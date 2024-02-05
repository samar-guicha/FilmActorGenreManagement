package com.example.project1.service;
import com.example.project1.entities.Acteur;


import java.util.List;
public interface IServiceActeur {
    public Acteur createActeur (Acteur a);
    public Acteur  findActeurById(int id) ;
    public Acteur updateActeur(Acteur a) ;
    public List<Acteur> findAllActeurs() ;
    public void deleteActeur(int id) ;
    public boolean acteurExist(int id) ;

}
