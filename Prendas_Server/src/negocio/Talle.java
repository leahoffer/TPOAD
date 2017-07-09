package negocio;

import entities.TalleEntity;

public class Talle {

	private String talle;

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public Talle() {
		// TODO Auto-generated constructor stub
	}

	public Talle(String tvo) {
		// TODO Auto-generated constructor stub
		talle= tvo;
	}

	public TalleEntity toEntity() {
		// TODO Auto-generated method stub
		TalleEntity res= new TalleEntity();
		res.setTalle(this.getTalle());
		return res;
	}
	
	
}
