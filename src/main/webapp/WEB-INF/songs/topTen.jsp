<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Top Ten Songs</title>
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
				<c:forEach items='${songs}' var='s'>
					<tr>
						<td>${s.getTitle()}</td>
						<td>${s.getArtist()}</td>
						<td>${s.getRating()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>