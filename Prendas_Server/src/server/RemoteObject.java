package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controlador.Controlador;
import tda.TDANegocioPublicado;
import vos.ClienteVO;

public class RemoteObject extends UnicastRemoteObject implements TDANegocioPublicado {

	private static final long serialVersionUID = 1L;
	private Controlador controlador;

	protected RemoteObject() throws RemoteException{
		super();
		controlador= Controlador.getInstancia();
	}

	@Override
	public void nuevoCliente(ClienteVO c) throws RemoteException {
		controlador.nuevoCliente(c);
	}

	@Override
	public ClienteVO buscarClienteVO(int legajo) throws RemoteException {
		ClienteVO cvo = controlador.buscarClienteVO(legajo);
		return cvo;
		
	}

	@Override
	public void eliminarCliente(int legajo) throws RemoteException {
		controlador.eliminarCliente(legajo);
		
	}
	
}
