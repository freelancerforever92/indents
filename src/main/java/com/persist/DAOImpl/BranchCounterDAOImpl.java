package com.persist.DAOImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.models.Counters;
import com.persist.DAO.BranchCounterDAO;


@Repository("BranchCounterDAO")
public class BranchCounterDAOImpl implements BranchCounterDAO {
	
static final Logger LOGGER = Logger.getLogger(BranchCounterDAOImpl.class);
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public List<Counters> getCounters() {
		Session theSession = sessionFactory.getCurrentSession();
		Criteria criteria = theSession.createCriteria(Counters.class);
		List<Counters> counters = criteria.list();
		return counters;
	}

	@Transactional
	public String addCounterToSession(String counterLegacyNo) {
		// TODO Auto-generated method stub
		Session theSession = sessionFactory.getCurrentSession();
		int counterId = Integer.parseInt(counterLegacyNo);
		Counters counter = (Counters)theSession.load(Counters.class, counterId);
		Hibernate.initialize(counter);
		return counter.getCounterNumber();
	}
	
}
