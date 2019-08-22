<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='css/dashboard.css'>
		<meta charset="ISO-8859-1">
		<title>Lookify!</title>
	</head>
	<body>
		<div id='container'>
			<div class='center-align'>
				<div class='button-container'>
					<form>
						<button formaction='/songs/new' type='submit'>Add New</button>
						<button formaction='/songs/topTen' type='submit'>Top Songs</button>
					</form>	
					<form id='search-form' name='search-form' method='post'>
						<input type='text' name='search-string' id='search-string' >
						<button onclick="searchClick();" type='submit'>Search Artists</button>
					</form>		
	
				</div>
				<br/>
				<div>
					<table>
						<thead>
							<tr>
								<th>Title</th>
								<th>Rating</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items='${songs}' var='s'>
								<tr>
									<td><a href='/songs/${s.getId()}'>${s.getTitle()}</a></td>
									<td><a>${s.getRating()}</a></td>
									<td><form method='post'><input type="hidden" name="_method" value="delete"><button formaction='/songs/${s.getId()}'>Delete</button></form></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script>
			function searchClick() { document.getElementById("search-form").action = "/search/" + document.getElementById("search-string").value; }
		</script>
	</body>
</html>