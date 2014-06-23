/**
 * 
 */
package com.persinfo.data;

import java.io.File;

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
public class EducationDetails {
	
	private String secYrOfAdmi;
	private String secSchlName;
	private String secPlace;
	private String secCert;
	private String secCertContentType;
	private String secCertFileName;
	
	private String colYrOfAdmi;
	private String colName;
	private String colPassedYr;
	private String colBoard;
	private String colPlace;
	private String colCert;
	private String colCertContentType;
	private String colCertFileName;
	
	private String degYrOfAdmi;
	private String degColName;
	private String degPassedYr;
	private String degUniversity;
	private String degPlace;
	private String degCert;
	private String degCertContentType;
	private String degCertFileName;
	
	private String date;
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
	 * @return the secYrOfAdmi
	 */
	public String getSecYrOfAdmi() {
		return secYrOfAdmi;
	}

	/**
	 * @param secYrOfAdmi the secYrOfAdmi to set
	 */
	public void setSecYrOfAdmi(String secYrOfAdmi) {
		this.secYrOfAdmi = secYrOfAdmi;
	}

	/**
	 * @return the secSchlName
	 */
	public String getSecSchlName() {
		return secSchlName;
	}

	/**
	 * @param secSchlName the secSchlName to set
	 */
	public void setSecSchlName(String secSchlName) {
		this.secSchlName = secSchlName;
	}

	/**
	 * @return the secPlace
	 */
	public String getSecPlace() {
		return secPlace;
	}

	/**
	 * @param secPlace the secPlace to set
	 */
	public void setSecPlace(String secPlace) {
		this.secPlace = secPlace;
	}

	/**
	 * @return the colYrOfAdmi
	 */
	public String getColYrOfAdmi() {
		return colYrOfAdmi;
	}

	/**
	 * @param colYrOfAdmi the colYrOfAdmi to set
	 */
	public void setColYrOfAdmi(String colYrOfAdmi) {
		this.colYrOfAdmi = colYrOfAdmi;
	}

	/**
	 * @return the colPassedYr
	 */
	public String getColPassedYr() {
		return colPassedYr;
	}

	/**
	 * @param colPassedYr the colPassedYr to set
	 */
	public void setColPassedYr(String colPassedYr) {
		this.colPassedYr = colPassedYr;
	}

	/**
	 * @return the colBoard
	 */
	public String getColBoard() {
		return colBoard;
	}

	/**
	 * @param colBoard the colBoard to set
	 */
	public void setColBoard(String colBoard) {
		this.colBoard = colBoard;
	}

	/**
	 * @return the colPlace
	 */
	public String getColPlace() {
		return colPlace;
	}

	/**
	 * @param colPlace the colPlace to set
	 */
	public void setColPlace(String colPlace) {
		this.colPlace = colPlace;
	}

	/**
	 * @return the degYrOfAdmi
	 */
	public String getDegYrOfAdmi() {
		return degYrOfAdmi;
	}

	/**
	 * @param degYrOfAdmi the degYrOfAdmi to set
	 */
	public void setDegYrOfAdmi(String degYrOfAdmi) {
		this.degYrOfAdmi = degYrOfAdmi;
	}

	/**
	 * @return the degPassedYr
	 */
	public String getDegPassedYr() {
		return degPassedYr;
	}

	/**
	 * @param degPassedYr the degPassedYr to set
	 */
	public void setDegPassedYr(String degPassedYr) {
		this.degPassedYr = degPassedYr;
	}

	/**
	 * @return the degUniversity
	 */
	public String getDegUniversity() {
		return degUniversity;
	}

	/**
	 * @param degUniversity the degUniversity to set
	 */
	public void setDegUniversity(String degUniversity) {
		this.degUniversity = degUniversity;
	}

	/**
	 * @return the degPlace
	 */
	public String getDegPlace() {
		return degPlace;
	}

	/**
	 * @param degPlace the degPlace to set
	 */
	public void setDegPlace(String degPlace) {
		this.degPlace = degPlace;
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
	 * @return the secCert
	 */
	public String getSecCert() {
		return secCert;
	}
	/**
	 * @param secCert the secCert to set
	 */
	public void setSecCert(String secCert) {
		this.secCert = secCert;
	}
	/**
	 * @return the secCertContentType
	 */
	public String getSecCertContentType() {
		return secCertContentType;
	}
	/**
	 * @param secCertContentType the secCertContentType to set
	 */
	public void setSecCertContentType(String secCertContentType) {
		this.secCertContentType = secCertContentType;
	}
	/**
	 * @return the secCertFileName
	 */
	public String getSecCertFileName() {
		return secCertFileName;
	}
	/**
	 * @param secCertFileName the secCertFileName to set
	 */
	public void setSecCertFileName(String secCertFileName) {
		this.secCertFileName = secCertFileName;
	}
	/**
	 * @return the colCert
	 */
	public String getColCert() {
		return colCert;
	}
	/**
	 * @param colCert the colCert to set
	 */
	public void setColCert(String colCert) {
		this.colCert = colCert;
	}
	/**
	 * @return the colCertContentType
	 */
	public String getColCertContentType() {
		return colCertContentType;
	}
	/**
	 * @param colCertContentType the colCertContentType to set
	 */
	public void setColCertContentType(String colCertContentType) {
		this.colCertContentType = colCertContentType;
	}
	/**
	 * @return the colCertFileName
	 */
	public String getColCertFileName() {
		return colCertFileName;
	}
	/**
	 * @param colCertFileName the colCertFileName to set
	 */
	public void setColCertFileName(String colCertFileName) {
		this.colCertFileName = colCertFileName;
	}
	/**
	 * @return the degCert
	 */
	public String getDegCert() {
		return degCert;
	}
	/**
	 * @param degCert the degCert to set
	 */
	public void setDegCert(String degCert) {
		this.degCert = degCert;
	}
	/**
	 * @return the degCertContentType
	 */
	public String getDegCertContentType() {
		return degCertContentType;
	}
	/**
	 * @param degCertContentType the degCertContentType to set
	 */
	public void setDegCertContentType(String degCertContentType) {
		this.degCertContentType = degCertContentType;
	}
	/**
	 * @return the degCertFileName
	 */
	public String getDegCertFileName() {
		return degCertFileName;
	}
	/**
	 * @param degCertFileName the degCertFileName to set
	 */
	public void setDegCertFileName(String degCertFileName) {
		this.degCertFileName = degCertFileName;
	}
	/**
	 * @return the colName
	 */
	public String getColName() {
		return colName;
	}
	/**
	 * @param colName the colName to set
	 */
	public void setColName(String colName) {
		this.colName = colName;
	}
	/**
	 * @return the degColName
	 */
	public String getDegColName() {
		return degColName;
	}
	/**
	 * @param degColName the degColName to set
	 */
	public void setDegColName(String degColName) {
		this.degColName = degColName;
	}
	

}
