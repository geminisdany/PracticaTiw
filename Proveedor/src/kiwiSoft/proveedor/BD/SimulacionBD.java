package kiwiSoft.proveedor.BD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class SimulacionBD {
	public ArrayList<Producto> dbProductos;
	public ArrayList<Proveedor> dbProveedores;
	public ArrayList<Registro> dbRegistros;
	public int idProducto;
	
	public SimulacionBD() {
		// TODO Auto-generated constructor stub
		/*****Se construye una base de datos de sumulacion********/
		
		/**Proveedores**/
		this.dbProveedores = new ArrayList<Proveedor>();
		dbProveedores.add(new Proveedor("A0001N", "Empresa de Vasijas", "Malaga", 66546546, "vasijas@vasijas", "vasijas", "wwww.vasijas.com"));
		dbProveedores.add(new Proveedor("B0002H", "Ceramica Murcia", "Murcia", 65465465, "ceramurcia@ceramurcia", "ceramica", "wwww.ceramurcia.com"));
		dbProveedores.add(new Proveedor("C0006G", "Pintores Ceramica", "Madrid", 66546464, "pintocera@hotmail.com", "pintores", "wwww.pintocera.com"));
		dbProveedores.add(new Proveedor("J0001K", "Arte y Cerámica de Galicia", "Galicia", 93615314, "acg@gmail.com", "arte", "wwww.arteceragalicia.com"));
		
		
		/**Productos**/
		this.dbProductos = new ArrayList<Producto>();
		dbProductos.add(new Producto(1, "A0001N", 25, 31, "fuente", "Fuente azul perfecta para diferentes snacks.", 55, "Fuente azul","http://media-cache-ec0.pinimg.com/736x/95/70/4e/95704ea6eb353dc3014d5f55a1f55250.jpg", true));
		dbProductos.add(new Producto(2, "A0001N", 37.5, 44.99, "vasija", "Vasija de estética china, perfecta para decorar.", 10, "Vasija china","http://www.museodevigo.org/img/coleccion/china.jpg", true));
		dbProductos.add(new Producto(3, "A0001N", 9.5, 12.3, "copa", "Taza aguamarina con bonito detalle de escamas.", 47, "Taza de escamas","http://media-cache-ec0.pinimg.com/736x/d7/a6/ab/d7a6ab9e53e8ea1e3d3dc47ea265f44c.jpg"));
		dbProductos.add(new Producto(4, "A0001N", 14, 18.5, "botijo", "¿Eres un amante de lo rústico? El mejor botijo para decorar tu casa y mantener el agua fresca.", 200, "Botijo clásico","http://www.ceramicasavante.com/104-194-thickbox/botijo-de-nevera-botijo-artesano-de-ceramica-tradiconal-hecho-a-mano-botijo-de-barro-para-poner-en-la-nevera.jpg"));
		dbProductos.add(new Producto(5, "B0002H", 20, 28, "fuente", "Colorida fuente de inspiración mexicana.", 64, "Fuente mexicana","http://media-cache-ec0.pinimg.com/736x/9f/b3/57/9fb357fccefa80f345f65f10c92f0214.jpg"));
		dbProductos.add(new Producto(6, "B0002H", 32, 40.8, "vasija", "Vasija mediana con motivos peruanos.", 37, "Vasija peruana"," http://www.mecd.gob.es/dms/museos/museodeamerica/coleccion/seleccion-de-piezas/png-etnologia/MAMF1984_09_292-shipibo/MAMF1984_09_292-shipibo.png"));
		dbProductos.add(new Producto(7, "B0002H", 16, 20.75, "maceta", "Maceta con forma de búho ideal para pequeñas plantas.", 83, "Maceta de Búho","https://img1.etsystatic.com/045/0/9814905/il_570xN.668584145_flxx.jpg"));
		dbProductos.add(new Producto(8, "B0002H", 18.75, 22.5, "botijo", "Botijo exquisitamente decorado que añadirá un toque de elegancia a su hogar.", 38, "Botijo Barroco"," http://media-cache-cd0.pinimg.com/736x/b6/6f/cd/b66fcdce67919078a447f8a34f015a74.jpg"));
		dbProductos.add(new Producto(9, "B0002H", 28, 35.5, "tinaja", "Herederas de las tinajas romanas, ahora puedes tener una en tu casa.", 150, "Tinaja clásica"," http://www.ranchogordo.com/assets/images/cook_claypots/clay_pots_-035.jpg"));
		dbProductos.add(new Producto(10, "C0006G", 15, 25, "fuente", "Añadirá un toque exótico a tu salón, disponible en varios colores.", 97, "Fuentes paisleys","http://media-cache-ec0.pinimg.com/736x/cc/f4/0b/ccf40b411787c952ff7d9b1b0dee6f9b.jpg"));
		dbProductos.add(new Producto(11, "C0006G", 8, 10, "copa", "Traido directamente desde Barrio Sésamo, la taza que se come tus galletas.", 100, "Taza Monstruo de las Galletas"," https://img1.etsystatic.com/009/0/5783565/il_570xN.418527041_cnwj.jpg"));
		dbProductos.add(new Producto(12, "C0006G", 15, 19, "maceta", "Simpática maceta que llenará de vida tu terraza.", 72, "Maceta Rana","https://img0.etsystatic.com/036/0/7724114/il_570xN.575541942_fs7c.jpg"));
		dbProductos.add(new Producto(13, "C0006G", 15, 20, "botijo", "Botijo con dibujos inspirados en la naturaleza china.", 44, "Botijo Pájaro","http://media-cache-ec0.pinimg.com/736x/ec/cb/0c/eccb0c370f9bd4d1e130b77b569305a9.jpg"));
		dbProductos.add(new Producto(14, "C0006G", 37, 44.75, "tinaja", "Gran tinaja con motivos egipcios.", 17, "Tinaja egipcia","http://www.britishmuseum.org/images/k13352_m.jpg"));
		dbProductos.add(new Producto(15, "J0001K", 40, 50, "vasija", "¿Eres un amante de la cultura griega? Esta es tu vasija.", 27, "Vasija griega","http://3.bp.blogspot.com/_zc1MGDboksw/SFP4nT_kPLI/AAAAAAAABtY/JwW1ePkIOm4/s400/vasija02.jpg"));
		dbProductos.add(new Producto(16, "J0001K", 5, 8.5, "copa", "Copa elegante con puntos blancos.", 66, "Copa blanca con puntos","http://cdn.tiendanube.com/stores/049/301/products/copa%20puntitos%2031-1024-1024.jpg"));
		dbProductos.add(new Producto(17, "J0001K", 20, 24.99, "maceta", "Monedas no, plantas sí.", 75, "Maceta cerdito","http://media-cache-ak0.pinimg.com/736x/49/13/ba/4913bafa14bab6bcdf03446c64304ba9.jpg"));
		dbProductos.add(new Producto(18, "J0001K", 33, 40, "tinaja", "Tinaja de gran tamaño para los amantes de África.", 13, "Tinaja africana","http://media-cache-ak0.pinimg.com/736x/e5/0c/7f/e50c7fbf0f1197dc2745d27eef27b153.jpg"));
		
		/**Ultimo id de un producto creado**/
		idProducto = 18;
		
		/**Registros**/
		this.dbRegistros = new ArrayList<Registro>();
		dbRegistros.add(new Registro("vasijas@vasijas","vasijas"));
		dbRegistros.add(new Registro("ceramurcia@ceramurcia","ceramica"));
		dbRegistros.add(new Registro("pintocera@hotmail.com","pintores"));
		dbRegistros.add(new Registro("acg@gmail.com","arte"));
		
	}
	
	
	public void editarProductos(int id, Producto productoAux) {
		// TODO Auto-generated method stub
		int index=0;
		Producto producto=null;
		Collection<Producto> collection= this.dbProductos;
		for (Iterator<Producto> iterator = collection.iterator(); iterator.hasNext();) {
			producto = (Producto) iterator.next();
			if(producto.getIdp()==id){	
				dbProductos.set(index, productoAux);
				return;
			}
			index++;
		}	
		
	}
	
	public void anadirProductos(Producto productoAux) {
		// TODO Auto-generated method stub
		idProducto = idProducto + 1;
		productoAux.setIdp(idProducto);
		dbProductos.add(productoAux);
	}
	
	public void anadirProveedor(Proveedor provReg) {
		// TODO Auto-generated method stub
		dbProveedores.add(provReg);
	}
	
	public void editarProveedor(String cif, Proveedor proveedorAux ) {
		// TODO Auto-generated method stub
		
		int index=0;
		Proveedor proveedor=null;
		Collection<Proveedor> collection= this.dbProveedores;
		for (Iterator<Proveedor> iterator = collection.iterator(); iterator.hasNext();) {
			proveedor = (Proveedor) iterator.next();
			if(proveedor.getCif().equalsIgnoreCase(cif)){
				System.out.println("encontrado****");
				dbProveedores.set(index, proveedorAux);
				return;
			}
			index++;
		}	
	}
	
		
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		Producto producto=null;
		Collection<Producto> collection= this.dbProductos;
		for (Iterator<Producto> iterator = collection.iterator(); iterator.hasNext();) {
			producto = (Producto) iterator.next();
			if(producto.getIdp()==id){
				dbProductos.remove(producto);
				return;
			}
		}
	}
	
	
	public void eliminarProveedor(String cif) {
		// TODO Auto-generated method stub
				Proveedor proveedor=null;
				Collection<Proveedor> collection= this.dbProveedores;
				for (Iterator<Proveedor> iterator = collection.iterator(); iterator.hasNext();) {
					proveedor = (Proveedor) iterator.next();
					if(proveedor.getCif().equals(cif)){
						dbProveedores.remove(proveedor);
						return;
					}
				}
	}
	
	/**Producto en Oferta**/
	public void productoOferta(int idp) {
		// TODO Auto-generated method stub
		int index=0;
		Producto producto=null;
		Collection<Producto> collection= this.dbProductos;
		for (Iterator<Producto> iterator = collection.iterator(); iterator.hasNext();) {
			producto = (Producto) iterator.next();
			if(producto.getIdp()==idp){
				producto.setOferta(true);
				producto.setPre_act(producto.getPre_min());
				dbProductos.set(index,producto);
				return;
			}
			index++;
		}
	}
	
	public static void main(String[] args) {
		SimulacionBD dbSimul = new SimulacionBD();
	}
	
}

