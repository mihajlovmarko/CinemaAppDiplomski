package aplication.cinema.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import aplication.cinema.dto.MovieDTO;
import aplication.cinema.dto.ProjectionDTO;
import aplication.cinema.dto.TicketDTO;
import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.model.Ticket;
import aplication.cinema.service.TicketService;
import aplication.cinema.support.TicketDtoToTicket;
import aplication.cinema.support.TicketToTicketDto;

@RestController
@RequestMapping(value = "/api/ticket", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TicketController {
	
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private TicketToTicketDto toDto;
	
	@Autowired
	private TicketDtoToTicket toTicket;
	
	@GetMapping("/{id}")
	public ResponseEntity<TicketDTO> getOne(@PathVariable Long id) {
		Ticket ticket = ticketService.findOne(id);

		if (ticket != null) {
			return new ResponseEntity<>(toDto.convert(ticket), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
    //@PreAuthorize("hasRole('ROLE_KORISNIK')")
	@GetMapping
	public ResponseEntity<List<TicketDTO>> getAll(){
		List<Ticket> tickets = ticketService.findAll();
		List<TicketDTO> ticketDtos = toDto.convert(tickets);
		
		return new ResponseEntity<>(ticketDtos, HttpStatus.OK);
	}
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> create(@Valid @RequestBody TicketDTO ticketDto){
        Ticket ticket = toTicket.convert(ticketDto);
        Ticket saveTicket = ticketService.save(ticket);

        return new ResponseEntity<>(toDto.convert(saveTicket), HttpStatus.CREATED);
    }
    
    
    
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDTO> update(@PathVariable Long id, @Valid @RequestBody TicketDTO ticketDto){

        if(!id.equals(ticketDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ticket ticket = toTicket.convert(ticketDto);
        Ticket saveTicket = ticketService.update(ticket);

        return new ResponseEntity<>(toDto.convert(saveTicket),HttpStatus.OK);
    }
	
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Ticket obrisanTicket = ticketService.delete(id);

        if(obrisanTicket != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/{id}/projekcije")
    public ResponseEntity<List<TicketDTO>> findByProjectionId (@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Ticket> tickets = ticketService.findByProjectionId(id);

        return new ResponseEntity<>(toDto.convert(tickets), HttpStatus.OK);
    }
    
   
    
    

}
