package fr.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.config.ConnectionEm;
import fr.models.Auteur;

public class AuteurService implements AuteurServiceInterface {
	

	public static EntityManager em = ConnectionEm.getInstance();


	public void save(Auteur nouvelauteur) {
		em.getTransaction().begin();
		em.persist(nouvelauteur);
		em.getTransaction().commit();
	}
	
	public Auteur find(int id){
		return em.find(Auteur.class, id);
	}

	public void update(Auteur auteur) {
		em.getTransaction().begin();
		Auteur nouvelAuteur = em.find(Auteur.class, auteur.getId());
		nouvelAuteur.setNom(auteur.getNom());
		nouvelAuteur.setPrenom(auteur.getPrenom());
		nouvelAuteur.setLivres(auteur.getLivres());
		nouvelAuteur.setLangue(auteur.getLangue());
		em.getTransaction().commit();
	}

	public List<Auteur> lister() {
		TypedQuery<Auteur> query = em.createQuery("FROM Auteur", Auteur.class);
		return (List<Auteur>) query.getResultList();
	}

	public Auteur detail(Auteur auteur) {
		// TODO Auto-generated method stub
		return null;
	}

}
