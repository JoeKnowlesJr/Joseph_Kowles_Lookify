<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${action} Song</title>
	</head>
	<body>
		<h1>${action} Song</h1>
		<c:choose>
			<c:when  test="${action == 'New'}">
				<c:set var='path' value='/songs/add'></c:set>
			</c:when>
			<c:when  test="${action == 'Edit'}">
				<c:set var='path' value='/songs/${song.id}'></c:set>
			</c:when>
		</c:choose>
		<form:form action="${path}" method="post" modelAttribute="song">
		    <input type="hidden" name="_method" value="put">
		    <p>
		        <form:label path="title">Title</form:label>
		        <form:errors path="title"/>
		        <form:input path="title"/>
		    </p>
		    <p>
		        <form:label path="artist">Artist</form:label>
		        <form:errors path="artist"/>
		        <form:textarea path="artist"/>
		    </p>
		    <p>
		        <form:label path="rating">Rating</form:label>
		        <form:errors path="rating"/>
		        <form:input path="rating"/>
		    </p>
		    <input type="submit" value="Submit"/>
		</form:form>	
	</body>
</html>