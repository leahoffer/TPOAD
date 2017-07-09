package rawTest;

import java.rmi.RemoteException;

import businessdelegate.BusinessDelegate;
import vos.ClienteVO;

public class TestCliente {
	
	public static void main(String[] args) {
		
		try {

			ClienteVO c= new ClienteVO();
			c.setLegajo(5000);
			c.setNombreComercio("47 street");
			c.setDireccion("Independencia 450");
			c.setCuit("A6000");
			c.setTelefono("4555-5555");
			c.setConsignacion(0);
			c.setLimite(15000);
			ClienteVO resultado=BusinessDelegate.getInstancia().buscarClienteVO(c.getLegajo());
			System.out.println(resultado.getNombreComercio());
			System.out.println(resultado.getDireccion());
			System.out.println(resultado.getTelefono());
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
