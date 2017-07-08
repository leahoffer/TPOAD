package servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import business.Color;
import business.Prenda;
import dao.PrendaDAO;
import ennumeration.Talle;
import hibernate.HibernateUtil;
import tda.TDANegocioPublicado;

public class Server {
	
	private TDANegocioPublicado remoto;
	
	
	public static void main(String[] args) {
		
		new Server();
		
	}
	
	public Server()
	{
		iniciar();
		carga();
	}

	private void carga() {
		// TODO Auto-generated method stub
		/*Prenda p= new Prenda();
		p.setCodigo("AAA");
		p.setDescripcion("Pantalon");
		List<Color> colores= new ArrayList<Color>();
		colores.add(new Color("Rojo", "Oscuro"));
		colores.add(new Color("Azul", "Oscuro"));
		colores.add(new Color("Verde", "Oscuro"));
		colores.add(new Color("Azul", "Oscuro"));
		List<Talle> talles= new ArrayList<Talle>();
		talles.add(Talle.S);
		talles.add(Talle.M);
		talles.add(Talle.L);
		p.setColores(colores);
		p.setTalles(talles);
		p.saveme();*/
		
	}

	private void iniciar() {
		// TODO Auto-generated method stub
		try {
			LocateRegistry.createRegistry(1099);
			remoto = new Remoto();
			Naming.rebind("//localhost/negocioRemoto", remoto);
			System.out.println("RemoteObject successfully published");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
