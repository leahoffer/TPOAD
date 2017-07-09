package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.sun.org.apache.xerces.internal.util.URI.MalformedURIException;

import hibernate.HibernateUtil;
import tda.TDANegocioPublicado;

public class Server {

	private TDANegocioPublicado remote;
	
	public static void main(String[] args) {
		new Server();
	}

	public Server()
	{
		Init();
	}
	
	public void Init()
	{
		try
		{
			LocateRegistry.createRegistry(1099);
			remote = new RemoteObject();
			Naming.rebind("//localhost/negocioRemoto", remote);
			HibernateUtil.getSessionFactory().openSession();
			System.out.println("RemoteObject successfully published");
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
		}
		catch (MalformedURLException mue)
		{
			mue.printStackTrace();
		}
	}
	
}
