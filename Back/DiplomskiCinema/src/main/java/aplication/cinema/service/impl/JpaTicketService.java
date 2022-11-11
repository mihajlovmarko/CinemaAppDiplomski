package aplication.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.model.Ticket;
import aplication.cinema.repository.TicketRepository;
import aplication.cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService {

	
	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Ticket findOne(Long id) {
	 return  ticketRepository.findOneById(id);
	}

	@Override
	public List<Ticket> findAll() {
	 return ticketRepository.findAll();
	}

	@Override
	public Page<Ticket> findAll(Pageable pageable) {
	 return  null;
	}

	@Override
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket update(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket delete(Long id) {
		Optional<Ticket> m = ticketRepository.findById(id);
        if(m.isPresent()){
            ticketRepository.deleteById(id);
            return m.get();
        }
        return null;
	}

	@Override
	public Page<Ticket> findAll(int brojStranice) {
		return ticketRepository.findAll(PageRequest.of(brojStranice,10));

	}

	@Override
	public List<Ticket> findByProjectionId(Long projectionId) {
		 return ticketRepository.findByProjectionId(projectionId);
		 
	}

	@Override
	public List<Ticket> findByUserId(Long userId) {
		 
		return  ticketRepository.findByUserId(userId);
	}

}
