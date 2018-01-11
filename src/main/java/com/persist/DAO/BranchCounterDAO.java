package com.persist.DAO;

import java.util.List;

import com.models.Counters;

public interface BranchCounterDAO {
	
	public List<Counters> getCounters();
	public String addCounterToSession(String counterLegacyNo);

}
