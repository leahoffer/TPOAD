package rawTest;

import java.rmi.RemoteException;

import businessdelegate.BusinessDelegate;
import vos.PedidoPrendaVO;

public class TestCompletarpedido {

	public static void main(String[] args) {
		
		try {
			PedidoPrendaVO pp= new PedidoPrendaVO();
			pp.setNumero(1);
			BusinessDelegate.getInstancia().confirmarPedido(pp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
