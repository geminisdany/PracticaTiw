package kiwisoft.daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.UserTransaction;

import kiwisoft.dominios.Administrador;

public class AdministradorDAO {
	
	private final EntityManager em;
	private final UserTransaction ut;

	public AdministradorDAO(EntityManager em, UserTransaction ut) {
		super();
		this.em = em;
		this.ut = ut;
	}
	
	
	public Administrador guardarAdmin(Administrador administrador) throws Exception{
		ut.begin();		//se inicia UserTransaction para el servidor 
		em.persist(administrador); //persist guarda en la base de datos  (serviria en local)
		ut.commit();	//guardar en el servidor
		return administrador; //retorno el objeto con un estado persistent
	}
	
	/*Se busca un Administrador por email y contraseña (para el LOGIN)*/
	 public Administrador buscarPorEmailYpassword(String email, String password)throws NoResultException{
       return em.createQuery("select a from Administrador a where a.email='"+email+"' and a.password='"+password+"'",Administrador.class).getSingleResult();
	 }
	 

}
