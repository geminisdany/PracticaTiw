package kiwisoft.daos;

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
}
