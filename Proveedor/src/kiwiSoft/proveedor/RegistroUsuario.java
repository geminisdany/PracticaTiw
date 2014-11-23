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

import kiwisoft.daos.ProveedorDAO;
import kiwisoft.dominios.Direccion;
import kiwisoft.dominios.Proveedor;
import kiwisoft.validacion.Validacion;


/**
 * Servlet implementation class RegistroUsuario
 */
@WebServlet("/RegistroUsuario")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
     	
	@PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	
	private ProveedorDAO proveedorDao;
	HttpSession sesionProv;
	private Validacion valid;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		proveedorDao = new ProveedorDAO(em,ut);
		valid = new Validacion();
	}
	
	@Override
	public void destroy() {
		proveedorDao = null;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		sesionProv  = request.getSession();
		if ((Boolean) sesionProv.getAttribute("adminValidado")){
			request.setAttribute("evento", "todos");
			this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
		} else{
			this.getServletContext().getRequestDispatcher("/proveedor-login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		sesionProv  = request.getSession();
		Proveedor provRegistrado  = null;
		String formProv = (String) sesionProv.getAttribute("formProveedor");
		String cif = null;
		String nombre = null;
		int telefono = 0;
		String email= null;
		String password = null;
		String pwd2P = null;
		String web = null;
		String direccion = null;
		String ciudad = null;
		String provincia = null;
		String pais = null;
		int cp = 0;
		try{
			cif = request.getParameter("cif");
			boolean cifVal = valid.cif(cif);
			System.out.println("*************"+cif + cifVal);
			nombre = request.getParameter("nombre");
			boolean nomVal = valid.sinRestriccion(nombre);
			System.out.println("*************"+nombre+nomVal);
			telefono = Integer.parseInt(request.getParameter("tlf"));
			String telfStr = Integer.toString(telefono);
			int telfsize = telfStr.length();
			boolean telfVal = valid.soloNumero(telfStr, telfsize);
			System.out.println("*************"+telefono +telfVal);
			email = request.getParameter("email");
			boolean emailVal = valid.sinRestriccion(email);
			System.out.println("*************"+email+emailVal);
			password = request.getParameter("contras");
			boolean passVal = valid.sinRestriccion(password);
			System.out.println("*************"+password+passVal);
			pwd2P = request.getParameter("pwd2P");
			boolean passVal2 = valid.sinRestriccion(pwd2P);
			System.out.println("*************"+pwd2P+passVal2);
			boolean iguales = valid.stringIguales(password, pwd2P);
			web = request.getParameter("web");
			boolean webVal = valid.sinRestriccion(web);
			System.out.println("*************"+web+webVal);
			direccion = request.getParameter("direccion");
			boolean dirVal = valid.sinRestriccion(direccion); 
			System.out.println("*************"+direccion+dirVal);
			ciudad = request.getParameter("ciudad");
			boolean ciuVal = valid.sinNumero(ciudad);
			System.out.println("*************"+ciudad+ciuVal);
			provincia = request.getParameter("provincia");
			boolean proVal = valid.sinNumero(provincia);
			System.out.println("*************"+provincia+proVal);
			pais = request.getParameter("pais");
			boolean paisVal = valid.sinNumero(pais);
			System.out.println("*************"+pais+paisVal);
			cp = Integer.parseInt(request.getParameter("cp"));
			String cpStr = Integer.toString(cp);
			int cpsize = cpStr.length();
			boolean cpVal = valid.soloNumero(cpStr, cpsize);
			System.out.println("*************"+cp+cpVal);
			if(!cifVal || !nomVal || !telfVal || !emailVal || !passVal || !iguales || !passVal2 ||!webVal || !dirVal || !ciuVal || !proVal || !paisVal || !cpVal){
				if(formProv.equals("registro")){
					sesionProv.setAttribute("adminValidado",false);
		    		sesionProv.setAttribute("formProveedor", "registro");
		    		this.getServletContext().getRequestDispatcher("/proveedor-registroUsuario.jsp").forward(request, response);
				} else{
					Proveedor provLogeado = (Proveedor) sesionProv.getAttribute("proveedorLogeado");
					sesionProv.setAttribute("formProveedor", "cuenta");
					request.setAttribute("cuentaProveedores", provLogeado);
					Direccion direccionLogeado = provLogeado.getDireccion();
					request.setAttribute("cuentaProvDireccion", direccionLogeado);
					this.getServletContext().getRequestDispatcher("/proveedor-ediciondatos.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			System.out.println("Error en el Proveedor");
		}
		try {
			if(formProv.equals("registro")){
				Direccion dir = new Direccion (direccion, ciudad, provincia, pais, cp);
				provRegistrado = new Proveedor (cif, nombre, telefono, web, email, password, dir);
				try {
					proveedorDao.guardarProveedor(provRegistrado);
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
					System.out.println("Error al registrar el Proveedor ");
				}
				sesionProv.setAttribute("adminValidado", true);
				sesionProv.setAttribute("proveedorLogeado", provRegistrado);
				request.setAttribute("evento", "todos");
				this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
			} else {
				Direccion dir = new Direccion (direccion, ciudad, provincia, pais, cp);
				Long idProv = Long.parseLong(request.getParameter("id"));
				provRegistrado = new Proveedor (cif, nombre, telefono, web, email, password, dir);
				provRegistrado.setId(idProv);
				try {
					proveedorDao.modificarProveedor(provRegistrado);
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
				System.out.println(provRegistrado.getNombre().toString());
				sesionProv.setAttribute("proveedorLogeado", provRegistrado);
				request.setAttribute("evento", "todos");
				this.getServletContext().getRequestDispatcher("/ProveedorCatalogo").forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al editar el Producto ");
		}

	}

}