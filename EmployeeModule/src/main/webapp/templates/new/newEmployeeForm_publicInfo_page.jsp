
<div class="row">
	<div class="col-md-6 col-sm-6">
		<h3>Contact Informaton</h3>

		<div class="form-group row">
			<label for="workingAddress" class="col-sm-4 control-label">Working
				Address</label>

			<div class="col-sm-8">
				<select class="form-control" name="workingAddress"
					id="workingAddress" required>
					<%-- 
								<option value="" disabled selected hidden>Select
									Company</option>
								<c:forEach items="${companies}" var="company">
									<option value="${company.companyName}">${company.companyName}</option>
								</c:forEach> --%>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="workMobile" class="col-sm-4 control-label">Work
				Mobile</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="workMobile" required>
			</div>
		</div>

		<div class="form-group row">
			<label for="workLocation" class="col-sm-4 control-label">Work
				Location</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="workLocation" required>
			</div>
		</div>

		<div class="form-group row">
			<label for="workEmail" class="col-sm-4 control-label">Work
				Email</label>
			<div class="col-sm-8">
				<input type="email" class="form-control" name="workEmail" required>
			</div>
		</div>

		<div class="form-group row">
			<label for="workPhone" class="col-sm-4 control-label">Work
				Phone</label>
			<div class="col-sm-8">
				<input type="text" class="form-control" name="workPhone">
			</div>
		</div>
	</div>
	<!-- end of contact information col -->


	<div class="col-md-6 col-sm-6">
		<h3>Position</h3>

		<div class="form-group row">
			<label for="department" class="col-sm-4 control-label">Department</label>
			<div class="col-sm-8">
				<select class="form-control" name="department" id="department"
					required>
					<option disabled selected hidden></option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="jobTitle" class="col-sm-4 control-label">Job
				title</label>
			<div class="col-sm-8">
				<select class="form-control" name="jobTitle" id="jobTitle" required>
					<option value="" disabled selected hidden></option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="manager" class="col-sm-4 control-label">Manager</label>
			<div class="col-sm-8">
				<select class="form-control" name="manager" id="manager">
					<option value="" disabled selected hidden></option>
				</select>
			</div>
		</div>

		<div class="form-group row">
			<label for="coach" class="col-sm-4 control-label">Coach</label>
			<div class="col-sm-8">
				<select class="form-control" name="coach" id="coach">
					<option value="" disabled selected hidden></option>
				</select>
			</div>
		</div>

	</div>
</div>
<!-- end of row -->

<div class="form-group row">
	<div class="col-sm-8 mywidth_full">
		<textarea type="text" class="form-control" name="otherInformation"
			placeholder="Other Information.." ></textarea>
	</div>
</div>

