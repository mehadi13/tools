package com.bjit.training.employee.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the employees database table.
 * 
 */
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Digits(fraction = 0, integer = 20, message = "{digitsonly}")
	private String bankAccount;

	@Column(name = "date_of_birth")
	private Date dateOfBirth;

	@Column(name = "home_address")
	@Length(max = 50)
	@NotEmpty(message = "{error.employee.homeAddress.notempty}")
	private String homeAddress;

	@Column(name = "identification_no")
	@Digits(fraction = 0, integer = 17, message = "{digitsonly}")
	@NotEmpty(message = "{error.employee.identificationNo.notempty}")
	private String identificationNo;

	@Column(name = "name")
	@Length(max = 20, min = 2)
	@Pattern(regexp = "[a-zA-Z ]+", message = "{error.employee.name.pattern.message}")
	@NotEmpty(message = "{error.employee.name.notempty}")
	private String name;

	@Column(name = "passport_no")
	private String passportNo;

	@Column(name = "photo_url")
	private String photoUrl;

	@Column(name = "work_address")
	@Length(max = 50)
	@NotEmpty(message = "{error.employee.workAddress.notempty}")
	private String workAddress;

	@Column(name = "work_email")
	@Length(max = 50)
	@Email(message = "{error.employee.email.valid}", regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@NotEmpty(message = "{error.employee.workEmail.notempty}")
	private String workEmail;

	@Column(name = "work_location")
	@Length(max = 50)
	@NotEmpty(message = "{error.employee.workLocation.notempty}")
	private String workLocation;

	@Column(name = "work_mobile")
	@Digits(fraction = 0, integer = 14, message = "{digitsonly}")
	@Length(max = 14, min = 11)
	@NotEmpty(message = "{error.employee.workMobile.notempty}")
	private String workMobile;

	@Column(name = "work_phone")
	@Digits(fraction = 0, integer = 14, message = "{digitsonly}")
	@Length(max = 14, min = 9)
	@NotEmpty(message = "{error.employee.workPhone.notempty}")
	private String workPhone;

	@ManyToOne
	private Gender gender;

	@ManyToOne
	private MaritalStatus maritalStatus;

	@ManyToOne
	private Nationality nationality;

	@ManyToOne
	private JobTitle jobTitle;

	@ManyToOne
	private Department department;

	@ManyToOne
	private JobType jobType;

	@ManyToOne
	private Employee manager;

	@ManyToOne
	private Employee coach;

	public Employee() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankaccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return this.homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getIdentificationNo() {
		return this.identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNo() {
		return this.passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getWorkAddress() {
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getWorkEmail() {
		return this.workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getWorkLocation() {
		return this.workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public String getWorkMobile() {
		return this.workMobile;
	}

	public void setWorkMobile(String workMobile) {
		this.workMobile = workMobile;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MaritalStatus getMaritialstatus() {
		return this.maritalStatus;
	}

	public void setMaritialstatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Nationality getNationality() {
		return this.nationality;
	}

	public void setNationality(Nationality nationality) {
		this.nationality = nationality;
	}

	public JobTitle getJobtitle() {
		return this.jobTitle;
	}

	public void setJobtitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public JobType getJobtype() {
		return this.jobType;
	}

	public void setJobtype(JobType jobType) {
		this.jobType = jobType;
	}

	public Employee getManager() {
		return this.manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Employee getCoach() {
		return this.coach;
	}

	public void setCoach(Employee coach) {
		this.coach = coach;
	}
}