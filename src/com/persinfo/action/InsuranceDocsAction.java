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
import com.persinfo.dao.InsuranceDocsDAO;
import com.persinfo.data.InsuranceDoc;
import com.persinfo.data.User;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class InsuranceDocsAction extends ActionSupport{

	private InsuranceDoc pol1;
	private InsuranceDoc pol2;
	private InsuranceDoc pol3;
	private InsuranceDoc pol4;
	private List<String> insCompanies;
	private boolean update;
	private String action;
	InsuranceDocsDAO dao = new InsuranceDocsDAO();
	
	public InsuranceDocsAction(){
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
	
	@Action(value = "/insurancedocs", results = {@Result(name = "success", location = "persinfo/insurancedocs.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String showInsuranceDocs(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			pol1 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol1");
			pol2 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol2");
			pol3 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol3");
			pol4 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol4");
			return SUCCESS;
		}else
			return "redirect";
	}
	 
	public String addInsuranceDoc(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			if(!hasFieldErrors()){
				if(pol1 != null){
					pol1.setUid(uid);
					pol1.setPolDocType("pol1");
					dao.addInsuranceDoc(pol1);
				}else if(pol2 != null){
					pol2.setUid(uid);
					pol2.setPolDocType("pol2");;
					dao.addInsuranceDoc(pol2);
				}else if(pol3 != null){
					pol3.setUid(uid);
					pol3.setPolDocType("pol3");
					dao.addInsuranceDoc(pol3);
				}else if(pol4 != null){
					pol4.setUid(uid);
					pol4.setPolDocType("pol4");		
					dao.addInsuranceDoc(pol4);
				}
			}
			populateOtherSections(uid);
			return "success";
		}else
			return "redirect";
	}
	
	public String updateInsuranceDoc(){
		if(ServletActionContext.getRequest().getSession().getValue("user") != null){
			validate();
			String uid = Long.toString(((User)ServletActionContext.getRequest().getSession().getValue("user")).getKey().getId());
			if(!hasFieldErrors()){
				if(pol1 != null){
					pol1.setUid(uid);
					pol1.setPolDocType("pol1");
					pol1 = dao.updateInsuranceDoc(pol1);
				}else if(pol2 != null){
					pol2.setUid(uid);
					pol2.setPolDocType("pol2");;
					pol2 = dao.updateInsuranceDoc(pol2);
				}else if(pol3 != null){
					pol3.setUid(uid);
					pol3.setPolDocType("pol3");
					pol3 = dao.updateInsuranceDoc(pol3);
				}else if(pol4 != null){
					pol4.setUid(uid);
					pol4.setPolDocType("pol4");		
					pol4 = dao.updateInsuranceDoc(pol4);
				}
			}

			populateOtherSections(uid);
			return "success";
		}else
			return "redirect";
	}
	
	public void validate() {
		
		if(pol1 != null){
			validatePolicy(pol1);
			action = "pol1";
		}else if(pol2 != null){
			validatePolicy(pol2);
			action = "pol2";
		}else if(pol3 != null){
			validatePolicy(pol3);
			action = "pol3";
		}else if(pol4 != null){
			validatePolicy(pol4);
			action = "pol4";
		}
		
	}
	
	private void validatePolicy(InsuranceDoc pol){
		Pattern date = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
		if(pol.getPolName().trim().equals("") && pol.getDateOfPol().trim().equals("") && pol.getDateOfRnwl().trim().equals("")
				&& pol.getPolComp().trim().equals("")&& pol.getPolNomi().trim().equals("") && pol.getPolNo().trim().equals("")
				&& (pol.getPolDoc1() == null || pol.getPolDoc1().trim().equals("")) && (pol.getPolDoc2() == null || pol.getPolDoc2().trim().equals(""))
				&& (pol.getPolDoc3() == null || pol.getPolDoc3().trim().equals("")) && (pol.getPolDoc4() == null || pol.getPolDoc4().trim().equals("")))
				addFieldError("", "Atleast one field must be entered to proceed");
		if(pol.getPolName().trim().equals(""))
			addFieldError("", "You must enter Policy Name to proceed");
		if(!pol.getDateOfPol().trim().equals("") && !date.matcher(pol.getDateOfPol()).matches())
			addFieldError("", "Please enter a valid date for Date of Policy field");
		if(!pol.getDateOfRnwl().trim().equals("") && !date.matcher(pol.getDateOfRnwl()).matches())
			addFieldError("", "Please enter a valid date for Date of Renewal field");
	}

	private void populateOtherSections(String uid){
		if(pol1 != null){
			pol2 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol2");
			pol3 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol3");
			pol4 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol4");
		}else if(pol2 != null){
			pol1 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol1");
			pol3 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol3");
			pol4 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol4");
		}else if(pol3 != null){
			pol1 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol1");
			pol2 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol2");
			pol4 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol4");
		}else if(pol4 != null){
			pol1 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol1");
			pol2 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol2");
			pol3 = dao.retrieveInsuranceDocByUserIdAndType(uid, "pol3");
		}
		if(hasFieldErrors())if(ActionContext.getContext().getName().contains("update")) update = true;
		
	}

	
	/**
	 * @return the pol4
	 */
	public InsuranceDoc getPol4() {
		return pol4;
	}
	/**
	 * @param pol4 the pol4 to set
	 */
	public void setPol4(InsuranceDoc pol4) {
		this.pol4 = pol4;
	}
	/**
	 * @return the pol1
	 */
	public InsuranceDoc getPol1() {
		return pol1;
	}
	/**
	 * @param pol1 the pol1 to set
	 */
	public void setPol1(InsuranceDoc pol1) {
		this.pol1 = pol1;
	}
	/**
	 * @return the pol2
	 */
	public InsuranceDoc getPol2() {
		return pol2;
	}
	/**
	 * @param pol2 the pol2 to set
	 */
	public void setPol2(InsuranceDoc pol2) {
		this.pol2 = pol2;
	}
	/**
	 * @return the pol3
	 */
	public InsuranceDoc getPol3() {
		return pol3;
	}
	/**
	 * @param pol3 the pol3 to set
	 */
	public void setPol3(InsuranceDoc pol3) {
		this.pol3 = pol3;
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
