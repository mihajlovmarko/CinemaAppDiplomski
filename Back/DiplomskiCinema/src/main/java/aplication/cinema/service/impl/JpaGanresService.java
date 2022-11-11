package aplication.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aplication.cinema.model.Ganres;
import aplication.cinema.model.Movies;
import aplication.cinema.repository.GanresRepository;
import aplication.cinema.repository.MovieRepository;
import aplication.cinema.service.GanresService;

@Service
public class JpaGanresService  implements GanresService{

	@Autowired
	private GanresRepository ganresRepository;
	
	@Override
	public Ganres findOne(Long id) {
		 
		return ganresRepository.findOneById(id);
	}

	@Override
	public List<Ganres> findAll() {
		 return ganresRepository.findAll();
	}

	 
	@Override
	public Ganres save(Ganres ganre) {
	return ganresRepository.save(ganre);
	}

	@Override
	public Ganres update(Ganres ganre) {
		 return ganresRepository.save(ganre);
	}

	@Override
	public Ganres delete(Long id) {
		Optional<Ganres> m = ganresRepository.findById(id);
        if(m.isPresent()){
            ganresRepository.deleteById(id);
            return m.get();
        }
        return null;
	}

	@Override
	public Page<Ganres> findAll(int brojStranice) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Movies> find(String filmName, String director, Integer durationOf, Integer durationTo, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	  @Override
	    public List<Ganres> find(List<Long> ids) {
	        return ganresRepository.findByIdIn(ids);
	    }

	@Override
	public List<Ganres> find(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

 
}
