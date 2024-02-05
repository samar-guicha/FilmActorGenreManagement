package com.example.project1.service;
import com.example.project1.entities.Categorie;
import com.example.project1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceCategorie implements IServiceCategorie{
    @Autowired
    CategorieRepository categorieRepository;


    @Override
    public Categorie createCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public Categorie findCategorieById(int id) {
        return categorieRepository.findById(id).get();
    }

    @Override
    public Categorie updateCategorie(Categorie c) {
        return categorieRepository.save(c);
    }

    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public void deleteCategorie(int id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public boolean categorieExist(int id) {
        return categorieRepository.existsById(id);
    }
}
