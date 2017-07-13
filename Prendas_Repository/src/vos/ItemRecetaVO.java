package vos;

import java.io.Serializable;

public class ItemRecetaVO implements Serializable {

	private static final long serialVersionUID = 8853205049195501717L;

	private float cantidad;
	private float desperdicio;
	private InsumoVO insumo;
	
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(float desperdicio) {
		this.desperdicio = desperdicio;
	}
	public InsumoVO getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoVO insumo) {
		this.insumo = insumo;
	}
	
	
}
