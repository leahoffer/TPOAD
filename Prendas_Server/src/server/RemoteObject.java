package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import controlador.Controlador;
import tda.TDANegocioPublicado;
import vo.ClienteVO;

public class RemoteObject extends UnicastRemoteObject implements TDANegocioPublicado {

	private static final long serialVersionUID = 1L;
	private Controlador controlador;

	protected RemoteObject() throws RemoteException{
		super();
		controlador= Controlador.getInstancia();
	}

	@Override
	public void nuevoCliente(ClienteVO c) throws RemoteException {
		// TODO Auto-generated method stub
		controlador.nuevoCliente(c);
	}
	
}
