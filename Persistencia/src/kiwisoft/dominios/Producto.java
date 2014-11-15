package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;
import java.sql.Blob;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Producto
 *
 */
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private double pre_min;
	@Column(nullable = false)
	private double pre_max;
	@Column(nullable = false)
	private double precio;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false)
	private String descripcion;
	@Column(nullable = false)
	private int stock;
	@Column(nullable = false)
	private boolean oferta;
	@Column(nullable = true)
	private String urlImagen;
	@Column(nullable = true)
	private Blob imagen;
	
	@OneToOne
	private Proveedor proveedor;

	public Producto(String nombre, double pre_min, double pre_max,
			double precio, String tipo, String descripcion, int stock,
			boolean oferta, String urlImagen, Blob imagen,Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.oferta = oferta;
		this.urlImagen = urlImagen;
		this.imagen = imagen;
		this.proveedor=proveedor;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPre_min() {
		return pre_min;
	}
	public void setPre_min(double pre_min) {
		this.pre_min = pre_min;
	}
	public double getPre_max() {
		return pre_max;
	}
	public void setPre_max(double pre_max) {
		this.pre_max = pre_max;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public boolean isOferta() {
		return oferta;
	}
	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}
	public String getUrlImagen() {
		return urlImagen;
	}
	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	public Blob getImagen() {
		return imagen;
	}
	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}
	public Producto() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
