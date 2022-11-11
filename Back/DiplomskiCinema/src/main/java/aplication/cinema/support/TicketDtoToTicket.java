package aplication.cinema.support;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import aplication.cinema.dto.TicketDTO;
import aplication.cinema.model.Movies;
import aplication.cinema.model.Ticket;
import aplication.cinema.service.KorisnikService;
import aplication.cinema.service.ProjectionService;
import aplication.cinema.service.TicketService;

@Component
public class TicketDtoToTicket  implements Converter<TicketDTO, Ticket>{

	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private KorisnikService userService;
	
	
	
	@Override
	public Ticket convert(TicketDTO dto) {
		 
		Ticket entity;
		if(dto.getId() == null) {
			entity=new Ticket();
		}else {
			entity=ticketService.findOne(dto.getId());
		}
		 if(entity != null) {
	            entity.setId(dto.getId());
	            entity.setPrice(dto.getPrice());
	            entity.setReserved(dto.getReserved());
	            entity.setSeatNumber(dto.getSeatNumber());
	            entity.setProjection(projectionService.findOne(dto.getProjectionID()));
	            entity.setUser(userService.findOne1(dto.getUserId()));
	            
 
	        }
		
		return entity;
	}

}
