package hr.foi.tbp.hibernate.dao;

import org.springframework.data.repository.query.Param;

import hr.foi.tbp.hibernate.model.Employee;

public interface EmployeeRepository extends AbstractJpaRepository<Employee, Long> {
	
	Employee findByUsernameAndActiveTrueAndDeletedFalse(@Param("username") String username);
	
	Employee findByIdAndActiveTrueAndDeletedFalse(@Param("id") Long id);

}
