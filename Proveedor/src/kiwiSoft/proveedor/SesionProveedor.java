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

import kiwisoft.daos.ClienteDAO;
import kiwisoft.daos.FacturaDAO;
import kiwisoft.daos.ProductoDAO;
import kiwisoft.daos.ProveedorDAO;
import kiwisoft.daos.SuscripcionDAO;
import kiwisoft.dominios.Cliente;
import kiwisoft.dominios.Direccion;
import kiwisoft.dominios.Factura;
import kiwisoft.dominios.Pedido;
import kiwisoft.dominios.Producto;
import kiwisoft.dominios.Proveedor;
import kiwisoft.dominios.Suscripcion;



/**
 * Servlet implementation class SesionProveedor
 */
@WebServlet("/SesionProveedor")
public class SesionProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	HttpSession sesionProv;
	
	private ProductoDAO productoDao;
	private ProveedorDAO proveedorDao;
	private SuscripcionDAO suscripcionDao;
	private ClienteDAO clienteDao;
	private FacturaDAO facturaDao;
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
    	proveedorDao = new ProveedorDAO(em,ut);	
    	productoDao = new ProductoDAO(em,ut);	
    	suscripcionDao = new SuscripcionDAO(em,ut);	
    	clienteDao = new ClienteDAO(em,ut);
    	facturaDao = new FacturaDAO(em,ut);
    	
    	try {
    		Producto producto = productoDao.buscarProductoNombreExacto("Fuente azul");
			if(producto!=null){
				System.out.println("******existen productos****");
			}
		} catch (Exception e) {
			// TODO: handle exception
			/**enviar notifiacion al usuario que no existe el email o contraseña*/
			System.out.println("No hay Productos, se crearan");
			iniciarDB();
		}
		
	}
	
	public SesionProveedor() {
        super();
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
    	productoDao = null;
    	proveedorDao = null;
    	suscripcionDao = null;
    	clienteDao = null;
    	facturaDao = null;
	}
	
    private void iniciarDB(){
    	//crear Cliente
		Direccion direcc =new Direccion("calle serrano 43", "madrid", "madrid", "espania", 28001);
		Cliente cliente1 = new Cliente("Raquel", "Garcia", 697893425, "raquel@raquel", "raquel", direcc);
		try {
			clienteDao.guardarCliente(cliente1);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Direccion dir =new Direccion("gran via 3", "oliva", "alicante", "espania", 57432);
		Cliente cliente2 = new Cliente("Elena", "Cerrato", 633452983, "elena@elena", "elena", dir);
		try {
			clienteDao.guardarCliente(cliente2);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
    	
    	
    	Direccion dir1 = new Direccion("C/Agua 9", "Malaga", "Malaga", "Espana", 29012);
		 Proveedor prov1 = new Proveedor("A0001N", "Empresa de Vasijas", 66546546 ,"http://www.vasijas.com", "vasijas@vasijas", "vasijas", dir1);
		 try {
			prov1=proveedorDao.guardarProveedor(prov1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 Producto produ1 = new Producto("Fuente azul", 25, 31, 25, "fuente", "Fuente azul perfecta para diferentes snacks.", 55, 11, true, "http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg", null, prov1);
		 Producto produ2 = new Producto("Vasija china", 37.5, 44.99, 8.2, 53.19, "vasija", "Vasija de estÃ©tica china, perfecta para decorar.", 10, 2, false, "http://www.museodevigo.org/img/coleccion/china.jpg", null, prov1);
		 Producto produ3 = new Producto("Taza de escamas", 9.5, 12.3, 12.3, "copa", "Taza aguamarina con bonito detalle de escamas.", 47, 9, false, "http://media-cache-ec0.pinimg.com/736x/d7/a6/ab/d7a6ab9e53e8ea1e3d3dc47ea265f44c.jpg", null, prov1);
		 Producto produ4 = new Producto("Botijo clasico", 14, 18.5, 18.5, "botijo", "Â¿Eres un amante de lo rÃºstico? El mejor botijo para decorar tu casa y mantener el agua fresca.", 200, 40, false, "http://www.ceramicasavante.com/104-194-thickbox/botijo-de-nevera-botijo-artesano-de-ceramica-tradiconal-hecho-a-mano-botijo-de-barro-para-poner-en-la-nevera.jpg", null, prov1);
		 Producto produ5 = new Producto("Fuente mexicana", 20, 28, 28, "fuente", "Colorida fuente de inspiraciÃ³n mexicana.", 64, 12, false, "http://media-cache-ec0.pinimg.com/736x/9f/b3/57/9fb357fccefa80f345f65f10c92f0214.jpg", null, prov1);		
		 Producto produ6 = new Producto("Vasija peruana", 32, 40.8, 5.75, 37.75, "vasija", "Vasija mediana con motivos peruanos.", 7, 7, true, " http://www.mecd.gob.es/dms/museos/museodeamerica/coleccion/seleccion-de-piezas/png-etnologia/MAMF1984_09_292-shipibo/MAMF1984_09_292-shipibo.png", null, prov1);
		 Producto produ7 = new Producto("Maceta de Buho", 16, 20.75, 20.75, "maceta", "Maceta con forma de bÃºho ideal para pequeÃ±as plantas.", 83, 16, false, "https://img1.etsystatic.com/045/0/9814905/il_570xN.668584145_flxx.jpg", null, prov1);
		 Producto produ8 = new Producto("Botijo Barroco", 18.75, 22.5, 22.5, "botijo", "Botijo exquisitamente decorado que aÃ±adirÃ¡ un toque de elegancia a su hogar.", 38, 7, false, " http://media-cache-cd0.pinimg.com/736x/b6/6f/cd/b66fcdce67919078a447f8a34f015a74.jpg", null, prov1);
		 Producto produ9 = new Producto("Tinaja clasica", 28, 35.5, 28, "tinaja", "Herederas de las tinajas romanas, ahora puedes tener una en tu casa.", 25, 30, true, " http://www.ranchogordo.com/assets/images/cook_claypots/clay_pots_-035.jpg", null, prov1);
		 Producto produ10 = new Producto("Fuentes paisleys", 15, 25, 25, "fuente", "AÃ±adirÃ¡ un toque exÃ³tico a tu salÃ³n, disponible en varios colores.", 97, 19, false, "http://media-cache-ec0.pinimg.com/736x/cc/f4/0b/ccf40b411787c952ff7d9b1b0dee6f9b.jpg", null, prov1);
			
		 			 
		 prov1.agregarProducto(produ1);
		 prov1.agregarProducto(produ2);
		 prov1.agregarProducto(produ3);
		 prov1.agregarProducto(produ4);
		 prov1.agregarProducto(produ5);
		 prov1.agregarProducto(produ6);	
		 prov1.agregarProducto(produ7);
		 prov1.agregarProducto(produ8);	
		 prov1.agregarProducto(produ9);
		 prov1.agregarProducto(produ10);
		 try {
			proveedorDao.modificarProveedor(prov1);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }	 
		 
		Direccion dir2 = new Direccion("C/Perla 3 ", "Murcia", "Murcia","Espana", 30060);
		Proveedor prov2 = new Proveedor("B0002H", "Ceramica Murcia", 65465465, "ceramurcia@ceramurcia", "http://www.ceramurcia.com", "ceramica", dir2);
		try {
			prov2 = proveedorDao.guardarProveedor(prov2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Producto produ11 = new Producto("Taza Monstruo de las Galletas",8,10, 1.1,11.1,"copa","Traido directamente desde Barrio SÃ©samo, la taza que se come tus galletas.",100, 20, false," https://img1.etsystatic.com/009/0/5783565/il_570xN.418527041_cnwj.jpg",null, prov2);
		prov2.agregarProducto(produ11);
		try {
			proveedorDao.modificarProveedor(prov2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Factura nuevaFactura = new Factura(cliente1, "tarjeta", 12,
					new Direccion("casa", "madrid", "madrid", "spain", 28400));// Factura de prueba sin pedidos
		 try {
			facturaDao.guardarFactura(nuevaFactura);
			cliente1.agregarFactura(nuevaFactura);
			clienteDao.modificarCliente(cliente1);
			System.out.println("+++Guardar Factura, Se guarda la factura en la BD");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Factura, Error al guardar la factura");//DEBUG
		 }	
		 
		Pedido ped1 = new Pedido(produ2,2,53.19,nuevaFactura);
		Pedido ped2 = new Pedido(produ6,1,37.75,nuevaFactura);
		Pedido ped3 = new Pedido(produ11,1,11.1,nuevaFactura);
			
		nuevaFactura.agregarPedido(ped1);
		nuevaFactura.agregarPedido(ped2);
		nuevaFactura.agregarPedido(ped3);
		
		try {
			facturaDao.modificarFactura(nuevaFactura);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }		
				
		Suscripcion susc1 = new Suscripcion(produ7, cliente1);
		 try {
			suscripcionDao.guardarSuscripcion(susc1);
			System.out.println("+++Guardar Suscripcion, Se guarda la suscripcion en la BD");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al guardar la suscripcion");//DEBUG
		 }
		 cliente1.agregarSuscripcion(susc1);
		 try {
			clienteDao.modificarCliente(cliente1);
			System.out.println("+++++Guardar Suscripcion, Se actualiza el cliente");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al actualizar el cliente");///DEBUG
		 }
		 
		 Suscripcion susc2 = new Suscripcion(produ10, cliente1);
		 try {
			suscripcionDao.guardarSuscripcion(susc2);
			System.out.println("+++Guardar Suscripcion, Se guarda la suscripcion en la BD");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al guardar la suscripcion");//DEBUG
		 }
		 cliente1.agregarSuscripcion(susc2);
		 try {
			clienteDao.modificarCliente(cliente1);
			System.out.println("+++++Guardar Suscripcion, Se actualiza el cliente");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al actualizar el cliente");///DEBUG
		 }
		 
		 Suscripcion susc3 = new Suscripcion(produ1, cliente2);
		 try {
			suscripcionDao.guardarSuscripcion(susc3);
			System.out.println("+++Guardar Suscripcion, Se guarda la suscripcion en la BD");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al guardar la suscripcion");//DEBUG
		 }
		 cliente2.agregarSuscripcion(susc3);
		 try {
			clienteDao.modificarCliente(cliente2);
			System.out.println("+++++Guardar Suscripcion, Se actualiza el cliente");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al actualizar el cliente");///DEBUG
		 }
		 
		 Suscripcion susc4 = new Suscripcion(produ10, cliente2);
		 try {
			suscripcionDao.guardarSuscripcion(susc4);
			System.out.println("+++Guardar Suscripcion, Se guarda la suscripcion en la BD");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al guardar la suscripcion");//DEBUG
		 }
		 cliente2.agregarSuscripcion(susc4);
		 try {
			clienteDao.modificarCliente(cliente2);
			System.out.println("+++++Guardar Suscripcion, Se actualiza el cliente");///DEBUG
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*****Guardar Suscripcion, Error al actualizar el cliente");///DEBUG
		 }
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	if (request.getParameter("evento") != null){
    		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    	} else{
    		sesionProv = request.getSession();
    		sesionProv.setAttribute("adminValidado",false);
    		sesionProv.setAttribute("formProveedor", "registro");
    		this.getServletContext().getRequestDispatcher("/proveedor-registroUsuario.jsp").forward(request, response);
    	}
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
			try {
				Proveedor proveedor = proveedorDao.buscarPorEmailYpassword(admin, pass);
				if(proveedor!=null){
					sesionProv.setAttribute("adminValidado", true);
					sesionProv.setAttribute("proveedorLogeado", proveedor);
					request.setAttribute("evento", "todos");
					this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				/**enviar notifiacion al usuario que no existe el email o contraseña*/
				System.out.println("Error al buscar al usuario");
			}
		}
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
