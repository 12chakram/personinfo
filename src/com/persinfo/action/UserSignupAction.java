/**
 * 
 */
package com.persinfo.action;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;
import com.persinfo.dao.UserDAO;
import com.persinfo.data.User;
import com.persinfo.utilities.MailService;
import com.persinfo.vo.UserSignupVO;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

/**
 * @author deva
 *
 */
@ResultPath(value="/")
public class UserSignupAction extends ActionSupport{

	private UserSignupVO signupVO;
	private String uname;
	private String email;

	@Action(value = "/register", results = {@Result(name = "success", location = "persinfo/emailactivation.jsp"), @Result(name = "input", location="persinfo/registration.jsp")}) 
	public String registerUser(){
		
		if(signupVO == null)return INPUT;
		
//		User u = dao.retrieveUserByUserName(signupVO.getUname());
//		if(u != null){
//			addFieldError("signupVO.uname", "User name already exist");
//			return "redirect";
//		}
		User u = new User();
		u.setFname(signupVO.getFname());
		u.setLname(signupVO.getLname());
		u.setAddress(signupVO.getAddress());
		u.setEmail(signupVO.getEmail());
		u.setPhno(signupVO.getPhno());
		u.setCompany(signupVO.getCompany());
		u.setUname(signupVO.getUname());
		u.setPassword(signupVO.getPassword());
		u.setSource(signupVO.getSource());
		u.setAgreed(signupVO.isAgreed());
		u.setActive(true);
		new UserDAO().addUser(u);
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		String uri = ServletActionContext.getRequest().getRequestURI();
		String root = url.substring( 0, url.indexOf(uri) );
		// String msgBody = "Please click on the below link to activate your account with "+ root+ "\n\n" + root + "/persinfo/activate?uname=" + u.getUname() + "\n\n\nYours\nPteCloud Admin";
		String msgBody = "Hi\n\n   Welcome to PteCloud - Anytime, Anywhere Make Cloud Private" +
				"\n\n   Your account with PteCloud is created just now!!! You can start exploring it now at "+ root+ "\n\nThe following are the details for your account.\n\n\tUsername: " + u.getUname() + "\n\tPassword: "+ u.getPassword() + "\n\n\nYours\nPteCloud Admin";
		MailService.sendEmail("Welcome to PteCloud", msgBody, signupVO.getEmail().trim(), signupVO.getFname().trim());
		 return SUCCESS;
	}
	
	public void validate() {
		
		UserDAO dao = new UserDAO();
	    Pattern email = Pattern.compile(".+@.+\\.[a-z]+");
		Pattern phno = Pattern.compile("\\d{10}");
		if(signupVO != null){
			if(signupVO.getAddress().trim().equals("") ||signupVO.getFname().trim().equals("")||signupVO.getLname().trim().equals("")||signupVO.getEmail().trim().equals("")
						|| signupVO.getPhno().trim().equals("") ||signupVO.getCompany().trim().equals("")||signupVO.getUname().trim().equals("")||signupVO.getPassword().trim().equals(""))
					addFieldError("", "All fields are required to proceed with registration");
			if(!signupVO.getUname().trim().equals("")){
				if (signupVO.getUname().length() < 4 || signupVO.getUname().length() > 15){
					addFieldError("uname", "User name length must be minimum 4 and maximum 15 characters");
				}else if (dao.retrieveUserByUserName(signupVO.getUname()) != null){
					addFieldError("unamea", "User name is already exist");
				}
			}
			if(!signupVO.getEmail().trim().equals("")){
			    Matcher m = email.matcher(signupVO.getEmail());
			    if (!m.matches())
			    	  addFieldError("emailv", "Email must be in valid formate");
				if(dao.retrieveUserByEmail(signupVO.getEmail()) != null)
					addFieldError("email", "Email is already exist");
			}
			if(!signupVO.getPhno().trim().equals("") && !phno.matcher(signupVO.getPhno()).matches())
				addFieldError("", "Phone number must be a valid 10 digit number");
			
			if(!signupVO.getPassword().trim().equals("")){
				if(signupVO.getPassword().length() < 6)
					addFieldError("password", "Password length must be minumum 6 characters");
				else if(!signupVO.getPassword().equals(signupVO.getCfrmpassword()))
					addFieldError("password", "Passwords are not matched");
			}
			if(!signupVO.isAgreed())
				addFieldError("agreed", "Please read and agree the terms and  conditions");
			HttpServletRequest request = ServletActionContext.getRequest();
			String remoteAddr = request.getRemoteAddr();
	        ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
	        reCaptcha.setPrivateKey("6LcpTcwSAAAAAIJFE8z79GUiJxfGvVM-Ai_sa54W");

	        String challenge = request.getParameter("recaptcha_challenge_field");
	        String uresponse = request.getParameter("recaptcha_response_field");
	        ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

	        if (!reCaptchaResponse.isValid()) {
	        	addFieldError("", "Are you human? If yes, please enter exact letters that are present on the captcha image");
	        }
		}	
		
	}
	
