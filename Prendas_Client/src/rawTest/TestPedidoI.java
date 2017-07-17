package rawTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessdelegate.BusinessDelegate;
import vos.PedidoInsumoVO;

public class TestPedidoI {

	public static void main(String[] args) {
		/*List<PedidoInsumoVO>  pedidos = new ArrayList<PedidoInsumoVO>();
		try {
			pedidos = BusinessDelegate.getInstancia().traerTodosLosPedidosI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PedidoInsumoVO pivo : pedidos)
			System.out.println(pivo.toString());*/
		try {
			BusinessDelegate.getInstancia().completarPedidoInsumo(new PedidoInsumoVO(2, new Date(), "Pendiente"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
