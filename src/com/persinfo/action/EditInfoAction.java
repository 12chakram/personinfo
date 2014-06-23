/**
 * 
 */
package com.persinfo.action;

import java.util.regex.Pattern;

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
public class EditInfoAction  extends ActionSupport{
	private User user;
	private String cfrmpassword;
	
	
	@Action(value = "/editinfo", results = {@Result(name = "success", location = "persinfo/editinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showEditInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			user = (User)ServletActionContext.getRequest().getSession().getValue("user");
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateAcntDetails", results = {@Result(name = "success", type="redirect", location = "dashboard"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/editinfo.jsp")}) 
	public String updateAcntDetails(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			User u = (User)ServletActionContext.getRequest().getSession().getValue("user");
//			u.setFname(user.getFname());
//			u.setLname(user.getLname());
//			u.setAddress(user.getAddress());
//			u.setCompany(user.getCompany());
//			if(!user.getPassword().equals(""))
//				u.setPassword(user.getPassword());
			
			user.setActive(true);
			user.setAgreed(true);
			user.setSource(u.getSource());
			user.setKey(u.getKey());
			if(user.getPassword().trim().equals(""))
				user.setPassword(u.getPassword());
			UserDAO dao = new UserDAO();
			dao.updateUserInfo(user);
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}else
			return "redirect";
	}
	
public void validate() {
		Pattern phno = Pattern.compile("\\d{10}");
		if(user != null){
			if(user.getAddress().trim().equals("") ||user.getFname().trim().equals("")||user.getLname().trim().equals("")||user.getEmail().trim().equals("")
						||user.getPhno().trim().equals("") ||user.getCompany().trim().equals("")||user.getUname().trim().equals(""))
					addFieldError("", "All fields are required to proceed with update");
			
			if(!user.getPhno().trim().equals("") && !phno.matcher(user.getPhno()).matches())
				addFieldError("", "Phone number must be a valid 10 digit number");
			
			if(!user.getPassword().trim().equals("")){
				if(user.getPassword().length() < 6)
					addFieldError("password", "Password length must be minumum 6 characters");
				else if(!user.getPassword().equals(cfrmpassword))
					addFieldError("password", "Passwords are not matched");
			}
			
		}	
		
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the cfrmpassword
	 */
	public String getCfrmpassword() {
		return cfrmpassword;
	}

	/**
	 * @param cfrmpassword the cfrmpassword to set
	 */
	public void setCfrmpassword(String cfrmpassword) {
		this.cfrmpassword = cfrmpassword;
	}

}
