package com.lip6.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.beans.*;
@Entity
public class Session {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSession;
	
	private String nomSession;
	private float prix=1000;
	private String dateDebut;
	private String dateFin;
	private String lieu;
	@Column(columnDefinition = "BOOLEAN")
	private boolean formateurConfirme;
	private TypeSession typeSession;
	@Column(columnDefinition = "BOOLEAN")
	private boolean installationFinie=false;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_salle")
	private Salle salle;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation>evaluations=new ArrayList<Evaluation>() ;
	
	//@ManyToOne(c
	//private Formateur formateur;
	
	//@ManyToMany
	//private List<Stagiaire> stagiaire = new ArrayList<Stagiaire>();
	
	//@ManyToMany
	//private List<Client> client = new ArrayList <Client>();
	
	@ManyToOne
	@JoinColumn(name="id_formation")
	private Formation formation;

	public Session(String nomSession, float prix, String dateDebut,String dateFin, String lieu, TypeSession typeSession) {
		this.nomSession=nomSession;
		this.prix = prix;
		this.dateDebut = dateDebut;
		this.dateFin=dateFin;
		this.lieu = lieu;
		this.formateurConfirme = false;
		this.typeSession = typeSession;
		this.installationFinie=false;
	}

	public Session() {
		super();
	}

	public long getIdSession() {
		return idSession;
	}

	public void setIdSession(long idSession) {
		this.idSession = idSession;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public boolean isFormateurConfirme() {
		return formateurConfirme;
	}

	public void setFormateurConfirme(boolean formateurConfirme) {
		this.formateurConfirme = formateurConfirme;
	}

	public TypeSession getTypeSession() {
		return typeSession;
	}

	public void setTypeSession(TypeSession typeSession) {
		this.typeSession = typeSession;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public List<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public String getNomSession() {
		return nomSession;
	}

	public void setNomSession(String nomSession) {
		this.nomSession = nomSession;
	}
	

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public boolean isInstallationFinie() {
		return installationFinie;
	}

	public void setInstallationFinie(boolean installationFinie) {
		this.installationFinie = installationFinie;
	}

	@Override
	public String toString() {
		return "Session [idSession=" + idSession + ", nomSession=" + nomSession + ", prix=" + prix + ", dateDebut="
				+ dateDebut + ", dateFin=" + dateFin + ", lieu=" + lieu + ", formateurConfirme=" + formateurConfirme
				+ ", typeSession=" + typeSession + ", installationFinie=" + installationFinie + ", salle=" + salle
				+ ", evaluations=" + evaluations + ", formation=" + formation + "]";
	}

	

	
	
	
	
	
	
}
