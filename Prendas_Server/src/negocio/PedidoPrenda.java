package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enumerations.EstadoPedido;

public class PedidoPrenda {

	private Cliente cliente;
	private Date fechaGen;
	private float total;
	private List<ItemPedidoP> prendas;
	private EstadoPedido estado;
	
	public PedidoPrenda() {
		super();
		this.prendas = new ArrayList<ItemPedidoP>();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
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

	public List<ItemPedidoP> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<ItemPedidoP> prendas) {
		this.prendas = prendas;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	
	
}
