package fr.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;

@Entity
public class Livre {
	
	@Expose
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Expose
	@Column(length = 50)
	private String titre;
	
	@Expose
	private Date datePublication;
	
	@Expose
	@Column(length = 150)
	private String description;
	
	@Expose
	@Column(length = 50)
	private String categorie;
	
	@ManyToOne
	private Auteur auteur;
	
	/**
	 * 
	 */
	public Livre() {
	}

	/**
	 * @param titre
	 * @param datePublication
	 * @param description
	 * @param categorie
	 * @param auteur
	 * @param nbrExemplaires
	 * @param nbrExempDispo
	 */
	public Livre(String titre, Date datePublication, String description, String categorie, Auteur auteur,
			Integer nbrExemplaires, Integer nbrExempDispo) {
		this.titre = titre;
		this.datePublication = datePublication;
		this.description = description;
		this.categorie = categorie;
		this.auteur = auteur;
		this.nbrExemplaires = nbrExemplaires;
		this.nbrExempDispo = nbrExempDispo;
	}

	private Integer nbrExemplaires;
	
	private Integer nbrExempDispo;

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the datePublication
	 */
	public Date getDatePublication() {
		return datePublication;
	}

	/**
	 * @param datePublication the datePublication to set
	 */
	public void setDatePublication(Date datePublication) {
		this.datePublication = datePublication;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the auteur
	 */
	public Auteur getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the nbrExemplaires
	 */
	public Integer getNbrExemplaires() {
		return nbrExemplaires;
	}

	/**
	 * @param nbrExemplaires the nbrExemplaires to set
	 */
	public void setNbrExemplaires(Integer nbrExemplaires) {
		this.nbrExemplaires = nbrExemplaires;
	}

	/**
	 * @return the nbrExempDispo
	 */
	public Integer getNbrExempDispo() {
		return nbrExempDispo;
	}

	/**
	 * @param nbrExempDispo the nbrExempDispo to set
	 */
	public void setNbrExempDispo(Integer nbrExempDispo) {
		this.nbrExempDispo = nbrExempDispo;
	}
	

}
