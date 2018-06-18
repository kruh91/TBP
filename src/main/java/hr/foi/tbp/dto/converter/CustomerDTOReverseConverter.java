package hr.foi.tbp.dto.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.hibernate.model.Customer;
import hr.foi.tbp.service.CustomerService;

@Component("customerDTOReverseConverter")
public class CustomerDTOReverseConverter extends AbstractConverter<CustomerDTO, Customer> {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Customer convert(CustomerDTO source) {

		Customer customer;
		Long id = source.getId();
		if (id == null) {
			customer = new Customer();
			customer.setUsername(source.getUsername());
		} else {
			customer = customerService.getCustomerById(id);
			if (customer == null) {
				customer = new Customer();
				customer.setUsername(source.getUsername());
			}
		}

		customer.setActive(source.getActive());
		customer.setEmail(source.getEmail());
		customer.setFirstName(source.getFirstName());
		customer.setLastName(source.getLastName());
		customer.setDeleted(source.getDeleted());
		customer.setType(source.getType());
		String password = source.getPassword();
		if (StringUtils.isNotBlank(password)) {
			customer.setPassword(passwordEncoder.encode(password));
		}

		return customer;
	}
}
