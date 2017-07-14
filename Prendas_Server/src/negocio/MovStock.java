package negocio;

import java.util.Date;

import entities.MovStockEntity;

public class MovStock {

	private Date fecha;
	private int cant;
	private boolean positivo;
	public MovStock() {
		// TODO Auto-generated constructor stub
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public boolean isPositivo() {
		return positivo;
	}
	public void setPositivo(boolean positivo) {
		this.positivo = positivo;
	}
	public MovStockEntity toEntity() {
		// TODO Auto-generated method stub
		MovStockEntity res= new MovStockEntity();
		res.setFecha((java.sql.Date) this.getFecha());
		res.setCant(this.getCant());
		res.setPositivo(this.isPositivo());
		return res;
	}
	
	
}
