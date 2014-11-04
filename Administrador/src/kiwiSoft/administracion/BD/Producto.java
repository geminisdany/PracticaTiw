package kiwiSoft.administracion.BD;


public class Producto {
	
	private int idp;
	private String cif;		
	private int pre_min;
	private int pre_max;
	private int pre_act;
	private String tipo;	
	private String descripcion;
	private int stock;
	private String nombre;
	private boolean oferta;
	private String urlImagen;
	
	public Producto(int IdP,String CIF,int pre_min,int pre_max,String tipo,String descripcion, int stock, String nombre,String urlImagen) {
		this.idp=IdP;
		this.cif=CIF;
		this.pre_min=pre_min;
		this.pre_max=pre_max;
		this.tipo=tipo;
		this.descripcion=descripcion;
		this.nombre=nombre;
		this.stock=stock;
		this.oferta=false;
		this.pre_act=pre_max;
		this.urlImagen=urlImagen;
		
	}
	public Producto(int IdP,String CIF,int pre_min,int pre_max,String tipo,String descripcion, int stock, String nombre,String urlImagen,boolean oferta, int precio_actual) {
		this.idp=IdP;
		this.cif=CIF;
		this.pre_min=pre_min;
		this.pre_max=pre_max;
		this.tipo=tipo;
		this.descripcion=descripcion;
		this.nombre=nombre;
		this.stock=stock;
		this.oferta=oferta;
		this.pre_act=precio_actual;
		this.urlImagen=urlImagen;
		
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

	public int getPre_min() {
		return pre_min;
	}

	public void setPre_min(int pre_min) {
		this.pre_min = pre_min;
	}

	public int getPre_max() {
		return pre_max;
	}

	public void setPre_max(int pre_max) {
		this.pre_max = pre_max;
	}

	public int getPre_act() {
		return pre_act;
	}

	public void setPre_act(int pre_act) {
		this.pre_act = pre_act;
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

}
