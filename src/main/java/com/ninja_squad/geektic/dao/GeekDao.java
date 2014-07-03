package com.ninja_squad.geektic.dao;


import java.util.List;

import javax.persistence.*;

import com.ninja_squad.geektic.*;


public class GeekDao {
	private EntityManager em;
	public GeekDao(EntityManager em){
		this.em=em;
	}
	
	public List<Geek> findAll(){
		String jpql = "SELECT g"
				+ "FROM Geek g";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class); 
		return query.getResultList();
	}
	
	public Geek findById(Long id){
		return em.find(Geek.class, id);
	}
	
	public List<Geek> findByCriteria(String sexe, String interet){
		String jpql = "SELECT g "
				+ "FROM Geek g "
				+ "JOIN g.interet i "
				+ "WHERE g.sexe = :sexe "
				+ "AND i.libelle = :interet ";
		TypedQuery<Geek> query = em.createQuery(jpql, Geek.class); 
		query.setParameter("sexe", sexe);
		query.setParameter("interet", interet);
		return query.getResultList();
	}
	
	public void persist(Geek geek){
		em.persist(geek);
	}
}
