package negocio;

import entities.UbicacionPrendaEntity;

public class UbicacionPrenda {

	private Prenda prenda;
	private String calle;
	private int bloque;
	private int estanteria;
	private int posicion;
	private String ubicacion;
	private int cantidad;
	private int reservados;
	
	public int getCantidadNeta()
	{
		return cantidad-reservados;
	}
	public UbicacionPrenda() {
		super();
		this.prenda = new Prenda();
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	
	public String obtenerUbicacion(){
		return calle + String.valueOf(this.bloque) + String.valueOf(this.estanteria) + String.valueOf(this.posicion);
	}
	public UbicacionPrendaEntity toEntity() {
		// TODO Auto-generated method stub
		UbicacionPrendaEntity up= new UbicacionPrendaEntity();
		up.setBloque(this.bloque);
		up.setCalle(this.getCalle());
		up.setCantidad(this.cantidad);
		up.setEstanteria(this.getEstanteria());
		up.setPosicion(this.getPosicion());
		up.setPrenda(this.getPrenda().toEntity());
		up.setReservados(this.getReservados());
		up.setUbicacion(this.getUbicacion());
		return up;
	}
	
	
}
