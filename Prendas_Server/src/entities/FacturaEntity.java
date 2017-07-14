package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import negocio.Factura;

@Entity
@Table(name="Facturas")
public class FacturaEntity implements Serializable{
	private static final long serialVersionUID = -9024352129033975974L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numero;
	
	private Date fecha;
	private String tipo;
	
	@OneToOne(fetch=FetchType.EAGER)
	private ClienteEntity cliente;
	
	@OneToOne(fetch=FetchType.EAGER)
	private PedidoPrendaEntity pedidoPrenda;
	
	private float total;
	private float totalSinIva;
	
	
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	public PedidoPrendaEntity getPedidoPrenda() {
		return pedidoPrenda;
	}
	public void setPedidoPrenda(PedidoPrendaEntity pedidoPrenda) {
		this.pedidoPrenda = pedidoPrenda;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTotalSinIva() {
		return totalSinIva;
	}
	public void setTotalSinIva(float totalSinIva) {
		this.totalSinIva = totalSinIva;
	}
	
	public Factura toNegocio(){
		Factura f = new Factura();
		f.setCliente(this.cliente.toNegocio());
		f.setFecha(this.fecha);
		f.setNumero(this.numero);
		f.setPedido(this.pedidoPrenda.toNegocio());
		f.setTipo(this.tipo);
		f.setTotal(this.total);
		f.setTotalSinIva(this.totalSinIva);
		return f;
	}
	
}
