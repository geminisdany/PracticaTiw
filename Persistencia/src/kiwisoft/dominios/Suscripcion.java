package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Suscripcion
 *
 */
@Entity
@Table(name = "suscripcion")
public class Suscripcion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Producto producto;
	@ManyToOne
	private Cliente cliente;
	
	

	
	public Suscripcion() {
		super();
	}   
	public Suscripcion(Producto producto, Cliente cliente) {
		super();
		this.producto = producto;
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
