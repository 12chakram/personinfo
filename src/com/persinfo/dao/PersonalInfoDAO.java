/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.BasicInfo;
import com.persinfo.data.BirthDetails;
import com.persinfo.data.EducationDetails;
import com.persinfo.data.ProfessionalInfo;
import com.persinfo.utilities.EMF;
import com.persinfo.utilities.PteCloudUtilities;

/**
 * @author deva
 *
 */
public class PersonalInfoDAO {
	
	public void addBasicInfo(BasicInfo basic){
		
		EntityManager em = EMF.get().createEntityManager();
		if(basic.getPhotoCopy() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(basic.getPhotoCopy(), basic.getPhotoCopyContentType(), "photoCopy", basic.getUid());
		basic.setPhotoCopy(null);
		em.getTransaction().begin();
		em.persist(basic);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateBasicInfo(BasicInfo basic){
		
		EntityManager em = EMF.get().createEntityManager();
		BasicInfo b = em.find(BasicInfo.class, retrieveBasicInfoByUserId(basic.getUid()).getKey());
		b.setAddress(basic.getAddress());
		b.setPhno(basic.getPhno());
		b.setEmail(basic.getEmail());
		b.setFullName(basic.getFullName());
		if(basic.getPhotoCopy() != null){
			PteCloudUtilities.splitAndPersistLongTextAsChunks(basic.getPhotoCopy(), basic.getPhotoCopyContentType(), "photoCopy", basic.getUid());
			b.setPhotoCopyFileName(basic.getPhotoCopyFileName());
			b.setPhotoCopyContentType(basic.getPhotoCopyContentType());
			basic.setPhotoCopy(null);
		}else if(b.getPhotoCopyFileName() != null)
			basic.setPhotoCopyFileName(b.getPhotoCopyFileName());
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void addBirthDetails(BirthDetails birth){
			
			EntityManager em = EMF.get().createEntityManager();
			if(birth.getBirthCert() != null)
				PteCloudUtilities.splitAndPersistLongTextAsChunks(birth.getBirthCert(), birth.getBirthCertContentType(), "birthCert", birth.getUid());
			birth.setBirthCert(null);
			em.getTransaction().begin();
			em.persist(birth);
			em.getTransaction().commit();
			EMF.get().createEntityManager().close();
	}
	
	public void updateBirthDetails(BirthDetails birth){
		
		EntityManager em = EMF.get().createEntityManager();		
		BirthDetails b = em.find(BirthDetails.class, retrieveBirthDetailsByUserId(birth.getUid()).getKey());
		if(birth.getPlaceOfBirth() != null)b.setPlaceOfBirth(birth.getPlaceOfBirth());
		if(birth.getDob() != null) b.setDob(birth.getDob());
		if(birth.getHospital() != null)b.setHospital(birth.getHospital());
		if(birth.getBirthCert() != null){
			PteCloudUtilities.splitAndPersistLongTextAsChunks(birth.getBirthCert(), birth.getBirthCertContentType(), "birthCert", birth.getUid());
			b.setBirthCertFileName(birth.getBirthCertFileName());
			b.setBirthCertContentType(birth.getBirthCertContentType());
			birth.setBirthCert(null);
		}else if(b.getBirthCertFileName() != null)
			birth.setBirthCertFileName(b.getBirthCertFileName());
		
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
	}
	
	public void addEduDetails(EducationDetails education){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		if(education.getSecCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getSecCert(), education.getSecCertContentType(), "secCert", education.getUid());
		education.setSecCert(null);
		if(education.getColCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getColCert(), education.getColCertContentType(), "colCert", education.getUid());
		education.setColCert(null);
		if(education.getDegCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getDegCert(), education.getDegCertContentType(), "degCert", education.getUid());
		education.setDegCert(null);
		em.persist(education);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}
	
	public void updateEduDetails(EducationDetails education){
		
		EntityManager em = EMF.get().createEntityManager();
		EducationDetails e = retrieveEducationDetailsByUserId(education.getUid());
		education.setKey(e.getKey());
		if(education.getSecCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getSecCert(), education.getSecCertContentType(), "secCert", education.getUid());
		else if(e.getSecCertFileName() != null)
			education.setSecCertFileName(e.getSecCertFileName());
		education.setSecCert(null);
		if(education.getColCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getColCert(), education.getColCertContentType(), "colCert", education.getUid());
		else if(e.getColCertFileName() != null)
			education.setColCertFileName(e.getSecCertFileName());
		education.setColCert(null);
		if(education.getDegCert() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(education.getDegCert(), education.getDegCertContentType(), "degCert", education.getUid());
		else if(e.getDegCertFileName() != null)
			education.setDegCertFileName(e.getDegCertFileName());
		education.setDegCert(null);
		em.getTransaction().begin();
		em.persist(education);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}
	
	public void addProfessionalInfo(ProfessionalInfo prof){
		
		EntityManager em = EMF.get().createEntityManager();
		if(prof.getFrstExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getFrstExpDoc(), prof.getFrstExpDocContentType(), "frstExpDoc", prof.getUid());
		prof.setFrstExpDoc(null);
		if(prof.getScndExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getScndExpDoc(), prof.getScndExpDocContentType(), "scndExpDoc", prof.getUid());
		prof.setScndExpDoc(null);
		if(prof.getThirdExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getThirdExpDoc(), prof.getThirdExpDocContentType(), "thirdExpDoc", prof.getUid());
		prof.setThirdExpDoc(null);
		em.getTransaction().begin();
		em.persist(prof);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}
	
	public void updateProfessionalInfo(ProfessionalInfo prof){
		
		EntityManager em = EMF.get().createEntityManager();
		ProfessionalInfo p = retrieveProfInfoByUserId(prof.getUid());
		prof.setKey(p.getKey());
		if(prof.getFrstExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getFrstExpDoc(), prof.getFrstExpDocContentType(), "frstExpDoc", prof.getUid());
		else if(p.getFrstExpDocFileName() != null)
			prof.setFrstExpDocFileName(p.getFrstExpDocFileName());
		prof.setScndExpDoc(null);
		if(prof.getScndExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getScndExpDoc(), prof.getScndExpDocContentType(), "scndExpDoc", prof.getUid());
		else if(p.getScndExpDocFileName() != null)
			prof.setScndExpDocFileName(p.getScndExpDocFileName());
		prof.setScndExpDoc(null);
		if(prof.getThirdExpDoc() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(prof.getThirdExpDoc(), prof.getThirdExpDocContentType(), "thirdExpDoc", prof.getUid());
		else if(p.getThirdExpDocFileName() != null)
			prof.setThirdExpDocFileName(p.getThirdExpDocFileName());
		prof.setThirdExpDoc(null);
		em.getTransaction().begin();
		em.persist(prof);
		em.getTransaction().commit();
		EMF.get().createEntityManager().close();
	}

	public BasicInfo retrieveBasicInfoByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select basic from BasicInfo basic where basic.uid='"+uid+"'");
		List<BasicInfo> basic= q.getResultList();
		em.getTransaction().commit();
		if(basic.isEmpty())
			return null;
		else
			return basic.get(0);
	}
	
	public EducationDetails retrieveEducationDetailsByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select edetails from EducationDetails edetails where edetails.uid='"+uid+"'");
		List<EducationDetails> edetails= q.getResultList();
		em.getTransaction().commit();
		if(edetails.isEmpty())
			return null;
		else
			return edetails.get(0);
	}
	
	public BirthDetails retrieveBirthDetailsByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select bdetails from BirthDetails bdetails where bdetails.uid='"+uid+"'");
		List<BirthDetails> bdetails= q.getResultList();
		em.getTransaction().commit();
		if(bdetails.isEmpty())
			return null;
		else
			return bdetails.get(0);
	}
	
	public ProfessionalInfo retrieveProfInfoByUserId(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select pinfo from ProfessionalInfo pinfo where pinfo.uid='"+uid+"'");
		List<ProfessionalInfo> pinfo= q.getResultList();
		em.getTransaction().commit();
		if(pinfo.isEmpty())
			return null;
		else
			return pinfo.get(0);
	}
	
	
}
