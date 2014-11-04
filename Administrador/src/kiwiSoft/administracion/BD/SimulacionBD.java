package kiwiSoft.administracion.BD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class SimulacionBD {
	public ArrayList<Cliente> dbClientes;
	public ArrayList<Producto> dbProductos;
	public ArrayList<Proveedor> dbProveedores;
	
	public SimulacionBD() {
		// TODO Auto-generated constructor stub
		/*****Se construye una base de datos de sumulacion********/
		
		/**CLientes**/
		this.dbClientes = new ArrayList<Cliente>();
		dbClientes.add(new Cliente(0, "Tomas", 66666666, "tomas@tomas.com", "c/linares"));
		dbClientes.add(new Cliente(1, "Alex",  77777777, "alex@alex.com", "c/pardo, villalba"));
		dbClientes.add(new Cliente(2, "Juan", 66666666, "juan@juan.com", "c/molina, madrid"));
		dbClientes.add(new Cliente(3, "Pedro", 66666666, "pedro@pedro.com", "c/oliva, las rozas"));
		
		/**Proveedores**/
		this.dbProveedores = new ArrayList<Proveedor>();
		dbProveedores.add(new Proveedor("A0001N", "Empresa de Vasijas", "Malaga", 66546546, "vasijas@vasijas", "wwww.vasijas.com"));
		dbProveedores.add(new Proveedor("B0002H", "Ceramica Murcia", "Murcia", 65465465, "ceramurcia@ceramurcia", "wwww.ceramurcia.com"));
		dbProveedores.add(new Proveedor("C0006G", "Pintores Ceramica", "Madrid", 66546464, "pintocera@hotmail.com", "wwww.pintocera.com"));
		dbProveedores.add(new Proveedor("J0001K", "Arte y Cerámica de Galicia", "Galicia", 93615314, "acg@gmail.com", "wwww.arteceragalicia.com"));
		
		
		/**Productos**/
		this.dbProductos = new ArrayList<Producto>();
		dbProductos.add(new Producto(1, "A0001N", 12, 20, "vasija", "la mejor coleccion de arte y cera...", 50, "Vasijas de colores","http://www.ventaceramica.es/gallery/coco_dec_rayas_t7v1i8e7.png"));
		dbProductos.add(new Producto(2, "B0002H", 5, 15, "decoracion", "la mejor coleccion de arte y cera...", 50, "Botija Terracota","http://www.ventaceramica.es/files/botija_1.png"));
		dbProductos.add(new Producto(3, "C0006G", 20, 50, "utencilios", "la mejor coleccion de arte y cera...", 50, "PLATO DE BARRO 15 CM","http://www.ventaceramica.es/files/platobarro.png"));
		dbProductos.add(new Producto(4, "J0001K", 55, 80, "antiguedad", "la mejor coleccion de arte y cera...", 50, "ALHAMBRA 30 X 40 CM","http://www.ventaceramica.es/files/copia-de-alhambra.png"));
		
	}
	
	/**editar**/
	public void editarCliente(int id, Cliente clienteAux) {
		// TODO Auto-generated method stub
		
		int index=0;
		Cliente cliente=null;
		Collection<Cliente> collection= this.dbClientes;
		for (Iterator<Cliente> iterator = collection.iterator(); iterator.hasNext();) {
			cliente = (Cliente) iterator.next();
			if(cliente.getIdc()==id){	
				dbClientes.set(index, clienteAux);
				return;
			}
			index++;
		}	
		
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
	
	/**eliminar**/
	public void eliminarCLiente(int id) {
		// TODO Auto-generated method stub
		Cliente cliente=null;
		Collection<Cliente> collection= this.dbClientes;
		for (Iterator<Cliente> iterator = collection.iterator(); iterator.hasNext();) {
			cliente = (Cliente) iterator.next();
			if(cliente.getIdc()==id){
				dbClientes.remove(cliente);
				return;
			}
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
		SimulacionBD dbSimulacion = new SimulacionBD();
		Collection<Cliente> collection= dbSimulacion.dbClientes;
		for (Iterator<Cliente> iterator = collection.iterator(); iterator.hasNext();) {
			Cliente cliente = (Cliente) iterator.next();
			System.out.println(cliente.getNombre());
		}
	}
	
}

