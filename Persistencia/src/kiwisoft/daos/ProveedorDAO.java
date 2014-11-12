package kiwisoft.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Proveedor;

public class ProveedorDAO {
	private final EntityManager em;
	private final UserTransaction ut;
	public ProveedorDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	public Proveedor guardarProveedor(Proveedor nuevoProveedor) throws Exception{
		ut.begin();
		em.persist(nuevoProveedor); 
		ut.commit();	
		return nuevoProveedor; 
	}
	
	public Proveedor modificarProveedor(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.merge(proveedor);
		ut.commit();
		return proveedor;
	}

	
	public void borrarProveedor(Proveedor proveedor) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(proveedor));
		ut.commit();
	}

	
	public Proveedor buscarProveedor(Long id) throws Exception{
		// TODO Auto-generated method stub
		return em.find(Proveedor.class, id);
	}

	
	public List<Proveedor> findAll() throws Exception{
		// TODO Auto-generated method stub
		return em.createQuery("select u from Proveedor u",Proveedor.class).getResultList();
	}
}
