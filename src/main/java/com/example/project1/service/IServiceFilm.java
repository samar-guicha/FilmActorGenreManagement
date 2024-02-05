package com.example.project1.service;
import java.util.List;
import com.example.project1.entities.Film;
public interface IServiceFilm {
    public Film createFilm(Film f) ;
    public Film findFilmById(int id) ;
    public Film updateFilm(Film f) ;
    public List<Film> findAllFilms() ;
    public void deleteFilm(int id) ;
    public boolean filmExist(int id) ;
    List<Film> findFilmByAnneeparution(int year);
}
