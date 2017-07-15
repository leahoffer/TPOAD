package server;

import daos.PrendaDAO;
import daos.UbicacionDAO;
import negocio.Prenda;
import negocio.UbicacionPrenda;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

public class Test {

	public static void main(String[] args) {
		UbicacionPrenda up1 = new UbicacionPrenda();
		up1.setCalle("A");
		up1.setBloque(01);
		up1.setEstanteria(06);
		up1.setPosicion(20);
		PrendaVO p = new PrendaVO();
		p.setColor("Negro");
		p.setTalle("XS");
		PrendaGenericaVO pgvo = new PrendaGenericaVO();
		pgvo.setCodigo("P001");
		p.setPrenda(pgvo);
		Prenda pr = PrendaDAO.getInstancia().traerEspecifica(p).toNegocio();
		up1.setUbicacion(up1.obtenerUbicacion());
		up1.setPrenda(pr);
		UbicacionDAO.getInstancia().guardarUbicacion(up1.toEntity());
		
		UbicacionPrenda up2 = new UbicacionPrenda();
		up2.setCalle("A");
		up2.setBloque(01);
		up2.setEstanteria(06);
		up2.setPosicion(19);
		PrendaVO p2 = new PrendaVO();
		p2.setColor("Negro");
		p2.setTalle("XS");
		PrendaGenericaVO pgvo2 = new PrendaGenericaVO();
		pgvo2.setCodigo("P001");
		p2.setPrenda(pgvo2);
		Prenda pr2 = PrendaDAO.getInstancia().traerEspecifica(p).toNegocio();
		up2.setUbicacion(up2.obtenerUbicacion());
		up2.setPrenda(pr2);
		UbicacionDAO.getInstancia().guardarUbicacion(up2.toEntity());
		
		UbicacionPrenda up3 = new UbicacionPrenda();
		up3.setCalle("B");
		up3.setBloque(01);
		up3.setEstanteria(06);
		up3.setPosicion(19);
		up3.setUbicacion(up3.obtenerUbicacion());
		PrendaVO p3 = new PrendaVO();
		p3.setColor("Negro");
		p3.setTalle("XS");
		PrendaGenericaVO pgvo3 = new PrendaGenericaVO();
		pgvo3.setCodigo("P001");
		p.setPrenda(pgvo3);
		Prenda pr3 = PrendaDAO.getInstancia().traerEspecifica(p).toNegocio();
		up3.setPrenda(pr3);
		UbicacionDAO.getInstancia().guardarUbicacion(up3.toEntity());
		
		UbicacionPrenda upprueba = UbicacionDAO.getInstancia().traerUbicacionMasAlta();
		System.out.println(upprueba.obtenerUbicacion());
		
		String analizar = upprueba.obtenerUbicacion();
		char[] aa = analizar.toCharArray();
		for(int i=0; aa.length>i; i++)
			System.out.println(aa[i]);
		String aa1 = aa.toString();
		System.out.println(analizar.indexOf('1'));
		
		
		

	}

}
