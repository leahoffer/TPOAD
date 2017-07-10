package entities;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="Talles")
public class TalleEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	private String talle;

	public TalleEntity() {
		// TODO Auto-generated constructor stub
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}
	
	

}
