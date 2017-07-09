package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ClienteVO;

public interface TDANegocioPublicado extends Remote {
	
	public void nuevoCliente(ClienteVO c) throws RemoteException;

}
