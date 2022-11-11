package aplication.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;
 

@Repository
public interface GanresRepository extends JpaRepository<Ganres, Long> {

	Ganres findOneById(Long id);
	
	 List<Ganres> findByIdIn(List<Long> ids);
}
