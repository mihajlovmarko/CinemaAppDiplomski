package aplication.cinema.support;

import java.util.ArrayList;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import aplication.cinema.dto.GanreDTO;
import aplication.cinema.dto.MovieDTO;
import aplication.cinema.model.Ganres;

import java.util.ArrayList;
import java.util.List;

@Component
public class GanresToGanresDTO implements Converter<Ganres, GanreDTO> {

	@Override
	public GanreDTO convert(Ganres source) {
		GanreDTO dto = new GanreDTO();

		dto.setId(source.getId());
		dto.setNameGanre(source.getNameGanre());
		return dto;

	}
	
	
	public List<GanreDTO> convert(List<Ganres> zanrovi){
		 List<GanreDTO> zanrDto = new ArrayList<>();

	        for(Ganres zanr : zanrovi) {
	            zanrDto.add(convert(zanr));
	        }

	        return zanrDto;
		
	}

}
