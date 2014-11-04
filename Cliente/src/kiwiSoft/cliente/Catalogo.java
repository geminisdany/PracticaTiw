package kiwiSoft.cliente;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiwiSoft.cliente.BD.Producto;
import kiwiSoft.cliente.BD.SimulacionBD;

/**
 * Servlet implementation class Catalogo
 */
@WebServlet("/catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SimulacionBD simulacionbd;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Catalogo() {
        super();
        simulacionbd = new SimulacionBD();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String tipoCatalogo= request.getParameter("tipoCatalogo");
				if(tipoCatalogo!=null){			
					System.out.println("busco el tipo:" + tipoCatalogo);
					Collection<Producto> collection=simulacionbd.obtenerCatalogo(tipoCatalogo);
					System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
					request.setAttribute("tipoCatalogo",tipoCatalogo);
					request.setAttribute("listaProducto", collection);
				}
				request.setAttribute("catalogo", true);	
				System.out.println("muestro catalogo");/////DEBUG
				response.setContentType("text/html");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
