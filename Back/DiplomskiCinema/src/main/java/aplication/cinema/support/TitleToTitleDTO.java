package aplication.cinema.support;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import aplication.cinema.dto.MovieDTO;
import aplication.cinema.dto.TitleDTO;
import aplication.cinema.model.Title;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

@Component
public class TitleToTitleDTO implements Converter<Title, TitleDTO> {

	@Override
	public TitleDTO convert(Title title) {
		TitleDTO dto = new TitleDTO();
		dto.setId(title.getId());
		dto.setLenguage(title.getLenguage());
		dto.setMovieId(title.getMovie().getId());
		dto.setMovieName(title.getMovie().getFilmName());
		 
	 

		return dto;

	}

	public List<TitleDTO> convert(List<Title> titlovi) {
		List<TitleDTO> titloviDto = new ArrayList<>();

		for (Title titl : titlovi) {
			titloviDto.add(convert(titl));
		}

		return titloviDto;
	}

}
