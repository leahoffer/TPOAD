package vos;

import java.io.Serializable;

public class ItemRecetaVO implements Serializable {

	private static final long serialVersionUID = 8853205049195501717L;

	private double cantidad;
	private double desperdicio;
	private InsumoVO insumo;
	
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	public double getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(double desperdicio) {
		this.desperdicio = desperdicio;
	}
	public InsumoVO getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoVO insumo) {
		this.insumo = insumo;
	}
	
	
}
