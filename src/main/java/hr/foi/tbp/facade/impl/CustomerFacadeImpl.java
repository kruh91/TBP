package hr.foi.tbp.facade.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.dto.converter.CustomerDTOConverter;
import hr.foi.tbp.dto.converter.CustomerDTOReverseConverter;
import hr.foi.tbp.enums.CustomerType;
import hr.foi.tbp.facade.CustomerFacade;
import hr.foi.tbp.form.UserProfileForm;
import hr.foi.tbp.hibernate.model.Customer;
import hr.foi.tbp.service.CustomerService;

@Component("customerFacade")
public class CustomerFacadeImpl implements CustomerFacade {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerDTOConverter customerDTOConverter;

	@Autowired
	private CustomerDTOReverseConverter customerDTOReverseConverter;

	@Override
	public List<CustomerDTO> getCustomers() {
		return customerDTOConverter.convertAll(customerService.getCustomers());
	}

	@Override
	public void saveCustomer(UserProfileForm userProfileForm) {
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setId(userProfileForm.getId());
		customerDTO.setActive(userProfileForm.getActive());
		customerDTO.setEmail(userProfileForm.getEmail());
		customerDTO.setFirstName(userProfileForm.getFirstName());
		customerDTO.setLastName(userProfileForm.getLastName());
		customerDTO.setPassword(userProfileForm.getPassword());
		customerDTO.setDeleted(userProfileForm.getDeleted());
		customerDTO.setType(userProfileForm.getType());

		Customer customer = customerDTOReverseConverter.convert(customerDTO);

		if (customer.getType() == null) {
			customer.setType(CustomerType.STANDARD);
		}

		if (StringUtils.isBlank(customer.getUsername())) {
			customer.setUsername(userProfileForm.getUsername());
		}

		customerService.saveUser(customer);
	}

	@Override
	public void setPermissionsToCustomer(Long userId, List<Long> permissions) {
		customerService.setPermissionsToCustomer(userId, permissions);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerService.deleteUser(id);
	}

	@Override
	public CustomerDTO getCustomerById(Long id) {
		return customerDTOConverter.convert(customerService.getCustomerById(id));
	}

}
