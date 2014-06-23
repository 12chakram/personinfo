/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.BasicInfo;
import com.persinfo.data.EducationDetails;
import com.persinfo.data.Message;
import com.persinfo.utilities.EMF;

/**
 * @author deva
 *
 */
public class MessageDAO {
	
	public void addMessage(Message msg){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(msg);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}
	
	public List<Message> retrieveMessagesByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select msg from Message msg where msg.uid='"+uid+"' order by msg.msgDate");
		List<Message> msgs= q.getResultList();
		em.getTransaction().commit();
		if(msgs.isEmpty())
			return null;
		else
			return msgs;
	}

}
