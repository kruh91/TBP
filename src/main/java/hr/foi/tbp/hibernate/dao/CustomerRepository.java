package hr.foi.tbp.hibernate.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import hr.foi.tbp.hibernate.model.Customer;

public interface CustomerRepository extends AbstractJpaRepository<Customer, Long> {
	
	Customer findByUsernameAndDeletedFalse(@Param("username") String username);
	
	Customer findByIdAndDeletedFalse(@Param("id") Long id);
	
	List<Customer> findByDeletedFalse();

}
