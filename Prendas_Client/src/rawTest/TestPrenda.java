package rawTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import businessdelegate.BusinessDelegate;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

public class TestPrenda {

	public static void main(String[] args) {
		
		
		try {
			PrendaGenericaVO pgvo= new PrendaGenericaVO();
			pgvo.setCodigo("C0001");
			pgvo.setDescripcion("Pantalon");
			pgvo.setCantColor(100);
			pgvo.setCantTalle(150);
			List<String> colores= new ArrayList<String>();
			List<String> talles= new ArrayList<String>();
			
			colores.add("Negro");
			colores.add("Blanco");
			talles.add("XL");
			talles.add("L");
			
			pgvo.setColores(colores);
			pgvo.setTalles(talles);
			
			PrendaVO pvo= new PrendaVO();
			pvo.setPrenda(pgvo);
			pvo.setEnProduccion(true);
			pvo.setColor("Rojo");
			pvo.setTalle("L");
			pvo.setCosto(0);
			pvo.setPrecio(0);
			BusinessDelegate.getInstancia().nuevaPrenda(pvo);
			System.out.println("Se creó la prenda.");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
