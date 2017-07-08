package negocio;

public class ItemPedidoP {

	private int cantidad;
	private float subtotal;
	private Prenda prenda;
	
	public ItemPedidoP() {
		super();
		this.prenda = new Prenda();
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public Prenda getPrenda() {
		return prenda;
	}

	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	
	
	
}
