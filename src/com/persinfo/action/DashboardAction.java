/**
 * 
 */
package com.persinfo.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.ImportantDocsDAO;
import com.persinfo.dao.InsuranceDocsDAO;
import com.persinfo.dao.MessageDAO;
import com.persinfo.dao.VehicleInfoDAO;
import com.persinfo.data.ImportantDoc;
import com.persinfo.data.InsuranceDoc;
import com.persinfo.data.Message;
import com.persinfo.data.User;
import com.persinfo.data.Vehicle;
import com.persinfo.vo.UserVO;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class DashboardAction extends ActionSupport {
	private UserVO user;
	private List<Message> msgs;
	private List<Vehicle> vehicles;
	private List<InsuranceDoc> insdocs;
	private List<ImportantDoc> impdocs;
	
	@Action(value = "/dashboard", results = {@Result(name = "success", location = "persinfo/dashboard.jsp"),  @Result(name = "redirect", location="index.jsp", type="redirect")})
	public String showDashboard(){
		
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			User u = (User) ServletActionContext.getRequest().getSession().getValue("user");
			String uid = Long.toString(u.getKey().getId());
			user = new UserVO();
			MessageDAO mdao = new MessageDAO();
			VehicleInfoDAO vdao = new VehicleInfoDAO();
			InsuranceDocsDAO idao = new InsuranceDocsDAO();
			ImportantDocsDAO impdao = new ImportantDocsDAO();
			user.setFname(u.getFname());
			user.setLname(u.getLname());
			user.setEmail(u.getEmail());
			user.setUname(u.getUname());
			user.setAddress(u.getAddress());
			msgs = mdao.retrieveMessagesByUserId(uid);
			vehicles = vdao.retrieveAllVehiclesByUserId(uid);
			insdocs = idao.retrieveAllInsuranceDocsByUserId(uid);
			impdocs = impdao.retrieveAllImportantDocs(uid);
			if(impdocs != null)
				for(ImportantDoc idoc:impdocs){
					char[] stringArray = idoc.getDocType().toCharArray();
					stringArray[0] = Character.toUpperCase(stringArray[0]);
					idoc.setDocType(new String(stringArray));
				}
			return SUCCESS;
		}	
		else{
			return "redirect";
		}
	}
	
	@Action(value = "/showmessage", results = {@Result(name = "success", location = "persinfo/message.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")})
	public String showMessage(){
		
		User u = (User) ServletActionContext.getRequest().getSession().getValue("user");
		if(u !=null ){
			user = new UserVO();
			user.setFname(u.getFname());
			user.setLname(u.getLname());
			user.setEmail(u.getEmail());
			user.setUname(u.getUname());
			user.setAddress(u.getAddress());
			return SUCCESS;
		}	
		else{
			return "redirect";
		}
	}
	
	/**
	 * @return the user
	 */
	public UserVO getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserVO user) {
		this.user = user;
	}

	/**
	 * @return the vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * @param vehicles the vehicles to set
	 */
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	/**
	 * @return the msgs
	 */
	public List<Message> getMsgs() {
		return msgs;
	}

	/**
	 * @param msgs the msgs to set
	 */
	public void setMsgs(List<Message> msgs) {
		this.msgs = msgs;
	}

	/**
	 * @return the insdocs
	 */
	public List<InsuranceDoc> getInsdocs() {
		return insdocs;
	}

	/**
	 * @param insdocs the insdocs to set
	 */
	public void setInsdocs(List<InsuranceDoc> insdocs) {
		this.insdocs = insdocs;
	}

	/**
	 * @return the impdocs
	 */
	public List<ImportantDoc> getImpdocs() {
		return impdocs;
	}

	/**
	 * @param impdocs the impdocs to set
	 */
	public void setImpdocs(List<ImportantDoc> impdocs) {
		this.impdocs = impdocs;
	}

}
