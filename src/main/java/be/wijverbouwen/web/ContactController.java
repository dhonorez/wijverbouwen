package be.wijverbouwen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/contact")
@Controller
public class ContactController {

	@RequestMapping(method = RequestMethod.GET)
    public String displayPage() {
        return "contact";
    }
	
}
