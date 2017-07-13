package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.ItemPedidoP;

@Entity
@Table(name="Items_Pedido_Prenda")
public class ItemPedidoPEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	private int cantidad;
	private float subtotal;
	
	@ManyToOne
	private PrendaEntity prenda;
	
	public ItemPedidoPEntity(){
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

	public PrendaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaEntity prenda) {
		this.prenda = prenda;
	}

	public ItemPedidoP toNegocio() {
		ItemPedidoP ipp = new ItemPedidoP();
		ipp.setCantidad(this.cantidad);
		ipp.setPrenda(this.prenda.toNegocio());
		ipp.setSubtotal(this.subtotal);
		return ipp;
	}
	
	
	
}
