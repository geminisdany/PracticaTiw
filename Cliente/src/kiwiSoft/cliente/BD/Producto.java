package kiwiSoft.cliente.BD;

public class Producto {
	private int idp;
	private String cif;		
	private double pre_min;
	private double pre_max;
	private String tipo;	
	private String descripcion;
	private int stock;
	private String nombre;
	private String urlImagen;
	private boolean oferta;
	
	public boolean isOferta() {
		return oferta;
	}


	public void setOferta(boolean oferta) {
		this.oferta = oferta;
	}


	public Producto(int idp, String cif, double pre_min, double pre_max,
			String tipo, String descripcion, int stock, String nombre,
			String urlImagen,boolean oferta) {
		this.idp = idp;
		this.cif = cif;
		this.pre_min = pre_min;
		this.pre_max = pre_max;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.nombre = nombre;
		this.urlImagen = urlImagen;
		this.oferta = oferta;
	}


	public int getIdp() {
		return idp;
	}


	public void setIdp(int idp) {
		this.idp = idp;
	}


	public String getCif() {
		return cif;
	}


	public void setCif(String cif) {
		this.cif = cif;
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


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrlImagen() {
		return urlImagen;
	}


	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
	

	
}
