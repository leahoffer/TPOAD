package tda;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import vos.ClienteVO;
import vos.InsumoVO;
import vos.ItemRecetaVO;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

public interface TDANegocioPublicado extends Remote {
	
	public void nuevoCliente(ClienteVO c) throws RemoteException;
	
	public ClienteVO buscarClienteVO(int legajo) throws RemoteException;
	
	public void eliminarCliente(ClienteVO cvo) throws RemoteException;
	
	public void nuevaPrenda(PrendaVO p) throws RemoteException;

	public List<InsumoVO> mostrarInsumos() throws RemoteException;
	
	public List<PrendaGenericaVO> mostrarPrendas() throws RemoteException;
	
	public void agregarItemReceta (ItemRecetaVO item, PrendaGenericaVO prenda) throws RemoteException;

}
