package vos;

import java.io.Serializable;

public class DetalleAreaVO implements Serializable {

	private static final long serialVersionUID = -2439476375400139185L;

	private float duracion;
	private String area;
	
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
