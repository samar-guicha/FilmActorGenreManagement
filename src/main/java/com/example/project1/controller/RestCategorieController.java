package com.example.project1.controller;

import com.example.project1.entities.Acteur;
import com.example.project1.entities.Categorie;
import com.example.project1.exception.ActeurNotfoundException;
import com.example.project1.exception.CategorieNotfoundException;
import com.example.project1.service.IServiceCategorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories/")
public class RestCategorieController {
    @Autowired
    IServiceCategorie iServiceCategorie;

    @GetMapping("")
    public List<Categorie> getAllCategories() {
        return iServiceCategorie.findAllCategories();
    }
    @GetMapping("{id}")
    public Categorie getCategorieById(@PathVariable int id) {
        if(!iServiceCategorie.categorieExist(id)) throw new CategorieNotfoundException();
        return iServiceCategorie.findCategorieById(id);}
    @PostMapping("add")
    public Categorie createCategorie(@RequestBody Categorie c) {return iServiceCategorie.createCategorie(c);}
    @PutMapping("update")
    public Categorie updateCategorie(@RequestBody Categorie c) {
        if(!iServiceCategorie.categorieExist(c.getId())) throw new CategorieNotfoundException();
        return iServiceCategorie.updateCategorie(c);}
    @DeleteMapping("delete/{id}")
    public String deleteCategorie(@PathVariable int id) {
        if(!iServiceCategorie.categorieExist(id)) throw new CategorieNotfoundException();
        iServiceCategorie.deleteCategorie(id);
        return "categorie supprimee";

    }
}
