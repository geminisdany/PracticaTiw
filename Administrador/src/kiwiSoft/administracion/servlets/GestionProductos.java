package kiwiSoft.administracion.servlets;

import java.io.IOException;
import java.util.Collection;

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

import kiwisoft.daos.ProductoDAO;
import kiwisoft.dominios.Producto;

/**
 * Servlet implementation class gestionProductos
 */
@WebServlet("/gestionProductos")
public class GestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource()
	private UserTransaction ut;
	
	private ProductoDAO proDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionProductos() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.proDao= new ProductoDAO(em, ut);
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	this.proDao=null;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String accion = request.getParameter("action");
		if(accion!=null){
			if(accion.equals("borrar")){
				Long idP = Long.parseLong(request.getParameter("idp"));
				Producto producto= proDao.buscarProducto(idP);
				try {
					proDao.borrarProducto(producto);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			if(accion.equals("oferta")){
				Long idP_oferta = Long.parseLong(request.getParameter("idp"));
				Producto producto= proDao.buscarProducto(idP_oferta);
				try {
					producto.setOferta(true);
					producto.setPrecio(producto.getPre_min());
					proDao.actualizarProducto(producto);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		request.setAttribute("listaProductos", listaProductos());
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
				
				
				HttpSession sesionAdmin = request.getSession();
				String validado = (String) sesionAdmin.getAttribute("adminValidado");
				if(validado!=null){
					System.out.println("esta validado, se puede editar el Prodcuto******"); ////DEBUG
					Long idp = Long.parseLong(request.getParameter("idp"));
					
					String descripcion = request.getParameter("descripcion");
					String nombre = request.getParameter("nombre");
					String oferta = request.getParameter("oferta");
					
					double pre_act = Double.parseDouble(request.getParameter("pre_act"));
					double pre_min = Double.parseDouble(request.getParameter("pre_min"));
					double pre_max = Double.parseDouble(request.getParameter("pre_max"));
					int stock = Integer.parseInt(request.getParameter("stock"));
					String tipo = request.getParameter("tipo");
					String urlImagen = request.getParameter("urlImagen");
					boolean b_oferta=false;
					
					if(oferta.equalsIgnoreCase("Si")){
						b_oferta= true;
					}
					try {
						Producto producto= proDao.buscarProducto(idp);
						producto.setNombre(nombre);
						producto.setDescripcion(descripcion);
						producto.setOferta(b_oferta);
						producto.setPre_max(pre_max);
						producto.setPre_min(pre_min);
						producto.setPrecio(pre_act);
						producto.setStock(stock);
						producto.setTipo(tipo);
						producto.setUrlImagen(urlImagen);
						
						proDao.actualizarProducto(producto);
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error al editar el Producto"+idp);
					}
				}
				
				request.setAttribute("listaProductos", listaProductos());
				request.setAttribute("panelProducto", true);
				System.out.println("envio lista de productos");///DEBUG
				
				response.setContentType("text/html");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	
	
	
	private Collection<Producto> listaProductos() {
		// TODO Auto-generated method stub
		Collection<Producto> listaProveedores=null;
		try {
			listaProveedores = proDao.findAll();
			System.out.println("+++++Listar Clientes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*******Listar CLientes, error al listar los clientes");
			e.printStackTrace();
		}
		return listaProveedores;
	}

}
