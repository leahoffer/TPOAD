package negocio;

import entities.ItemRecetaEntity;

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
	public ItemRecetaEntity toEntity() {
		// TODO Auto-generated method stub
		ItemRecetaEntity res= new ItemRecetaEntity();
		res.setCantidad(this.getCantidad());
		res.setDesperdicio(this.getDesperdicio());
		res.setInsumo(this.getInsumo().toEntity());
		return res;
	}
	
	

}
