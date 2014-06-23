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
public class DrivingLicense {
	
	private String issuedAuth;
	private String validFrm;
	private String validTo;
	private String licenseNo;
	private String dlDoc;
	private String dlDocContentType;
	private String dlDocFileName;
	private Text dlDocText;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
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
	 * @return the issuedAuth
	 */
	public String getIssuedAuth() {
		return issuedAuth;
	}
	/**
	 * @param issuedAuth the issuedAuth to set
	 */
	public void setIssuedAuth(String issuedAuth) {
		this.issuedAuth = issuedAuth;
	}
	/**
	 * @return the validFrm
	 */
	public String getValidFrm() {
		return validFrm;
	}
	/**
	 * @param validFrm the validFrm to set
	 */
	public void setValidFrm(String validFrm) {
		this.validFrm = validFrm;
	}
	/**
	 * @return the validTo
	 */
	public String getValidTo() {
		return validTo;
	}
	/**
	 * @param validTo the validTo to set
	 */
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	/**
	 * @return the licenseNo
	 */
	public String getLicenseNo() {
		return licenseNo;
	}
	/**
	 * @param licenseNo the licenseNo to set
	 */
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	/**
	 * @return the dlDoc
	 */
	public String getDlDoc() {
		return dlDoc;
	}
	/**
	 * @param dlDoc the dlDoc to set
	 */
	public void setDlDoc(String dlDoc) {
		this.dlDoc = dlDoc;
	}
	/**
	 * @return the dlDocContentType
	 */
	public String getDlDocContentType() {
		return dlDocContentType;
	}
	/**
	 * @param dlDocContentType the dlDocContentType to set
	 */
	public void setDlDocContentType(String dlDocContentType) {
		this.dlDocContentType = dlDocContentType;
	}
	/**
	 * @return the dlDocFileName
	 */
	public String getDlDocFileName() {
		return dlDocFileName;
	}
	/**
	 * @param dlDocFileName the dlDocFileName to set
	 */
	public void setDlDocFileName(String dlDocFileName) {
		this.dlDocFileName = dlDocFileName;
	}
	/**
	 * @return the dlDocText
	 */
	public Text getDlDocText() {
		return dlDocText;
	}
	/**
	 * @param dlDocText the dlDocText to set
	 */
	public void setDlDocText(Text dlDocText) {
		this.dlDocText = dlDocText;
	}

}
