package aplication.cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplication.cinema.model.Movies;

public interface MovieService {
	Movies findOne(Long id);

	List<Movies> findAll();

	Page<Movies> findAll(Pageable pageable);

	Movies save(Movies movie);

	Movies update(Movies movie);

	Movies delete(Long id);

	Page<Movies> findAll(int brojStranice);

	Page<Movies> find(String filmName , Integer durationOf, Integer durationTo, int pageNo);

 
 }
