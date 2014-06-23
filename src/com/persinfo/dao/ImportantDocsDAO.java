/**
 * 
 */
package com.persinfo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.persinfo.data.ImportantDoc;
import com.persinfo.utilities.EMF;
import com.persinfo.utilities.PteCloudUtilities;
/**
 * @author deva
 *
 */
public class ImportantDocsDAO {

	public void addImportantDoc(ImportantDoc impDoc){
		
		
		if(impDoc.getDocCopy() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(impDoc.getDocCopy(), impDoc.getDocCopyContentType(), impDoc.getDocType(), impDoc.getUid());
		impDoc.setDocCopy(null);
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		em.persist(impDoc);
		em.getTransaction().commit();
		//EMF.get().createEntityManager().close();
	}
	public ImportantDoc updateImportantDoc(ImportantDoc impDoc){
		
		EntityManager em = EMF.get().createEntityManager();
		
		ImportantDoc imp = em.find(ImportantDoc.class, retrieveImportantDocByUserIdAndType(impDoc.getUid(), impDoc.getDocType()).getKey());
		if(impDoc.getIdNo() != null) imp.setIdNo(impDoc.getIdNo());
		if(impDoc.getDateOfIssue() != null) imp.setDateOfIssue(impDoc.getDateOfIssue());
		if(impDoc.getPlaceOfIssue() != null) imp.setPlaceOfIssue(impDoc.getPlaceOfIssue());
		if(impDoc.getCountry() != null) imp.setCountry(impDoc.getCountry());
		if(impDoc.getRefSrlNo() != null) imp.setRefSrlNo(impDoc.getRefSrlNo());
		if(impDoc.getDocType() != null) imp.setDocType(impDoc.getDocType());
		if(impDoc.getDocCopyContentType() != null) imp.setDocCopyContentType(impDoc.getDocCopyContentType());
		if(impDoc.getDocCopyFileName() != null) imp.setDocCopyFileName(impDoc.getDocCopyFileName());
		if(impDoc.getDocCopy() != null)
			PteCloudUtilities.splitAndPersistLongTextAsChunks(impDoc.getDocCopy(), impDoc.getDocCopyContentType(), impDoc.getDocType(), impDoc.getUid());
		impDoc.setDocCopy(null);
		//impDoc.setKey(imp.getKey());
//		if((impDoc.getDocCopy() == null || impDoc.getDocCopy().trim().equals("")) && imp.getDocCopyFileName() != null){
//			impDoc.setDocCopy("");
//			impDoc.setDocCopyContentType(imp.getDocCopyContentType());
//			impDoc.setDocCopyFileName(imp.getDocCopyFileName());
//			//impDoc.setDocCopyText(imp.getDocCopyText());
//		}
		em.getTransaction().begin();
		em.persist(imp);
		em.getTransaction().commit();
		em.close();
		return imp;
	}
	
	public ImportantDoc retrieveImportantDocByUserIdAndType(String uid, String type){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select impDoc from ImportantDoc impDoc where impDoc.uid='"+uid+"' and impDoc.docType='" + type + "'");
		List<ImportantDoc> impDoc= q.getResultList();
		em.getTransaction().commit();
		if(impDoc.isEmpty())
			return null;
		else
			return impDoc.get(0);
	}
	
	public List<ImportantDoc> retrieveAllImportantDocs(String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("select impDoc from ImportantDoc impDoc where impDoc.uid='"+uid+"'");
		List<ImportantDoc> impDocs = q.getResultList();
		em.getTransaction().commit();
		if(impDocs.isEmpty())
			return null;
		else
			return impDocs;
	}
}
