package negocio;

import entities.DetalleAreaEntity;
import enumerations.Area;

public class DetalleArea {

	private float duracion;
	private Area area;
	
	public DetalleArea() {
		// TODO Auto-generated constructor stub
	}
	public float getDuracion() {
		return duracion;
	}
	public void setDuracion(float duracion) {
		this.duracion = duracion;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public DetalleAreaEntity toEntity() {
		// TODO Auto-generated method stub
		DetalleAreaEntity res= new DetalleAreaEntity();
		res.setDuracion(this.getDuracion());
		res.setArea(this.getArea().toString());
		return res;
	}
	
	
}
