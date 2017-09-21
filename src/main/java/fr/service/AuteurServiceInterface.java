package fr.service;

import java.util.List;

import fr.models.Auteur;

public interface AuteurServiceInterface {
	
	public void save(Auteur auteur);
	public void update (Auteur auteur);
	public List<Auteur> lister();
	public Auteur find(int id);
	public Auteur detail(Auteur auteur);

}
