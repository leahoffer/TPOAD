package entities;
import java.io.Serializable;

import javax.persistence.*;

import negocio.Insumo;

@Entity
@Table(name="Insumos")
public class InsumoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String codigo;
	private String nombre;
	private float ptoPedido;
	private float cantAComprar;
	private float precioComprado;
	
	@OneToOne(fetch=FetchType.EAGER)
	private ColorEntity color;
	
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
	
	public ColorEntity getColor() {
		return color;
	}
	public void setColor(ColorEntity color) {
		this.color = color;
	}
	public Insumo toNegocio(){
		Insumo i = new Insumo();
		i.setCantAComprar(this.cantAComprar);
		i.setCodigo(this.codigo);
		i.setNombre(this.nombre);
		i.setPrecioComprado(this.precioComprado);
		i.setPtoPedido(this.ptoPedido);
		i.setColor(this.getColor().toNegocio());
		return i;
	}
	
}
