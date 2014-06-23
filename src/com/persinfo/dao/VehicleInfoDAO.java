/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.DrivingLicense;
import com.persinfo.data.Vehicle;
import com.persinfo.utilities.EMF;
import com.persinfo.utilities.PteCloudUtilities;

/**
 * @author deva
 *
 */
public class VehicleInfoDAO {
	
	
	public void addDrivingLicense(DrivingLicense dlicense){
		
		EntityManager em = EMF.get().createEntityManager();
		if(dlicense.getDlDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks( dlicense.getDlDoc(), dlicense.getDlDocContentType(), "dldoc", dlicense.getUid());
		dlicense.setDlDoc(null);
		em.getTransaction().begin();
		em.persist(dlicense);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateDrivingLicense(DrivingLicense dlicense){
		
		EntityManager em = EMF.get().createEntityManager();
		DrivingLicense d = retrieveDrivingLicneseByUserId(dlicense.getUid());
		dlicense.setKey(d.getKey());
		if(dlicense.getDlDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks( dlicense.getDlDoc(), dlicense.getDlDocContentType(), "dldoc", dlicense.getUid());
		else if(d.getDlDocFileName() != null)
			dlicense.setDlDocFileName(d.getDlDocFileName());
		dlicense.setDlDoc(null);
		em.getTransaction().begin();		
		em.persist(dlicense);
		em.getTransaction().commit();
		em.close();
	}
	
	public void addVehicle(Vehicle vehicle){
			
			EntityManager em = EMF.get().createEntityManager();
			if(vehicle.getRcDoc() != null)
				PteCloudUtilities.splitAndPersistLongTextAsChunks( vehicle.getRcDoc(), vehicle.getRcDocContentType(), vehicle.getDocType()+"rcdoc", vehicle.getUid());
			vehicle.setRcDoc(null);
			em.getTransaction().begin();
			em.persist(vehicle);
			em.getTransaction().commit();
			em.close();
	}
	
	public Vehicle updateVehicle(Vehicle vehicle){
		
		EntityManager em = EMF.get().createEntityManager();
		Vehicle v = retrieveVehicleByUserIdAndSequence(vehicle.getUid(), vehicle.getDocType());
		vehicle.setKey(v.getKey());		
		if(vehicle.getRcDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks( vehicle.getRcDoc(), vehicle.getRcDocContentType(), vehicle.getDocType()+"rcdoc", vehicle.getUid());
		else if(v.getRcDocFileName() != null)
			vehicle.setRcDocFileName(v.getRcDocFileName());
		vehicle.setRcDoc(null);
		em.getTransaction().begin();
		em.persist(vehicle);
		em.getTransaction().commit();
		em.close();
		return vehicle;
	}
	
	public DrivingLicense retrieveDrivingLicneseByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select dlicense from DrivingLicense dlicense where dlicense.uid='"+uid+"'");
		List<DrivingLicense> dlicense= q.getResultList();
		em.getTransaction().commit();
		if(dlicense.isEmpty())
			return null;
		else
			return dlicense.get(0);
	}
	

	public Vehicle retrieveVehicleByUserIdAndSequence(String uid, String type){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select vehicle from Vehicle vehicle where vehicle.uid='"+uid+"' and vehicle.docType='" + type +"'");
		List<Vehicle> vehicle= q.getResultList();
		em.getTransaction().commit();
		if(vehicle.isEmpty())
			return null;
		else
			return vehicle.get(0);
	}

	public List<Vehicle> retrieveAllVehiclesByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select vehicle from Vehicle vehicle where vehicle.uid='"+uid+"' order by vehicle.docType");
		List<Vehicle> vehicles= q.getResultList();
		em.getTransaction().commit();
		if(vehicles.isEmpty())
			return null;
		else
			return vehicles;
	}

}
