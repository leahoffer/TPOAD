package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdenProduccion {

	private String tipo;
	private Date fecha;
	private List<Talle> talles;
	private List<Color> colores;
	private PedidoPrenda pedido;
	private int cantidadAProducir;
	private String estado;
	
	public OrdenProduccion() {
		super();
		this.talles = new ArrayList<Talle>();
		this.colores = new ArrayList<Color>();
		this.pedido = new PedidoPrenda();
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

	public List<Talle> getTalles() {
		return talles;
	}

	public void setTalles(List<Talle> talles) {
		this.talles = talles;
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	public PedidoPrenda getPedido() {
		return pedido;
	}

	public void setPedido(PedidoPrenda pedido) {
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
