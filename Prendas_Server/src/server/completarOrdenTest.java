package server;

import controlador.Controlador;
import daos.OrdenProduccionDAO;

public class completarOrdenTest {

	public static void main(String[] args) {
		Controlador.getInstancia().completarOrdenProduccion(8);
	}

}
