package entities;
import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="Items_Receta")
public class ItemRecetaEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	private float cantidad;
	private float desperdicio;
	@OneToOne(cascade=CascadeType.ALL)
	private InsumoEntity insumo;
	public ItemRecetaEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	
	
}
