package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vos.ClienteVO;

public interface TDANegocioPublicado extends Remote {
	
	public void nuevoCliente(ClienteVO c) throws RemoteException;

}
