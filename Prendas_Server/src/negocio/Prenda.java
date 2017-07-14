package negocio;

import java.util.ArrayList;
import java.util.List;

import daos.PrendaDAO;
import entities.DetalleAreaEntity;
import entities.ItemRecetaEntity;
import entities.MovStockEntity;
import entities.PrendaEntity;
import vos.PrendaVO;

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
	
	private int idaux;
	
	public int getIdaux() {
		return idaux;
	}

	public void setIdaux(int idaux) {
		this.idaux = idaux;
	}

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

	public void saveMe() {
		// TODO Auto-generated method stub
		PrendaDAO.getInstancia().guardarPrenda(this.toEntity());
	}

	public PrendaEntity toEntity() {
		// TODO Auto-generated method stub
		PrendaEntity p= new PrendaEntity();
		p.setCosto(this.getCosto());
		p.setEnProduccion(this.isEnProduccion());
		p.setPrecio(this.getPrecio());
		p.setPrenda(this.getPrenda().toEntity());
		p.setColor(this.getColor().toEntity());
		p.setTalle(this.getTalle().toEntity());
		
		List<MovStockEntity> movsE= new ArrayList<MovStockEntity>();
		List<DetalleAreaEntity> detsE= new ArrayList<DetalleAreaEntity>();
		List<ItemRecetaEntity> itemsE= new ArrayList<ItemRecetaEntity>();
		
		for (MovStock m: this.movStocks)
		{
			movsE.add(m.toEntity());
		}
		
		for (DetalleArea d: this.detAreas)
		{
			detsE.add(d.toEntity());
		}
		
		for (ItemReceta i: this.itemsReceta)
		{
			itemsE.add(i.toEntity());
		}
		p.setDetAreas(detsE);
		p.setMovStocks(movsE);
		p.setItemsReceta(itemsE);
		p.setId(this.idaux);
		return p;
		
	}
	
	public float obtenerCosto(){
		float costo = 0;
		for(ItemReceta ir : this.getItemsReceta())
			costo = costo + (ir.getInsumo().getPrecioComprado()*ir.getCantidad());
		return costo;
	}
	
	public void calcularCosto(){
		float costo = 0;
		for(ItemReceta ir : this.getItemsReceta())
			costo = costo + (ir.getInsumo().getPrecioComprado()*ir.getCantidad());
		this.costo = costo;
	}

	public void calcularPrecio() {
		this.precio = this.costo * this.getPrenda().getGanancia();
		
	}

	

	public PrendaVO toVO() {
		PrendaVO pvo = new PrendaVO();
		pvo.setColor(this.color.getColor());
		pvo.setCosto(this.costo);
		pvo.setEnProduccion(this.enProduccion);
		pvo.setPrecio(this.precio);
		pvo.setPrenda(this.prenda.toVO());
		pvo.setTalle(this.talle.getTalle());
		return pvo;
	}

	public int calcularStock() {
		int s = 0;
		//Por cada movimiento, calculo el stock que tengo para esta prenda
		for(MovStock ms : this.movStocks)
		{
			//Si es positivo, es un ingreso de stock -> Tengo más. Si es negativo, es un egreso -> tengo menos.
			if(ms.isPositivo())
			{
				s = s + ms.getCant();
			}
			else
			{
				s = s - ms.getCant();
			}
		}
		return s;
	}
	
	
	
	

}
