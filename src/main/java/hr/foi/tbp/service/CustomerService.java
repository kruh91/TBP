package hr.foi.tbp.service;

import java.util.List;

import hr.foi.tbp.hibernate.model.Customer;

public interface CustomerService extends UserService {

	List<Customer> getCustomers();
	
	Customer getCustomerById(Long id);
	
	void setPermissionsToCustomer(Long customerId, List<Long> permissionIds);
}
