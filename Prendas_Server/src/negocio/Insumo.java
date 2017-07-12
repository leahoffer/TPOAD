package negocio;

import entities.InsumoEntity;
import vos.InsumoVO;

public class Insumo {
	
	private String codigo;
	private String nombre;
	private float ptoPedido;
	private float cantAComprar;
	private float precioComprado;
	public Insumo() {
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
	public InsumoEntity toEntity() {
		// TODO Auto-generated method stub
		InsumoEntity res= new InsumoEntity();
		res.setCantAComprar(this.getCantAComprar());
		res.setCodigo(this.getCodigo());
		res.setNombre(this.getNombre());
		res.setPrecioComprado(this.getPrecioComprado());
		res.setPtoPedido(this.getPtoPedido());
		return res;
	}
	
	public InsumoVO toVO(){
		InsumoVO ivo = new InsumoVO();
		ivo.setCantAComprar(this.cantAComprar);
		ivo.setCodigo(this.codigo);
		ivo.setNombre(this.nombre);
		ivo.setPrecioComprado(this.precioComprado);
		ivo.setPtoPedido(this.ptoPedido);
		return ivo;
		
	}
	

}
