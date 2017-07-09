package rawTest;

import java.rmi.RemoteException;

import businessdelegate.BusinessDelegate;
import vo.ClienteVO;

public class Test {
	
	public static void main(String[] args) {
		
		try {

			ClienteVO c= new ClienteVO();
			c.setLegajo(5000);
			c.setNombreComercio("Zara");
			c.setDireccion("Entre Rios 450");
			c.setCuit("A6000");
			c.setTelefono("4555-5555");
			c.setConsignacion(0);
			c.setLimite(15000);
			BusinessDelegate.getInstancia().nuevoCliente(c);
			System.out.println("Cliente creado.");
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
