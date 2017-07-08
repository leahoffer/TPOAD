package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import business.Cliente;
import business.Color;
import business.CuentaCorriente;
import business.InsumoTC;
import business.ItemPedidoP;
import business.ItemReceta;
import business.PedidoPrenda;
import business.Prenda;
import business.PrendaTC;
import business.RecetaPrenda;
import dao.ClienteDAO;
import dao.InsumoDAO;
import dao.PedidoDAO;
import dao.PrendaDAO;
import ennumeration.EstadoPedido;
import ennumeration.Talle;
import entities.ColorEntity;
import entities.IdPrendaEntity;
import entities.PedidoPrendaEntity;
import entities.PrendaEntity;
import entities.PrendaTCEntity;
import entities.TalleEntity;
import exceptions.ClienteSobreLimiteException;
import exceptions.PedidoNoEncontradoException;
import exceptions.PrendaDiscontinuaException;
import view.ClienteVO;
import view.ColorVO;
import view.CuentaCorrienteVO;
import view.ItemPedidoPVO;
import view.ItemRecetaVO;
import view.MovimientoCCVO;
import view.PedidoPrendaVO;
import view.PrendaTCVO;
import view.PrendaVO;

public class Controlador {
	
	private Vector<Cliente> clientes;
	private static Controlador instancia;
	private Vector<PedidoPrenda> pedidos=new Vector<PedidoPrenda>();
	private Vector<PrendaTC> prendas= new Vector<PrendaTC>();
	private Vector<Prenda> prendas_generales= new Vector<Prenda>();
	
	public static Controlador getInstancia()
	{
		if (instancia == null)
			instancia = new Controlador();
		return instancia;
	}
	
	private Controlador()
	{
		clientes = new Vector<Cliente>();
		clientes = ClienteDAO.getInstancia().traerTodosLosClientes();
	}

	public Vector<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Vector<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	
	//* ABM CLIENTES*//
	public void nuevoCliente(ClienteVO c, float limite)
	{
		Cliente cliente= new Cliente();
		cliente.setNombreComercio(c.getNombreComercio());
		cliente.setDireccion(c.getDireccion());
		cliente.setTelefono(c.getTelefono());
		cliente.setCuit(c.getCuit());
		cliente.setIva(c.getIva());
		cliente.setCuenta(new CuentaCorriente(limite));
		clientes.add(cliente);
		cliente.guardarCliente();
	}

	public Cliente buscarCliente(int legajo)
	{
		return ClienteDAO.getInstancia().traercliente(legajo);
	}
	
	public ClienteVO mostrarCliente(int legajo)
	{
		Cliente c= this.buscarCliente(legajo);
		ClienteVO cvo= new ClienteVO();
		cvo.setNombreComercio(c.getNombreComercio());
		cvo.setDireccion(c.getDireccion());
		cvo.setIva(c.getIva());
		cvo.setTelefono(c.getTelefono());
		return cvo;
	}
	public void eliminarCliente(ClienteVO c) {
		
		ClienteDAO.getInstancia().eliminarCliente(c);
	}
	
	public void modificarCliente (ClienteVO cvo)
	{
		Cliente c = ClienteDAO.getInstancia().traercliente(cvo.getLegajo());
		c.setDireccion(cvo.getDireccion());
		c.setIva(cvo.getIva());
		c.setCuit(cvo.getCuit());
		c.setLegajo(cvo.getLegajo());
		c.setNombreComercio(cvo.getNombreComercio());
		c.setTelefono(cvo.getTelefono());
		ClienteDAO.getInstancia().guardarCliente(c.toEntity());
	}

	public void agregarMovimientoACliente(MovimientoCCVO mccvo, int legajo)
	{
		Cliente c = ClienteDAO.getInstancia().traercliente(legajo);
		c.getCuenta().agregarMovimiento(mccvo.getMonto(), mccvo.isPositivo());
		ClienteDAO.getInstancia().actualizarCliente(c.toEntity());
	}
	
	
	
	
	//*ABM PEDIDOS*//
	/*public int nuevoPedido (PedidoPrendaVO p, int legajo)
	{
		
		PedidoPrenda pedido= new PedidoPrenda();
		pedido.setCliente(this.buscarCliente(legajo));
		pedido.setFechaGen(new Date());
		Vector<ItemPedidoP> items= new Vector<ItemPedidoP>();
		for (ItemPedidoPVO item: p.getItems())
		{
			ItemPedidoP i = new ItemPedidoP();
			i.setPrenda(this.buscarPrendaTC(item.getPrenda())); //falta traer la prenda de la bd
			i.setCantidad(item.getCantidad());
			i.obtenerSubtotal();
			items.add(i);
		}
		pedido.setItems(items);
		pedido.calcularTotal();
		
		try {
			this.validarCliente(pedido);	
		} catch (exceptions.ClienteSobreLimiteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pedido.setEstado(EstadoPedido.Validado);
		System.out.print("Pedido validado. Su numero de pedido es "+pedido.getNumero());
		pedidos.add(pedido);
		try {
			this.verificarPrendasPedido(pedido);
		} catch (PrendaDiscontinuaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pedido.setFechaProbable(addDays(pedido.getFechaGen(), 25)); //seteo como fecha probable 25 dias despues de la validacion del pedido
		System.out.print("Su pedido ha sido aprobado. Su fecha estimada de entrega es el "+pedido.getFechaProbable()+ "y su total estimado es de "+pedido.getTotal());
		
		pedido.saveMe();
		this.validarstock(pedido);
		return pedido.getNumero();
	}*/

