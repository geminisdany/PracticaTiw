package kiwiSoft.cliente.BD;


public class Cliente {
	
	/*Atributos*/
	
	private int idc;
	private String nombre;
	private int tlf;
	private String email;
	private String direccion;
	
	/*Constructor*/
	
	public Cliente(int IdC, String Nombre, int Tlf, String Email, String Direccion) {

		this.idc=IdC;
		this.nombre=Nombre;
		this.tlf=Tlf;
		this.email=Email;
		this.direccion=Direccion;
		
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
}
