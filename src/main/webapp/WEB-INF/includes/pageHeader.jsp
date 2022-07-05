<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div id="page_header" class="col-12">
		<div class="row">
			<div class="col-12 text-center">
				<a href="/" id="page_header__page_title">School Manager</a>
			</div>
		</div>
		
		<div id="page_header__message" class="row">
			<div class="col-12 text-center">
				<div id="page_header__message">
					<c:out value="${message}"/>
				</div>
			</div>
		</div>
	</div>
</div>