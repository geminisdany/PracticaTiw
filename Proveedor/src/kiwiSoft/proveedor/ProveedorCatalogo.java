package kiwiSoft.proveedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import kiwisoft.daos.PedidosDAO;
import kiwisoft.daos.ProductoDAO;
import kiwisoft.daos.SuscripcionDAO;
import kiwisoft.dominios.*;


/**
 * Servlet implementation class ProveedorCatalogo
 */
@WebServlet("/ProveedorCatalogo")
public class ProveedorCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private Proveedor provLogeado;
	private ProductoDAO productoDao;
	private SuscripcionDAO suscripcionDao;
	private PedidosDAO pedidosDao;
	HttpSession sesionProv;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorCatalogo() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
    	productoDao = new ProductoDAO(em,ut);
    	suscripcionDao = new SuscripcionDAO(em,ut);
    	pedidosDao = new PedidosDAO(em,ut);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		productoDao = null;
		suscripcionDao = null;
		pedidosDao = null;
	}
	
	public ArrayList<Producto> arrayProductos (Collection<Producto> auxiliar){
    	ArrayList<Producto> arrayProductos = new ArrayList<Producto>();
    	Iterator<Producto> aux = auxiliar.iterator();
		Producto iteracion;
		while(aux.hasNext()){
			iteracion = aux.next();
			arrayProductos.add(iteracion);
		}
		return arrayProductos;
    }
     
    public ArrayList<Suscripcion> obtenerSuscripciones(Collection<Producto> listaProductos) {
		/*ArrayList<Cliente> listaClientes= new ArrayList<Cliente>();*/
		Iterator<Producto> productoIterator = listaProductos.iterator();
		Collection<Suscripcion> auxiliar;
		Iterator<Suscripcion> suscripcionesIterator;
		ArrayList<Suscripcion> listaSuscripciones = new ArrayList<Suscripcion>();
		while(productoIterator.hasNext()){
			Producto prod = productoIterator.next();
			auxiliar = suscripcionDao.buscarSuscripcionProducto(prod.getId());
			if(auxiliar != null){
				suscripcionesIterator = auxiliar.iterator();
				while(suscripcionesIterator.hasNext()){
					Suscripcion susc = suscripcionesIterator.next();
					listaSuscripciones.add(susc);
					/*listaClientes.add(susc.getCliente());*/
				}
			}
		}
		
		return listaSuscripciones;
	}
    
    public ArrayList<Producto> productosStockBajo (Collection<Producto> auxiliar){
    	ArrayList<Producto> arrayProductos = new ArrayList<Producto>();
    	Iterator<Producto> aux = auxiliar.iterator();
		Producto iteracion;
		while(aux.hasNext()){
			iteracion = aux.next();
			if (iteracion.getStock() <= iteracion.getUmbralStock()){
				arrayProductos.add(iteracion);
			}
		}
		return arrayProductos;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		provLogeado = (Proveedor) sesionProv.getAttribute("proveedorLogeado");
		Long idProvLogeado = provLogeado.getId();
		String cifP = provLogeado.getCif();
		if (cifP != null && (Boolean) sesionProv.getAttribute("adminValidado")){
			String event = null;
			if(request.getAttribute("evento") != null){
				event = (String) request.getAttribute("evento");
				
			} else if(request.getParameter("evento") != null){
				event = request.getParameter("evento");
				
			} 
			if(event != null){
				Collection<Producto> resp;
				if(event.equals("todos")){
					resp = productoDao.buscarProductoProveedor(idProvLogeado);
				} else if (event.equals("oferta")){
					resp = productoDao.buscarProductoProveedorOferta(idProvLogeado);
				} else {
					resp = productoDao.buscarProductoProveedorTipo(idProvLogeado, event);
				}
				ArrayList<Producto> respuesta = arrayProductos(resp);
				request.setAttribute("arrayProductos", respuesta);
				sesionProv.setAttribute("categoriaProd", event);
				this.getServletContext().getRequestDispatcher("/proveedor-misproductos.jsp").forward(request, response);
			} else if (request.getParameter("idProducto") != null){
				Long idProd = Long.parseLong(request.getParameter("idProducto"));
				System.out.println("**************IDPROD " + idProd);
				Producto prodSeleccionado = productoDao.buscarProducto(idProd);
				request.setAttribute("productoID", prodSeleccionado);
				this.getServletContext().getRequestDispatcher("/proveedor-producto.jsp").forward(request, response);
			} else if (request.getParameter("aniadir") != null){
				sesionProv.setAttribute("formularioProducto", "aniadir");
				this.getServletContext().getRequestDispatcher("/proveedor-altaproducto.jsp").forward(request, response);
			} else if (request.getParameter("modificar") != null){
				sesionProv.setAttribute("formularioProducto", "modificar");
				Long idProd = Long.parseLong(request.getParameter("modificar"));
				Producto prodSeleccionado = productoDao.buscarProducto(idProd);
				request.setAttribute("productoID", prodSeleccionado);
				this.getServletContext().getRequestDispatcher("/proveedor-modifproducto.jsp").forward(request, response);
			} else if (request.getParameter("salir") != null){
				sesionProv.setAttribute("adminValidado", false);
				this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
			} else if (request.getParameter("suscripcion") != null){
				request.setAttribute("haySuscripciones",false);
				Collection<Producto> productosLogeado;
				productosLogeado = productoDao.buscarProductoProveedor(idProvLogeado);
				ArrayList<Suscripcion> suscripcionesProductos = new ArrayList<Suscripcion>();
				suscripcionesProductos = obtenerSuscripciones(productosLogeado);
				if(suscripcionesProductos.size() > 0){
					request.setAttribute("haySuscripciones",true);
					request.setAttribute("listaSuscripcion",suscripcionesProductos);
				}
				this.getServletContext().getRequestDispatcher("/proveedor-suscripciones.jsp").forward(request, response);
			} else if (request.getParameter("avisos") != null){
				request.setAttribute("hayAvisos",false);
				Collection<Producto> productosLogeado;
				productosLogeado = productoDao.buscarProductoProveedor(idProvLogeado);
				ArrayList<Producto> stockBajo = productosStockBajo(productosLogeado);
				if(stockBajo.size() > 0){
					request.setAttribute("hayAvisos",true);
					request.setAttribute("listaAvisos",stockBajo);
				}
				this.getServletContext().getRequestDispatcher("/proveedor-avisos.jsp").forward(request, response);
			} else if (request.getParameter("factura") != null){
				request.setAttribute("hayFacturas",false);
				Collection<Pedido> pedidosLog;
				pedidosLog = pedidosDao.ordenarByFechaProveedor(idProvLogeado);
				if(pedidosLog.size() > 0){
					request.setAttribute("hayFacturas",true);
					request.setAttribute("listaPedidos",pedidosLog);
				}
				this.getServletContext().getRequestDispatcher("/proveedor-facturacion.jsp").forward(request, response);
			} else{
				sesionProv.setAttribute("formProveedor", "cuenta");
				request.setAttribute("cuentaProveedores", provLogeado);
				Direccion direccionLogeado = provLogeado.getDireccion();
				request.setAttribute("cuentaProvDireccion", direccionLogeado);
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