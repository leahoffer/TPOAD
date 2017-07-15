package controlador;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daos.ClienteDAO;
import daos.InsumoDAO;
import daos.OrdenProduccionDAO;
import daos.PedidoDAO;
import daos.PrendaDAO;
import entities.ClienteEntity;
import entities.InsumoEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import entities.PrendaGenericaEntity;
import enumerations.Area;
import enumerations.EstadoPedido;
import negocio.*;
import vos.ClienteVO;
import vos.DetalleAreaVO;
import vos.InsumoVO;
import vos.ItemPedidoPVO;
import vos.ItemRecetaVO;
import vos.PedidoPrendaVO;
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
			i.setColor(new Color(irvo.getInsumo().getColor()));
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
		p.calcularCosto();
		p.calcularPrecio();
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
			
			PrendaDAO.getInstancia().agregarItemPrendas(i.toEntity(), p);
		}
		
	}
	
	
	
	
	/*
	 *ABM PEDIDOS 
	 */
	public void nuevoPedido(PedidoPrendaVO pvo) {
		// TODO Auto-generated method stub
		Cliente c= this.traerClientePorPK(pvo.getCliente().getLegajo());
		PedidoPrenda p= new PedidoPrenda();
		p.setCliente(c);
		p.setEstado(EstadoPedido.Pendiente);
		p.setFechaGen(pvo.getFechaGen());
		List <ItemPedidoP> items= new ArrayList<ItemPedidoP>();
		for (ItemPedidoPVO ivo: pvo.getPrendas())
		{
			ItemPedidoP i= new ItemPedidoP();
			i.setCantidad(ivo.getCantidad());
			i.setPrenda(this.traerPrendaEspecificaPorPK(ivo.getPrenda()));
			i.calcularSubtotal();
			items.add(i);
		}
		p.setPrendas(items);
		p.calcularTotal();
		p.saveMe();
	}
	
	private Prenda traerPrendaEspecificaPorPK(PrendaVO prenda) {
		// TODO Auto-generated method stub
		PrendaEntity p= PrendaDAO.getInstancia().traerEspecifica(prenda);
		return p.toNegocio();
	}
	private Cliente traerClientePorPK(int legajo) {
		// TODO Auto-generated method stub
		ClienteEntity c=ClienteDAO.getInstancia().buscarCliente(legajo);
		return c.toNegocio();
	}
	
	public List<PedidoPrendaVO> mostrarPedidosAValidar()
	{
		List<PedidoPrendaVO> res = new ArrayList<PedidoPrendaVO>();
		List<PedidoPrendaEntity> pedidos = PedidoDAO.getInstancia().mostrarPedidosSinValidar();
		for(PedidoPrendaEntity ppe : pedidos)
			res.add(ppe.toNegocio().toVO());
		return res;
	}
	
	
	
	
	
	
	/*
	 * VALIDACIÓN DE PEDIDOS + VERIFICAR STOCK
	 */
	public void validarPedido(PedidoPrendaVO selectedValue) {
		//Traigo la prenda po PK
		PedidoPrenda pp = PedidoDAO.getInstancia().buscarPedido(selectedValue.getNumero());
		//Boolean para validar si todo ok
		boolean pedidosok = true;
		//Busco todos los ItemPedido. Si al menos uno no está en producción, entonces pedido NO OK
		for(ItemPedidoP ipp : pp.getPrendas())
		{
			if (!ipp.getPrenda().isEnProduccion())
			{
				pedidosok = false;
			}
		}
		if(!pedidosok)
		{
			//Pedido tiene al menos un item con prenda NO en producción. De última mandar throw diciendo que prenda no está en producción
			pp.setEstado(EstadoPedido.Invalido);
		}
		//Si todas las prendas del Pedido están en producción, valido el saldo del cliente
		else
		{
			if(pp.getCliente().validarSaldo(pp))
			{
				//Si cliente tiene saldo, sigo adelante validando stock
				pp.setEstado(EstadoPedido.Validado);
				pp.updatearEstadoPedido();
				validarStockPedidoPrenda(pp);
				
			}
			else
			{
				//Si cliente no tiene saldo, Pedido es invalido y de última mandar mensaje con throw diciendo que el cliente ponga la tarasca
				pp.setEstado(EstadoPedido.Invalido);
			}
		}
		
	}
	
	private void validarStockPedidoPrenda(PedidoPrenda pp) {
		List<Prenda> sinstock = pp.validarStock();
		//Si validacion=true entonces tengo stock
		if(sinstock.isEmpty())
		{
			pp.completarPedido();
			/*
			 *Revisar datos de Factura. Razon Social, Cuit quizás no hace falta porque ya guardo un Cliente.
			 *Tipo depende de si el Cliente es Responsable Inscripto... pero igual si todos nuestros clientes son comercios... le puse a todos tipo "A"
			 *
			 */
			/*Factura f = new Factura();
			f.setCliente(pp.getCliente());
			f.setFecha(new Date());
			f.setPedido(pp);
			f.setTipo("A");
			f.setTotal(pp.getTotal());
			f.setTotalSinIva((float) (pp.getTotal()/(1.21)));*/
			
		}
		else
		{
			//Acá hay que ver el caso de si es OPP u OPC.
			int i=0;
			pp.setEstado(EstadoPedido.Incompleto);
			pp.updatearEstadoPedido();
			while(!sinstock.isEmpty())
			{
				List<Prenda> prendasMismaGenerica = new ArrayList<Prenda>();
				prendasMismaGenerica.add(sinstock.get(i));
				sinstock.remove(i);
				String codigo=prendasMismaGenerica.get(0).getPrenda().getCodigo();
				while ((!sinstock.isEmpty()) && (sinstock.get(i).getPrenda().getCodigo().equals(codigo)))
				{
					while((!sinstock.isEmpty()) && (sinstock.get(i).getPrenda().getCodigo().equals(codigo)))
					{
						prendasMismaGenerica.add(sinstock.get(i));
						sinstock.remove(i);
					}
				}
				if (!prendasMismaGenerica.isEmpty())
				{
					if (prendasMismaGenerica.size()>=3)
						this.nuevaOPCompleta(prendasMismaGenerica.get(0).getPrenda(), pp);
					else
						this.nuevaOPParcial(prendasMismaGenerica, pp);
				}
			}
					
			
		}
	}
	private void nuevaOPParcial(List<Prenda> prendasMismaGenerica, PedidoPrenda pp) {
		// TODO Auto-generated method stub
		 OrdenProduccion op= new OrdenProduccion();
		 op.setEstado("Incompleta");
		 op.setFecha(new Date());
		 op.setPedido(pp);
		 op.setPrendas(prendasMismaGenerica);
		 op.setTipo("Parcial");
		 op.saveMe();
		 op.validarInsumos();
		
	}
	private void nuevaOPCompleta(PrendaGenerica prenda, PedidoPrenda pp) {
		// TODO Auto-generated method stub
		OrdenProduccion op= new OrdenProduccion();
		op.setEstado("Incompleta");
		op.setFecha(new Date());
		op.setPedido(pp);
		op.setTipo("Completa");
		List<Prenda> prendas= new ArrayList<Prenda>();
		for (Color c:prenda.getColores())
		{
			for (Talle t:prenda.getTalles())
			{
				PrendaVO pvo= new PrendaVO();
				pvo.setColor(c.getColor());
				pvo.setTalle(t.getTalle());
				pvo.setPrenda(new PrendaGenericaVO(prenda.getCodigo()));
				Prenda p = PrendaDAO.getInstancia().traerEspecifica(pvo).toNegocio();
				prendas.add(p);
			}
		}
		op.setPrendas(prendas);
		op.saveMe();
		op.validarInsumos();
	}
	
	
	public void completarOrdenProduccion(int numero){
		OrdenProduccion op = OrdenProduccionDAO.getInstancia().traerOrden(numero);
		op.setEstado("Completa");
		for(Prenda p : op.getPrendas())
		{
			p.AgregarMovimientoStock(op.getCantidadAProducir(), true);
			p.updateMe();
		}
		Almacen.getInstancia().colocarPrendas(op);
		
		
		
	}
	
}
