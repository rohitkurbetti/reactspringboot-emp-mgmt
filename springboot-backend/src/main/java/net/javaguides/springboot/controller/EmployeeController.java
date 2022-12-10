package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.EmpDetails;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.SalDetails;
import net.javaguides.springboot.repository.EmployeeRepository;
import net.javaguides.springboot.repository.GenericDaoImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private GenericDaoImpl genericDaoImpl;
	
	// get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}		
	
	// create employee rest api
	@PostMapping("/employees")
	@Transactional
	public Employee createEmployee(@RequestBody Employee employee) {
		Employee emp =  employeeRepository.save(employee);
		genericDaoImpl.getGenericDAO("insert into employee_details values (nextval('emp_details_seq'),?,?,?,?,?,?,?) ")
			.setParameter(1, emp.getId())
			.setParameter(2, emp.getEmpDesignation())
			.setParameter(3, emp.getEmpSalary())
			.setParameter(4, emp.getEmpAddress1())
			.setParameter(5, emp.getEmpAddress2())
			.setParameter(6, emp.getEmpAnnualIncome())
			.setParameter(7, emp.getEmpState())
			.executeUpdate();
		genericDaoImpl.getGenericDAO("insert into sal_details values (nextval('sal_details_seq'),?,?,?,?,?) ")
			.setParameter(1, emp.getId())
			.setParameter(2, emp.getEmpSalary())
			.setParameter(3, emp.getEmpTaxslab())
			.setParameter(4, emp.getEmpPrimaryIncome())
			.setParameter(5, emp.getEmpTaxableAmount())
			.executeUpdate();
		return emp;
	}
	
	// get employee by id rest api
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		EmpDetails empDetails = employeeRepository.getEmpDetails(id);
		if(empDetails != null) {
			employee.setEmpDesignation(empDetails.getEmpDesignation());
			employee.setEmpSalary(empDetails.getEmpSalary());
			employee.setEmpAddress1(empDetails.getEmpAddress1());
			employee.setEmpAddress2(empDetails.getEmpAddress2());
			employee.setEmpAnnualIncome(empDetails.getEmpAnnualIncome());
			employee.setEmpState(empDetails.getEmpState());
		}
		SalDetails salDetails = employeeRepository.getSalDetails(id);
		if(salDetails!= null){
			employee.setEmpTaxslab(salDetails.getEmpTaxslab());
			employee.setEmpPrimaryIncome(salDetails.getEmpPrimaryIncome());
			employee.setEmpTaxableAmount(salDetails.getEmpTaxableAmount());
		}
		return ResponseEntity.ok(employee);
	}
	
	// update employee rest api
	
	@PutMapping("/employees/{id}")
	@Transactional
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
		employee.setPhoneNumber(employeeDetails.getPhoneNumber());
		Employee updatedEmployee = employeeRepository.save(employee);
		genericDaoImpl.getGenericDAO("update employee_details set emp_designation = ?, emp_salary = ?, emp_address1 = ? , emp_address2 = ? , emp_annual_income =?, emp_state=? where emp_id = ?")
			.setParameter(1, employeeDetails.getEmpDesignation())
			.setParameter(2, employeeDetails.getEmpSalary())
			.setParameter(3, employeeDetails.getEmpAddress1())
			.setParameter(4, employeeDetails.getEmpAddress2())
			.setParameter(5, employeeDetails.getEmpAnnualIncome())
			.setParameter(6, employeeDetails.getEmpState())
			.setParameter(7, employee.getId())
			.executeUpdate();
		genericDaoImpl.getGenericDAO("update sal_details set emp_salary = ?, emp_taxslab = ? , emp_primary_income = ? , emp_taxable_amount =? where emp_id = ?")
			.setParameter(1, employeeDetails.getEmpSalary())
			.setParameter(2, employeeDetails.getEmpTaxslab())
			.setParameter(3, employeeDetails.getEmpPrimaryIncome())
			.setParameter(4, employeeDetails.getEmpTaxableAmount())
			.setParameter(5, employee.getId())
			.executeUpdate();
		return ResponseEntity.ok(updatedEmployee);
	}
	
	// delete employee rest api
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/employees/getEmpDetails/{empId}")
	public ResponseEntity<EmpDetails> getEmpDetails(@PathVariable("empId") Long empId){
		EmpDetails empDetails = employeeRepository.getEmpDetails(empId);
		return ResponseEntity.ok(empDetails);
	}
	
	@GetMapping("/employees/getSalaryDetails/{empId}")
	public ResponseEntity<SalDetails> getSalDetails(@PathVariable("empId") Long empId){
		SalDetails salDetails = employeeRepository.getSalDetails(empId);
		return ResponseEntity.ok(salDetails);
	}
	
	
	
}
