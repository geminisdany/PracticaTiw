package kiwisoft.tienda.servlets;

import java.io.IOException;

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
				HttpSession sesionRegistro = request.getSession();
				Long idCliente = (Long) sesionRegistro.getAttribute("idCliente");
				Cliente cliente = cliDao.buscarClienteID(idCliente);
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelDatos",true);
				request.setAttribute("cliente", cliente);
				break;
			
			case "cambiarPass": ///muestrado el formulario para cambiar la contraseña 
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelPass",true);
				break;
			
			case "suscripcion": ///muestra los productos a los que esta suscrito
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelSuscripcion",true);
				break;
				
			case "historial":///muestra la lista de facturas
				
				HttpSession sesionHistorial = request.getSession(); 
				Long idClienteH = (Long) sesionHistorial.getAttribute("idCliente");
				Cliente clienteHistorial=null;
				try{
					 clienteHistorial = cliDao.buscarClienteID(idClienteH);
				}catch(Exception e){
					System.out.println("******Historial* Error al buscar el cliente");////DEBUG
				}
				
				request.setAttribute("listaFacturas",clienteHistorial.getFacturas());
				
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelHistorial",true);
				break;
			
			case "detalleFactura":
				HttpSession sesionDetalleFactura = request.getSession(); 
				Long idClienteFac = (Long) sesionDetalleFactura.getAttribute("idCliente");
				Cliente clienteFactura=null;
				Factura factura=null;
				try{
					clienteFactura = cliDao.buscarClienteID(idClienteFac);
				}catch(Exception e){
					System.out.println("******Historial* Error al buscar el cliente");////DEBUG
				}
				Long idFac = Long.parseLong(request.getParameter("id"));
				try{
					factura = facDao.buscarFactura(idFac);
				}catch(Exception e){
					System.out.println("******Historial* Error al buscar la factura");////DEBUG
				}
				
				request.setAttribute("factura",factura);
				request.setAttribute("listaPedidos",factura.getPedidos());
				request.setAttribute("cliente",clienteFactura);
				
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelHistorial",true);
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

}
