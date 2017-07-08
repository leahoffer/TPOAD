package negocio;

public class UbicacionInsumo {

	private Insumo insumo;
	private String calle;
	private int bloque;
	private int estanteria;
	private int posicion;
	private String ubicacion;
	private float cantidad;
	private float reservados;
	
	public UbicacionInsumo() {
		super();
		this.insumo = new Insumo();
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
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

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public float getReservados() {
		return reservados;
	}

	public void setReservados(float reservados) {
		this.reservados = reservados;
	}
	
	
	
	
	
}
