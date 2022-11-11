package aplication.cinema.controller;

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
import aplication.cinema.dto.TitleDTO;
import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.model.Title;
import aplication.cinema.service.MovieService;
import aplication.cinema.service.TitleService;
import aplication.cinema.support.MovieDtoToMovie;
import aplication.cinema.support.TitleDtoToTitle;
import aplication.cinema.support.TitleToTitleDTO;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;


@RestController
@RequestMapping(value="/api/title", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TitleController {
	
	
	@Autowired
	private TitleService titleService;
	
	@Autowired
	private TitleToTitleDTO toDto;
	
	@Autowired
	private TitleDtoToTitle toTitle;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TitleDTO> getOne(@PathVariable Long id) {
		Title title = titleService.findOne(id);

		if (title != null) {
			return new ResponseEntity<>(toDto.convert(title), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<TitleDTO>> getAll(){
		List<Title> titlovi = titleService.findAll();
		List<TitleDTO> titloviDto = toDto.convert(titlovi);
		
		return new ResponseEntity<>(titloviDto, HttpStatus.OK);
	}
	   @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TitleDTO> create(@Valid @RequestBody TitleDTO titleDto){
	        Title title = toTitle.convert(titleDto);
	        Title saveTitle = titleService.save(title);

	        return new ResponseEntity<>(toDto.convert(saveTitle), HttpStatus.CREATED);
	    }
	
 
	    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<TitleDTO> update(@PathVariable Long id, @Valid @RequestBody TitleDTO titleDTO){

	        if(!id.equals(titleDTO.getId())) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }

	        Title title = toTitle.convert(titleDTO);
	        Title saveTitle = titleService.update(title);

	        return new ResponseEntity<>(toDto.convert(saveTitle),HttpStatus.OK);
	    }
	    
	    

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> delete(@PathVariable Long id){
	        Title obrisanTitle = titleService.delete(id);

	        if(obrisanTitle != null) {
	            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    
	    

}
