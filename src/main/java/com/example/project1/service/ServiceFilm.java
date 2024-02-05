package com.example.project1.service;
import com.example.project1.entities.Film;
import com.example.project1.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ServiceFilm implements IServiceFilm{
    @Autowired
    FilmRepository filmRepository;

    @Override
    public Film createFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public Film findFilmById(int id) {
        return filmRepository.findById(id).get();
    }

    @Override
    public Film updateFilm(Film f) {
        return filmRepository.save(f);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }

    @Override
    public boolean filmExist(int id) {
        return filmRepository.existsById(id);
    }

    @Override
    public List<Film> findFilmByAnneeparution(int year) {
        return filmRepository.findByAnneeparution(year);
    }
}