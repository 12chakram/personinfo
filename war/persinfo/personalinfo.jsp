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
	<script language="javascript">
	$(document).ready(function() {
    $("#pi_edit").click(function(e) {
    	var $inputs = $('#pi_form :input');
        $inputs.each(function() {
            $(this).removeAttr('disabled');
        });
		$("#pi_edit").hide();
        $("#pi_submit").show();
		$("#pi_cancel").show();
    });
	$("#pi_cancel").click(function(e) {
		 var $inputs = $('#pi_form :input');
	        $inputs.each(function() {
	            $(this).attr('disabled','disabled');
	        });
        $("#pi_edit").show();
		$("#pi_submit").hide();
		$("#pi_cancel").hide();
    });
	
	//Birth Form
	 $("#bi_edit").click(function(e) {
	    	var $inputs = $('#bi_form :input');
	        $inputs.each(function() {
	            $(this).removeAttr('disabled');
	        });
			$("#bi_edit").hide();
	        $("#bi_submit").show();
			$("#bi_cancel").show();
	    });
		$("#bi_cancel").click(function(e) {
			 var $inputs = $('#bi_form :input');
		        $inputs.each(function() {
		            $(this).attr('disabled','disabled');
		        });
	        $("#bi_edit").show();
			$("#bi_submit").hide();
			$("#bi_cancel").hide();
	    });
		
		
		//Education Form
		 $("#ei_edit").click(function(e) {
		    	var $inputs = $('#ei_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#ei_edit").hide();
		        $("#ei_submit").show();
				$("#ei_cancel").show();
		    });
			$("#ei_cancel").click(function(e) {
				 var $inputs = $('#ei_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#ei_edit").show();
				$("#ei_submit").hide();
				$("#ei_cancel").hide();
		    });
			
			
			//Professional Form
			 $("#pr_edit").click(function(e) {
			    	var $inputs = $('#pr_form :input');
			        $inputs.each(function() {
			            $(this).removeAttr('disabled');
			        });
					$("#pr_edit").hide();
			        $("#pr_submit").show();
					$("#pr_cancel").show();
			    });
				$("#pr_cancel").click(function(e) {
					 var $inputs = $('#pr_form :input');
				        $inputs.each(function() {
				            $(this).attr('disabled','disabled');
				        });
			        $("#pr_edit").show();
					$("#pr_submit").hide();
					$("#pr_cancel").hide();
			    });
			
});

	</script>	
</head>

<body>
<s:hidden name = "uid" value = "%{uid}" />
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
			<li class="current"><a>Personal Info</a></li> 
			<li><a href="vehicleinfo">Vehicle Info</a></li>
			<li><a href="importantdocs">Important Docs</a></li>
			<li><a href="insurancedocs">Insurance Docs</a></li>
		</ul>
	</div>
	<div class="breadcrumbs">
		&nbsp;
	</div>

	<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>Personal Info</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
			<s:if test="%{action.contains('BasicInfo')}">
			<div id="fieldError">
    					<s:fielderror />
			</div>
			</s:if>
				<form id="pi_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Full Name </label>
						<s:if test="%{binfo == null ||  (hasFieldErrors() && action.contains('BasicInfo'))}"><s:textfield name ="binfo.fullName" cssClass="medium" value="%{binfo.fullName}" /></s:if>
						<s:else><s:textfield name ="binfo.fullName"  cssClass="medium" disabled="true"  value="%{binfo.fullName}" /></s:else>
					</div>
					<div class="line">
						<label>Phone Number</label>
						<s:if test="%{binfo == null ||  (hasFieldErrors() && action.contains('BasicInfo'))}"><s:textfield name ="binfo.phno" cssClass="medium" value="%{binfo.phno}" /></s:if>
						<s:else><s:textfield name ="binfo.phno"  cssClass="medium" disabled="true"  value="%{binfo.phno}" /></s:else>
					</div>
					<div class="line">
						<label>Email Id</label>
						<s:if test="%{binfo == null ||  (hasFieldErrors() && action.contains('BasicInfo'))}"><s:textfield name ="binfo.email" cssClass="medium" value="%{binfo.email}" /></s:if>
						<s:else><s:textfield name ="binfo.email"  cssClass="medium" disabled="true" value="%{binfo.email}" /></s:else>
					</div>
					<div class="line">
						<label>Address</label>
						<s:if test="%{binfo == null ||  (hasFieldErrors() && action.contains('BasicInfo'))}"><s:textarea name ="binfo.address" cssClass="medium" value="%{binfo.address}" /></s:if>
						<s:else><s:textarea name ="binfo.address" cssClass="medium" disabled="true" value="%{binfo.address}" /></s:else>
					</div>
					<div class="line">
						<s:if test="%{binfo == null || (hasFieldErrors() && action.contains('BasicInfo'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<input type = "file" name="binfo.photoCopy" /></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="binfo.photoCopy" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=photoCopy" target = "_blank"><s:property value="binfo.photoCopyFileName" /></a></div>
						</s:else>
					</div>
					<div class="submitbtn">
                    	<s:if test="%{binfo == null ||  (hasFieldErrors() && !update && action.contains('BasicInfo'))}"><button type="submit" class="green medium" name="action:addBasicInfo"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('BasicInfo')}">
                    		<div id="pi_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pi_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pi_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateBasicInfo"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pi_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pi_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pi_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateBasicInfo"><span>Update</span></button>&nbsp;</div>
                    		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Birth Certificate</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('BirthDetails')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="bi_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Place of birth </label>
						<s:if test="%{birthDetails == null ||  (hasFieldErrors() && action.contains('BirthDetails'))}"><s:textfield cssClass="small" name="birthDetails.placeOfBirth" value="%{birthDetails.placeOfBirth}" /></s:if>
						<s:else><s:textfield name="birthDetails.placeOfBirth"   cssClass="medium" disabled="true" value="%{birthDetails.placeOfBirth}"/></s:else>
					</div>
					<div class="line">
						<label>D.O.B</label>
						<s:if test="%{birthDetails == null ||  (hasFieldErrors() && action.contains('BirthDetails'))}"><s:textfield name="birthDetails.dob" cssClass="datepicker" value="%{birthDetails.dob}"/></s:if>
						<s:else><s:textfield name="birthDetails.dob"   cssClass="datepicker" disabled="true" value="%{birthDetails.dob}"/></s:else> 
					</div>
					<div class="line">
						<label>Hospital</label>
						<s:if test="%{birthDetails == null ||  (hasFieldErrors() && action.contains('BirthDetails'))}"><s:textfield name="birthDetails.hospital" cssClass="medium" value="%{birthDetails.hospital}" /></s:if>
						<s:else><s:textfield name="birthDetails.hospital"   cssClass="medium" disabled="true" value="%{birthDetails.hospital}"/></s:else>
					</div>
					<div class="line">
						<s:if test="%{birthDetails == null || (hasFieldErrors() && action.contains('BirthDetails'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<input type = "file" name="birthDetails.birthCert" /></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="birthDetails.birthCert" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=birthCert" target = "_blank"><s:property value="birthDetails.birthCertFileName" /></a></div>
						</s:else>
					</div>
					<div class="submitbtn">
                    	<s:if test="%{birthDetails == null ||  (hasFieldErrors() && !update && action.contains('BirthDetails'))}"><button type="submit" class="green medium" name="action:addBirthDetails"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('BirthDetails')}">
                    		<div id="bi_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="bi_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="bi_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateBirthDetails"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="bi_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="bi_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="bi_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateBirthDetails"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="section">
		<div class="box medium">
			<div class="title">
				<h2>Education</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('EduDetails')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="ei_form" method="post" enctype="multipart/form-data">
                <div class="line">
                <h3>Secondary / Metriculation</h3>
                </div>
                	<div class="line">
						<label>Year of Admission </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.secYrOfAdmi" cssClass="small" /></s:if>
						<s:else><s:textfield name = "eduDetails.secYrOfAdmi"  cssClass="medium" disabled="true" value="%{eduDetails.secYrOfAdmi}"/></s:else>
					</div>
                    <div class="line">
						<label>School Name</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.secSchlName" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.secSchlName" cssClass="medium" disabled="true"  value="%{eduDetails.secSchlName}"/></s:else>
					</div>
                    <div class="line">
						<label> Place/State/Country </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.secPlace" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.secPlace" cssClass="medium" disabled="true" value="%{eduDetails.secPlace}"/></s:else>
					</div>
                    <div class="line">
   						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="eduDetails.secCert" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="eduDetails.secCert" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=secCert" target = "_blank"><s:property value="eduDetails.secCertFileName"></s:property></a></div>
						
						</s:else>
					</div>
                   	<div class="line">
                     <h3>College</h3>
               		 </div>
                	<div class="line">
						<label>Year of Admission </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.colYrOfAdmi" cssClass="small" /></s:if>
						<s:else><s:textfield name = "eduDetails.colYrOfAdmi" cssClass="medium" disabled="true" value="%{eduDetails.colYrOfAdmi}"/></s:else>
					</div>
					<div class="line">
						<label>College Name</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.colName" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.colName" cssClass="medium" disabled="true"  value="%{eduDetails.colName}"/></s:else>
					</div>
                    <div class="line">
						<label>Passed out year</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.colPassedYr" cssClass="small" /></s:if>
						<s:else><s:textfield name = "eduDetails.colPassedYr" cssClass="medium" disabled="true" value="%{eduDetails.colPassedYr}"/></s:else>
					</div>
                    <div class="line">
						<label>Board</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.colBoard" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.colBoard"  cssClass="medium" disabled="true" value="%{eduDetails.colBoard}"/></s:else>
					</div>
                    <div class="line">
						<label> Place/State/Country </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.colPlace" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.colPlace"  cssClass="medium" disabled="true" value="%{eduDetails.colPlace}"/></s:else>
					</div>
                    <div class="line">
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<input type = "file" name="eduDetails.colCert" /></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="eduDetails.colCert" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=colCert" target = "_blank"><s:property value="eduDetails.colCertFileName" /></a></div>
						</s:else>
					</div>
                    
                    <div class="line">
                     <h3>Degree / Technical / Professional</h3>
               		 </div>
                	<div class="line">
						<label>Year of Admission </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield cssClass="small" name = "eduDetails.degYrOfAdmi" /></s:if>
						<s:else><s:textfield name = "eduDetails.degYrOfAdmi"  cssClass="medium" disabled="true" value="%{eduDetails.degYrOfAdmi}"/></s:else>
					</div>
					<div class="line">
						<label>College Name</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.degColName" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.degColName" cssClass="medium" disabled="true"  value="%{eduDetails.degColName}"/></s:else>
					</div>
                    <div class="line">
						<label>Passed out year</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield cssClass="small" name = "eduDetails.degPassedYr" /></s:if>
						<s:else><s:textfield name = "eduDetails.degPassedYr"  cssClass="medium" disabled="true" value="%{eduDetails.degPassedYr}"/></s:else>
					</div>
                    <div class="line">
						<label>University</label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.degUniversity" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.degUniversity"  cssClass="medium" disabled="true" value="%{eduDetails.degUniversity}"/></s:else>
					</div>
                    <div class="line">
						<label> Place/State/Country </label>
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.degPlace" cssClass="medium" /></s:if>
						<s:else><s:textfield name = "eduDetails.degPlace"  cssClass="medium" disabled="true" value="%{eduDetails.degPlace}"/></s:else>
					</div>
                    <div class="line">
						<s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<input type = "file" name="eduDetails.degCert" /></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="eduDetails.degCert" disabled="true"/>							
							<div style="float: right"><a href = "showDoc?docName=degCert" target = "_blank"><s:property value="eduDetails.degCertFileName" /></a></div>
						</s:else>
					</div>
                     
                    <!-- 
					<div class="line">
						<label>Date picker</label>
						<span class="date">Starting date</span> <s:if test="%{eduDetails == null || (hasFieldErrors() && action.contains('EduDetails'))}"><s:textfield name = "eduDetails.date" cssClass="datepicker" /></s:if> 
						<s:else><s:textfield name = "eduDetails.date" disabled="true"  cssClass="datepicker" disabled="true" value="%{eduDetails.date}"/></s:else>
					</div>  -->
					<div class="submitbtn">
						<s:if test="%{eduDetails == null ||  (hasFieldErrors() && !update && action.contains('EduDetails'))}"><button type="submit" class="green medium" name="action:addEduDetails"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('EduDetails')}">
                    		<div id="ei_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="ei_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="ei_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateEduDetails"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="ei_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="ei_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="ei_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateEduDetails"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	
		<div class="box medium">
			<div class="title">
				<h2>Professional Info</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('ProfessionalInfo')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pr_form" method="post" enctype="multipart/form-data">
                	<div class="line">
						<label>First Company</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.frstComp" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.frstComp"  cssClass="medium" disabled="true" value="%{profInfo.frstComp}" /></s:else>
					</div>
                    <div class="line">
						<label>D.O.J</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.frstDOJ" cssClass="datepicker" /> </s:if>
						<s:else><s:textfield name="profInfo.frstDOJ"  cssClass="datepicker" disabled="true" value="%{profInfo.frstDOJ}" /></s:else>
					</div>
                    <div class="line">
						<label> Designation </label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.frstDesig" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.frstDesig"  cssClass="medium" disabled="true" value="%{profInfo.frstDesig}" /></s:else>
					</div>
                    <div class="line">
                    	<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}">
                    	<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="profInfo.frstExpDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="profInfo.frstExpDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=frstExpDoc" target = "_blank"><s:property value="profInfo.frstExpDocFileName" /></a></div>							
						</s:else>
					</div>
                    
                    <div class="line">
						<label>Second Company</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.scndComp" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.scndComp"  cssClass="medium" disabled="true" value="%{profInfo.scndComp}" /></s:else>
					</div>
                    <div class="line">
						<label>D.O.J</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.scndDOJ" cssClass="datepicker" /> </s:if>
						<s:else><s:textfield name="profInfo.scndDOJ"  cssClass="datepicker" disabled="true" value="%{profInfo.scndDOJ}" /></s:else>
					</div>
                    <div class="line">
						<label> Designation </label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.scndDesig" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.scndDesig"  cssClass="medium" disabled="true" value="%{profInfo.scndDesig}" /></s:else>
					</div>
                    <div class="line">
                    	<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}">
                    	<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="profInfo.scndExpDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="profInfo.scndExpDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=scndExpDoc" target = "_blank"><s:property value="profInfo.scndExpDocFileName" /></a></div>	
						</s:else>
					</div>
                    
                     <div class="line">
						<label>Third Company</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.thirdComp" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.thirdComp"  cssClass="medium" disabled="true" value="%{profInfo.thirdComp}" /></s:else>
					</div>
                    <div class="line">
						<label>D.O.J</label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.thirdDOJ" cssClass="datepicker" /> </s:if>
						<s:else><s:textfield name="profInfo.thirdDOJ"  cssClass="datepicker" disabled="true" value="%{profInfo.thirdDOJ}" /></s:else>
					</div>
                    <div class="line">
						<label> Designation </label>
						<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}"><s:textfield name="profInfo.thirdDesig" cssClass="medium" /></s:if>
						<s:else><s:textfield name="profInfo.thirdDesig"  cssClass="medium" disabled="true" value="%{profInfo.thirdDesig}" /></s:else>
					</div>
                    <div class="line">
                    	<s:if test="%{profInfo == null || (hasFieldErrors() && action.contains('ProfessionalInfo'))}">
                    	<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="profInfo.thirdExpDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="profInfo.thirdExpDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=thirdExpDoc" target = "_blank"><s:property value="profInfo.thirdExpDocFileName" /></a></div>
							
						</s:else>
					</div>
                    <div class="submitbtn">
                    	<s:if test="%{profInfo == null ||  (hasFieldErrors() && !update && action.contains('ProfessionalInfo'))}"><button type="submit" class="green medium" name="action:addProfessionalInfo"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('ProfessionalInfo')}">
                    		<div id="pr_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pr_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pr_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateProfessionalInfo"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pr_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pr_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pr_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateProfessionalInfo"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
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