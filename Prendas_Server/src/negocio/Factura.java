package negocio;

import java.util.Date;

import daos.FacturaDAO;
import entities.FacturaEntity;

public class Factura {

	private int numero;
	private Date fecha;
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
	
	
	public void saveMe(){
		FacturaDAO.getInstancia().guardarFactura(this.toEntity());
	}
	
	public FacturaEntity toEntity(){
		FacturaEntity fe = new FacturaEntity();
		fe.setCliente(this.cliente.toEntity());
		fe.setFecha(this.fecha);
		fe.setNumero(this.numero);
		fe.setPedidoPrenda(this.pedido.toEntity());
		fe.setTipo(this.tipo);
		fe.setTotal(this.total);
		fe.setTotalSinIva(this.totalSinIva);
		return fe;
	}
	
}
