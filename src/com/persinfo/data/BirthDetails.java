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
public class BirthDetails {

	private String placeOfBirth;
	private String dob;
	private String hospital;
	private String birthCert;
	private String birthCertContentType;
	private String birthCertFileName;
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
	 * @return the placeOfBirth
	 */
	public String getPlaceOfBirth() {
		return placeOfBirth;
	}
	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the hospital
	 */
	public String getHospital() {
		return hospital;
	}
	/**
	 * @param hospital the hospital to set
	 */
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	/**
	 * @return the birthCert
	 */
	public String getBirthCert() {
		return birthCert;
	}
	/**
	 * @param birthCert the birthCert to set
	 */
	public void setBirthCert(String birthCert) {
		this.birthCert = birthCert;
	}
	/**
	 * @return the birthCertContentType
	 */
	public String getBirthCertContentType() {
		return birthCertContentType;
	}
	/**
	 * @param birthCertContentType the birthCertContentType to set
	 */
	public void setBirthCertContentType(String birthCertContentType) {
		this.birthCertContentType = birthCertContentType;
	}
	/**
	 * @return the birthCertFileName
	 */
	public String getBirthCertFileName() {
		return birthCertFileName;
	}
	/**
	 * @param birthCertFileName the birthCertFileName to set
	 */
	public void setBirthCertFileName(String birthCertFileName) {
		this.birthCertFileName = birthCertFileName;
	}
	
	
	
}
