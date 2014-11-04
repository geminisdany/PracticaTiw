package kiwiSoft.proveedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kiwiSoft.proveedor.BD.Proveedor;
import kiwiSoft.proveedor.BD.Producto;
import kiwiSoft.proveedor.BD.SimulacionBD;

/**
 * Servlet implementation class ProveedorCatalogo
 */
@WebServlet("/ProveedorCatalogo")
public class ProveedorCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private SimulacionBD dbSimulacion;//Se declara la BD
	public Proveedor provLogeado;
	HttpSession sesionProv;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorCatalogo() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    
    public ArrayList<Producto> seleccionaProductos (String categoria, String cifProv){
    	ArrayList<Producto> dbProductos = new ArrayList<Producto>();
    	Collection<Producto> auxiliar = dbSimulacion.dbProductos;
		Iterator<Producto> aux = auxiliar.iterator();
		Producto iteracion;
		while(aux.hasNext()){
			iteracion = aux.next();
			if(categoria.equals(iteracion.getTipo()) && cifProv.equals(iteracion.getCif())){
				dbProductos.add(iteracion);
			} else if (categoria.equals("oferta") && iteracion.isOferta() && cifProv.equals(iteracion.getCif())){
				dbProductos.add(iteracion);
			} else if (categoria.equals("todos") && cifProv.equals(iteracion.getCif())){
				dbProductos.add(iteracion);
			}
		}
		return dbProductos;
    }
    
    public Producto buscarProducto (int idProd){
    	Producto prod = null;
    	Collection<Producto> auxiliar = dbSimulacion.dbProductos;
		Iterator<Producto> aux = auxiliar.iterator();
		Producto iteracion;
		while(aux.hasNext()){
			iteracion = aux.next();
			if(idProd == iteracion.getIdp()){
				prod = iteracion;
			} 
		}
    	return prod;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		dbSimulacion = (SimulacionBD) sesionProv.getAttribute("simulacionBaseDatos");        
		provLogeado = (Proveedor) sesionProv.getAttribute("proveedorLogeado");
		String cifP = provLogeado.getCif();
		ArrayList<Producto> respuesta = new ArrayList<Producto>();
		if (cifP != null && (Boolean) sesionProv.getAttribute("adminValidado")){
			String event = null;
			if(request.getAttribute("evento") != null){
				event = (String) request.getAttribute("evento");
				
			} else if(request.getParameter("evento") != null){
				event = request.getParameter("evento");
				
			} 
			if(event != null){
				respuesta = seleccionaProductos(event, cifP);
				request.setAttribute("arrayProductos", respuesta);
				sesionProv.setAttribute("categoriaProd", event);
				this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
			} else if (request.getParameter("idProducto") != null){
				int idProd = Integer.parseInt(request.getParameter("idProducto"));
				System.out.println("**************ID " + idProd);
				Producto prodSeleccionado = buscarProducto(idProd);
				request.setAttribute("productoID", prodSeleccionado);
				this.getServletContext().getRequestDispatcher("/proveedor-producto.jsp").forward(request, response);
			} else if (request.getParameter("aniadir") != null){
				sesionProv.setAttribute("formularioProducto", "aniadir");
				this.getServletContext().getRequestDispatcher("/proveedor-altaproducto.jsp").forward(request, response);
			} else if (request.getParameter("modificar") != null){
				sesionProv.setAttribute("formularioProducto", "modificar");
				int idProducto = Integer.parseInt(request.getParameter("modificar"));
				Producto prodSeleccionado = buscarProducto(idProducto);
				request.setAttribute("productoID", prodSeleccionado);
				this.getServletContext().getRequestDispatcher("/proveedor-modifproducto.jsp").forward(request, response);
			} else if (request.getParameter("salir") != null){
				sesionProv.setAttribute("adminValidado", false);
				this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
			} else{
				sesionProv.setAttribute("formProveedor", "cuenta");
				request.setAttribute("cuentaProveedores", provLogeado);
				this.getServletContext().getRequestDispatcher("/proveedor-ediciondatos.jsp").forward(request, response);
			}
			
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
