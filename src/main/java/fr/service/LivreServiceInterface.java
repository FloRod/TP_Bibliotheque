package fr.service;

import java.util.List;
import java.util.Map;

import fr.models.Auteur;
import fr.models.Livre;

public interface LivreServiceInterface {
	
	public void add(Map<String, String> mapAdd);
	public void update (Map<String, String> mapUpdate);
	public List<Livre> lister();
	public Livre find(int id);
	public Livre detail(Livre livre);

}
