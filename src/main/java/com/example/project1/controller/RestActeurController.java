package com.example.project1.controller;

import com.example.project1.entities.Acteur;
import com.example.project1.exception.ActeurNotfoundException;
import com.example.project1.exception.FilmNotfoundException;
import com.example.project1.service.IServiceActeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/acteurs/")
public class RestActeurController {
    @Autowired
    IServiceActeur iServiceActeur;

    @GetMapping("")
    public List<Acteur> getAllActeurs() {
        return iServiceActeur.findAllActeurs();
    }
    @GetMapping("{id}")
    public Acteur getActeurById(@PathVariable int id) {
        if(!iServiceActeur.acteurExist(id)) throw new ActeurNotfoundException();
        return iServiceActeur.findActeurById(id);}
    @PostMapping("add")
    public Acteur createActeur(@RequestBody Acteur a) {return iServiceActeur.createActeur(a);}
    @PutMapping("update")
    public Acteur updateActeur(@RequestBody Acteur a) {

        if(!iServiceActeur.acteurExist(a.getId())) throw new ActeurNotfoundException();
        return iServiceActeur.updateActeur(a);
    }
    @DeleteMapping("delete/{id}")
    public String deleteActeur(@PathVariable int id) {
        if(!iServiceActeur.acteurExist(id)) throw new ActeurNotfoundException();
        iServiceActeur.deleteActeur(id);
        return "acteur supprime";

    }
}
