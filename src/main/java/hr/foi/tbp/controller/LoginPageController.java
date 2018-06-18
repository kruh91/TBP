package hr.foi.tbp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginPageController {

	@RequestMapping
	public String getLoginPage(Model model, String error, String logout) {
		
		if (error != null)
            model.addAttribute("error", "Pogrešno korisničko ime ili lozinka.");

        if (logout != null)
            model.addAttribute("message", "Uspješto ste odjavljeni.");

        return "pages/login";
	}
}
