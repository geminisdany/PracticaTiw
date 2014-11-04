package kiwiSoft.proveedor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.proveedor.BD.Proveedor;
import kiwiSoft.proveedor.BD.SimulacionBD;

/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
     	
	private SimulacionBD dbSimulacion;//Se declara la BD
	public Proveedor provLogeado;
	HttpSession sesionProv;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sesionProv  = request.getSession();
		if ((Boolean) sesionProv.getAttribute("adminValidado")){
			this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		dbSimulacion = (SimulacionBD) sesionProv.getAttribute("simulacionBaseDatos");
		Proveedor provRegistrado  = null;
		String formProv = (String) sesionProv.getAttribute("formProveedor");
		try{
			String cif = request.getParameter("cif");
			String nombre = request.getParameter("nombre");
			String direccion = request.getParameter("direccion");
			int telefono = Integer.parseInt(request.getParameter("tlf"));
			String email = request.getParameter("email");
			String contrasenia = request.getParameter("contras");
			String web = request.getParameter("web");
			provRegistrado = new Proveedor (cif, nombre, direccion, telefono, email, contrasenia, web);
		} catch (Exception e) {
			System.out.println("Error al crear el Proveedor");
		}
		try {
			if(formProv.equals("registro")){
				sesionProv.setAttribute("adminValidado", true);
				provRegistrado.setIdSesion(sesionProv.getId());
				dbSimulacion.anadirProveedor(provRegistrado);
				sesionProv.setAttribute("proveedorLogeado", provRegistrado);
				sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
				request.setAttribute("evento", "todos");
				this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
			} else {
				String cifProv = provRegistrado.getCif();
				dbSimulacion.editarProveedor(cifProv, provRegistrado);
				sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
				this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al editar el Producto ");
		}

	}

}
