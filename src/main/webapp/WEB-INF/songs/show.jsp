<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel='stylesheet' type='text/css' href='css/search.css'>
		<title>${song.getTitle()}</title>
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
				<tr>
					<td>${song.getTitle()}</td>
					<td>${song.getArtist()}</td>
					<td>${song.getRating()}</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>