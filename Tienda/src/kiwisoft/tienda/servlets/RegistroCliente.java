package kiwisoft.tienda.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import kiwisoft.daos.ClienteDAO;
import kiwisoft.daos.FacturaDAO;
import kiwisoft.dominios.Cliente;
import kiwisoft.dominios.Direccion;
import kiwisoft.dominios.Factura;


/**
 * Servlet implementation class RegistroCliente
 */
@WebServlet("/registro")
public class RegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private ClienteDAO cliDao;
	private FacturaDAO facDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		cliDao = new ClienteDAO(em,ut);
		facDao = new FacturaDAO(em,ut);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		cliDao=null;
		facDao=null;
	}
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesionRegistro = request.getSession();
		Long idCliente = (Long) sesionRegistro.getAttribute("idCliente");
		Collection<Factura> facturas=null;
		String action= request.getParameter("action");
		
		if (action!=null) {
			switch (action) {
			case "formulario":///muestra el formulario de registro del cliente 
				request.setAttribute("action", "registroCliente");
				break;
			
			case "resgitrar":
				/**registrar entran por post**/
				break;
			
			case "modificarCliente":///muestra el formulario para cambiar los datos
				
				Cliente cliente = cliDao.buscarClienteID(idCliente);
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelDatos",true);
				request.setAttribute("cliente", cliente);
				break;
			
			case "cambiarPass": ///muestrado el formulario para cambiar la contraseña 
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelPass",true);
				break;
			
			
				
			case "historial":///muestra la lista de facturas
				
				Cliente clienteHistorial=null;
				try{
					 clienteHistorial = cliDao.buscarClienteID(idCliente);
				}catch(Exception e){
					System.out.println("******Historial* Error al buscar el cliente");////DEBUG
				}
				
				if(clienteHistorial.getFacturas().size()>0){
					request.setAttribute("listaFacturas",clienteHistorial.getFacturas());
					request.setAttribute("hayFacturas",true);
				}
				request.setAttribute("panelHistorial",true);
				request.setAttribute("action","seccionCliente");
				
				break;
			
			case "detalleFactura":
				Factura factura=null;
				
				Long idFac = Long.parseLong(request.getParameter("id"));
				try{
					factura = facDao.buscarFactura(idFac);
				}catch(Exception e){
					System.out.println("******Historial* Error al buscar la factura");////DEBUG
				}
				
				request.setAttribute("factura",factura);
				request.setAttribute("listaPedidos",factura.getPedidos());
				request.setAttribute("hayFacturas",true);
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelHistorial",true);
				break;
			
			case "buscarFacturasByFecha":
				System.out.println("++++buscando facturas");
				String fecha =request.getParameter("fecha");
				System.out.println("++++Busca Factura, Se busca la fecha: "+fecha);
				
				try {
					facturas=facDao.buscarByFecha(convertirFecha(fecha), idCliente);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*****Buscar por Fecha, Error al buscar por fecha");///DEBUG
					e.printStackTrace();
				}
				
				if(facturas.size()>0){
					request.setAttribute("listaFacturas",facturas);
					request.setAttribute("hayFacturas",true);
				}
				request.setAttribute("panelHistorial",true);
				request.setAttribute("action","seccionCliente");
				break;
			
			
			case "ordenarByFecha":
				try {
					facturas=facDao.ordenarByFecha(idCliente);
					System.out.println("+++Ordenar por fecha, Se ordena por fecha las facturas");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*****Ordenar por Fecha, Error al ordenar por fecha");///DEBUG
				}
				if(facturas.size()>0){
					request.setAttribute("listaFacturas",facturas);
					request.setAttribute("hayFacturas",true);
				}
				request.setAttribute("panelHistorial",true);
				request.setAttribute("action","seccionCliente");
				break;
			
			default:
				break;
			}
			
		}
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesionRegistro = request.getSession();
		String action= request.getParameter("action");
			
		if (action!=null) {
			switch (action) {		
			case "registrar":
				String nomReg= request.getParameter("nombreC");
				String apeReg= request.getParameter("apellidosC");
				String emailReg= request.getParameter("emailC");
				int telReg= Integer.parseInt(request.getParameter("telefonoC"));
				String passReg= request.getParameter("pass2C");
				String paisReg= request.getParameter("paisC");
				String proReg= request.getParameter("provinciaC");
				String ciuReg= request.getParameter("ciudadC");
				String dirReg= request.getParameter("direccionC");
				int cpReg= Integer.parseInt(request.getParameter("cpC"));
				System.out.println("datos: "+nomReg+apeReg+emailReg+telReg+passReg+proReg+paisReg+ciuReg+dirReg+cpReg);///DEBUG
				
				Direccion nuevaDireccion=new Direccion(dirReg, ciuReg, proReg, paisReg, cpReg);	
				Cliente nuevoCliente = new Cliente(nomReg, apeReg, telReg, emailReg, passReg, nuevaDireccion);
				System.out.println("datos en proceso");///DEBUG
				try {
					nuevoCliente = cliDao.guardarCliente(nuevoCliente);
					System.out.println("****************se ha guardado el nuevo cliente******************");///DEBUG
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				break;
			
			case "editarCliente":
				/**los datos entran por post**/
				String nomEdit= request.getParameter("nombreC");
				String apeEdit= request.getParameter("apellidosC");
				String emailedit= request.getParameter("emailC");
				int telEdit= Integer.parseInt(request.getParameter("telefonoC"));
				String paisEdit= request.getParameter("paisC");
				String proEdit= request.getParameter("provinciaC");
				String ciuEdit= request.getParameter("ciudadC");
				String dirEdit= request.getParameter("direccionC");
				int cpEdit= Integer.parseInt(request.getParameter("cpC"));
				System.out.println("datos a editar: "+nomEdit+apeEdit+emailedit+telEdit+proEdit+paisEdit+ciuEdit+dirEdit+cpEdit);///DEBUG
			    
				///Se obtiene el id del cliente (que se guardo en la Sesion)
				Long idCliente = (Long) sesionRegistro.getAttribute("idCliente");
				
				///Obtenemos el cliente buscando por su id (se busca en la BD)
				Cliente cliente = cliDao.buscarClienteID(idCliente);
				
				cliente.setNombre(nomEdit);
				cliente.setApellidos(apeEdit);
				cliente.setEmail(emailedit);
				cliente.setTelefono(telEdit);
				cliente.getDireccion().setProvincia(proEdit);
				cliente.getDireccion().setCiudad(ciuEdit);
				cliente.getDireccion().setPais(paisEdit);
				cliente.getDireccion().setDireccion(dirEdit);
				cliente.getDireccion().setCp(cpEdit);
				
				try {
					cliDao.actualizarCliente(cliente);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("**Modificar Cliente**Error al actualizar el cliente***");
				}
				break;
				
			case "cambiarPass":
				String passActualC= request.getParameter("passActual");
				
				String pass1C= request.getParameter("pass1C");
				//String pass2C= request.getParameter("pass2C");
				
				///Se obtiene el id del cliente (que se guardo en la Sesion)
				
				Long idPass = (Long) sesionRegistro.getAttribute("idCliente");
				
				///Obtenemos el cliente buscando por su id (se busca en la BD)
				Cliente clientePass = cliDao.buscarClienteID(idPass);
				
				if(passActualC.equals(clientePass.getPassword())){
					clientePass.setPassword(pass1C);
					try {
						cliDao.actualizarCliente(clientePass);
						System.out.println("+++++Cambiar Pass+++Se ha cambiado la contraseña");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("***********Cambiar Pass *** Error al guardar la nueva contraseña ");
					}
				}else{
					System.out.println("*Error en la contraseña Actual");
				}
				
				break;

			default:
				break;
			}
			
		}
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	
	private Date convertirFecha(String fecha) {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date convFecha=null;
		try {
			convFecha=formatter.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date(convFecha.getTime());
	}

}
