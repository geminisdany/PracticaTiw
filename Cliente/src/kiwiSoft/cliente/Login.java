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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	
/*	listado.jsp
	<%@ tagLib uri="http://java.sun.com/jsp/jstl/coreprefix"="c"%>
	<body><c:if test=${listado !=null}>
	<c:forEach var="elemento"	item="${listdo}">
		${elemento}
		<tR><tD><c:out var="${elemento}/>
	</c:forEach>
	</table>
	</c:if>
	
		request.setAttribute("Sol", lista);
		HttpSession sesion = request.getSession();
		
		sesion.setAttribute("nombreSesion", "valor de la sesion");
		this.getServletConfig().getServletContext().getRequestDispatcher("/Sol.jsp").forward(request, response);
	}
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}