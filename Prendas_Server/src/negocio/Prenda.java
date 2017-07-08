package negocio;

import java.util.ArrayList;
import java.util.List;

public class Prenda {
	
	private PrendaGenerica prenda;
	private Color color;
	private Talle talle;
	private boolean enProduccion;
	private float precio;
	private float costo;
	
	private List<MovStock> movStocks;
	private List<DetalleArea> detAreas;
	private List<ItemReceta> itemsReceta;
	
	public Prenda() {
		// TODO Auto-generated constructor stub
		movStocks= new ArrayList<MovStock>();
		detAreas= new ArrayList<DetalleArea>();
		itemsReceta= new ArrayList<ItemReceta>();
		prenda= new PrendaGenerica();
		color= new Color();
		talle= new Talle();
	}

	public PrendaGenerica getPrenda() {
		return prenda;
	}

	public void setPrenda(PrendaGenerica prenda) {
		this.prenda = prenda;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Talle getTalle() {
		return talle;
	}

	public void setTalle(Talle talle) {
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

	public List<MovStock> getMovStocks() {
		return movStocks;
	}

	public void setMovStocks(List<MovStock> movStocks) {
		this.movStocks = movStocks;
	}

	public List<DetalleArea> getDetAreas() {
		return detAreas;
	}

	public void setDetAreas(List<DetalleArea> detAreas) {
		this.detAreas = detAreas;
	}

	public List<ItemReceta> getItemsReceta() {
		return itemsReceta;
	}

	public void setItemsReceta(List<ItemReceta> itemsReceta) {
		this.itemsReceta = itemsReceta;
	}
	
	
	
	
	
	
	

}
