package com.packt.springhighperformance.ch6.bankingapp.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.packt.springhighperformance.ch6.bankingapp.dao.AbstractJpaDAO;
import com.packt.springhighperformance.ch6.bankingapp.dao.IAccountDAO;
import com.packt.springhighperformance.ch6.bankingapp.model.Account;

@Repository
public class AccountDAO extends AbstractJpaDAO<Account> implements IAccountDAO {

	public AccountDAO() {
		super();
		setClazz(Account.class);
	}

	@Override
	public Account findbyAccountId(Long accountId) {
		Query query = getEntityManager().createQuery("SELECT a FROM Account a WHERE account_id=:accountId", Account.class);
		query.setParameter("accountId", accountId);
				
		return (Account)query.getSingleResult();
	}
	
	@Override
	public Account findAccountUsingJoinFetch(Long accountId){
		Query query = getEntityManager().createQuery("SELECT a FROM Account AS a JOIN FETCH a.transactions WHERE a.accountId=:accountId", Account.class);
		query.setParameter("accountId", accountId);
		return (Account)query.getSingleResult();
	}

	@Override
	public Account findAccountUsingNamedEntityGraph(Long accountId) {
		EntityGraph<?> entityGraph =  getEntityManager().createEntityGraph("graph.transactions");
		Query query = getEntityManager().createQuery("SELECT a FROM Account AS a WHERE a.accountId=:accountId", Account.class);
		query.setHint("javax.persistence.fetchgraph", entityGraph);
		query.setParameter("accountId", accountId);
		return (Account)query.getSingleResult();
	}

	@Override
	public Account findAccountUsingDynamicEntityGraph(Long accountId) {
		EntityGraph<?> entityGraph =  getEntityManager().createEntityGraph(Account.class);
		entityGraph.addSubgraph("transactions");
		
		Map<String, Object> hints = new HashMap<String, Object>();
		hints.put("javax.persistence.fetchgraph", entityGraph);
		return this.getEntityManager().find(Account.class, accountId, hints);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Account findAccountUsingCriteriaAPI(Long accountId) {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<?> query = criteriaBuilder.createQuery(Account.class);
		Root root = query.from(Account.class);
		root.fetch("transactions", JoinType.INNER);
		query.select(root);
		query.where(criteriaBuilder.equal(root.get("accountId"), accountId));

		return (Account)this.getEntityManager().createQuery(query).getSingleResult();
	}
}
