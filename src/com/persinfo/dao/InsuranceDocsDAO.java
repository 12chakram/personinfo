/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.InsuranceDoc;
import com.persinfo.utilities.EMF;
import com.persinfo.utilities.PteCloudUtilities;

/**
 * @author deva
 *
 */
public class InsuranceDocsDAO {

	
	public void addInsuranceDoc(InsuranceDoc insDoc){
		
		EntityManager em = EMF.get().createEntityManager();
		if(insDoc.getPolDoc1() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc1(), insDoc.getPolDoc1ContentType(), insDoc.getPolDocType()+"Doc1", insDoc.getUid());
		insDoc.setPolDoc1(null);
		if(insDoc.getPolDoc2() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc2(), insDoc.getPolDoc2ContentType(), insDoc.getPolDocType()+"Doc2", insDoc.getUid());
		insDoc.setPolDoc2(null);
		if(insDoc.getPolDoc3() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc3(), insDoc.getPolDoc3ContentType(), insDoc.getPolDocType()+"Doc3", insDoc.getUid());
		insDoc.setPolDoc3(null);
		if(insDoc.getPolDoc4() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc4(), insDoc.getPolDoc4ContentType(), insDoc.getPolDocType()+"Doc4", insDoc.getUid());
		insDoc.setPolDoc4(null);
		em.getTransaction().begin();
		em.persist(insDoc);
		em.getTransaction().commit();
		em.close();
	}
	public InsuranceDoc updateInsuranceDoc(InsuranceDoc insDoc){
		
		EntityManager em = EMF.get().createEntityManager();
		InsuranceDoc ins = em.find(InsuranceDoc.class, retrieveInsuranceDocByUserIdAndType(insDoc.getUid(), insDoc.getPolDocType()).getKey());
		if(insDoc.getPolName() != null)ins.setPolName(insDoc.getPolName());
		if(insDoc.getDateOfPol() != null)ins.setDateOfPol(insDoc.getDateOfPol());
		if(insDoc.getDateOfRnwl() != null)ins.setDateOfRnwl(insDoc.getDateOfRnwl());
		if(insDoc.getPolComp()!= null)ins.setPolComp(insDoc.getPolComp());
		if(insDoc.getPolNomi() != null)ins.setPolNomi(insDoc.getPolNomi());
		if(insDoc.getPolNo() != null) ins.setPolNo(insDoc.getPolNo());
		if(insDoc.getPolDoc1FileName() != null)ins.setPolDoc1FileName(insDoc.getPolDoc1FileName());
		if(insDoc.getPolDoc1ContentType() != null)ins.setPolDoc1ContentType(insDoc.getPolDoc1ContentType());
		if(insDoc.getPolDoc1() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc1(), insDoc.getPolDoc1ContentType(), insDoc.getPolDocType()+"Doc1", insDoc.getUid());
		insDoc.setPolDoc1(null);
		if(insDoc.getPolDoc2FileName() != null)ins.setPolDoc2FileName(insDoc.getPolDoc2FileName());
		if(insDoc.getPolDoc2ContentType() != null)ins.setPolDoc2ContentType(insDoc.getPolDoc2ContentType());
		if(insDoc.getPolDoc2() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc2(), insDoc.getPolDoc2ContentType(), insDoc.getPolDocType()+"Doc2", insDoc.getUid());
		insDoc.setPolDoc2(null);
		if(insDoc.getPolDoc3FileName() != null)ins.setPolDoc3FileName(insDoc.getPolDoc3FileName());
		if(insDoc.getPolDoc3ContentType() != null)ins.setPolDoc3ContentType(insDoc.getPolDoc3ContentType());
		if(insDoc.getPolDoc3() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc3(), insDoc.getPolDoc3ContentType(), insDoc.getPolDocType()+"Doc3", insDoc.getUid());
		insDoc.setPolDoc3(null);
		if(insDoc.getPolDoc4FileName() != null)ins.setPolDoc4FileName(insDoc.getPolDoc4FileName());
		if(insDoc.getPolDoc4ContentType() != null)ins.setPolDoc4ContentType(insDoc.getPolDoc4ContentType());
		if(insDoc.getPolDoc4() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(insDoc.getPolDoc4(), insDoc.getPolDoc4ContentType(), insDoc.getPolDocType()+"Doc4", insDoc.getUid());
		insDoc.setPolDoc4(null);
		
//		insDoc.setKey(ins.getKey());
//		if((insDoc.getPolDoc1() == null || insDoc.getPolDoc1().trim().equals("")) && ins.getPolDoc1Text() != null){
//			insDoc.setPolDoc1("");
//			insDoc.setPolDoc1ContentType(ins.getPolDoc1ContentType());
//			insDoc.setPolDoc1FileName(ins.getPolDoc1FileName());
//			insDoc.setPolDoc1Text(ins.getPolDoc1Text());
//		}
//		if((insDoc.getPolDoc2() == null || insDoc.getPolDoc2().trim().equals("")) && ins.getPolDoc2Text() != null){
//			insDoc.setPolDoc2("");
//			insDoc.setPolDoc2ContentType(ins.getPolDoc2ContentType());
//			insDoc.setPolDoc2FileName(ins.getPolDoc2FileName());
//			insDoc.setPolDoc2Text(ins.getPolDoc2Text());
//		}
//		if((insDoc.getPolDoc3() == null || insDoc.getPolDoc3().trim().equals("")) && ins.getPolDoc3Text() != null){
//			insDoc.setPolDoc3("");
//			insDoc.setPolDoc3ContentType(ins.getPolDoc3ContentType());
//			insDoc.setPolDoc3FileName(ins.getPolDoc3FileName());
//			insDoc.setPolDoc3Text(ins.getPolDoc3Text());
//		}
//		if((insDoc.getPolDoc4() == null || insDoc.getPolDoc4().trim().equals("")) && ins.getPolDoc4Text() != null){
//			insDoc.setPolDoc4("");
//			insDoc.setPolDoc4ContentType(ins.getPolDoc4ContentType());
//			insDoc.setPolDoc4FileName(ins.getPolDoc4FileName());
//			insDoc.setPolDoc4Text(ins.getPolDoc4Text());
//		}

		em.getTransaction().begin();
		em.persist(ins);
		em.getTransaction().commit();
		em.close();
		return ins;
	}
	
	public InsuranceDoc retrieveInsuranceDocByUserIdAndType(String uid, String type){
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select doc from InsuranceDoc doc where doc.uid='"+uid+"' and doc.polDocType='" + type+"'");
		List<InsuranceDoc> insDoc = q.getResultList();
		em.getTransaction().commit();
		if(insDoc.isEmpty())
			return null;
		else
			return insDoc.get(0);
	}
	
	public List<InsuranceDoc> retrieveAllInsuranceDocsByUserId(String uid){
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select doc from InsuranceDoc doc where doc.uid='"+uid+"' order by doc.polDocType");
		List<InsuranceDoc> insDocs = q.getResultList();
		em.getTransaction().commit();
		if(insDocs.isEmpty())
			return null;
		else
			return insDocs;
	}

}
