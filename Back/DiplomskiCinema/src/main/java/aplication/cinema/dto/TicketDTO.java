package aplication.cinema.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import aplication.cinema.model.Projection;
import aplication.cinema.model.Ticket;

public class TicketDTO {

	private Long id;

	private String seatNumber;

	private String reserved;

	private int price;

	private Long projectionID;
	private Long UserId;
	
	private double PriceProjection;
	
	private String NazivF;
	
	private String datumP;
	
	
	
	
	 
	public String getDatumP() {
		return datumP;
	}
	public void setDatumP(String datumP) {
		this.datumP = datumP;
	}
	public String getNazivF() {
		return NazivF;
	}
	public void setNazivF(String nazivF) {
		NazivF = nazivF;
	}
	public double getPriceProjection() {
		return PriceProjection;
	}
	public void setPriceProjection(double priceProjection) {
		PriceProjection = priceProjection;
	}
	private String UserNamee;
	
	
	public String getUserNamee() {
		return UserNamee;
	}
	public void setUserNamee(String userNamee) {
		UserNamee = userNamee;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getProjectionID() {
		return projectionID;
	}
	public void setProjectionID(Long projectionID) {
		this.projectionID = projectionID;
	}
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	
	

}
