/**
 * 
 */
package com.persinfo.data;

import java.util.List;

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
public class VehicleInfo {
	private DrivingLicense dlicense;
	private List<Vehicle> listVehicles;
	private String uid;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
	
	
	/**
	 * @return the dlicense
	 */
	public DrivingLicense getDlicense() {
		return dlicense;
	}
	/**
	 * @param dlicense the dlicense to set
	 */
	public void setDlicense(DrivingLicense dlicense) {
		this.dlicense = dlicense;
	}
	/**
	 * @return the listVehicles
	 */
	public List<Vehicle> getListVehicles() {
		return listVehicles;
	}
	/**
	 * @param listVehicles the listVehicles to set
	 */
	public void setListVehicles(List<Vehicle> listVehicles) {
		this.listVehicles = listVehicles;
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
