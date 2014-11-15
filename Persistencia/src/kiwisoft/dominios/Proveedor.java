package kiwisoft.dominios;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.lang.Long;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.FetchType.LAZY;



/**
 * Entity implementation class for Entity: Proveedor
 *
 */
@Entity
@Table(name = "proveedor")
public class Proveedor implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Column(nullable = false, unique = true)
	private String cif;
	@Column(nullable = false)
	private String nombre;
	@Column(unique = true)
	private int telefono;
	@Column(nullable = false)
	private String web;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	@OneToOne(cascade = ALL, fetch = EAGER)
	private Direccion direccion;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "proveedor", fetch = LAZY)
	private Collection<Producto> productos;
	
	
	
	public Proveedor(String cif, String nombre, int telefono, String web,
			String email, String password, Direccion direccion) {
		this.cif = cif;
		this.nombre = nombre;
		this.telefono = telefono;
		this.web = web;
		this.email = email;
		this.password = password;
		this.direccion = direccion;
		this.productos = new ArrayList<Producto>();
	}
	
	//agregar producto a productos
		public void agregarProducto(Producto producto) {
			this.productos.add(producto);
		}
		
	public String getCif() {
		return cif;
	}
	public void setCif(String cif) {
		this.cif = cif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
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
	public Collection<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	public Proveedor() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
