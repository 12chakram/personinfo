/**
 * 
 */
package com.persinfo.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.UserDAO;
import com.persinfo.data.User;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class UserLoginAction extends ActionSupport{

	private String uname;
	private String password;
	
	
	
	@Action(value = "/logout", results = {@Result(name = "success", location="index.jsp", type="redirect")})
	public String logout(){
		
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	
	@Action(value = "/", results = {@Result(name = "success", location="persinfo/index.jsp", type="redirect")})
	public String showRoot(){
		return SUCCESS;
	}
	
	
	@Action(value = "/doLogin", results = {@Result(name = "success", location = "dashboard", type="redirect"), @Result(name = "input", location="persinfo/index.jsp")})
	public String doLogin(){
		User u = null;		
		if(uname != null && password != null){
			u = new UserDAO().retrieveUserByUserNameAndPassword(uname, password);			
		}
		if(u !=null ){
			ServletActionContext.getRequest().getSession().putValue("user", u);
			return SUCCESS;
		}	
		else{
			addFieldError("", "ERROR: Invalid username or password.");
			addFieldError("", "If logging for first time please login to your mail and confirm.");
			return INPUT;
		}
	}
	

	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	

}
