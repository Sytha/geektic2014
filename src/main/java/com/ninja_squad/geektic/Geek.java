package com.ninja_squad.geektic;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="GEEKS")
public class Geek {
	@Id
	@SequenceGenerator(name="geeks_seq",sequenceName="geeks_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="geeks_seq")
	private Long id;
	
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String sexe;
	@Column
	private int age;
	@Column
	private String ville;
	@Column
	private String mail;
	@Column
	private String gravatar;
	@ManyToOne
	@JoinColumn(name = "interet")
    private Interet interet;
	@OneToMany(mappedBy = "geek")
	private Set<History> history ;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getGravatar() {
		return gravatar;
	}

	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	public Interet getInteret() {
		return interet;
	}

	public void setInteret(Interet interet) {
		this.interet = interet;
	}
}
