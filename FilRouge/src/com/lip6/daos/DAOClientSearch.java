package com.lip6.daos;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lip6.entities.Formation;
import com.lip6.entities.Objectif;
import com.lip6.entities.Session;
import com.lip6.entities.Theme;
import com.lip6.util.JpaUtil;
@Repository("daoSearch")
public class DAOClientSearch {
	
	public Set<Formation> resultSearch(String result) {
		
		Set<Formation> formSet = new HashSet<>();
		
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			String requete="SELECT fo FROM Formation fo, Session se , Theme th , Objectif obj WHERE fo.nomFormation='"+result+"' or se.nomSession='"+result+"' or th.nomTheme='"+result+"' or se.lieu='"+result+"' or obj.nomObjectif='"+result+"'";
			Query query = em.createQuery(requete);
			List<Formation>formList = query.getResultList();
			for(Formation form : formList) {
				for(Theme th :form.getTheme()) {
					if(th.getNomTheme().equals(result)) {
						formSet.add(form);
					}		
				}
				for(Objectif obj: form.getObjectifsFormation()) {
					if(obj.getNomObjectif().equals(result)) {
						formSet.add(form);
					}
				}
				for(Session se:form.getSessions()) {
					if(se.getNomSession().equals(result) || se.getLieu().equals(result)) {
						formSet.add(form);
					}
				}
				if(form.getNomFormation().equalsIgnoreCase(result)) {
					formSet.add(form);
				}
			}
			
			tx.commit();
			
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formSet;
	}
}
