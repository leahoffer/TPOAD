package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daos.PedidoDAO;
import entities.ItemPedidoPEntity;
import entities.PedidoPrendaEntity;
import enumerations.EstadoPedido;

public class PedidoPrenda {

	private Cliente cliente;
	private Date fechaGen;
	private double total;
	private List<ItemPedidoP> prendas;
	private EstadoPedido estado;
	private int nro;
	
	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
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

	public void calcularTotal() {
		// TODO Auto-generated method stub
		double totalaux=0;
		for (ItemPedidoP i: prendas)
		{
			totalaux=totalaux+i.getSubtotal();
		}
		this.total=totalaux;
	}

	public void saveMe() {
		// TODO Auto-generated method stub
		PedidoDAO.getInstancia().guardarPedido(this.toEntity());
	}

	private PedidoPrendaEntity toEntity() {
		// TODO Auto-generated method stub
		PedidoPrendaEntity pe= new PedidoPrendaEntity();
		pe.setCliente(this.getCliente().toEntity());
		pe.setEstado(this.getEstado().toString());
		pe.setFechaGen(new java.sql.Date(this.getFechaGen().getTime()));
		pe.setTotal(this.getTotal());
		List<ItemPedidoPEntity> itemspe= new ArrayList<ItemPedidoPEntity>();
		for (ItemPedidoP i: this.prendas)
		{
			itemspe.add(i.toEntity());
		}
		pe.setNumero(1);
		pe.setItems(itemspe);
		return pe;
		
		
	}
	
	
	
}
