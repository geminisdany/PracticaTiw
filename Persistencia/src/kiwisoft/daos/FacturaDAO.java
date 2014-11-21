package kiwisoft.daos;
import java.util.Collection;
import java.util.Date;

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
	
	public Collection<Factura> ordenarByFecha(Long id) {
		// TODO Auto-generated method stub
		return em.createQuery("select f from Factura f where f.cliente.id='"+id+"'ORDER BY f.fecha",Factura.class).getResultList();
	}
	
	public Collection<Factura> buscarByFecha(Date fecha, Long idCliente) {
		// TODO Auto-generated method stub
		return em.createQuery("select f from Factura f where f.cliente.id='"+idCliente+"' and f.fecha='"+fecha+"'",Factura.class).getResultList();
	}
	
	public Factura buscarFactura(Long id) {
		// TODO Auto-generated method stub
		return em.find(Factura.class, id);
	}

	
}