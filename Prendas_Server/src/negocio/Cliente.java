package negocio;

import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.MovimientoCCEntity;

public class Cliente {

	private int legajo;
	private String nombreComercio;
	private String direccion;
	private String telefono;
	private String cuit;
	private CuentaCorriente cuenta;
	
	public Cliente() {
		super();
		this.cuenta = new CuentaCorriente();
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombreComercio() {
		return nombreComercio;
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public CuentaCorriente getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorriente cuenta) {
		this.cuenta = cuenta;
	}

	public void saveMe() {
		// TODO Auto-generated method stub
		ClienteDAO.getInstancia().guardarCliente(this.toEntity());
	}

	private ClienteEntity toEntity() {
		// TODO Auto-generated method stub
		ClienteEntity clienteEntity= new ClienteEntity();
		clienteEntity.setLegajo(this.getLegajo());
		clienteEntity.setNombreComercio(this.getNombreComercio());
		clienteEntity.setDireccion(this.getDireccion());
		clienteEntity.setCuit(this.getCuit());
		clienteEntity.setTelefono(this.getTelefono());
		CuentaCorrienteEntity ccEntity= new CuentaCorrienteEntity();
		List<MovimientoCCEntity> movsEntity= new ArrayList<MovimientoCCEntity>();
		for (MovimientoCC mov: this.getCuenta().getMovimientos())
		{
			MovimientoCCEntity movEntity= new MovimientoCCEntity();
			movEntity.setFecha(mov.getFecha());
			movEntity.setMonto(mov.getMonto());
			movEntity.setPositivo(mov.isPositivo());
			movsEntity.add(movEntity);
		}
		ccEntity.setConsignacion(this.getCuenta().getConsignacion());
		ccEntity.setLimiteCredito(this.getCuenta().getLimiteCredito());
		ccEntity.setSaldo(this.getCuenta().getSaldo());
		ccEntity.setMovimientos(movsEntity);
		clienteEntity.setCc(ccEntity);
		return clienteEntity;
		}
		
		
	
	
	
	
}
