package negocio;

import entities.ItemPedidoPEntity;
import vos.ItemPedidoPVO;

public class ItemPedidoP {

	private int cantidad;
	private float subtotal;
	private Prenda prenda;
	
	public ItemPedidoP() {
		super();
		this.prenda = new Prenda();
	}

	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}


	public void calcularSubtotal() {
		// TODO Auto-generated method stub
		subtotal=this.prenda.getPrecio();
	}


	public ItemPedidoPEntity toEntity() {
		// TODO Auto-generated method stub
		ItemPedidoPEntity ie= new ItemPedidoPEntity();
		ie.setCantidad(this.getCantidad());
		ie.setSubtotal(this.getSubtotal());
		ie.setPrenda(this.getPrenda().toEntity());
		return ie;
	}


	public ItemPedidoPVO toVO() {
		ItemPedidoPVO ippvo = new ItemPedidoPVO();
		ippvo.setCantidad(this.cantidad);
		ippvo.setPrenda(this.prenda.toVO());
		ippvo.setSubtotal(this.subtotal);
		return ippvo;
	}


	public boolean validarStock() {
		//Si la prenda tiene stock mayor o igual a la cantidad que pide el Item, sale por true. Si tiene stock menor a la cantidad pedida, sale por false.
		if(this.prenda.calcularStock() >= this.cantidad)
			return true;
		return false;
	}
	
	
	
}
