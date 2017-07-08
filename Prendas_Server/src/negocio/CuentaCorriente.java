package negocio;

import java.util.ArrayList;
import java.util.List;

public class CuentaCorriente {

	private float limiteCredito;
	private float consignacion;
	private float saldo;
	private List<MovimientoCC> movimientos;
	
	public CuentaCorriente() {
		super();
		this.movimientos = new ArrayList<MovimientoCC>();
	}

	public float getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(float limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public float getConsignacion() {
		return consignacion;
	}

	public void setConsignacion(float consignacion) {
		this.consignacion = consignacion;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public List<MovimientoCC> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<MovimientoCC> movimientos) {
		this.movimientos = movimientos;
	}

	
	
	
}
