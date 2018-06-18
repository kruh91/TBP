package hr.foi.tbp.facade.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hr.foi.tbp.dto.ContactInfoDTO;
import hr.foi.tbp.dto.converter.ContactInfoDTOConverter;
import hr.foi.tbp.dto.converter.ContactInfoDTOReverseConverter;
import hr.foi.tbp.facade.ContactInfoFacade;
import hr.foi.tbp.form.ContactInfoForm;
import hr.foi.tbp.hibernate.model.ContactInfo;
import hr.foi.tbp.service.ContactInfoService;
import hr.foi.tbp.service.UserService;

@Component("contactInfoFacade")
public class ContactInfoFacadeImpl implements ContactInfoFacade {

	@Autowired
	private ContactInfoService contactInfoService;
	
	@Autowired
	private ContactInfoDTOConverter contactInfoDTOConverter;
	
	@Autowired
	private ContactInfoDTOReverseConverter contactInfoDTOReverseConverter;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<ContactInfoDTO> getContactInfos() {
		return contactInfoDTOConverter.convertAll(contactInfoService.getContactInfos());
	}

	@Override
	public ContactInfoDTO getContactInfoById(Long id) {
		ContactInfo contactInfo = contactInfoService.getContactInfoById(id);
		if(contactInfo != null) {
			return contactInfoDTOConverter.convert(contactInfo);
		}
		return null;
	}

	@Override
	public void saveContactInfo(ContactInfoForm contactInfoForm) {
		ContactInfoDTO contactInfoDTO = new ContactInfoDTO();
		contactInfoDTO.setId(contactInfoForm.getId());
		contactInfoDTO.setAddress(contactInfoForm.getAddress());
		contactInfoDTO.setMobile(contactInfoForm.getMobile());
		contactInfoDTO.setPhone(contactInfoForm.getPhone());
		contactInfoDTO.setPostalCode(contactInfoForm.getPostalCode());
		contactInfoDTO.setTown(contactInfoForm.getTown());
		contactInfoDTO.setCountry(contactInfoForm.getCountry());
		
		ContactInfo contactInfo = contactInfoDTOReverseConverter.convert(contactInfoDTO);
		if(StringUtils.isBlank(contactInfo.getUsername())) {
			contactInfo.setUsername(userService.getUserById(contactInfoForm.getUserId()).getUsername());
		}
		
		contactInfoService.saveContactInfo(contactInfo);
	}

	@Override
	public void deleteContactInfo(Long id) {
		contactInfoService.deleteContactInfo(id);
	}
}
