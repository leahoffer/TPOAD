package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import enumerations.Area;
import negocio.Color;
import negocio.DetalleArea;
import negocio.ItemReceta;
import negocio.MovStock;
import negocio.Prenda;
import negocio.PrendaGenerica;
import negocio.Talle;

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
	private float precio;
	private float costo;
	
	@OneToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<MovStockEntity> movStocks;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<DetalleAreaEntity> detAreas;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<ItemRecetaEntity> itemsReceta;

	public PrendaEntity(){
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public Prenda toNegocio() {
		// TODO Auto-generated method stub
		
		Prenda p= new Prenda();
		p.setPrenda(this.getPrenda().toNegocio());
		p.setColor(new Color(this.getColor().getColor()));
		p.setTalle(new Talle(this.getTalle().getTalle()));
		p.setEnProduccion(this.isEnProduccion());
		p.setPrecio(this.getPrecio());
		p.setCosto(this.getCosto());
		List<DetalleArea> dets= new ArrayList<DetalleArea>();
		List<ItemReceta> items= new ArrayList<ItemReceta>();
		List<MovStock> movs= new ArrayList<MovStock>();
		for (DetalleAreaEntity de: this.getDetAreas())
		{
			DetalleArea d= new DetalleArea();
			d.setArea(Area.valueOf(de.getArea()));
			d.setDuracion(de.getDuracion());
			dets.add(d);
		}
		for (MovStockEntity me:this.getMovStocks())
		{
			MovStock m= new MovStock();
			m.setFecha(me.getFecha());
			m.setCant(me.getCant());
			m.setPositivo(me.isPositivo());
			movs.add(m);
			
		}
		for (ItemRecetaEntity ie: this.getItemsReceta())
		{
			ItemReceta i= new ItemReceta();
			i.setCantidad(ie.getCantidad());
			i.setDesperdicio(ie.getDesperdicio());
			i.setInsumo(ie.getInsumo().toNegocio());
			items.add(i);
		}
		p.setItemsReceta(items);
		p.setDetAreas(dets);
		p.setMovStocks(movs);
		p.setIdaux(this.id);
		return p;
		}
	
	
	
}
