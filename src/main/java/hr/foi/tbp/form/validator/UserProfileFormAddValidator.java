package hr.foi.tbp.form.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import hr.foi.tbp.form.UserProfileForm;

@Component("userProfileFormAddValidator")
public class UserProfileFormAddValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserProfileForm.class.equals(clazz);
	}

	@Override
	public void validate(Object form, Errors errors) {
		
		UserProfileForm profileForm = (UserProfileForm) form;
		
		if(StringUtils.isBlank(profileForm.getPassword())) {
			errors.rejectValue("password", "Obavezno polje");
		}
	}

}
