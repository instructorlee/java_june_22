<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/includes/head.jsp" />

<body>
	<div class="container-fluid">
	
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
		
		<div class="row justify-content-center">
			<div class="col-7">
				
				<form:form method="POST" action="/student/update" modelAttribute="student">
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
						<a href="/student" class="btn btn-danger mt-2 col-7 col-md-7">Cancel</a> 
					</div>
				</form:form>
			</div>
	</div>
</body>
</head>