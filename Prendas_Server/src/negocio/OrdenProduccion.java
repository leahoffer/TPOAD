package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import daos.OrdenProduccionDAO;
import entities.OrdenProduccionEntity;
import entities.PrendaEntity;

public class OrdenProduccion {

	private static final AtomicInteger incrementador = new AtomicInteger(0);
	private int nro;
	private String tipo;
	private Date fecha;
	//Una orden de produccion nunca va a ser de mas de una prenda generica, todas las prendas tienen la misma prendagenerica.
	private List<Prenda> prendas;
	private PedidoPrenda pedido;
	private int cantidadAProducir;
	private String estado;
	
	

	public List<Prenda> getPrendas() {
		return prendas;
	}

	public void setPrendas(List<Prenda> prendas) {
		this.prendas = prendas;
	}

	public OrdenProduccion() {
		super();
		this.prendas= new ArrayList<Prenda>();
		this.pedido = new PedidoPrenda();
		setNro(incrementador.incrementAndGet());
		cantidadAProducir=100;
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

	public void saveMe() {
		// TODO Auto-generated method stub
		OrdenProduccionDAO.getInstancia().guardarOrden(this.toEntity());
	}

	private OrdenProduccionEntity toEntity() {
		// TODO Auto-generated method stub
		OrdenProduccionEntity ope= new OrdenProduccionEntity();
		ope.setCantidadAProducir(this.getCantidadAProducir());
		ope.setEstado(this.getEstado());
		ope.setFecha(new java.sql.Date(this.getFecha().getTime()));
		ope.setNro(this.getNro());
		ope.setPedido(this.getPedido().toEntity());
		ope.setTipo(this.getTipo());
		List<PrendaEntity> prendase= new ArrayList<PrendaEntity>();
		for (Prenda p: this.getPrendas())
		{
			prendase.add(p.toEntity());
		}
		ope.setPrendas(prendase);
		return ope;
	}

	public int getNro() {
		return nro;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}
	
	
	
}
