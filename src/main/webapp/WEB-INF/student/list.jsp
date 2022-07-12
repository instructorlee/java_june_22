<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/includes/head.jsp" />

<body>
	<div class="container-fluid">
		<jsp:include page="/WEB-INF/includes/pageHeader.jsp" />
		
		<div class="row justify-content-center mt-3">
			<div id="active_area" class="col-7">
				<table class="table">
					<thead>
						<th>Name</th>
					</thead>
					<c:forEach var="student" items="${students}">
						<tr>
							<td>
								<a href="/student/${student.id}">
									<c:out value="${student.name}"/>
								</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<div class="col-7">
				<a href="/student/add" class="btn btn-success">Add student</a>
			</div>
		</div>
	</div>
</body>
</head>