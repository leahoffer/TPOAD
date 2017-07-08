package negocio;

public class LoteInsumo {

	private Insumo insumo;
	private float cantidad;
	private UbicacionInsumo ubicacion;
	
	public LoteInsumo() {
		super();
		this.insumo = new Insumo();
		this.ubicacion = new UbicacionInsumo();
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public UbicacionInsumo getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(UbicacionInsumo ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
	
}
