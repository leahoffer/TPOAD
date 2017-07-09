package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vos.ClienteVO;
import vos.PrendaVO;

public interface TDANegocioPublicado extends Remote {
	
	public void nuevoCliente(ClienteVO c) throws RemoteException;
	
	public ClienteVO buscarClienteVO(int legajo) throws RemoteException;
	
	public void eliminarCliente(ClienteVO cvo) throws RemoteException;
	
	public void nuevaPrenda(PrendaVO p) throws RemoteException;
}
