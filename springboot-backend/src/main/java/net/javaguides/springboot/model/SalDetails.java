package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "sal_details")
public class SalDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sal_details_seq")
	@SequenceGenerator(name = "sal_details_seq", sequenceName = "sal_details_seq", allocationSize = 1)
	private long id;
	
	@Column(name = "emp_id")
	private Long empId;

	@Column(name = "emp_salary")
	private Long empSalary;
	
	@Column(name = "emp_taxslab")
	private Long empTaxslab;
	
	@Column(name = "emp_primary_income")
	private Boolean empPrimaryIncome;
	
	@Column(name = "emp_taxable_amount")
	private Long empTaxableAmount;
	
	public SalDetails() {
		
	}

	public SalDetails(Long empId, Long empSalary, Long empTaxslab, Boolean empPrimaryIncome, Long empTaxableAmount) {
		super();
		this.empId = empId;
		this.empSalary = empSalary;
		this.empTaxslab = empTaxslab;
		this.empPrimaryIncome = empPrimaryIncome;
		this.empTaxableAmount = empTaxableAmount;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Long empSalary) {
		this.empSalary = empSalary;
	}

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
	
	
	
}
