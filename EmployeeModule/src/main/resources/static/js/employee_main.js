$(document).ready(function() {
	showEmployees();
});

var pageNo = 0;// default page number
var pageSize = 5;

function showEmployees() {

	pageNo = 0;// might change for pagination, so reset

	$("#dynamic_content").remove();

	jQuery.ajaxSetup({
		async : false
	});// first load page then load and set employees

	$.get({
		url : '/employeelist-page',
		success : function(responsedData) {
			output = '<div id="dynamic_content">';
			output += responsedData;
			output += '</div>';
			$("#container").append(output);
		}
	})

	loadEmployees();
}

function loadEmployees() {

	$
			.ajax({
				type : 'post',
				url : '/allemployees/' + pageNo,
				dataType : 'json',

				success : function(responsedEmployees) {

					if (responsedEmployees.length != 0) {

						$("#tbodyId tr").empty();

						var output = '';
						var serialCounter = pageNo * pageSize;

						document.getElementById("pageId").innerHTML = (serialCounter + 1)
								+ '-'
								+ (serialCounter + pageSize)
								+ ' / '
								+ responsedEmployees.length;

						for (var i = 0; i < responsedEmployees.length; i++) {

							var workPhone = '';
							if (responsedEmployees[i].workPhone == '') {
								workPhone = 'Not provided';
							} else {
								workPhone = responsedEmployees[i].workPhone;
							}

							var manager = '';
							if (responsedEmployees[i].manager == null) {
								manager = 'Not assigned yet';
							} else {
								manager = responsedEmployees[i].manager;
							}

							output += '<tr>' + '<td>'
									+ (++serialCounter)
									+ '</td><td><a onclick=showEmployeeDetails('
									+ responsedEmployees[i].id + ');>'
									+ responsedEmployees[i].employeeName
									+ '</a></td>' + '<td>' + workPhone
									+ '</td>' + '<td>'
									+ responsedEmployees[i].workEmail + '</td>'
									+ '<td>' + responsedEmployees[i].department
									+ '</td>' + '<td>'
									+ responsedEmployees[i].jobTitle + '</td>'
									+ '<td>' + manager + '</td>' + '</tr>';
						}

						$("#tbodyId").append(output);
					} else {
						pageNo -= 1;
					}
				}
			});
}

function gotoNextPage() {
	pageNo += 1;
	loadEmployees(pageNo);
}

function gotoPreviousPage() {
	if (pageNo == 0) {
		// do nothing
	} else {
		pageNo -= 1;
		loadEmployees(pageNo);
	}
}

function showEmployeeDetails(employeeId) {

	$("#dynamic_content").remove();

	jQuery.ajaxSetup({
		async : false
	});// first load page then load and set employees

	$.get({
		url : '/employeedetals-page',
		success : function(responsedData) {
			output = '<div id="dynamic_content">';
			output += responsedData;
			output += '</div>';
			$("#container").append(output);

			// set employeeId to the employee details page edit button
			// $(#"")
		}
	})

	loadEmployeeDetails(employeeId);
}
// clicking on discard will redirect to details
function goBackToEmployeeDetails() {
	showEmployeeDetails(document.getElementById("employeeId").value);
}
function loadEmployeeDetails(employeeId) {

	$
			.ajax({
				type : 'post',
				url : '/employees/employeedetails/' + employeeId,
				dataType : 'json',

				success : function(responsedEmployee) {

					if (responsedEmployee.length != 0) {

						// breadcrumb value set
						$("#navigationId").append(
								responsedEmployee.employeeName);
						// set id for edit click for diffrent employee
						document.getElementById("employeeId").value = responsedEmployee.id;

						// details value set
						$("#employeeName").append(
								responsedEmployee.employeeName);

						if (responsedEmployee.profilePicture != null) {
							var photo = '<img class="mywidth_mx100 img-responsive"'
									+ 'src="../employee-photo/'
									+ responsedEmployee.profilePicture + '">';
							$("#profilePictureId").append(photo);
						} else {
							var photo = '<img class="mywidth_mx100 img-responsive"'
									+ 'src="../img/nophoto.jpg">';
							$("#profilePictureId").append(photo);
						}

						/*if (responsedEmployee.workType != null) {
							$("#workType").append(responsedEmployee.workType);
						}*/

						$("#workingAddress").append(
								responsedEmployee.workingAddress);
						$("#workMobile").append(responsedEmployee.workMobile);
						$("#workLocation").append(
								responsedEmployee.workLocation);
						$("#workEmail").append(responsedEmployee.workEmail);
						$("#workPhone").append(responsedEmployee.workPhone);
						$("#department").append(responsedEmployee.department);
						$("#jobTitle").append(responsedEmployee.jobTitle);

						if (responsedEmployee.manager != null) {
							$("#manager").append(responsedEmployee.manager);
						}
						if (responsedEmployee.coach != null) {
							$("#coach").append(responsedEmployee.coach);
						}

						$("#otherInformation").append(
								responsedEmployee.otherInformation);
						$("#nationality").append(responsedEmployee.nationality);
						$("#identificationNo").append(
								responsedEmployee.identificationNo);
						$("#passportNo").append(responsedEmployee.passportNo);
						$("#bankAccountNumber").append(
								responsedEmployee.bankAccountNumber);
						$("#gender").append(responsedEmployee.gender);
						$("#maritalStatus").append(
								responsedEmployee.maritalStatus);
						$("#homeAddress").append(responsedEmployee.homeAddress);
						$("#dateOfBirth").append(responsedEmployee.dateOfBirth);

					} else {
						pageNo -= 1;
					}
				}
			});
}
function showNewEmployeeForm() {

	$("#dynamic_content").remove();
	$.get({
		url : '/newemployee-page',
		success : function(responsedData) {
			output = '<div id="dynamic_content">';
			output += responsedData;
			output += '</div>';
			$("#container").append(output);
		}
	})

	initializeFormWithMasterData();// load and set master data in form
}

