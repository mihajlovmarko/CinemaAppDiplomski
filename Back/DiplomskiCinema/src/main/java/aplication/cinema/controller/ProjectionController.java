package aplication.cinema.controller;

import java.util.List;

import javax.validation.Valid;

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
import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.service.ProjectionService;
import aplication.cinema.support.PorjectionDtoToProjection;
import aplication.cinema.support.ProjectionToProjectionDTO;

@RestController
@RequestMapping(value = "/api/projection", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProjectionController {
	
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private ProjectionToProjectionDTO toDto;
	
	@Autowired
	private PorjectionDtoToProjection toProjeciton;
	
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectionDTO> getOne(@PathVariable Long id) {
		Projection projection = projectionService.findOne(id);

		if (projection != null) {
			return new ResponseEntity<>(toDto.convert(projection), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
   // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<ProjectionDTO>> getAll(){
		List<Projection> projekcije = projectionService.findAll();
		List<ProjectionDTO> projekcijeDto = toDto.convert(projekcije);
		
		return new ResponseEntity<>(projekcijeDto, HttpStatus.OK);
	}
	
	
	   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ProjectionDTO> create(@Valid @RequestBody ProjectionDTO projectionDto){
	        Projection projection = toProjeciton.convert(projectionDto);
	        Projection saveProjection = projectionService.save(projection);

	        return new ResponseEntity<>(toDto.convert(saveProjection), HttpStatus.CREATED);
	    }
	   
	   @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ProjectionDTO> update(@PathVariable Long id, @Valid @RequestBody ProjectionDTO projectionDto){

	        if(!id.equals(projectionDto.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Projection projection = toProjeciton.convert(projectionDto);
	        Projection saveProjection = projectionService.update(projection);

	        return new ResponseEntity<>(toDto.convert(saveProjection),HttpStatus.OK);
	    }
		
	   @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
	        Projection obrisiProjekciju = projectionService.delete(id);

	        if(obrisiProjekciju != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	

}
