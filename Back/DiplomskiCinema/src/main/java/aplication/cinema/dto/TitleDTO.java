package aplication.cinema.dto;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import aplication.cinema.model.Movies;

public class TitleDTO {

	private Long id;

	private String lenguage;

 
	
	private Long movieId;

    private String movieName;
    
    

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLenguage() {
		return lenguage;
	}

	public void setLenguage(String lenguage) {
		this.lenguage = lenguage;
	}

 
	
	

}
