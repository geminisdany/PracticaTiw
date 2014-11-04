package kiwiSoft.proveedor.BD;

public class Proveedor {

	/*Atributos*/
	
	private String cif;
	private String nombre;
	private String direccion;
	private int tlf;
	private String email;
	private String contras;
	private String web;
	private String idSesion;
	
	
	/*Constructor*/
	
	public Proveedor(String CIF, String Nombre, String Direccion, int Tlf, String Email, String Contras, String Web) {
		
		this.cif=CIF;
		this.nombre=Nombre;
		this.direccion=Direccion;
		this.tlf=Tlf;
		this.email=Email;
		this.contras = Contras;
		this.web=Web;
		this.idSesion = null;
		
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContras() {
		return contras;
	}

	public void setContras(String contras) {
		this.contras = contras;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}
	
	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
	}
	
	/*Getters and Setters*/
	
}
