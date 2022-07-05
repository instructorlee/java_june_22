<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="includes/head.jsp" />

<body>
	<div id="content" class="container-fluid">
		<jsp:include page="includes/pageHeader.jsp" />
		
		<div id="active_area" class="row justify-content-center">
			<div class="col-7">
				<h1>Welcome to the District Schools Manager</h1>
				
				<p>
					Use this tool to manage each school's students and teachers.
				</p>
			</div>
			<div class="col-7">
				<a href="/school">Continue</a>
			</div>
		</div>
	</div>
</body>