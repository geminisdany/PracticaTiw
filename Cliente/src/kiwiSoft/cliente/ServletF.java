package kiwiSoft.cliente;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiwiSoft.cliente.BD.Factura;


/**
 * Servlet implementation class ServletF
 */
@WebServlet("/ServletF")
public class ServletF extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Factura factura;
	
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombreC");
		String ciudad = request.getParameter("ciudad");
		String direccion = request.getParameter("direccion");
		String pais = request.getParameter("pais");
		String DNI = request.getParameter("dni");
		String provincia = request.getParameter("provincia");
		String cp = request.getParameter("cp");
		factura = new Factura(0,null,0,null,null,0,direccion, provincia, ciudad, cp, pais, DNI, nombre);
		request.setAttribute("factura", factura);
		this.getServletConfig().getServletContext().getRequestDispatcher("/gestionCompra3.jsp").forward(request, response);
	}
}
