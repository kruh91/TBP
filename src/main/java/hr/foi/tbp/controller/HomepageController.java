package hr.foi.tbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hr.foi.tbp.facade.CustomerFacade;

@Controller
@RequestMapping("/")
public class HomepageController {

	@Autowired
	private CustomerFacade customerFacade;
	
	@RequestMapping
	public String getHomepage(Model model) {
		
		model.addAttribute("users", customerFacade.getCustomers());
		
		return "pages/homepage";
	}
}
