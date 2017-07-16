package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import daos.OrdenProduccionDAO;
import entities.OrdenProduccionEntity;
import entities.PrendaEntity;

public class OrdenProduccion {

	private int nro;
	private String tipo;
	private Date fecha;
	//Una orden de produccion nunca va a ser de mas de una prenda generica, todas las prendas tienen la misma prendagenerica.
	private List<Prenda> prendas;
	private PedidoPrenda pedido;
	private int cantidadAProducir;
	private String estado;
	
	

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public OrdenProduccion() {
		super();
		this.prendas= new ArrayList<Prenda>();
		this.pedido = new PedidoPrenda();
		cantidadAProducir=100;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public PedidoPrenda getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPrenda pedido) {
		this.pedido = pedido;
	}

	public int getCantidadAProducir() {
		return cantidadAProducir;
	}

	public void setCantidadAProducir(int cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void saveMe() {
		// TODO Auto-generated method stub
		OrdenProduccionDAO.getInstancia().guardarOrden(this.toEntity());
	}

	public OrdenProduccionEntity toEntity() {
		// TODO Auto-generated method stub
		OrdenProduccionEntity ope= new OrdenProduccionEntity();
		ope.setCantidadAProducir(this.getCantidadAProducir());
		ope.setEstado(this.getEstado());
		ope.setFecha(new java.sql.Date(this.getFecha().getTime()));
		ope.setNro(this.getNro());
		ope.setPedido(this.getPedido().toEntity());
		ope.setTipo(this.getTipo());
		List<PrendaEntity> prendase= new ArrayList<PrendaEntity>();
		for (Prenda p: this.getPrendas())
		{
			prendase.add(p.toEntity());
		}
		ope.setPrendas(prendase);
		return ope;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}
	
	public void validarInsumos() {
		// TODO Auto-generated method stub
		List<ItemReceta> items= new ArrayList<ItemReceta>();
		
		/*Convierto las prendas en sus items, asi tengo directamente un vector de TODOS los items (insumos repetidos)*/
		for (Prenda p: this.prendas)
		{
			for (ItemReceta i: p.getItemsReceta())
			{
				items.add(i);
			}
		}
		//Por cada item, primero pregunto si ya esta en mis items resultado, si no esta, lo agrego
		//y si ya esta, le sumo la cantidad que necesito a la cantidad total que necesito. Mis items resultado va a ser
		//una lista de insumos DIFERENTES y la cantidad que necesito EN TOTAL para completar esa orden.
		List<ItemPedidoI> itemspedidoaux= new ArrayList<ItemPedidoI>();
		for (ItemReceta ir: items)
		{
			if (ir.getInsumo().noEstaEn(itemspedidoaux))
			{
				ItemPedidoI ip= new ItemPedidoI(ir.getInsumo());
				ip.setCantidad(ir.getCantidad());
				itemspedidoaux.add(ip);
			}
			else
			{
				ir.getInsumo().agregarA(itemspedidoaux, ir.getCantidad());
			}
		}
		//Recorro estos items resultado (itemspedidoaux) verificando si tengo stock de cada uno
		//Agrego a insumosSinStock los items pedido de los cuales no tengo suficiente stock de insumo
		//para cubrir la cantidad TOTAL de ese insumo que necesito.
		List<ItemPedidoI> insumosSinStock= new ArrayList<ItemPedidoI>();
		for (ItemPedidoI ipp: itemspedidoaux)
		{
			if (Almacen.getInstancia().traerStockInsumo(ipp.getInsumo())<ipp.getCantidad())
				{
					ipp.setCantidad(ipp.getInsumo().getCantAComprar());
					insumosSinStock.add(ipp);
				}
		}
		//Creo el pedido de insumos con estos insumos sin stock
		if (!insumosSinStock.isEmpty())
		{
			PedidoInsumo p= new PedidoInsumo();
			p.setFechaGen(new Date());
			p.setItems(insumosSinStock);
			p.setNumero(10); //cambiar esto por los autogenerados
			p.setOpProveniente(this);
			p.saveMe();
			
		}
		else
		{
			this.setEstado("Completa");
			//Aca hay que ver que corno pasa cuando completas una orden usea
		}
		
	}
	
}
