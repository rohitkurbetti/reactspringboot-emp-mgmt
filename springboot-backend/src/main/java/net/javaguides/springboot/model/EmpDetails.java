package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "employee_details")
public class EmpDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "emp_details_seq")
	@SequenceGenerator(name = "emp_details_seq", sequenceName = "emp_details_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_designation")
	private String empDesignation;
	
	@Column(name = "emp_salary")
	private Long empSalary;
	
	@Column(name = "emp_address1")
	private String empAddress1;
	
	@Column(name = "emp_address2")
	private String empAddress2;
	
	@Column(name = "emp_annual_income")
	private Long empAnnualIncome;
	
	@Column(name = "emp_state")
	private String empState;

	
	public EmpDetails() {
		
	}
	
	public EmpDetails(Long empId, String empDesignation, Long empSalary, String empAddress1, String empAddress2,
			Long empAnnualIncome, String empState) {
		super();
		this.empId = empId;
		this.empDesignation = empDesignation;
		this.empSalary = empSalary;
		this.empAddress1 = empAddress1;
		this.empAddress2 = empAddress2;
		this.empAnnualIncome = empAnnualIncome;
		this.empState = empState;
	}

	
	
	public long getId() {
		return id;
	}

	
	public void setId(long id) {
		this.id = id;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
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
	
	
}
