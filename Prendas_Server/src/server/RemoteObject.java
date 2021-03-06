package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import controlador.Controlador;
import tda.TDANegocioPublicado;
import vos.ClienteVO;
import vos.InsumoVO;
import vos.ItemRecetaVO;
import vos.PedidoPrendaVO;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

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
	public void eliminarCliente(ClienteVO cvo) throws RemoteException {
		controlador.eliminarCliente(cvo);
		
	}

	@Override
	public void nuevaPrenda(PrendaVO p) throws RemoteException {
		// TODO Auto-generated method stub
		controlador.nuevaPrenda(p);
	}

	@Override
	public List<InsumoVO> mostrarInsumos() throws RemoteException {
		return controlador.mostrarInsumos();
	}

	@Override
	public List<PrendaGenericaVO> mostrarPrendas() throws RemoteException {
		// TODO Auto-generated method stub
		return controlador.mostrarPrendas();
	}

	@Override
	public void agregarItemReceta(ItemRecetaVO item, PrendaGenericaVO prenda) throws RemoteException {
		// TODO Auto-generated method stub
		controlador.agregarItemReceta(item, prenda);
	}

	@Override
	public void nuevoPedido(PedidoPrendaVO p) throws RemoteException {
		// TODO Auto-generated method stub
		controlador.nuevoPedido(p);
	}

	@Override
	public List<PedidoPrendaVO> mostrarPedidosAValidar() throws RemoteException {
		return controlador.mostrarPedidosAValidar();
	}

	@Override
	public void validarPedido(PedidoPrendaVO selectedValue) throws RemoteException {
		controlador.validarPedido(selectedValue);
		
	}
	
}
