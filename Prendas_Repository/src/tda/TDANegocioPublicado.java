package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;

import exceptions.ClienteSobreLimiteException;
import exceptions.PedidoNoEncontradoException;
import exceptions.PrendaDiscontinuaException;
import view.*;

public interface TDANegocioPublicado extends Remote{
	
	
	
	public void nuevoCliente(ClienteVO c, float limite) throws RemoteException;
	
	public void eliminarCliente(ClienteVO c) throws RemoteException;
	
	public ClienteVO mostrarCliente(int legajo) throws RemoteException;

	public void nuevaPrenda(PrendaVO pvo) throws RemoteException;
	
	public PrendaVO buscarPrenda(String codigo) throws RemoteException;
	
	public void eliminarPrenda(String codigo, String descripcion) throws RemoteException;
	
	public int nuevoPedido(PedidoPrendaVO pedido, int legajo) throws RemoteException;
	
	public void validarClientePedido (int numero) throws RemoteException, ClienteSobreLimiteException;
	
	public PedidoPrendaVO mostrarPedido(int numero) throws RemoteException, PedidoNoEncontradoException;
	
	public void validarDiscontinuados(int numero) throws RemoteException, PrendaDiscontinuaException, PedidoNoEncontradoException;
	
	public void noValidarPedido (int numero) throws RemoteException;
	
	public void agregarInsumos(ItemRecetaVO i, String codigo) throws RemoteException;
	
	public void nuevaPrendaTC(PrendaTCVO ptcvo) throws RemoteException;
	
	public void confirmarPedido(int numero)throws RemoteException;
	
	public void pruebaParaSofi();
	
	public void otraPRuebaSkype();

	public void pruebaConjuNNNtaLean();
	public void PRUEBACONJUNTASOFIA();
}
