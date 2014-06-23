/**
 * 
 */
package com.persinfo.action;

import java.sql.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.persinfo.dao.MessageDAO;
import com.persinfo.dao.ReminderEMailsDAO;
import com.persinfo.dao.UserDAO;
import com.persinfo.data.InsuranceDoc;
import com.persinfo.data.Message;
import com.persinfo.data.User;
import com.persinfo.data.Vehicle;
import com.persinfo.utilities.DateUtility;
import com.persinfo.utilities.MailService;

/**
 * @author deva
 *
 */
public class ReminderEMailsAction {
	
	@Action(value = "/reminderemail", results = {@Result(name = "success", location = "persinfo/confidentialdocs.jsp"), @Result(name = "redirect", location="index.jsp", type="redirect")}) 
	public String sendReminderEmail(){
		ReminderEMailsDAO dao = new ReminderEMailsDAO();
		UserDAO udao= new UserDAO();
		MessageDAO mdao = new MessageDAO();
		Message m = null;
		String sub = "Reminder For Policy Renewal - 15 days to go!!";
		List<User> us = udao.retrieveAllActiveUsers();
		List<InsuranceDoc> insDocs = dao.retrievePoliciesForReminder (DateUtility.getDateAsString(16));
		for(InsuranceDoc idoc: insDocs){
			for(User u:us){
				if(u.getKey().getId() == Long.parseLong(idoc.getUid())){
					StringBuffer msgBody = new StringBuffer("Your policy # ").append(idoc.getPolNo()).append(" is going to be lapsed in 15 days.")
											.append("The following are the details for the same.\n\n     Policy #: ").append(idoc.getPolNo()).append("\n     Policy Name: ")
											.append(idoc.getPolName()).append("\n     Policy Company: ").append(idoc.getPolComp()).append("\n     Date Of Renewal:")
											.append(idoc.getDateOfRnwl()).append("\n\nPlease renew it as soon as possible.\n\n Yours!!\n PteCloud Admin");
					MailService.sendEmail(sub, msgBody.toString(), u.getEmail(), u.getFname());
					m = new Message();
					m.setSubject(sub);
					m.setMsg(msgBody.toString());
					m.setUid(idoc.getUid());
					
					m.setMsgDate(new Date(new java.util.Date().getTime()));
					mdao.addMessage(m);
					break;
				}	
			}
			
		}
		
		insDocs = dao.retrievePoliciesForReminder(DateUtility.getDateAsString(4));
		sub = "Reminder For Policy Renewal - 3 days to go!!";
		for(InsuranceDoc idoc: insDocs){
			for(User u:us){
				if(u.getKey().getId() == Long.parseLong(idoc.getUid())){
					StringBuffer msgBody = new StringBuffer("Your policy # ").append(idoc.getPolNo()).append(" is going to be lapsed in 15 days.")
											.append("The following are the details for the same.\n\n     Policy #: ").append(idoc.getPolNo()).append("\n     Policy Name: ")
											.append(idoc.getPolName()).append("\n     Policy Company: ").append(idoc.getPolComp()).append("\n     Date Of Renewal:")
											.append(idoc.getDateOfRnwl()).append("\n\nPlease renew it as soon as possible.\n\n Yours!!\n PteCloud Admin");
					MailService.sendEmail(sub, msgBody.toString(), u.getEmail(), u.getFname());
					m = new Message();
					m.setSubject(sub);
					m.setMsg(msgBody.toString());
					m.setUid(idoc.getUid());
					m.setMsgDate(new Date(new java.util.Date().getTime()));
					mdao.addMessage(m);
					break;
				}	
			}
			
		}
		
		List<Vehicle> vs = dao.retrieveVehiclePoliciesForReminder(DateUtility.getDateAsString(16));
		sub = "Reminder For Vehicle Insurance Renewal - 15 days to go!!";
		for(Vehicle ve: vs){
			for(User u:us){
				if(u.getKey().getId() == Long.parseLong(ve.getUid())){
					StringBuffer msgBody = new StringBuffer("Your vehicle insurance # ").append(ve.getInsNo()).append(" is going to be expired in 15 days.")
											.append("The following are the details for the same.\n\n     Insurance #: ").append(ve.getInsNo())
											.append("\n     Insurance Company: ").append(ve.getInsComp()).append("\n     Date Of Renewal:")
											.append(ve.getRenwlDate()).append("\n\nPlease renew it as soon as possible.\n\n Yours!!\n PteCloud Admin");
					MailService.sendEmail(sub, msgBody.toString(), u.getEmail(), u.getFname());
					m = new Message();
					m.setSubject(sub);
					m.setMsg(msgBody.toString());
					m.setUid(ve.getUid());
					m.setMsgDate(new Date(new java.util.Date().getTime()));
					mdao.addMessage(m);
					break;
				}	
			}
			
		}
		
		vs = dao.retrieveVehiclePoliciesForReminder(DateUtility.getDateAsString(4));
		sub = "Reminder For Vehicle Insurance Renewal - 3 days to go!!";
		for(Vehicle ve: vs){
			for(User u:us){
				if(u.getKey().getId() == Long.parseLong(ve.getUid())){
					StringBuffer msgBody = new StringBuffer("Your vehicle insurance # ").append(ve.getInsNo()).append(" is going to be expired in 15 days.")
											.append("The following are the details for the same.\n\n     Insurance #: ").append(ve.getInsNo())
											.append("\n     Insurance Company: ").append(ve.getInsComp()).append("\n     Date Of Renewal:")
											.append(ve.getRenwlDate()).append("\n\nPlease renew it as soon as possible.\n\n Yours!!\n PteCloud Admin");
					MailService.sendEmail(sub, msgBody.toString(), u.getEmail(), u.getFname());
					m = new Message();
					m.setSubject(sub);
					m.setMsg(msgBody.toString());
					m.setUid(ve.getUid());
					m.setMsgDate(new Date(new java.util.Date().getTime()));
					mdao.addMessage(m);
					break;
				}	
			}
			
		}
		
		return null;
	}

}
