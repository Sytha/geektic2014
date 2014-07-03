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
	private String interet;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInteret() {
		return interet;
	}

	public void setInteret(String interet) {
		this.interet = interet;
	}
}
