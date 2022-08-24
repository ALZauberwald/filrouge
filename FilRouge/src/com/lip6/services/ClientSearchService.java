package com.lip6.services;

import java.util.Set;

import com.lip6.daos.DAOClientSearch;
import com.lip6.entities.Formation;

public class ClientSearchService {
	public Set<Formation> resultSearch(String result) {
		DAOClientSearch daos = new DAOClientSearch();
		return daos.resultSearch(result);
	}
}
