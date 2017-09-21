package fr.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionEm {
	
	private static EntityManager em;
	

	private ConnectionEm() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation_jee");
		em = entityManagerFactory.createEntityManager();
	}
	
	public static EntityManager getInstance(){
		if (em == null){
			new ConnectionEm();
		}
		return em;
	}
	
// ToDO	
//	public static void getFinalize(){
//		if (){
//			em.close();
//		}
//	}
}
