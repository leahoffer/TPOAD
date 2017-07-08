package negocio;

import java.util.ArrayList;
import java.util.List;

public class PrendaGenerica {

	private String codigo;
	private String descripcion;
	private int cantTalle;
	private int cantColor;
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
	
	
	
}
