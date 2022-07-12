<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/includes/head.jsp" />

<body>
	<div class="container-fluid">
	
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
			
		<div class="row justify-content-center">
			<div id="active_area" class="col-7">
				<div>name: <c:out value="${student.name}"/></div>
			</div>
			
			<div class="col-7">
				<h2>Teachers</h2>
				<hr>
			</div>
			
			<div class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
						<th></th>
					</thead>
					<c:forEach var="teacherStudent" items="${student.teacherStudent}">
						<tr>
							<td><c:out value="${teacherStudent.teacher.name}"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			
			<div class="col-7">
				<a href="/student" class="btn btn-success">Back to List</a>
				<a href="/student/update/${student.id}" class="btn btn-warning">Update student</a>
				<a href="/student/delete/${student.id}" class="btn btn-danger">Delete student</a>
			</div>
		</div>
	</div>
</body>
</head>