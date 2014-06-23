/**
 * 
 */
package com.persinfo.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.MemorableDaysDAO;
import com.persinfo.data.ImportantDays;
import com.persinfo.data.MostMemorableDays;
import com.persinfo.data.User;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class MemorableDaysAction extends ActionSupport{
	
	private MostMemorableDays memDays;
	private ImportantDays impDays;

	@Action(value = "/memorabledays", results = {@Result(name = "success", location = "persinfo/memorabledays.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showMemorableDays(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			MemorableDaysDAO dao = new MemorableDaysDAO();
			memDays = dao.retrieveMostMemorableDaysByUserId(uid);
			impDays = dao.retrieveImportantDaysByUserIdAndSequence(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/addMostMemDays", results = {@Result(name = "success", location = "persinfo/memorabledays.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String addMostMemDays(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			long uid = ((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId();
			MemorableDaysDAO dao = new MemorableDaysDAO();
			memDays.setUid(Long.toString(uid));
			dao.addMostMemorableDays(memDays);
			impDays = dao.retrieveImportantDaysByUserIdAndSequence(Long.toString(uid));
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/addImpDays", results = {@Result(name = "success", location = "persinfo/memorabledays.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String addImpDays(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			long uid = ((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId();
			MemorableDaysDAO dao = new MemorableDaysDAO();
			impDays.setUid(Long.toString(uid));
			dao.addImportantDays(impDays);
			memDays = dao.retrieveMostMemorableDaysByUserId(Long.toString(uid));
			return SUCCESS;
		}else
			return "redirect";
	}

	/**
	 * @return the memDays
	 */
	public MostMemorableDays getMemDays() {
		return memDays;
	}

	/**
	 * @param memDays the memDays to set
	 */
	public void setMemDays(MostMemorableDays memDays) {
		this.memDays = memDays;
	}

	/**
	 * @return the impDays
	 */
	public ImportantDays getImpDays() {
		return impDays;
	}

	/**
	 * @param impDays the impDays to set
	 */
	public void setImpDays(ImportantDays impDays) {
		this.impDays = impDays;
	}
}
