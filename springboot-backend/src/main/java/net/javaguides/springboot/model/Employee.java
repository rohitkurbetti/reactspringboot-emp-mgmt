package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_seq")
	@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Transient
	private String empDesignation;
	@Transient
	private Long empSalary;
	@Transient
	private String empAddress1;
	@Transient
	private String empAddress2;
	@Transient
	private Long empAnnualIncome;
	@Transient
	private String empState;
	
	@Transient
	private Long empTaxslab;
	@Transient
	private Boolean empPrimaryIncome;
	@Transient
	private Long empTaxableAmount;

	
	
	public Long getEmpTaxslab() {
		return empTaxslab;
	}


	public void setEmpTaxslab(Long empTaxslab) {
		this.empTaxslab = empTaxslab;
	}


	public Boolean getEmpPrimaryIncome() {
		return empPrimaryIncome;
	}


	public void setEmpPrimaryIncome(Boolean empPrimaryIncome) {
		this.empPrimaryIncome = empPrimaryIncome;
	}


	public Long getEmpTaxableAmount() {
		return empTaxableAmount;
	}


	public void setEmpTaxableAmount(Long empTaxableAmount) {
		this.empTaxableAmount = empTaxableAmount;
	}


	public String getEmpDesignation() {
		return empDesignation;
	}


	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}


	public Long getEmpSalary() {
		return empSalary;
	}


	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}


	public String getEmpAddress1() {
		return empAddress1;
	}


	public void setEmpAddress1(String empAddress1) {
		this.empAddress1 = empAddress1;
	}


	public String getEmpAddress2() {
		return empAddress2;
	}


	public void setEmpAddress2(String empAddress2) {
		this.empAddress2 = empAddress2;
	}


	public Long getEmpAnnualIncome() {
		return empAnnualIncome;
	}


	public void setEmpAnnualIncome(Long empAnnualIncome) {
		this.empAnnualIncome = empAnnualIncome;
	}


	public String getEmpState() {
		return empState;
	}


	public void setEmpState(String empState) {
		this.empState = empState;
	}


	public Employee() {
		
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public Employee(String firstName, String lastName, String emailId, Long phoneNumber, String empDesignation,
			Long empSalary, String empAddress1, String empAddress2, Long empAnnualIncome, String empState,
			Long empTaxslab, Boolean empPrimaryIncome, Long empTaxableAmount) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.empDesignation = empDesignation;
		this.empSalary = empSalary;
		this.empAddress1 = empAddress1;
		this.empAddress2 = empAddress2;
		this.empAnnualIncome = empAnnualIncome;
		this.empState = empState;
		this.empTaxslab = empTaxslab;
		this.empPrimaryIncome = empPrimaryIncome;
		this.empTaxableAmount = empTaxableAmount;
	}
	
	
	
	
}
