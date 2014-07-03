package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import com.ninja_squad.geektic.*;

@Repository
public class InteretDao {
	@PersistenceContext
	private EntityManager em;

	
	public List<Interet> findAll(){
		String jpql = "SELECT i "
				+ "FROM Interet i";
		TypedQuery<Interet> query = em.createQuery(jpql, Interet.class); 
		return query.getResultList();
	}
	
	public void persist(Interet interet){
		em.persist(interet);
	}
}
