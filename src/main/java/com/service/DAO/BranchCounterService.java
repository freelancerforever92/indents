package com.service.DAO;

import java.util.List;


import com.models.Counters;

public interface BranchCounterService {

	public List<Counters> getCounters();
	
	public String addCounterToSession(String counterLegacyNo);
	
}
