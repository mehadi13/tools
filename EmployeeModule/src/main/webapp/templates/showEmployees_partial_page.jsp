<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row container-fluid">
	<ul class="breadcrumb">
		<li class="active">Employees</li>
	</ul>
</div>

<div class="row container-fluid">
	<div>
		<a class="btn btn-default mybutton3 pull-left mymargin-bottom10"
			onclick="showNewEmployeeForm();"> <span
			class="glyphicon glyphicon-plus" aria-hidden="true"></span> Create
		</a>
		<div class="pull-right">
			<a id="pageId"></a>
			<Button onclick="gotoPreviousPage();" class="d-inline" href="#">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</Button>
			<Button onclick="gotoNextPage();" class="d-inline">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</Button>
		</div>
	</div>
</div>

<div class="row container-fluid">
	<div class="table-responsive">
		<table class="table table-bordered table-striped text-center">
			<thead>
				<tr class="mybackground3 mycolor3">
					<th class="text-center">Serial</th>
					<th class="text-center">Name</th>
					<th class="text-center">Work Phone</th>
					<th class="text-center">Work Email</th>
					<th class="text-center">Department</th>
					<th class="text-center">Job Title</th>
					<th class="text-center">Manager</th>
				</tr>
			</thead>
			<tbody id="tbodyId">
				<%-- <c:forEach items="${employees}" var="employee">
					<tr>
						<td><a
							href='/SpringAss/delete?id=<c:out value="${user.id}"/>'>${employee.employeeName}</a></td>
						<td>${employee.workPhone}</td>
						<td>${employee.workEmail}</td>
						<td>${employee.department}</td>
						<td>${employee.jobTitle}</td>
						<td>${employee.manager}</td>
					</tr>
				</c:forEach> --%>
			</tbody>
		</table>
	</div>
</div>