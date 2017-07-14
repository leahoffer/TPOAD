package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import enumerations.EstadoPedido;
import negocio.Cliente;
import negocio.ItemPedidoP;
import negocio.PedidoPrenda;

@Entity
@Table(name="Pedidos_Prenda")
public class PedidoPrendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue()
	private Integer numero;
	
	@ManyToOne
	private ClienteEntity cliente;
	
	private Date fechaGen;
	private float total;
	private String estado;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ItemPedidoPEntity> items;

	public PedidoPrendaEntity(){
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public Date getFechaGen() {
		return fechaGen;
	}

	public void setFechaGen(Date fechaGen) {
		this.fechaGen = fechaGen;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<ItemPedidoPEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoPEntity> items) {
		this.items = items;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PedidoPrenda toNegocio() {
		PedidoPrenda pp = new PedidoPrenda();
		pp.setCliente(this.cliente.toNegocio());
		pp.setEstado(EstadoPedido.valueOf(this.estado));
		pp.setFechaGen(this.fechaGen);
		pp.setNro(this.numero);
		pp.setTotal(this.total);
		List<ItemPedidoP> its = new ArrayList<ItemPedidoP>();
		for(ItemPedidoPEntity ippe : this.getItems())
			its.add(ippe.toNegocio());
		pp.setPrendas(its);
		return pp;
	}
	
	
	
	
}
