package business;

import java.util.concurrent.atomic.AtomicInteger;

import dao.ClienteDAO;
import ennumeration.IVA;
import entities.ClienteEntity;
import entities.MovimientoCCEntity;

public class Cliente 
{
	private static AtomicInteger legajo_generador = new AtomicInteger(1000);
	
	private int legajo;
	private String nombreComercio;
	private String direccion;
	private String telefono;
	private String cuit;
	private IVA iva;
	private CuentaCorriente cuenta;
	
	public Cliente(String nombreComercio, String direccion,
			String telefono, String cuit, IVA iva, CuentaCorriente cuenta) {
		super();
		this.legajo = legajo_generador.incrementAndGet();
		this.nombreComercio = nombreComercio;
		this.direccion = direccion;
		this.telefono = telefono;
		this.cuit = cuit;
		this.iva = iva;
		this.cuenta = cuenta;
	}
	
	public Cliente(){
		this.legajo = legajo_generador.incrementAndGet();
	};
	
	public int getLegajo() {
		return legajo;
	}
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	public String getNombreComercio() {
		return nombreComercio;
	}
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public IVA getIva() {
		return iva;
	}
	public void setIva(IVA iva) {
		this.iva = iva;
	}
	public CuentaCorriente getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}
	
	public void crearCuentaCorriente(float limite)
	{
		this.cuenta = new CuentaCorriente(limite);
		
	}

	public void guardarCliente() {
		// TODO Auto-generated method stub
		ClienteDAO.getInstancia().guardarCliente(this.toEntity());
	}
	
	public float traerSaldoCliente()
	{
		return this.getCuenta().calcularSaldo();
	}
	
	public ClienteEntity toEntity()
	{
		ClienteEntity ce = new ClienteEntity();
		ce.setLegajo(this.getLegajo());
		ce.setNombreComercio(this.getNombreComercio());
		ce.setDireccion(this.getDireccion());
		ce.setTelefono(this.getTelefono());
		ce.setCuit(this.getCuit());
		ce.setIva(this.getIva());
		
		ce.setCuentaCorriente(this.getCuenta().toEntity());
		
		return ce;
	}
	
	
}
