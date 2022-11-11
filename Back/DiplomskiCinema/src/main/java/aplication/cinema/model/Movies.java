package aplication.cinema.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Movies {
	
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
 
	    @Column(unique = true, nullable = false)
	    private String filmName;
	    
	    @Column
	    private int year;
	    
	    @Column
	    private String director;
	    
	    
	    @Column
	    private int duration;
	    
	    
	  @OneToMany(mappedBy = "movie",  cascade = CascadeType.ALL)
	  private List<Projection> projekcije = new ArrayList<>();
	  
	  @OneToMany(mappedBy = "movie",  cascade = CascadeType.ALL)
	  private List<Title> titlovi = new ArrayList<>();
	  
	  
	  @ManyToMany
	    @JoinTable(name = "film_genre", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
	            inverseJoinColumns = @JoinColumn(name = "ganre_id", referencedColumnName = "id"))
	    private Set<Ganres> ganres = new HashSet<>();
	  
	  
	    

		public List<Projection> getProjekcije() {
		return projekcije;
	}


	public void setProjekcije(List<Projection> projekcije) {
		this.projekcije = projekcije;
	}


	public List<Title> getTitlovi() {
		return titlovi;
	}


	public void setTitlovi(List<Title> titlovi) {
		this.titlovi = titlovi;
	}


	public Set<Ganres> getGanres() {
		return ganres;
	}


	public void setGanres(Set<Ganres> ganres) {
		this.ganres = ganres;
	}


		public Movies() {
			super();
		}


		public Movies(Long id, String filmName, int year, String director, int duration) {
			super();
			this.id = id;
			this.filmName = filmName;
			this.year = year;
			this.director = director;
			this.duration = duration;
			 
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


		public int getYear() {
			return year;
		}


		public void setYear(int year) {
			this.year = year;
		}


		public String getDirector() {
			return director;
		}


		public void setDirector(String director) {
			this.director = director;
		}


		public int getDuration() {
			return duration;
		}


		public void setDuration(int duration) {
			this.duration = duration;
		}


 
	    
	    
}
