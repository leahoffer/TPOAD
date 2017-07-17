package rawTest;

import java.rmi.RemoteException;

import businessdelegate.BusinessDelegate;
import vos.PedidoPrendaVO;

public class TestConfirmarPedido {

	public static void main(String[] args) {
		PedidoPrendaVO ppvo = new PedidoPrendaVO();
		ppvo.setNumero(1);
		try {
			BusinessDelegate.getInstancia().confirmarPedido(ppvo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
