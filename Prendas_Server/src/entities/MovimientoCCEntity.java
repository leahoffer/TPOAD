package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import negocio.MovimientoCC;

@Entity
@Table(name="Movimientos_CC")
public class MovimientoCCEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
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
	public MovimientoCC toNegocio() {
		MovimientoCC mcc = new MovimientoCC();
		mcc.setFecha(this.getFecha());
		mcc.setMonto(this.getMonto());
		mcc.setPositivo(this.isPositivo());
		return mcc;
	}
	
	

}
