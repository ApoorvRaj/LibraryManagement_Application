<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Library</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Library Management</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/">All Books</a></li>
				<li><a href="/add">New Book</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<c:choose>

			<c:when test="${mode == 'BOOK_VIEW'}">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Book Name</th>
							<th>Author</th>
							<th>Purchased Date</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:set var="count" value="0" />
						<c:forEach items="${books}" var="book">
							<tr>
								<c:set var="count" value="${count + 1}" scope="page" />

								<td>${count}</td>
								<td>${book.bookName}</td>
								<td>${book.author}</td>
								<td>${book.purchaseDate}</td>
								<td><a href="update?id=${book.id}"><div
											class="glyphicon glyphicon-pencil"></div></a></td>&nbsp;&nbsp;
								<td><a href="delete?id=${book.id}"><div
											class="glyphicon glyphicon-trash"></div></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>

			<c:when test="${mode == 'BOOK_EDIT'}">
				<form action="save" method="post">
					<input type="hidden" value="${book.id}" name="id" id="id">
					<div class="form-group">
						<label for="email">BookName:</label> <input type="text"
							class="form-control" id="bookName" value="${book.bookName}"
							name="bookName">
					</div>
					<div class="form-group">
						<label for="pwd">Author:</label> <input type="text"
							class="form-control" id="author" value="${book.author}"
							name="author">
					</div>
					<div class="form-group">
						<label for="pwd">Purchase Date:</label> <input type="date"
							class="form-control" id="date" value="${book.purchaseDate}"
							name="purchaseDate">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>
			<c:when test="${mode == 'BOOK_ADD'}">
				<form action="save" method="post">
					<div class="form-group">
						<label for="email">BookName:</label> <input type="text"
							class="form-control" id="bookName" required name="bookName">
					</div>
					<div class="form-group">
						<label for="pwd">Author:</label> <input type="text"
							class="form-control" id="author" required name="author">
					</div>
					<div class="form-group">
						<label for="pwd">Purchase Date:</label> <input type="date"
							class="form-control" id="date" required name="purchaseDate">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</c:when>
		</c:choose>


	</div>

</body>
</html>