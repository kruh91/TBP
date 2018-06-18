package hr.foi.tbp.controller;

import java.util.ArrayList;
import java.util.List;

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

import hr.foi.tbp.dto.CustomerDTO;
import hr.foi.tbp.dto.PermissionDTO;
import hr.foi.tbp.enums.CustomerType;
import hr.foi.tbp.facade.CustomerFacade;
import hr.foi.tbp.facade.PermissionFacade;
import hr.foi.tbp.form.ContactInfoForm;
import hr.foi.tbp.form.UserPermissionsForm;
import hr.foi.tbp.form.UserProfileForm;
import hr.foi.tbp.form.validator.UserProfileFormAddValidator;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private CustomerFacade customerFacade;
	
	@Autowired
	private PermissionFacade permissionFacade;
	
	@Autowired
	private UserProfileFormAddValidator userProfileFormAddValidator;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUserProfilePage(@PathVariable("id") Long id, Model model) {
		
		CustomerDTO user = customerFacade.getCustomerById(id);
		if(user == null) {
			return "redirect:/error";
		}
		
		UserProfileForm userProfileForm = new UserProfileForm();
		userProfileForm.setId(user.getId());
		userProfileForm.setActive(user.getActive());
		userProfileForm.setEmail(user.getEmail());
		userProfileForm.setFirstName(user.getFirstName());
		userProfileForm.setLastName(user.getLastName());
		userProfileForm.setUsername(user.getUsername());
		userProfileForm.setDeleted(user.getDeleted());
		userProfileForm.setType(user.getType());
		
		model.addAttribute("userProfileForm", userProfileForm);
		model.addAttribute("usernameReadOnly", true);
		model.addAttribute("customerTypes", CustomerType.values());
		
		return "pages/userProfile";
	}
	
	@RequestMapping(value =  "/{id}", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("userProfileForm") UserProfileForm userProfileForm, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "pages/userProfile";
		}
		
		customerFacade.saveCustomer(userProfileForm);
		redirectAttributes.addFlashAttribute("successMessage", "Korisnik uspješno spremljen!");
		
		return "redirect:/users/" + userProfileForm.getId();
	}
	
	@RequestMapping(value = "/{id}/permissions", method = RequestMethod.GET)
	public String getUserPermissionsPage(@PathVariable("id") Long id, Model model) {
		
		CustomerDTO user = customerFacade.getCustomerById(id);
		if(user == null) {
			return "redirect:/error";
		}
		
		List<Long> usersPermissionsIds = new ArrayList<>();
		List<PermissionDTO> usersPermissions = user.getPermissions();
		for(PermissionDTO permissionDTO : usersPermissions) {
			usersPermissionsIds.add(permissionDTO.getId());
		}
		List<PermissionDTO> allPermissions = permissionFacade.getPermissions();
		UserPermissionsForm userPermissionsForm = new UserPermissionsForm();
		userPermissionsForm.setUserId(user.getId());
		userPermissionsForm.setPermissions(usersPermissionsIds);
		model.addAttribute("user", user);
		model.addAttribute("allPermissions", allPermissions);
		model.addAttribute("userPermissionsForm", userPermissionsForm);
		
		return "pages/userPermissions";
	}
	
	@RequestMapping(value = "/{id}/permissions", method = RequestMethod.POST)
	public String saveUserPermissions(@Valid @ModelAttribute("userPermissionsForm") UserPermissionsForm userPermissionsForm, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		if(bindingResult.hasErrors()) {
			return "pages/userPermissions";
		}
		
		customerFacade.setPermissionsToCustomer(userPermissionsForm.getUserId(), userPermissionsForm.getPermissions());
		redirectAttributes.addFlashAttribute("successMessage", "Promjene su uspješno spremljene!");
		
		return "redirect:/users/" + userPermissionsForm.getUserId() + "/permissions";
	}
	
	@RequestMapping(value = "/{id}/contact-infos", method = RequestMethod.GET)
	public String getUserContactInfos(@PathVariable("id") Long id, Model model) {
		
		CustomerDTO user = customerFacade.getCustomerById(id);
		if(user == null) {
			return "redirect:/error";
		}
		
		model.addAttribute("user", user);
		
		return "pages/userContactInfos";
	}
	
	@RequestMapping(value = "/{id}/add-contact-info", method = RequestMethod.GET)
	public String getAddContactInfoPage(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
		
		CustomerDTO user = customerFacade.getCustomerById(id);
		if(user == null) {
			return "redirect:/error";
		}
		
		ContactInfoForm contactInfoForm = new ContactInfoForm();
		contactInfoForm.setUserId(user.getId());
		model.addAttribute("contactInfoForm", contactInfoForm);
		model.addAttribute("user", user);
		model.addAttribute("action", request.getContextPath() + "/contact-infos/add-contact-info");
		
		return "pages/contactInfo";
	}
	
	@RequestMapping(value = "/add-user", method = RequestMethod.GET)
	public String getAddUserPage(Model model) {
		
		UserProfileForm userProfileForm = new UserProfileForm();
		userProfileForm.setDeleted(false);
		model.addAttribute("userProfileForm", userProfileForm);
		model.addAttribute("usernameReadOnly", false);
		
		return "pages/userProfile";
	}
	
	@RequestMapping(value =  "/add-user", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("userProfileForm") UserProfileForm userProfileForm, BindingResult bindingResult, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		ValidationUtils.invokeValidator(userProfileFormAddValidator, userProfileForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "pages/userProfile";
		}
		
		customerFacade.saveCustomer(userProfileForm);
		redirectAttributes.addFlashAttribute("successMessage", "Korisnik uspješno spremljen!");
		
		return "redirect:/";
	}
	
	@RequestMapping(value =  "/{id}/delete", method = RequestMethod.POST)
	public String deleteContactInfo(@RequestParam("id") Long id, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) {
		
		customerFacade.deleteCustomer(id);
		redirectAttributes.addFlashAttribute("successMessage", "Korisnik obrisan!");
		
		return "redirect:" + request.getHeader("referer");
	}
}
