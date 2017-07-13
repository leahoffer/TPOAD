package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="Prendas_Genericas")
public class PrendaGenericaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	private String descripcion;
	private int cantTalle;
	private int cantColor;
	private double ganancia;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<ColorEntity> colores;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<TalleEntity> talles;
	
	public PrendaGenericaEntity() {
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
	public List<ColorEntity> getColores() {
		return colores;
	}
	public void setColores(List<ColorEntity> colores) {
		this.colores = colores;
	}
	public List<TalleEntity> getTalles() {
		return talles;
	}
	public void setTalles(List<TalleEntity> talles) {
		this.talles = talles;
	}
	public double getGanancia() {
		return ganancia;
	}
	public void setGanancia(double ganancia) {
		this.ganancia = ganancia;
	}
	
	
	
	
	
}
