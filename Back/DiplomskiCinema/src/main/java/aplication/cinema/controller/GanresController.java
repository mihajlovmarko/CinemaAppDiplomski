package aplication.cinema.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplication.cinema.dto.GanreDTO;
import aplication.cinema.dto.MovieDTO;
import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;
import aplication.cinema.service.GanresService;
import aplication.cinema.support.GanreDtoToGanre;
import aplication.cinema.support.GanresToGanresDTO;

@RestController
@RequestMapping(value="/api/ganres", produces = MediaType.APPLICATION_JSON_VALUE)
public class GanresController {

	@Autowired
	private GanresService ganreService;
	
	
	@Autowired
	private GanreDtoToGanre toGanre;
	
	@Autowired
	private GanresToGanresDTO toDto;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<GanreDTO> getOne(@PathVariable Long id) {
		Ganres ganre = ganreService.findOne(id);

		if (ganre != null) {
			return new ResponseEntity<>(toDto.convert(ganre), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<GanreDTO>> getAll(){
		List<Ganres> ganres = ganreService.findAll();
		List<GanreDTO> ganresDto = toDto.convert(ganres);
		
		return new ResponseEntity<>(ganresDto, HttpStatus.OK);
	}
	
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GanreDTO> create(@Valid @RequestBody GanreDTO ganreDto){
        Ganres ganre = toGanre.convert(ganreDto);
        Ganres saveGanre = ganreService.save(ganre);

        return new ResponseEntity<>(toDto.convert(saveGanre), HttpStatus.CREATED);
    }
    
    
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GanreDTO> update(@PathVariable Long id, @Valid @RequestBody GanreDTO ganreDto){

        if(!id.equals(ganreDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ganres ganre = toGanre.convert(ganreDto);
        Ganres saveGanres = ganreService.update(ganre);

        return new ResponseEntity<>(toDto.convert(saveGanres),HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Ganres obrisanGanre = ganreService.delete(id);

        if(obrisanGanre != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
	
}
    
}
