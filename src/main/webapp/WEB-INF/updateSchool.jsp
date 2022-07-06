<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="includes/head.jsp" />

<body>
	<div class="container-fluid">
	
		<jsp:include page="includes/pageHeader.jsp" />
		
		<div class="row justify-content-center">
			<div class="col-7">
				
				<form:form method="POST" action="/school/update" modelAttribute="school">
					<div class="row justify-content-center">
						<form:input type="hidden" path="id"/>
						
						<div class="col-12 col-md-6">
							<form:label path="name">
									Name:
									<form:errors path="name"/>
									<form:input type="text" path="name" class="form-control"/>
							</form:label>
						</div>
					
						<button class="btn btn-success mt-2 col-7 col-md-7">Update</button>
					</div>
				</form:form>
			</div>
			
			<div class="col-7">
				<h2>Students</h2>
				<hr>
			</div>
			
			<div class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
						<th>Grade</th>
						<th></th>
					</thead>
					<c:forEach var="student" items="${school.students}">
						<tr>
							<td><c:out value="${student.name}"/></td>
							<td><c:out value="${student.grade}"/></td>
							<td>
								<a href="/school/remove-student/${school.id}/${student.id}">remove</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<hr>
				<h3>Add Student</h3>
				<form:form action="/school/add-student/${school.id}" method="POST">
					<select name="student_id" class="form-control">
						<c:forEach var="student" items="${students}">
							<option value="${student.id}">
								<c:out value="${student.name} (${student.grade})"/>
							</option>
						</c:forEach>
					</select>
					<button class="btn btn-info">Add Student</button>
				</form:form>
			</div>
			
			</div class="col-7">
				<div id="buttons">
					<a href="/school" class="btn btn-danger">Cancel</a> 
				</div>
			</div>
	</div>
</body>
</head>