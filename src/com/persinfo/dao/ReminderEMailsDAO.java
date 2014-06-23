/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.InsuranceDoc;
import com.persinfo.data.Vehicle;
import com.persinfo.utilities.EMF;

/**
 * @author deva
 *
 */
public class ReminderEMailsDAO {
	
	public List<InsuranceDoc> retrievePoliciesForReminder(String date){
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select doc from InsuranceDoc doc where doc.dateOfRnwl='"+date+"'");
		List<InsuranceDoc> obj= q.getResultList();
		em.getTransaction().commit();
		if(obj.isEmpty())
			return null;
		else
			return obj;
	}
	
	public List<Vehicle> retrieveVehiclePoliciesForReminder(String date){
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select v from Vehicle v where v.renwlDate='"+date+"'");
		List<Vehicle> obj= q.getResultList();
		em.getTransaction().commit();
		if(obj.isEmpty())
			return null;
		else
			return obj;
	}

}
