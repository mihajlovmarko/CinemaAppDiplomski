package aplication.cinema.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import aplication.cinema.model.Movies;

@Repository
public interface MovieRepository extends  JpaRepository<Movies, Long> {

	Movies findOneById(Long id);
	
	   

	Page<Movies> findByFilmNameIgnoreCaseContainsAndDurationBetween(String filmName, 
			Integer durationOf, Integer durationTo, Pageable pageable);
	
 
 
 
 }
