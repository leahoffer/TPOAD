package businessdelegate;

import java.rmi.Naming;
import java.rmi.RemoteException;

import tda.TDANegocioPublicado;
import vos.ClienteVO;

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
			remoteObject = (TDANegocioPublicado)Naming.lookup("//localhost/negocioRemoto");
			System.out.println("Connected to Remote Object");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}


	@Override
	public void nuevoCliente(ClienteVO c) throws RemoteException {
		remoteObject.nuevoCliente(c);
	}


	@Override
	public ClienteVO buscarClienteVO(int legajo) throws RemoteException {
		ClienteVO cvo = remoteObject.buscarClienteVO(legajo);
		return cvo;
	}


	@Override
	public void eliminarCliente(ClienteVO cvo) throws RemoteException {
		remoteObject.eliminarCliente(cvo);
		
	}
	
	
	
	
}
