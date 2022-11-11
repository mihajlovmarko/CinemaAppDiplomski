package aplication.cinema.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

 

import org.springframework.http.MediaType;

import aplication.cinema.dto.KorisnikDTO;
import aplication.cinema.dto.MovieDTO;
import aplication.cinema.dto.ProjectionDTO;
import aplication.cinema.model.Korisnik;
import aplication.cinema.model.Movies;
import aplication.cinema.model.Projection;
import aplication.cinema.service.MovieService;
import aplication.cinema.service.ProjectionService;
import aplication.cinema.support.MovieDtoToMovie;
import aplication.cinema.support.MovieToMovieDTO;
import aplication.cinema.support.ProjectionToProjectionDTO;

@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated

public class MovieController {

	@Autowired
	private MovieService movieService;

	@Autowired
	private MovieToMovieDTO toDto;

	@Autowired
	private MovieDtoToMovie toMovie;
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private ProjectionToProjectionDTO toProjDto;

	   
	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getOne(@PathVariable Long id) {
		Movies film = movieService.findOne(id);

		if (film != null) {
			return new ResponseEntity<>(toDto.convert(film), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
//	
//	@GetMapping
//	public ResponseEntity<List<MovieDTO>> getAll(){
//		List<Movies> filmovi = movieService.findAll();
//		List<MovieDTO> filmoviDto = toDto.convert(filmovi);
//		
//		return new ResponseEntity<>(filmoviDto, HttpStatus.OK);
//	}
	
	 
	 @GetMapping
	    public ResponseEntity<List<MovieDTO>> getAll(
	    		@RequestParam(required = false) String filmName,
	    		 
	    		@RequestParam(required = false) Integer durationOf,
	    		@RequestParam(required = false) Integer durationTo,
	            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

	        Page<Movies> page;
	       System.out.println(filmName);
	        if(filmName != null   || durationOf != null || durationTo!=null) {
	        	System.out.println("Usao");
	        	page = movieService.find(filmName,   durationOf, durationTo,pageNo);
	        }
	        else {	        	
	        	page = movieService.findAll(pageNo);
	        }
	      

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));
	        
	        return new ResponseEntity<>(toDto.convert(page.getContent()), headers, HttpStatus.OK);
	    }
	
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> create(@Valid @RequestBody MovieDTO movieDto){
        Movies movie = toMovie.convert(movieDto);
        Movies saveMovie = movieService.save(movie);

        return new ResponseEntity<>(toDto.convert(saveMovie), HttpStatus.CREATED);
    }
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
     @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @Valid @RequestBody MovieDTO movieDto){

        if(!id.equals(movieDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Movies movie = toMovie.convert(movieDto);
        Movies saveMovie = movieService.update(movie);

        return new ResponseEntity<>(toDto.convert(saveMovie),HttpStatus.OK);
    }
	
	
    
	    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Movies obrianMovie = movieService.delete(id);

        if(obrianMovie != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
    // @PreAuthorize("hasAnyRole('ROLE_KORISNIK', 'ROLE_ADMIN')")
    @GetMapping("/{id}/projection")
    public ResponseEntity<List<ProjectionDTO>> findByFilmId(@PathVariable @Positive(message = "Id must be positive.")  Long id){
        List<Projection> projekcije = projectionService.findByMovieId(id);

        return new ResponseEntity<>(toProjDto.convert(projekcije), HttpStatus.OK);
    }
    
    
    
    

}