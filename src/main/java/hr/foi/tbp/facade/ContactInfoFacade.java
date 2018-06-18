package hr.foi.tbp.facade;

import java.util.List;

import hr.foi.tbp.dto.ContactInfoDTO;
import hr.foi.tbp.form.ContactInfoForm;

public interface ContactInfoFacade {

	List<ContactInfoDTO> getContactInfos();
	
	ContactInfoDTO getContactInfoById(Long id);
	
	void saveContactInfo(ContactInfoForm contactInfoForm);

	void deleteContactInfo(Long id);
}
