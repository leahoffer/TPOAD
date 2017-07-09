package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Predas")
public class PrendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PrendaGenericaEntity prenda;
	
	private String color;
	private String talle;
	private boolean enProduccion;
	private float precio;
	private float costo;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<MovStockEntity> movStocks;

	public PrendaEntity(){
	}
	
	public PrendaGenericaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaGenericaEntity prenda) {
		this.prenda = prenda;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public boolean isEnProduccion() {
		return enProduccion;
	}

	public void setEnProduccion(boolean enProduccion) {
		this.enProduccion = enProduccion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public List<MovStockEntity> getMovStocks() {
		return movStocks;
	}

	public void setMovStocks(List<MovStockEntity> movStocks) {
		this.movStocks = movStocks;
	}
	
	
	
}
