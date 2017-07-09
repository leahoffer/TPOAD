package negocio;

import java.util.Date;

import entities.MovStockEntity;

public class MovStock {

	private Date fecha;
	private float monto;
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
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
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
		res.setMonto(this.getMonto());
		res.setPositivo(this.isPositivo());
		return res;
	}
	
	
}
