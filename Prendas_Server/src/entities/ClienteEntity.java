package entities;

import javax.persistence.*;

@Entity
@Table(name="Clientes")
public class ClienteEntity {
	
	@Id
	private int legajo;
	private String nombreComercio;
	private String direccion;
	private String telefono;
	private String cuit;
	@OneToOne(cascade=CascadeType.ALL)
	private CuentaCorrienteEntity cc;
	public ClienteEntity() {
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
	public CuentaCorrienteEntity getCc() {
		return cc;
	}
	public void setCc(CuentaCorrienteEntity cc) {
		this.cc = cc;
	}
	
	

}
