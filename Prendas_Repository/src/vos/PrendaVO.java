package vos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrendaVO implements Serializable {

	private static final long serialVersionUID = 1340429982151665292L;
	private PrendaGenericaVO prenda;
	private String color;
	private String talle;
	private boolean enProduccion;
	private float precio;
	private float costo;
	private List<ItemRecetaVO> receta;
	private List<DetalleAreaVO> areas;
	public PrendaVO() {
		this.receta = new ArrayList<ItemRecetaVO>();
		this.areas = new ArrayList<DetalleAreaVO>();
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
	
	public void setPrecio(){
		this.precio = this.costo * this.getPrenda().getGanancia();
	}
	public List<ItemRecetaVO> getReceta() {
		return receta;
	}
	public void setReceta(List<ItemRecetaVO> receta) {
		this.receta = receta;
	}
	public List<DetalleAreaVO> getAreas() {
		return areas;
	}
	public void setAreas(List<DetalleAreaVO> areas) {
		this.areas = areas;
	}

	public void agregarItem(ItemRecetaVO irvo){
		this.receta.add(irvo);
	}
	
	
}
