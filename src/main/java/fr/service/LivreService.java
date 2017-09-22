package fr.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.config.ConnectionEm;
import fr.models.Livre;

public class LivreService implements LivreServiceInterface {
	

	public static EntityManager em = ConnectionEm.getInstance();


	public void add(Map<String, String> mapAdd) {
		em.getTransaction().begin();
		Livre nouveauLivre = new Livre();
		nouveauLivre.setTitre(mapAdd.get("titre"));
		nouveauLivre.setDescription(mapAdd.get("description"));
		nouveauLivre.setDatePublication(Date.valueOf(mapAdd.get("datePublication")));
		nouveauLivre.setCategorie(mapAdd.get("categorie"));
		nouveauLivre.setNbrExemplaires(Integer.parseInt(mapAdd.get("nbrExemplaires")));
		nouveauLivre.setNbrExempDispo(Integer.parseInt(mapAdd.get("nbrExempDispo")));
		nouveauLivre.setAuteur(null);
		em.persist(nouveauLivre);
		em.getTransaction().commit();
	}
	
	public Livre find(int id){
		return em.find(Livre.class, id);
	}

	public void update(Map<String, String> mapUpdate) {
		em.getTransaction().begin();
		int id = Integer.parseInt(mapUpdate.get("id"));
		Livre nouveauLivre = em.find(Livre.class, id);
		nouveauLivre.setTitre(mapUpdate.get("titre"));
		nouveauLivre.setDescription(mapUpdate.get("description"));
		nouveauLivre.setDatePublication(Date.valueOf(mapUpdate.get("datePublication")));
		nouveauLivre.setCategorie(mapUpdate.get("categorie"));
		nouveauLivre.setNbrExemplaires(Integer.parseInt(mapUpdate.get("nbrExemplaires")));
		nouveauLivre.setNbrExempDispo(Integer.parseInt(mapUpdate.get("nbrExempDispo")));
		nouveauLivre.setAuteur(null);
		em.getTransaction().commit();
	}

	public List<Livre> lister() {
		TypedQuery<Livre> query = em.createQuery("FROM Livre", Livre.class);
		return (List<Livre>) query.getResultList();
	}

	public Livre detail(Livre livre) {
		// TODO Auto-generated method stub
		return null;
	}

}
