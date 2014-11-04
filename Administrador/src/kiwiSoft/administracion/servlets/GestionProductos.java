package kiwiSoft.administracion.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.administracion.BD.Producto;
import kiwiSoft.administracion.BD.SimulacionBD;

/**
 * Servlet implementation class gestionProductos
 */
@WebServlet("/gestionProductos")
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulacionBD dbSimulacion ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProductos() {
        super();
        // TODO Auto-generated constructor stub
        this.dbSimulacion = new SimulacionBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String accion = request.getParameter("action");
		if(accion!=null){
			if(accion.equals("borrar")){
				int idp = Integer.parseInt(request.getParameter("idp"));
				dbSimulacion.eliminarProducto(idp);
			}
			if(accion.equals("oferta")){
				int idp = Integer.parseInt(request.getParameter("idp"));
				dbSimulacion.productoOferta(idp);
			}
		}
		Collection<Producto> collection= dbSimulacion.dbProductos;
		request.setAttribute("listaProductos", collection);
		request.setAttribute("panelProducto", true);
		System.out.println("envio lista de productos");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				Collection<Producto> collection= dbSimulacion.dbProductos;
				
				HttpSession sesionAdmin = request.getSession();
				Boolean validado = (Boolean) sesionAdmin.getAttribute("adminValidado");
				if(validado){
					System.out.println("esta validado, se puede editar el Prodcuto******"); ////DEBUG
					int idp = Integer.parseInt(request.getParameter("idp"));
					String descripcion = request.getParameter("descripcion");
					String cif = request.getParameter("cif");
					String nombre = request.getParameter("nombre");
					String oferta = request.getParameter("oferta");
					
					int pre_act = Integer.parseInt(request.getParameter("pre_act"));
					int pre_min = Integer.parseInt(request.getParameter("pre_min"));
					int pre_max = Integer.parseInt(request.getParameter("pre_max"));
					int stock = Integer.parseInt(request.getParameter("stock"));
					String tipo = request.getParameter("tipo");
					String urlImagen = request.getParameter("urlImagen");
					boolean b_oferta=false;
					if(oferta.equalsIgnoreCase("Si")){
						b_oferta= true;
					}
					try {
						Producto producto = new Producto(idp, cif, pre_min, pre_max, tipo, descripcion, stock, nombre, urlImagen,b_oferta,pre_act);
						
						dbSimulacion.editarProductos(idp, producto);
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error al editar el Producto"+idp);
					}
				}
				
				request.setAttribute("listaProductos", collection);
				request.setAttribute("panelProducto", true);
				System.out.println("envio lista de productos");///DEBUG
				
				response.setContentType("text/html");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
