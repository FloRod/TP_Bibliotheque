package fr.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Auteur {

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Expose
	@Column(length = 40)
	private String nom;

	@Expose
	@Column(length = 40)
	private String prenom;

	@Expose
	@Column(length = 40)
	private String langue;

	@OneToMany(mappedBy = "auteur")
	private Set<Livre> livres = new HashSet<Livre>();

	/**
	 * 
	 */
	public Auteur() {
	}

	/**
	 * @param nom
	 * @param prenom
	 * @param langue
	 * @param livres
	 */
	public Auteur(String nom, String prenom, String langue, Set<Livre> livres) {
		this.nom = nom;
		this.prenom = prenom;
		this.langue = langue;
		this.livres = livres;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the langue
	 */
	public String getLangue() {
		return langue;
	}

	/**
	 * @param langue the langue to set
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
}
