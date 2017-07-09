package entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Colores")
public class ColorEntity implements Serializable{
	
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
	
	
	
	
	

}
