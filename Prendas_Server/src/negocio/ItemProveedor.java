package negocio;

public class ItemProveedor {
	
	private Insumo insumo;
	private float precio;
	public ItemProveedor() {
		// TODO Auto-generated constructor stub
		insumo= new Insumo();
	}
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	

}
