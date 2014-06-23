/**
 * 
 */
package com.persinfo.utilities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.google.appengine.api.datastore.Text;
import com.persinfo.data.ImportantDoc;
import com.persinfo.data.PteCloudFile;
/**
 * @author deva
 *
 */
public class PteCloudUtilities {
	
	public static void main(String[] args){
		String string = "sfsdfsdfsdfsd";
		int nochunks = (int)Math.ceil(string.getBytes().length/2);
		int len = string.length();
		int nchars = len/nochunks;
		List<String> parts = new ArrayList();
		for (int i=0; i<len; i+=nchars)
		{
			parts.add(string.substring(i, Math.min(len, i + nchars)));
		}
	}
	
	public static void splitAndPersistLongTextAsChunks(String text, String type, String name, String uid){
		
		EntityManager em = EMF.get().createEntityManager();
		int nochunks = (int)Math.ceil(text.length()/512000);
		nochunks = nochunks + 1;
		PteCloudFile pfile =  null;
		int j = 1;
		int len = text.length();
		int nchars = len/nochunks;
		List<String> chunks = new ArrayList<String>();
		for (int i=0; i<len; i+=nchars){
			chunks.add(text.substring(i, Math.min(len, i + nchars)));
		}
		deleteAllChunksForDoc(name, uid);
		for(String chunk: chunks){ 
			pfile = new PteCloudFile();
			pfile.setSeq(j);
			pfile.setFileText(new Text(chunk));
			pfile.setFileType(type);
			pfile.setUid(uid);
			pfile.setFileName(name);
			em.getTransaction().begin();
			em.persist(pfile);
			if ( j % 20 == 0 ) { //20, same as the JDBC batch size
		        //flush a batch of inserts and release memory:
		        em.flush();
		        em.clear();
			}
			em.getTransaction().commit();
			//listChunks.add(pfile);
			j++;
		}
		//retrieveAllChunksForDoc(name, uid, em);
	}
	
	private static void deleteAllChunksForDoc(String name, String uid){
		EntityManager em = EMF.get().createEntityManager();
		Query q = em.createQuery("select pfile from PteCloudFile pfile where pfile.uid='"+uid+"' and pfile.fileName='" + name + "' order by pfile.seq");
		List<PteCloudFile> pfiles = q.getResultList();
		for(PteCloudFile pfile:pfiles){
			em.getTransaction().begin();
			em.remove(pfile);
			em.getTransaction().commit();
		}
//		Query q = em.createQuery("delete from PteCloudFile pfile where pfile.uid='"+uid+"' and pfile.fileName='" + name + "'");
//		int i = q.executeUpdate();
	}
	
	public static String[] retrieveAllChunksForDoc(String name, String uid){
		EntityManager em = EMF.get().createEntityManager();
		Query q = em.createQuery("select pfile from PteCloudFile pfile where pfile.uid='"+uid+"' and pfile.fileName='" + name + "' order by pfile.seq");
		List<PteCloudFile> pfiles = q.getResultList();
		StringBuffer file = new StringBuffer();
		for(PteCloudFile pfile:pfiles){
			file.append(pfile.getFileText().getValue());
		}
		return new String[]{file.toString(), pfiles.get(0).getFileType()};
	}

}
