package aplication.cinema.support;

import org.springframework.stereotype.Component;

import aplication.cinema.dto.ProjectionDTO;
import aplication.cinema.model.Projection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

@Component
public class ProjectionToProjectionDTO implements Converter<Projection, ProjectionDTO> {

	@Override
	public ProjectionDTO convert(Projection projekcija) {
		ProjectionDTO dto = new ProjectionDTO();

		dto.setId(projekcija.getId());
		dto.setDateAndTime(projekcija.getDateAndTime().toString());
		dto.setFilmId(projekcija.getMovie().getId());
		dto.setFilmNaziv(projekcija.getMovie().getFilmName());
		dto.setPrice(projekcija.getPrice());
		dto.setTheatre(projekcija.getTheater());
		 

		return dto;

	}

	public List<ProjectionDTO> convert(List<Projection> projekcije) {
		List<ProjectionDTO> projekcijeDto = new ArrayList<>();

		for (Projection projekcija : projekcije) {
			projekcijeDto.add(convert(projekcija));
		}

		return projekcijeDto;
	}

}
