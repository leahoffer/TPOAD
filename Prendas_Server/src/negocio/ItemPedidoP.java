package negocio;

import entities.ItemPedidoPEntity;

public class ItemPedidoP {

	private int cantidad;
	private double subtotal;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
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
	
	
	
}
