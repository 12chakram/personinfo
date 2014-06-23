<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>
	
	 
	<title>PteCloud</title>
	
	<style type="text/css">
		@import url("./css/style.css");
		@import url('./css/style_text.css');
		@import url('./css/form-buttons.css');
		@import url('./css/link-buttons.css');
		@import url('./css/menu.css');
		@import url('./css/statics.css');
		@import url('./css/messages.css');
		@import url('./css/table-sorter.css');
		@import url('./css/tabs.css');
		@import url('./css/forms.css');
		@import url('./css/datepicker.css');
		@import url('./css/jquery.fancybox-1.3.4.css');
	</style>
	
	<script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
	
	<!--[if lte IE 8]>
		<script type="text/javascript" src="js/excanvas.min.js"></script>
	<![endif]-->
	
<meta charset="UTF-8"></head>

<body>

<div class="container">   
  
	<div class="logo-labels">
		<h1><a href="http://ptecloud.com">PteCloud</a></h1>
		
	</div>
	
	<div class="menu-search">
		
		&nbsp;
	</div>
	
	<div class="breadcrumbs">
		&nbsp;
    	</div>

	<div class="section">
		<div class="box big">
			<div class="title">
				<h2>You are 30 seconds away from working smarter!</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">

					<p>All fields are required. Your information will be kept private and not redistributed.</p>
					<div id="fieldError">
    					<s:fielderror />
					</div>
				<s:form action="register" theme = "simple" method="post">
					<div class="line">
						<label>First Name</label>
						<s:textfield cssClass="small" name="signupVO.fname" value = "%{signupVO.fname}" />
					</div>
					<div class="line">
						<label>Last Name</label>
						<s:textfield cssClass="small" name="signupVO.lname" value = "%{signupVO.lname}" />
					</div>
                     <div class="line">
						<label>Address</label>
						<s:textarea cssClass="small" name="signupVO.address" value = "%{signupVO.address}" />
					</div>
                    <div class="line">
						<label>Email</label>
						<s:textfield cssClass="small" name="signupVO.email" value = "%{signupVO.email}" />
					</div>
					<div class="line">
						<label>Phone Number</label>
						<s:textfield cssClass="small" name="signupVO.phno" value = "%{signupVO.phno}" />
					</div>
                     <div class="line">
						<label>Company</label>
						<s:textfield cssClass="small" name="signupVO.company" value = "%{signupVO.company}" />
					</div>
                     <div class="line" style="list-style: none;">
						<label>Username</label>
						<s:textfield cssClass="small" name="signupVO.uname" value = "%{signupVO.uname}" />
					</div>
                     <div class="line">
						<label>Password</label>
						<s:password cssClass="small" name="signupVO.password" />
					</div>
                    <div class="line">
						<label>Confirm Password</label>
						<s:password cssClass="small" name="signupVO.cfrmpassword" />
					</div>
                    <div class="line">
						<label>How did you hear about us? </label>
						<s:textfield cssClass="small" name="signupVO.source" value = "%{signupVO.source}" />
					</div>
                    	<% ReCaptcha c = ReCaptchaFactory.newReCaptcha("6LcpTcwSAAAAADuTu9ONAVIebcjO0_E9fjXv-fLZ", "6LcpTcwSAAAAAIJFE8z79GUiJxfGvVM-Ai_sa54W", false); %>
          			<div class="line">	
          				<% out.print(c.createRecaptchaHtml(null, null)); %>
          			</div>
                    <div class="line">
                    	<s:checkbox name="signupVO.agreed" /><label for="signupVO.agreed">I have read &amp; agree to the <a target="_blank" href="#">Terms of Service</a> &amp; <a target="_blank" href="#">Privacy Policy.</a></label>
                    </div>
                     <div class="line">
					<button type="submit" class="green medium"><span>Register</span></button>&nbsp;
					<a href="index.jsp"><button type="button" class="green medium"><span>Cancel</span></button></a>
					</div>
				</s:form>
			</div>
		</div>
        <div class="box small">
        <div class="mainTableRightTd">
					<div align="center"><img width="130px" height="130px" border="0" align="absmiddle" title="100% Satisfaction Guaranteed" alt="100% Satisfaction Guaranteed" src="gfx/guarantee.png"></div>
					<ul class="li">
						<li><b>100% web-based.</b> Nothing to download, install, deploy or configure.</li>
						<li><b>Trusted</b> by many people in about more than 10 countries.</li>
						<li><b>Security</b> World-class hosting, zero-downtime network, daily backup.</li>
						<li><b>Customer Service</b> Friendly &amp; Prompt. No canned responses.</li>
					</ul>
				</div>
        </div>
	</div>
	
	
  
</div>

<script type="text/javascript" src="./js/superfish.js"></script>
<script type="text/javascript" src="./js/supersubs.js"></script>
<script type="text/javascript" src="./js/hoverIntent.js"></script>
<script type="text/javascript" src="./js/jquery.flot.js"></script>
<script type="text/javascript" src="./js/jquery.graphtable-0.2.js"></script>
<script type="text/javascript" src="./js/jquery.ui.core.js"></script> 
<script type="text/javascript" src="./js/jquery.ui.widget.js"></script> 
<script type="text/javascript" src="./js/jquery.ui.tabs.js"></script>
<script type="text/javascript" src="./js/customInput.jquery.js"></script>
<script type="text/javascript" src="./js/jquery.tablesorter.js"></script>
<script type="text/javascript" src="./js/jquery.tablesorter.pager.js"></script>
<script type="text/javascript" src="./js/jquery.sparkbox-select.js"></script>
<script type="text/javascript" src="./js/jquery.fancybox-1.3.4.js"></script>
<script type="text/javascript" src="./js/jquery.filestyle.mini.js"></script>
<script type="text/javascript" src="./js/date.js"></script>
<script type="text/javascript" src="./js/jquery.datepicker.js"></script>
<script type="text/javascript" src="./js/inline.js"></script>

</body>

</html> 