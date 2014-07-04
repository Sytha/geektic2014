package com.ninja_squad.geektic.dao;

import java.util.Date;
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

	
	public List<History> findAllGeekHistoryById(Long id){
		String jpql = "SELECT h "
				+ "FROM History h "
				+ "JOIN h.geek g "
				+ "WHERE g.id = :id ";
		TypedQuery<History> query = em.createQuery(jpql, History.class); 
		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public void addHistoryById(Geek geek,String ip){
		History history = new History();
		Date date = new Date();
		history.setDate(date);
		history.setGeek(geek);
		history.setIp(ip);
		this.persist(history);
	}
	
	public int findCountGeekHistoryById(Long id){
		List<History> list = findAllGeekHistoryById(id);
		return list.size();
	}
	
	public void persist(History history){
		em.persist(history);
	}
}
