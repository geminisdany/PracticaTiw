package kiwiSoft.proveedor;

import java.io.IOException;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import kiwisoft.daos.ProductoDAO;
import kiwisoft.daos.ProveedorDAO;
import kiwisoft.dominios.Producto;
import kiwisoft.dominios.Proveedor;
import kiwisoft.validacion.Validacion;

/**
 * Servlet implementation class GestionarProducto
 */
@WebServlet("/GestionarProducto")
public class GestionarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private ProductoDAO productoDao;
	private ProveedorDAO proveedorDao;
	HttpSession sesionProv;
	private Proveedor provLogeado;
	private Validacion valid;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GestionarProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		productoDao = new ProductoDAO(em,ut);
		proveedorDao = new ProveedorDAO(em,ut);
		valid = new Validacion();
	}
	
	@Override
	public void destroy() {
		productoDao = null;
		proveedorDao = null;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		if ((Boolean) sesionProv.getAttribute("adminValidado")){
			request.setAttribute("evento", "todos");
			this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
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
		provLogeado = (Proveedor) sesionProv.getAttribute("proveedorLogeado");
		String cifP = provLogeado.getCif();
		Boolean validado = (Boolean) sesionProv.getAttribute("adminValidado");
		String formProd = (String) sesionProv.getAttribute("formularioProducto");
		if(validado && cifP != null && formProd != null){
			Producto producto  = null;
			String descripcion = null;
			String nombre = null;
			double pre_min = 0;
			double pre_max = 0;
			int stock = 0;
			int umbralStock = 0;
			String tipo = null;
			String urlImagen = null;
			try{
				descripcion = request.getParameter("descripcion");
				boolean descVal = valid.sinRestriccion(descripcion);
				System.out.println("*******************DESCRIPCION" + descripcion +descVal);
				nombre = request.getParameter("nombre");
				boolean nomVal = valid.sinRestriccion(nombre);
				System.out.println("*******************NOMBRE" + nombre + nomVal);
				pre_min = Double.parseDouble(request.getParameter("pre_min"));
				String preminStr = Double.toString(pre_min);
				boolean pminVal = valid.precio(preminStr);
				System.out.println("*******************PREMIN" + pre_min + pminVal);
				pre_max = Double.parseDouble(request.getParameter("pre_max"));
				String pmaxStr = Double.toString(pre_max);
				boolean pmaxVal = valid.precio(pmaxStr);
				System.out.println("*******************PREMAX" + pre_max + pmaxVal);
				boolean precios = valid.menoroIgual(pre_min, pre_max);
				System.out.println("*******************PRECIOS" + precios);
				stock = Integer.parseInt(request.getParameter("stock"));
				String stockStr = Integer.toString(stock);
				int stocksize = stockStr.length();
				boolean stockVal = valid.soloNumero(stockStr, stocksize);
				System.out.println("*******************STOCK" + stock + stockVal);
				umbralStock = Integer.parseInt(request.getParameter("umbralStock"));
				String umbStr = Integer.toString(umbralStock);
				int umbsize = umbStr.length();
				boolean umbVal = valid.soloNumero(umbStr, umbsize);
				System.out.println("*******************UMBRAL" + umbralStock+ umbVal);
				boolean cantidades = valid.mayor(stock, umbralStock);
				System.out.println("*******************CANTIDADES" + cantidades);
				tipo = request.getParameter("tipo");
				System.out.println("*******************TIPO" + tipo);
				urlImagen = request.getParameter("urlImagen");
				boolean urlVal = valid.sinRestriccion(urlImagen);
				System.out.println("*******************URL" + urlImagen);
				if (descVal && nomVal && pminVal && pmaxVal && precios && stockVal && umbVal && cantidades && urlVal) {
					producto = new Producto (nombre, pre_min, pre_max, pre_max, tipo, descripcion, stock, umbralStock, false, urlImagen, provLogeado);
				} else {
					//Si no se validan correctamente, se redirige al usuario a su catalogo de productos
					System.out.println("#### Los campos introducidos no son correctos ####");
					if(formProd.equals("aniadir")){
						sesionProv.setAttribute("formularioProducto", "aniadir");
						this.getServletContext().getRequestDispatcher("/proveedor-altaproducto.jsp").forward(request, response);
					} else{
						sesionProv.setAttribute("formularioProducto", "modificar");
						Long idProd = Long.parseLong(request.getParameter("idProd"));
						Producto prodSeleccionado = productoDao.buscarProducto(idProd);
						request.setAttribute("productoID", prodSeleccionado);
						this.getServletContext().getRequestDispatcher("/proveedor-modifproducto.jsp").forward(request, response);
					}
				}
				
			} catch (Exception e) {
				System.out.println("Error al editar el Producto");
			} 
			try {
				if(formProd.equals("aniadir")){
					provLogeado.agregarProducto(producto);
					proveedorDao.modificarProveedor(provLogeado);
					request.setAttribute("evento", "todos");
					this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
				} else {
					Long id = Long.parseLong(request.getParameter("idProd"));
					producto.setId(id);
					productoDao.modificarProducto(producto);
					request.setAttribute("evento", "todos");
					this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
				}
				
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al editar el Producto ");
			}
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}

	}
}