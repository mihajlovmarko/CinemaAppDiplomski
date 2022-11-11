package aplication.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

 
import aplication.cinema.model.Projection;

public interface ProjectionRepository  extends JpaRepository<Projection, Long>{

	Projection findOneById(Long id);
	

    List<Projection> findByMovieId(Long filmId);
}
