/**
 * 
 */
package com.persinfo.vo;

import java.util.Date;

/**
 * @author deva
 *
 */
public class UserMessageVO {
	private String title;
	private String status;
	private String dateCreated;
	private String authorFname;
	private String authorLname;
	private String message;
	
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return the authorFname
	 */
	public String getAuthorFname() {
		return authorFname;
	}
	/**
	 * @param authorFname the authorFname to set
	 */
	public void setAuthorFname(String authorFname) {
		this.authorFname = authorFname;
	}
	/**
	 * @return the authorLname
	 */
	public String getAuthorLname() {
		return authorLname;
	}
	/**
	 * @param authorLname the authorLname to set
	 */
	public void setAuthorLname(String authorLname) {
		this.authorLname = authorLname;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
