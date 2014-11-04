package kiwiSoft.administracion.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sesion
 */
@WebServlet("/Login")
public class Sesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesionAdmin = request.getSession();
		/*se obtienen los parametros para cerrar sesion al administrador*/
		System.out.println("voy a leer cerrar Sesion");
		String accion = request.getParameter("accion");	
		if(accion!=null){
			if(accion.equals("logOut")){
				sesionAdmin.setAttribute("adminValidado", false);		
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
		sesionAdmin.setAttribute("adminValidado",false);
		/*se obtienen los parametros para validar el administrador*/
		String admin = request.getParameter("email");
		String pass = request.getParameter("password");
		if(admin!=null){
			if(admin.equals("admin@admin.com") && pass.equals("admin")){
				sesionAdmin.setAttribute("adminValidado", true);
				System.out.println("Etoy validado!!!!");/////DEBUG
				
			}else{		
				request.setAttribute("errorLogin", true);	
				sesionAdmin.setAttribute("adminValidado", false);
				System.out.println("no estoy validado");/////DEBUG
			}
		}
		

		
		
		
		String respuesta = sesionAdmin.getAttribute("adminValidado").toString();/////DEBUG
		System.out.println(respuesta);/////DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

}
