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

			<button onclick="showEditEmployeeForm();"
				class="btn btn-default mybutton3">
				<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
				Edit
			</button>

			<a class="btn btn-default mybutton2" onclick="showNewEmployeeForm();">
				<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				Create
			</a>
		</div>

	</div>
</div>

<div class="row container-fluid">
	<div class="panel panel-default mypadding15">

		<form>
			<div class="row">

				<!-- to use this employeeId for editing employee -->
				<input id="employeeId" value="" hidden name="employeeId">

				<div class=" col-md-3 col-sm-3">
					<div class="form-group">
						<div id="profilePictureId">
							
						</div>
					</div>
				</div>

				<div class="col-md-9 col-sm-9">
					<h2 id="employeeName" class=" text-info"></h2>
					<!-- <label id="workType" class="control-label"></label> -->
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
					<%@include file="showEmployeeDetails_publicInfo_page.jsp"%>

				</div>
				<div id="personalInformation" class="tab-pane fade">

					<!-- load personal info form -->
					<%@include file="showEmployeeDetails_personalInfo_page.jsp"%>
					<%-- <jsp:include page="showEmployeeDetails_personalInfo_page.jsp"> --%>
				</div>
			</div>

			<div id="resultContainer" style="display: none;">
				<pre style="color: green;">
						<code></code>
					</pre>
			</div>
		</form>

	</div>
</div>