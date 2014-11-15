package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pedido
 *
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private int cantidad;
	@Column(nullable = false)
	private double precio;	
	
	@OneToOne
	private Producto producto;
	

	public Pedido(Producto producto, int cantidad, double precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public Pedido() {
		super();
	} 

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
	
  
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
