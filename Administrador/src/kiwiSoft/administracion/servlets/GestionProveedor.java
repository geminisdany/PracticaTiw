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

import kiwisoft.daos.ProveedorDAO;
import kiwisoft.dominios.Proveedor;

/**
 * Servlet implementation class gestionProveedor
 */
@WebServlet("/gestionProveedores")
public class GestionProveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource()
	private UserTransaction ut;
	
	private ProveedorDAO proveDao;
	
	//private SimulacionBD dbSimulacion;
    /**
     **@see HttpServlet#HttpServlet()
     */
    public GestionProveedor() {
        super();
        // TODO Auto-generated constructor stub
       // this.dbSimulacion = new SimulacionBD();
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.proveDao= new ProveedorDAO(em, ut);
    	
    }
    
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	super.destroy();
    	this.proveDao=null;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
				
		//		Collection<Proveedor> collection= dbSimulacion.dbProveedores;
				String accion = request.getParameter("action");
				if(accion!=null){
					if(accion.equals("borrar")){
						Long idP = Long.parseLong(request.getParameter("id"));
						Proveedor proveedor=null;
						try {
							proveedor = proveDao.buscarProveedor(idP);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if(proveedor!=null){
							try {
								proveDao.borrarProveedor(proveedor);
								System.out.println("++++Borrar Proveedor, se ha borrado con exito");
							} catch (Exception e) {
								// TODO Auto-generated catch block
								System.out.println("****Borrar Proveedor, Error al borrar Proveedor");
								e.printStackTrace();
							}
						}
					}
				}
				
				request.setAttribute("listaProveedor", listaProveedores());
				request.setAttribute("panelProveedor", true);
				System.out.println("envio lista de proveedores");///DEBUG
				
				response.setContentType("text/html");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	
	private Collection<Proveedor> listaProveedores() {
		// TODO Auto-generated method stub
		Collection<Proveedor> listaProveedores=null;
		try {
			listaProveedores = proveDao.findAll();
			System.out.println("+++++Listar Clientes");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("*******Listar CLientes, error al listar los clientes");
			e.printStackTrace();
		}
		return listaProveedores;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		/****/
		HttpSession sesionAdmin = request.getSession();
		String validado = (String)sesionAdmin.getAttribute("adminValidado");
		if(validado!=null){
			System.out.println("esta validado, se puede editar el Proveedor******"); ////DEBUG
			String cif = request.getParameter("cif");
			String nombre = request.getParameter("nombre");
			int telefono = Integer.parseInt(request.getParameter("tlf"));
			String email = request.getParameter("email");
			String password = request.getParameter("contras");
			String web = request.getParameter("web");
			String direccion = request.getParameter("direccion");
			String ciudad = request.getParameter("ciudad");
			String provincia = request.getParameter("provincia");
			String pais = request.getParameter("pais");
			int cp = Integer.parseInt(request.getParameter("cp"));
			
			Long idP = Long.parseLong(request.getParameter("id"));
			Proveedor proveedor=null;
			try {
				proveedor = proveDao.buscarProveedor(idP);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if (proveedor!=null) {
				proveedor.setCif(cif);
				proveedor.setNombre(nombre);
				proveedor.setEmail(email);
				proveedor.setPassword(password);
				proveedor.setTelefono(telefono);
				proveedor.setWeb(web);
				proveedor.getDireccion().setPais(pais);
				proveedor.getDireccion().setProvincia(provincia);
				proveedor.getDireccion().setCiudad(ciudad);
				proveedor.getDireccion().setDireccion(direccion);
				proveedor.getDireccion().setCp(cp);
				try {
					proveDao.modificarProveedor(proveedor);
					System.out.println("actualizado proveedor*****"); ///DEBUG
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error al editar el Proveedor"+":"+cif);
				}
			}else {
				System.out.println("ERROR, EL proveedor no existe");
			}
			
		}
		/****/
		
		request.setAttribute("listaProveedor", listaProveedores());
		request.setAttribute("panelProveedor", true);
		System.out.println("envio lista de proveedores");///DEBUG
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
