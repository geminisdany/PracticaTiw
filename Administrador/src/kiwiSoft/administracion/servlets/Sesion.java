package kiwiSoft.administracion.servlets;

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

import kiwisoft.daos.AdministradorDAO;
import kiwisoft.dominios.Administrador;


/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Login")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource()
	private UserTransaction ut;
	
	private AdministradorDAO admDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.admDao= new AdministradorDAO(em, ut);
    	iniciarDB();
    }
    

	@Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	this.admDao=null;
    	
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesionAdmin = request.getSession();
		/*se obtienen los parametros para cerrar sesion al administrador*/
		System.out.println("voy a leer cerrar Sesion");
		String accion = request.getParameter("action");	
		if(accion!=null){
			if(accion.equals("logOut")){
				sesionAdmin.setAttribute("adminValidado", null);		
			}
			System.out.println("*****Cerrando Sesion");/////DEBUG
		}
		request.setAttribute("Error", true);
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*se crea el parametro de sesion*/
		HttpSession sesionAdmin = request.getSession();
		sesionAdmin.setAttribute("adminValidado",null);
		/*se obtienen los parametros para validar el administrador*/
		String admin = request.getParameter("email");
		String pass = request.getParameter("password");
		
		try {
			Administrador administrador=admDao.buscarPorEmailYpassword(admin, pass);
			if (administrador!=null) {
				sesionAdmin.setAttribute("adminValidado", administrador.getNombre());
				System.out.println("++++Validar Administrador, con exito");/////DEBUG
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("errorLogin", true);	
			sesionAdmin.setAttribute("adminValidado", null);
			System.out.println("*****Validar Admin, Error en la validacion");/////DEBUG
		}
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	
	}
	
	
	
	
	
	
	
	
	 private void iniciarDB() {
			// TODO Auto-generated method stub
		 Administrador admin=null;
		 	try {
		 		admDao.buscarPorEmailYpassword("admin@admin", "admin");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("no hay Administradores en la BD, se creara uno");
			}
			
			if (admin==null) {
				Administrador adm1= new Administrador("Administrador", "admin@admin", "admin");
				try {
					adm1=admDao.guardarAdmin(adm1);
					System.out.println("++++Guardar Admin, se ha guardado el Administrador");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("****Guardar Administrador, Error al guardar");
				}
			}
		}

}
