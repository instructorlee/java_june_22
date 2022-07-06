package com.example.SchoolOrganizer.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.SchoolOrganizer.models.School;
import com.example.SchoolOrganizer.models.Student;
import com.example.SchoolOrganizer.services.SchoolService;
import com.example.SchoolOrganizer.services.StudentService;

@Controller
@RequestMapping("school")
public class SchoolController {

	@Autowired
	private SchoolService service; // using generic variable names for better reusability
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("")
	public String home( Model model) {
		
		List<School> schools = this.service.all();
		
		model.addAttribute("schools", schools); // add a breakpoint to this line to look into schools
		
		return "schools.jsp";
	}
	
	@GetMapping("/add")
    public String getAddForm(@ModelAttribute("school") School schoool) {
		
        return "addSchool.jsp";
    }
	
	@PostMapping("/add")
	public String add(
			@Valid @ModelAttribute("School") School School,
			BindingResult result,
			RedirectAttributes redirectAttributes,
			HttpSession session
			) {
		
		// check for form errors
		if ( result.hasErrors() ) return "addSchool.jsp";
		
		this.service.create(School);
		
		redirectAttributes.addFlashAttribute("message", "School has been added");
		
		return "redirect:/school";
	}
	
	@GetMapping("/{id}")
	public String viewItem (
			HttpSession session,
			@PathVariable Long id,
			Model model
			) {
		
		model.addAttribute("school", this.service.retrieve(id));
		
		return "viewSchool.jsp";
	}

	
	@GetMapping("/delete/{id}")
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes
			) {
		
		this.service.delete(id);
		
		redirectAttributes.addFlashAttribute("message", "School has been deleted");
		
		return "redirect:/school";
	}
	
	@GetMapping("/update/{id}")
    public String getUpdateForm(Model model, @PathVariable Long id) {
			
			model.addAttribute("school", this.service.retrieve(id));
			model.addAttribute("students", this.studentService.all());
			
            return "updateSchool.jsp";
    }

	@PostMapping("/update")
	public String update(
			@Valid @ModelAttribute("school") School school,
			BindingResult result,
			RedirectAttributes redirectAttributes) {
		
		if ( result.hasErrors() ) return "addSchool.jsp";
		
		this.service.update(school);
		
		redirectAttributes.addFlashAttribute("message", "School has been updated");
		
		return "redirect:/school";
	}
	
	@PostMapping("/add-student/{schoolId}")
	public String addStudent(
			@PathVariable Long schoolId,
			@RequestParam(value="student_id") Long studentId,
			RedirectAttributes redirectAttributes) {
		
		if ( this.studentService.setSchool(schoolId, studentId) ) {
			redirectAttributes.addFlashAttribute("message", "Student has been added");
			
		} else {

			redirectAttributes.addFlashAttribute("message", "Unable to add student");
		}
		
		return String.format("redirect:/school/update/%d", schoolId); // add the ID of the school being updated
				
	}
	
	@GetMapping("/remove-student/{schoolId}/{studentId}")
	public String removeStudent(
			@PathVariable Long schoolId,
			@PathVariable Long studentId,
			RedirectAttributes redirectAttributes
			) {
		
		if ( this.studentService.unsetSchool(schoolId, studentId) ) {
			
			redirectAttributes.addFlashAttribute("message", "Student has been removed");
			
		} else {

			redirectAttributes.addFlashAttribute("message", "Unable to remove student");
			
		}
		
		return String.format("redirect:/school/update/%d", schoolId); // add the ID of the school being updated
	}
}
