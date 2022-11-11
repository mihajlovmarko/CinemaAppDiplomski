package aplication.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aplication.cinema.model.Movies;
import aplication.cinema.model.Title;

@Repository
public interface TitleRepository extends JpaRepository<Title, Long> {
	Title findOneById(Long id);

}
