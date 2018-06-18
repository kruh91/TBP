package hr.foi.tbp.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hr.foi.tbp.hibernate.dao.ContactInfoRepository;
import hr.foi.tbp.hibernate.model.ContactInfo;
import hr.foi.tbp.service.ContactInfoService;

@Service("contactInfoService")
public class ContactInfoServiceImpl implements ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepository;
	
	@Override
	public List<ContactInfo> getContactInfos() {
		return contactInfoRepository.findAll();
	}

	@Override
	public ContactInfo getContactInfoById(Long id) {
		return contactInfoRepository.findOne(id);
	}

	@Override
	public void saveContactInfo(ContactInfo contactInfo) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		contactInfo.setModifiedByUsername(username);
		contactInfo.setModificationTime(new Timestamp(new Date().getTime()));

		contactInfoRepository.save(contactInfo);
	}

	@Override
	public void deleteContactInfo(Long id) {
		contactInfoRepository.delete(id);
		
	}

	@Override
	public List<ContactInfo> getContactInfosByUsername(String username) {
		return contactInfoRepository.findByUsername(username);
	}
}
