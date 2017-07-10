package negocio;

import java.util.ArrayList;
import java.util.List;

import entities.ColorEntity;
import entities.PrendaGenericaEntity;
import entities.TalleEntity;

public class PrendaGenerica {

	private String codigo;
	private String descripcion;
	private int cantTalle;
	private int cantColor;
	private float ganancia;
	private List<Color> colores;
	private List<Talle> talles;
	
	public PrendaGenerica() {
		// TODO Auto-generated constructor stub
		colores= new ArrayList<Color>();
		talles= new ArrayList<Talle>();
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantTalle() {
		return cantTalle;
	}

	public void setCantTalle(int cantTalle) {
		this.cantTalle = cantTalle;
	}

	public int getCantColor() {
		return cantColor;
	}

	public void setCantColor(int cantColor) {
		this.cantColor = cantColor;
	}

	public List<Color> getColores() {
		return colores;
	}

	public void setColores(List<Color> colores) {
		this.colores = colores;
	}

	public List<Talle> getTalles() {
		return talles;
	}

	public void setTalles(List<Talle> talles) {
		this.talles = talles;
	}

	public float getGanancia() {
		return ganancia;
	}

	public void setGanancia(float ganancia) {
		this.ganancia = ganancia;
	}
	
	public PrendaGenericaEntity toEntity() {
		// TODO Auto-generated method stub
		PrendaGenericaEntity res= new PrendaGenericaEntity();
		res.setCodigo(this.getCodigo());
		res.setDescripcion(this.getDescripcion());
		res.setCantColor(this.getCantColor());
		res.setCantTalle(this.getCantTalle());
		res.setGanancia(this.getGanancia());
		List<ColorEntity> colores= new ArrayList<ColorEntity>();
		List<TalleEntity> talles= new ArrayList<TalleEntity>();
		
		for (Color c: this.getColores())
		{
			colores.add(c.toEntity());
		}
		
		for (Talle t: this.getTalles())
		{
			talles.add(t.toEntity());
		}
		
		return res;
		
	}

	
	
	
	
}
