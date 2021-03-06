/**
 * 
 */
package com.persinfo.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class ConfidentialDocsAction extends ActionSupport{

	@Action(value = "/confidentialdocs", results = {@Result(name = "success", location = "persinfo/confidentialdocs.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showPersonalInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			return SUCCESS;
		}else
			return "redirect";
	}
}