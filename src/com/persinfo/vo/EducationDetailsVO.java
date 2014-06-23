/**
 * 
 */
package com.persinfo.vo;

import java.io.File;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

/**
 * @author deva
 *
 */
public class EducationDetailsVO {
	
	private String secYrOfAdmi;
	private String secSchlName;
	private String secPlace;
	private File secFile;
	
	private String colYrOfAdmi;
	private String colPassedYr;
	private String colBoard;
	private String colPlace;
	private File colFile;
	
	private String degYrOfAdmi;
	private String degPassedYr;
	private String degUniversity;
	private String degPlace;
	private File sdegFile;
	
	private String date;

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
	 * @return the secFile
	 */
	public File getSecFile() {
		return secFile;
	}

	/**
	 * @param secFile the secFile to set
	 */
	public void setSecFile(File secFile) {
		this.secFile = secFile;
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
	 * @return the colFile
	 */
	public File getColFile() {
		return colFile;
	}

	/**
	 * @param colFile the colFile to set
	 */
	public void setColFile(File colFile) {
		this.colFile = colFile;
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
	 * @return the sdegFile
	 */
	public File getSdegFile() {
		return sdegFile;
	}

	/**
	 * @param sdegFile the sdegFile to set
	 */
	public void setSdegFile(File sdegFile) {
		this.sdegFile = sdegFile;
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
	

}
