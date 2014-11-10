package kiwisoft.tienda.servlets;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kiwisoft.dominios.Producto;



/**
 * Servlet implementation class Catalogo
 */
@WebServlet("/catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L; 
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
					
					break;
					
				case "mostrarProducto":
					/**mostrar una categoria**/
					int idp = Integer.parseInt(request.getParameter("id"));
					/*Producto producto = simulacionbd.obtenerProducto(idp);
					
					request.setAttribute("producto",producto);///para  producto.jsp		
					request.setAttribute("action","mostrarProducto");///para el indice.jsp
					System.out.println("muestro un producto");/////DEBUG*/
					
					break;
					
				case "categoria":
					/**mostrar una categoria**/
					String tipoCatalogo= request.getParameter("tipoCatalogo");	
					if(tipoCatalogo!=null){			
						System.out.println("busco el tipo:" + tipoCatalogo);
						/*Collection<Producto> collection=simulacionbd.obtenerCatalogo(tipoCatalogo);
						System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
						request.setAttribute("tipoCatalogo",tipoCatalogo);
						request.setAttribute("listaProducto", collection);*/
					}else{
						/**si no hay parametro de tipo de catalogo, por defecto se retorna la lista con ofertas**/
						/*System.out.println("busco el tipo: ofertas");
						Collection<Producto> collection=simulacionbd.ofertaCatalogo();
						System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
						request.setAttribute("tipoCatalogo","oferta");///para catalogo.jsp
						request.setAttribute("listaProducto", collection);*/
					}
					request.setAttribute("action","catalogo");///para el indice.jsp
					System.out.println("muestro catalogo");/////DEBUG
					
					break;
					
				default:
					/**si no hay parametro, por defecto se retorna la lista con ofertas**/
					System.out.println("busco el tipo: ofertas");
					/*Collection<Producto> collection=simulacionbd.ofertaCatalogo();
					System.out.println("tamaño de la lista de productos "+collection.size());///DEBUG
					request.setAttribute("tipoCatalogo","oferta");///para catalogo.jsp
					request.setAttribute("listaProducto", collection);
					request.setAttribute("action","catalogo");///para el indice.jsp
					System.out.println("muestro catalogo");/////DEBUG*/
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

}
