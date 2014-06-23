/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.User;
import com.persinfo.utilities.EMF;

/**
 * @author deva
 *
 */
public class UserDAO {

	public void addUser(User user){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateUserInfo(User u){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, u.getKey());
		u.setKey(user.getKey());
		em.persist(u);
		em.getTransaction().commit();
		em.close();
	}

	public User retrieveUserByUserNameAndPassword(String uname, String password){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select u from User u where u.uname='"+uname+"' and u.password='"+password+"' and u.active=True");
		List<User> user= q.getResultList();
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}
	
	public User retrieveUserByUserName(String uname){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select u from User u where u.uname='"+uname+"'");
		List<User> user= q.getResultList();
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}
	
	public User retrieveUserByEmail(String email){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select u from User u where u.email='"+email+"'");
		List<User> user= q.getResultList();
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}
	
	public List<User> retrieveAllActiveUsers(){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select u from User u where u.active=True");
		List<User> users= q.getResultList();
		em.getTransaction().commit();
		if(users.isEmpty())
			return null;
		else
			return users;
	}
	
	public void updateUser(User u){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, u.getKey());
		user.setActive(true);
		em.getTransaction().commit();
		em.close();
	}
	
	public User retrievePasswordByUsernameOrEmail(String input){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select u from User u where u.email='"+input+"'");
		List<User> user= q.getResultList();
		if(user.isEmpty()){
			q = em.createQuery("select u from User u where u.uname='"+input+"'");
			user= q.getResultList();
		}
		em.getTransaction().commit();
		if(user.isEmpty())
			return null;
		else
			return user.get(0);
	}

}
