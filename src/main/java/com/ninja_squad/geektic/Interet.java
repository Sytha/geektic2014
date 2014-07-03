package com.ninja_squad.geektic;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="INTERETS")
public class Interet {
	@Id
	@SequenceGenerator(name="interets_seq",sequenceName="interets_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="interets_seq")
	private Long id;
	
	@Column
	private String libelle;

	@ManyToMany
	@JoinTable(name = "GEEKS_INTERETS",
	           joinColumns = @JoinColumn(name = "interet_id"),
	           inverseJoinColumns = @JoinColumn(name = "geek_id"))
	private Set<Geek> geeks ;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
}
