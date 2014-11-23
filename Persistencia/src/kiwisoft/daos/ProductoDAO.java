package kiwisoft.daos;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Producto;


public class ProductoDAO {
	private final EntityManager em;
	private final UserTransaction ut;
	
	public ProductoDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	public Collection<Producto> findAll() throws Exception{
		// TODO Auto-generated method stub
		return em.createQuery("select u from Producto u",Producto.class).getResultList();
	}
	
	
	public Producto guardarProducto(Producto nuevoProducto) throws Exception{
		ut.begin();
		em.persist(nuevoProducto); 
		ut.commit();	
		return nuevoProducto; 
	}
	
	/***borrar un Producto
	 * @param producto
	 * @throws Exception
	 */
	public void borrarProducto(Producto producto)throws Exception{
        ut.begin();
        em.remove(em.merge(producto));
        ut.commit();
	}
	
	/***Actualizar Producto
	 * @param productoActualizado
	 * @return Producto
	 * @throws Exception
	 */
	public Producto actualizarProducto(Producto productoActualizado) throws Exception{
        ut.begin();
        em.merge(productoActualizado);
        ut.commit();
        return productoActualizado;
	}
	
	public Producto modificarProducto(Producto producto) throws Exception{
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(producto);
		ut.commit();
		return producto;
	}
	 

	 public Collection<Producto> listarProductos()throws NoResultException{
         return em.createQuery("select u from Producto u",Producto.class).getResultList();
	 }
	 
	public Producto buscarProducto(Long pk){
		return em.createQuery("select u from Producto u where u.id='"+pk+"'",Producto.class).getSingleResult();
	}
	
	public Collection<Producto> buscarProductoOferta(){
		return em.createQuery("select u from Producto u where u.oferta='"+true+"'",Producto.class).getResultList();
	}
	
	
	//busqueda simple por nombre EXACTO
	public Producto buscarProductoNombreExacto(String nombre){
		return em.createQuery("select u from Producto u where u.nombre='"+nombre+"'",Producto.class).getSingleResult();
	}
	
	//busqueda simple por nombre, contiene el nombre
	public Collection<Producto> buscarProductoNombre(String nombre){
		return em.createQuery("select u from Producto u where lower(u.nombre) like lower('%"+nombre+"%')",Producto.class).getResultList();
	}
	
	//busqueda simple por tipo
	public Collection<Producto> buscarProductoTipo(String tipo){
		return em.createQuery("select u from Producto u where u.tipo='"+tipo+"'",Producto.class).getResultList();
	}
	
	//busqueda simple por proveedor EXACTO
	public Collection<Producto> buscarProductoProveedorExacto(String proveedor){
		return em.createQuery("select u from Producto u where u.proveedor.nombre='"+proveedor+"'",Producto.class).getResultList();
	}
	
	//busqueda simple por proveedor
		public Collection<Producto> buscarProductoProveedor(String proveedor){
			return em.createQuery("select u from Producto u where lower(u.proveedor.nombre) like lower('%"+proveedor+"%')",Producto.class).getResultList();
		}
	
	///busqueda Basica por Precio
	public Collection<Producto> buscarProductoMayor(double precio){
		return em.createQuery("select u from Producto u where u.precio>'"+precio+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoMenor(double precio){
		return em.createQuery("select u from Producto u where u.precio<'"+precio+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoIgual(double precio){
		return em.createQuery("select u from Producto u where u.precio='"+precio+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarAvanzado(String campo1,String valor1, String operador, String campo2,String valor2) {
		// TODO Auto-generated method stub
		if(campo1.equals("proveedor"))
			campo1="proveedor.nombre";
		if(campo2.equals("proveedor"))
			campo2="proveedor.nombre";
		
		return em.createQuery("select u from Producto u where lower(u."+campo1+") like lower('%"+valor1+"%') "+operador+" u."+campo2+" like lower('%"+valor2+"%')",Producto.class).getResultList();
	}
	
	
	
	
	
	public Collection<Producto> buscarProductoProveedor(Long idProveedor){
		return em.createQuery("select u from Producto u join u.proveedor p where p.id='"+idProveedor+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoProveedorTipo(Long idProveedor, String tipo){
		return em.createQuery("select u from Producto u join u.proveedor p where p.id='"+idProveedor+"' and u.tipo='"+tipo+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoProveedorOferta(Long idProveedor){
		return em.createQuery("select u from Producto u join u.proveedor p where p.id='"+idProveedor+"' and u.oferta='"+true+"'",Producto.class).getResultList();
	}
	
}
