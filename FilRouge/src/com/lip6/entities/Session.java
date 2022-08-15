package com.lip6.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;

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
	
	@ManyToOne
	@JoinColumn(name="id_salle")
	private Salle salle;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Evaluation>evaluations=new ArrayList<Evaluation>() ;
	
	@ManyToOne
	@JoinColumn(name="id_formateur")
	private Formateur formateur;
	
	@ManyToMany(cascade ={CascadeType.PERSIST,
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.REFRESH
},mappedBy = "sessions")
	private Set<Stagiaire> stagiaires = new HashSet<>();
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name ="Clients_par_Sessions", joinColumns=@JoinColumn(name = "id_Session"),inverseJoinColumns = @JoinColumn(name="id_Client"))
	private Set<Client> clients = new HashSet<>();
	
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

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Set<Client> getClient() {
		return clients;
	}

	public void setClient(Set<Client> client) {
		this.clients = client;
	}

	@Override
	public String toString() {

		return  idSession + "  |  "  + nomSession;

	}
	
	
	
}
