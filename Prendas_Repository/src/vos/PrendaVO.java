package vos;

import java.io.Serializable;

public class PrendaVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1340429982151665292L;
	private PrendaGenericaVO prenda;
	private String color;
	private String talle;
	private boolean enProduccion;
	private float precio;
	private float costo;
	public PrendaVO() {
		// TODO Auto-generated constructor stub
	}
	public PrendaGenericaVO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaGenericaVO prenda) {
		this.prenda = prenda;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTalle() {
		return talle;
	}
	public void setTalle(String talle) {
		this.talle = talle;
	}
	public boolean isEnProduccion() {
		return enProduccion;
	}
	public void setEnProduccion(boolean enProduccion) {
		this.enProduccion = enProduccion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	

}
