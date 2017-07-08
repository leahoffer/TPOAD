package controlador;

import java.util.ArrayList;
import java.util.List;

import negocio.*;

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
	
	
	
	
}
