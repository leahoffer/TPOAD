package view;

import java.io.Serializable;

import ennumeration.IVA;

public class ClienteVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int legajo;
	private String nombreComercio;
	private String direccion;
	private String telefono;
	private String cuit;
	private IVA iva;
	private CuentaCorrienteVO cuenta;
	
	public ClienteVO() {
		// TODO Auto-generated constructor stub
	}
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
	public CuentaCorrienteVO getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaCorrienteVO cuenta) {
		this.cuenta = cuenta;
	}
	
	
}
