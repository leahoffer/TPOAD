package negocio;

import entities.ItemRecetaEntity;

public class ItemReceta {
	
	private double cantidad;
	private double desperdicio;
	private Insumo insumo;
	
	public ItemReceta() {
		// TODO Auto-generated constructor stub
		insumo= new Insumo();
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(double desperdicio) {
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
