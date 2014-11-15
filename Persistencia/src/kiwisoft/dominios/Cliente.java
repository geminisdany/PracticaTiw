package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellidos;
	@Column(nullable = false)
	private int telefono;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@OneToOne(cascade = ALL)
	private Direccion direccion;
	@OneToMany(fetch = LAZY, cascade = ALL)
	private Collection<Suscripcion> suscripciones;
	@OneToMany(fetch=LAZY, cascade = ALL)
	private Collection<Factura> facturas;
	
	public Cliente() {
		super();
	}  
	
	public Cliente(String nombre, String apellidos, int telefono, String email,
			String password, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.direccion = direccion;
		this.suscripciones=new ArrayList<Suscripcion>();
		this.facturas=new ArrayList<Factura>();
	}
	 
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Collection<Suscripcion> getSuscripciones() {
		return suscripciones;
	}
	public void setSuscripciones(Collection<Suscripcion> suscripciones) {
		this.suscripciones = suscripciones;
	}
	public Collection<Factura> getFacturas() {
		return facturas;
	}
	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
	}
   
}
