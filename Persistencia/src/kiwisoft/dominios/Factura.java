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
public class Factura implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	private Direccion direccion;
	private String fecha;
	private String hora;
	private double importe;
	
	@OneToMany(cascade = ALL, mappedBy = "producto")
	private Collection<Pedido>pedidos;
	
	public Factura(Direccion direccion, String fecha,String hora, double importe) {
		this.direccion=direccion;
		this.fecha=fecha;
		this.hora=hora;
		this.importe=importe;
		this.pedidos=new ArrayList<Pedido>();
	} 
	
	//agregar factura
	public void agregarPedido(Pedido pedido) {
			this.pedidos.add(pedido);
	}
		
	public Collection<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Collection<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Factura() {
		super();
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
