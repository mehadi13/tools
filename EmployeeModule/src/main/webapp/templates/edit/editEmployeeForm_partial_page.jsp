<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row container-fluid">
	<ul class="breadcrumb">
		<li><a onclick="showEmployees();" class="btn">Employees</a></li>
		<li id="navigationId" class="active"></li>
	</ul>
</div>

<div class="row container-fluid">
	<div>
		<div class="pull-left mymargin-bottom10">
			<button onclick="updateEmployee();" class="btn btn-default mybutton3">Save</button>
			<!-- <button id="submitButton" class="btn btn-default mybutton3">Save</button>-->
			<button class="btn btn-default mybutton2"
				onclick="goBackToEmployeeDetails();">Discard</button>
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

			<div class="form-group">
				<!-- to use this employeeId for editing employee -->
				<input id="employeeId" value="" hidden name="id">
			</div>

			<div class="row">
				<div class=" col-md-4 col-sm-4">
					<div class="form-group">
						<div class="col-sm-8 panel">
							<!-- <img id="mockPhoto" src="../img/camera.png"
								class="img-responsive mywidth_mx100">  -->
							<div id="profilePictureId"></div>
							
							<input type="file" class="form-control" name="profilePhoto"
								id="profilePhoto" onchange="displayPictureOnBrowse(this);">
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
							type="text" value="" class="form-control" name="employeeName"
							placeholder="Employee's Name" required id="employeeName">
					</div>
				</div>

				<div class="col-md-4 col-sm-4">

					<div class="form-group">
						<label for="workType" class="control-label">Work Type</label> <select
							class="form-control" name="workType" id="workType">

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
					<%@include file="editEmployeeForm_publicInfo_page.jsp"%>

				</div>
				<div id="personalInformation" class="tab-pane fade">

					<!-- load personal info form -->
					<%@include file="editEmployeeForm_personalInfo_page.jsp"%>
					<%-- <jsp:include page="editEmployeeForm_personalInfo_page.jsp"> --%>
				</div>
			</div>

		</form>

	</div>
</div>