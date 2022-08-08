package com.lip6.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.lip6.util.JpaUtil;

//Cette classe g�n�rique a pour but la r�utilisation de ses m�thodes C R U D peu-importe le type souhait�
public  class Crud <T>{
//	private String name;
//	private String detail;
	 private Class<T> type;
	
	 public Crud(Class<T> type) {
	        this.type = type;
	    }
	 
	public boolean createObject(T t) {
//		this.name= name;
//		this.detail = detail;
		
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			//utiliser spring pour l'injection de dependance ?
						
			em.persist(t);
			tx.commit();
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
public boolean searchObject(T t, long id) {	
		boolean success=false;
		try {
			EntityManager em=JpaUtil.getEmf().createEntityManager();	
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();	
			T object= (T) em.find(type, id);
			
			System.out.println("voici l'object de type : "+object.getClass()+" retourn� : "+object);
			
			em.close();
			
			success=true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return success;
	}
public boolean UpdateObject(long id , T t) {
	
	boolean success=false;
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		T object= em.find(type, id);
		object = t;
		em.persist(object);
		
		tx. commit();
		em.close();
		
		
		success=true;
	} catch (Exception e) {
		e.printStackTrace();
	}

	return success;
}
public boolean removeObject(long id) {
	
	boolean success=false;
	try {
		EntityManager em=JpaUtil.getEmf().createEntityManager();	
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();	
		T object= em.find(type, id);
		em.remove(object);
		tx. commit();
		em.close();
		
		System.out.println("L'object "+object+ " de type : "+object.getClass()+" a bien �t� supprim�.");
		
		success=true;
	} catch (Exception e) {
		e.printStackTrace();
	}

	return success;
}


}
