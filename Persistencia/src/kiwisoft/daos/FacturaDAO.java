package kiwisoft.daos;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Factura;


public class FacturaDAO {
	
	EntityManager em;
	UserTransaction ut;
	
	public FacturaDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	public Factura guardarFactura(Factura factura)
			throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(factura);
		ut.commit();
		return factura;
	}

	public void borrarFactura(Factura factura) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(factura));
		ut.commit();
	}

	
	public Factura buscarFactura(Long id) {
		// TODO Auto-generated method stub
		return em.find(Factura.class, id);
	}

	
}