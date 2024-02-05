package com.example.project1.service;
import com.example.project1.entities.Categorie;
import java.util.List;
public interface IServiceCategorie {
    public Categorie createCategorie(Categorie c) ;
    public Categorie  findCategorieById(int id) ;
    public Categorie updateCategorie(Categorie c) ;
    public List<Categorie> findAllCategories() ;
    public void deleteCategorie(int id) ;
    public boolean categorieExist(int id) ;
}
