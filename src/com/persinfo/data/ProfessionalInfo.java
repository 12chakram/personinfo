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
public class ProfessionalInfo {

	private String frstComp;
	private String frstDOJ;
	private String frstDesig;
	private String frstExpDoc;
	private String frstExpDocContentType;
	private String frstExpDocFileName;
	
	private String scndComp;
	private String scndDOJ;
	private String scndDesig;
	private String scndExpDoc;
	private String scndExpDocContentType;
	private String scndExpDocFileName;
	
	private String thirdComp;
	private String thirdDOJ;
	private String thirdDesig;
	private String thirdExpDoc;
	private String thirdExpDocContentType;
	private String thirdExpDocFileName;
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
	 * @return the frstComp
	 */
	public String getFrstComp() {
		return frstComp;
	}
	/**
	 * @param frstComp the frstComp to set
	 */
	public void setFrstComp(String frstComp) {
		this.frstComp = frstComp;
	}
	/**
	 * @return the frstDOJ
	 */
	public String getFrstDOJ() {
		return frstDOJ;
	}
	/**
	 * @param frstDOJ the frstDOJ to set
	 */
	public void setFrstDOJ(String frstDOJ) {
		this.frstDOJ = frstDOJ;
	}
	/**
	 * @return the frstDesig
	 */
	public String getFrstDesig() {
		return frstDesig;
	}
	/**
	 * @param frstDesig the frstDesig to set
	 */
	public void setFrstDesig(String frstDesig) {
		this.frstDesig = frstDesig;
	}
	/**
	 * @return the frstExpDoc
	 */
	public String getFrstExpDoc() {
		return frstExpDoc;
	}
	/**
	 * @param frstExpDoc the frstExpDoc to set
	 */
	public void setFrstExpDoc(String frstExpDoc) {
		this.frstExpDoc = frstExpDoc;
	}
	/**
	 * @return the scndComp
	 */
	public String getScndComp() {
		return scndComp;
	}
	/**
	 * @param scndComp the scndComp to set
	 */
	public void setScndComp(String scndComp) {
		this.scndComp = scndComp;
	}
	/**
	 * @return the scndDOJ
	 */
	public String getScndDOJ() {
		return scndDOJ;
	}
	/**
	 * @param scndDOJ the scndDOJ to set
	 */
	public void setScndDOJ(String scndDOJ) {
		this.scndDOJ = scndDOJ;
	}
	/**
	 * @return the scndDesig
	 */
	public String getScndDesig() {
		return scndDesig;
	}
	/**
	 * @param scndDesig the scndDesig to set
	 */
	public void setScndDesig(String scndDesig) {
		this.scndDesig = scndDesig;
	}
	/**
	 * @return the scndExpDoc
	 */
	public String getScndExpDoc() {
		return scndExpDoc;
	}
	/**
	 * @param scndExpDoc the scndExpDoc to set
	 */
	public void setScndExpDoc(String scndExpDoc) {
		this.scndExpDoc = scndExpDoc;
	}
	/**
	 * @return the thirdComp
	 */
	public String getThirdComp() {
		return thirdComp;
	}
	/**
	 * @param thirdComp the thirdComp to set
	 */
	public void setThirdComp(String thirdComp) {
		this.thirdComp = thirdComp;
	}
	/**
	 * @return the thirdDOJ
	 */
	public String getThirdDOJ() {
		return thirdDOJ;
	}
	/**
	 * @param thirdDOJ the thirdDOJ to set
	 */
	public void setThirdDOJ(String thirdDOJ) {
		this.thirdDOJ = thirdDOJ;
	}
	/**
	 * @return the thirdDesig
	 */
	public String getThirdDesig() {
		return thirdDesig;
	}
	/**
	 * @param thirdDesig the thirdDesig to set
	 */
	public void setThirdDesig(String thirdDesig) {
		this.thirdDesig = thirdDesig;
	}
	/**
	 * @return the thirdExpDoc
	 */
	public String getThirdExpDoc() {
		return thirdExpDoc;
	}
	/**
	 * @param thirdExpDoc the thirdExpDoc to set
	 */
	public void setThirdExpDoc(String thirdExpDoc) {
		this.thirdExpDoc = thirdExpDoc;
	}
	/**
	 * @return the frstExpDocContentType
	 */
	public String getFrstExpDocContentType() {
		return frstExpDocContentType;
	}
	/**
	 * @param frstExpDocContentType the frstExpDocContentType to set
	 */
	public void setFrstExpDocContentType(String frstExpDocContentType) {
		this.frstExpDocContentType = frstExpDocContentType;
	}
	/**
	 * @return the frstExpDocFileName
	 */
	public String getFrstExpDocFileName() {
		return frstExpDocFileName;
	}
	/**
	 * @param frstExpDocFileName the frstExpDocFileName to set
	 */
	public void setFrstExpDocFileName(String frstExpDocFileName) {
		this.frstExpDocFileName = frstExpDocFileName;
	}
	/**
	 * @return the scndExpDocContentType
	 */
	public String getScndExpDocContentType() {
		return scndExpDocContentType;
	}
	/**
	 * @param scndExpDocContentType the scndExpDocContentType to set
	 */
	public void setScndExpDocContentType(String scndExpDocContentType) {
		this.scndExpDocContentType = scndExpDocContentType;
	}
	/**
	 * @return the scndExpDocFileName
	 */
	public String getScndExpDocFileName() {
		return scndExpDocFileName;
	}
	/**
	 * @param scndExpDocFileName the scndExpDocFileName to set
	 */
	public void setScndExpDocFileName(String scndExpDocFileName) {
		this.scndExpDocFileName = scndExpDocFileName;
	}
	/**
	 * @return the thirdExpDocContentType
	 */
	public String getThirdExpDocContentType() {
		return thirdExpDocContentType;
	}
	/**
	 * @param thirdExpDocContentType the thirdExpDocContentType to set
	 */
	public void setThirdExpDocContentType(String thirdExpDocContentType) {
		this.thirdExpDocContentType = thirdExpDocContentType;
	}
	/**
	 * @return the thirdExpDocFileName
	 */
	public String getThirdExpDocFileName() {
		return thirdExpDocFileName;
	}
	/**
	 * @param thirdExpDocFileName the thirdExpDocFileName to set
	 */
	public void setThirdExpDocFileName(String thirdExpDocFileName) {
		this.thirdExpDocFileName = thirdExpDocFileName;
	}
	
	
	
	
}
