package negocio;

import java.util.Date;

public class MovimientoCC {

	private float monto;
	private Date fecha;
	private boolean positivo;
	
	public MovimientoCC() {
		super();
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
