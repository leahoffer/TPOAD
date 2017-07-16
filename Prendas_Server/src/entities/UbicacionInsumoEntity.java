package entities;

import java.io.Serializable;

import javax.persistence.*;

import entities.InsumoEntity;
import negocio.UbicacionInsumo;

@Entity
@Table(name="UbicacionesInsumo")
public class UbicacionInsumoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String ubicacion;
	@ManyToOne
	private InsumoEntity insumo;
	private String calle;
	private int bloque;
	private int estanteria;
	private int posicion;
	
	private float cantidad;
	private float reservados;
	public UbicacionInsumoEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
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
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	public UbicacionInsumo toNegocio() {
		// TODO Auto-generated method stub
		UbicacionInsumo ui= new UbicacionInsumo();
		ui.setBloque(this.getBloque());
		ui.setCalle(this.getCalle());
		ui.setCantidad(this.getCantidad());
		ui.setEstanteria(this.getEstanteria());
		ui.setInsumo(this.getInsumo().toNegocio());
		ui.setPosicion(this.getPosicion());
		ui.setUbicacion(this.getUbicacion());
		this.setReservados(this.getReservados());
		return ui;
	}
	public float getReservados() {
		return reservados;
	}
	public void setReservados(float reservados) {
		this.reservados = reservados;
	}
	public float getCantidadNeta() {
		// TODO Auto-generated method stub
		return cantidad-reservados;
	}
	
	
}