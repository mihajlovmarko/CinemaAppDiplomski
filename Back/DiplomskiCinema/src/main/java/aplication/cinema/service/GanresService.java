package aplication.cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;

public interface GanresService {

	Ganres findOne(Long id);

	List<Ganres> findAll();

 
	Ganres save(Ganres ganre);

	Ganres update(Ganres ganre);

	Ganres delete(Long id);

	Page<Ganres> findAll(int brojStranice);

	Page<Movies> find(String filmName, String director, Integer durationOf, Integer durationTo, int pageNo);

	List<Ganres> find(Object object);

	List<Ganres> find(List<Long> ids);

}
