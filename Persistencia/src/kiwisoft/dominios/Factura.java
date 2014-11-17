package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;



/**
 * Entity implementation class for Entity: Factura
 *
 */
@Entity
@Table(name = "factura")
public class Factura implements Serializable {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String fecha;
	@Column(nullable = false)
	private String hora;
	@Column(nullable = false)
	private String tipoPago;
	@Column(nullable = false)
	private double importe;
	
	@OneToOne(cascade = ALL)
	private Direccion direccion;
	@OneToMany(cascade = ALL)
	private Collection<Pedido>pedidos;
	
	public Factura() {
		super();
	} 
	public Factura(String fecha, String hora,String tipoPago,double importe, Direccion direccion, ArrayList<Pedido> pedidos) {
		super();
		this.direccion = direccion;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
		this.pedidos = pedidos;
		this.tipoPago=tipoPago;
	}
	
	public String getTipoPago() {
		return tipoPago;
	}
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
	}
	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	//agregar pedido
	public void agregarPedido(Pedido pedido) {
			this.pedidos.add(pedido);
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
