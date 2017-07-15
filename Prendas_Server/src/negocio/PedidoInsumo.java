package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import daos.PedidoDAO;
import entities.ItemPedidoIEntity;
import entities.LoteInsumoEntity;
import entities.PedidoInsumoEntity;

public class PedidoInsumo {

	private int numero;
	private Date fechaGen;
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

	public void saveMe() {
		// TODO Auto-generated method stub
		PedidoDAO.getInstancia().guardarPedidoInsumo(this.toEntity());
	}

	public PedidoInsumoEntity toEntity() {
		// TODO Auto-generated method stub
		PedidoInsumoEntity pie= new PedidoInsumoEntity();
		pie.setFechaGen(new java.sql.Date(this.getFechaGen().getTime()));
		pie.setNumero(this.getNumero());
		pie.setOpProveniente(this.getOpProveniente().toEntity());
		List<LoteInsumoEntity> lotes= new ArrayList<LoteInsumoEntity>();
		List<ItemPedidoIEntity> items= new ArrayList<ItemPedidoIEntity>();
		for (LoteInsumo li: this.getLotes())
		{
			lotes.add(li.toEntity());
		}
		for (ItemPedidoI ip: this.getItems())
		{
			items.add(ip.toEntity());
		}
		pie.setLotes(lotes);
		pie.setItems(items);
		return pie;
	}
	
	
}
