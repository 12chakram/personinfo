/**
 * 
 */
package com.persinfo.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Text;

/**
 * @author deva
 *
 */
@Entity
public class Vehicle {
	
	private String owner;
	private String make;
	private String regNo;
	private String engNo;
	private String insComp;
	private String insNo;
	private String validity;
	private String renwlDate;
	private String rcDoc;
	private String rcDocContentType;
	private String rcDocFileName;
	private String docType;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the regNo
	 */
	public String getRegNo() {
		return regNo;
	}
	/**
	 * @param regNo the regNo to set
	 */
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	/**
	 * @return the engNo
	 */
	public String getEngNo() {
		return engNo;
	}
	/**
	 * @param engNo the engNo to set
	 */
	public void setEngNo(String engNo) {
		this.engNo = engNo;
	}
	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}
	/**
	 * @param vSeq the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
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
	 * @return the insComp
	 */
	public String getInsComp() {
		return insComp;
	}
	/**
	 * @param insComp the insComp to set
	 */
	public void setInsComp(String insComp) {
		this.insComp = insComp;
	}
	/**
	 * @return the insNo
	 */
	public String getInsNo() {
		return insNo;
	}
	/**
	 * @param insNo the insNo to set
	 */
	public void setInsNo(String insNo) {
		this.insNo = insNo;
	}
	/**
	 * @return the validity
	 */
	public String getValidity() {
		return validity;
	}
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(String validity) {
		this.validity = validity;
	}
	/**
	 * @return the renwlDate
	 */
	public String getRenwlDate() {
		return renwlDate;
	}
	/**
	 * @param renwlDate the renwlDate to set
	 */
	public void setRenwlDate(String renwlDate) {
		this.renwlDate = renwlDate;
	}
	/**
	 * @return the rcDoc
	 */
	public String getRcDoc() {
		return rcDoc;
	}
	/**
	 * @param rcDoc the rcDoc to set
	 */
	public void setRcDoc(String rcDoc) {
		this.rcDoc = rcDoc;
	}
	/**
	 * @return the rcDocContentType
	 */
	public String getRcDocContentType() {
		return rcDocContentType;
	}
	/**
	 * @param rcDocContentType the rcDocContentType to set
	 */
	public void setRcDocContentType(String rcDocContentType) {
		this.rcDocContentType = rcDocContentType;
	}
	/**
	 * @return the rcDocFileName
	 */
	public String getRcDocFileName() {
		return rcDocFileName;
	}
	/**
	 * @param rcDocFileName the rcDocFileName to set
	 */
	public void setRcDocFileName(String rcDocFileName) {
		this.rcDocFileName = rcDocFileName;
	}

}
