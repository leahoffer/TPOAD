package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.Color;

@Entity
@Table(name="Colores")
public class ColorEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String color;

	public ColorEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Color toNegocio() {
		Color c = new Color(this.color);
		return c;
	}
	
	
	
	
	

}
