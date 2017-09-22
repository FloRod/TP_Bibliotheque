package fr.service;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.config.ConnectionEm;
import fr.models.Auteur;

public class AuteurService implements AuteurServiceInterface {
	

	public static EntityManager em = ConnectionEm.getInstance();


	public void add(Map<String, String> mapAdd) {
		em.getTransaction().begin();
		Auteur nouvelAuteur = new Auteur();
		nouvelAuteur.setNom(mapAdd.get("nom"));
		nouvelAuteur.setPrenom(mapAdd.get("prenom"));
		nouvelAuteur.setLangue(mapAdd.get("langue"));
		nouvelAuteur.setLivres(null);
		em.persist(nouvelAuteur);
		em.getTransaction().commit();
	}
	
	public Auteur find(int id){
		return em.find(Auteur.class, id);
	}

	public void update(Map<String, String> mapUpdate) {
		em.getTransaction().begin();
		int id = Integer.parseInt(mapUpdate.get("id"));
		Auteur nouvelAuteur = em.find(Auteur.class, id);
		nouvelAuteur.setNom(mapUpdate.get("nom"));
		nouvelAuteur.setPrenom(mapUpdate.get("prenom"));
		nouvelAuteur.setLangue(mapUpdate.get("langue"));
		nouvelAuteur.setLivres(null);
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
