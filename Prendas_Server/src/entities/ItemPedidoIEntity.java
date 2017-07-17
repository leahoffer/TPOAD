package entities;

import java.io.Serializable;

import javax.persistence.*;

import negocio.ItemPedidoI;

@Entity
@Table(name="Items_Pedido_Insumos")
public class ItemPedidoIEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private InsumoEntity insumo;
	private float cantidad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public ItemPedidoIEntity() {
		// TODO Auto-generated constructor stub
	}
	public ItemPedidoI toNegocio() {
		ItemPedidoI ipi = new ItemPedidoI();
		ipi.setCantidad(this.cantidad);
		ipi.setInsumo(this.insumo.toNegocio());
		return ipi;
	}
	
	
	

}