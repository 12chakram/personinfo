/**
 * 
 */
package com.persinfo.action;

import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.google.appengine.api.datastore.Text;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.ImportantDocsDAO;
import com.persinfo.dao.MemorableDaysDAO;
import com.persinfo.data.BasicInfo;
import com.persinfo.data.BirthDetails;
import com.persinfo.data.EducationDetails;
import com.persinfo.data.ImportantDoc;
import com.persinfo.data.ProfessionalInfo;
import com.persinfo.data.User;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class ImportantDocsAction extends ActionSupport{
	
	private ImportantDoc voterId;
	private ImportantDoc passport;
	private ImportantDoc pancard;
	private ImportantDoc otherimp;
	private boolean update;
	private String action;
	ImportantDocsDAO dao = new ImportantDocsDAO();

	@Action(value = "/importantdocs", results = {@Result(name = "success", location = "persinfo/importantdocs.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showImportantDocs(){
		//SessionTracker.getInstance().add(ServletActionContext.getRequest().getSession().getId());
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			ImportantDocsDAO dao = new ImportantDocsDAO();
			voterId = dao.retrieveImportantDocByUserIdAndType(uid, "voterid");
			passport = dao.retrieveImportantDocByUserIdAndType(uid, "passport");
			pancard = dao.retrieveImportantDocByUserIdAndType(uid, "pancard");
			otherimp = dao.retrieveImportantDocByUserIdAndType(uid, "otherimp");
			return SUCCESS;
		}else
			return "redirect";
	}
	 
	public String addImportantDoc(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				if(voterId != null){
					voterId.setUid(uid);
					voterId.setDocType("voterid");
					dao.addImportantDoc(voterId);
				}else if(passport != null){
					passport.setUid(uid);
					passport.setDocType("passport");
					dao.addImportantDoc(passport);
				}else if(pancard != null){
					pancard.setUid(uid);
					pancard.setDocType("pancard");
					dao.addImportantDoc(pancard);
				}else if(otherimp != null){
					otherimp.setUid(uid);
					otherimp.setDocType("otherimp");
					dao.addImportantDoc(otherimp);
				}
			}
			populateOtherSections(uid);
			return "success";
		}else
			return "redirect";
	}
	
	public String updateImportantDoc(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			validate();
			if(!hasFieldErrors()){
				if(voterId != null){
					voterId.setUid(uid);
					voterId.setDocType("voterid");
					voterId = dao.updateImportantDoc(voterId);
				}else if(passport != null){
					passport.setUid(uid);
					passport.setDocType("passport");
					passport = dao.updateImportantDoc(passport);
				}else if(pancard != null){
					pancard.setUid(uid);
					pancard.setDocType("pancard");
					pancard = dao.updateImportantDoc(pancard);
				}else if(otherimp != null){
					otherimp.setUid(uid);
					otherimp.setDocType("otherimp");
					otherimp = dao.updateImportantDoc(otherimp);
				}
			}
			populateOtherSections(uid);
			return "success";
		}else
			return "redirect";
	}
	
	public void validate() {
		Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		if(voterId != null){
			if(voterId.getIdNo().trim().equals("") && voterId.getDateOfIssue().trim().equals("") && voterId.getPlaceOfIssue().trim().equals("")
					&& voterId.getCountry().trim().equals("")&& voterId.getRefSrlNo().trim().equals("") && (voterId.getDocCopy() == null || voterId.getDocCopy().trim().equals("")))
					addFieldError("", "Atleast one field must be entered to proceed");
			if(!voterId.getDateOfIssue().trim().equals("") && !date.matcher(voterId.getDateOfIssue()).matches())
				addFieldError("", "Please enter a valid date for date of issue");
			if(voterId.getIdNo().trim().equals("")){
				addFieldError("", "You must enter Voter ID No. to proceed");
			}
		}else if(passport != null){
			if(passport.getIdNo().trim().equals("") && passport.getDateOfIssue().trim().equals("") && passport.getPlaceOfIssue().trim().equals("")
					&& passport.getCountry().trim().equals("")&& passport.getRefSrlNo().trim().equals("") && (passport.getDocCopy() == null || passport.getDocCopy().trim().equals("")))
					addFieldError("", "Atleast one field must be entered to proceed");
			if(!passport.getDateOfIssue().trim().equals("") && !date.matcher(passport.getDateOfIssue()).matches())
				addFieldError("", "Please enter a valid date for date of issue");
			if(passport.getIdNo().trim().equals("")){
				addFieldError("", "You must enter Passport No. to proceed");
			}
		}else if(pancard != null){
			if(pancard.getIdNo().trim().equals("") && pancard.getDateOfIssue().trim().equals("") && pancard.getPlaceOfIssue().trim().equals("")
					&& pancard.getCountry().trim().equals("")&& pancard.getRefSrlNo().trim().equals("") && (pancard.getDocCopy() == null || pancard.getDocCopy().trim().equals("")))
					addFieldError("", "Atleast one field must be entered to proceed");
			if(!pancard.getDateOfIssue().trim().equals("") && !date.matcher(pancard.getDateOfIssue()).matches())
				addFieldError("", "Please enter a valid date for date of issue");
			if(pancard.getIdNo().trim().equals("")){
				addFieldError("", "You must enter PAN Card No. to proceed");
			}
		}else if(otherimp != null){
			if(otherimp.getIdNo().trim().equals("") && otherimp.getDateOfIssue().trim().equals("") && otherimp.getPlaceOfIssue().trim().equals("")
					&& otherimp.getCountry().trim().equals("")&& otherimp.getRefSrlNo().trim().equals("") && (otherimp.getDocCopy() == null || otherimp.getDocCopy().trim().equals("")))
					addFieldError("", "Atleast one field must be entered to proceed");
			if(otherimp.getIdNo().trim().equals("")){
				addFieldError("", "You must enter Other Doc Type & No. to proceed");
			}
			if(!otherimp.getDateOfIssue().trim().equals("") && !date.matcher(otherimp.getDateOfIssue()).matches())
				addFieldError("", "Please enter a valid date for date of issue");
		}
		
	}

	private void populateOtherSections(String uid){
		if(voterId != null){
			passport = dao.retrieveImportantDocByUserIdAndType(uid, "passport");
			pancard = dao.retrieveImportantDocByUserIdAndType(uid, "pancard");
			otherimp = dao.retrieveImportantDocByUserIdAndType(uid, "otherimp");
			action = "voterId";
		}else if(passport != null){
			voterId = dao.retrieveImportantDocByUserIdAndType(uid, "voterid");
			pancard = dao.retrieveImportantDocByUserIdAndType(uid, "pancard");
			otherimp = dao.retrieveImportantDocByUserIdAndType(uid, "otherimp");
			action = "passport";
		}else if(pancard != null){
			voterId = dao.retrieveImportantDocByUserIdAndType(uid, "voterid");
			passport = dao.retrieveImportantDocByUserIdAndType(uid, "passport");
			otherimp = dao.retrieveImportantDocByUserIdAndType(uid, "otherimp");
			action = "pancard";
		}else if(otherimp != null){
			voterId = dao.retrieveImportantDocByUserIdAndType(uid, "voterid");
			passport = dao.retrieveImportantDocByUserIdAndType(uid, "passport");
			pancard = dao.retrieveImportantDocByUserIdAndType(uid, "pancard");
			action = "otherimp";
		}
		if(hasFieldErrors())if(ActionContext.getContext().getName().contains("update")) update = true;
		
	}

	/**
	 * @return the voterId
	 */
	public ImportantDoc getVoterId() {
		return voterId;
	}

	/**
	 * @param voterId the voterId to set
	 */
	public void setVoterId(ImportantDoc voterId) {
		this.voterId = voterId;
	}

	/**
	 * @return the passport
	 */
	public ImportantDoc getPassport() {
		return passport;
	}

	/**
	 * @param passport the passport to set
	 */
	public void setPassport(ImportantDoc passport) {
		this.passport = passport;
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
	 * @return the pancard
	 */
	public ImportantDoc getPancard() {
		return pancard;
	}

	/**
	 * @param pancard the pancard to set
	 */
	public void setPancard(ImportantDoc pancard) {
		this.pancard = pancard;
	}

	/**
	 * @return the otherimp
	 */
	public ImportantDoc getOtherimp() {
		return otherimp;
	}

	/**
	 * @param otherimp the otherimp to set
	 */
	public void setOtherimp(ImportantDoc otherimp) {
		this.otherimp = otherimp;
	}
}