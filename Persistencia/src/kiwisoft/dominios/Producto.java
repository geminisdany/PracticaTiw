package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;
import java.sql.Blob;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "producto")

public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private double pre_min;
	@Column(nullable = false)
	private double pre_max;
	@Column(nullable = false)
	private double impuesto;
	@Column(nullable = false)
	private double precio;
	@Column(nullable = false)
	private String tipo;
	@Column(nullable = false, length = 255)
	private String descripcion;
	@Column(nullable = false)
	private int stock;
	@Column(nullable = false)
	private int umbralStock;
	@Column(nullable = false)
	private boolean oferta;
	@Column(nullable = true)
	private String urlImagen;
	@Column(nullable = true)
	private Blob imagen;
	
	/*@ManyToOne(cascade = PERSIST)
	private Proveedor proveedor;*/
	
	@ManyToOne(cascade = PERSIST)
	private Proveedor proveedor;
	
	@OneToMany(mappedBy="producto", cascade = ALL)
	private Collection<Suscripcion> suscripciones;
	
	public Producto() {
		super();
	}
	
	public Producto(String nombre, double pre_min, double pre_max,
			double impuesto, double precio, String tipo, String descripcion, int stock, int umbralStock,
			boolean oferta, String urlImagen, Blob imagen,Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.impuesto = impuesto;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.umbralStock = umbralStock;
		this.oferta = oferta;
		this.urlImagen = urlImagen;
		this.imagen = imagen;
		this.proveedor=proveedor;
	}
	
	public Producto(String nombre, double pre_min, double pre_max,
			double precio, String tipo, String descripcion, int stock, int umbralStock,
			boolean oferta, String urlImagen, Blob imagen,Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.impuesto = 0;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.umbralStock = umbralStock;
		this.oferta = oferta;
		this.urlImagen = urlImagen;
		this.imagen = imagen;
		this.proveedor=proveedor;
	}
	
	public Producto(String nombre, double pre_min, double pre_max,
			double precio, String tipo, String descripcion, int stock, int umbralStock,
			boolean oferta, String urlImagen, Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.impuesto = 0;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.umbralStock = umbralStock;
		this.oferta = oferta;
		this.urlImagen = urlImagen;
		this.proveedor = proveedor;
	}
	
	
	public Producto(String nombre, double pre_min, double pre_max,
			double precio, String tipo, String descripcion, int stock, int umbralStock,
			boolean oferta, Blob imagen,Proveedor proveedor) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.precio = precio;
		this.impuesto = 0;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.umbralStock = umbralStock;
		this.oferta = oferta;
		this.imagen = imagen;
		this.urlImagen = null;
		this.proveedor = proveedor;
	}

	/*public Producto(String nombre, double pre_min, double pre_max,
			double precio, String tipo, String descripcion, int stock,
			boolean oferta, String imagen, Proveedor proveedor, Pedido pedidos) {
		super();
		this.nombre = nombre;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.precio = precio;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.oferta = oferta;
		this.imagen = imagen;
		this.proveedor = proveedor;
		this.pedidos = pedidos;
	}*/

	public Long getId() {
		return id;
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

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collection<Suscripcion> getSuscripciones() {
		return suscripciones;
	}

	public void setSuscripciones(Collection<Suscripcion> suscripciones) {
		this.suscripciones = suscripciones;
	}

	public int getUmbralStock() {
		return umbralStock;
	}

	public void setUmbralStock(int umbralStock) {
		this.umbralStock = umbralStock;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	
}