	@Action(value = "/activate", results = {@Result(name = "success", location = "persinfo/emailactivation.jsp"), @Result(name = "redirect", location="registration.jsp", type="redirect")}) 
	public String activateUser(){
		
		UserDAO dao = new UserDAO();
		String url = ServletActionContext.getRequest().getRequestURL().toString();
		String uri = ServletActionContext.getRequest().getRequestURI();
		String root = url.substring( 0, url.indexOf(uri) );
		User u = dao.retrieveUserByUserName(getUname());
		if(u == null)return "redirect";
		String email = u.getEmail();
		String name = u.getFname();
		new UserDAO().updateUser(u);
		String msgBody = "Your account with PteCloud is activated, You can start exploring it now at "+ root+ "\n\nThe following are the details for your account.\n\n\tUsername: " + u.getUname() + "\n\tPassword: "+ u.getPassword() + "\n\n\nYours\nPteCloud Admin";
		MailService.sendEmail("Your PteCloud Account Is Activated", msgBody, email, name);
		return SUCCESS;
	}
	
	@Action(value = "findpassword", results = {@Result(name = "success", location = "persinfo/sendpassword.jsp"), @Result(name = "input", location="persinfo/forgotpassword.jsp")}) 
	public String sendPassword(){
		
		UserDAO dao = new UserDAO();
		User u = dao.retrievePasswordByUsernameOrEmail(getUname());
		if(u == null){
			Pattern email = Pattern.compile(".+@.+\\.[a-z]+");
			Matcher m = email.matcher(getUname());
			String msg = (!m.matches())? "username":"emailid";
			addFieldError("", "There is no record exist in our system with this "+ msg);
			return "input";
		}
		String email = u.getEmail();
		String name = u.getFname();
		this.email = email;
		new UserDAO().updateUser(u);
		String msgBody = "Hi\n\n Thank you for using PteCloud forgot password service.\n\nThe following are the details for your account.\n\n\tUsername: " + u.getUname() + "\n\tPassword: "+ u.getPassword() + "\n\n\nYours\nPteCloud Admin";
		MailService.sendEmail("PteCloud Account Details", msgBody, email, name);
		return SUCCESS;
	}
	
//	@Action(value = "/_ah/*", results = {@Result(name = "success", location = "persinfo/registration_thankyou.jsp"), @Result(name = "redirect", location="registration.jsp", type="redirect")}) 
//	public void forwardReq() throws Exception{
//		
//		ServletActionContext.getRequest().getRequestDispatcher("_ah/admin").forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
//	}
	
	
	/**
	 * @return the signupVO
	 */
	public UserSignupVO getSignupVO() {
		return signupVO;
	}

	/**
	 * @param signupVO the signupVO to set
	 */
	public void setSignupVO(UserSignupVO signupVO) {
		this.signupVO = signupVO;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
