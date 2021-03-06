package com.ninja_squad.geektic.dao;


import java.util.List;

import javax.persistence.*;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import com.ninja_squad.geektic.*;

@Repository
public class GeekDao {
	@PersistenceContext
	private EntityManager em;

	
	public List<Geek> findAll(){
		String jpql = "SELECT distinct g "
				+ "FROM Geek g "
				+ "LEFT JOIN FETCH g.interets i";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class); 
		return query.getResultList();
	}
	
	public Geek findById(Long id){
		Geek g = em.find(Geek.class, id);
		Hibernate.initialize(g.getInterets());
		return g;
	}
	
	public List<Geek> findBySexeInteret(String sexe, String interet){
		String jpql = "SELECT distinct g "
				+ "FROM Geek g "
				+ "LEFT JOIN FETCH g.interets i "
				+ "JOIN g.interets i "
				+ "WHERE g.sexe = :sexe "
				+ "AND i.libelle = :interet ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class); 
		query.setParameter("sexe", sexe);
		query.setParameter("interet", interet);
		return query.getResultList();
	}
	
	public List<Geek> findByInteret(String interet){
		String jpql = "SELECT distinct g "
				+ "FROM Geek g "
				+ "LEFT JOIN FETCH g.interets i "
				+ "JOIN g.interets i "
				+ "WHERE i.libelle = :interet ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class); 
		query.setParameter("interet", interet);
		return query.getResultList();
	}
	
	public void persist(Geek geek){
		em.persist(geek);
	}
}
