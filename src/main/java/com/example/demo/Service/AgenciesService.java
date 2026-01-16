package com.example.demo.Service;
import java.util.List;

import com.example.demo.Model.Agencies;

public interface AgenciesService {

	public void saveAgency(Agencies a1);

	public Agencies checkAgency(String u, String p);

	public Agencies Display();

	public Agencies fetchSingleRecord(String name);

	public Agencies findByUsername(String x);

	public List<Agencies> ADisplay();
	
	public Long countAgencies();

	public List<Agencies> getAllAgencies();

	

}
