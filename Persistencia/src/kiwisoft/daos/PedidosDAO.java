package kiwisoft.daos;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Pedido;


public class PedidosDAO {

	private final EntityManager em;
	private final UserTransaction ut;
	
	public PedidosDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}


	public Pedido guardarPedidos(Pedido pedidos)
			throws NotSupportedException, SystemException, SecurityException,
			IllegalStateException, RollbackException, HeuristicMixedException,
			HeuristicRollbackException {
		// TODO Auto-generated method stub
		ut.begin();
		em.persist(pedidos);
		ut.commit();
		return pedidos;
	}

	public void borrarPedidos(Pedido pedidos) throws Exception {
		// TODO Auto-generated method stub
		ut.begin();
		em.remove(em.merge(pedidos));
		ut.commit();
	}

	
	public Pedido buscarPedidos(Long id) {
		// TODO Auto-generated method stub
		return em.find(Pedido.class, id);
	}

	public List<Pedido> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("select from Pedidos").getResultList();
	}

	public Collection<Pedido> ordenarByFechaProveedor(Long idProveedor) {
		return em.createQuery("select u from Pedido u join u.producto p where p.proveedor.id='"+idProveedor+"'ORDER BY u.factura.fecha",Pedido.class).getResultList();
	}
	
}
