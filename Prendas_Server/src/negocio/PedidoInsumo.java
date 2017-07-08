package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoInsumo {

	private int numero;
	private Date fechaGen;
	private Date fechaProbable;
	private Date fechaReal;
	private OrdenProduccion opProveniente;
	private List<LoteInsumo> lotes;
	private List<ItemPedidoI> items;
	
	public PedidoInsumo() {
		super();
		this.opProveniente = new OrdenProduccion();
		this.lotes = new ArrayList<LoteInsumo>();
		this.items = new ArrayList<ItemPedidoI>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getFechaGen() {
		return fechaGen;
	}

	public void setFechaGen(Date fechaGen) {
		this.fechaGen = fechaGen;
	}

	public Date getFechaProbable() {
		return fechaProbable;
	}

	public void setFechaProbable(Date fechaProbable) {
		this.fechaProbable = fechaProbable;
	}

	public Date getFechaReal() {
		return fechaReal;
	}

	public void setFechaReal(Date fechaReal) {
		this.fechaReal = fechaReal;
	}

	public OrdenProduccion getOpProveniente() {
		return opProveniente;
	}

	public void setOpProveniente(OrdenProduccion opProveniente) {
		this.opProveniente = opProveniente;
	}

	public List<LoteInsumo> getLotes() {
		return lotes;
	}

	public void setLotes(List<LoteInsumo> lotes) {
		this.lotes = lotes;
	}

	public List<ItemPedidoI> getItems() {
		return items;
	}

	public void setItems(List<ItemPedidoI> items) {
		this.items = items;
	}
	
	
}
