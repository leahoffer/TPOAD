package negocio;

import entities.ItemPedidoIEntity;

public class ItemPedidoI {
	
	private Insumo insumo;
	private float cantidad;
	public ItemPedidoI() {
		// TODO Auto-generated constructor stub
		
		insumo= new Insumo();
	}
	
	public ItemPedidoI(Insumo i) {
		// TODO Auto-generated constructor stub
		insumo=i;
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
	
	public ItemPedidoIEntity toEntity() {
		// TODO Auto-generated method stub
		ItemPedidoIEntity res= new ItemPedidoIEntity();
		res.setCantidad(this.getCantidad());
		res.setInsumo(this.getInsumo().toEntity());
		return res;
	}

}
