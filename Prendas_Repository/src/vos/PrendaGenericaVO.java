package vos;

import java.io.Serializable;
import java.util.List;

public class PrendaGenericaVO implements Serializable{

	private static final long serialVersionUID = 3946585048146793895L;
	private String codigo;
	private String descripcion;
	private int cantTalle;
	private int cantColor;
	private float ganancia;
	private List<String> colores;
	private List<String> talles;
	public PrendaGenericaVO() {
		// TODO Auto-generated constructor stub
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
	public List<String> getColores() {
		return colores;
	}
	public void setColores(List<String> colores) {
		this.colores = colores;
	}
	public List<String> getTalles() {
		return talles;
	}
	public void setTalles(List<String> talles) {
		this.talles = talles;
	}
	public float getGanancia() {
		return ganancia;
	}
	public void setGanancia(float ganancia) {
		this.ganancia = ganancia;
	}
	
	public String toString()
	{
		return codigo+" - "+descripcion;
	}
	
	

}
