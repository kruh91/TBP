package hr.foi.tbp.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.hibernate.model.Customer;
import hr.foi.tbp.service.ContactInfoService;

@Component("customerDTOConverter")
public class CustomerDTOConverter extends AbstractConverter<Customer, CustomerDTO> {

	@Autowired
	private ContactInfoDTOConverter contactInfoDTOConverter;

	@Autowired
	private PermissionDTOConverter permissionDTOConverter;
	
	@Autowired
	private CustomerDTOSimpleConverter customerDTOSimpleConverter;
	
	@Autowired
	private ContactInfoService contactInfoService;

	@Override
	public CustomerDTO convert(Customer source) {

		CustomerDTO target = customerDTOSimpleConverter.convert(source);
		target.setActive(source.getActive());
		target.setContactInfos(contactInfoDTOConverter.convertAll(contactInfoService.getContactInfosByUsername(source.getUsername())));
		target.setPermissions(permissionDTOConverter.convertAll(source.getPermissions()));
		target.setUsername(source.getUsername());
		target.setEmail(source.getEmail());
		target.setDeleted(source.getDeleted());
		target.setType(source.getType());

		return target;
	}
}
