package com.lip6.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lip6.daos.DAOClientSearch;
import com.lip6.entities.Formation;
@Service("searchServ")
public class ClientSearchService {
	@Autowired
	@Qualifier("daoSearch")
	DAOClientSearch daoSearch;
	public Set<Formation> resultSearch(String result) {
		
		return daoSearch.resultSearch(result);
	}
}