	/*nuevoPedido NO VALIDA NADA. Eso lo hará después un botón.
	 * Solo crea pedido. Asocia cliente. Por cada itemPedido en el PedidoVO crea un ItemPedido de negocio con toda la parafarnalia y lo agrega.
	 * Después calcula el total, le manda un saveMe() para guardar en la base, y retorna el numero de pedido autogenerado al cliente*/
	public int nuevoPedido(PedidoPrendaVO ppvo, int legajo)
	{
		PedidoPrenda np = new PedidoPrenda();
		Cliente c = ClienteDAO.getInstancia().traercliente(legajo);
		np.setCliente(c);
		np.setFechaGen(new Date());
		for(ItemPedidoPVO ippvo : ppvo.getItems())
		{
			ItemPedidoP ipp = new ItemPedidoP();
			ipp.setCantidad(ippvo.getCantidad());
			PrendaTCEntity ptce = new PrendaTCEntity();
			ptce.setColor(new ColorEntity(ippvo.getPrenda().getColor().getNombre(), ippvo.getPrenda().getColor().getDescripcion()));
			ptce.setTalle(new TalleEntity(ippvo.getPrenda().getTalle().toString()));
			IdPrendaEntity idpe = new IdPrendaEntity();
			idpe.setCodigo(ippvo.getPrenda().getPvo().getCodigo());
			idpe.setDescripcion(ippvo.getPrenda().getPvo().getDescripcion());
			ptce.setPrenda(new PrendaEntity(idpe));
			PrendaTC ptc = PrendaDAO.getinstancia().traerPrendaTC(ptce);
			ipp.setPrenda(ptc);			
			np.agregarItemAPedido(ipp);
		}
		np.calcularTotal();
		np.setEstado(EstadoPedido.Pendiente);
		np.saveMe();
		return np.getNumero();
	}
	
	private void validarstock(PedidoPrenda pedido) {
		// TODO Auto-generated method stub
		for (ItemPedidoP i: pedido.getItems())
		{
			List<PrendaTC> faltantes= new ArrayList<PrendaTC>();
			if(i.getCantidad()>(i.getPrenda().getStock().calcularStockTotal()))
			{
				faltantes.add(i.getPrenda());
				i.getPrenda().getStock().reservarStock(i.getCantidad());
			}
		}
	}
	

	
	public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
	
	
	//VALIDACIONES PARA PEDIDOS
	public void validarCliente(int numero) throws exceptions.ClienteSobreLimiteException {
		PedidoPrenda pedido = PedidoDAO.getInstancia().buscarPedido(numero);
		if ((pedido.getCliente().getCuenta().getSaldo()+pedido.getTotal())>pedido.getCliente().getCuenta().getLimiteCredito())
		{
			throw new ClienteSobreLimiteException("Este pedido excede su limite total de credito.");
		}
	}
	
	public void validarDiscontinuados(int numero) throws exceptions.PrendaDiscontinuaException, PedidoNoEncontradoException{
		PedidoPrenda pedido = PedidoDAO.getInstancia().buscarPedido(numero);
		if (pedido == null)
			throw new PedidoNoEncontradoException("El pedido no fue encontrado");
		for (ItemPedidoP i: pedido.getItems())
		{
			if(!i.getPrenda().isEnProduccion())
				throw new PrendaDiscontinuaException("Una de las prendas seleccionadas se encuentra discontinuada.");
		}
	}
	
	public void noValidarPedido(int numero)
	{
		PedidoPrenda pp = PedidoDAO.getInstancia().buscarPedido(numero);
		pp.setEstado(EstadoPedido.Cancelado);
		pp.update();
	}
	
	
	//ABM PRENDAS

	private PrendaTC buscarPrendaTC(PrendaTCVO prenda) {
		// TODO Auto-generated method stub
		return null;
	}

