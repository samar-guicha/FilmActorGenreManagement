package com.example.project1.service;
import com.example.project1.entities.Acteur;
import com.example.project1.repository.ActeurRepository;
import com.example.project1.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceActeur implements IServiceActeur{
    @Autowired
    ActeurRepository acteurRepository;

    @Override
    public Acteur createActeur(Acteur a) {
        return acteurRepository.save(a);
    }

    @Override
    public Acteur findActeurById(int id) {
        return acteurRepository.findById(id).get();
    }

    @Override
    public Acteur updateActeur(Acteur a) {
        return acteurRepository.save(a);
    }

    @Override
    public List<Acteur> findAllActeurs() {
        return acteurRepository.findAll();
    }

    @Override
    public void deleteActeur(int id) {
        acteurRepository.deleteById(id);
    }

    @Override
    public boolean acteurExist(int id) {
        return acteurRepository.existsById(id);
    }
}
