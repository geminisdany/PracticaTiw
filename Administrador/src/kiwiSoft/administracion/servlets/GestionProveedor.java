package kiwiSoft.administracion.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.administracion.BD.Proveedor;
import kiwiSoft.administracion.BD.SimulacionBD;

/**
 * Servlet implementation class gestionProveedor
 */
@WebServlet("/gestionProveedores")
public class GestionProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulacionBD dbSimulacion;
    /**
     **@see HttpServlet#HttpServlet()
     */
    public GestionProveedor() {
        super();
        // TODO Auto-generated constructor stub
        this.dbSimulacion = new SimulacionBD();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				
				Collection<Proveedor> collection= dbSimulacion.dbProveedores;
				
				String accion = request.getParameter("action");
				if(accion!=null){
					if(accion.equals("borrar")){
						String cif = request.getParameter("cif");
						dbSimulacion.eliminarProveedor(cif);
					}
				}
				
				request.setAttribute("listaProveedor", collection);
				request.setAttribute("panelProveedor", true);
				System.out.println("envio lista de proveedores");///DEBUG
				
				response.setContentType("text/html");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/****/
		HttpSession sesionAdmin = request.getSession();
		Boolean validado = (Boolean) sesionAdmin.getAttribute("adminValidado");
		if(validado){
			System.out.println("esta validado, se puede editar el Proveedor******"); ////DEBUG
			String cif = request.getParameter("cif");
			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			String email = request.getParameter("email");
			int tlf = Integer.parseInt(request.getParameter("tlf"));
			String web = request.getParameter("web");
			
			try {
				Proveedor proveedor = new Proveedor(cif, nombre, direccion, tlf, email, web);	
				dbSimulacion.editarProveedor(cif, proveedor);
				System.out.println("actualizado proveedor*****"); ///DEBUG
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al editar el Proveedor"+":"+cif);
			}
		}
		/****/
		Collection<Proveedor> collection= dbSimulacion.dbProveedores;
		request.setAttribute("listaProveedor", collection);
		request.setAttribute("panelProveedor", true);
		System.out.println("envio lista de proveedores");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
