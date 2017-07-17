package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import negocio.ItemPedidoI;
import negocio.LoteInsumo;
import negocio.OrdenProduccion;
import negocio.PedidoInsumo;


@Entity
@Table(name="Pedidos_Insumo")
public class PedidoInsumoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numero;
	private Date fechaGen;
	private String estado;
	@OneToOne
	private OrdenProduccionEntity opProveniente;
	@OneToMany
	private List<LoteInsumoEntity> lotes;
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ItemPedidoIEntity> items;
	public PedidoInsumoEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(Date fechaGen) {
		this.fechaGen = fechaGen;
	}
	public OrdenProduccionEntity getOpProveniente() {
		return opProveniente;
	}
	public void setOpProveniente(OrdenProduccionEntity opProveniente) {
		this.opProveniente = opProveniente;
	}
	public List<LoteInsumoEntity> getLotes() {
		return lotes;
	}
	public void setLotes(List<LoteInsumoEntity> lotes) {
		this.lotes = lotes;
	}
	public List<ItemPedidoIEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemPedidoIEntity> items) {
		this.items = items;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public PedidoInsumo toNegocio() {
		PedidoInsumo pi = new PedidoInsumo();
		pi.setNumero(this.numero);
		pi.setEstado(this.estado);
		pi.setFechaGen(this.fechaGen);
		OrdenProduccion op = new OrdenProduccion();
		op.setNro(this.opProveniente.getNro());
		pi.setOpProveniente(op);
		List<ItemPedidoI> items = new ArrayList<ItemPedidoI>();
		List<LoteInsumo> lotes = new ArrayList<LoteInsumo>();
		for(ItemPedidoIEntity ipie : this.items)
			items.add(ipie.toNegocio());
		pi.setItems(items);
		pi.setLotes(lotes);
		return pi;
	}
	
	

}