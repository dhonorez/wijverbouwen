package be.wijverbouwen.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import be.wijverbouwen.model.Reservation;
import be.wijverbouwen.persistence.ReservationDAO;
import be.wijverbouwen.service.ReservationService;

@RequestMapping("/admin")
@Controller
public class AdminController {

	@Autowired private ReservationDAO reservationDAO;
	@Autowired private ReservationService reservationService;
	@Autowired private PartsController partsController;
	
	@RequestMapping(value="/reservationList", method = RequestMethod.GET)
    public ModelAndView displayPage() {
		ModelAndView mav = new ModelAndView("reservations");
		mav.addObject("reservations", reservationDAO.findAll());
        return mav;
    }
	
	@RequestMapping(value="/confirm/{id}")
	public ModelAndView confirmPayment(@PathVariable("id") Long reservationId) {
		Reservation reservation = reservationDAO.findById(reservationId);
		reservationService.confirmPayment(reservation);
		return displayPage();
	}
	
	@RequestMapping(value="/rebuild", method = RequestMethod.GET)
    public ModelAndView rebuild() {
		reservationService.rebuild();
		return partsController.listParts();
    }

}
