/**
 * 
 */
package com.persinfo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * @author deva
 *
 */
@Entity
public class ImportantDoc {
	
	private String idNo;
	private String dateOfIssue;
	private String placeOfIssue;
	private String country;
	private String refSrlNo;
	private String docCopy;
	private String docCopyContentType;
	private String docCopyFileName;
	private String docType;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	/**
	 * @return the idNo
	 */
	public String getIdNo() {
		return idNo;
	}
	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	/**
	 * @return the dateOfIssue
	 */
	public String getDateOfIssue() {
		return dateOfIssue;
	}
	/**
	 * @param dateOfIssue the dateOfIssue to set
	 */
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	/**
	 * @return the placeOfIssue
	 */
	public String getPlaceOfIssue() {
		return placeOfIssue;
	}
	/**
	 * @param placeOfIssue the placeOfIssue to set
	 */
	public void setPlaceOfIssue(String placeOfIssue) {
		this.placeOfIssue = placeOfIssue;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the refSrlNo
	 */
	public String getRefSrlNo() {
		return refSrlNo;
	}
	/**
	 * @param refSrlNo the refSrlNo to set
	 */
	public void setRefSrlNo(String refSrlNo) {
		this.refSrlNo = refSrlNo;
	}
	/**
	 * @return the docCopy
	 */
	public String getDocCopy() {
		return docCopy;
	}
	/**
	 * @param docCopy the docCopy to set
	 */
	public void setDocCopy(String docCopy) {
		this.docCopy = docCopy;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(Key key) {
		this.key = key;
	}
	/**
	 * @return the docCopyContentType
	 */
	public String getDocCopyContentType() {
		return docCopyContentType;
	}
	/**
	 * @param docCopyContentType the docCopyContentType to set
	 */
	public void setDocCopyContentType(String docCopyContentType) {
		this.docCopyContentType = docCopyContentType;
	}
	/**
	 * @return the docCopyFileName
	 */
	public String getDocCopyFileName() {
		return docCopyFileName;
	}
	/**
	 * @param docCopyFileName the docCopyFileName to set
	 */
	public void setDocCopyFileName(String docCopyFileName) {
		this.docCopyFileName = docCopyFileName;
	}
	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * @param docType the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}
	
	

}
