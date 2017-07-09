package negocio;

import java.util.ArrayList;
import java.util.List;

import entities.CuentaCorrienteEntity;
import entities.MovimientoCCEntity;

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

	public CuentaCorrienteEntity toEntity()
	{
		CuentaCorrienteEntity cce = new CuentaCorrienteEntity();
		cce.setConsignacion(this.consignacion);
		cce.setLimiteCredito(this.limiteCredito);
		cce.setSaldo(this.saldo);
		List<MovimientoCCEntity> movs = new ArrayList<MovimientoCCEntity>();
		for (MovimientoCC mcc : this.getMovimientos())
			movs.add(mcc.toEntity());
		cce.setMovimientos(movs);
		return cce;
	}
	
	
}
