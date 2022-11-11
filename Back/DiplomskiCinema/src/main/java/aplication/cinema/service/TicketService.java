package aplication.cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplication.cinema.model.Projection;
import aplication.cinema.model.Ticket;
 

public interface TicketService {
	
	Ticket findOne(Long id);

	List<Ticket> findAll();

	Page<Ticket> findAll(Pageable pageable);

	Ticket save(Ticket ticket);

	Ticket update(Ticket ticket);

	Ticket delete(Long id);

	Page<Ticket> findAll(int brojStranice);
	
	 List<Ticket> findByProjectionId(Long projectionId);

	  List<Ticket> findByUserId(Long userId);

	 
}
