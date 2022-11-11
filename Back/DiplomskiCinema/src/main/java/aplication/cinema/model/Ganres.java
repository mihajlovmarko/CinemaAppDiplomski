package aplication.cinema.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ganres {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column (nullable = false)
    private String nameGanre;
    
    
    @ManyToMany(mappedBy = "ganres",  cascade = CascadeType.ALL)
    private Set<Movies> movies = new HashSet<>();
 
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameGanre() {
		return nameGanre;
	}


	public void setNameGanre(String nameGanre) {
		this.nameGanre = nameGanre;
	}


	public Set<Movies> getMovies() {
		return movies;
	}


	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
	
    
    
}
