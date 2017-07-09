package entities;

import java.util.List;
import javax.persistence.*;

import negocio.MovimientoCC;

@Entity
@Table(name="Cuentas_Corrientes")
public class CuentaCorrienteEntity {
	
	@Id
	@GeneratedValue
	private int nroCuenta;
	private float limiteCredito;
	private float consignacion;
	private float saldo;
	@OneToMany(cascade=CascadeType.ALL)
	private List<MovimientoCCEntity> movimientos;
	public CuentaCorrienteEntity() {
		// TODO Auto-generated constructor stub
	}
	public int getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(int nroCuenta) {
		this.nroCuenta = nroCuenta;
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
	public List<MovimientoCCEntity> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<MovimientoCCEntity> movimientos) {
		this.movimientos = movimientos;
	}
	

}