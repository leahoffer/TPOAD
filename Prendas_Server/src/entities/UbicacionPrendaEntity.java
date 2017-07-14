package entities;

import javax.persistence.*;

import negocio.UbicacionPrenda;

@Entity
@Table(name="UbicacionesPrenda")
public class UbicacionPrendaEntity {
	
	@Id
	private String ubicacion;
	@ManyToOne
	private PrendaEntity prenda;
	
	private String calle;
	private int bloque;
	private int estanteria;
	private int posicion;
	private int cantidad;
	private int reservados;
	public UbicacionPrendaEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public PrendaEntity getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getBloque() {
		return bloque;
	}
	public void setBloque(int bloque) {
		this.bloque = bloque;
	}
	public int getEstanteria() {
		return estanteria;
	}
	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}
	public int getPosicion() {
		return posicion;
	}
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getReservados() {
		return reservados;
	}
	public void setReservados(int reservados) {
		this.reservados = reservados;
	}
	public UbicacionPrenda toNegocio() {
		// TODO Auto-generated method stub
		UbicacionPrenda up= new UbicacionPrenda();
		up.setBloque(this.getBloque());
		up.setCalle(this.getCalle());
		up.setCantidad(this.getCantidad());
		up.setEstanteria(this.getEstanteria());
		up.setPosicion(this.getPosicion());
		up.setPrenda(this.getPrenda().toNegocio());
		up.setReservados(this.getReservados());
		up.setUbicacion(this.getUbicacion());
		return up;
	}
	
	

}
