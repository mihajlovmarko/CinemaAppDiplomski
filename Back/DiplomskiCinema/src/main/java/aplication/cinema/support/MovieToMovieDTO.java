package aplication.cinema.support;

import org.springframework.stereotype.Component;

import aplication.cinema.dto.MovieDTO;
import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

@Component
public class MovieToMovieDTO  implements Converter<Movies, MovieDTO>{

	@Override
	public MovieDTO convert(Movies source) {
		MovieDTO dto = new MovieDTO();
		dto.setId(source.getId());
		dto.setFilmName(source.getFilmName());
		dto.setDuration(source.getDuration());
		dto.setYear(source.getYear());
		dto.setDirector(source.getDirector());
		
        LinkedHashMap<Long, String> zanroviMap = new LinkedHashMap<>();

		for(Ganres ganre : source.getGanres()) {
			zanroviMap.put(ganre.getId(), ganre.getNameGanre());
		}
		dto.setGanres(zanroviMap);
		return dto;
		
	}
	
	 public List<MovieDTO> convert(List<Movies> movies){
	        List<MovieDTO> moviesDto = new ArrayList<>();

	        for(Movies movie : movies) {
	        	moviesDto.add(convert(movie));
	        }

	        return moviesDto;
	    }

}
