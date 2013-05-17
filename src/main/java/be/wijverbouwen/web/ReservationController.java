package be.wijverbouwen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.wijverbouwen.model.Reservation;
import be.wijverbouwen.persistence.PartDAO;
import be.wijverbouwen.service.ReservationService;

@RequestMapping("/reservation")
@Controller
public class ReservationController {
	
	@Autowired PartDAO partDAO;
	@Autowired ReservationService reservationService;
	
	@RequestMapping(value="/makeReservation", method = RequestMethod.POST)
	public String makeReservation(@ModelAttribute("reservation") Reservation reservation) {
		System.out.println(reservation);
		reservationService.makeReservation(reservation);
		return "overview";
	}
	
	@RequestMapping("/new/{partId}")
	public ModelAndView newReservation(@PathVariable Long partId) {
		ModelAndView mav = new ModelAndView("reservationForm");
		addParts(mav);
		mav.addObject("selectedPart", partId);
		mav.addObject("command", new Reservation());
		
		return mav;
	}

	private void addParts(ModelAndView mav) {
		mav.addObject("parts", partDAO.findAll());
	}

}
