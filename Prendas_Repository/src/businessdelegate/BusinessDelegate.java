package businessdelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;

import tda.TDANegocioPublicado;

public class BusinessDelegate implements TDANegocioPublicado {

	private static BusinessDelegate instancia;
	private TDANegocioPublicado remoteObject;
	
	public static BusinessDelegate getInstancia() throws RemoteException
	{
		if (instancia == null)
			instancia = new BusinessDelegate();
		return instancia;
	}
	
	
	private BusinessDelegate() throws RemoteException
	{
		System.out.println("Connecting to Remote Object");
		try
		{
			remoteObject = (TDANegocioPublicado)Naming.lookup("//localhost/RemoteObject");
			System.out.println("Connected to Remote Object");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
