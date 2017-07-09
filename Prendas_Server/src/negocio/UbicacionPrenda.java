package negocio;

public class UbicacionPrenda {

	private Prenda prenda;
	private String calle;
	private int bloque;
	private int estanteria;
	private int posicion;
	private String ubicacion;
	private int cantidad;
	private int reservados;
	
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
	
	
}
