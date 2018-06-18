package hr.foi.tbp.form.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import hr.foi.tbp.form.ContactInfoForm;

@Component("contactInfoFormValidator")
public class ContactInfoFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactInfoForm.class.equals(clazz);
	}

	@Override
	public void validate(Object form, Errors errors) {

		ContactInfoForm contactInfoForm = (ContactInfoForm) form;
		
		if(StringUtils.isNotBlank(contactInfoForm.getAddress())) {
			return;
		}

		if(StringUtils.isNotBlank(contactInfoForm.getMobile())) {
			return;
		}
		
		if(StringUtils.isNotBlank(contactInfoForm.getPhone())) {
			return;
		}
		
		if(StringUtils.isNotBlank(contactInfoForm.getPostalCode())) {
			return;
		}
		
		if(StringUtils.isNotBlank(contactInfoForm.getTown())) {
			return;
		}
		
		errors.reject("all.empty", "Morate popuniti barem jedno polje!");
	}

}
