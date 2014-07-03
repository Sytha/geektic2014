package com.ninja_squad.geektic;

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
