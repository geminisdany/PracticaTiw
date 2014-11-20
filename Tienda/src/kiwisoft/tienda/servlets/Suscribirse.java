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
		Long idCliente = (Long) sesionSuscripcion.getAttribute("idCliente");
		String action= request.getParameter("action");
		if (action!=null) {
			switch (action) {
			case "guardar":
				Long idp = Long.parseLong(request.getParameter("id"));
				
				//se comprueba que el usuario esta en sesion, de lo contrario
				//se retorna al catalogo en producto donde encontraba
				if(idCliente==null){
					System.out.println("****Guardar suscripcion, Error usuario no registrado");
					request.setAttribute("mensajeValidarse", "true");
					response.setContentType("text/html");
					this.getServletContext().getRequestDispatcher("/catalogo?action=mostrarProducto&id="+idp).forward(request, response);
					return;
				}
				
				//se captura el producto de la BD
				try {			
					producto = proDao.buscarProducto(idp);
					System.out.println("+++Guardar Suscripcion, Se obtiene el objeto Producto de la BD");///DEBUG
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*****Guardar Suscripcion, Error al buscar el producto en la BD");///DEBUG
				}
				
				//se captura el cliente de BD
				try {			
					cliente = cliDao.buscarClienteID(idCliente);
					System.out.println("+++Guardar Suscripcion, Se obtiene el objeto Cliente de la BD");///DEBUG
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*****Guardar Suscripcion, Error al buscar el cliente en la BD");///DEBUG
				}
				//se crea la suscripcion del producto y cliente y se guarda en la BD
				suscripcion= new Suscripcion(producto, cliente);
				try {
					suscripcion=susDao.guardarSuscripcion(suscripcion);
					System.out.println("+++Guardar Suscripcion, Se guarda la suscripcion en la BD");///DEBUG
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("*****Guardar Suscripcion, Error al guardar la suscripcion");//DEBUG
				}
				cliente.getSuscripciones().add(suscripcion);
				try {
					cliDao.actualizarCliente(cliente);
					System.out.println("+++++Guardar Suscripcion, Se actualiza el cliente");///DEBUG
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("*****Guardar Suscripcion, Error al actualizar el cliente");///DEBUG
				}
				break;	
			
			case "borrar":
				Long idpBorrar = Long.parseLong(request.getParameter("id"));
				//se comprueba que el usuario esta en sesion, de lo contrario
				//se retorna al catalogo en producto donde encontraba
				//(no deberia de entrar nunca ya que el jsp no da la opcion de aular suscripcion si no esta resgistrado)
				if(idCliente==null){
					System.out.println("****Guardar suscripcion, Error usuario no registrado");
					request.setAttribute("mensajeValidarse", "true");
					response.setContentType("text/html");
					this.getServletContext().getRequestDispatcher("/catalogo?action=mostrarProducto&id="+idpBorrar+".jsp").forward(request, response);
					return;
				}
				
				
				
				
				//se busca la suscripcion en la BD que se desea borrar y se captura el objeto
				try {
					  suscripcion=susDao.buscarSuscripcionClienteProducto(idCliente, idpBorrar);
					  System.out.println("+++Borrar Suscripccion, Se ha obtenido de la busqueda el objeto Suscripcion");///DEBUG
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("*******Borrar Suscripccion, Error al buscar la Suscripcion en la BD");///DEBUG
				}
				  
				// se borra la suscripcion de la BD  
				try {
					susDao.borrarSuscripcion(suscripcion);
					System.out.println("+++Borrar Suscripccion, Se ha borrado la suscripcion de BD"); ///DEBUG
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("*****Suscripcion*Error al Borrar Suscripcion de la BD");///DEBUG
				}
				
				//se captura el cliente
				try {
					cliente = cliDao.buscarClienteID(idCliente);
					System.out.println("+++Borrar Suscripccion, Se ha obtenido el objeto cliente");///DEBUG
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*******Borrar Suscripccion, Error al ontener el objeto cliente");///DEBUG
				}
				
				//actualizar el cliente
				cliente.borrarSuscripcion(idpBorrar);
				try {
					cliDao.actualizarCliente(cliente);
					System.out.println("+++Borrar Suscripccion, Se ha actualizado el cliente");///DEBUG
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("*****Suscripcion*Error al actualizar el cliente");///DEBUG
				}
				
				
				break;
				
			case "mostrarSuscripciones": ///muestra los productos a los que esta suscrito
				
				//se comprueba que el usuario esta en sesion
				try {
					cliente = cliDao.buscarClienteID(idCliente);
					System.out.println("+++Mostrar Suscripcion, Se ha capturado el cliente");///DEBUG
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("*****Mostrar Suscripcion, Error al capturar el cliente");///DEBUG
				}
				Collection<Producto> listaProductos=null;
				if(cliente!=null){
					Collection<Suscripcion> listaSuscripciones =cliente.getSuscripciones();
					listaProductos = obtenerProductos(listaSuscripciones);
					System.out.println("Hay: "+listaSuscripciones.size() + " productos suscritos");///DEBUG
					
					if(listaSuscripciones.size()>0){
						request.setAttribute("listaProducto",listaProductos);			
						request.setAttribute("haySuscripciones",true);
					}
				}
				
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
