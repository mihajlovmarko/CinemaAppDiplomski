package aplication.cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.core.convert.converter.Converter;

import aplication.cinema.dto.GanreDTO;
import aplication.cinema.model.Ganres;
import aplication.cinema.service.GanresService;

@Component
public class GanreDtoToGanre  implements Converter<GanreDTO, Ganres>{

	@Autowired
	private GanresService ganreService;
	
	
	@Override
	public Ganres convert(GanreDTO ganreDTO) {
		Ganres ganre;
		
		if(ganreDTO.getId() == null) {
			ganre=new Ganres();
		}else {
			ganre= ganreService.findOne(ganreDTO.getId());
		}
		
		if(ganre !=null) {
			ganre.setNameGanre(ganreDTO.getNameGanre());
		}
		return ganre;
		
	}
}
