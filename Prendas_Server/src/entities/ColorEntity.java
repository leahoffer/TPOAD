package entities;

import java.io.Serializable;

import javax.persistence.*;

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
	
	
	
	
	

}
