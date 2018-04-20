function initializeFormWithMasterData() {
	loadAndSetCompanies();
	loadAndSetDepartments();
	loadAndSetJobTitles();
	loadAndSetManagersAndCoaches();// employees
	loadAndSetCountries();// nationality as country
}

function loadAndSetCompanies() {
	$.ajax({
		type : 'Get',
		url : '/allcompanies',
		dataType : 'json',
		async : true,
		
		success : function(responsedCompanies) {

			var output = '<option value="" disabled selected hidden>'
					+ 'Select Company</option>';

			for (var i = 0; i < responsedCompanies.length; i++) {
				output += '<option value="' + responsedCompanies[i].companyName
						+ '">' + '' + responsedCompanies[i].companyName
						+ '</option>';
			}

			$("#workingAddress").append(output);
			// document.getElementById("workingAddress").innerHTML = output;
		}
	});
}

function loadAndSetDepartments() {
	$.ajax({
		type : 'Get',
		url : '/alldepartments',
		dataType : 'json',
		async : true,
		
		success : function(responsedDepartments) {

			var output = '';

			for (var i = 0; i < responsedDepartments.length; i++) {
				output += '<option value="'
						+ responsedDepartments[i].departmentName + '">' + ''
						+ responsedDepartments[i].departmentName + '</option>';
			}

			$("#department").append(output);
		}
	});
}

function loadAndSetJobTitles() {
	$.ajax({
		type : 'Get',
		url : '/alljobtitles',
		dataType : 'json',
		async : true,
		
		success : function(responsedJobTitles) {

			var output = '';

			for (var i = 0; i < responsedJobTitles.length; i++) {
				output += '<option value="'
						+ responsedJobTitles[i].jobTitleName + '">' + ''
						+ responsedJobTitles[i].jobTitleName + '</option>';
			}

			$("#jobTitle").append(output);
		}
	});
}

function loadAndSetManagersAndCoaches() {
	$.ajax({
		type : 'Get',
		url : '/allemployeenames',
		dataType : 'json',
		async : true, //allows to executes next statements at same time

		success : function(responsedEmployees) {

			var output = '';

			for (var i = 0; i < responsedEmployees.length; i++) {
				output += '<option value="' + responsedEmployees[i] + '">' + ''
						+ responsedEmployees[i] + '</option>';
			}
			$("#manager").append(output);
			$("#coach").append(output);
		}
	});
}

function loadAndSetCountries() {
	$.ajax({
		type : 'Get',
		url : '/allcountries',
		dataType : 'json',
		async : true,

		success : function(responsedCountries) {

			var output = '<option value="" disabled selected hidden>'
					+ 'Select Country</option>';

			for (var i = 0; i < responsedCountries.length; i++) {
				output += '<option value="' + responsedCountries[i].countryName
						+ '">' + responsedCountries[i].countryName
						+ '</option>';
			}

			$("#nationality").append(output);
			// document.getElementById("nationality").innerHTML =
			// output;
		}
	});
}