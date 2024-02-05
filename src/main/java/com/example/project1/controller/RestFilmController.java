package com.example.project1.controller;

import com.example.project1.entities.Film;
import com.example.project1.exception.FilmNotfoundException;
import com.example.project1.service.IServiceFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films/")
public class RestFilmController {
    @Autowired
    IServiceFilm iServiceFilm;

    @GetMapping("")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public List<Film> getAllFilms() {
        return iServiceFilm.findAllFilms();
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public Film getFilmById(@PathVariable int id) {
        if(!iServiceFilm.filmExist(id)) throw new FilmNotfoundException();
        return iServiceFilm.findFilmById(id);
    }

    @PostMapping("add")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Film createFilm(@RequestBody Film f) {
        return iServiceFilm.createFilm(f);
    }

    @PutMapping("update")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Film updateFilm(@RequestBody Film f) {
        if(!iServiceFilm.filmExist(f.getId())) throw new FilmNotfoundException();
        return iServiceFilm.updateFilm(f);
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public String deleteFilm(@PathVariable int id) {
        if(!iServiceFilm.filmExist(id)) throw new FilmNotfoundException();
        iServiceFilm.deleteFilm( id);
        return "film supprime";
    }

    @GetMapping("/findbyyear/{year}")

    public List<Film> findByYear(@PathVariable int year){
        return iServiceFilm.findFilmByAnneeparution(year);
    }
}
