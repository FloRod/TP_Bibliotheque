package fr.config;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import fr.models.Auteur;
import fr.models.Livre;

public class ConfigInitial {
	
	public void initialise(){
		EntityManager em = ConnectionEm.getInstance();
		em.getTransaction().begin();
		for (int i=0; i<10; i++){
			Livre livre = new Livre("Titre " + i, Date.valueOf("2017-09-20"), "Description " + i, "Roman", null, i+2, i);
			em.persist(livre);
		}
		em.getTransaction().commit();
		em.getTransaction().begin();
		System.out.println("2ème boucle");
		for (int i=0; i<5; i++){
			System.out.println("boucle : " +i+ " débute");
			Set<Livre> tab = new HashSet<Livre>();
			Livre livre1 = em.find(Livre.class, i);
			tab.add(livre1);
			Livre livre2 = em.find(Livre.class, 9-i);
			tab.add(livre2);
			Auteur auteur = new Auteur("Marley " + i, "Bob " + i, "français", tab);
			em.persist(auteur);
//			livre1.setAuteur(auteur);
//			livre2.setAuteur(auteur);
			System.out.println("boucle : " +i + " fin");
		}
		
		em.getTransaction().commit();
		em.getTransaction().begin();
		for (int i=1; i<=5; i++){
			em.find(Livre.class, i).setAuteur(em.find(Auteur.class, i));
			em.find(Livre.class, 11-i).setAuteur(em.find(Auteur.class, i));
		}
		em.getTransaction().commit();
		
	}

}
