package bd;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import exceptions.ClienteSobreLimiteException;
import exceptions.PedidoNoEncontradoException;
import exceptions.PrendaDiscontinuaException;
import tda.TDANegocioPublicado;
import view.ClienteVO;
import view.ItemRecetaVO;
import view.PedidoPrendaVO;
import view.PrendaTCVO;
import view.PrendaVO;

public class BusinessDelegate implements TDANegocioPublicado{

	private TDANegocioPublicado remoto;
	private static BusinessDelegate instancia;
	
	public static BusinessDelegate getInstancia()
	{
		if (instancia==null)
			instancia= new BusinessDelegate();
		return instancia;
	}
	
	private BusinessDelegate()
	{
		try {
			remoto= (TDANegocioPublicado) Naming.lookup("//localhost/negocioRemoto");
			System.out.println("Conectado al servidor.");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ABM CLIENTES
	
	public void nuevoCliente(ClienteVO c, float limite) throws RemoteException {
		// TODO Auto-generated method stub
		remoto.nuevoCliente(c, limite);
	}
	
	public void eliminarCliente (ClienteVO cvo) throws RemoteException {
		remoto.eliminarCliente(cvo);
	}

	@Override
	public ClienteVO mostrarCliente(int legajo) throws RemoteException {
		// TODO Auto-generated method stub
		return remoto.mostrarCliente(legajo);
	}

	
	

	//ABM PRENDAS
	public void nuevaPrenda(PrendaVO pvo) throws RemoteException {
		remoto.nuevaPrenda(pvo);
	}

	@Override
	public PrendaVO buscarPrenda(String codigo) throws RemoteException{
		return remoto.buscarPrenda(codigo);
	}
	
	public void eliminarPrenda(String codigo, String descripcion) throws RemoteException{
		remoto.eliminarPrenda(codigo, descripcion);
	}

	public void nuevaPrendaTC(PrendaTCVO ptcvo) throws RemoteException {
		remoto.nuevaPrendaTC(ptcvo);
	}
	
	public void agregarInsumos(ItemRecetaVO i, String text) throws RemoteException {
		// TODO Auto-generated method stub
		remoto.agregarInsumos(i, text);
	}
	
	@Override
	public int nuevoPedido(PedidoPrendaVO pedido, int legajo) throws RemoteException {
		return remoto.nuevoPedido(pedido, legajo);
		
	}

	@Override
	public void validarClientePedido(int numero) throws RemoteException, ClienteSobreLimiteException {
		remoto.validarClientePedido(numero);
		
	}

	@Override
	public PedidoPrendaVO mostrarPedido(int numero) throws RemoteException, PedidoNoEncontradoException {
		return remoto.mostrarPedido(numero);
	}

	@Override
	public void validarDiscontinuados(int numero) throws RemoteException, PrendaDiscontinuaException, PedidoNoEncontradoException {
		remoto.validarDiscontinuados(numero);
		
	}

	@Override
	public void noValidarPedido(int numero) throws RemoteException {
		remoto.noValidarPedido(numero);
		
	}

	@Override
	public void confirmarPedido(int numero) throws RemoteException {
		remoto.confirmarPedido(numero);
	}
	

}
