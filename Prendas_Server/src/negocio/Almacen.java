package negocio;

import java.util.ArrayList;
import java.util.List;

public class Almacen {

	private List<UbicacionPrenda> ubicacionesPrendas;
	private List<UbicacionInsumo> ubicacionesInsumos;
	private static Almacen instancia;
	
	public static Almacen getInstancia(){
		if (instancia == null)
			instancia = new Almacen();
		return instancia;
	}
	
	private Almacen() {
		this.ubicacionesInsumos = new ArrayList<UbicacionInsumo>();
		this.ubicacionesPrendas = new ArrayList<UbicacionPrenda>();
	}

	public List<UbicacionPrenda> getUbicacionesPrendas() {
		return ubicacionesPrendas;
	}

	public void setUbicacionesPrendas(List<UbicacionPrenda> ubicacionesPrendas) {
		this.ubicacionesPrendas = ubicacionesPrendas;
	}

	public List<UbicacionInsumo> getUbicacionesInsumos() {
		return ubicacionesInsumos;
	}

	public void setUbicacionesInsumos(List<UbicacionInsumo> ubicacionesInsumos) {
		this.ubicacionesInsumos = ubicacionesInsumos;
	}

	
	
}
