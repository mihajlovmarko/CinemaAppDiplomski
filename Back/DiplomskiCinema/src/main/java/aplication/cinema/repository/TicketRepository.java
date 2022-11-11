package aplication.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 
import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.model.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
	Ticket findOneById(Long id);
	
	  List<Ticket> findByProjectionId(Long projekcijaId);

	  
	    List<Ticket> findByUserId(Long userId);

	  
}
