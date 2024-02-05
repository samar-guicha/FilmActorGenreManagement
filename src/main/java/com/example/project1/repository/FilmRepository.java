package com.example.project1.repository;
import com.example.project1.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
//findByAnneeparutionGreaterThan
    List<Film> findByAnneeparution (int year);
    List <Film> findByTitreContains(String titre);
}