function updateEmployee() {
	var employeeId = document.getElementById("employeeId").value;
	createEmployee(employeeId);
}

function displayPictureOnBrowse(inputFile) {
	if (inputFile.files && inputFile.files[0]) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$('#mockPhoto').attr('src', e.target.result);
		};
		reader.readAsDataURL(inputFile.files[0]);
	}
}

function createProfilePicture() {
	$.ajax({
		type : 'post',
		url : '/create-profile-picture',

		// for multipart file upload
		enctype : 'multipart/form-data',
		data : new FormData($("#formId")[0]),
		processData : false,
		contentType : false,
		cache : false,

		// async: true,

		success : function(response) {
			console.log(response);
		},
		error : function() {
			console.log('not ok');
		}
	});
}
// takes id from update, takes nothing from create
function createEmployee(employeeId) {

	// file is attached
	if (document.getElementById("profilePhoto").value != "") {
		createProfilePicture();
	}

	$('input').next().remove();

	$.ajax({
		type : 'post',
		url : '/employees/createemployee',
		data : $('form[name=employeeForm]').serialize(),
		async : true,

		success : function(response) {

			if (response.validated) {

				// having id means this is part of update
				if (employeeId != null) {
					showEmployeeDetails(employeeId);
				} else {

					showEmployees();

					// create wont send any id
					$('#formId')[0].reset();
					$('#resultContainer pre code').text(
							"Successfully saved the employee!");
					$('#resultContainer').show();
					$("span.error").hide();
				}

			} else {
				$('#resultContainer').hide();
				$.each(response.errorMessages, function(key, value) {

					// error message doesn't show up for dropdown list using
					// input[name=''], so used dropdown id and set manually

					if (key == 'workingAddress') {
						$("#workingAddress").after(
								'<span class="error">' + value + '</span>');
					}
					if (key == 'department') {
						$("#department").after(
								'<span class="error">' + value + '</span>');
					}
					if (key == 'jobTitle') {
						$("#jobTitle").after(
								'<span class="error">' + value + '</span>');
					}
					if (key == 'nationality') {
						$("#nationality").after(
								'<span class="error">' + value + '</span>');
					}

					if (key == 'profilePicture') {

					} else {
						// all other fields
						$('input[name=' + key + ']').after(
								'<span class="error">' + value + '</span>');
					}

				});
			}
		},
		error : function() {

		}
	});
}
function showEditEmployeeForm() {
	var employeeId = document.getElementById("employeeId").value;

	$("#dynamic_content").remove();

	jQuery.ajaxSetup({
		async : false
	});
	$.get({
		url : '/editemployee-page',
		success : function(responsedData) {
			output = '<div id="dynamic_content">';
			output += responsedData;
			output += '</div>';
			$("#container").append(output);
		}
	})

	initializeFormWithEmployeeAndMasterData(employeeId);// load and set master
	// data in form
}

/*//This has been written by Muhammad Touhidul Islam, 25/2/2018
 * // takes id from update, takes nothing from create function
 * createEmployee(employeeId) {
 * 
 * $('input').next().remove();
 * 
 * $.ajax({ type : 'post', url : '/createemployee',
 * 
 * //employeeForm all data must be before file data, otherwise multipart error
 * will occur data : $('form[name=employeeForm]').serialize(),
 * 
 * //for multipart file upload enctype: 'multipart/form-data', data: new
 * FormData($("#formId")[0]), processData: false, contentType: false, cache:
 * false,
 * 
 * 
 * success : function(response) {
 * 
 * if (response.validated) { // having id means this is part of update if
 * (employeeId != null) { showEmployeeDetails(employeeId); } // create wont send
 * any id $('#formId')[0].reset(); $('#resultContainer pre code').text(
 * "Successfully saved the employee!"); $('#resultContainer').show();
 * $("span.error").hide(); } else { $('#resultContainer').hide();
 * $.each(response.errorMessages, function(key, value) { // error message
 * doesn't show up for dropdown list using // input[name=''], so used dropdown
 * id and set manually
 * 
 * if (key == 'workingAddress') { $("#workingAddress").after( '<span
 * class="error">' + value + '</span>'); } if (key == 'department') {
 * $("#department").after( '<span class="error">' + value + '</span>'); } if
 * (key == 'jobTitle') { $("#jobTitle").after( '<span class="error">' + value + '</span>'); }
 * if (key == 'nationality') { $("#nationality").after( '<span class="error">' +
 * value + '</span>'); } // all other fields $('input[name=' + key +
 * ']').after( '<span class="error">' + value + '</span>'); }); } }, error :
 * function() { } }); }
 */
