package controlador;

import java.util.ArrayList;
import java.util.List;

import negocio.*;
import vo.ClienteVO;

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
	
	
	
	
}
