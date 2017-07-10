package negocio;

import entities.ColorEntity;

public class Color {
	
	private String color;

	public Color() {
		// TODO Auto-generated constructor stub
	}

	public Color(String cvo) {
		// TODO Auto-generated constructor stub
		this.color= cvo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public ColorEntity toEntity() {
		// TODO Auto-generated method stub
		ColorEntity res= new ColorEntity();
		res.setColor(this.getColor());
		return res;
	}
	
	

}
