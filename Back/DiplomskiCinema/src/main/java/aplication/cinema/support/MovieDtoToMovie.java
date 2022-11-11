package aplication.cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aplication.cinema.dto.MovieDTO;
import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;
import aplication.cinema.service.GanresService;
import aplication.cinema.service.MovieService;

import org.springframework.core.convert.converter.Converter;
 

@Component
public class MovieDtoToMovie implements Converter<MovieDTO,Movies> {

	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private GanresService ganresService;
	
	@Override
	public Movies convert(MovieDTO dto) {
		 
		Movies entity;
		
		if(dto.getId() == null) {
			entity=new Movies();
		}else {
			entity=movieService.findOne(dto.getId());
		}
		 if(entity != null) {
	            entity.setFilmName(dto.getFilmName());
	            entity.setDuration(dto.getDuration());
	            entity.setDirector(dto.getDirector());
	            entity.setYear(dto.getYear());
 
 	            List<Ganres> zanrovi = ganresService.find(new ArrayList<>(dto.getGanres().keySet()));
 	            entity.setGanres(new HashSet<>(zanrovi));
	        }
		
		return entity;
	}

	 
}
