package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tda.TDANegocioPublicado;

public class RemoteObject extends UnicastRemoteObject implements TDANegocioPublicado {

	private static final long serialVersionUID = 1L;

	protected RemoteObject() throws RemoteException{
		super();
	}
	
}
