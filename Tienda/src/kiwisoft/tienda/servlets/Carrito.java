package kiwisoft.tienda.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import kiwisoft.dominios.Pedido;
import kiwisoft.dominios.Producto;




/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/cart")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<Pedido> listaPedidos;
    
    @PersistenceContext(unitName="PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private ProductoDAO proDao;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		proDao = new ProductoDAO(em,ut);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		proDao=null;
	}
    public Carrito() {
        super();
        this.listaPedidos = new ArrayList<Pedido>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action==null){
			action="default";
		}
		
		switch (action) {
		case "agregar":///agrega un articulo al carrito, utilizando su id de producto.
			Long idp = Long.parseLong(request.getParameter("id"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			agregarPedido(idp,cantidad);		
			break;
		
		case "borrar":///borra un articulo del carrito
			Long idBorrar = Long.parseLong(request.getParameter("idp"));
			borrarPedido(idBorrar);
			mostrarCarrito(request, response);
			break;
			
		case "modificar"://modificar un articulo
			Long idpModificar = Long.parseLong(request.getParameter("id"));
			int cantidadModificar = Integer.parseInt(request.getParameter("cantidad"));
			modificarPedido(idpModificar, cantidadModificar);
			mostrarCarrito(request, response);
			
			break;
		
		case "vaciar"://elminar todos los articulos del carrito
			listaPedidos= new ArrayList<Pedido>();
			mostrarCarrito(request, response);
			break;
			
			
		case "mostrarLista"://mostrar todos los articulos del carrito
			mostrarCarrito(request, response);
			break;
		
		case "formPedido":
			request.setAttribute("action", "formPedido");
			break;
			
		case "facturar":
			break;
		default:
			break;
		}
		
		
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}
	
	
	private void mostrarCarrito(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		if(listaPedidos.size()>0){
			request.setAttribute("panelPedido", true);
			Collection<Pedido> lista = listaPedidos;
			request.setAttribute("listaPedido", lista);
		}
		request.setAttribute("action", "mostrarCarrito");
		double precioTotal=redondear(calcularTotal(),2);
		request.setAttribute("total", precioTotal);
	}
	
	private double redondear( double numero, int decimales ) {
	    return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
	  }
	
	
	
	
	/**
	 * 
	 */
	private double calcularTotal() {
		double total=0;
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			total+=pedido.getPrecio();
		}
		return total;
	}
	
	/**
	 * 
	 * @param idp
	 * @param cantidad
	 */
	private void agregarPedido(Long idp,int cantidad) {
		// TODO Auto-generated method stub
		//comprobamos si existe el pedido y lo sumamos
		Pedido pedido=sumarPedido(idp,cantidad);
		
		if(pedido==null){//si no existe el pedido,es un nuevo pedido
			try {
				Producto producto = proDao.buscarProducto(idp);
				Pedido pedidoAdd = new Pedido(producto, cantidad, cantidad*producto.getPrecio());
				listaPedidos.add(pedidoAdd);//se crea el pedido*/
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error en la consulta de agregar Pedido...Carrito");///DEBUG
			}
			
		}
		
	}
	
	/**
	 * 
	 * @param idBorrar
	 */
	private void borrarPedido(long idBorrar){
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getProducto().getId()==idBorrar){
				listaPedidos.remove(pedido);
				break;
			}
		}
	}
	
	
	/***
	 *Se modifica la cantidad y el precio  de un pedido
	 *si no existe se crea 
	 * @param idp
	 * @param cantidad
	 */
	private void modificarPedido(Long idp,int cantidad) {
		// TODO Auto-generated method stub
		boolean existePedido=false;
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getProducto().getId()==idp){
				listaPedidos.get(i).setCantidad(cantidad);
				double nuevoPrecio =cantidad*pedido.getProducto().getPrecio();
				listaPedidos.get(i).setPrecio(nuevoPrecio);
				existePedido=true;
				return;
			}
		}
		if(!existePedido){
			try {
				Producto producto = proDao.buscarProducto(idp);
				double precio = producto.getPrecio()*cantidad;
				
				Pedido pedidoAdd = new Pedido(producto, cantidad, precio);
				listaPedidos.add(pedidoAdd);//se crea el pedido*/
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error al consultar el producto, en agregar o modificar nuevo pedido....Carrito");
			}
			
		}
		
		
	}
	
	/**
	 * 
	 * @param idp
	 * @param cantidad
	 * @return
	 */
	private Pedido sumarPedido(Long idp,int cantidad) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getProducto().getId()==idp){
				listaPedidos.get(i).setCantidad(pedido.getCantidad()+cantidad);
				double nuevoPrecio = pedido.getCantidad()* proDao.buscarProducto(idp).getPrecio();
				listaPedidos.get(i).setPrecio(nuevoPrecio);
				return pedido;
			}
		}
		return null;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * Si se envian datos por metodo post significa que se va a registrar una factura
	 * se crea una nueva factura y se asocia al cliente
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		  
		//obtener datos
		//crear direccion
		//crear factura
		request.setAttribute("action", "datosFactura");
		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
}
