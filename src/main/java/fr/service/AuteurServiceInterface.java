package fr.service;

import java.util.List;
import java.util.Map;

import fr.models.Auteur;

public interface AuteurServiceInterface {
	
	public void add(Map<String, String> mapAdd);
	public void update (Map<String, String> mapUpdate);
	public List<Auteur> lister();
	public Auteur find(int id);
	public Auteur detail(Auteur auteur);

}
