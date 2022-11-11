package aplication.cinema.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import aplication.cinema.model.Title;

 

public interface TitleService {
	
	Title findOne(Long id);

	List<Title> findAll();

	Page<Title> findAll(Pageable pageable);

	Title save(Title movie);

	Title update(Title movie);

	Title delete(Long id);

	Page<Title> findAll(int brojStranice);

}
