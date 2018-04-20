	<div class="container">

		<br />
		<div class='row'>
			<input id="store" type="submit" class="btn btn-sm btn-purple"
			value="Submit"> &nbsp
			<!-- <button id="discard" type="button" class="btn btn-sm btn-purple">Discard</button> -->

		</div>
		<div class='row'>
			<div class="form-group">
			<input id="id" type="hidden">
			<div>
				<label for="name" required maxlength=20 >Name</label> <input type="text"
				class="form-control" id="name"  placeholder="Enter Name">
				<label id="nameError" class="errorText"></label>
				</div>
				<label for="jobtype">Job Type</label> <select id="jobtype"></select>
			</div>
		</div>



		<div class='row'>
			<div class='col-md-6'>
				<h3>Contact Information</h3>
				<table>
					<tr>
						<td>Working Address</td>
						<td><input id="workAddress" type="text"><label id="workAddressError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Working Mobile</td>
						<td><input id="workMobile" type="text"><label id="workMobileError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Working Location</td>
						<td><input id="workLocation" type="text"><label id="workLocationError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Working Email</td>
						<td><input id="workEmail" type="text"><label id="workEmailError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Working Phone</td>
						<td><input id="workPhone" type="text"><label id="workPhoneError" class="errorText"></label></td>
					</tr>
				</table>

			</div>
			<div class='col-md-6'>
				<h3>Position</h3>
				<table>
					<tr>
						<td>Department</td>
						<td><select id="department"></select></td>
					</tr>
					<tr>
						<td>Job Title</td>
						<td><select id="jobtitle"></select></td>
					</tr>
					<tr>
						<td>Manager</td>
						<td><select id="manager"></select></td>
					</tr>
					<tr>
						<td>Coach</td>
						<td><select id="coach"></select></td>
					</tr>
				</table>
			</div>
		</div>



		<div class='row'>
			<div class='col-md-6'>
				<h3>Citizenship and Other Information</h3>
				<table>
					<tr>
						<td>Nationality (Country)</td>
						<td><select id="nationality"></select></td>
					</tr>
					<tr>
						<td>Identification No</td>
						<td><input id="identificationNo" type="text"><label id="identificationNoError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Passport No</td>
						<td><input id="passportNo" type="text"><label id="passportNoError" class="errorText"></label></td>
					</tr>
					<tr>
						<td>Bank Account No</td>
						<td><input id="bankAccount" type="text"><label id="bankAccountError" class="errorText"></label></td>
					</tr>
				</table>

			</div>
			<div class='col-md-6'>
				<h3>Contact Information</h3>
				<table>
					<tr>
						<td>Home Address</td>
						<td><input id="homeAddress" type="text"><label id="homeAddressError" class="errorText"></label></td>
					</tr>
				</table>
			</div>
		</div>

		<div class='row'>
			<div class='col-md-6'>
				<h3>Status</h3>
				<table>
					<tr>
						<td>Gender</td>
						<td><select id="gender"></select></td>
					</tr>
					<tr>
						<td>Marital Status</td>
						<td><select id="maritalstatus"></select></td>
					</tr>
				</table>

			</div>
			<div class='col-md-6'>
				<h3>Birth</h3>
				<table>
					<tr>
						<td>Date Of Birth</td>
						<td><input id="dateOfBirth" type="date"></td>
					</tr>
				</table>
			</div>
		</div>
		<br />
	</div>
	<script src="/js/main.js"></script>