package kiwiSoft.administracion.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.administracion.BD.Cliente;
import kiwiSoft.administracion.BD.SimulacionBD;

/**
 * Servlet implementation class gestionCliente
 */
@WebServlet("/gestionClientes")
public class GestionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SimulacionBD dbSimulacion;//Se declara la BD
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionCliente() {
        super();
        // TODO Auto-generated constructor stub
        this.dbSimulacion = new SimulacionBD(); //se inicializa la BD
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		Collection<Cliente> collection= dbSimulacion.dbClientes;
		
		String accion = request.getParameter("action");
		if(accion!=null){
			if(accion.equals("borrar")){
				int id = Integer.parseInt(request.getParameter("idc"));
				dbSimulacion.eliminarCLiente(id);
			}
		}
		
		request.setAttribute("listaClientes", collection);
		request.setAttribute("panelCliente", true);
		System.out.println("envio lista de clientes");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Cliente> collection= dbSimulacion.dbClientes;
		
		HttpSession sesionAdmin = request.getSession();
		Boolean validado = (Boolean) sesionAdmin.getAttribute("adminValidado");
		if(validado){
			System.out.println("esta validado, se puede editar******"); ////DEBUG
			int idc = Integer.parseInt(request.getParameter("idc"));
			String email = request.getParameter("email");
			String direccion = request.getParameter("direccion");
			String nombre = request.getParameter("nombre");
			int telefono = Integer.parseInt(request.getParameter("tlf"));
			
			try {
				Cliente cliente = new Cliente(idc, nombre, telefono, email, direccion);
				dbSimulacion.editarCliente(idc, cliente);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al editar el cliente"+idc);
			}
		}
		
		request.setAttribute("listaClientes", collection);
		request.setAttribute("panelCliente", true);
		System.out.println("envio lista de clientes");///DEBUG
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
