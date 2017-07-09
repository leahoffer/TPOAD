package entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Detalles_Area")
public class DetalleAreaEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	private float duracion;
	private String area;
	public DetalleAreaEntity() {
		// TODO Auto-generated constructor stub
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	

}
