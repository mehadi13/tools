$(function() {
	
	var host='http://localhost:9070/v1/';
	var $tableBody = $('#tableBody');
	
	var $page = 1;
	
	$('#nextPage').on('click',function(){
		$page = $page+1;
		loadData();
	});
	
	$('#prePage').on('click',function(){
		if($page>1){
		$page = $page-1;
		}
		loadData();
	});
	
	function loadData(){
		$.ajax({
			type : 'GET',
			url : host+'employees?page='+$page,
			success : function(response) {
				$.each(response.result.employees, function(i, employee) {
					
					var id = employee.id;
					if (employee.manager != null)
						var $manager = employee.manager.name;
					else
						var $manager = '';
					$tableBody.empty();

					$tableBody.append(
							"<tr id="+id+" data-value='"+JSON.stringify(employee)+"'>" + '<td></td>' + '<td class="dd">' + employee.name
							+ '</td>' + '<td>' + employee.workPhone + '</td>'
							+ '<td>' + employee.workEmail + '</td>' + '<td>'
							+ employee.department.name + '</td>' + '<td>'
							+ employee.jobtitle.name + '</td>' + '<td>' + $manager
							+ '</td>' + '</tr>');
					$('#'+id).on('click',function(){
						var $employee = $(this).data('value');
						$.ajax({
							type : 'GET',
							url : '/showEdit',
							success : function(response) {
								$('#right-container').html(response);
								setValue($employee);
							}
						})
					})
				})

			}
		});
	}
	
	
$.ajax({
		type : 'GET',
		url : host+'employees',
		success : function(response) {
			$.each(response.result.employees, function(i, employee) {
				
				var id = employee.id;
				if (employee.manager != null)
					var $manager = employee.manager.name;
				else
					var $manager = '';

				$tableBody.append(
						"<tr id="+id+" data-value='"+JSON.stringify(employee)+"'>" + '<td></td>' + '<td class="dd">' + employee.name
						+ '</td>' + '<td>' + employee.workPhone + '</td>'
						+ '<td>' + employee.workEmail + '</td>' + '<td>'
						+ employee.department.name + '</td>' + '<td>'
						+ employee.jobtitle.name + '</td>' + '<td>' + $manager
						+ '</td>' + '</tr>');
				$('#'+id).on('click',function(){
					var $employee = $(this).data('value');
					$.ajax({
						type : 'GET',
						url : '/showEdit',
						success : function(response) {
							$('#right-container').html(response);
							setValue($employee);
						}
					})
				})
			})

		}
	});
	

	$('#create').on('click',function(){
		$.ajax({
			type : 'GET',
			url : '/showEdit',
			success : function(response) {
				$('#right-container').html(response);
				loadDepartment();
				loadJobTitle();
				loadManagerAndCoach();
				loadGender();
				loadMaritalStatus();
				loadJobType();
				loadNationalities();
			}
		})
	});
	
	function loadDepartment(){
		var $department = $('#department');
		$.ajax({
			type : 'GET',
			url : host+'departments',
			success : function(response) {
				$.each(response.result.departments, function(i, department) {
					$department.append("<option data-value='"+JSON.stringify(department)+"'>"+department.name+"</option>");
				});
			}
		})
	}
	
	function loadJobTitle(){
		var $jobtitle = $('#jobtitle');
		$.ajax({
			type : 'GET',
			url : host+'jobtitles',
			success : function(response) {
				$.each(response.result.jobtitles, function(i, jobtitle) {
					$jobtitle.append("<option data-value='"+JSON.stringify(jobtitle)+"'>"+jobtitle.name+"</option>");
				});
			}
		})
	}
	
	function loadManagerAndCoach(){
		var $manager = $('#manager');
		var $coach = $('#coach');
		$.ajax({
			type : 'GET',
			url : host+'employees',
			success : function(response) {
				$.each(response.result.employees, function(i, employee) {
					$manager.append("<option data-value='"+JSON.stringify(employee)+"'>"+employee.name+"</option>");
					$coach.append("<option data-value='"+JSON.stringify(employee)+"'>"+employee.name+"</option>");
				});
			}
		})
	}
	
	function loadGender(){
		var $gender = $('#gender');
		$.ajax({
			type : 'GET',
			url : host+'genders',
			success : function(response) {
				$.each(response.result.genders, function(i, gender) {
					$gender.append("<option data-value='"+JSON.stringify(gender)+"'>"+gender.name+"</option>");
				});
			}
		})
	}
	
	
	function loadMaritalStatus(){
		var $maritalstatus = $('#maritalstatus');
		$.ajax({
			type : 'GET',
			url : host+'maritalstatuses',
			success : function(response) {
				$.each(response.result.maritalstatuses, function(i, maritalstatus) {
					
					$maritalstatus.append("<option data-value='"+JSON.stringify(maritalstatus)+"'>"+maritalstatus.status+"</option>");
				});
			}
		})
	}
	
	function loadJobType(){
		var $jobtype = $('#jobtype');
		$.ajax({
			type : 'GET',
			url : host+'jobtypes',
			success : function(response) {
				$.each(response.result.jobtypes, function(i, jobtype) {
					$jobtype.append("<option data-value='"+JSON.stringify(jobtype)+"'>"+jobtype.name+"</option>");
				});
			}
		})
	}
	
	function loadNationalities(){
		var $nationality = $('#nationality');
		$.ajax({
			type : 'GET',
			url : host+'nationalities',
			success : function(response) {
				$.each(response.result.nationalities, function(i, nationality) {
					
					$nationality.append("<option data-value='"+JSON.stringify(nationality)+"'>"+nationality.country+"</option>");
				});
			}
		})
	}

		$('#store').on('click', function() {
			saveEmployee(setEmployee(),'POST');
		});

		function setEmployee(){
			var employee = {
				name : $('#name').val(),
				bankAccount: $('#bankAccount').val(),
				dateOfBirth: $('#dateOfBirth').val(),
				homeAddress: $('#homeAddress').val(),
				identificationNo: $('#identificationNo').val(),
				passportNo: $('#passportNo').val(),
				photoUrl: $('#photoUrl').val(),
				workAddress: $('#workAddress').val(),
				workEmail: $('#workEmail').val(),
				workLocation: $('#workLocation').val(),
				workMobile: $('#workMobile').val(),
				workPhone: $('#workPhone').val(),
				jobtype : $('#jobtype').find(':selected').data('value'),
				gender:$('#gender').find(':selected').data('value'),
				nationality:$('#nationality').find(':selected').data('value'),
				department:$('#department').find(':selected').data('value'),
				maritialstatus:$('#maritalstatus').find(':selected').data('value'),
				jobtitle:$('#jobtitle').find(':selected').data('value'),
				manager: $('#manager').find(':selected').data('value'),
				coach: $('#coach').find(':selected').data('value')
			}; 
			return employee;
		}

		

		function saveEmployee(employee,method){
			$.ajax({
				type : method,
				url : host+'employees',
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(employee),
				dataType : 'json',
				cache : false,
				success : function(response) {
					if(response.status=='ok'){
						$.ajax({
							type : 'GET',
							url : '/showEdit',
							success : function(view) {
								$('#right-container').html(view);
								setValue(response.result.employee);
							}
						})
					}
					else{
						if(response.status=='validation_error'){
							setField();
							showErrors(response.result.errors);
						}
					}
					
				},
				error : function(response){
					console.log(response);
				}
			});
		}
		
		function setField(){
			$('#nameError').text('');
			$('#bankAccountError').text('');
			$('#dateOfBirthError').text('');
			$('#homeAddressError').text('');
			$('#identificationNoError').text('');
			$('#passportNoError').text('');
			/*$('#photoUrlError').text('');*/
			$('#workAddressError').text('');
			$('#workEmailError').text('');
			$('#workLocationError').text('');
			$('#workMobileError').text('');
			$('#workPhoneError').text('');
		}
		
		function showErrors($errors){
			$('#nameError').text($errors.name);
			$('#bankAccountError').text($errors.bankAccount);
			$('#dateOfBirthError').text($errors.dateOfBirth);
			$('#homeAddressError').text($errors.homeAddress);
			$('#identificationNoError').text($errors.identificationNo);
			$('#passportNoError').text($errors.passportNo);
			/*$('#photoUrlError').text($errors.photoUrl);*/
			$('#workAddressError').text($errors.workAddress);
			$('#workEmailError').text($errors.workEmail);
			$('#workLocationError').text($errors.workLocation);
			$('#workMobileError').text($errors.workMobile);
			$('#workPhoneError').text($errors.workPhone);
		}

		function setValue(employee){
			$('#id').val(employee.id);
			$('#name').val(employee.name).prop('disabled', true);
			$('#bankAccount').val(employee.bankAccount).prop('disabled', true);
			$('#dateOfBirth').val(employee.dateOfBirth).prop('disabled', true);
			$('#homeAddress').val(employee.homeAddress).prop('disabled', true);
			$('#identificationNo').val(employee.identificationNo).prop('disabled', true);
			$('#passportNo').val(employee.passportNo).prop('disabled', true);
			$('#photoUrl').val(employee.photoUrl).prop('disabled', true);
			$('#workAddress').val(employee.workAddress).prop('disabled', true);
			$('#workEmail').val(employee.workEmail).prop('disabled', true);
			$('#workLocation').val(employee.workLocation).prop('disabled', true);
			$('#workMobile').val(employee.workMobile).prop('disabled', true);
			$('#workPhone').val(employee.workPhone).prop('disabled', true); 

			if(employee.jobtype!=null){
				$('#jobtype').append("<option data-value='"+JSON.stringify(employee.jobtype)
						+"'>"+employee.jobtype.name+"</option>")
				.prop('disabled', true);
			}

			if(employee.gender!=null){
				$('#gender').append("<option data-value='"+JSON.stringify(employee.gender)
						+"'>"+employee.gender.name+"</option>")
				.prop('disabled', true);
			}

			if(employee.nationality!=null){
				$('#nationality').append("<option data-value='"+JSON.stringify(employee.nationality)
						+"'>"+employee.nationality.country+"</option>")
				.prop('disabled', true);
			}
			
			if(employee.department!=null){
				$('#department').append("<option data-value='"+JSON.stringify(employee.department)
						+"'>"+employee.department.name+"</option>")
				.prop('disabled', true);
			}
			
			if(employee.maritialstatus!=null){
				$('#maritalstatus').append("<option data-value='"+JSON.stringify(employee.maritialstatus)
						+"'>"+employee.maritialstatus.status+"</option>")
				.prop('disabled', true);
			}
			
			if(employee.jobtitle!=null){
				$('#jobtitle').append("<option data-value='"+JSON.stringify(employee.jobtitle)
						+"'>"+employee.jobtitle.name+"</option>")
				.prop('disabled', true);
			}
			
			if(employee.manager!=null){
				$('#manager').append("<option data-value='"+JSON.stringify(employee.manager)
						+"'>"+employee.manager.name+"</option>")
				.prop('disabled', true);
			}
			if(employee.coach!=null){
				$('#coach').append("<option data-value='"+JSON.stringify(employee.coach)
						+"'>"+employee.coach.name+"</option>")
				.prop('disabled', true);
			}
			$('#store').prop('value', 'Edit').prop('id','edit');
		}

		
		$('#edit').on('click',function(){
			$('#edit').prop('value','Update').prop('id','update');
			$('#name').prop('disabled', false);
			$('#bankAccount').prop('disabled', false);
			$('#dateOfBirth').prop('disabled', false);
			$('#homeAddress').prop('disabled', false);
			$('#identificationNo').prop('disabled', false);
			$('#passportNo').prop('disabled', false);
			$('#photoUrl').prop('disabled', false);
			$('#workAddress').prop('disabled', false);
			$('#workEmail').prop('disabled', false);
			$('#workLocation').prop('disabled', false);
			$('#workMobile').prop('disabled', false);
			$('#workPhone').prop('disabled', false);
			
			
			
			/*$('#jobtitle').prop('disabled', false).empty();
			$('#gender').prop('disabled', false).empty();
			$('#nationality').prop('disabled', false).empty();
			$('#department').prop('disabled', false).empty();
			$('#gender').prop('disabled', false).empty();
			$('#maritalstatus').prop('disabled', false).empty();
			$('#manager').prop('disabled', false).empty();
			$('#coach').prop('disabled', false).empty();
			
			loadDepartment();
			
			loadManagerAndCoach();
			loadGender();
			loadMaritalStatus();
			loadJobType();
			loadNationalities();*/

			$('#update').on('click', function() {
				saveEmployee(setUpdatAbleEmployee(),'PUT');
			});
		});
		
		function setUpdatAbleEmployee(){
			var employee = {
					id : $('#id').val(),
				name : $('#name').val(),
				bankAccount: $('#bankAccount').val(),
				dateOfBirth: $('#dateOfBirth').val(),
				homeAddress: $('#homeAddress').val(),
				identificationNo: $('#identificationNo').val(),
				passportNo: $('#passportNo').val(),
				photoUrl: $('#photoUrl').val(),
				workAddress: $('#workAddress').val(),
				workEmail: $('#workEmail').val(),
				workLocation: $('#workLocation').val(),
				workMobile: $('#workMobile').val(),
				workPhone: $('#workPhone').val(),
				jobtype : $('#jobtype').find(':selected').data('value'),
				gender:$('#gender').find(':selected').data('value'),
				nationality:$('#nationality').find(':selected').data('value'),
				department:$('#department').find(':selected').data('value'),
				maritialstatus:$('#maritalstatus').find(':selected').data('value'),
				jobtitle:$('#jobtitle').find(':selected').data('value'),
				manager: $('#manager').find(':selected').data('value'),
				coach: $('#coach').find(':selected').data('value')
			}; 
			return employee;
		}
	

});
