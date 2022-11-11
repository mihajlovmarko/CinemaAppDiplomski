package aplication.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import aplication.cinema.model.Movies;
import aplication.cinema.repository.MovieRepository;
import aplication.cinema.service.MovieService;

@Service
public class JpaMovieService implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movies findOne(Long id) {
		return movieRepository.findOneById(id);
	}

	@Override
	public List<Movies> findAll() {
		return movieRepository.findAll();
	}

	@Override
	public Page<Movies> findAll(int brojStranice) {
		return movieRepository.findAll(PageRequest.of(brojStranice,10));
	}

	@Override
	public Movies save(Movies movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movies update(Movies movie) {
		return movieRepository.save(movie);
	}

	@Override
	public Movies delete(Long id) {
		 Optional<Movies> m = movieRepository.findById(id);
	        if(m.isPresent()){
	            movieRepository.deleteById(id);
	            return m.get();
	        }
	        return null;
	}
	@Override
	public Page<Movies> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Movies> find(String filmName, Integer durationOf, Integer durationTo, int pageNo) {
		if(filmName == null) {
			filmName = "";
		}
		
		 
		
		if(durationOf == null) {
			durationOf=0;
		}
		if(durationTo == null) {
			durationTo=Integer.MAX_VALUE;
		}
		
		
         return movieRepository.findByFilmNameIgnoreCaseContainsAndDurationBetween(filmName, durationOf,durationTo, PageRequest.of(pageNo, 4));

	}

 
}

 
