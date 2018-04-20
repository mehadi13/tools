function initializeFormWithEmployeeAndMasterData(employeeId) {
	$
			.ajax({
				type : 'post',
				url : '/employees/employeedetails/' + employeeId,
				dataType : 'json',

				success : function(responsedEmployee) {

					// breadcrumb value set
					$("#navigationId").append(responsedEmployee.employeeName);

					// set id for edit click for diffrent employee
					document.getElementById("employeeId").value = responsedEmployee.id;

					//profile picture
//					if(responsedEmployee.profilePicture != null){
//						var photo = '<img class="mywidth_mx100 img-responsive"'
//							+'src="../employee-photo/'+responsedEmployee.profilePicture+'">';
//						$("#profilePictureId").append(photo);
//					}
					
					if(responsedEmployee.profilePicture != null){
						var photo = '<img id="mockPhoto" class="mywidth_mx100 img-responsive"'
							+'src="../employee-photo/'+responsedEmployee.profilePicture+'">';
						$("#profilePictureId").append(photo);
					}else{
						var photo = '<img id="mockPhoto" class="mywidth_mx100 img-responsive"'
							+'src="../img/nophoto.jpg">';
						$("#profilePictureId").append(photo);
					}
					
					// details value set
					document.getElementById("employeeName").value = responsedEmployee.employeeName;
					document.getElementById("workMoble").value = responsedEmployee.workMobile;
					document.getElementById("workLocaion").value = responsedEmployee.workLocation;
					document.getElementById("workEmail").value = responsedEmployee.workEmail;
					document.getElementById("workPhone").value = responsedEmployee.workPhone;
					document.getElementById("otherInformation").value = responsedEmployee.otherInformation;
					document.getElementById("identificationNo").value = responsedEmployee.identificationNo;
					document.getElementById("passportNo").value = responsedEmployee.passportNo;
					document.getElementById("bankAccountNumber").value = responsedEmployee.bankAccountNumber;
					document.getElementById("homeAddress").value = responsedEmployee.homeAddress;

					var birthDate = new Date(responsedEmployee.dateOfBirth);
					document.getElementById("dateOfBirth").valueAsDate = birthDate;

					// dropdowns
					loadCompanies(responsedEmployee.workingAddress);
					loadDepartments(responsedEmployee.department);
					loadJobTitles(responsedEmployee.jobTitle);
					loadManagersAndCoaches(responsedEmployee.manager,
							responsedEmployee.coach);// employees
					loadCountries(responsedEmployee.nationality);// nationality
					// as country

					// all other master data not from database
					loadWorkType(responsedEmployee.workType);
					loadGender(responsedEmployee.gender);
					loadMaritalStatus(responsedEmployee.maritalStatus);
				}
			});
}

function loadCompanies(workingAddress) {
	$.ajax({
		type : 'Get',
		url : '/allcompanies',
		dataType : 'json',
		async : true,

		success : function(responsedCompanies) {

			var output = '<option value="' + workingAddress + '">'
					+ workingAddress + '</option>';

			for (var i = 0; i < responsedCompanies.length; i++) {

				if (responsedCompanies[i].companyName != workingAddress) {

					output += '<option value="'
							+ responsedCompanies[i].companyName + '">' + ''
							+ responsedCompanies[i].companyName + '</option>';
				}
			}

			$("#workingAddress").append(output);
			// document.getElementById("workingAddress").innerHTML = output;
		}
	});
}

function loadDepartments(department) {
	$.ajax({
		type : 'Get',
		url : '/alldepartments',
		dataType : 'json',
		async : true,

		success : function(responsedDepartments) {

			var output = '<option value="' + department + '">' + department
					+ '</option>';

			for (var i = 0; i < responsedDepartments.length; i++) {

				if (responsedDepartments[i].departmentName != department) {

					output += '<option value="'
							+ responsedDepartments[i].departmentName + '">'
							+ '' + responsedDepartments[i].departmentName
							+ '</option>';
				}
			}

			$("#department").append(output);
		}
	});
}

function loadJobTitles(jobTitle) {
	$.ajax({
		type : 'Get',
		url : '/alljobtitles',
		dataType : 'json',
		async : true,

		success : function(responsedJobTitles) {

			var output = '<option value="' + jobTitle + '">' + jobTitle
					+ '</option>';

			for (var i = 0; i < responsedJobTitles.length; i++) {

				if (responsedJobTitles[i].jobTitleName != jobTitle) {

					output += '<option value="'
							+ responsedJobTitles[i].jobTitleName + '">' + ''
							+ responsedJobTitles[i].jobTitleName + '</option>';
				}
			}
			$("#jobTitle").append(output);
		}
	});
}

function loadManagersAndCoaches(manager, coach) {
	$
			.ajax({
				type : 'Get',
				url : '/allemployeenames',
				dataType : 'json',
				async : true, // allows to executes next statements at same
				// time

				success : function(responsedEmployees) {

					// managers
					var output = '<option value="' + manager + '">' + manager
							+ '</option>';

					for (var i = 0; i < responsedEmployees.length; i++) {

						if (responsedEmployees[i] != manager) {

							output += '<option value="' + responsedEmployees[i]
									+ '">' + '' + responsedEmployees[i]
									+ '</option>';
						}
					}
					$("#manager").append(output);

					// coaches
					var output = '<option value="' + coach + '">' + coach
							+ '</option>';

					for (var i = 0; i < responsedEmployees.length; i++) {

						if (responsedEmployees[i] != coach) {

							output += '<option value="' + responsedEmployees[i]
									+ '">' + '' + responsedEmployees[i]
									+ '</option>';
						}
					}
					$("#coach").append(output);
				}
			});
}

function loadCountries(country) {
	$.ajax({
		type : 'Get',
		url : '/allcountries',
		dataType : 'json',
		async : true,

		success : function(responsedCountries) {

			var output = '<option value="' + country + '">' + country
					+ '</option>';

			for (var i = 0; i < responsedCountries.length; i++) {

				if (responsedCountries[i].countryName != country) {

					output += '<option value="'
							+ responsedCountries[i].countryName + '">'
							+ responsedCountries[i].countryName + '</option>';
				}
			}
			$("#nationality").append(output);
			// document.getElementById("nationality").innerHTML =
			// output;
		}
	});
}

function loadWorkType(workType){
	var output = '<option value="' + workType + '">' + workType + '</option>';
	var workTypes = ['Part Time', 'Full Time'];
	
	for (var i = 0; i < 2; i++) {
		if (workTypes[i] != workType) {
			output += '<option value="' + workTypes[i]
					+ '">' + workTypes[i] + '</option>';
		}
	}
	$("#workType").append(output);
}
function loadGender(gender){
	var output = '<option value="' + gender + '">' + gender + '</option>';
	var genders = ['Male', 'Female'];
	
	for (var i = 0; i < 2; i++) {
		if (genders[i] != gender) {
			output += '<option value="' + genders[i]
					+ '">' + genders[i] + '</option>';
		}
	}
	$("#gender").append(output);
}
function loadMaritalStatus(maritalStatus){
	var output = '<option value="' + maritalStatus + '">' + maritalStatus + '</option>';
	var maritalStatuses = ['Single', 'Married','Un-married', 'Complicated'];
	
	for (var i = 0; i < 2; i++) {
		if (maritalStatuses[i] != maritalStatus) {
			output += '<option value="' + maritalStatuses[i]
					+ '">' + maritalStatuses[i] + '</option>';
		}
	}
	$("#maritalStatus").append(output);
}

