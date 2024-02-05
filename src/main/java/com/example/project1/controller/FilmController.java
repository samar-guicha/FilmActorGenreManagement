package com.example.project1.controller;
import com.example.project1.entities.Film;
import com.example.project1.service.IServiceActeur;
import com.example.project1.service.IServiceCategorie;
import com.example.project1.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/film/")
public class FilmController {

    @Autowired
    IServiceFilm iServiceFilm;
    @Autowired
    IServiceCategorie iServiceCategorie;
    @Autowired
    IServiceActeur iServiceActeur;

    @GetMapping("all")
    public String listeFilms(Model model){
        model.addAttribute("films", iServiceFilm.findAllFilms());
        model.addAttribute("acteurs",iServiceActeur.findAllActeurs());
        return "affiche";
    }
    @GetMapping("new")
    public String afficheNewForm(Model model){
        model.addAttribute("categories", iServiceCategorie.findAllCategories());
        model.addAttribute("acteurs",iServiceActeur.findAllActeurs());
        return "Ajout";
    }
    @PostMapping("add")
    public String add(Film f){
        iServiceFilm.createFilm(f);
        return "redirect:/film/all";
    }
    @GetMapping("delete/{id}")
    public String delete(@PathVariable int id){
        iServiceFilm.deleteFilm(id);
        return "redirect:/film/all";
    }

    @GetMapping("update/{id}")
    public String update(Model model, @PathVariable int id){
        model.addAttribute("categories", iServiceCategorie.findAllCategories());
        model.addAttribute("film", iServiceFilm.findFilmById(id));
        model.addAttribute("acteurs",iServiceActeur.findAllActeurs());
        return "Edit";
    }
    @PostMapping("update")
    public String update(Film f){
        iServiceFilm.updateFilm(f);
        return "redirect:/film/all";
    }

}


