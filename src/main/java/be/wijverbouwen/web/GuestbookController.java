package be.wijverbouwen.web;

import be.wijverbouwen.model.Guestbook;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/guestbooks")
@Controller
@RooWebScaffold(path = "guestbooks", formBackingObject = Guestbook.class)
public class GuestbookController {
}
