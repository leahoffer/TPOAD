package negocio;

import java.util.ArrayList;
import java.util.List;

public class Proveedor {
	
	private String nombre;
	private String telefono;
	private List<ItemProveedor> items;
	public Proveedor() {
		// TODO Auto-generated constructor stub
		items= new ArrayList<ItemProveedor>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<ItemProveedor> getItems() {
		return items;
	}
	public void setItems(List<ItemProveedor> items) {
		this.items = items;
	}
	
	
	
	
	

}
