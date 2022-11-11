package aplication.cinema.dto;

import javax.persistence.Column;

public class GanreDTO {

	private Long id;

	private String nameGanre;

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

}
