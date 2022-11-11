package aplication.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import aplication.cinema.model.Movies;
import aplication.cinema.model.Title;
import aplication.cinema.repository.TitleRepository;
import aplication.cinema.service.TitleService;

@Service
public class JpaTitleService implements TitleService {

	@Autowired
	private  TitleRepository titleRepository;
	
	@Override
	public Title findOne(Long id) {
	 return titleRepository.findOneById(id);
	}

	@Override
	public List<Title> findAll() {
	return titleRepository.findAll();
	}

	@Override
	public Page<Title> findAll(Pageable pageable) {
		 return titleRepository.findAll(pageable);
	}

	@Override
	public Title save(Title title) {
		return titleRepository.save(title);
	}

	@Override
	public Title update(Title title) {
	return titleRepository.save(title);
	}

	@Override
	public Title delete(Long id) {
		 Optional<Title> m = titleRepository.findById(id);
	        if(m.isPresent()){
	            titleRepository.deleteById(id);
	            return m.get();
	        }
	        return null;
	}

	@Override
	public Page<Title> findAll(int brojStranice) {
		return titleRepository.findAll(PageRequest.of(brojStranice, 10));
	}

}
