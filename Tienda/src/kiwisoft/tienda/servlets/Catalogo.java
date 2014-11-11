package kiwisoft.tienda.servlets;

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
import javax.transaction.UserTransaction;

import kiwisoft.daos.ProductoDAO;
import kiwisoft.dominios.Producto;



/**
 * Servlet implementation class Catalogo
 */
@WebServlet("/catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L; 
   

	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private ProductoDAO proDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		proDao = new ProductoDAO(em,ut);
		try {
			Producto productos = proDao.buscarProductoNombre("Fuente azul");
			if(productos!=null){
				System.out.println("******existen productos****");
			}
		} catch (Exception e) {
			// TODO: handle exception
			/**enviar notifiacion al usuario que no existe el email o contraseña*/
			System.out.println("No hay Productos, se crearan");
			iniciarDB();
			
		}
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		proDao=null;
	}
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public Catalogo() {
        super();
    }
    
   
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
				String action = request.getParameter("action");
				if(action==null)
					action="default";
					
				switch (action) {
				case "buscar":
							String opcion= request.getParameter("opcion");
							String palabraClave = request.getParameter("palabraClave");
							switch (opcion) {
							case "producto":
								try {
									Producto producto= proDao.buscarProductoNombre(palabraClave);
									request.setAttribute("producto",producto);///para  producto.jsp		
									request.setAttribute("action","mostrarProducto");///para el indice.jsp
									System.out.println("muestro un producto");/////DEBUG*/
								} catch (Exception e) {
									// TODO: handle exception
									System.out.println("BUSCAR*******no existe el producto");
								}
								break;
								}
		
				break;
					
				case "mostrarProducto":
					/**mostrar una categoria**/
					Long idp = Long.parseLong(request.getParameter("id"));
					try {
						Producto producto = proDao.buscarProducto(idp);
						
						request.setAttribute("producto",producto);///para  producto.jsp		
						request.setAttribute("action","mostrarProducto");///para el indice.jsp
						System.out.println("muestro un producto");/////DEBUG*/
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Error en la consulta de mostrar Producto...Catalogo");///DEBUG
					}
					
					
					break;
					
				case "categoria":
					/**mostrar una categoria**/
					String tipoCatalogo= request.getParameter("tipoCatalogo");	
					if(tipoCatalogo!=null){			
						System.out.println("busco el tipo:" + tipoCatalogo);
						try {
							Collection<Producto> collection= proDao.buscarProductoTipo(tipoCatalogo);
							System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
							request.setAttribute("tipoCatalogo",tipoCatalogo);
							request.setAttribute("listaProducto", collection);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println("Error en la consulta de tipo");
						}
						
					}else{
						/**si no hay parametro de tipo de catalogo, por defecto se retorna la lista con ofertas**/
						System.out.println("busco el tipo: ofertas");
						try {
							Collection<Producto> collection=proDao.buscarProductoOferta();
							System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
							request.setAttribute("tipoCatalogo","oferta");
							request.setAttribute("listaProducto", collection);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					request.setAttribute("action","catalogo");///para el indice.jsp
					System.out.println("muestro catalogo");/////DEBUG
					
					break;
					
				default:
					/**si no hay parametro, Se realiza la busqueda anterior**/
					
					break;
				}
				
				response.setContentType("text/html");		
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
	
	
	/********Carga de catalogo*********/
	 private void iniciarDB(){
	    String[] nombres={"Fuente azul","Vasija china"};
	    String[] descripcion={"Fuente azul perfecta para diferentes snacks.","Vasija de estética china, perfecta para decorar."};
	    String[] urlImagen={"http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg","http://www.museodevigo.org/img/coleccion/china.jpg"};
	    double [] pre_min={25,37.5};
	    double [] pre_max={31,44.99};
	    double [] precio={31,44.99};
	    int [] stock={55,10};
	    String [] tipo={"fuente","vasija"};
	    boolean [] oferta ={true,true};
	    
	    for (int i = 0; i < nombres.length; i++) {
			Producto nuevoProducto=new Producto(nombres[i], pre_min[i], pre_max[i], precio[i], tipo[i], descripcion[i], stock[i], oferta[i], urlImagen[i], null);	
			System.out.println("cargando datos");///DEBUG
			try {
				proDao.guardarProducto(nuevoProducto);
				System.out.println("****************se ha guardado un nuevo producto******************"+i);///DEBUG
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	    }
			
		}
		 
	/**Fin de Carga de Catalogo**/
	

}
