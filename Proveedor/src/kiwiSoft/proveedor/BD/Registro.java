package kiwiSoft.proveedor.BD;

public class Registro {
	/*Atributos*/
	
	private String email;
	private String contras;	
	
	/*Constructor*/
	
	public Registro(String Email, String Contras) {
		
		this.email=Email;
		this.contras=Contras;
		
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
	
	/*Getters and Setters*/
	
}
