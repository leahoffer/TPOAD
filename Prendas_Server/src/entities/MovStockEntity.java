package entities;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;


@Entity
@Table(name="Movimientos_Stock")
public class MovStockEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private int id;
	private Date fecha;
	private int cant;
	private boolean positivo;
	public MovStockEntity() {
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
	
	

}
