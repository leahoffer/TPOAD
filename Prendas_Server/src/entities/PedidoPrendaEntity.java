package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Pedidos_Prenda")
public class PedidoPrendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int numero;
	
	@ManyToOne(cascade=CascadeType.ALL)
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
	
	
	
	
}
