package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import daos.PedidoDAO;
import entities.ItemPedidoPEntity;
import entities.PedidoPrendaEntity;
import enumerations.EstadoPedido;
import vos.ItemPedidoPVO;
import vos.PedidoPrendaVO;

public class PedidoPrenda {

	private static AtomicInteger instanciador= new AtomicInteger(0);
	private Cliente cliente;
	private Date fechaGen;
	private float total;
	private List<ItemPedidoP> prendas;
	private EstadoPedido estado;
	private int nro;
	private List<UbicacionPrenda> ubicaciones;
	
	
	public List<UbicacionPrenda> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(List<UbicacionPrenda> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public PedidoPrenda() {
		super();
		this.prendas = new ArrayList<ItemPedidoP>();
		this.nro=instanciador.incrementAndGet();
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

	
	public PedidoPrendaEntity toEntity() {
		// TODO Auto-generated method stub
		PedidoPrendaEntity pe= new PedidoPrendaEntity();
		pe.setCliente(this.getCliente().toEntity());
		pe.setEstado(this.getEstado().toString());
		pe.setFechaGen(new java.sql.Date(this.getFechaGen().getTime()));
		pe.setTotal(this.getTotal());
		Set<ItemPedidoPEntity> itemspe= new HashSet<ItemPedidoPEntity>();
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

	public List<Prenda> validarStock() {
		//Por cada item, veo si la prenda para ESE item tiene stock. Si NO tiene, sale por false. Si todas tienen, sale por true.
		List<Prenda> sinstock= new ArrayList<Prenda>();
		
		for(ItemPedidoP ipp : this.prendas)
		{
			if(!ipp.validarStock())
				sinstock.add(ipp.getPrenda());
		}
		return sinstock;
		
	}

	public void completarPedido() {
		/* Llego ac� solo si todos los items del pedido dieron OK en el stock.
		 * Le digo al Almacen que reserve el stock para cada prenda de este pedido.
		 * FALTA COMPLETAR EL METODO RESERVARSTOCK DEL ALMACEN
		 */
		Almacen.getInstancia().reservarStock(this);
		//Seteo el estado como Completo.
		this.estado = EstadoPedido.Completo;
		PedidoDAO.getInstancia().guardarPedido(this.toEntity());
	}

	public void updatearEstadoPedido() {
		// TODO Auto-generated method stub
		PedidoDAO.getInstancia().updatearEstadoPedido(this);
	}
	
	
	
}
