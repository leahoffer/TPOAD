package entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Insumos")
public class InsumoEntity implements Serializable{

	@Id
	private String codigo;
	private String nombre;
	private float ptoPedido;
	private float cantAComprar;
	private float precioComprado;
	public InsumoEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPtoPedido() {
		return ptoPedido;
	}
	public void setPtoPedido(float ptoPedido) {
		this.ptoPedido = ptoPedido;
	}
	public float getCantAComprar() {
		return cantAComprar;
	}
	public void setCantAComprar(float cantAComprar) {
		this.cantAComprar = cantAComprar;
	}
	public float getPrecioComprado() {
		return precioComprado;
	}
	public void setPrecioComprado(float precioComprado) {
		this.precioComprado = precioComprado;
	}
	
	
}
