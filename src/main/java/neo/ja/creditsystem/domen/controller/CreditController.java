package neo.ja.creditsystem.domen.controller;

import neo.ja.creditsystem.domen.DTO.CreditCreateDTO;
import neo.ja.creditsystem.domen.DTO.CreditUpdateDTO;
import neo.ja.creditsystem.domen.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/credit/*")
public class CreditController {

    private final CreditService service;

    @Autowired
    public CreditController(CreditService service) {
        this.service = service;
    }
    @PostMapping("create/")
    public String create(@ModelAttribute CreditCreateDTO createDTO){
        service.create(createDTO);
        return "redirect:/";
    }

    @GetMapping("detail/{id}")
    private String details(Model model, @PathVariable Integer id) {
        model.addAttribute("credit", service.get(id));
        return "credit/detail";
    }

    @RequestMapping(value = "delete/{id}/", method = RequestMethod.POST)
    private String delete(@PathVariable Integer id) {
        service.delete(id);
        return "redirect:/";
    }

    @GetMapping(value = "delete/{id}/")
    private String deletePage(Model model, @PathVariable Integer id) {
        model.addAttribute("credit", service.get(id));
        return "credit/delete";
    }

    @GetMapping(value = "update/{id}/")
    private String updatePage(Model model, @PathVariable Integer id) {
        model.addAttribute("credit", service.getA(id));
        return "credit/update";
    }

    @PostMapping(value = "update/{id}")
    private String update(CreditUpdateDTO updateDTO, @PathVariable Integer id) {
        service.update(updateDTO);
        return "redirect:/";
    }

}
