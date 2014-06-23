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
	    $("#vi_edit").click(function(e) {
	    	var $inputs = $('#vi_form :input');
	        $inputs.each(function() {
	            $(this).removeAttr('disabled');
	        });
			$("#vi_edit").hide();
	        $("#vi_submit").show();
			$("#vi_cancel").show();
	    });
		$("#vi_cancel").click(function(e) {
			 var $inputs = $('#vi_form :input');
		        $inputs.each(function() {
		            $(this).attr('disabled','disabled');
		        });
	        $("#vi_edit").show();
			$("#vi_submit").hide();
			$("#vi_cancel").hide();
	    });
		
		
		 $("#pa_edit").click(function(e) {
		    	var $inputs = $('#pa_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#pa_edit").hide();
		        $("#pa_submit").show();
				$("#pa_cancel").show();
		    });
			$("#pa_cancel").click(function(e) {
				 var $inputs = $('#pa_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#pa_edit").show();
				$("#pa_submit").hide();
				$("#pa_cancel").hide();
		    });
			
			
			$("#pc_edit").click(function(e) {
		    	var $inputs = $('#pc_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#pc_edit").hide();
		        $("#pc_submit").show();
				$("#pc_cancel").show();
		    });
			$("#pc_cancel").click(function(e) {
				 var $inputs = $('#pc_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#pc_edit").show();
				$("#pc_submit").hide();
				$("#pc_cancel").hide();
		    });
			
			
			
			$("#oi_edit").click(function(e) {
		    	var $inputs = $('#oi_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#oi_edit").hide();
		        $("#oi_submit").show();
				$("#oi_cancel").show();
		    });
			$("#oi_cancel").click(function(e) {
				 var $inputs = $('#oi_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#oi_edit").show();
				$("#oi_submit").hide();
				$("#oi_cancel").hide();
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
			<li class="current"><a>Important Docs</a></li>
			<li><a href="insurancedocs">Insurance Docs</a></li>
		</ul>
		
	</div>
	
	<div class="breadcrumbs">
		&nbsp;
	</div>

	<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>Voters ID</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('voterId')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="vi_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Voters ID No.</label>
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}"><s:textfield name="voterId.idNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="voterId.idNo" cssClass="medium" disabled="true" value="%{voterId.idNo}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Issue</label>
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}"><s:textfield name="voterId.dateOfIssue" cssClass="datepicker" /></s:if>
						<s:else><s:textfield name="voterId.dateOfIssue" cssClass="datepicker" disabled="true" value="%{voterId.dateOfIssue}"/></s:else>
					</div>
					<div class="line">
						<label>Place of Issue</label>
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}"><s:textfield name="voterId.placeOfIssue" cssClass="medium" /></s:if>
						<s:else><s:textfield name="voterId.placeOfIssue" cssClass="medium" disabled="true" value="%{voterId.placeOfIssue}"/></s:else>
					</div>
                    <div class="line">
						<label>Country & Region</label>
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}"><s:textfield name="voterId.country" cssClass="medium" /></s:if>
						<s:else><s:textfield name="voterId.country" cssClass="medium" disabled="true" value="%{voterId.country}"/></s:else>
					</div>
                    <div class="line">
						<label>Ref serial no.</label>
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}"><s:textfield name="voterId.refSrlNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="voterId.refSrlNo" cssClass="medium" disabled="true" value="%{voterId.refSrlNo}"/></s:else>
					</div>
                     <div class="line">
						<s:if test="%{voterId == null || (hasFieldErrors() && action.contains('voterId'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="voterId.docCopy" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="voterId.docCopy" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=voterid" target = "_blank"><s:property value="voterId.docCopyFileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{voterId == null ||  (hasFieldErrors() && !update && action.contains('voterId'))}"><button type="submit" class="green medium" name="action:addImportantDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('voterId')}">
                    		<div id="vi_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="vi_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="vi_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="vi_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="vi_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="vi_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Passport</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('passport')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pa_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Passport No.</label>
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}"><s:textfield name="passport.idNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="passport.idNo" cssClass="medium" disabled="true" value="%{passport.idNo}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Issue</label>
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}"><s:textfield name="passport.dateOfIssue" cssClass="datepicker" /></s:if>
						<s:else><s:textfield name="passport.dateOfIssue" cssClass="datepicker" disabled="true" value="%{passport.dateOfIssue}"/></s:else>
					</div>
					<div class="line">
						<label>Place of Issue</label>
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}"><s:textfield name="passport.placeOfIssue" cssClass="medium" /></s:if>
						<s:else><s:textfield name="passport.placeOfIssue" cssClass="medium" disabled="true" value="%{passport.placeOfIssue}"/></s:else>
					</div>
                    <div class="line">
						<label>Country & Region</label>
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}"><s:textfield name="passport.country" cssClass="medium" /></s:if>
						<s:else><s:textfield name="passport.country" cssClass="medium" disabled="true" value="%{passport.country}"/></s:else>
					</div>
                    <div class="line">
						<label>Ref serial no.</label>
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}"><s:textfield name="passport.refSrlNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="passport.refSrlNo" cssClass="medium" disabled="true" value="%{passport.refSrlNo}"/></s:else>
					</div>
                     <div class="line">
						<s:if test="%{passport == null || (hasFieldErrors() && action.contains('passport'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="passport.docCopy" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="passport.docCopy" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=passport" target = "_blank"><s:property value="passport.docCopyFileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                   		<s:if test="%{passport == null ||  (hasFieldErrors() && !update && action.contains('passport'))}"><button type="submit" class="green medium" name="action:addImportantDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('passport')}">
                    		<div id="pa_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pa_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pa_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pa_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pa_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pa_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="section">
    <div class="box medium">
			<div class="title">
				<h2>PAN Card</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('pancard')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="pc_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>PAN Card No.</label>
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}"><s:textfield name="pancard.idNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="pancard.idNo" cssClass="medium" disabled="true" value="%{pancard.idNo}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Issue</label>
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}"><s:textfield name="pancard.dateOfIssue" cssClass="datepicker" /></s:if>
						<s:else><s:textfield name="pancard.dateOfIssue" cssClass="datepicker" disabled="true" value="%{pancard.dateOfIssue}"/></s:else>
					</div>
					<div class="line">
						<label>Place of Issue</label>
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}"><s:textfield name="pancard.placeOfIssue" cssClass="medium" /></s:if>
						<s:else><s:textfield name="pancard.placeOfIssue" cssClass="medium" disabled="true" value="%{pancard.placeOfIssue}"/></s:else>
					</div>
                    <div class="line">
						<label>Country & Region</label>
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}"><s:textfield name="pancard.country" cssClass="medium" /></s:if>
						<s:else><s:textfield name="pancard.country" cssClass="medium" disabled="true" value="%{pancard.country}"/></s:else>
					</div>
                    <div class="line">
						<label>Ref serial no.</label>
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}"><s:textfield name="pancard.refSrlNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="pancard.refSrlNo" cssClass="medium" disabled="true" value="%{pancard.refSrlNo}"/></s:else>
					</div>
                     <div class="line">
						<s:if test="%{pancard == null || (hasFieldErrors() && action.contains('pancard'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="pancard.docCopy" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="pancard.docCopy" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=pancard" target = "_blank"><s:property value="pancard.docCopyFileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                    	<s:if test="%{pancard == null ||  (hasFieldErrors() && !update && action.contains('pancard'))}"><button type="submit" class="green medium" name="action:addImportantDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('pancard')}">
                    		<div id="pc_edit" style="display:none;float:right;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pc_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pc_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="pc_edit" style="float:right;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="pc_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="pc_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>   		
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Other</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('otherimp')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="oi_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Other Doc Type & No.</label>
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}"><s:textfield name="otherimp.idNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="otherimp.idNo" cssClass="medium" disabled="true" value="%{otherimp.idNo}"/></s:else>
					</div>
					<div class="line">
						<label>Date of Issue</label>
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}"><s:textfield name="otherimp.dateOfIssue" cssClass="datepicker" /></s:if>
						<s:else><s:textfield name="otherimp.dateOfIssue" cssClass="datepicker" disabled="true" value="%{otherimp.dateOfIssue}"/></s:else>
					</div>
					<div class="line">
						<label>Place of Issue</label>
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}"><s:textfield name="otherimp.placeOfIssue" cssClass="medium" /></s:if>
						<s:else><s:textfield name="otherimp.placeOfIssue" cssClass="medium" disabled="true" value="%{otherimp.placeOfIssue}"/></s:else>
					</div>
                    <div class="line">
						<label>Country & Region</label>
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}"><s:textfield name="otherimp.country" cssClass="medium" /></s:if>
						<s:else><s:textfield name="otherimp.country" cssClass="medium" disabled="true" value="%{otherimp.country}"/></s:else>
					</div>
                    <div class="line">
						<label>Ref serial no.</label>
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}"><s:textfield name="otherimp.refSrlNo" cssClass="medium" /></s:if>
						<s:else><s:textfield name="otherimp.refSrlNo" cssClass="medium" disabled="true" value="%{otherimp.refSrlNo}"/></s:else>
					</div>
                     <div class="line">
						<s:if test="%{otherimp == null || (hasFieldErrors() && action.contains('otherimp'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="otherimp.docCopy" cssClass="medium"/></s:if>
						<s:else><label>Document Copy</label>
							<s:file name="otherimp.docCopy" disabled="true" cssClass="medium"/>
							<div style="float: right"><a href = "showDoc?docName=otherimp" target = "_blank"><s:property value="otherimp.docCopyFileName" /></a></div>
						</s:else>
					</div>
                   <div class="submitbtn">
                   		<s:if test="%{otherimp == null ||  (hasFieldErrors() && !update && action.contains('otherimp'))}"><button type="submit" class="green medium" name="action:addImportantDoc"><span>Sumbit</span></button></s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('otherimp')}">
                    		<div id="oi_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="oi_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="oi_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="oi_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="oi_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="oi_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateImportantDoc"><span>Update</span></button>&nbsp;</div>   		
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