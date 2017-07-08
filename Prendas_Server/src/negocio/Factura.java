package negocio;

import java.util.Date;

public class Factura {

	private int numero;
	private Date fecha;
	private String cuit;
	private String razonSocial;
	private String tipo;
	private Cliente cliente;
	private PedidoPrenda pedido;
	private float total;
	private float totalSinIva;
	
	public Factura() {
		super();
		this.cliente = new Cliente();
		this.pedido = new PedidoPrenda();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public PedidoPrenda getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPrenda pedido) {
		this.pedido = pedido;
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
	
	
	
}
