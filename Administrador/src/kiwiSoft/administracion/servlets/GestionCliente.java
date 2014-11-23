package kiwiSoft.administracion.servlets;

import java.io.IOException;
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









//import kiwiSoft.administracion.BD.Cliente;
//import kiwiSoft.administracion.BD.SimulacionBD;
import kiwisoft.daos.ClienteDAO;
import kiwisoft.dominios.Cliente;

/**
 * Servlet implementation class gestionCliente
 */
@WebServlet("/gestionClientes")
public class GestionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource()
	private UserTransaction ut;
	
	private ClienteDAO cliDao;
	//private SimulacionBD dbSimulacion;//Se declara la BD
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.cliDao=new ClienteDAO(em, ut);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		this.cliDao=null;
	}
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCliente() {
        super();
        // TODO Auto-generated constructor stub
        //this.dbSimulacion = new SimulacionBD(); //se inicializa la BD
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		String accion = request.getParameter("action");
		if(accion!=null){
			if(accion.equals("borrar")){
				Long idC = Long.parseLong(request.getParameter("idc"));
				Cliente cliente=cliDao.buscarClienteID(idC);
				if(cliente!=null){
					try {
						cliDao.borrarCliente(cliente);
						System.out.println("++++Borrar Cliente, se ha borrado con exito");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("****Borrar Cliente, Error al borrar Cliente");
						e.printStackTrace();
					}
				}
			}
		}
		request.setAttribute("listaClientes", listaClientes());
		request.setAttribute("panelCliente", true);
		System.out.println("envio lista de clientes");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private Collection<Cliente> listaClientes() {
		// TODO Auto-generated method stub
		Collection<Cliente> listaClientes=null;
		try {
			listaClientes = cliDao.listarCliente();
			System.out.println("+++++Listar Clientes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*******Listar CLientes, error al listar los clientes");
			e.printStackTrace();
		}
		return listaClientes;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Collection<Cliente> collection= dbSimulacion.dbClientes;
		
		HttpSession sesionAdmin = request.getSession();
		String admValidado = (String) sesionAdmin.getAttribute("adminValidado");
		if(admValidado!=null){
			System.out.println("esta validado, se puede editar******"); ////DEBUG
			Long idC = Long.parseLong(request.getParameter("id"));
			
	
				
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
				
				///Obtenemos el cliente buscando por su id (se busca en la BD)
				Cliente cliente = cliDao.buscarClienteID(idC);
				
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
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("**Modificar Cliente**Error al actualizar el cliente***");
			}
		}
		
		request.setAttribute("listaClientes", listaClientes());
		request.setAttribute("panelCliente", true);
		System.out.println("envio lista de clientes");///DEBUG
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
