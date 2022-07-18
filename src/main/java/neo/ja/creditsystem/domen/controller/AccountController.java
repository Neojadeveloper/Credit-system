package neo.ja.creditsystem.domen.controller;

import neo.ja.creditsystem.domen.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account/*")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("list/{code}")
    public String listPage(Model model, @PathVariable Integer code){
        model.addAttribute("accounts",service.getAll(code));
        return "account/list";
    }

    @GetMapping("detail/{id}")
    public String detail(Model model, @PathVariable Integer id){
        model.addAttribute("account", service.getId(id));
        return "account/detail";
    }
}
