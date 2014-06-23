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
public class BasicInfo {

	private String fullName;
	private String email;
	private String address;
	private String phno;
	private String photoCopy;
	private String photoCopyFileName;
	private String photoCopyContentType;
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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phno
	 */
	public String getPhno() {
		return phno;
	}
	/**
	 * @param phno the phno to set
	 */
	public void setPhno(String phno) {
		this.phno = phno;
	}
	/**
	 * @return the photoCopy
	 */
	public String getPhotoCopy() {
		return photoCopy;
	}
	/**
	 * @param photoCopy the photoCopy to set
	 */
	public void setPhotoCopy(String photoCopy) {
		this.photoCopy = photoCopy;
	}
	/**
	 * @return the photoCopyFileName
	 */
	public String getPhotoCopyFileName() {
		return photoCopyFileName;
	}
	/**
	 * @param photoCopyFileName the photoCopyFileName to set
	 */
	public void setPhotoCopyFileName(String photoCopyFileName) {
		this.photoCopyFileName = photoCopyFileName;
	}
	/**
	 * @return the photoCopyContentType
	 */
	public String getPhotoCopyContentType() {
		return photoCopyContentType;
	}
	/**
	 * @param photoCopyContentType the photoCopyContentType to set
	 */
	public void setPhotoCopyContentType(String photoCopyContentType) {
		this.photoCopyContentType = photoCopyContentType;
	}
	
	
}
