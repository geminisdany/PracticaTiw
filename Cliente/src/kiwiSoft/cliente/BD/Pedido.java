package kiwiSoft.cliente.BD;

public class Pedido {
	
	/*Atributos*/

	private int Nfactura;
	private int idp;
	private String nombre;
	private int cantidad;
	private double precio;
	
	/*Constructor*/
	
	public Pedido(int Nfactura, int idp,String nombre, int cantidad, double precio) {
	
		this.Nfactura=Nfactura;
		this.idp=idp;
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.precio=precio;
	
		
	}

	/*Getters and Setters*/
	
	public int getNfactura() {
		return Nfactura;
	}

	public void setNfactura(int nfactura) {
		this.Nfactura = nfactura;
	}

	public int getIdp() {
		return idp;
	}

	public void setIdp(int idp) {
		this.idp = idp;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
