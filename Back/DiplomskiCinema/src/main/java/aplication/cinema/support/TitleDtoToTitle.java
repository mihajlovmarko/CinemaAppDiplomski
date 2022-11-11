package aplication.cinema.support;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import aplication.cinema.dto.TitleDTO;
import aplication.cinema.model.Title;
import aplication.cinema.service.MovieService;
import aplication.cinema.service.TitleService;

@Component
public class TitleDtoToTitle  implements Converter<TitleDTO, Title>{

	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private MovieService movieService;
	
	
	@Override
	public Title convert(TitleDTO dto) {
	 
		Title title;
		
		if(dto.getId() == null) {
			title = new Title();
		}else
		{
			title= titleService.findOne(dto.getId());
		}
		
		if(title != null) {
			title.setId(dto.getId());
			title.setLenguage(dto.getLenguage());
			title.setMovie(movieService.findOne(dto.getMovieId()));
		}
		return title;
		
		
		
		
		
		 
	}

}
