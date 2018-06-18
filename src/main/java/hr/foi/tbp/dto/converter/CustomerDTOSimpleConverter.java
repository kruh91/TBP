package hr.foi.tbp.dto.converter;

import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.dto.UserDTO;
import hr.foi.tbp.hibernate.model.Customer;

@Component("customerDTOSimpleConverter")
public class CustomerDTOSimpleConverter extends AbstractConverter<Customer, UserDTO> {

	@Override
	public CustomerDTO convert(Customer source) {

		CustomerDTO target = new CustomerDTO();
		target.setId(source.getId());
		target.setFirstName(source.getFirstName());
		target.setLastName(source.getLastName());

		return target;
	}
}
