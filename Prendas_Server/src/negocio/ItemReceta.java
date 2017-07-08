package negocio;

public class ItemReceta {
	
	private float cantidad;
	private float desperdicio;
	private Insumo insumo;
	
	public ItemReceta() {
		// TODO Auto-generated constructor stub
		insumo= new Insumo();
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	
	

}
