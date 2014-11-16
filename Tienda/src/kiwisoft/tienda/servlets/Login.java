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
import kiwisoft.dominios.Cliente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
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
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesionAdmin = request.getSession();
		sesionAdmin.setAttribute("clienteValidado",null);
		response.setContentType("text/html");
		this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("user");
		String password = request.getParameter("password");
		HttpSession sesionAdmin = request.getSession();
		try {
			Cliente cliente = cliDao.buscarPorEmailYpassword(email, password);
			if(cliente!=null){
				sesionAdmin.setAttribute("clienteValidado",cliente.getNombre());
				sesionAdmin.setAttribute("idCliente",cliente.getId());
			}
		} catch (Exception e) {
			// TODO: handle exception
			/**enviar notifiacion al usuario que no existe el email o contraseña*/
			System.out.println("Error al buscar al usuario");
		}
		
		
		
		response.setContentType("text/html");
		this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
