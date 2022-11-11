package aplication.cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

 
import aplication.cinema.model.Projection;

public interface ProjectionService {
	Projection findOne(Long id);

	List<Projection> findAll();

	Page<Projection> findAll(Pageable pageable);

	Projection save(Projection projection);

	Projection update(Projection projection);

	Projection delete(Long id);

	Page<Projection> findAll(int brojStranice);
	
	  List<Projection> findByMovieId(Long filmId);
	
	

}
