package com.example.demo.controller;

import com.example.demo.metier.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcController {

    @Autowired
    PersonneService personneService;

    @GetMapping("annuairePersonnes")
    public String annuairePersonnes(Model model){
        // MVC
        // C: Controller
        // M : Modele
        // V : View

        model.addAttribute("personnes", personneService.getPersonnes());

        return "annuaire.html";
        //return "annuaire";

    }


}
