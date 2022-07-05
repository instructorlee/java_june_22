<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="includes/head.jsp" />

<body>
	<div class="container-fluid">
	
		<jsp:include page="includes/pageHeader.jsp" />
			
		<div class="row justify-content-center">
			<div id="active_area" class="col-7">
				<div>name: <c:out value="${school.name}"/></div>
			</div>
			<div class="col-7">
				<a href="/school" class="btn btn-success">Back to List</a>
				<a href="/school/update/${school.id}" class="btn btn-warning">Update School</a>
				<a href="/school/delete/${school.id}" class="btn btn-danger">Delete School</a>
			</div>
		</div>
	</div>
</body>
</head>