package kiwiSoft.cliente.BD;

public class Pedido {
	
	/*Atributos*/

	private int idp;
	private String nombre;
	private int cantidad;
	private double precio;
	
	/*Constructor*/
	
	public Pedido(int idp,String nombre, int cantidad, double precio) {
		this.idp=idp;
		this.nombre=nombre;
		this.cantidad=cantidad;
		this.precio=precio;
	
		
	}

	/*Getters and Setters*/
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

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
