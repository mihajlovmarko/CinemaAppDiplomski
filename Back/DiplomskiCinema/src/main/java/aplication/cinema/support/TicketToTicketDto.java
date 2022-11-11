package aplication.cinema.support;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import aplication.cinema.dto.MovieDTO;
import aplication.cinema.dto.TicketDTO;
import aplication.cinema.model.Movies;
import aplication.cinema.model.Ticket;

@Component
public class TicketToTicketDto implements Converter<Ticket, TicketDTO> {

	@Override
	public TicketDTO convert(Ticket source) {
		TicketDTO dto = new TicketDTO();
		dto.setId(source.getId());
		 
		dto.setSeatNumber(source.getSeatNumber());
		dto.setReserved(source.getReserved());
		dto.setProjectionID(source.getProjection().getId());
		dto.setUserId(source.getUser().getId());
		dto.setPriceProjection(source.getProjection().getPrice());
		dto.setNazivF(source.getProjection().getMovie().getFilmName());
		dto.setDatumP(source.getProjection().getDateAndTime().toString());
		
 
		
		return dto;
	}
	
	
	 public List<TicketDTO> convert(List<Ticket> tickets){
	        List<TicketDTO> ticketDto = new ArrayList<>();

	        for(Ticket ticket1 : tickets) {
	        	ticketDto.add(convert(ticket1));
	        }

	        return ticketDto;
	    }

}
