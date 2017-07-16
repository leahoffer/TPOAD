package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="Pedidos_Insumo")
public class PedidoInsumoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int numero;
	private Date fechaGen;
	@OneToOne
	private OrdenProduccionEntity opProveniente;
	@OneToMany
	private List<LoteInsumoEntity> lotes;
	@OneToMany(cascade=CascadeType.ALL)
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
	
	

}