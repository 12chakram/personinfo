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
public class MostMemorableDays {

	private String frstLove;
	private String date;
	private String memories;
	private String mrgDate;
	private String mrgDetails;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	
	/**
	 * @return the frstLove
	 */
	public String getFrstLove() {
		return frstLove;
	}
	/**
	 * @param frstLove the frstLove to set
	 */
	public void setFrstLove(String frstLove) {
		this.frstLove = frstLove;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the memories
	 */
	public String getMemories() {
		return memories;
	}
	/**
	 * @param memories the memories to set
	 */
	public void setMemories(String memories) {
		this.memories = memories;
	}
	/**
	 * @return the mrgDate
	 */
	public String getMrgDate() {
		return mrgDate;
	}
	/**
	 * @param mrgDate the mrgDate to set
	 */
	public void setMrgDate(String mrgDate) {
		this.mrgDate = mrgDate;
	}
	/**
	 * @return the mrgDetails
	 */
	public String getMrgDetails() {
		return mrgDetails;
	}
	/**
	 * @param mrgDetails the mrgDetails to set
	 */
	public void setMrgDetails(String mrgDetails) {
		this.mrgDetails = mrgDetails;
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
