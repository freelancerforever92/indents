package com.service.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.models.Counters;
import com.persist.DAO.BranchCounterDAO;
import com.service.DAO.BranchCounterService;

@Service("BranchCounterService")
public class BranchCounterServiceImpl implements BranchCounterService {

	@Autowired
	BranchCounterDAO branchCounterDAO;
	
	
	@Transactional
	public List<Counters> getCounters() {
		return branchCounterDAO.getCounters();
	}

	@Transactional
	public String addCounterToSession(String counterLegacyNo) {
		return branchCounterDAO.addCounterToSession(counterLegacyNo);
	}
	
}
