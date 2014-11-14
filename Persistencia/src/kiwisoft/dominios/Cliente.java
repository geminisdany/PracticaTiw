package kiwisoft.dominios;


import java.io.Serializable;
import java.lang.Long;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.ALL;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String apellidos;
	private int telefono;
	private String email;
	private String password;
	
	@OneToOne(cascade = ALL,fetch=EAGER)
	private Direccion direccion;
	
	
	@OneToMany(cascade = ALL, fetch = LAZY, mappedBy = "cliente")
	private Collection<Factura> facturas;
	
	
	public Cliente(String nombre, String apellidos, int telefono, String email, String password,Direccion direccion) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
		this.direccion=direccion;
		this.facturas=new ArrayList<Factura>();
	}
	
	//agregar factura
	public void agregarProducto(Factura factura) {
		this.facturas.add(factura);
	}
	
	public Collection<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Cliente() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

   
}
