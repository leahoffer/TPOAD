package vo;

import java.io.Serializable;

public class ClienteVO implements Serializable{
	
	private int legajo;
	private String nombreComercio;
	private String direccion;
	private String telefono;
	private String cuit;
	
	private float limite;
	private float consignacion;
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
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	public float getConsignacion() {
		return consignacion;
	}
	public void setConsignacion(float consignacion) {
		this.consignacion = consignacion;
	}
	
	

}
