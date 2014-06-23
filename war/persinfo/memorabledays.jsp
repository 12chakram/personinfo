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
	
	<script type="text/javascript" src="./js/jquery-1.6.2.min.js"></script>
	
	<!--[if lte IE 8]>
		<script type="text/javascript" src="js/excanvas.min.js"></script>
	<![endif]-->
	
<meta charset="UTF-8"></head>

<body>

<div class="container">   
  
	<div class="logo-labels">
		<h1><a href="#">PteCloud</a></h1>
		<ul>
			<li><a href="#"><span>Settings</span></a></li>
			<li class="usermessage"><a href="#"><span>1 new message</span></a></li>
			<li class="logout"><a href="logout"><span>Logout</span></a></li>
		</ul>
	</div>
	
	<div class="menu-search">
		<ul> 
			<li><a href="dashboard">Dashboard</a></li> 
			<li><a href="personal">Personal Info</a></li> 
			<li><a href="vehicleinfo">Vehicle Info</a></li>
			<li class="current"><a>Memorable Days</a></li>
			<li><a href="importantdocs">Important Docs</a></li>
            <li><a href="confidentialdocs">Confidential Docs</a></li>
            <li><a href="properties">Properties</a></li>
		</ul>		
	</div>
	
	<div class="breadcrumbs">
		&nbsp;
	</div>

	<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>Most Memorable Days</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<form action="" method="post">
					<div class="line">
						<label>First Love</label>
						<s:if test="%{memDays == null}"><input type="text" name="memDays.frstLove" class="medium" value="" /></s:if>
						<s:else><s:textfield name="memDays.frstLove" readonly="true" value="%{memDays.frstLove}"/></s:else>
					</div>
					<div class="line">
						<label>Date</label>
						<s:if test="%{memDays == null}"><input type="text" name="memDays.date" class="datepicker" value="" /></s:if>
						<s:else><s:textfield name="memDays.date" readonly="true" value="%{memDays.date}"/></s:else>
					</div>
					<div class="line">
						<label>Memories</label>
						<s:if test="%{memDays == null}"><input type="text" name="memDays.memories" class="medium" value="" /></s:if>
						<s:else><s:textfield name="memDays.memories" readonly="true" value="%{memDays.memories}"/></s:else>
					</div>
                    <div class="line">
						<label>Marriage Date</label>
						<s:if test="%{memDays == null}"><input type="text" name="memDays.mrgDate" class="datepicker" value="" /></s:if>
						<s:else><s:textfield name="memDays.mrgDate" readonly="true" value="%{memDays.mrgDate}"/></s:else>
					</div>
                    <div class="line">
						<label>Marriage Details</label>
						<s:if test="%{memDays == null}"><input type="text" name="memDays.mrgDetails" class="medium" value="" /></s:if>
						<s:else><s:textfield name="memDays.mrgDetails" readonly="true" value="%{memDays.mrgDetails}"/></s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{memDays == null}"><button type="submit" class="green medium" name="action:addMostMemDays"><span>Sumbit</span></button></s:if>
                    	<s:else><button type="button" class="green medium"><span>Edit</span></button></s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Important Dates</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<form action="" method="post">
               		<div class="line">
						<label>Incident Name/ Event Name</label>
						<s:if test="%{impDays == null}"><input type="text" name="impDays.event" class="small" value="" /></s:if>
						<s:else><s:textfield name="impDays.event" readonly="true" value="%{impDays.event}"/></s:else>
					</div>
					<div class="line">
						<label>Incident Date/ Event Date</label>
						<s:if test="%{impDays == null}"><input type="text" name="impDays.date" class="datepicker" value="" /></s:if>
						<s:else><s:textfield name="impDays.date" readonly="true" value="%{impDays.date}"/></s:else>
					</div>
					<div class="submitbtn">
                    	<s:if test="%{impDays == null}"><button type="submit" class="green medium" name="action:addImpDays"><span>Sumbit</span></button></s:if>
                    	<s:else><button type="button" class="green medium"><span>Edit</span></button></s:else>
                    </div>
				</form>
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