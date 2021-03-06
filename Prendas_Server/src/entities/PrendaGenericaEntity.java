package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;


import negocio.Color;
import negocio.PrendaGenerica;
import negocio.Talle;

@Entity
@Table(name="Prendas_Genericas")
public class PrendaGenericaEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String codigo;
	
	private String descripcion;
	private int cantTalle;
	private int cantColor;
	
	
	private float ganancia;
		
	@OneToMany
	private List<ColorEntity> colores;
		
	@OneToMany
	private List<TalleEntity> talles;
	
	
	public List<ColorEntity> getColores() {
		return colores;
	}
	public void setColores(List<ColorEntity> colores) {
		this.colores = colores;
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


	public List<TalleEntity> getTalles() {
		return talles;
	}
	public void setTalles(List<TalleEntity> talles) {
		this.talles = talles;
	}
	public float getGanancia() {
		return ganancia;
	}
	public void setGanancia(float ganancia) {
		this.ganancia = ganancia;
	}
	public PrendaGenerica toNegocio() {
		// TODO Auto-generated method stub
		PrendaGenerica pg= new PrendaGenerica();
		
		pg.setCantColor(this.getCantColor());
		pg.setCantTalle(this.getCantTalle());
		pg.setCodigo(this.getCodigo());
		pg.setDescripcion(this.getDescripcion());
		pg.setGanancia(this.getGanancia());
		List<Color> colores= new ArrayList<Color>();
		List<Talle> talles= new ArrayList<Talle>();
		for (ColorEntity c: this.getColores())
		{
			colores.add(new Color(c.getColor()));
		}
		for (TalleEntity t: this.getTalles())
		{
			talles.add(new Talle(t.getTalle()));
		}
		return pg;
	}

	
	
	
	
	
}
