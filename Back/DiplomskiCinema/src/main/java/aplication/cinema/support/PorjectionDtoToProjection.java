package aplication.cinema.support;

import org.springframework.stereotype.Component;

import aplication.cinema.dto.ProjectionDTO;
import aplication.cinema.model.Projection;
import aplication.cinema.service.MovieService;
import aplication.cinema.service.ProjectionService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class PorjectionDtoToProjection implements Converter<ProjectionDTO, Projection> {

	@Autowired
	private ProjectionService projectionService;
	
	
	@Autowired
	private MovieService movieService;
	
 
	
	
	@Override
	public Projection convert(ProjectionDTO dto) {
		Projection projection;
		
		 if(dto.getId() == null){
			 projection = new Projection();
	        }else{
	        	projection = projectionService.findOne(dto.getId());
	        }

	        if(projection != null){
	        	projection.setDateAndTime(getLocalDateTime(dto.getDateAndTime()));
	        	projection.setMovie(movieService.findOne(dto.getFilmId()));
	        	projection.setPrice(dto.getPrice());
	        	projection.setTheater(dto.getTheatre());
	        	
	        	
	        
	        	 
	        	 
	        }
	        return projection;
		
		
		
		 
	}
	
	 private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        return LocalDateTime.parse(dateTime, formatter);
	    }

 
	
	
}
