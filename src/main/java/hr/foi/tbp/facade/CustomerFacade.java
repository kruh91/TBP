package hr.foi.tbp.facade;

import java.util.List;

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.form.UserProfileForm;

public interface CustomerFacade {

	List<CustomerDTO> getCustomers();

	CustomerDTO getCustomerById(Long id);
	
	void saveCustomer(UserProfileForm userProfileForm);
	
	void setPermissionsToCustomer(Long userId, List<Long> permissions);
	
	void deleteCustomer(Long id);
}
