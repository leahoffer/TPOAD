package entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="Lotes_Insumo")
public class LoteInsumoEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private InsumoEntity insumo;
	private float cantidad;
	@ManyToOne
	private UbicacionInsumoEntity ubicacion;
	public LoteInsumoEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public InsumoEntity getInsumo() {
		return insumo;
	}
	public void setInsumo(InsumoEntity insumo) {
		this.insumo = insumo;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public UbicacionInsumoEntity getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(UbicacionInsumoEntity ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	
}