package pl.cytawek.vatRates.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.cytawek.vatRates.services.VatService;

@Controller
public class WellcomeController {
    final VatService vatService;

    @Autowired
    public WellcomeController(VatService vatService) {
        this.vatService = vatService;
    }

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("countryList",vatService.getCurrentVat().getRate());
        return "index";
    }

}
