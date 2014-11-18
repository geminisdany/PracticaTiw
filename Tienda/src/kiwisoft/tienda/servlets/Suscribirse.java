package kiwisoft.tienda.servlets;

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

import kiwisoft.daos.ClienteDAO;
import kiwisoft.daos.ProductoDAO;
import kiwisoft.daos.SuscripcionDAO;
import kiwisoft.dominios.Cliente;
import kiwisoft.dominios.Producto;
import kiwisoft.dominios.Suscripcion;

/**
 * Servlet implementation class Suscribirse
 */
@WebServlet("/suscribirse")
public class Suscribirse extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut; 
	
	private SuscripcionDAO susDao;
	private ClienteDAO cliDao;
	private ProductoDAO proDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Suscribirse() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	susDao= new SuscripcionDAO(em, ut);
    	cliDao= new ClienteDAO(em, ut);
    	proDao = new ProductoDAO(em,ut);
    }
    
    @Override
	public void destroy() {
		// TODO Auto-generated method stub
    	susDao=null;
    	cliDao=null;
    	proDao=null;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sesionSuscripcion = request.getSession();
		Producto producto=null;
		Cliente cliente=null;
		Suscripcion suscripcion=null;
		String action= request.getParameter("action");
		if (action!=null) {
			switch (action) {
			case "guardar":
				try {
					Long idp = Long.parseLong(request.getParameter("id"));
					producto = proDao.buscarProducto(idp);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
				try {
					Long idCliente = (Long) sesionSuscripcion.getAttribute("idCliente");
					cliente = cliDao.buscarClienteID(idCliente);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				suscripcion= new Suscripcion(producto, cliente);
				try {
					suscripcion=susDao.guardarSuscripcion(suscripcion);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("*****Suscripcion*Error al guardar la suscripcion");//DEBUG
				}
				cliente.getSuscripciones().add(suscripcion);
				try {
					cliDao.actualizarCliente(cliente);
					System.out.println("+++++Suscripcion Guardada");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;	
			
			case "borrar":
				try {
					Long idp = Long.parseLong(request.getParameter("id"));
					producto = proDao.buscarProducto(idp);
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					Long idCliente = (Long) sesionSuscripcion.getAttribute("idCliente");
					cliente = cliDao.buscarClienteID(idCliente);
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					  suscripcion=susDao.buscarSuscripcionClienteProducto(cliente.getId(), producto.getId());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
				  
				try {
					susDao.borrarSuscripcion(suscripcion);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("*****Suscripcion*Error al Borrar Suscripcion");
				}
				
				break;
				
			case "suscripcion": ///muestra los productos a los que esta suscrito
				
				try {
					Long idCliente = (Long) sesionSuscripcion.getAttribute("idCliente");
					cliente = cliDao.buscarClienteID(idCliente);
				} catch (Exception e) {
					// TODO: handle exception
				}
				Collection<Producto> listaProductos=null;
				if(cliente!=null){
					Collection<Suscripcion> listaSuscripciones =cliente.getSuscripciones();
					listaProductos = obtenerProductos(listaSuscripciones);
				}
				request.setAttribute("listaProductos",listaProductos);
				request.setAttribute("action","seccionCliente");
				request.setAttribute("panelSuscripcion",true);
				break;

				
			default:
				break;
			}
		}
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private Collection<Producto> obtenerProductos(
			Collection<Suscripcion> listaSuscripciones) {
		// TODO Auto-generated method stub
		Collection<Producto> listaProductos= new ArrayList<Producto>();
		Iterator<Suscripcion> nombreIterator = listaSuscripciones.iterator();
		while(nombreIterator.hasNext()){
			Suscripcion suscripcion = nombreIterator.next();
			listaProductos.add(suscripcion.getProducto());
		}
		
		return listaProductos;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
