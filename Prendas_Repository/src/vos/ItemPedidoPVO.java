package vos;

import java.io.Serializable;

public class ItemPedidoPVO implements Serializable{
	
	private int cantidad;
	private double subtotal;
	private PrendaVO prenda;
	public ItemPedidoPVO() {
		// TODO Auto-generated constructor stub
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
	public PrendaVO getPrenda() {
		return prenda;
	}
	public void setPrenda(PrendaVO prenda) {
		this.prenda = prenda;
	}
	

}
