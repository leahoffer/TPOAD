package rawTest;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import businessdelegate.BusinessDelegate;
import vos.*;

public class TestPedido {
	
	public static void main(String[] args) {
		
		
		
		try {

			PrendaVO p= new PrendaVO();
			p.setColor("Negro");
			p.setTalle("S");
			p.setPrenda(new PrendaGenericaVO("P001"));

		

			PrendaVO p2= new PrendaVO();
			p2.setColor("Blanco");
			p2.setTalle("S");

			p2.setPrenda(new PrendaGenericaVO("P001"));

			PrendaVO p3= new PrendaVO();
			p3.setColor("Negro");
			p3.setTalle("L");
			p3.setPrenda(new PrendaGenericaVO("P001"));
		
			List<ItemPedidoPVO> items= new ArrayList<ItemPedidoPVO>();
			ItemPedidoPVO ipvo= new ItemPedidoPVO();
			ipvo.setCantidad(10);
			ipvo.setPrenda(p);
			ItemPedidoPVO ipvo2= new ItemPedidoPVO();
			ipvo2.setCantidad(20);
			ipvo2.setPrenda(p2);
			ItemPedidoPVO ipvo3 = new ItemPedidoPVO();
			ipvo3.setCantidad(10);
			ipvo3.setPrenda(p3);
			
			items.add(ipvo);
			items.add(ipvo2);
			items.add(ipvo3);
			
			ClienteVO c= new ClienteVO();
			c.setLegajo(1001);
			PedidoPrendaVO pp= new PedidoPrendaVO();
			pp.setCliente(c);
			pp.setFechaGen(new Date());
			pp.setPrendas(items);
			BusinessDelegate.getInstancia().nuevoPedido(pp);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
