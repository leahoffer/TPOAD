package entities;

import java.sql.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.*;

import business.Cliente;
import business.ItemPedidoP;
import ennumeration.EstadoPedido;
@Entity
@Table(name="pedidosdeprendas")
public class PedidoPrendaEntity {
	
	@Id
	private int numero;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private ClienteEntity cliente;
	
	private Date fechaGen;
	private Date fechaProbable;
	private Date fechaReal;
	private float total;

	String estado;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pedido")
	List<ItemPedidoPEntity> items;
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
	public Date getFechaProbable() {
		return fechaProbable;
	}
	public void setFechaProbable(Date fechaProbable) {
		this.fechaProbable = fechaProbable;
	}
	public Date getFechaReal() {
		return fechaReal;
	}
	public void setFechaReal(Date fechaReal) {
		this.fechaReal = fechaReal;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public List<ItemPedidoPEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoPEntity> items) {
		this.items = items;
	}

}
