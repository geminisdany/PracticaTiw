package kiwiSoft.proveedor;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.proveedor.BD.Proveedor;
import kiwiSoft.proveedor.BD.SimulacionBD;

/**
 * Servlet implementation class SesionProveedor
 */
@WebServlet("/SesionProveedor")
public class SesionProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private SimulacionBD dbSimulacion;//Se declara la BD
	HttpSession sesionProv;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SesionProveedor() {
        super();
        this.dbSimulacion = new SimulacionBD(); //se inicializa la BD
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sesionProv = request.getSession();
		sesionProv.setAttribute("adminValidado",false);
		sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
		sesionProv.setAttribute("formProveedor", "registro");
		this.getServletContext().getRequestDispatcher("/proveedor-registroUsuario.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*se crea el parametro de sesion*/
		sesionProv = request.getSession();
		sesionProv.setAttribute("adminValidado",false);
		/*se obtienen los parametros para validar el proveedor*/
		String admin = request.getParameter("user");
		String pass = request.getParameter("password");
		if(admin!=null){
			Collection<Proveedor> auxiliar = dbSimulacion.dbProveedores;
			Iterator<Proveedor> aux = auxiliar.iterator();
			Proveedor prueba;
			while(aux.hasNext()){
				prueba = aux.next();
				if(admin.equals(prueba.getEmail()) && pass.equals(prueba.getContras())){
					sesionProv.setAttribute("adminValidado", true);
					prueba.setIdSesion(sesionProv.getId());
					sesionProv.setAttribute("proveedorLogeado", prueba);
					request.setAttribute("evento", "todos");
					sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
					this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
				}
			}
		}
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
