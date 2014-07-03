package com.ninja_squad.geektic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ninja_squad.geektic.*;

public class InteretDao {
	private EntityManager em;
	public InteretDao(EntityManager em){
		this.em=em;
	}
	
	public List<Interet> findAll(){
		String jpql = "SELECT i"
				+ "FROM Interet i";
		TypedQuery<Interet> query = em.createQuery(jpql, Interet.class); 
		return query.getResultList();
	}
	
	public void persist(Geek history){
		em.persist(history);
	}
}
