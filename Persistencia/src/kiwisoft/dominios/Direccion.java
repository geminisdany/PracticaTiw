package kiwisoft.dominios;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Direccion
 *
 */
@Entity
@Table(name = "direccion")
public class Direccion implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private String ciudad;
	@Column(nullable = false)
	private String provincia;
	@Column(nullable = false)
	private String pais;
	@Column(nullable = false)
	private int cp;
	
	public Direccion() {
		super();
	}  
	public Direccion(String direccion, String ciudad, String provincia,
			String pais, int cp) {
		super();
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.provincia = provincia;
		this.pais = pais;
		this.cp = cp;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	 
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
   
}
