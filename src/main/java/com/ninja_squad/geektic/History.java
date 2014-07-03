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
	
	@OneToOne @MapsId
	private Geek geek;
}
