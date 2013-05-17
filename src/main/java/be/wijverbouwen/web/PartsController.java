package be.wijverbouwen.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.wijverbouwen.model.Part;
import be.wijverbouwen.persistence.PartDAO;

@RequestMapping("/shop")
@Controller
public class PartsController {
	
	@Autowired private PartDAO partDAO;
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listParts() {
		ModelAndView mav = new ModelAndView("shop");
		List<Part> parts = partDAO.findAll();
		mav.addObject("parts", parts);
        return mav;
    }

}
