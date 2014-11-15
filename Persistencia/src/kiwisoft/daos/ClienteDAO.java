package kiwisoft.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Cliente;

public class ClienteDAO {
	private final EntityManager em;
	private final UserTransaction ut;

	public ClienteDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}

	public Cliente guardarCliente(Cliente nuevoCliente) throws Exception{
		ut.begin();		//se inicia UserTransaction para el servidor 
		em.persist(nuevoCliente); //persist guarda en la base de datos  (serviria en local)
		ut.commit();	//guardar en el servidor
		return nuevoCliente; //retorno el objeto con un estado persistent
	}
	
	/*Se busca un cliente por email y contraseña (para el LOGIN)*/
	 public Cliente buscarPorEmailYpassword(String email, String password)throws NoResultException{
        return em.createQuery("select u from Cliente u where u.email='"+email+"' and u.password='"+password+"'",Cliente.class).getSingleResult();
	 }
	 
	 /*Se busca un cliente por id*/
	 public Cliente buscarProducto(Long pk){
			return em.createQuery("select u from Cliente u where u.id='"+pk+"'",Cliente.class).getSingleResult();
		}
}
