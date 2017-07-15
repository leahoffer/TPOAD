package server;

import daos.UbicacionDAO;
import negocio.UbicacionPrenda;

public class Test {

	public static void main(String[] args) {
		UbicacionPrenda up1 = new UbicacionPrenda();
		up1.setCalle("A");
		up1.setBloque(01);
		up1.setEstanteria(06);
		up1.setPosicion(20);
		up1.setUbicacion(up1.obtenerUbicacion());
		UbicacionDAO.getInstancia().guardarUbicacion(up1.toEntity());
		
		UbicacionPrenda up2 = new UbicacionPrenda();
		up2.setCalle("A");
		up2.setBloque(01);
		up2.setEstanteria(06);
		up2.setPosicion(19);
		up2.setUbicacion(up2.obtenerUbicacion());
		UbicacionDAO.getInstancia().guardarUbicacion(up2.toEntity());
		
		UbicacionPrenda up3 = new UbicacionPrenda();
		up3.setCalle("B");
		up3.setBloque(01);
		up3.setEstanteria(06);
		up3.setPosicion(19);
		up3.setUbicacion(up3.obtenerUbicacion());
		UbicacionDAO.getInstancia().guardarUbicacion(up3.toEntity());
		
		
		

	}

}
