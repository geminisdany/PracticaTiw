package kiwiSoft.proveedor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.proveedor.BD.Producto;
import kiwiSoft.proveedor.BD.Proveedor;
import kiwiSoft.proveedor.BD.SimulacionBD;

/**
 * Servlet implementation class GestionarProducto
 */
@WebServlet("/GestionarProducto")
public class GestionarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimulacionBD dbSimulacion;// Se declara la BD
	HttpSession sesionProv;
	public Proveedor provLogeado;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		if ((Boolean) sesionProv.getAttribute("adminValidado")){
			this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sesionProv  = request.getSession();
		dbSimulacion = (SimulacionBD) sesionProv.getAttribute("simulacionBaseDatos");
		provLogeado = (Proveedor) sesionProv.getAttribute("proveedorLogeado");
		String cifP = provLogeado.getCif();
		Boolean validado = (Boolean) sesionProv.getAttribute("adminValidado");
		String formProd = (String) sesionProv.getAttribute("formularioProducto");
		if(validado && cifP != null && formProd != null){
			Producto producto  = null;
			try{
				String descripcion = request.getParameter("descripcion");
				String cif = cifP;
				String nombre = request.getParameter("nombre");
				double pre_min = Double.parseDouble(request.getParameter("pre_min"));
				double pre_max = Double.parseDouble(request.getParameter("pre_max"));
				int stock = Integer.parseInt(request.getParameter("stock"));
				String tipo = request.getParameter("tipo");
				String urlImagen = request.getParameter("urlImagen");
				producto = new Producto (cif, pre_min, pre_max, tipo, descripcion, stock, nombre, urlImagen);
			} catch (Exception e) {
				System.out.println("Error al editar el Producto");
			}
			try {
				if(formProd.equals("aniadir")){
					dbSimulacion.anadirProductos(producto);
					sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
					this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
				} else {
					int idp = Integer.parseInt(request.getParameter("idp"));
					producto.setIdp(idp);
					dbSimulacion.editarProductos(idp, producto);
					sesionProv.setAttribute("simulacionBaseDatos", dbSimulacion);
					this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al editar el Producto ");
			}
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}

	}
}
