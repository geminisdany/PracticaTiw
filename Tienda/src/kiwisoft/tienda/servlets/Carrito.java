package kiwisoft.tienda.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiwisoft.dominios.Pedido;




/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/cart")
public class Carrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<Pedido> listaPedidos;

	
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
			int idp = Integer.parseInt(request.getParameter("id"));
			int cantidad = Integer.parseInt(request.getParameter("cantidad"));
			agregarPedido(idp,cantidad);		
			break;
		
		case "borrar":///borra un articulo del carrito
			int idBorrar = Integer.parseInt(request.getParameter("idp"));
			borrarPedido(idBorrar);
			mostrarCarrito(request, response);
			break;
			
		case "modificar"://modificar un articulo
			int idpModificar = Integer.parseInt(request.getParameter("id"));
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
	private void agregarPedido(int idp,int cantidad) {
		// TODO Auto-generated method stub
		//comprobamos si existe el pedido y lo sumamos
		Pedido pedido=sumarPedido(idp,cantidad);
		
		if(pedido==null){//si no existe el pedido,es un nuevo pedido
			/*String nombre =dbSimulacion.obtenerProducto(idp).getNombre();
			double precio = dbSimulacion.obtenerProducto(idp).getPre_max();
			Pedido pedidoAdd = new Pedido(idp, nombre, cantidad, precio);
			listaPedidos.add(pedidoAdd);//se crea el pedido*/
		}
		
	}
	
	/**
	 * 
	 * @param idBorrar
	 */
	private void borrarPedido(int idBorrar){
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getId()==idBorrar){
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
	private void modificarPedido(int idp,int cantidad) {
		// TODO Auto-generated method stub
		boolean existePedido=false;
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getId()==idp){
				listaPedidos.get(i).setCantidad(cantidad);
				/*double nuevoPrecio =cantidad*dbSimulacion.obtenerProducto(idp).getPre_max();
				listaPedidos.get(i).setPrecio(nuevoPrecio);*/
				existePedido=true;
				return;
			}
		}
		if(!existePedido){
			/*String nombre =dbSimulacion.obtenerProducto(idp).getNombre();
			double precio = dbSimulacion.obtenerProducto(idp).getPre_max();
			Pedido pedidoAdd = new Pedido(idp, nombre, cantidad, precio);
			listaPedidos.add(pedidoAdd);//se crea el pedido*/
		}
		
		
	}
	
	/**
	 * 
	 * @param idp
	 * @param cantidad
	 * @return
	 */
	private Pedido sumarPedido(int idp,int cantidad) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaPedidos.size(); i++) {
			Pedido pedido = listaPedidos.get(i);
			if(pedido.getId()==idp){
				listaPedidos.get(i).setCantidad(pedido.getCantidad()+cantidad);
			/*	double nuevoPrecio = pedido.getCantidad()*dbSimulacion.obtenerProducto(idp).getPre_max();
				listaPedidos.get(i).setPrecio(nuevoPrecio);*/
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
