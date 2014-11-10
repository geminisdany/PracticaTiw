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
import javax.transaction.UserTransaction;

import kiwisoft.daos.ClienteDAO;
import kiwisoft.dominios.Cliente;
import kiwisoft.dominios.Direccion;


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
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		cliDao = new ClienteDAO(em,ut);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		cliDao=null;
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
			case "formulario":
				request.setAttribute("action", "registroCliente");
				break;
			
			case "resgitrar":
				/**registrar entran por post**/
				break;
			case "mostrarDatos":
				request.setAttribute("action","mostrarDatos");
				break;
			
			case "cambiarDatos":
				/**los datos entran por post**/
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
			
			case "cambiarDatos":
				/**los datos entran por post**/
				break;

			default:
				break;
			}
			
		}
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
