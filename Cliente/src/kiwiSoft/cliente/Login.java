package kiwiSoft.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String nombre = request.getParameter("user");
		String passwd = request.getParameter("password");
		HttpSession sesionAdmin = request.getSession();
		
		if(nombre != null && passwd!=null){
			if(nombre.equals("daniel")&&passwd.equals("daniel")){
				sesionAdmin.setAttribute("clienteValidado",nombre);
			}
		}
		response.setContentType("text/html");
		this.getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
