/**
 * 
 */
package com.persinfo.data;

import java.io.Serializable;

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
public class InsuranceDoc implements Serializable{

	
	private String polName;
	private String dateOfPol;
	private String dateOfRnwl;
	private String polComp;
	private String polNomi;
	private String polNo;
	private String polDoc1;
	private String polDoc1ContentType;
	private String polDoc1FileName;
	private String polDoc2;
	private String polDoc2ContentType;
	private String polDoc2FileName;
	private String polDoc3;
	private String polDoc3ContentType;
	private String polDoc3FileName;
	private String polDoc4;
	private String polDoc4ContentType;
	private String polDoc4FileName;
	private String polDocType;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	
	/**
	 * @return the polName
	 */
	public String getPolName() {
		return polName;
	}
	/**
	 * @param polName the polName to set
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	/**
	 * @return the dateOfPol
	 */
	public String getDateOfPol() {
		return dateOfPol;
	}
	/**
	 * @param dateOfPol the dateOfPol to set
	 */
	public void setDateOfPol(String dateOfPol) {
		this.dateOfPol = dateOfPol;
	}
	/**
	 * @return the dateOfRnwl
	 */
	public String getDateOfRnwl() {
		return dateOfRnwl;
	}
	/**
	 * @param dateOfRnwl the dateOfRnwl to set
	 */
	public void setDateOfRnwl(String dateOfRnwl) {
		this.dateOfRnwl = dateOfRnwl;
	}
	/**
	 * @return the polComp
	 */
	public String getPolComp() {
		return polComp;
	}
	/**
	 * @param polComp the polComp to set
	 */
	public void setPolComp(String polComp) {
		this.polComp = polComp;
	}
	/**
	 * @return the polNomi
	 */
	public String getPolNomi() {
		return polNomi;
	}
	/**
	 * @param polNomi the polNomi to set
	 */
	public void setPolNomi(String polNomi) {
		this.polNomi = polNomi;
	}
	/**
	 * @return the polNo
	 */
	public String getPolNo() {
		return polNo;
	}
	/**
	 * @param polNo the polNo to set
	 */
	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}
	/**
	 * @return the polDoc1
	 */
	public String getPolDoc1() {
		return polDoc1;
	}
	/**
	 * @param polDoc1 the polDoc1 to set
	 */
	public void setPolDoc1(String polDoc1) {
		this.polDoc1 = polDoc1;
	}
	/**
	 * @return the polDoc1ContentType
	 */
	public String getPolDoc1ContentType() {
		return polDoc1ContentType;
	}
	/**
	 * @param polDoc1ContentType the polDoc1ContentType to set
	 */
	public void setPolDoc1ContentType(String polDoc1ContentType) {
		this.polDoc1ContentType = polDoc1ContentType;
	}
	/**
	 * @return the polDoc1FileName
	 */
	public String getPolDoc1FileName() {
		return polDoc1FileName;
	}
	/**
	 * @param polDoc1FileName the polDoc1FileName to set
	 */
	public void setPolDoc1FileName(String polDoc1FileName) {
		this.polDoc1FileName = polDoc1FileName;
	}
	/**
	 * @return the polDoc2
	 */
	public String getPolDoc2() {
		return polDoc2;
	}
	/**
	 * @param polDoc2 the polDoc2 to set
	 */
	public void setPolDoc2(String polDoc2) {
		this.polDoc2 = polDoc2;
	}
	/**
	 * @return the polDoc2ContentType
	 */
	public String getPolDoc2ContentType() {
		return polDoc2ContentType;
	}
	/**
	 * @param polDoc2ContentType the polDoc2ContentType to set
	 */
	public void setPolDoc2ContentType(String polDoc2ContentType) {
		this.polDoc2ContentType = polDoc2ContentType;
	}
	/**
	 * @return the polDoc2FileName
	 */
	public String getPolDoc2FileName() {
		return polDoc2FileName;
	}
	/**
	 * @param polDoc2FileName the polDoc2FileName to set
	 */
	public void setPolDoc2FileName(String polDoc2FileName) {
		this.polDoc2FileName = polDoc2FileName;
	}
	/**
	 * @return the polDoc3
	 */
	public String getPolDoc3() {
		return polDoc3;
	}
	/**
	 * @param polDoc3 the polDoc3 to set
	 */
	public void setPolDoc3(String polDoc3) {
		this.polDoc3 = polDoc3;
	}
	/**
	 * @return the polDoc3ContentType
	 */
	public String getPolDoc3ContentType() {
		return polDoc3ContentType;
	}
	/**
	 * @param polDoc3ContentType the polDoc3ContentType to set
	 */
	public void setPolDoc3ContentType(String polDoc3ContentType) {
		this.polDoc3ContentType = polDoc3ContentType;
	}
	/**
	 * @return the polDoc3FileName
	 */
	public String getPolDoc3FileName() {
		return polDoc3FileName;
	}
	/**
	 * @param polDoc3FileName the polDoc3FileName to set
	 */
	public void setPolDoc3FileName(String polDoc3FileName) {
		this.polDoc3FileName = polDoc3FileName;
	}
	/**
	 * @return the polDoc4
	 */
	public String getPolDoc4() {
		return polDoc4;
	}
	/**
	 * @param polDoc4 the polDoc4 to set
	 */
	public void setPolDoc4(String polDoc4) {
		this.polDoc4 = polDoc4;
	}
	/**
	 * @return the polDoc4ContentType
	 */
	public String getPolDoc4ContentType() {
		return polDoc4ContentType;
	}
	/**
	 * @param polDoc4ContentType the polDoc4ContentType to set
	 */
	public void setPolDoc4ContentType(String polDoc4ContentType) {
		this.polDoc4ContentType = polDoc4ContentType;
	}
	/**
	 * @return the polDoc4FileName
	 */
	public String getPolDoc4FileName() {
		return polDoc4FileName;
	}
	/**
	 * @param polDoc4FileName the polDoc4FileName to set
	 */
	public void setPolDoc4FileName(String polDoc4FileName) {
		this.polDoc4FileName = polDoc4FileName;
	}
	/**
	 * @return the polDocType
	 */
	public String getPolDocType() {
		return polDocType;
	}
	/**
	 * @param polDocSeq the polDocType to set
	 */
	public void setPolDocType(String polDocType) {
		this.polDocType = polDocType;
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

}
