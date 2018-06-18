package hr.foi.tbp.service;

import java.util.List;

import hr.foi.tbp.hibernate.model.ContactInfo;

public interface ContactInfoService {

	List<ContactInfo> getContactInfos();
	
	List<ContactInfo> getContactInfosByUsername(String username);
	
	ContactInfo getContactInfoById(Long id);
	
	void saveContactInfo(ContactInfo contactInfo);
	
	void deleteContactInfo(Long id);
}
