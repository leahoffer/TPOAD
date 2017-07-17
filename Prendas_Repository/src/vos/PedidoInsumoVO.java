package vos;

import java.io.Serializable;
import java.util.Date;

public class PedidoInsumoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int numero;
	private Date fechaGen;
	private String estado;
	
	public PedidoInsumoVO(int numero, Date fechaGen, String estado) {
		super();
		this.numero = numero;
		this.fechaGen = fechaGen;
		this.estado = estado;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getFechaGen() {
		return fechaGen;
	}
	public void setFechaGen(Date fechaGen) {
		this.fechaGen = fechaGen;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String toString(){
		return String.valueOf(this.numero) + " " + this.estado + " " + fechaGen.toString();
	}
	
}
