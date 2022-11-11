package aplication.cinema.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;

import aplication.cinema.model.Ticket;

public class ProjectionDTO {

	private Long id;

	private String dateAndTime;

	private double price;
	
    private Long filmId;

    private String filmNaziv;
    
    private Integer Theatre;
    
    
    
 

	public Integer getTheatre() {
		return Theatre;
	}

	public void setTheatre(Integer theatre) {
		Theatre = theatre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getFilmId() {
		return filmId;
	}

	public void setFilmId(Long filmId) {
		this.filmId = filmId;
	}

	public String getFilmNaziv() {
		return filmNaziv;
	}

	public void setFilmNaziv(String filmNaziv) {
		this.filmNaziv = filmNaziv;
	}
    
    

	 

}
