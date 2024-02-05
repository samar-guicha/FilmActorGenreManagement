package com.example.project1.controller;


import com.example.project1.entities.Acteur;
import com.example.project1.entities.Film;
import com.example.project1.service.IServiceActeur;
import com.example.project1.service.IServiceCategorie;
import com.example.project1.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/acteur/")
public class ActeurController {
/*    @Autowired
    IServiceActeur iServiceActeur;
    @Autowired
    IServiceFilm iServiceFilm;

    @GetMapping("all")
    public String listeActeurs(Model model){
        model.addAttribute("acteurs", iServiceActeur.findAllActeurs());
        return "affiche";
    }
    @PostMapping("add")
    public String add(Acteur a){
        iServiceActeur.createActeur(a);
        return "redirect:/acteur/all";
    }*/
}