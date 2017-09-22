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
		// nouveauLivre.setDatePublication(Date.valueOf(mapAdd.get("datePublication")));
		// problème avec la date à corriger
		nouveauLivre.setCategorie(mapAdd.get("categorie"));
		if (mapAdd.get("nbrExemplaires") != null) {
			nouveauLivre.setNbrExemplaires(Integer.parseInt(mapAdd.get("nbrExemplaires")));
		}
		if (mapAdd.get("nbrExempDispo") != null) {
			nouveauLivre.setNbrExempDispo(Integer.parseInt(mapAdd.get("nbrExempDispo")));
		}
		nouveauLivre.setAuteur(null);
		em.persist(nouveauLivre);
		em.getTransaction().commit();
	}

	public Livre find(int id) {
		return em.find(Livre.class, id);
	}

	public void update(Map<String, String> mapUpdate) {
		em.getTransaction().begin();
		int id = Integer.parseInt(mapUpdate.get("id"));
		Livre nouveauLivre = em.find(Livre.class, id);
		if (mapUpdate.get("titre") != null) {
			nouveauLivre.setTitre(mapUpdate.get("titre"));
		}
		if (mapUpdate.get("description") != null) {
			nouveauLivre.setDescription(mapUpdate.get("description"));
		}
		if (mapUpdate.get("datePublication") != null) {
			nouveauLivre.setDatePublication(Date.valueOf(mapUpdate.get("datePublication")));
		}
		if (mapUpdate.get("categorie") != null) {
			nouveauLivre.setCategorie(mapUpdate.get("categorie"));
		}
		if (mapUpdate.get("nbrExemplaires") != null) {
			nouveauLivre.setNbrExemplaires(Integer.parseInt(mapUpdate.get("nbrExemplaires")));
		}
		if (mapUpdate.get("nbrExempDispo") != null) {
			nouveauLivre.setNbrExempDispo(Integer.parseInt(mapUpdate.get("nbrExempDispo")));
		}
		if (mapUpdate.get("auteur") != null) {
			nouveauLivre.setAuteur(null);			// à compléter
		}
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
