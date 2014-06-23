/**
 * 
 */
package com.persinfo.action;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.security.sasl.AuthenticationException;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.google.appengine.api.datastore.Text;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.persinfo.dao.ImportantDocsDAO;
import com.persinfo.dao.InsuranceDocsDAO;
import com.persinfo.dao.PersonalInfoDAO;
import com.persinfo.dao.UserDAO;
import com.persinfo.dao.VehicleInfoDAO;
import com.persinfo.data.BasicInfo;
import com.persinfo.data.BirthDetails;
import com.persinfo.data.DrivingLicense;
import com.persinfo.data.EducationDetails;
import com.persinfo.data.ImportantDoc;
import com.persinfo.data.InsuranceDoc;
import com.persinfo.data.ProfessionalInfo;
import com.persinfo.data.User;
import com.persinfo.data.Vehicle;
import com.persinfo.utilities.PteCloudUtilities;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class PersonalInfoAction extends ActionSupport{
	
	private static final long serialVersionUID = 49058332568842450L;
	private BasicInfo binfo;
	private EducationDetails eduDetails;
	private BirthDetails birthDetails;
	private ProfessionalInfo profInfo;
	private String docName;
	private InputStream stream;
	private boolean update;
	private String action;
	private PersonalInfoDAO dao = new  PersonalInfoDAO();
	
	
	@Action(value = "/personalinfo", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showPersonalInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			PersonalInfoDAO dao = new  PersonalInfoDAO();
			binfo = dao.retrieveBasicInfoByUserId(uid);
			eduDetails = dao.retrieveEducationDetailsByUserId(uid);
			birthDetails = dao.retrieveBirthDetailsByUserId(uid);
			profInfo = dao.retrieveProfInfoByUserId(uid);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/addBasicInfo", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String addBasicInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.addBasicInfo(binfo);
			return SUCCESS;
		}
		else
			return "redirect";
	}
	
	@Action(value = "/updateBasicInfo", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String updateBasicInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.updateBasicInfo(binfo);			
			return SUCCESS;
		}
		else
			return "redirect";
	}
	
	@Action(value = "/addBirthDetails", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String addBirthDetails(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.addBirthDetails(birthDetails);
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateBirthDetails", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String updateBirthDetails(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.updateBirthDetails(birthDetails);			
			return SUCCESS;
		}
		else
			return "redirect";
	}
	
	//@Action(value = "/addEduDetails", interceptorRefs = { @InterceptorRef("fileUploadStack")}, results={@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String addEduDetails(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.addEduDetails(eduDetails);			
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateEduDetails", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String updateEduDetails(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.updateEduDetails(eduDetails);			
			return SUCCESS;
		}
		else
			return "redirect";
	}
	
	@Action(value = "/addProfessionalInfo", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String addProfessionalInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.addProfessionalInfo(profInfo);
			
			return SUCCESS;
		}else
			return "redirect";
	}
	
	@Action(value = "/updateProfessionalInfo", results = {@Result(name = "success", location = "persinfo/personalinfo.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect"), @Result(name = "input", location="persinfo/personalinfo.jsp")}) 
	public String updateProfessionalInfo(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			if(!hasFieldErrors())
				dao.updateProfessionalInfo(profInfo);			
			return SUCCESS;
		}
		else
			return "redirect";
	}
	
	
	public String showDoc()throws Exception{
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			String contetnType = "";
			
			String [] file = PteCloudUtilities.retrieveAllChunksForDoc(docName, uid);
			stream = IOUtils.toInputStream(file[0],"ISO-8859-1");
			contetnType = file[1];
			
			if(contetnType.contains("image"))
				return "image";
			else if(contetnType.contains("pdf"))
				return "pdf";
			else if(contetnType.contains("msword"))
				return "msword";
			else if(contetnType.contains("ms-excel"))
				return "msexcel";
			else if(contetnType.contains("mp3"))
				return "mp3";
			else
				return "image";
		}else
			return "redirect";
	}
	
	public void validate() {
		Pattern email = Pattern.compile(".+@.+\\.[a-z]+");
		Pattern year = Pattern.compile("[1-2][0-9]{3}");
		Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		Pattern phno = Pattern.compile("\\d{10}");
		if(binfo != null){
			if(binfo.getAddress().trim().equals("") && binfo.getEmail().trim().equals("") && binfo.getFullName().trim().equals("") && binfo.getPhno().trim().equals(""))
					addFieldError("", "Atleast one field must be entered to proceed");
			if(!binfo.getPhno().trim().equals("") && !phno.matcher(binfo.getPhno()).matches())
				addFieldError("", "Phone number must be a valid 10 digit number");
			if(!binfo.getEmail().equals("")){
			    if (!email.matcher(binfo.getEmail()).matches())
			    	  addFieldError("emailv", "Email must be in valid format");
			}
			populateOtherSections(binfo);
		}else if(birthDetails != null){
			if(birthDetails.getPlaceOfBirth().trim().equals("") && birthDetails.getDob().trim().equals("") && birthDetails.getHospital().trim().equals(""))
				addFieldError("", "Atleast one field must be entered to update");
			if(!birthDetails.getDob().trim().equals("") && !date.matcher(birthDetails.getDob()).matches())
				addFieldError("", "Date Of Birth must be a valid date");
				populateOtherSections(birthDetails);
		}else if(eduDetails != null){
			if(eduDetails.getColBoard().trim().equals("") /*&& eduDetails.getColCert().trim().equals("")*/ && eduDetails.getColPassedYr().trim().equals("") && eduDetails.getColName().trim().equals("")
					 && eduDetails.getColPlace().trim().equals("") && eduDetails.getColYrOfAdmi().trim().equals("") /* && eduDetails.getDate().trim().equals("")*/ && eduDetails.getDegColName().trim().equals("")
					 /*&& eduDetails.getDegCert().trim().equals("")*/ && eduDetails.getDegPassedYr().trim().equals("") && eduDetails.getDegPlace().trim().equals("")
					 && eduDetails.getDegUniversity().trim().equals("") && eduDetails.getDegYrOfAdmi().trim().equals("") /*&& eduDetails.getSecCert().trim().equals("")*/
					 && eduDetails.getSecPlace().trim().equals("") && eduDetails.getSecSchlName().trim().equals("") && eduDetails.getSecYrOfAdmi().trim().equals(""))
				addFieldError("", "Atleast one field must be entered to proceed");
			if(!eduDetails.getSecYrOfAdmi().trim().equals("") && !year.matcher(eduDetails.getSecYrOfAdmi()).matches()){
				addFieldError("", "Please enter a valid year for secondary year of admission");
			}
			if(!eduDetails.getColYrOfAdmi().trim().equals("") && !year.matcher(eduDetails.getColYrOfAdmi()).matches()){
				addFieldError("", "Please enter a valid year for college year of admission");
			}
			if(!eduDetails.getColPassedYr().trim().equals("") && !year.matcher(eduDetails.getColPassedYr()).matches()){
				addFieldError("", "Please enter a valid year for college passed out year");
			}
			if(!eduDetails.getDegYrOfAdmi().trim().equals("") && !year.matcher(eduDetails.getDegYrOfAdmi()).matches()){
				addFieldError("", "Please enter a valid year for degree year of admission");
			}
			if(!eduDetails.getDegPassedYr().trim().equals("") && !year.matcher(eduDetails.getDegPassedYr()).matches()){
				addFieldError("", "Please enter a valid year for degree passed out year");
			}
//			if(!eduDetails.getDate().trim().equals("") && !date.matcher(eduDetails.getDate()).matches())
//					addFieldError("", "Please enter a valid date for date field");
				populateOtherSections(eduDetails);
		}else if(profInfo != null){
			if(profInfo.getFrstComp().trim().equals("") && profInfo.getFrstDesig().trim().equals("") && profInfo.getFrstDOJ().trim().equals("") /*&& profInfo.getFrstExpDoc().trim().equals("")*/
					&& profInfo.getScndComp().trim().equals("") && profInfo.getScndDesig().trim().equals("") && profInfo.getScndDOJ().trim().equals("") /*&& profInfo.getScndExpDoc().trim().equals("")*/
					&& profInfo.getThirdComp().trim().equals("") && profInfo.getThirdDesig().trim().equals("") && profInfo.getThirdDOJ().trim().equals("") )/*&& profInfo.getThirdExpDoc().trim().equals(""))*/
				addFieldError("", "Atleast one field must be entered to proceed");
			if(!profInfo.getFrstDOJ().trim().equals("") && !date.matcher(profInfo.getFrstDOJ()).matches())
				addFieldError("", "Please enter a valid date for first company DOJ");
			if(!profInfo.getScndDOJ().trim().equals("") && !date.matcher(profInfo.getScndDOJ()).matches())
				addFieldError("", "Please enter a valid date for second company DOJ");
			if(!profInfo.getThirdDOJ().trim().equals("") && !date.matcher(profInfo.getThirdDOJ()).matches())
				addFieldError("", "Please enter a valid date for third company DOJ");
				populateOtherSections(profInfo);
		}		
		
	}

	private void populateOtherSections(Object obj){
		String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
		if(obj instanceof  BasicInfo){
			binfo.setUid(uid);
			eduDetails = dao.retrieveEducationDetailsByUserId(uid);
			birthDetails = dao.retrieveBirthDetailsByUserId(uid);
			profInfo = dao.retrieveProfInfoByUserId(uid);
		}else if(obj instanceof  BirthDetails){
			birthDetails.setUid(uid);
			binfo = dao.retrieveBasicInfoByUserId(uid);
			eduDetails = dao.retrieveEducationDetailsByUserId(uid);
			profInfo = dao.retrieveProfInfoByUserId(uid);
			
		}else if(obj instanceof EducationDetails){
			eduDetails.setUid(uid);
			binfo = dao.retrieveBasicInfoByUserId(uid);
			birthDetails = dao.retrieveBirthDetailsByUserId(uid);
			profInfo = dao.retrieveProfInfoByUserId(uid);
		}else if(obj instanceof ProfessionalInfo){
			profInfo.setUid(uid);
			binfo = dao.retrieveBasicInfoByUserId(uid);
			eduDetails = dao.retrieveEducationDetailsByUserId(uid);
			birthDetails = dao.retrieveBirthDetailsByUserId(uid);
		}
		if(hasFieldErrors())if(ActionContext.getContext().getName().contains("update")) update = true;
		action = ActionContext.getContext().getName();
	}
	
	/**
	 * @return the binfo
	 */
	public BasicInfo getBinfo() {
		return binfo;
	}

	/**
	 * @param binfo the binfo to set
	 */
	public void setBinfo(BasicInfo binfo) {
		this.binfo = binfo;
	}

	/**
	 * @return the eduDetails
	 */
	public EducationDetails getEduDetails() {
		return eduDetails;
	}

	/**
	 * @param eduDetails the eduDetails to set
	 */
	public void setEduDetails(EducationDetails eduDetails) {
		this.eduDetails = eduDetails;
	}

	/**
	 * @return the birthDetails
	 */
	public BirthDetails getBirthDetails() {
		return birthDetails;
	}

	/**
	 * @param birthDetails the birthDetails to set
	 */
	public void setBirthDetails(BirthDetails birthDetails) {
		this.birthDetails = birthDetails;
	}

	/**
	 * @return the profInfo
	 */
	public ProfessionalInfo getProfInfo() {
		return profInfo;
	}

	/**
	 * @param profInfo the profInfo to set
	 */
	public void setProfInfo(ProfessionalInfo profInfo) {
		this.profInfo = profInfo;
	}

	/**
	 * @return the docName
	 */
	public String getDocName() {
		return docName;
	}

	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}

	/**
	 * @return the stream
	 */
	public InputStream getStream() {
		return stream;
	}

	/**
	 * @param stream the stream to set
	 */
	public void setStream(InputStream stream) {
		this.stream = stream;
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

}
