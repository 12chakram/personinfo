/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.ImportantDays;
import com.persinfo.data.MostMemorableDays;
import com.persinfo.utilities.EMF;

/**
 * @author deva
 *
 */
public class MemorableDaysDAO {

	public void addMostMemorableDays(MostMemorableDays memDays){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(memDays);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}
	
	public void addImportantDays(ImportantDays impDays){
			
			EntityManager em = EMF.get().createEntityManager();
			em.getTransaction().begin();
			em.persist(impDays);
			em.getTransaction().commit();
			EMF.get().createEntityManager().close();
		}
	public MostMemorableDays retrieveMostMemorableDaysByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select memDays from MostMemorableDays memDays where memDays.uid='"+uid+"'");
		List<MostMemorableDays> memDays= q.getResultList();
		em.getTransaction().commit();
		if(memDays.isEmpty())
			return null;
		else
			return memDays.get(0);
	}
	

	public ImportantDays retrieveImportantDaysByUserIdAndSequence(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select impDays from ImportantDays impDays where impDays.uid='"+uid+"'");
		List<ImportantDays> impDays= q.getResultList();
		em.getTransaction().commit();
		if(impDays.isEmpty())
			return null;
		else
			return impDays.get(0);
	}
}
