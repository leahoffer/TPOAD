package vos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PedidoPrendaVO implements Serializable {

	private static final long serialVersionUID = -3440875924186219766L;
	private ClienteVO cliente;
	private Date fechaGen;
	private float total;
	private List<ItemPedidoPVO> prendas;
	public PedidoPrendaVO() {
		// TODO Auto-generated constructor stub
	}
	public ClienteVO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteVO cliente) {
		this.cliente = cliente;
	}
	public Date getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(Date fechaGen) {
		this.fechaGen = fechaGen;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public List<ItemPedidoPVO> getPrendas() {
		return prendas;
	}
	public void setPrendas(List<ItemPedidoPVO> prendas) {
		this.prendas = prendas;
	}
	public String toString(){
		return this.cliente.getCuit() + " - " + this.cliente.getNombreComercio() + " - " + this.fechaGen.toString();
	}
	
	

}
