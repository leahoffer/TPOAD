package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Prendas")
public class PrendaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private PrendaGenericaEntity prenda;
	
	@OneToOne(cascade=CascadeType.ALL)
	private ColorEntity color;
	@OneToOne(cascade=CascadeType.ALL)
	private TalleEntity talle;
	
	private boolean enProduccion;
	private double precio;
	private double costo;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<MovStockEntity> movStocks;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DetalleAreaEntity> detAreas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ItemRecetaEntity> itemsReceta;

	public PrendaEntity(){
	}
	
	public void AgregarItem (ItemRecetaEntity i)
	{
		this.itemsReceta.add(i);
	}
	public PrendaGenericaEntity getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaGenericaEntity prenda) {
		this.prenda = prenda;
	}

	public ColorEntity getColor() {
		return color;
	}

	public void setColor(ColorEntity color) {
		this.color = color;
	}

	public TalleEntity getTalle() {
		return talle;
	}

	public void setTalle(TalleEntity talle) {
		this.talle = talle;
	}

	public boolean isEnProduccion() {
		return enProduccion;
	}

	public void setEnProduccion(boolean enProduccion) {
		this.enProduccion = enProduccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public List<MovStockEntity> getMovStocks() {
		return movStocks;
	}

	public void setMovStocks(List<MovStockEntity> movStocks) {
		this.movStocks = movStocks;
	}

	public List<DetalleAreaEntity> getDetAreas() {
		return detAreas;
	}

	public void setDetAreas(List<DetalleAreaEntity> detAreas) {
		this.detAreas = detAreas;
	}

	public List<ItemRecetaEntity> getItemsReceta() {
		return itemsReceta;
	}

	public void setItemsReceta(List<ItemRecetaEntity> itemsReceta) {
		this.itemsReceta = itemsReceta;
	}
	
	
	
}
