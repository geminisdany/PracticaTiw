package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity
@Table(name = "administrador")
public class Administrador implements Serializable {

	   
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	
	
	
	public Administrador(String nombre, String email, String password) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.password = password;
	}
	
	public Administrador() {
		super();
	} 
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	  
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
