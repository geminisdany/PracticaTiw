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
	
	 

	 public Collection<Producto> listarProductos()throws NoResultException{
         return em.createQuery("select u from Producto u",Producto.class).getResultList();
	 }
	 
	public Producto buscarProducto(Long pk){
		return em.createQuery("select u from Producto u where u.Id='"+pk+"'",Producto.class).getSingleResult();
	}
	
	public Collection<Producto> buscarProductoMayor(Float precio){
		return em.createQuery("select u from Producto u where u.precio>='"+precio+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoMenor(Float precio){
		return em.createQuery("select u from Producto u where u.precio<='"+precio+"'",Producto.class).getResultList();
	}
	
	public Collection<Producto> buscarProductoTipo(String tipo){
		return em.createQuery("select u from Producto u where u.tipo='"+tipo+"'",Producto.class).getResultList();
	}
	
	public Producto buscarProductoNombre(String nombre){
		return em.createQuery("select u from Producto u where u.nombre='"+nombre+"'",Producto.class).getSingleResult();
	}
	
	public Collection<Producto> buscarProductoOferta(){
		return em.createQuery("select u from Producto u where u.oferta='"+true+"'",Producto.class).getResultList();
	}

}
