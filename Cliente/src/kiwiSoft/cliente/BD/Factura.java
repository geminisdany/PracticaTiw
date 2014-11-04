package kiwiSoft.cliente.BD;

public class Factura {

	/*Atributos*/
	
	private int n_factura;
	private String cif;
	private int idc;
	private String fecha;
	private String hora;
	private float importe;
	private String direccion;
	private String provincia;
	private String ciudad;
	private String cp;
	private String pais;
	private String DNI;
	private String nombreC;
	
	/*Constructor*/

	public Factura(int n_factura, String cif, int idc, String fecha,
			String hora, float importe, String direccion, String provincia,
			String ciudad, String cp, String pais, String dNI, String nombreC) {
		super();
		this.n_factura = n_factura;
		this.cif = cif;
		this.idc = idc;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
		this.direccion = direccion;
		this.provincia = provincia;
		this.ciudad = ciudad;
		this.cp = cp;
		this.pais = pais;
		DNI = dNI;
		this.nombreC = nombreC;
	}

	public int getN_factura() {
		return n_factura;
	}

	public void setN_factura(int n_factura) {
		this.n_factura = n_factura;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public int getIdc() {
		return idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombreC() {
		return nombreC;
	}

	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	
	/*Getters and Setters*/
	
	
}
