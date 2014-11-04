package kiwiSoft.cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiwiSoft.cliente.BD.SimulacionBD;
import kiwiSoft.cliente.BD.Pedido;



/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulacionBD dbSimulacion;
    public Pedido pedido;
    public ArrayList<Pedido> dbPedido;
	public Object obtener;
	
    public ServletCarrito() {
        super();
        this.dbSimulacion = new SimulacionBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getParameter("action");
		if(accion!=null){
			if(accion.equals("borrar")){
				int idp = Integer.parseInt(request.getParameter("idp"));
				dbSimulacion.eliminarPedido(idp);
			}
		}
		
		Collection<Pedido> collection= dbSimulacion.dbPedido;
		request.setAttribute("listaPedido", collection);
		request.setAttribute("panelPedido", true);
		System.out.println("envio lista de productos");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/gestionCompra.jsp").forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  
		Collection<Pedido> collection= dbSimulacion.dbPedido;	

		System.out.println("esta validado, se puede editar el Prodcuto******"); ////DEBUG
		int Nfactura = Integer.parseInt(request.getParameter("Nfactura"));
		int idp = Integer.parseInt(request.getParameter("idp"));
		String nombre = request.getParameter("nombre");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		double precio = Integer.parseInt(request.getParameter("precio"));
		
		try {
			new Pedido(Nfactura, idp, nombre, cantidad, precio);					
			
		} catch (Exception e) {
			System.out.println("Error al editar el Producto"+idp);
		}	
		
		request.setAttribute("listaPedido", collection);
		request.setAttribute("panelPedido", true);
		System.out.println("envio lista de productos");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/gestionCompra.jsp").forward(request, response);
	
	}
}
