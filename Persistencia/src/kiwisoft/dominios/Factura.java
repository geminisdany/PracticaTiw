package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
	private Date fecha;
	
	@Column(nullable = false)
	private String tipoPago;
	
	@Column(nullable = false)
	private double importe;
	
	@OneToOne
	private Cliente cliente;
	@OneToOne(cascade = ALL)
	private Direccion direccion;
	@OneToMany(cascade = ALL)
	private Collection<Pedido>pedidos;
	
	public Factura() {
		super();
	} 
	public Factura(Cliente cliente, String tipoPago,double importe, Direccion direccion, ArrayList<Pedido> pedidos) {
		super();
		java.util.Date hoy= new java.util.Date();
		
		this.direccion = direccion;
		this.fecha = new Date( hoy.getTime());
		this.importe = importe;
		this.pedidos = pedidos;
		this.tipoPago=tipoPago;
		this.cliente=cliente;
	}
	
	public Factura(Cliente cliente, String tipoPago,double importe, Direccion direccion) {
		super();
		java.util.Date hoy= new java.util.Date();
		
		this.direccion = direccion;
		this.fecha = new Date( hoy.getTime());
		this.importe = importe;
		this.pedidos = new ArrayList<Pedido>();
		this.tipoPago=tipoPago;
		this.cliente=cliente;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String fechaUsuario(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(this.fecha);
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
