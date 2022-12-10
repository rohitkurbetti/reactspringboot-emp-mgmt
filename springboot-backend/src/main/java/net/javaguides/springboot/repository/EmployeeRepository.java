package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.EmpDetails;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.model.SalDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	
	
	@Query(value = "select ed from EmpDetails ed where ed.empId = :empId")
	EmpDetails getEmpDetails(@Param("empId") Long empId);

	@Query(value = "select sd from SalDetails sd where sd.empId = :empId")
	SalDetails getSalDetails(@Param("empId") Long empId);

}
