package neo.ja.creditsystem.domen.controller;

import neo.ja.creditsystem.domen.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/")
public class HomeController {

    private final CreditService service;

    @Autowired
    public HomeController(CreditService service) {
        this.service = service;
    }

    @GetMapping("")
    public String homePage(Model model){
        model.addAttribute("credits", service.getAll());
        return "credit/list";
    }
}
