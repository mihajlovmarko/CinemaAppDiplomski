package aplication.cinema.dto;

import java.util.LinkedHashMap;
import java.util.Map;

public class MovieDTO {
	

	private Long id;
	
	private String filmName;
	
	private int duration;
	
	private int year;
	   
	    private String director;
	
	private Map<Long, String> ganres = new LinkedHashMap<>();
	
	
	
	public MovieDTO ( ) {
		
	}

	
	
	public String getDirector() {
		return director;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Map<Long, String> getGanres() {
		return ganres;
	}

	public void setGanres(Map<Long, String> ganres) {
		this.ganres = ganres;
	}
	
	

}
