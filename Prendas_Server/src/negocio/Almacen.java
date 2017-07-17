package negocio;

import java.util.ArrayList;
import java.util.List;

import daos.UbicacionDAO;

public class Almacen {

	private List<UbicacionPrenda> ubicacionesPrendas;
	private List<UbicacionInsumo> ubicacionesInsumos;
	private static Almacen instancia;
	
	public static Almacen getInstancia(){
		if (instancia == null)
			instancia = new Almacen();
		return instancia;
	}
	
	private Almacen() {
		this.ubicacionesInsumos = new ArrayList<UbicacionInsumo>();
		this.ubicacionesPrendas = UbicacionDAO.getInstancia().traerUbicaciones();
		
	}

	public List<UbicacionPrenda> getUbicacionesPrendas() {
		return ubicacionesPrendas;
	}

	public void setUbicacionesPrendas(List<UbicacionPrenda> ubicacionesPrendas) {
		this.ubicacionesPrendas = ubicacionesPrendas;
	}

	public List<UbicacionInsumo> getUbicacionesInsumos() {
		return ubicacionesInsumos;
	}

	public void setUbicacionesInsumos(List<UbicacionInsumo> ubicacionesInsumos) {
		this.ubicacionesInsumos = ubicacionesInsumos;
	}
	
	public float traerStockInsumo(Insumo i)
	{
		return UbicacionDAO.getInstancia().traerStockI(i);
		
	}
	
	/*La idea es que este método vaya recorriendo las ubicaciones que tienen prenda = pedidoPrenda.getItemPedidoP().getPrenda()
	 *y si la cantidad del bulto es = pedidoPrenda.getItemPedidoP.getCant(), que reserve por la totalidad.
	 *
	 *Si la cantidad del bulto es menor, que reserve por la totalidad del bulto y siga buscando en otras ubicaciones hasta encontrar
	 *la cantidad que pide el pedidoPrenda.getItemPedidoP.getCant().
	 *
	 *Después veremos si el Despacho se encarga de buscar las ubicaciones con reservados, o si esto debiera pasarle al Despacho
	 *las ubicaciones encontradas. Si se las pasa, quizás deberíamos agregar al ItemPedidoP o al Pedido en sí una List<UbicacionPrenda>
	 *para saber dónde buscar después.
	 **/
	
	public void reservarStock(PedidoPrenda pedidoPrenda) {
		// TODO Auto-generated method stub
		List<UbicacionPrenda> ubicaciones= new ArrayList<UbicacionPrenda>();
		
		for (ItemPedidoP ipp: pedidoPrenda.getPrendas())
		{
			int cantidad= ipp.getCantidad();
			ipp.getPrenda().AgregarMovimientoStock(cantidad, false);
			for (UbicacionPrenda up: this.ubicacionesPrendas)
			{
				if ((cantidad>0) && (up.getPrenda().esIgualA(ipp.getPrenda())))
				{
					if (up.getCantidadNeta()>=cantidad)
					{
						up.setReservados(up.getReservados()+cantidad);
						cantidad= 0;
						ubicaciones.add(up);
					}
					else
					{
						up.setReservados(up.getReservados()+up.getCantidadNeta());
						cantidad= cantidad-up.getCantidadNeta();
						ubicaciones.add(up);
					}
					UbicacionDAO.getInstancia().guardarUbicacion(up.toEntity());
				}
				
			}
		}
		pedidoPrenda.setUbicaciones(ubicaciones);
	}

	public void colocarPrendas(OrdenProduccion op) 
	{
		for(Prenda p : op.getPrendas())
		{
			UbicacionPrenda up = new UbicacionPrenda();
			up.setPrenda(p);
			up.setCantidad(op.getCantidadAProducir());
			buscarYColocar(up);
		}
	}

