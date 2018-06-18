package hr.foi.tbp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import hr.foi.tbp.dto.ContactInfoDTO;
import hr.foi.tbp.facade.ContactInfoFacade;
import hr.foi.tbp.form.ContactInfoForm;
import hr.foi.tbp.form.validator.ContactInfoFormValidator;

@Controller
@RequestMapping("/contact-infos")
public class ContactInfoController {
	
	@Autowired
	private ContactInfoFacade contactInfoFacade;
	
	@Autowired
	private ContactInfoFormValidator contactInfoFormValidator;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getContactInfo(@PathVariable("id") Long id, Model model) {
		
		ContactInfoDTO contactInfo = contactInfoFacade.getContactInfoById(id);
		if(contactInfo == null) {
			return "redirect:/error";
		}
		
		ContactInfoForm contactInfoForm = new ContactInfoForm();
		contactInfoForm.setId(contactInfo.getId());
		contactInfoForm.setAddress(contactInfo.getAddress());
		contactInfoForm.setMobile(contactInfo.getMobile());
		contactInfoForm.setPhone(contactInfo.getPhone());
		contactInfoForm.setPostalCode(contactInfo.getPostalCode());
		contactInfoForm.setTown(contactInfo.getTown());
		contactInfoForm.setCountry(contactInfo.getCountry());
		model.addAttribute("contactInfoForm", contactInfoForm);
		model.addAttribute("user", contactInfo.getUser());
		model.addAttribute("action", "");
		
		return "pages/contactInfo";
	}
	
	@RequestMapping(value =  "/{id}", method = RequestMethod.POST)
	public String saveContactInfo(@Valid @ModelAttribute("contactInfoForm") ContactInfoForm contactInfoForm, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		ValidationUtils.invokeValidator(contactInfoFormValidator, contactInfoForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "pages/contactInfo";
		}
		
		contactInfoFacade.saveContactInfo(contactInfoForm);
		redirectAttributes.addFlashAttribute("successMessage", "Kontakt informacije uspješno spremljene!");
		
		return "redirect:/contact-infos/" + contactInfoForm.getId();
	}
	
	@RequestMapping(value =  "/{id}/delete", method = RequestMethod.POST)
	public String deleteContactInfo(@RequestParam("id") Long id, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		contactInfoFacade.deleteContactInfo(id);
		redirectAttributes.addFlashAttribute("successMessage", "Kontakt informacija obrisana!");
		
		return "redirect:" + request.getHeader("referer");
	}
	
	@RequestMapping(value =  "/add-contact-info", method = RequestMethod.POST)
	public String addContactInfo(@Valid @ModelAttribute("contactInfoForm") ContactInfoForm contactInfoForm, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		ValidationUtils.invokeValidator(contactInfoFormValidator, contactInfoForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "pages/contactInfo";
		}
		
		contactInfoFacade.saveContactInfo(contactInfoForm);
		redirectAttributes.addFlashAttribute("successMessage", "Kontakt informacija uspješno spremljena!");
		
		return "redirect:/users/" + contactInfoForm.getUserId()  + "/contact-infos";
	}
}
