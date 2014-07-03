package com.ninja_squad.geektic.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.ninja_squad.geektic.*;

@Repository
public class HistoryDao {
	@PersistenceContext
	private EntityManager em;
	public HistoryDao(EntityManager em){
		this.em=em;
	}
	
	public List<History> findAllGeekHistoryById(Long id){
		String jpql = "SELECT h "
				+ "FROM History h "
				+ "JOIN h.geek g "
				+ "WHERE g.id = :id ";
		TypedQuery<History> query = em.createQuery(jpql, History.class); 
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public int findCountGeekHistoryById(Long id){
		List<History> list = findAllGeekHistoryById(id);
		return list.size();
	}
	
	public void persist(Geek history){
		em.persist(history);
	}
}
