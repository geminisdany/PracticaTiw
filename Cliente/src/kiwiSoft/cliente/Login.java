package kiwiSoft.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
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
		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = "";
		if(request.getParameter("nombre") != null){
			nombre = request.getParameter("Tom");
		}
		if(nombre.equalsIgnoreCase("Tom")){
			this.getServletConfig().getServletContext().getRequestDispatcher("/indecCliente.jsp").forward(request, response);
		}
		// TODO Auto-generated method stub
		List<String> lista = new ArrayList<String>();
		lista.add("elemento1");
		lista.add("elemento2");
		lista.add("elemento3");
		
	}

}
