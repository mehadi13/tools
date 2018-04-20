<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="utf-8">
<title>Employees</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/main.css">
</head>
<body>
	<nav class="navbar navbar-dark bg-dark"> <a class="navbar-brand"
		href="#">Employee</a> </nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2">
				<img src="/img/logo.png" alt="Logo"> <a href="/">Employees</a>
			</div>
			<div class="col-md-10" id="right-container">
				<h3>Employees</h3>
				<div class="row">
					<div class="col-md-11">
						<button id="create" type="button" class="btn btn-sm btn-purple">Create</button>
					</div>
					<div class="col-md-1">
						<ul class="pagination">
							<li class="page-item">
							<a id="prePage" class="page-link"> 
							<span aria-hidden="true">&laquo;</span>
									<span class="sr-only">Previous</span>
							</a></li>
							<li class="page-item">
							<a id="nextPage" class="page-link">
							<span aria-hidden="true">&raquo;</span> <span
									class="sr-only">Next</span>
							</a></li>
						</ul>
					</div>
				</div>


				<hr>
				<table id="employee-table"
					class="border-top table table-striped table-hover" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th></th>
							<th>Name</th>
							<th>Work Phone</th>
							<th>Work Email</th>
							<th>Department</th>
							<th>Job Title</th>
							<th>Manager</th>
						</tr>
					</thead>
					<tbody id="tableBody">
					</tbody>
				</table>
			</div>
		</div>
	</div>


	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/main.js"></script>

</body>
</html>