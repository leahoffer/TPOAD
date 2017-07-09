package entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="Movimientos_CC")
public class MovimientoCCEntity {
	
	@Id
	@GeneratedValue
	private int nro;
	private float monto;
	private Date fecha;
	private boolean positivo;
	public MovimientoCCEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public boolean isPositivo() {
		return positivo;
	}
	public void setPositivo(boolean positivo) {
		this.positivo = positivo;
	}
	
	

}