	public void crearPrenda (PrendaVO pvo)
	{
		Prenda p = new Prenda();
		p.setCantColorAProducir(pvo.getCantColorAProducir());
		p.setCantTalleAProducir(pvo.getCantTalleAProducir());
		p.setCodigo(pvo.getCodigo());
		p.setDescripcion(pvo.getDescripcion());
		List<Talle> tallesprenda = new ArrayList<Talle>();
		for (String s : pvo.getTalles())
		{
			if(s.equalsIgnoreCase("XS"))
				tallesprenda.add(Talle.XS);
			if(s.equalsIgnoreCase("S"))
				tallesprenda.add(Talle.S);
			if(s.equalsIgnoreCase("M"))
				tallesprenda.add(Talle.M);
			if(s.equalsIgnoreCase("L"))
				tallesprenda.add(Talle.L);
			if(s.equalsIgnoreCase("XL"))
				tallesprenda.add(Talle.XL);
		}
		p.setTalles(tallesprenda);
		for(ColorVO s : pvo.getColores())
			p.getColores().add(new Color(s.getNombre(), s.getDescripcion()));
		prendas_generales.add(p);
		p.saveme();
	}
	
	public void modificarPrenda(PrendaVO pvo)
	{
		Prenda p = PrendaDAO.getinstancia().traerPrenda(pvo.getCodigo());
		p.setCantColorAProducir(pvo.getCantColorAProducir());
		p.setCantTalleAProducir(pvo.getCantTalleAProducir());
		p.setCodigo(pvo.getCodigo());
		p.setDescripcion(pvo.getDescripcion());
		List<Talle> tallesprenda = new ArrayList<Talle>();
		for (String s : pvo.getTalles())
		{
			if(s.equalsIgnoreCase("XS"))
				tallesprenda.add(Talle.XS);
			if(s.equalsIgnoreCase("S"))
				tallesprenda.add(Talle.S);
			if(s.equalsIgnoreCase("M"))
				tallesprenda.add(Talle.M);
			if(s.equalsIgnoreCase("L"))
				tallesprenda.add(Talle.L);
			if(s.equalsIgnoreCase("XL"))
				tallesprenda.add(Talle.XL);
		}
		p.setTalles(tallesprenda);
		for(ColorVO s : pvo.getColores())
			p.getColores().add(new Color(s.getNombre(), s.getDescripcion()));
		p.updateme();
		
	}

	public PrendaVO buscarPrenda(String codigo) {
		Prenda p = PrendaDAO.getinstancia().traerPrenda(codigo);
		PrendaVO pvo = new PrendaVO();
		pvo.setCantColorAProducir(p.getCantColorAProducir());
		pvo.setCantTalleAProducir(p.getCantTalleAProducir());
		pvo.setCodigo(p.getCodigo());
		pvo.setDescripcion(p.getDescripcion());
		List<String> tallesvo = new ArrayList<String>();
		for (Talle t : p.getTalles())
			tallesvo.add(t.toString());
		List<ColorVO> colvo = new ArrayList<ColorVO>();
		for (Color c : p.getColores())
			colvo.add(new ColorVO(c.getNombre()));
		pvo.setColores(colvo);
		pvo.setTalles(tallesvo);
		return pvo;
	}
	
	public void eliminarPrenda(String codigo, String descripcion)
	{
		PrendaEntity pe = new PrendaEntity();
		IdPrendaEntity ipe = new IdPrendaEntity();
		ipe.setCodigo(codigo);
		ipe.setDescripcion(descripcion);
		pe.setId(ipe);
		PrendaDAO.getinstancia().eliminarPrenda(pe);
	}

	public void nuevaPrendaTC(PrendaTCVO ptcvo) {
		// TODO Auto-generated method stub
		Prenda p= new Prenda();
		for (Prenda p2: prendas_generales)
		{
			if (p2.getCodigo().equals(ptcvo.getPvo().getCodigo()))
				p=p2;
		}
		PrendaTC prenda= new PrendaTC();
		prenda.setPrenda(p);
		prenda.setColor(new Color(ptcvo.getColor()));
		prenda.setEnProduccion(true);
		if (ptcvo.getTalle().equals("XS"))
			prenda.setTalle(Talle.XS);
		else if (ptcvo.getTalle().equals("S"))
			prenda.setTalle(Talle.S);
		else if (ptcvo.getTalle().equals("M"))
			prenda.setTalle(Talle.M);
		else if (ptcvo.getTalle().equals("L"))
			prenda.setTalle(Talle.L);
		else if (ptcvo.getTalle().equals("XL"))
			prenda.setTalle(Talle.XL);
		prenda.setReceta(new RecetaPrenda());
		this.prendas.add(prenda);
		PrendaDAO.getinstancia().guardarPrendaTC(prenda.toEntity());
	}
	
