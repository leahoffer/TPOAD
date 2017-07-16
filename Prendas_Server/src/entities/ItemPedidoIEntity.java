package entities;

import java.io.Serializable;

import javax.persistence.*;

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
	
	public ItemPedidoIEntity toEntity() {
		// TODO Auto-generated method stub
		ItemPedidoIEntity res= new ItemPedidoIEntity();
		res.setCantidad(this.getCantidad());
		res.setInsumo(this.getInsumo().toEntity());
		return res;
	}
	

}