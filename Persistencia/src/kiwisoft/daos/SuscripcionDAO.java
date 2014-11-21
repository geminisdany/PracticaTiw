package kiwisoft.daos;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Suscripcion;

public class SuscripcionDAO {
	EntityManager em;
	UserTransaction ut;
	
	
	public SuscripcionDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	public Suscripcion guardarSuscripcion(Suscripcion suscripcion)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(suscripcion);
		ut.commit();
		return suscripcion;
	}
	
	public void borrarSuscripcion(Suscripcion suscripcion) throws Exception{
		  ut.begin();
	      em.remove(em.merge(suscripcion));
	      ut.commit();
	}
	
	public Suscripcion buscarSuscripcionClienteProducto(Long idcliente,Long idproducto)throws Exception{
		return em.createQuery("select u from Suscripcion u where u.cliente.id='"+idcliente+"' and u.producto.id='"+idproducto+"'", Suscripcion.class).getSingleResult();
	}

	
	
}