	public void agregarInsumos(ItemRecetaVO i, String codigo) {
		// TODO Auto-generated method stub
		List<InsumoTC> insumos= InsumoDAO.getInstancia().traerInsumo(i.getInsumo());
		ItemReceta itemR= new ItemReceta();
		Float c=i.getCantidad();
		itemR.setDesperdicio(i.getDesperdicio());
		for (PrendaTC p: prendas)
		{
			if (p.getPrenda().getCodigo().equals(codigo))
			{
				if (insumos.get(0).getNombre().equals("Tela"))
				{
					if (p.getTalle().equals(Talle.XS))
						itemR.setCantidad(c);
					else if (p.getTalle().equals(Talle.S))
						itemR.setCantidad(c+100);
					else if (p.getTalle().equals(Talle.M))
						itemR.setCantidad(c+200);
					else if (p.getTalle().equals(Talle.L))
						itemR.setCantidad(c+300);
					else if (p.getTalle().equals(Talle.XL))
						itemR.setCantidad(c+400);
				}
				else
					itemR.setCantidad(c);
				
				if (insumos.get(0).getColor().equals(null))
				{
					itemR.setInsumo(insumos.get(0));
				}
				else
				{
					for (InsumoTC itc: insumos)
					{
						if (itc.getColor().getNombre().equals(p.getColor().getNombre()))
							itemR.setInsumo(itc);
						
					}
				}
				p.getReceta().agregarItem(itemR);
				p.saveme();
			}
		
		}
		
	}
	
	//METODOS QUE INVOLUCRAN VO
	public PedidoPrendaVO mostrarPedido(int numero) throws PedidoNoEncontradoException {
		PedidoPrendaVO pvo = new PedidoPrendaVO();
		PedidoPrenda pp = PedidoDAO.getInstancia().buscarPedido(numero);
		if(pp==null)
			throw new PedidoNoEncontradoException("El pedido no fue encontrado");
		ClienteVO cvo = new ClienteVO();
		CuentaCorrienteVO ccvo = new CuentaCorrienteVO();
		ccvo.setConsignacion(pp.getCliente().getCuenta().getConsignacion());
		ccvo.setLimiteCredito(pp.getCliente().getCuenta().getLimiteCredito());
		ccvo.setSaldo(pp.getCliente().getCuenta().getSaldo());
		cvo.setCuenta(ccvo);
		pvo.setCliente(cvo);
		for(ItemPedidoP ipp : pp.getItems())
		{
			ItemPedidoPVO ippvo = new ItemPedidoPVO();
			ippvo.setCantidad(ipp.getCantidad());
			PrendaTCVO ptcvo = new PrendaTCVO();
			ptcvo.setColor(new ColorVO(ipp.getPrenda().getColor().getNombre()));
			ptcvo.setTalle(ipp.getPrenda().getTalle().toString());
			ptcvo.setPvo(this.PrendaToVO(ipp.getPrenda().getPrenda()));
			ippvo.setPrenda(ptcvo);
			pvo.agregarItemVO(ippvo);
		}
		pvo.setNumero(pp.getNumero());
		pvo.setEstado(String.valueOf(pp.getEstado()));
		return pvo;
	}

	private PrendaVO PrendaToVO(Prenda prenda) {
		PrendaVO pvo = new PrendaVO();
		pvo.setCantColorAProducir(prenda.getCantColorAProducir());
		pvo.setCantTalleAProducir(prenda.getCantTalleAProducir());
		pvo.setCodigo(prenda.getCodigo());
		pvo.setDescripcion(prenda.getDescripcion());
		List<ColorVO> colvo = new ArrayList<ColorVO>();
		List<String> tallevo = new ArrayList<String>();
		for(Color c : prenda.getColores())
			colvo.add(new ColorVO(c.getNombre()));
		for(Talle t : prenda.getTalles())
			tallevo.add(String.valueOf(t));
		pvo.setColores(colvo);
		pvo.setTalles(tallevo);
		return pvo;	
	}

	public void confirmarPedido(int numero) {
		try{
			PedidoPrenda pp = PedidoDAO.getInstancia().buscarPedido(numero);
			pp.setEstado(EstadoPedido.Validado);
			int verificar = pp.verificarStock();
			if (verificar == 0)
			{
				pp.reservarStock();
				pp.setEstado(EstadoPedido.Completo);
			}
			else if (verificar == 1)
			{
				pp.reservarStock();
				pp.generarOrdenCompleta();
			}
			else
			{
				
			}
			
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
}
