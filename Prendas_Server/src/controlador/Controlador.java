package controlador;

import java.util.ArrayList;
import java.util.List;

import daos.ClienteDAO;
import daos.InsumoDAO;
import daos.PrendaDAO;
import entities.ClienteEntity;
import entities.InsumoEntity;
import entities.PrendaEntity;
import entities.PrendaGenericaEntity;
import enumerations.Area;
import negocio.*;
import vos.ClienteVO;
import vos.DetalleAreaVO;
import vos.InsumoVO;
import vos.ItemRecetaVO;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

public class Controlador {

	private static Controlador instancia;
	private List<OrdenProduccion> ordenesProduccion;
	private List<Factura> facturas;
	private List<Cliente> clientes;
	private Almacen almacen;
	private List<Prenda> prendas;
	private List<Proveedor> proveedores;
	private List<PrendaGenerica> prendasGenericas;
	
	public static Controlador getInstancia(){
		if (instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	//En vez de crearlos nuevos, quizás deberíamos hacer un DAO.getTodo() para cada tipo
	private Controlador() {
		super();
		this.ordenesProduccion = new ArrayList<OrdenProduccion>();
		this.facturas = new ArrayList<Factura>();
		this.clientes = new ArrayList<Cliente>();
		this.almacen = Almacen.getInstancia();
		this.prendas = new ArrayList<Prenda>();
		this.proveedores = new ArrayList<Proveedor>();
		this.prendasGenericas = new ArrayList<PrendaGenerica>();
	}
	
	
	
	/*
	 * 
	 * ABM CLIENTES
	 * 
	 */
	public void nuevoCliente(ClienteVO c) {
		// TODO Auto-generated method stub
		Cliente cliente= new Cliente();
		cliente.setLegajo(c.getLegajo());
		cliente.setDireccion(c.getDireccion());
		cliente.setNombreComercio(c.getNombreComercio());
		cliente.setTelefono(c.getTelefono());
		cliente.setCuit(c.getCuit());
		CuentaCorriente cc= new CuentaCorriente();
		cc.setLimiteCredito(c.getLimite());
		cc.setConsignacion(c.getConsignacion());
		cliente.setCuenta(cc);
		
		clientes.add(cliente);
		cliente.saveMe();
	}
	
	public ClienteVO buscarClienteVO(int legajo){
		ClienteEntity ce= ClienteDAO.getInstancia().buscarCliente(legajo);
		Cliente c = ce.toNegocio();
		ClienteVO cvo = c.toVO();
		return cvo;
	}
	public void eliminarCliente(ClienteVO cvo) {
		
		ClienteDAO.getInstancia().eliminarCliente(cvo);
		
	}
	
	
	
	/*
	 * 
	 * ABM PRENDAS
	 * 
	 */
	public void nuevaPrenda(PrendaVO pvo) {
		// TODO Auto-generated method stub
		PrendaGenerica pg= new PrendaGenerica();
		pg.setCodigo(pvo.getPrenda().getCodigo());
		pg.setDescripcion(pvo.getPrenda().getDescripcion());
		pg.setCantColor(pvo.getPrenda().getCantColor());
		pg.setCantTalle(pvo.getPrenda().getCantTalle());
		pg.setGanancia(pvo.getPrenda().getGanancia());
		for (String cvo: pvo.getPrenda().getColores())
		{
			pg.getColores().add(new Color(cvo));
		}
		for (String tvo: pvo.getPrenda().getTalles())
		{
			pg.getTalles().add(new Talle(tvo));
		}
		Prenda p= new Prenda();
		p.setPrenda(pg);
		p.setColor(new Color(pvo.getColor()));
		p.setTalle(new Talle(pvo.getTalle()));
		p.setEnProduccion(pvo.isEnProduccion());
		List<DetalleArea> das = new ArrayList<DetalleArea>();
		List<ItemReceta> irs = new ArrayList<ItemReceta>();
		for(ItemRecetaVO irvo : pvo.getReceta())
		{
			ItemReceta ir = new ItemReceta();
			ir.setCantidad(irvo.getCantidad());
			ir.setDesperdicio(irvo.getDesperdicio());
			Insumo i = new Insumo();
			i.setCantAComprar(irvo.getInsumo().getCantAComprar());
			i.setCodigo(irvo.getInsumo().getCodigo());
			i.setNombre(irvo.getInsumo().getNombre());
			i.setPrecioComprado(irvo.getInsumo().getPrecioComprado());
			i.setPtoPedido(irvo.getInsumo().getPtoPedido());
			ir.setInsumo(i);
			irs.add(ir);
		}
		for(DetalleAreaVO davo : pvo.getAreas())
		{
			DetalleArea da = new DetalleArea();
			da.setArea(Area.valueOf(davo.getArea()));
			da.setDuracion(davo.getDuracion());
			das.add(da);
		}
		p.setDetAreas(das);
		p.setItemsReceta(irs);
		p.saveMe();
	}
	
	public List<InsumoVO> mostrarInsumos(){
		List<InsumoEntity> aux = InsumoDAO.getInstancia().traerTodosLosInusmos();
		List<InsumoVO> mostrar = new ArrayList<InsumoVO>();
		for(InsumoEntity ie : aux)
			mostrar.add(ie.toNegocio().toVO());
		return mostrar;
		
	}
	public List<PrendaGenericaVO> mostrarPrendas() {
		// TODO Auto-generated method stub
		List<PrendaGenericaEntity> aux= PrendaDAO.getInstancia().traerTodasLasGenericas();
		List<PrendaGenericaVO> mostrar= new ArrayList<PrendaGenericaVO>();
		for(PrendaGenericaEntity pe: aux)
		{
			PrendaGenericaVO p= new PrendaGenericaVO();
			p.setCodigo(pe.getCodigo());
			p.setDescripcion(pe.getDescripcion());
			p.setCantColor(pe.getCantColor());
			p.setCantTalle(pe.getCantTalle());
			mostrar.add(p);
		}
		return mostrar;
	}
	public void agregarItemReceta(ItemRecetaVO item, PrendaGenericaVO prenda) {
		// TODO Auto-generated method stub
		Insumo insumo= new Insumo();
		insumo.setCantAComprar(item.getInsumo().getCantAComprar());
		insumo.setCodigo(item.getInsumo().getCodigo());
		insumo.setNombre(item.getInsumo().getNombre());
		insumo.setPrecioComprado(item.getInsumo().getPrecioComprado());
		insumo.setPtoPedido(item.getInsumo().getPtoPedido());
		
		ItemReceta i = new ItemReceta();
		i.setCantidad(item.getCantidad());
		i.setDesperdicio(item.getDesperdicio());
		i.setInsumo(insumo);
		
		List<PrendaEntity> prendas= PrendaDAO.getInstancia().traerEspecificas(prenda);
		for (PrendaEntity p: prendas)
		{
			/*Aca es donde tenes que fijarte que segun que PrendaEntity trajiste, cambiar 
			el item para asignarle otra cantidad (mas o menos) 
			segun el talle o (que color es) segun el color. WESA.
			Por ahora no importa que prendaEntity p sea, le agrega el mismo a todas.*/
			PrendaDAO.getInstancia().agregarItemPrendas(i.toEntity(), p);
		}
		
	}
	
}
