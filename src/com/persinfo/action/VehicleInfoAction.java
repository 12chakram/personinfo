/**
 * 
 */
package com.persinfo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.google.appengine.api.datastore.Text;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.VehicleInfoDAO;
import com.persinfo.data.BasicInfo;
import com.persinfo.data.BirthDetails;
import com.persinfo.data.DrivingLicense;
import com.persinfo.data.EducationDetails;
import com.persinfo.data.ProfessionalInfo;
import com.persinfo.data.User;
import com.persinfo.data.Vehicle;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class VehicleInfoAction extends ActionSupport{
	
	private DrivingLicense dlicense;
	private Vehicle vehicle1;
	private Vehicle vehicle2;
	private Vehicle vehicle3;
	private List<String> insCompanies;
	private boolean update;
	private String action;
	
	public VehicleInfoAction(){
		insCompanies = new ArrayList<String>();
		insCompanies.add("AIG Life Insurance Company Limited");
		insCompanies.add("Aviva Life Insurance Co. India Pvt. Ltd");
		insCompanies.add("Allianz Life Insurance Company Ltd");
		insCompanies.add("AEGON Religare Life Insurance Company Ltd");
		insCompanies.add("Bharti AXA Life Insurance Company Ltd");
		insCompanies.add("Birla Sun Life Insurance Co. Ltd");
		insCompanies.add("HSBC Oriental Bank of Commerce Life Insurance Co. Ltd");
		insCompanies.add("DLF Pramerica Life Insurance Co. Ltd");
		insCompanies.add("Future Generali Life Insurance Company Ltd");
		insCompanies.add("HDFC Standard Life Insurance Company Limited");
		insCompanies.add("Prudential Life Insurance Company Limited");
		insCompanies.add("ING Vysya Life Insurance Company Limited");
		insCompanies.add("IDBI Fortis Life Insurance");
		insCompanies.add("Kotak Mahindra");
		insCompanies.add("Life Insurance Corporation");
		insCompanies.add("Max New York");
		insCompanies.add("Met Life");
		insCompanies.add("SBI Life");
		insCompanies.add("Reliance Life Insurance");
		insCompanies.add("Sahara India");
		insCompanies.add("Shriram Life");
		insCompanies.add("Star Union Dai-Ichi Life");
		insCompanies.add("Star Health");
		insCompanies.add("Other");
		
	}
	
	VehicleInfoDAO dao = new VehicleInfoDAO();
	

	@Action(value = "/vehicleinfo", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showPersonalInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			long uid = ((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId();
			VehicleInfoDAO dao = new VehicleInfoDAO();
			dlicense = dao.retrieveDrivingLicneseByUserId(Long.toString(uid));
			vehicle1 = dao.retrieveVehicleByUserIdAndSequence(Long.toString(uid), "vehicle1");
			vehicle2 = dao.retrieveVehicleByUserIdAndSequence(Long.toString(uid), "vehicle2");
			vehicle3 = dao.retrieveVehicleByUserIdAndSequence(Long.toString(uid), "vehicle3");
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/addDrivingLicense", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
	public String addDrivingLicense(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				dlicense.setUid(uid);
				dao.addDrivingLicense(dlicense);
			}
			populateOtherSections(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateDrivingLicense", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
	public String updateDrivingLicense(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				dlicense.setUid(uid);
				dao.updateDrivingLicense(dlicense);
			}
			populateOtherSections(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/addVehicle", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
	public String addVehicle(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				if(vehicle1 != null){
					vehicle1.setUid(uid);
					vehicle1.setDocType("vehicle1");
					dao.addVehicle(vehicle1);
				}else if(vehicle2 != null){
					vehicle2.setUid(uid);
					vehicle2.setDocType("vehicle2");
					dao.addVehicle(vehicle2);
				}else if(vehicle3 != null){
					vehicle3.setUid(uid);
					vehicle3.setDocType("vehicle3");
					dao.addVehicle(vehicle3);
				}
			}
			populateOtherSections(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateVehicle", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
	public String updateVehicle(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				if(vehicle1 != null){
					vehicle1.setUid(uid);
					vehicle1.setDocType("vehicle1");
					dao.updateVehicle(vehicle1);
				}else if(vehicle2 != null){
					vehicle2.setUid(uid);
					vehicle2.setDocType("vehicle2");
					dao.updateVehicle(vehicle2);
				}else if(vehicle3 != null){
					vehicle3.setUid(uid);
					vehicle3.setDocType("vehicle3");
					dao.updateVehicle(vehicle3);
				}
			}
			populateOtherSections(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
//	@Action(value = "/addVehicleTwo", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
//	public String addVehicleTwo(){
//		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
//			validate();
//			if(!hasFieldErrors())
//				dao.addVehicle(vehicle2);
//			return SUCCESS;
//		}else
//			return "redirect";
//	}
//	
//	@Action(value = "/updateVehicleTwo", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
//	public String updateVehicleTwo(){
//		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
//			validate();
//			if(!hasFieldErrors())
//				dao.updateVehicle(vehicle2);
//			return SUCCESS;
//		}else
//			return "redirect";
//	}
//
//	
//	
//	@Action(value = "/addVehicleThree", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
//	public String addVehicleThree(){
//		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
//			validate();
//			if(!hasFieldErrors())
//				dao.addVehicle(vehicle3);
//			return SUCCESS;
//		}else
//			return "redirect";
//	}
//	
//	@Action(value = "/updateVehicleThree", results = {@Result(name = "success", location = "persinfo/vehicleinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/vehicleinfo.jsp")}) 
//	public String updateVehicleThree(){
//		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
//			validate();
//			if(!hasFieldErrors())
//				dao.updateVehicle(vehicle3);
//			return SUCCESS;
//		}else
//			return "redirect";
//	}
	
	
	public void validate() {
		Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		if(dlicense != null){
			if(dlicense.getIssuedAuth().trim().equals("") && dlicense.getValidFrm().trim().equals("") && dlicense.getValidTo().trim().equals("") 
					&& dlicense.getLicenseNo().trim().equals("") && (dlicense.getDlDoc() == null || dlicense.getDlDoc().trim().equals("")))
					addFieldError("", "Atleast one field must be entered to proceed");
			if((!dlicense.getValidFrm().trim().equals("")&& dlicense.getValidTo().trim().equals("")) || (dlicense.getValidFrm().trim().equals("")&& !dlicense.getValidTo().trim().equals(""))){
				addFieldError("", "Both from and to dates must be entered");
			}
			if(!dlicense.getValidFrm().trim().equals("") && !date.matcher(dlicense.getValidFrm()).matches())
				addFieldError("", "Please enter a valid date for From date field");
			if(!dlicense.getValidTo().trim().equals("") && !date.matcher(dlicense.getValidTo()).matches())
				addFieldError("", "Please enter a valid date for To date field");
		}else if(vehicle1 != null){
			validateVehcile(vehicle1);
		}else if(vehicle2 != null){
			validateVehcile(vehicle2);
		}else if(vehicle3 != null){
			validateVehcile(vehicle3);
		}
		
	}
	
	private void validateVehcile(Vehicle vehicle){
		Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Pattern year = Pattern.compile("[1-2][0-9]{3}");
		if(vehicle.getOwner().trim().equals("") && vehicle.getMake().trim().equals("") && vehicle.getRegNo().trim().equals("")
				&& vehicle.getEngNo().trim().equals("") && vehicle.getInsComp().trim().equals("") && vehicle.getInsNo().trim().equals("")
				&& vehicle.getValidity().trim().equals("")	&& vehicle.getRenwlDate().trim().equals("") && (vehicle.getRcDoc() == null || vehicle.getRcDoc().trim().equals("")))
			addFieldError("", "Atleast one field must be entered to proceed");
		if(vehicle.getMake().trim().equals(""))
			addFieldError("", "You must enter Vehicle Make and Model to proceed");
		if(!vehicle.getValidity().trim().equals("") && !year.matcher(vehicle.getValidity()).matches())
			addFieldError("", "Please enter a valid year for Validtiy field");
		if(!vehicle.getRenwlDate().trim().equals("") && !date.matcher(vehicle.getRenwlDate()).matches())
			addFieldError("", "Please enter a valid date for Renewal Date field");
	}

	private void populateOtherSections(String uid){
		if(dlicense != null){
			vehicle1 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle1");
			vehicle2 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle2");
			vehicle3 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle3");
			action = "DrivingLicense";
		}else if(vehicle1 != null){
			dlicense = dao.retrieveDrivingLicneseByUserId(uid);
			vehicle2 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle2");
			vehicle3 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle3");
			action = "VehicleOne";
		}else if(vehicle2 != null){
			dlicense = dao.retrieveDrivingLicneseByUserId(uid);
			vehicle1 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle1");
			vehicle3 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle3");
			action = "VehicleTwo";
		}else if(vehicle3 != null){
			dlicense = dao.retrieveDrivingLicneseByUserId(uid);
			vehicle1 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle1");
			vehicle2 = dao.retrieveVehicleByUserIdAndSequence(uid, "vehicle2");
			action = "VehicleThree";
		}
		if(hasFieldErrors())if(ActionContext.getContext().getName().contains("update")) update = true;
		
	}


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
	 * @return the vehicle1
	 */
	public Vehicle getVehicle1() {
		return vehicle1;
	}

	/**
	 * @param vehicle1 the vehicle1 to set
	 */
	public void setVehicle1(Vehicle vehicle1) {
		this.vehicle1 = vehicle1;
	}

	/**
	 * @return the vehicle2
	 */
	public Vehicle getVehicle2() {
		return vehicle2;
	}

	/**
	 * @param vehicle2 the vehicle2 to set
	 */
	public void setVehicle2(Vehicle vehicle2) {
		this.vehicle2 = vehicle2;
	}

	/**
	 * @return the vehicle3
	 */
	public Vehicle getVehicle3() {
		return vehicle3;
	}

	/**
	 * @param vehicle3 the vehicle3 to set
	 */
	public void setVehicle3(Vehicle vehicle3) {
		this.vehicle3 = vehicle3;
	}

	/**
	 * @return the update
	 */
	public boolean isUpdate() {
		return update;
	}

	/**
	 * @param update the update to set
	 */
	public void setUpdate(boolean update) {
		this.update = update;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the insCompanies
	 */
	public List<String> getInsCompanies() {
		return insCompanies;
	}

	/**
	 * @param insCompanies the insCompanies to set
	 */
	public void setInsCompanies(List<String> insCompanies) {
		this.insCompanies = insCompanies;
	}
}
