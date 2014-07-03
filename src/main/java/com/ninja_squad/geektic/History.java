package com.ninja_squad.geektic;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="HISTORY")
public class History {
	@Id
	@SequenceGenerator(name="history_seq",sequenceName="history_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="history_seq")
	private Long id;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "geek")
	private Geek geek;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Geek getGeek() {
		return geek;
	}

	public void setGeek(Geek geek) {
		this.geek = geek;
	}
	
	
}
