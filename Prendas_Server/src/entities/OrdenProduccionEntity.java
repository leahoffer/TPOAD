package entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Ordenes_Produccion")
public class OrdenProduccionEntity {

	@Id
	private int nro;
	private String tipo;
	private Date fecha;
	//Una orden de produccion nunca va a ser de mas de una prenda generica, todas las prendas tienen la misma prendagenerica.
	@OneToMany
	private List<PrendaEntity> prendas;
	@ManyToOne
	private PedidoPrendaEntity pedido;
	private int cantidadAProducir;
	private String estado;
	public OrdenProduccionEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public List<PrendaEntity> getPrendas() {
		return prendas;
	}
	public void setPrendas(List<PrendaEntity> prendas) {
		this.prendas = prendas;
	}
	public PedidoPrendaEntity getPedido() {
		return pedido;
	}
	public void setPedido(PedidoPrendaEntity pedido) {
		this.pedido = pedido;
	}
	public int getCantidadAProducir() {
		return cantidadAProducir;
	}
	public void setCantidadAProducir(int cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
