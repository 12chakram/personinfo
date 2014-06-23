<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<script language="javascript">
	$(document).ready(function() {
	    $("#pol1_edit").click(function(e) {
	    	var $inputs = $('#pol1_form :input');
	        $inputs.each(function() {
	            $(this).removeAttr('disabled');
	        });
			$("#pol1_edit").hide();
	        $("#pol1_submit").show();
			$("#pol1_cancel").show();
	    });
		$("#pol1_cancel").click(function(e) {
			 var $inputs = $('#pol1_form :input');
		        $inputs.each(function() {
		            $(this).attr('disabled','disabled');
		        });
	        $("#pol1_edit").show();
			$("#pol1_submit").hide();
			$("#pol1_cancel").hide();
	    });
		
		 $("#pol2_edit").click(function(e) {
		    	var $inputs = $('#pol2_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#pol2_edit").hide();
		        $("#pol2_submit").show();
				$("#pol2_cancel").show();
		    });
			$("#pol2_cancel").click(function(e) {
				 var $inputs = $('#pol2_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#pol2_edit").show();
				$("#pol2_submit").hide();
				$("#pol2_cancel").hide();
		    });
			
		  $("#pol3_edit").click(function(e) {
		    	var $inputs = $('#pol3_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#pol3_edit").hide();
		        $("#pol3_submit").show();
				$("#pol3_cancel").show();
		    });
			$("#pol3_cancel").click(function(e) {
				 var $inputs = $('#pol3_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#pol3_edit").show();
				$("#pol3_submit").hide();
				$("#pol3_cancel").hide();
		    });
			
			 $("#pol4_edit").click(function(e) {
			    	var $inputs = $('#pol4_form :input');
			        $inputs.each(function() {
			            $(this).removeAttr('disabled');
			        });
					$("#pol4_edit").hide();
			        $("#pol4_submit").show();
					$("#pol4_cancel").show();
			    });
				$("#pol4_cancel").click(function(e) {
					 var $inputs = $('#pol4_form :input');
				        $inputs.each(function() {
				            $(this).attr('disabled','disabled');
				        });
			        $("#pol4_edit").show();
					$("#pol4_submit").hide();
					$("#pol4_cancel").hide();
			    });
		});

	</script>	
	<!--[if lte IE 8]>
		<script type="text/javascript" src="js/excanvas.min.js"></script>
	<![endif]-->
	
<meta charset="UTF-8"></head>

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
			<li><a href ="vehicleinfo">Vehicle Info</a></li>
			<li><a href="importantdocs">Important Docs</a></li>
            <li class="current"><a>Insurance Docs</a></li>
		</ul>
		
	</div>
	
	<div class="breadcrumbs">
		&nbsp;
	</div>

	<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>Policy - 1</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('pol1')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pol1_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Policy name</label>
						<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}"><s:textfield cssClass="medium" name="pol1.polName"/></s:if>
						<s:else><s:textfield name="pol1.polName" cssClass="medium" disabled="true" value="%{pol1.polName}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Policy</label>
						<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}"><s:textfield cssClass="datepicker" name="pol1.dateOfPol"/></s:if>
						<s:else><s:textfield name="pol1.dateOfPol" cssClass="datepicker" disabled="true" value="%{pol1.dateOfPol}"/></s:else>
					</div>
                    <div class="line">
						<label>Date of Renewal</label>
						<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}"><s:textfield cssClass="datepicker" name="pol1.dateOfRnwl"/></s:if>
						<s:else><s:textfield name="pol1.dateOfRnwl" cssClass="datepicker" disabled="true" value="%{pol1.dateOfRnwl}"/></s:else>
					</div>
					<div class="line">
						<label>Policy Company</label>
						<s:if test="%{pol1 == null ||  (hasFieldErrors() && action.contains('pol1'))}"><s:select headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol1.polComp"/></s:if>
						<s:else><s:select disabled="true" headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol1.polComp" value="%{pol1.polComp}" /></s:else>
					</div>
                    <div class="line">
						<label>Policy Nominee</label>
						<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}"><s:textfield cssClass="medium" name="pol1.polNomi"/></s:if>
						<s:else><s:textfield name="pol1.polNomi" cssClass="medium" disabled="true" value="%{pol1.polNomi}"/></s:else>
					</div>
                    <div class="line">
						<label>Policy No.</label>
						<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}"><s:textfield cssClass="medium" name="pol1.polNo"/></s:if>
						<s:else><s:textfield name="pol1.polNo" cssClass="medium" disabled="true" value="%{pol1.polNo}"/></s:else>
					</div>
                     <div class="line">
                     	<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol1.polDoc1" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol1.polDoc1" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol1Doc1" target = "_blank"><s:property value="pol1.polDoc1FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol1.polDoc2" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol1.polDoc2" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol1Doc2" target = "_blank"><s:property value="pol1.polDoc2FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol1.polDoc3" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol1.polDoc3" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol1Doc3" target = "_blank"><s:property value="pol1.polDoc3FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol1 == null || (hasFieldErrors() && action.contains('pol1'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol1.polDoc4" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol1.polDoc4" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol1Doc4" target = "_blank"><s:property value="pol1.polDoc4FileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{pol1 == null ||  (hasFieldErrors() && !update && action.contains('pol1'))}"><button type="submit" class="green medium" name="action:addInsuranceDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('pol1')}">
                    		<div id="pol1_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol1_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol1_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pol1_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol1_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol1_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Policy - 2</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('pol2')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pol2_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Policy name</label>
						<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}"><s:textfield cssClass="medium" name="pol2.polName"/></s:if>
						<s:else><s:textfield name="pol2.polName" cssClass="medium" disabled="true" value="%{pol2.polName}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Policy</label>
						<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}"><s:textfield cssClass="datepicker" name="pol2.dateOfPol"/></s:if>
						<s:else><s:textfield name="pol2.dateOfPol" cssClass="datepicker" disabled="true" value="%{pol2.dateOfPol}"/></s:else>
					</div>
                    <div class="line">
						<label>Date of Renewal</label>
						<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}"><s:textfield cssClass="datepicker" name="pol2.dateOfRnwl"/></s:if>
						<s:else><s:textfield name="pol2.dateOfRnwl" cssClass="datepicker" disabled="true" value="%{pol2.dateOfRnwl}"/></s:else>
					</div>
					<div class="line">
						<label>Policy Company</label>
						<s:if test="%{pol2 == null ||  (hasFieldErrors() && action.contains('pol2'))}"><s:select headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol2.polComp"/></s:if>
						<s:else><s:select disabled="true" headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol2.polComp" value="%{pol2.polComp}" /></s:else>
					</div>
                    <div class="line">
						<label>Policy Nominee</label>
						<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}"><s:textfield cssClass="medium" name="pol2.polNomi"/></s:if>
						<s:else><s:textfield name="pol2.polNomi" cssClass="medium" disabled="true" value="%{pol2.polNomi}"/></s:else>
					</div>
                    <div class="line">
						<label>Policy No.</label>
						<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}"><s:textfield cssClass="medium" name="pol2.polNo"/></s:if>
						<s:else><s:textfield name="pol2.polNo" cssClass="medium" disabled="true" value="%{pol2.polNo}"/></s:else>
					</div>
                     <div class="line">
                     	<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol2.polDoc1" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol2.polDoc1" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol2Doc1" target = "_blank"><s:property value="pol2.polDoc1FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol2.polDoc2" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol2.polDoc2" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol2Doc2" target = "_blank"><s:property value="pol2.polDoc2FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol2.polDoc3" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol2.polDoc3" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol2Doc3" target = "_blank"><s:property value="pol2.polDoc3FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol2 == null || (hasFieldErrors() && action.contains('pol2'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol2.polDoc4" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol2.polDoc4" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol2Doc4" target = "_blank"><s:property value="pol2.polDoc4FileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{pol2 == null ||  (hasFieldErrors() && !update && action.contains('pol2'))}"><button type="submit" class="green medium" name="action:addInsuranceDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('pol2')}">
                    		<div id="pol2_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol2_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol2_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pol2_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol2_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol2_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	</div>
<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>Policy - 3</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('pol3')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pol3_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Policy name</label>
						<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}"><s:textfield cssClass="medium" name="pol3.polName"/></s:if>
						<s:else><s:textfield name="pol3.polName" cssClass="medium" disabled="true" value="%{pol3.polName}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Policy</label>
						<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}"><s:textfield cssClass="datepicker" name="pol3.dateOfPol"/></s:if>
						<s:else><s:textfield name="pol3.dateOfPol" cssClass="datepicker" disabled="true" value="%{pol3.dateOfPol}"/></s:else>
					</div>
                    <div class="line">
						<label>Date of Renewal</label>
						<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}"><s:textfield cssClass="datepicker" name="pol3.dateOfRnwl"/></s:if>
						<s:else><s:textfield name="pol3.dateOfRnwl" cssClass="datepicker" disabled="true" value="%{pol3.dateOfRnwl}"/></s:else>
					</div>
					<div class="line">
						<label>Policy Company</label>
						<s:if test="%{pol3 == null ||  (hasFieldErrors() && action.contains('pol3'))}"><s:select headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol3.polComp"/></s:if>
						<s:else><s:select disabled="true" headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol3.polComp" value="%{pol3.polComp}" /></s:else>
					</div>
                    <div class="line">
						<label>Policy Nominee</label>
						<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}"><s:textfield cssClass="medium" name="pol3.polNomi"/></s:if>
						<s:else><s:textfield name="pol3.polNomi" cssClass="medium" disabled="true" value="%{pol3.polNomi}"/></s:else>
					</div>
                    <div class="line">
						<label>Policy No.</label>
						<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}"><s:textfield cssClass="medium" name="pol3.polNo"/></s:if>
						<s:else><s:textfield name="pol3.polNo" cssClass="medium" disabled="true" value="%{pol3.polNo}"/></s:else>
					</div>
                     <div class="line">
                     	<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol3.polDoc1" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol3.polDoc1" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol3Doc1" target = "_blank"><s:property value="pol3.polDoc1FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol3.polDoc2" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol3.polDoc2" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol3Doc2" target = "_blank"><s:property value="pol3.polDoc2FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol3.polDoc3" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol3.polDoc3" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol3Doc3" target = "_blank"><s:property value="pol3.polDoc3FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol3 == null || (hasFieldErrors() && action.contains('pol3'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol3.polDoc4" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol3.polDoc4" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol3Doc4" target = "_blank"><s:property value="pol3.polDoc4FileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{pol3 == null ||  (hasFieldErrors() && !update && action.contains('pol3'))}"><button type="submit" class="green medium" name="action:addInsuranceDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('pol3')}">
                    		<div id="pol3_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol3_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol3_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pol3_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol3_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol3_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Policy - 4</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('pol4')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pol4_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Policy name</label>
						<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}"><s:textfield cssClass="medium" name="pol4.polName"/></s:if>
						<s:else><s:textfield name="pol4.polName" cssClass="medium" disabled="true" value="%{pol4.polName}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Policy</label>
						<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}"><s:textfield cssClass="datepicker" name="pol4.dateOfPol"/></s:if>
						<s:else><s:textfield name="pol4.dateOfPol" cssClass="datepicker" disabled="true" value="%{pol4.dateOfPol}"/></s:else>
					</div>
                    <div class="line">
						<label>Date of Renewal</label>
						<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}"><s:textfield cssClass="datepicker" name="pol4.dateOfRnwl"/></s:if>
						<s:else><s:textfield name="pol4.dateOfRnwl" cssClass="datepicker" disabled="true" value="%{pol4.dateOfRnwl}"/></s:else>
					</div>
					<div class="line">
						<label>Policy Company</label>
						<s:if test="%{pol4 == null ||  (hasFieldErrors() && action.contains('pol4'))}"><s:select headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol4.polComp"/></s:if>
						<s:else><s:select disabled="true" headerKey="" cssClass="medium" headerValue="Select Policy Company" list="insCompanies" name="pol4.polComp" value="%{pol4.polComp}" /></s:else>
					</div>
                    <div class="line">
						<label>Policy Nominee</label>
						<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}"><s:textfield cssClass="medium" name="pol4.polNomi"/></s:if>
						<s:else><s:textfield name="pol4.polNomi" cssClass="medium" disabled="true" value="%{pol4.polNomi}"/></s:else>
					</div>
                    <div class="line">
						<label>Policy No.</label>
						<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}"><s:textfield cssClass="medium" name="pol4.polNo"/></s:if>
						<s:else><s:textfield name="pol4.polNo" cssClass="medium" disabled="true" value="%{pol4.polNo}"/></s:else>
					</div>
                     <div class="line">
                     	<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol4.polDoc1" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol4.polDoc1" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol4Doc1" target = "_blank"><s:property value="pol4.polDoc1FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol4.polDoc2" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol4.polDoc2" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol4Doc2" target = "_blank"><s:property value="pol4.polDoc2FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol4.polDoc3" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol4.polDoc3" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol4Doc3" target = "_blank"><s:property value="pol4.polDoc3FileName" /></a></div>
						</s:else>
					</div>
                     <div class="line">
                    	<s:if test="%{pol4 == null || (hasFieldErrors() && action.contains('pol4'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pol4.polDoc4" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pol4.polDoc4" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pol4Doc4" target = "_blank"><s:property value="pol4.polDoc4FileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{pol4 == null ||  (hasFieldErrors() && !update && action.contains('pol4'))}"><button type="submit" class="green medium" name="action:addInsuranceDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('pol4')}">
                    		<div id="pol4_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol4_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol4_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pol4_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pol4_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pol4_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateInsuranceDoc"><span>Update</span></button>&nbsp;</div>   		
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