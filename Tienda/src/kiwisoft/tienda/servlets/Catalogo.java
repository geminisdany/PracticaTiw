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
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

import kiwisoft.daos.ClienteDAO;
import kiwisoft.daos.FacturaDAO;
import kiwisoft.daos.ProductoDAO;
import kiwisoft.daos.ProveedorDAO;
import kiwisoft.daos.SuscripcionDAO;
import kiwisoft.dominios.Direccion;
import kiwisoft.dominios.Factura;
import kiwisoft.dominios.Pedido;
import kiwisoft.dominios.Producto;
import kiwisoft.dominios.Proveedor;
import kiwisoft.dominios.Cliente;

/**
 * Servlet implementation class Catalogo
 * http://www.objectdb.com/java/jpa/query/jpql/select
 */
@WebServlet("/catalogo")
public class Catalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "PracticaTiw")
	private EntityManager em;
	@Resource
	private UserTransaction ut;
	private ProductoDAO proDao;
	private ProveedorDAO proveDao;
	private ClienteDAO cliDao;
	private SuscripcionDAO susDao;
	private FacturaDAO facDao;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		proDao = new ProductoDAO(em, ut);
		proveDao = new ProveedorDAO(em, ut);
		cliDao = new ClienteDAO(em, ut);
		susDao = new SuscripcionDAO(em, ut);
		facDao = new FacturaDAO(em, ut);
		try {
			Producto productos = proDao
					.buscarProductoNombreExacto("Fuente azul");
			if (productos != null) {
				System.out.println("******existen productos****");
			}
		} catch (Exception e) {
			// TODO: handle exception
			/**
			 * enviar notifiacion al usuario que no existe el email o contraseña
			 */
			System.out.println("No hay Productos, se crearan");
			iniciarDB();

		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		proDao = null;
		proveDao = null;
		cliDao = null;
		susDao = null;
		facDao = null;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Catalogo() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection<Producto> productos = null;

		String action = request.getParameter("action");
		if (action == null)
			action = "default";

		switch (action) {
		case "busquedaBasica":
			String opcion = request.getParameter("opcion");
			String palabraClave = request.getParameter("palabraClave");
			System.out.println("++++++++++++++++++++++++++Busqueda simple por "	+ opcion + ": " + palabraClave);// /DEBUG*/
			switch (opcion) {
			case "producto":
				String busquedaExacta = request.getParameter("busquedaExacta");
				if (busquedaExacta != null) {
					try {
						Producto producto = proDao.buscarProductoNombreExacto(palabraClave);
						request.setAttribute("producto", producto);
						request.setAttribute("action", "mostrarProducto");
						System.out.println("+++++Busqueda Simple por Nombre Exacto, Con Exito");// /DEBUG*/

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("Busqueda Basica por nombre Exacto*******No existe el producto");// /DEBUG*/
						request.setAttribute("action", "mensaje");
						request.setAttribute("titulo", "Resultados de Busqueda");
						request.setAttribute("descripcion",
								"Lo sentimos, no se ha encontrado ningun producto con el nombre: "
										+ palabraClave);
					}
				} else {
					try {
						productos = proDao.buscarProductoNombre(palabraClave);
						if (productos.size() > 0) {
							request.setAttribute("listaProducto", productos);
							request.setAttribute("tipoCatalogo", "oferta");
							request.setAttribute("action", "catalogo");
							request.setAttribute("tituloTipoCatalogo",
									"Busqueda de: " + palabraClave);
							System.out.println("+++++Busqueda Simple por Nombre, Con Exito");
						} else {
							System.out.println("+++++Busqueda Simple por Nombre, no hay productos con ese nombre");
							request.setAttribute("action", "mensaje");
							request.setAttribute("titulo","Resultados de Busqueda");
							request.setAttribute("descripcion","Lo sentimos, no se ha encontrado ningun producto con el nombre: "+ palabraClave);
						}

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("********Busqueda Simple por Nombre, ERROR en la busqueda");
						// e.printStackTrace();
					}
				}

				break;

			case "tipo":
				try {
					productos = proDao.buscarProductoTipo(palabraClave);
					if (productos.size() > 0) {
						request.setAttribute("listaProducto", productos);
						request.setAttribute("tipoCatalogo", "oferta");
						request.setAttribute("action", "catalogo");
						request.setAttribute("tituloTipoCatalogo","Busqueda de: " + palabraClave);
						System.out.println("+++++Busqueda Simple por Tipo, Con Exito");
					} else {
						System.out.println("+++++Busqueda Simple por Tipo, no hay ese tipo de productos");
						request.setAttribute("action", "mensaje");
						request.setAttribute("titulo", "Resultados de Busqueda");
						request.setAttribute("descripcion","Lo sentimos, no se ha encontrado ningun tipo con el nombre: "+ palabraClave);
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("********Busqueda Simple por Tipo, ERROR en la busqueda");
				}

				break;

			case "proveedor":
				String busquedaExacta2 = request.getParameter("busquedaExacta");
				if (busquedaExacta2 != null) {
					try {
						productos = proDao.buscarProductoProveedorExacto(palabraClave);
						if (productos.size() > 0) {
							request.setAttribute("listaProducto", productos);
							request.setAttribute("tipoCatalogo", "oferta");
							request.setAttribute("action", "catalogo");
							request.setAttribute("tituloTipoCatalogo","Busqueda de: " + palabraClave);
							System.out.println("+++++Busqueda Simple por Proveedor, Con Exito");
						} else {
							System.out.println("+++++Busqueda Simple por Tipo, no hay ese tipo de productos");
							request.setAttribute("action", "mensaje");
							request.setAttribute("titulo","Resultados de Busqueda");
							request.setAttribute("descripcion","Lo sentimos, no se ha encontrado ningun proveedor con el nombre: "+ palabraClave);
						}
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("********Busqueda Simple por Proveedor, ERROR en la busqueda");
					}
				} else {
					try {
						productos = proDao.buscarProductoProveedor(palabraClave);
						if (productos.size() > 0) {
							request.setAttribute("listaProducto", productos);
							request.setAttribute("tipoCatalogo", "oferta");
							request.setAttribute("action", "catalogo");
							request.setAttribute("tituloTipoCatalogo","Busqueda de: " + palabraClave);
							System.out.println("+++++Busqueda Simple por Nombre, Con Exito");
						} else {
							System.out.println("+++++Busqueda Simple por Nombre, no hay productos con ese nombre");
							request.setAttribute("action", "mensaje");
							request.setAttribute("titulo","Resultados de Busqueda");
							request.setAttribute("descripcion","Lo sentimos, no se ha encontrado ningun proveedor con el nombre: "+ palabraClave);
						}

					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("********Busqueda Simple por Proveedor, ERROR en la busqueda");
						// e.printStackTrace();
					}
				}
				break;

			case "precioMayor":
				double precioMayor = Double.parseDouble(palabraClave);
				try {
					productos = proDao.buscarProductoMayor(precioMayor);
					if (productos.size() > 0) {
						request.setAttribute("listaProducto", productos);
						request.setAttribute("tipoCatalogo", "oferta");
						request.setAttribute("action", "catalogo");
						request.setAttribute("tituloTipoCatalogo","Busqueda de por precio mayor a: "+ palabraClave);
						System.out.println("+++++Busqueda Simple por Precio Mayor, Con Exito");
					} else {
						System.out.println("+++++Busqueda Simple por Precio Mayor, no hay productos");
						request.setAttribute("action", "mensaje");
						request.setAttribute("titulo", "Resultados de Busqueda");
						request.setAttribute("descripcion","Lo sentimos, no se ha encontrado productos con el precio mayor a : "+ palabraClave);
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out
							.println("********Busqueda Simple por Producto Mayor, ERROR en la busqueda");
				}
				break;

			case "precioMenor":
				double precioMenor = Double.parseDouble(palabraClave);
				try {
					productos = proDao.buscarProductoMenor(precioMenor);
					if (productos.size() > 0) {
						request.setAttribute("listaProducto", productos);
						request.setAttribute("tipoCatalogo", "oferta");
						request.setAttribute("action", "catalogo");
						request.setAttribute("tituloTipoCatalogo","Busqueda de precio menor a: " + palabraClave);
						System.out.println("+++++Busqueda Simple por Precio Mayor, Con Exito");
					} else {
						System.out.println("+++++Busqueda Simple por Precio Mayor, no hay productos");
						request.setAttribute("action", "mensaje");
						request.setAttribute("titulo", "Resultados de Busqueda");
						request.setAttribute("descripcion","Lo sentimos, no se ha encontrado productos con el precio menor a : "+ palabraClave);
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("********Busqueda Simple por Producto Menor, ERROR en la busqueda");
				}
				break;

			case "precioIgual":
				double precioIgual = Double.parseDouble(palabraClave);
				try {
					productos = proDao.buscarProductoIgual(precioIgual);
					if (productos.size() > 0) {
						request.setAttribute("listaProducto", productos);
						request.setAttribute("tipoCatalogo", "oferta");
						request.setAttribute("action", "catalogo");
						request.setAttribute("tituloTipoCatalogo","Busqueda de precio igual a: " + palabraClave);
						System.out.println("+++++Busqueda Simple por Precio Igual, Con Exito");
					} else {
						System.out.println("+++++Busqueda Simple por Precio Mayor, no hay productos");
						request.setAttribute("action", "mensaje");
						request.setAttribute("titulo", "Resultados de Busqueda");
						request.setAttribute("descripcion","Lo sentimos, no se ha encontrado productos con el precio igual a : "+ palabraClave);
					}

				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("********Busqueda Simple por Producto Igual, ERROR en la busqueda");
					
				}
				break;

			}
			break;

			
			
			
		case "busquedaAvanzada":
			try {	
				 String campo1=request.getParameter("campo1"),
					    valor1=request.getParameter("valor1"),
					    operador=request.getParameter("operador"),
					    campo2=request.getParameter("campo2"),
					    valor2=request.getParameter("valor2");
				productos=proDao.buscarAvanzado(campo1, valor1, operador, campo2, valor2);
				if (productos.size() > 0) {
					request.setAttribute("listaProducto", productos);
					request.setAttribute("tipoCatalogo", "oferta");
					request.setAttribute("action", "catalogo");
					request.setAttribute("tituloTipoCatalogo","Busqueda Avanzada");
					System.out.println("+++++Busqueda Avanzada, Con Exito");
				} else {
					System.out.println("+++++Busqueda Avanzada, no hay productos");
					request.setAttribute("action", "mensaje");
					request.setAttribute("titulo", "Resultados de Busqueda");
					request.setAttribute("descripcion","Lo sentimos, no se han encontrado productos con: "+ valor1 +" y "+valor2);
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("********Busqueda AVANZADA, ERROR en la busqueda");
				e.printStackTrace();
			}
			break;

			
			
			
			
			
			
			
		case "mostrarProducto":
			/** mostrar una categoria **/
			Long idp = Long.parseLong(request.getParameter("id"));

			try {
				HttpSession sesionCatalogo = request.getSession();
				Long idClien = (Long) sesionCatalogo.getAttribute("idCliente");
				susDao.buscarSuscripcionClienteProducto(idClien, idp);
				request.setAttribute("productoSuscrito", true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out
						.println("***Mostrar Producto, el producto no se ecuentra en suscritos");
			}
			try {
				Producto producto = proDao.buscarProducto(idp);

				request.setAttribute("producto", producto);// /para producto.jsp
				request.setAttribute("action", "mostrarProducto");// /para el
																	// indice.jsp
				System.out.println("muestro un producto");// ///DEBUG*/

			} catch (Exception e) {
				// TODO: handle exception
				System.out
						.println("Error en la consulta de mostrar Producto...Catalogo");// /DEBUG
			}

			break;

		case "categoria":
			/** mostrar una categoria **/
			String tipoCatalogo = request.getParameter("tipoCatalogo");
			if (tipoCatalogo != null) {
				System.out.println("busco el tipo:" + tipoCatalogo);
				try {
					Collection<Producto> collection = proDao
							.buscarProductoTipo(tipoCatalogo);
					System.out.println("tamaño de la lista de productos "
							+ collection.size());// /DEBUG
					request.setAttribute("tipoCatalogo", tipoCatalogo);
					request.setAttribute("tituloTipoCatalogo", tipoCatalogo);
					request.setAttribute("listaProducto", collection);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en la consulta de tipo");
				}

			} else {
				/**
				 * si no hay parametro de tipo de catalogo, por defecto se
				 * retorna la lista con ofertas
				 **/
				System.out.println("busco el tipo: ofertas");
				try {
					Collection<Producto> collection = proDao
							.buscarProductoOferta();
					System.out.println("tamaño de la lista de productos "
							+ collection.size());// /DEBUG
					request.setAttribute("tipoCatalogo", "oferta");
					request.setAttribute("tituloTipoCatalogo", "Ofertas");
					request.setAttribute("listaProducto", collection);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			request.setAttribute("action", "catalogo");// /para el indice.jsp
			System.out.println("muestro catalogo");// ///DEBUG

			break;

		default:
			/** si no hay parametro, Se realiza la busqueda anterior **/

			break;
		}

		response.setContentType("text/html");
		this.getServletContext().getRequestDispatcher("/index.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/******** Carga de catalogo *********/
	private void iniciarDB() {
		try {
			// crer Cliente
			Direccion casa = new Direccion("pardo santallana", "villalba","madrid", "spain", 28400);
			Cliente yo = new Cliente("alex", "ruiz", 680606060, "alex@alex","alex", casa);
			cliDao.guardarCliente(yo);

			Factura nuevaFactura = new Factura(yo, "tarjeta", 12,new Direccion("casa", "madrid", "madrid", "spain", 28400),new ArrayList<Pedido>());// Factura de prueba sin // pedidos//////
			facDao.guardarFactura(nuevaFactura);

			yo.agregarFactura(nuevaFactura);
			cliDao.actualizarCliente(yo);

			// crear proveedor
			Direccion dir1 = new Direccion("C/Agua 9", "Malaga", "Malaga","Espana", 29012);
			Proveedor prov1 = new Proveedor("A0001N", "Empresa de Vasijas",66546546, "http://www.vasijas.com", "vasijas@vasijas","vasijas", dir1);
			prov1 = proveDao.guardarProveedor(prov1);
			
			Producto produ1 = new Producto("Fuente azul",25,31,25,"fuente","Fuente azul perfecta para diferentes snacks.",55,2,true,"http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg",null, prov1);
			Producto produ2 = new Producto("Vasija china", 37.5, 44.99, 44.99,"vasija","Vasija de estetica china, perfecta para decorar.", 10,2,false,"http://www.museodevigo.org/img/coleccion/china.jpg", null,prov1);
			Producto produ3 = new Producto("Taza de escamas",9.5,12.3,12.3,"copa","Taza aguamarina con bonito detalle de escamas.",47,2,false,"http://media-cache-ec0.pinimg.com/736x/d7/a6/ab/d7a6ab9e53e8ea1e3d3dc47ea265f44c.jpg",null, prov1);
			Producto produ4 = new Producto("Botijo clasico",14,18.5,18.5,"botijo","Â¿Eres un amante de lo rÃºstico? El mejor botijo para decorar tu casa y mantener el agua fresca.",200,2,false,"http://www.ceramicasavante.com/104-194-thickbox/botijo-de-nevera-botijo-artesano-de-ceramica-tradiconal-hecho-a-mano-botijo-de-barro-para-poner-en-la-nevera.jpg",null, prov1);
			Producto produ5 = new Producto(
					"Fuente mexicana",
					20,
					28,
					28,
					"fuente",
					"Colorida fuente de inspiraciÃ³n mexicana.",
					64,2,
					false,
					"http://media-cache-ec0.pinimg.com/736x/9f/b3/57/9fb357fccefa80f345f65f10c92f0214.jpg",
					null, prov1);
			Producto produ6 = new Producto(
					"Vasija peruana",
					32,
					40.8,
					32,
					"vasija",
					"Vasija mediana con motivos peruanos.",
					37,2,
					true,
					" http://www.mecd.gob.es/dms/museos/museodeamerica/coleccion/seleccion-de-piezas/png-etnologia/MAMF1984_09_292-shipibo/MAMF1984_09_292-shipibo.png",
					null, prov1);
			Producto produ7 = new Producto(
					"Maceta de Buho",
					16,
					20.75,
					20.75,
					"maceta",
					"Maceta con forma de bÃºho ideal para pequeÃ±as plantas.",
					83,2,
					false,
					"https://img1.etsystatic.com/045/0/9814905/il_570xN.668584145_flxx.jpg",
					null, prov1);
			Producto produ8 = new Producto(
					"Botijo Barroco",
					18.75,
					22.5,
					22.5,
					"botijo",
					"Botijo exquisitamente decorado que aÃ±adirÃ¡ un toque de elegancia a su hogar.",
					38,2,
					false,
					" http://0.static.wix.com/media/11be1a_20bcd5432638905887cf91c615b70686.jpg_1024",
					null, prov1);
			Producto produ9 = new Producto(
					"Tinaja clasica",
					28,
					35.5,
					28,
					"tinaja",
					"Herederas de las tinajas romanas, ahora puedes tener una en tu casa.",
					150,2,
					true,
					" http://www.ranchogordo.com/assets/images/cook_claypots/clay_pots_-035.jpg",
					null, prov1);
			Producto produ10 = new Producto(
					"Fuentes paisleys",
					15,
					25,
					25,
					"fuente",
					"AÃ±adirÃ¡ un toque exÃ³tico a tu salÃ³n, disponible en varios colores.",
					97,2,
					false,
					"http://media-cache-ec0.pinimg.com/736x/cc/f4/0b/ccf40b411787c952ff7d9b1b0dee6f9b.jpg",
					null, prov1);

			prov1.agregarProducto(produ1);
			prov1.agregarProducto(produ2);
			prov1.agregarProducto(produ3);
			prov1.agregarProducto(produ3);
			prov1.agregarProducto(produ4);
			prov1.agregarProducto(produ5);
			prov1.agregarProducto(produ6);
			prov1.agregarProducto(produ7);
			prov1.agregarProducto(produ8);
			prov1.agregarProducto(produ9);
			prov1.agregarProducto(produ10);
			proveDao.modificarProveedor(prov1);

			Direccion dir2 = new Direccion("C/Perla 3 ", "Murcia", "Murcia",
					"Espana", 30060);
			Proveedor prov2 = new Proveedor("B0002H", "Ceramica Murcia",
					65465465, "http://www.ceramurcia.com",
					"ceramurcia@ceramurcia", "ceramica", dir2);
			prov2 = proveDao.guardarProveedor(prov2);
			Producto produ11 = new Producto(
					"Taza Monstruo de las Galletas",
					8,
					10,
					10,
					"copa",
					"Traido directamente desde Barrio samo, la taza que se come tus galletas.",
					100,2,
					false,
					" https://img1.etsystatic.com/009/0/5783565/il_570xN.418527041_cnwj.jpg",
					null, prov2);
			Producto produ12 = new Producto(
					"Maceta Rana",
					15,
					19,
					19,
					"maceta",
					"SimpÃ¡tica maceta que llenarÃ¡ de vida tu terraza.",
					72,2,
					false,
					"https://img0.etsystatic.com/036/0/7724114/il_570xN.575541942_fs7c.jpg",
					null, prov2);
			Producto produ13 = new Producto(
					"Botijo Pajaro",
					15,
					20,
					15,
					"botijo",
					"Botijo con dibujos inspirados en la naturaleza china.",
					44,2,
					true,
					"http://media-cache-ec0.pinimg.com/736x/ec/cb/0c/eccb0c370f9bd4d1e130b77b569305a9.jpg",
					null, prov2);
			Producto produ14 = new Producto("Tinaja egipcia", 37, 44.75, 44.75,
					"tinaja", "Gran tinaja con motivos egipcios.", 17,2, false,
					"http://www.britishmuseum.org/images/k13352_m.jpg", null,
					prov2);
			Producto produ15 = new Producto(
					"Vasija griega",
					40,
					50,
					50,
					"vasija",
					"Â¿Eres un amante de la cultura griega? Esta es tu vasija.",
					27,2,
					false,
					"http://3.bp.blogspot.com/_zc1MGDboksw/SFP4nT_kPLI/AAAAAAAABtY/JwW1ePkIOm4/s400/vasija02.jpg",
					null, prov2);

			prov2.agregarProducto(produ11);
			prov2.agregarProducto(produ12);
			prov2.agregarProducto(produ13);
			prov2.agregarProducto(produ14);
			prov2.agregarProducto(produ15);
			proveDao.modificarProveedor(prov2);

			Direccion dir3 = new Direccion("C/Hierbabuena 1", "Madrid",
					"Madrid", "Espana", 28039);
			Proveedor prov3 = new Proveedor("C0006G", "Pintores Ceramica",
					66546464, "http://www.pintocera.com",
					"pintocera@hotmail.com", "pintores", dir3);
			prov3 = proveDao.guardarProveedor(prov3);
			Producto produ16 = new Producto(
					"Copa blanca con puntos",
					5,
					8.5,
					5,
					"copa",
					"Copa elegante con puntos blancos.",
					66,2,
					true,
					"http://cdn.tiendanube.com/stores/049/301/products/copa%20puntitos%2031-1024-1024.jpg",
					null, prov3);
			Producto produ17 = new Producto(
					"Maceta cerdito",
					20,
					24.99,
					24.99,
					"maceta",
					"Monedas no, plantas sÃ­.",
					75,2,
					false,
					"http://media-cache-ak0.pinimg.com/736x/49/13/ba/4913bafa14bab6bcdf03446c64304ba9.jpg",
					null, prov3);
			Producto produ18 = new Producto(
					"Tinaja africana",
					33,
					40,
					33,
					"tinaja",
					"Tinaja de gran tamaÃ±o para los amantes de Ã�frica.",
					13,2,
					true,
					"http://media-cache-ak0.pinimg.com/736x/e5/0c/7f/e50c7fbf0f1197dc2745d27eef27b153.jpg",
					null, prov3);
			Producto produ19 = new Producto(
					"Tinaja barro",
					20,
					30,
					27,
					"tinaja",
					"Tinaja de barro ideal para el jardín",
					8,2,
					false,
					"http://tinajasmorenoleon.com/wp-content/uploads/2011/12/tinaja-barro_lisa.jpg",
					null, prov3);
			Producto produ20 = new Producto(
					"Tinaja cuello alto",
					35,
					37,
					36,
					"tinaja",
					"Tinaja de barro de cuello alto con asas",
					25,2,
					false,
					"http://tinajasmorenoleon.com/wp-content/uploads/2011/12/tinaja-barro-cuello-alto.jpg",
					null, prov3);

			prov3.agregarProducto(produ16);
			prov3.agregarProducto(produ17);
			prov3.agregarProducto(produ18);
			prov3.agregarProducto(produ19);
			prov3.agregarProducto(produ20);
			proveDao.modificarProveedor(prov3);

			Direccion dir4 = new Direccion("C/De los Formigueiros 58",
					"Sarria", "Galicia", "Espana", 27600);
			Proveedor prov4 = new Proveedor("J0003K",
					"Arte y Ceramica de Galicia", 63615314, "http://www.arteceragalicia.com",
					"acg@gmail.com", "arte", dir4);
			prov4 = proveDao.guardarProveedor(prov4);
			Producto produ21 = new Producto(
					"Tinaja blanca baja",
					47,
					55,
					51,
					"tinaja",
					"Tinaja de barro pequeña blanca",
					32,2,
					false,
					"http://www.ceramicasavante.com/128-214-thickbox/tinaja-tarragona-tinaja-de-barro-natural-resistente-a-las-heladas.jpg",
					null, prov4);
			Producto produ22 = new Producto(
					"Tinaja olla",
					50,
					60,
					52,
					"tinaja",
					"Tinaja de barro con forma de olla con asas",
					7,2,
					false,
					"http://tinajasmorenoleon.com/wp-content/uploads/2011/12/tinaja-barro_olla.jpg",
					null, prov4);
			Producto produ23 = new Producto(
					"Tinaja antigua",
					75,
					100,
					75,
					"tinaja",
					"Tinaja antigua grande decorativa",
					5,2,
					true,
					"http://www.tinajasorozco.com/files/productos/tinaja_antigua_redonda_500.jpg",
					null, prov4);
			Producto produ24 = new Producto(
					"Tinaja con relieve",
					35,
					40,
					37,
					"tinaja",
					"Tinaja de barro pequeña con relieve",
					25,2,
					false,
					"http://www.hornospereruela.es/recursos/productos/IMG_542651_G.jpg",
					null, prov4);
			Producto produ25 = new Producto(
					"Tinaja oscura",
					10,
					15,
					10,
					"tinaja",
					"Tinaja pequeña oscura con relive de letras chinas ",
					28,2,
					true,
					"http://www.artesanum.com/upload/postal/5/2/0/tinaja-1-1864.jpg",
					null, prov4);

			prov4.agregarProducto(produ21);
			prov4.agregarProducto(produ22);
			;
			prov4.agregarProducto(produ23);
			prov4.agregarProducto(produ24);
			prov4.agregarProducto(produ25);
			proveDao.modificarProveedor(prov4);

			Direccion dir5 = new Direccion("Av/Portugal 106", "Salamanca",
					"Salamanca", "Espana", 37005);
			Proveedor prov5 = new Proveedor("M0007Q", "Grespania", 64316975,
					"http://www.grespania.com/", "gres@gmail.com", "ceramica",
					dir5);
			prov5 = proveDao.guardarProveedor(prov5);

			Producto produ26 = new Producto(
					"Tinaja naranja",
					12,
					22,
					17,
					"tinaja",
					"Tinaja pequeña de barro de color naranja",
					32,2,
					false,
					"http://botanicaojuanimeyi.com/wp-content/uploads/2013/10/tinaja.jpg",
					null, prov5);
			Producto produ27 = new Producto(
					"Maceta naranja",
					11.50,
					17.50,
					11.50,
					"maceta",
					"Maceta de barro pequeña de color naranja",
					40,2,
					false,
					"http://www.ociohogar.com/2628-thickbox/maceta-plastico-vondom.jpg",
					null, prov5);
			Producto produ28 = new Producto(
					"Maceta marron",
					11.50,
					17.50,
					11.50,
					"maceta",
					"Maceta de barro pequeña de color marrón",
					75,2,
					false,
					"http://www.ociohogar.com/2622-thickbox/maceta-plastico-vondom.jpg",
					null, prov5);
			Producto produ29 = new Producto(
					"Maceta ovalada",
					27,
					35,
					27,
					"maceta",
					"Maceta de barro ovalada pequeña.",
					20,2,
					true,
					"http://www.jardineria.pro/wp-content/uploads/2007/12/maceta1.jpg",
					null, prov5);
			Producto produ30 = new Producto(
					"Maceta labrada",
					30,
					40,
					35,
					"maceta",
					"Maceta de barro pequeña con relieves labrados.",
					35,2,
					false,
					"http://www.lacasadelamaceta.com/data/images/bng061_-_maceta_americana_labrada.jpg",
					null, prov5);

			prov5.agregarProducto(produ26);
			prov5.agregarProducto(produ27);
			prov5.agregarProducto(produ28);
			prov5.agregarProducto(produ29);
			prov5.agregarProducto(produ30);
			proveDao.modificarProveedor(prov5);

			Direccion dir6 = new Direccion("C/Serrano 49 ", "Madrid", "Madrid",
					"Espana", 28001);
			Proveedor prov6 = new Proveedor("P0004W", "Ceracasa", 63571485,
					"http://www.ceracasa.com/", "ceracasa@gmail.com",
					"ceramica", dir6);
			prov6 = proveDao.guardarProveedor(prov6);

			Producto produ31 = new Producto(
					"Maceta griega",
					37,
					48,
					40,
					"maceta",
					"Maceta de barro con relieve de estilo griego",
					20,2,
					false,
					"https://istiaiden.files.wordpress.com/2011/06/dsc03548.jpg",
					null, prov6);
			Producto produ32 = new Producto(
					"Maceta cuadrada",
					50,
					65.99,
					50,
					"maceta",
					"Maceta de barro cuadrada pequeña",
					17,2,
					true,
					"http://plantajardin.com/305-thickbox/maceta-cuadrada-resina-milrayas.jpg",
					null, prov6);
			Producto produ33 = new Producto("Copa barro", 7, 8.5, 7, "copa",
					"Copa de barro pequeña con relieve de estilo griego", 50,2,
					true,
					"http://www.estecha.com/imagen/copas-ceramica-jardin.jpg",
					null, prov6);
			Producto produ34 = new Producto(
					"Copa barro con cuello",
					17,
					24.99,
					20,
					"copa",
					"Copa de barro mediano con cuello alto",
					20,2,
					false,
					"http://www.decorarconarte.com/WebRoot/StoreES2/Shops/61552482/4D52/405E/4179/C7F5/1737/C0A8/2981/18C8/Copa_ceramica_244.jpg",
					null, prov6);
			Producto produ35 = new Producto("Copa barro con cuello bajo", 17,
					24.99, 20, "copa",
					"Copa de barro mediano con cuello bajo.", 20,2, false,
					"http://www.estecha.com/imagen/copa-guadaira-146.jpg",
					null, prov6);

			prov6.agregarProducto(produ31);
			prov6.agregarProducto(produ32);
			prov6.agregarProducto(produ33);
			prov6.agregarProducto(produ34);
			prov6.agregarProducto(produ35);
			proveDao.modificarProveedor(prov6);

			Direccion dir7 = new Direccion("C/Jabberwock sn",
					"Jabberwock Beach", "Antigua", "Antigua y Barbuda", 8080);
			Proveedor prov7 = new Proveedor("I0006E", "Ascer", 61679438,
					"http://www.ascer.es/", "ascer@gmail.com", "pintores", dir7);
			prov7 = proveDao.guardarProveedor(prov7);
			Producto produ36 = new Producto(
					"Fuente hoja",
					32,
					56,
					45,
					"fuente",
					"Fuente con forma de hoja.",
					7,2,
					false,
					"http://1.bp.blogspot.com/-BBNbpdIwQ9Q/Uotat-8TDmI/AAAAAAAAA94/-WJXKK_7feY/s1600/IMG_2769.jpg",
					null, prov7);
			Producto produ37 = new Producto(
					"Botijo espiral",
					54,
					76,
					64,
					"botijo",
					"Botijo con decoración en espiral.",
					23,2,
					false,
					"http://www.ceramicasavante.com/103-193-thickbox/botijo-de-carro-botijo-artesano-de-ceramica-tradiconal-hecho-a-mano-botijo-para-transportar-agua.jpg",
					null, prov7);
			Producto produ38 = new Producto(
					"Vasija Recuay sexual",
					150,
					240,
					190,
					"vasija",
					"Vasija de barro con motivo sexual.",
					2,2,
					false,
					"http://img1.wikia.nocookie.net/__cb20080616110952/ceramica/images/5/51/Vasija_Recuay_sexual_(M._Am%C3%A9rica_Inv.11098)_01.jpg",
					null, prov7);
			Producto produ39 = new Producto(
					"Fuente con rostro",
					45,
					55,
					50,
					"fuente",
					"Fuente con una cara, fin decorativo.",
					34,2,
					false,
					"http://www.adevaherranz.es/ARTE/ESPANA/CONTEMPORANEA/XX%20ARTES%20MENORES%20PICASSO%20ESPANA/Art%20Ceramica%20XX%20Picasso%20Fuente%20rectangular%20Barro%20vidriado%20con%20engobes%20e%20incisiones%20Vallauris%201947.gif",
					null, prov7);
			Producto produ40 = new Producto("Botijo abuelo", 31, 42, 37,
					"botijo", "Botijo con dibujo del abuelo.", 4,2, false,
					"http://www.botijopedia.com/es/images/france_00.gif", null,
					prov7);
			Producto produ41 = new Producto(
					"Vasija hojas",
					15,
					23,
					19,
					"vasija",
					"Vasija decorada con motivos de hojas.",
					24,2,
					false,
					"http://azu1.facilisimo.com/ima/i/3/9/25/am_79212_5042791_608821.jpg",
					null, prov7);

			prov7.agregarProducto(produ36);
			prov7.agregarProducto(produ37);
			prov7.agregarProducto(produ38);
			prov7.agregarProducto(produ39);
			prov7.agregarProducto(produ40);
			prov7.agregarProducto(produ41);
			proveDao.modificarProveedor(prov7);

			Direccion dir8 = new Direccion("C/Riosalido 10", "Almazan",
					"Soria", "Espana", 42200);
			Proveedor prov8 = new Proveedor("H0004R", "Vives azulejos y gres",
					67341658, "http://www.vivesceramica.com/",
					"vayf@gmail.com", "ceramica", dir8);
			prov8 = proveDao.guardarProveedor(prov8);
			Producto produ42 = new Producto(
					"Vasija griega",
					45,
					72,
					53,
					"vasija",
					"Vasija con inscripcción en griego.",
					21,2,
					false,
					"http://www.imperioromano.com/blog/img/hallada-vasija-con-inscripcion-que-alude-supuestamente-a-jesucristo-en-alejandria1.jpg",
					null, prov8);
			Producto produ43 = new Producto(
					"Fuente floral",
					25,
					50,
					30,
					"fuente",
					"Fuente esmaltada y decorada con motivos florales.",
					31,2,
					false,
					"http://91.229.239.8/fg/1265/70/otros-articulos-de-menaje/fuente-o-frutero-de-barro-126570906_1.jpg",
					null, prov8);
			Producto produ44 = new Producto(
					"Botijo OVNI oliva",
					65,
					80,
					75,
					"botijo",
					"Botijo achatado con forma de OVNI, esmaltado en verde oliva.",
					4,2,
					false,
					"http://www.ceramicasavante.com/105-195-thickbox/botijo-ovni-botijo-artesano-de-ceramica-tradiconal-hecho-a-mano-con-barro-natural-botijo-decorado-para-agua.jpg",
					null, prov8);
			Producto produ45 = new Producto("Vasija Chulcana", 56, 76, 67,
					"vasija",
					"Vasija decorada con motivos de la cultura chulcana.", 17,2,
					false, "http://galeon.hispavista.com/artefyr/img/vasija",
					null, prov8);

			prov8.agregarProducto(produ42);
			prov8.agregarProducto(produ43);
			prov8.agregarProducto(produ44);
			prov8.agregarProducto(produ45);
			proveDao.modificarProveedor(prov8);

			Direccion dir9 = new Direccion("C/De la Salud 6", "Madrid",
					"Madrid", "Espana", 28013);
			Proveedor prov9 = new Proveedor("G0008T", "TAU ceramica", 66741379,
					"http://tauceramica.com/", "taucer@gmail.com", "ceramica",
					dir9);
			prov9 = proveDao.guardarProveedor(prov9);
			Producto produ46 = new Producto(
					"Fuente geométrica",
					50,
					70,
					65,
					"fuente",
					"Fuente decorada con motivos geométricos.",
					15,2,
					false,
					"http://pictures2.todocoleccion.net/tc/2014/08/26/11/44946456.jpg",
					null, prov9);
			Producto produ47 = new Producto(
					"Botijo moderno",
					40,
					55,
					51,
					"botijo",
					"Botijo moderno sin asa, diseño exclusivo.",
					8,2,
					false,
					"http://diariodesign.com/wp-content/uploads/2012/05/Mil%C3%A1n-Satellite-2012-elBOTIJO_MLerma_MThurne_06.jpg",
					null, prov9);
			Producto produ48 = new Producto(
					"Vasija abstracta",
					35,
					48,
					40,
					"vasija",
					"Vasija decorada con motivos abstractos.",
					29,2,
					false,
					"http://upload.wikimedia.org/wikipedia/commons/b/b3/Vasija.jpg",
					null, prov9);
			Producto produ49 = new Producto(
					"Fuente barro peruano",
					50,
					70,
					59,
					"fuente",
					"Fuente de barro hecha en Perú.",
					11,2,
					false,
					"http://ollasdebarroperu.com/web/wp-content/uploads/2012/12/fotos17.jpg",
					null, prov9);
			Producto produ54 = new Producto("Botijo abuelo", 31, 42, 37,
					"botijo", "Botijo con dibujo del abuelo.", 4,2, false,
					"http://www.botijopedia.com/es/images/france_00.gif", null,
					prov9);
			Producto produ55 = new Producto(
					"Vasija hojas",
					15,
					23,
					19,
					"vasija",
					"Vasija decorada con motivos de hojas.",
					24,2,
					false,
					"http://azu1.facilisimo.com/ima/i/3/9/25/am_79212_5042791_608821.jpg",
					null, prov9);
			Producto produ56 = new Producto(
					"Fuente geométrica",
					50,
					70,
					65,
					"fuente",
					"Fuente decorada con motivos geométricos.",
					15,2,
					false,
					"http://pictures2.todocoleccion.net/tc/2014/08/26/11/44946456.jpg",
					null, prov9);
			Producto produ57 = new Producto(
					"Botijo moderno",
					40,
					55,
					51,
					"botijo",
					"Botijo moderno sin asa, diseño exclusivo.",
					8,2,
					false,
					"http://diariodesign.com/wp-content/uploads/2012/05/Mil%C3%A1n-Satellite-2012-elBOTIJO_MLerma_MThurne_06.jpg",
					null, prov9);
			Producto produ60 = new Producto(
					"Botijo con asa",
					15,
					23,
					19,
					"botijo",
					"Botijo con asa sin barnizar.",
					21,2,
					false,
					"http://4.bp.blogspot.com/-qcKfSZsu_zk/USlK9kJ9GsI/AAAAAAAAAxo/tBejQjfDFgw/s1600/blog_botijo.jpg",
					null, prov9);

			prov9.agregarProducto(produ54);
			prov9.agregarProducto(produ55);
			prov9.agregarProducto(produ56);
			prov9.agregarProducto(produ57);
			prov9.agregarProducto(produ60);
			prov9.agregarProducto(produ46);
			prov9.agregarProducto(produ47);
			prov9.agregarProducto(produ48);
			prov9.agregarProducto(produ49);
			proveDao.modificarProveedor(prov9);

			/*
			 * List<Producto> productos = new ArrayList<Producto>(); Producto
			 * nuevoProducto = new Producto("xxx", 12.1, 12.1, 21.1, "wwww",
			 * "wwwwwww", 21, true, "wqwqwqw",null); nuevoProducto =
			 * proDao.guardarProducto(nuevoProducto);
			 * productos.add(nuevoProducto);
			 */

			// crear proveedor
			/*
			 * Direccion direccion =new Direccion("mi casa", "peru", "peru",
			 * "peru", 123); Proveedor provedor = new Proveedor("A01", "uc3m",
			 * 91919191, "www.uc3m.es", "uc3m@uc3m", "uc3m", direccion);
			 * provedor=proveDao.guardarProveedor(provedor);
			 * 
			 * //crear su producto Producto prod1= new Producto("Fuente azul",
			 * 12.1, 12.1, 21.1, "fuente",
			 * "Vasija de estética china, perfecta para decorar.", 21, true,
			 * "http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg"
			 * ,null,provedor); provedor.agregarProducto(prod1);
			 * proveDao.modificarProveedor(provedor);
			 * 
			 * 
			 * //mostrar producto Producto productoFinal =
			 * proDao.buscarProductoNombre("Fuente azul");
			 * System.out.println("nombre producto:"+productoFinal.getNombre());
			 * System.out.println("nombre precio:"+productoFinal.getPrecio());
			 * System
			 * .out.println("nombre nonbre Proveedor:"+productoFinal.getProveedor
			 * ().getNombre());
			 */

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la carga de BD");
			System.out.println(e);
		}
		/*
		 * String[] nombres={"Fuente azul","Vasija china"}; String[]
		 * proveedorNom={}
		 * 
		 * String[] descripcion={"Fuente azul perfecta para diferentes snacks.",
		 * "Vasija de estética china, perfecta para decorar."}; String[]
		 * urlImagen={
		 * "http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg"
		 * ,"http://www.museodevigo.org/img/coleccion/china.jpg"}; double []
		 * pre_min={25,37.5}; double [] pre_max={31,44.99}; double []
		 * precio={31,44.99}; int [] stock={55,10}; String []
		 * tipo={"fuente","vasija"}; boolean [] oferta ={true,true};
		 * 
		 * for (int i = 0; i < nombres.length; i++) { Producto nuevoProducto=new
		 * Producto(nombres[i], pre_min[i], pre_max[i], precio[i], tipo[i],
		 * descripcion[i], stock[i], oferta[i], urlImagen[i], null);
		 * System.out.println("cargando datos");///DEBUG try {
		 * proDao.guardarProducto(nuevoProducto); System.out.println(
		 * "****************se ha guardado un nuevo producto******************"
		 * +i);///DEBUG } catch (Exception e) { e.printStackTrace(); }
		 * 
		 * }
		 */

	}
	/** Fin de Carga de Catalogo **/

}
