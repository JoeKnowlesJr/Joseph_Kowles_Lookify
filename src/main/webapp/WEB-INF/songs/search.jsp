<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel='stylesheet' type='text/css' href='css/search.css'>
		<title>Search (${search-string})</title>
	</head>
	<body>
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test='${results.size() == 0}'>
						<div class='warning'></div>
					</c:when>
					<c:otherwise>
						<c:forEach items='${results}' var='r'>
							<tr>
								<td>${r.getTitle()}</td>
								<td>${r.getArtist()}</td>
								<td>${r.getRating()}</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</body>
</html>