package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daos.PedidoDAO;
import entities.ItemPedidoPEntity;
import entities.PedidoPrendaEntity;
import enumerations.EstadoPedido;
import vos.ItemPedidoPVO;
import vos.PedidoPrendaVO;

public class PedidoPrenda {

	private Cliente cliente;
	private Date fechaGen;
	private float total;
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

	public void calcularTotal() {
		// TODO Auto-generated method stub
		float totalaux=0;
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
		pe.setNumero(this.nro);
		pe.setItems(itemspe);
		return pe;
		
		
	}

	public PedidoPrendaVO toVO() {
		PedidoPrendaVO ppvo = new PedidoPrendaVO();
		ppvo.setCliente(this.cliente.toVO());
		ppvo.setFechaGen(this.fechaGen);
		ppvo.setTotal(this.total);
		List<ItemPedidoPVO> its = new ArrayList<ItemPedidoPVO>();
		for(ItemPedidoP ipp : this.prendas)
			its.add(ipp.toVO());
		ppvo.setPrendas(its);
		ppvo.setNumero(this.nro);
		return ppvo;
	}

	public boolean validarStock() {
		//Por cada item, veo si la prenda para ESE item tiene stock. Si NO tiene, sale por false. Si todas tienen, sale por true.
		for(ItemPedidoP ipp : this.prendas)
		{
			if(!ipp.validarStock())
				return false;
		}
		return true;
		
	}

	public void completarPedido() {
		/* Llego acá solo si todos los items del pedido dieron OK en el stock.
		 * Le digo al Almacen que reserve el stock para cada prenda de este pedido.
		 * FALTA COMPLETAR EL METODO RESERVARSTOCK DEL ALMACEN
		 */
		Almacen.getInstancia().reservarStock(this);
		//Seteo el estado como Completo.
		this.estado = EstadoPedido.Completo;
	}
	
	
	
}
