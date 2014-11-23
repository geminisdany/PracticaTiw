package kiwiSoft.administracion.servlets;

import java.io.IOException;

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
import javax.transaction.UserTransaction;

import kiwisoft.daos.ProductoDAO;
import kiwisoft.dominios.Producto;


/**
 * Servlet implementation class GestionFacturacion
 */
@WebServlet("/gestionFacturas")
public class GestionFacturas extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource()
	private UserTransaction ut;
	
	private ProductoDAO proDao;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionFacturas() {
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
		String action = request.getParameter("action");
		switch (action) {
		case "impuestos":
			request.setAttribute("panelImpuestos", true);	
			break;
		
		
		case "facturas":
			request.setAttribute("hayFacturas", true);
			request.setAttribute("panelFacturas", true);
			break;
		
		case "guardarImpuestosGenerales":
			double impuesto = Double.parseDouble(request.getParameter("precio"));
			
			Collection<Producto> listaProductos=null;
			try {
				listaProductos = proDao.findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Iterator<Producto> nombreIterator = listaProductos.iterator();
			while(nombreIterator.hasNext()){
				Producto productoActualizado = nombreIterator.next();
				productoActualizado.setImpuesto(impuesto);
				try {
					proDao.actualizarProducto(productoActualizado);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			break;
		
		case "guardarImpuestosProveedor":
			break;
		case "guardarImpuestosProduto":
			break;
		default:
			break;
		}
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