	private void buscarYColocar(UbicacionPrenda ubicacion)
	{
		UbicacionPrenda up = new UbicacionPrenda();
		up = UbicacionDAO.getInstancia().traerUbicacionPMasAlta();
		if(up==null)
		{
			ubicacion.setCalle("A");
			ubicacion.setBloque(1);
			ubicacion.setEstanteria(1);
			ubicacion.setPosicion(1);
			ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
			UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
		}
		else{
		if(up.getPosicion()==21)
		{
			if(up.getEstanteria()==6)
			{
				if(up.getBloque()==5)
				{
					if(up.getCalle().equalsIgnoreCase("A"))
					{
						ubicacion.setCalle("B");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
					else if (up.getCalle().equalsIgnoreCase("B"))
					{
						ubicacion.setCalle("C");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
					else if (up.getCalle().equalsIgnoreCase("C"))
					{
						ubicacion.setCalle("D");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
					else if (up.getCalle().equalsIgnoreCase("D"))
					{
						ubicacion.setCalle("E");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
					else if (up.getCalle().equalsIgnoreCase("E"))
					{
						ubicacion.setCalle("F");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
					else if (up.getCalle().equalsIgnoreCase("F"))
					{
						ubicacion.setCalle("G");
						ubicacion.setBloque(1);
						ubicacion.setEstanteria(1);
						ubicacion.setPosicion(1);
						ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
						UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
					}
				}
				else
				{
					ubicacion.setCalle(up.getCalle());
					ubicacion.setBloque(up.getBloque()+1);
					ubicacion.setEstanteria(1);
					ubicacion.setPosicion(1);
					ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
					UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
				}
			}
			else
			{
				ubicacion.setCalle(up.getCalle());
				ubicacion.setBloque(up.getBloque());
				ubicacion.setEstanteria(up.getEstanteria()+1);
				ubicacion.setPosicion(1);
				ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
				UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
			}
		}
		else
		{
			ubicacion.setCalle(up.getCalle());
			ubicacion.setBloque(up.getBloque());
			ubicacion.setEstanteria(up.getEstanteria());
			ubicacion.setPosicion(up.getPosicion()+1);
			ubicacion.setUbicacion(ubicacion.obtenerUbicacion());
			UbicacionDAO.getInstancia().guardarUbicacion(ubicacion.toEntity());
		}
		
	}
}

	public UbicacionInsumo devolvemeSiguienteUbicacionInsumo() {
		UbicacionInsumo ui = new UbicacionInsumo();
		ui = UbicacionDAO.getInstancia().traerUbicacionIMasAlta();
		UbicacionInsumo resultado = new UbicacionInsumo();
		if(ui==null)
		{
			resultado.setCalle("H");
			resultado.setBloque(1);
			resultado.setEstanteria(1);
			resultado.setPosicion(1);
			resultado.setUbicacion(resultado.obtenerUbicacion());
			return resultado;
		}
		else
		{
			if(ui.getPosicion()==21)
			{
				if(ui.getEstanteria()==6)
				{
					if(ui.getBloque()==5)
					{
						if(ui.getCalle().equals("H"))
						{
							resultado.setCalle("I");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
							
						}
						else if (ui.getCalle().equals("I"))
						{
							resultado.setCalle("J");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("J"))
						{
							resultado.setCalle("K");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("K"))
						{
							resultado.setCalle("L");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("L"))
						{
							resultado.setCalle("M");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("M"))
						{
							resultado.setCalle("N");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("N"))
						{
							resultado.setCalle("O");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
						else if (ui.getCalle().equals("O"))
						{
							resultado.setCalle("P");
							resultado.setBloque(1);
							resultado.setEstanteria(1);
							resultado.setPosicion(1);
							resultado.setUbicacion(resultado.obtenerUbicacion());
							return resultado;
						}
					}
					else
					{
						resultado.setCalle(ui.getCalle());
						resultado.setBloque(ui.getBloque()+1);
						resultado.setEstanteria(1);
						resultado.setPosicion(1);
						resultado.setUbicacion(resultado.obtenerUbicacion());
						return resultado;
					}
				}
				else
				{
					resultado.setCalle(ui.getCalle());
					resultado.setBloque(ui.getBloque());
					resultado.setEstanteria(ui.getEstanteria()+1);
					resultado.setPosicion(1);
					resultado.setUbicacion(resultado.obtenerUbicacion());
					return resultado;
				}
			}
			else
			{
				resultado.setCalle(ui.getCalle());
				resultado.setBloque(ui.getBloque());
				resultado.setEstanteria(ui.getEstanteria());
				resultado.setPosicion(ui.getPosicion()+1);
				resultado.setUbicacion(resultado.obtenerUbicacion());
				return resultado;
			}
		}
		return null;
	}
	
	
	
}
