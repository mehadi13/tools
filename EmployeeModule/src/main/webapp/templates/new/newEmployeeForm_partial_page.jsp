<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row container-fluid">
	<ul class="breadcrumb">
		<li><a onclick="showEmployees();" class="btn">Employees</a></li>
		<li class="active">New Employee</li>
	</ul>
</div>

<div class="row container-fluid">
	<div>
		<div class="pull-left mymargin-bottom10">
			<button onclick="createEmployee();" class="btn btn-default mybutton3">Save</button>
			<!-- <button id="submitButton" class="btn btn-default mybutton3">Save</button>-->
			<button class="btn btn-default mybutton2" onclick="showEmployees();">Discard</button>
		</div>

	</div>
</div>
<div id="resultContainer" style="display: none;"
	class="row container-fluid">
	<pre style="color: green;">
		<code></code>
	</pre>
</div>
<div class="row container-fluid">
	<div class="panel panel-default mypadding15">

		<form name="employeeForm" id="formId" action="" method="">
			<!-- <form id="formId" class="form-horizontal" action="createemployee"
			method="post" name="employeeForm"> -->

			<div class="row">
				<div class=" col-md-4 col-sm-4">
					<div class="form-group">
						<div class="col-sm-8 panel">
							<img id="mockPhoto" src="../img/camera.png"
								class="img-responsive mywidth_mx100"> 
								<input type="file"
								class="form-control" name="profilePhoto" id="profilePhoto"
								onchange="displayPictureOnBrowse(this);">
						</div>
					</div>
					<!-- below part is just to have profilePicture name as field is in model, 
					 that's why hidden. upper profilePhoto is working for saving image-->
					<div class="form-group hide">
						<div class="col-sm-8 panel">
							<img id="empPicture" src="../img/camera.png"
								class="img-responsive mywidth_mx100"> <input type="file"
								class="form-control" name="profilePicture" id="profilePicture">
						</div>
					</div>
				</div>

				<div class="col-md-4 col-sm-4">
					<div class="form-group">
						<label for="employeeName" class="control-label">Name</label> <input
							type="text" class="form-control" name="employeeName"
							placeholder="Employee's Name" required>
					</div>
				</div>

				<div class="col-md-4 col-sm-4">

					<div class="form-group">
						<label for="workType" class="control-label">Work Type</label> <select
							class="form-control" name="workType" id="workType">
							<option value="Part Time">Part Time</option>
							<option value="Full Time">Full Time</option>
						</select>
					</div>

				</div>

			</div>
			<!-- end of row -->

			<ul class="nav nav-tabs">
				<li class="active"><a data-toggle="tab"
					href="#publicInformation">Public Information</a></li>
				<li><a data-toggle="tab" href="#personalInformation">Personal
						Information</a></li>
			</ul>

			<div class="tab-content">
				<div id="publicInformation" class="tab-pane fade in active">

					<!-- load public info form -->
					<%@include file="newEmployeeForm_publicInfo_page.jsp"%>

				</div>
				<div id="personalInformation" class="tab-pane fade">

					<!-- load personal info form -->
					<%@include file="newEmployeeForm_personalInfo_page.jsp"%>
					<%-- <jsp:include page="newEmployeeForm_personalInfo_page.jsp"> --%>
				</div>
			</div>
		</form>

	</div>
</div>