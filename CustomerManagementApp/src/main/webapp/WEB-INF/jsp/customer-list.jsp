<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<script>
	function editUser(id) {
		document.getElementById("editUserId").value = id;
		console.log(id);
	}
</script>
<body>
	<main>
		<table>
			<thead>
				<tr>
					<td>cid</td>
					<td>country</td>
					<td>cname</td>
					<td>Actions</td>
				</tr>
			</thead>
			<tbody>
				
				<c:forEach items="${list}" var="customer">
					<tr>
						<td><c:out value="${customer.id}"></c:out></td>
						<td><c:out value="${customer.country}"></c:out></td>
						<td><c:out value="${customer.name}"></c:out></td>
						<td><a href="#" data-toggle="modal"
							data-target="#editModal${customer.id}">Edit</a> <a
							href="deleteCustomer?id=${customer.id}">Delete</a></td>
					</tr>
					<!-- Modal for editing customer details -->
					<div class="modal fade" id="editModal${customer.id}" tabindex="-1"
						role="dialog" aria-labelledby="editModalLabel${customer.id}"
						aria-hidden="true">
						<div class="modal-dialog" role="document">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="editModalLabel${customer.id}">Edit
										Customer</h5>
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
										<span aria-hidden="true">&times;</span>
									</button>
								</div>
								<div class="modal-body">
									<form action="update" method="POST">
										<input type="text" name="id" value="${customer.id}" readonly>

										<!-- Display customer details for editing -->
										<label for="name">Name:</label> <input type="text" name="name"
											value="${customer.name}"> <label for="country">Country:</label>
										<input type="text" name="country" value="${customer.country}">

										<!-- Submit button to update the customer -->
										<button type="submit">Update</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
				
			</tbody>
		</table>

	</main>
</body>
</html>