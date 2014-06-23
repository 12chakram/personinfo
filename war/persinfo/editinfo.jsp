<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
</head>

<body>
<div class="container">   
  
	<div class="logo-labels">
		<h1><a href="#">PteCloud</a></h1>
		<ul>
			<li><a href="editinfo"><span>Settings</span></a></li>
			<li class="logout"><a href="logout"><span>Logout</span></a></li>
		</ul>
	</div>
	
	<div class="menu-search">
		<ul> 
			<li><a href="dashboard">Dashboard</a></li> 
			<li><a href="personalinfo">Personal Info</a></li> 
			<li><a href="vehicleinfo">Vehicle Info</a></li>
			<li><a href="importantdocs">Important Docs</a></li>
			<li><a href="insurancedocs">Insurance Docs</a></li>
		</ul>
	</div>
	<div class="breadcrumbs">
		&nbsp;
	</div>

	<div class="section">
    	<div class="box big">
    		<div class="title">
				<h2>My Account Details</h2>
				
			</div>
			<div class="content forms">
					<div id="fieldError">
    					<s:fielderror />
					</div>
				<s:form action="register" theme = "simple" method="post">
					<div class="line">
						<label>First Name</label>
						<s:textfield cssClass="small" name="user.fname" value = "%{user.fname}" />
					</div>
					<div class="line">
						<label>Last Name</label>
						<s:textfield cssClass="small" name="user.lname" value = "%{user.lname}" />
					</div>
                     <div class="line">
						<label>Address</label>
						<s:textarea cssClass="small" name="user.address" value = "%{user.address}" />
					</div>
                    <div class="line">
						<label>Email</label>
						<s:textfield cssClass="small" name="user.email" readonly="true" value = "%{user.email}" />
					</div>
					<div class="line">
						<label>Phone Number</label>
						<s:textfield cssClass="small" name="user.phno" value = "%{user.phno}" />
					</div>
                     <div class="line">
						<label>Company</label>
						<s:textfield cssClass="small" name="user.company" value = "%{user.company}" />
					</div>
                     <div class="line" style="list-style: none;">
						<label>Username</label>
						<s:textfield cssClass="small" name="user.uname" readonly="true" value = "%{user.uname}" />
					</div>
                     <div class="line">
						<label>Password</label>
						<s:password cssClass="small" name="user.password" />
					</div>
                    <div class="line">
						<label>Confirm Password</label>
						<s:password cssClass="small" name="cfrmpassword" />
					</div>
                     <div class="line">
                     <button type="submit" class="green medium" name="action:updateAcntDetails"><span>Update</span></button>&nbsp;
					<a href="dashboard"><button type="button" class="green medium"><span>Cancel</span></button></a>
					</div>
				</s:form>
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