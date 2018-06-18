package hr.foi.tbp.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.ContactInfoDTO;
import hr.foi.tbp.dto.UserDTO;
import hr.foi.tbp.hibernate.model.Address;
import hr.foi.tbp.hibernate.model.ContactInfo;
import hr.foi.tbp.hibernate.model.User;
import hr.foi.tbp.service.UserService;

@Component("contactInfoDTOConverter")
public class ContactInfoDTOConverter extends AbstractConverter<ContactInfo, ContactInfoDTO> {

	@Autowired
	private UserService userService;
	
	@Override
	public ContactInfoDTO convert(ContactInfo source) {
		
		ContactInfoDTO target = new ContactInfoDTO();
		target.setId(source.getId());
		Address address = source.getAddress();
		target.setAddress(address.getAddress());
		target.setMobile(source.getMobile());
		target.setPhone(source.getPhone());
		target.setPostalCode(address.getPostalCode());
		target.setTown(address.getTown());
		target.setCountry(address.getCountry());
		
		User user = userService.getUserByUsername(source.getUsername());
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		target.setUser(userDTO);
		
		return target;
	}
}
