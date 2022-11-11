package aplication.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aplication.cinema.model.Projection;
import aplication.cinema.model.Title;
import aplication.cinema.repository.ProjectionRepository;
import aplication.cinema.service.ProjectionService;

@Service
public class JpaProjectionService  implements ProjectionService{

	@Autowired
	private ProjectionRepository projectionRepository;
	
	@Override
	public Projection findOne(Long id) {
	return projectionRepository.findOneById(id);
	}

	@Override
	public List<Projection> findAll() {
		return projectionRepository.findAll();
	}

	@Override
	public Page<Projection> findAll(Pageable pageable) {
		 return projectionRepository.findAll(pageable);
	}

	@Override
	public Projection save(Projection projection) {
		 return projectionRepository.save(projection);
	}

	@Override
	public Projection update(Projection projection) {
	 return projectionRepository.save(projection);
	}

	@Override
	public Projection delete(Long id) {
		 Optional<Projection> m = projectionRepository.findById(id);
	        if(m.isPresent()){
	            projectionRepository.deleteById(id);
	            return m.get();
	        }
	        return null;
	}

	@Override
	public Page<Projection> findAll(int brojStranice) {
	return projectionRepository.findAll(PageRequest.of(brojStranice, 10));
	}

	@Override
	public List<Projection> findByMovieId(Long filmId) {
	 return projectionRepository.findByMovieId(filmId);
	}

}
