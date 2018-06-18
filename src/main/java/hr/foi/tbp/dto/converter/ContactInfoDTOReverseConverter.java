package hr.foi.tbp.dto.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.ContactInfoDTO;
import hr.foi.tbp.hibernate.model.Address;
import hr.foi.tbp.hibernate.model.ContactInfo;
import hr.foi.tbp.service.ContactInfoService;

@Component("contactInfoDTOReverseConverter")
public class ContactInfoDTOReverseConverter extends AbstractConverter<ContactInfoDTO, ContactInfo> {

	@Autowired
	private ContactInfoService contactInfoService;
	
	@Override
	public ContactInfo convert(ContactInfoDTO source) {

		ContactInfo contactInfo;
		Long id = source.getId();
		if (id == null) {
			contactInfo = new ContactInfo();
		} else {
			contactInfo = contactInfoService.getContactInfoById(id);
			if (contactInfo == null) {
				contactInfo = new ContactInfo();
			}
		}
		
		Address address = new Address(source.getCountry(), source.getTown(), source.getPostalCode(), source.getAddress());
		contactInfo.setAddress(address);
		contactInfo.setMobile(source.getMobile());
		contactInfo.setPhone(source.getPhone());
		
		return contactInfo;
	}

}
