<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%><!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
    $("#dl_edit").click(function(e) {
    	var $inputs = $('#dl_form :input');
        $inputs.each(function() {
            $(this).removeAttr('disabled');
        });
		$("#dl_edit").hide();
        $("#dl_submit").show();
		$("#dl_cancel").show();
    });
	$("#dl_cancel").click(function(e) {
		 var $inputs = $('#dl_form :input');
	        $inputs.each(function() {
	            $(this).attr('disabled','disabled');
	        });
        $("#dl_edit").show();
		$("#dl_submit").hide();
		$("#dl_cancel").hide();
    });
	
	//Birth Form
	 $("#v1_edit").click(function(e) {
	    	var $inputs = $('#v1_form :input');
	        $inputs.each(function() {
	            $(this).removeAttr('disabled');
	        });
			$("#v1_edit").hide();
	        $("#v1_submit").show();
			$("#v1_cancel").show();
	    });
		$("#v1_cancel").click(function(e) {
			 var $inputs = $('#v1_form :input');
		        $inputs.each(function() {
		            $(this).attr('disabled','disabled');
		        });
	        $("#v1_edit").show();
			$("#v1_submit").hide();
			$("#v1_cancel").hide();
	    });
		
		
		//Education Form
		 $("#v2_edit").click(function(e) {
		    	var $inputs = $('#v2_form :input');
		        $inputs.each(function() {
		            $(this).removeAttr('disabled');
		        });
				$("#v2_edit").hide();
		        $("#v2_submit").show();
				$("#v2_cancel").show();
		    });
			$("#v2_cancel").click(function(e) {
				 var $inputs = $('#v2_form :input');
			        $inputs.each(function() {
			            $(this).attr('disabled','disabled');
			        });
		        $("#v2_edit").show();
				$("#v2_submit").hide();
				$("#v2_cancel").hide();
		    });
			
			
			//Professional Form
			 $("#v3_edit").click(function(e) {
			    	var $inputs = $('#v3_form :input');
			        $inputs.each(function() {
			            $(this).removeAttr('disabled');
			        });
					$("#v3_edit").hide();
			        $("#v3_submit").show();
					$("#v3_cancel").show();
			    });
				$("#v3_cancel").click(function(e) {
					 var $inputs = $('#v3_form :input');
				        $inputs.each(function() {
				            $(this).attr('disabled','disabled');
				        });
			        $("#v3_edit").show();
					$("#v3_submit").hide();
					$("#v3_cancel").hide();
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
			<li class="current"><a>Vehicle Info</a></li>
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
				<h2>Driving License</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
				<s:if test="%{action.contains('DrivingLicense')}">
					<div id="fieldError">
		    			<s:fielderror />
					</div>
				</s:if>
				<form id="dl_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>Issued Authority / Dept.</label>
						<s:if test="%{dlicense == null ||  (hasFieldErrors() && action.contains('DrivingLicense'))}"><s:textfield name = "dlicense.issuedAuth" cssClass="small" /></s:if>
						<s:else><s:textfield cssClass="medium" name ="dlicense.issuedAuth" disabled="true"  value="%{dlicense.issuedAuth}" /></s:else>
					</div>
					<div class="line">
						<label>Validity (From - To)</label>
						<s:if test="%{dlicense == null ||  (hasFieldErrors() && action.contains('DrivingLicense'))}"><s:textfield name = "dlicense.validFrm" cssClass="datepicker" /> 
                        <s:textfield name = "dlicense.validTo" cssClass="datepicker" /> </s:if>
                        <s:else><s:textfield cssClass="datepicker" name ="dlicense.validFrm" disabled="true"  value="%{dlicense.validFrm}" /> 
                        <s:textfield cssClass="datepicker" name ="dlicense.validTo" disabled="true"  value="%{dlicense.validTo}" /></s:else>
					</div>
					<div class="line">
						<label>License No./State & Country</label>
						<s:if test="%{dlicense == null ||  (hasFieldErrors() && action.contains('DrivingLicense'))}"><s:textfield name = "dlicense.licenseNo" cssClass="medium" /></s:if>
						<s:else><s:textfield cssClass="medium" name ="dlicense.licenseNo"  disabled="true"  value="%{dlicense.licenseNo}" /></s:else>
					</div>
					<div class="line">
   						<s:if test="%{dlicense == null || (hasFieldErrors() && action.contains('DrivingLicense'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="dlicense.dlDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="dlicense.dlDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=dldoc" target = "_blank"><s:property value="dlicense.dlDocFileName"></s:property></a></div>					
						</s:else>
					</div>
					<div class="submitbtn">
						<s:if test="%{dlicense == null ||  (hasFieldErrors() && !update && action.contains('DrivingLicense'))}">
							<button type="submit" class="green medium" name="action:addDrivingLicense"><span>Sumbit</span></button>
						</s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('DrivingLicense')}">
                    		<div id="dl_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="dl_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="dl_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateDrivingLicense"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="dl_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="dl_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="dl_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateDrivingLicense"><span>Update</span></button>&nbsp;</div>
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
		<div class="box medium">
			<div class="title">
				<h2>Vehicle 1</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
			<s:if test="%{action.contains('VehicleOne')}">
				<div id="fieldError">
	    			<s:fielderror />
				</div>
			</s:if>
				<form id="v1_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>First owner / Second Party / Third Party</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.owner" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle1.owner"  disabled="true"  value="%{vehicle1.owner}" /></s:else>
					</div>
					<div class="line">
						<label>Vehicle Make & Model</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.make" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle1.make"  disabled="true"  value="%{vehicle1.make}" /></s:else>
					</div>
					<div class="line">
						<label>Registration Number</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.regNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle1.regNo"  disabled="true"  value="%{vehicle1.regNo}" /></s:else>
					</div>
                    <div class="line">
						<label>Engine/Chassi number</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.engNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle1.engNo"  disabled="true"  value="%{vehicle1.engNo}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance Company</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:select headerKey="" cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle1.insComp"/></s:if>
						<s:else><s:select disabled="true" headerKey="" cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle1.insComp" value="%{vehicle1.insComp}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance No</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.insNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle1.insNo"  disabled="true"  value="%{vehicle1.insNo}" /></s:else>
					</div>
					<div class="line">
						<label>Validity</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.validity" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle1.validity"  disabled="true"  value="%{vehicle1.validity}" /></s:else>
					</div>
                    <div class="line">
						<label>Renewal Date</label>
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && action.contains('VehicleOne'))}"><s:textfield name = "vehicle1.renwlDate" cssClass="datepicker"/></s:if>
						<s:else><s:textfield cssClass="datepicker" name ="vehicle1.renwlDate"  disabled="true"  value="%{vehicle1.renwlDate}" /></s:else>
					</div>
					<div class="line">
   						<s:if test="%{vehicle1 == null || (hasFieldErrors() && action.contains('VehicleOne'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="vehicle1.rcDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="vehicle1.rcDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=vehicle1rcdoc" target = "_blank"><s:property value="vehicle1.rcDocFileName"></s:property></a></div>					
						</s:else>
					</div>
					<div class="submitbtn">
						<s:if test="%{vehicle1 == null ||  (hasFieldErrors() && !update && action.contains('VehicleOne'))}">
							<button type="submit" class="green medium" name="action:addVehicle"><span>Sumbit</span></button>
						</s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('VehicleOne')}">
                    		<div id="v1_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v1_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v1_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="v1_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v1_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v1_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	</div>
	
	<div class="section">
		<div class="box medium">
			<div class="title">
				<h2>Vehicle 2</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
			<s:if test="%{action.contains('VehicleTwo')}">
				<div id="fieldError">
	    			<s:fielderror />
				</div>
			</s:if>
				<form id="v2_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>First owner / Second Party / Third Party</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.owner" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle2.owner"  disabled="true"  value="%{vehicle2.owner}" /></s:else>
					</div>
					<div class="line">
						<label>Vehicle Make & Model</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.make" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle2.make"  disabled="true"  value="%{vehicle2.make}" /></s:else>
					</div>
					<div class="line">
						<label>Registration Number</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.regNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle2.regNo"  disabled="true"  value="%{vehicle2.regNo}" /></s:else>
					</div>
                    <div class="line">
						<label>Engine/Chassi number</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.engNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle2.engNo"  disabled="true"  value="%{vehicle2.engNo}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance Company</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:select headerKey=""  cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle2.insComp"/></s:if>
						<s:else><s:select disabled="true"  headerKey=""  cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle2.insComp"  value="%{vehicle2.insComp}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance No</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.insNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle2.insNo"  disabled="true"  value="%{vehicle2.insNo}" /></s:else>
					</div>
					<div class="line">
						<label>Validity</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.validity" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle2.validity"  disabled="true"  value="%{vehicle2.validity}" /></s:else>
					</div>
                    <div class="line">
						<label>Renewal Date</label>
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && action.contains('VehicleTwo'))}"><s:textfield name = "vehicle2.renwlDate" cssClass="datepicker"/></s:if>
						<s:else><s:textfield cssClass="datepicker" name ="vehicle2.renwlDate"  disabled="true"  value="%{vehicle2.renwlDate}" /></s:else>
					</div>
					<div class="line">
   						<s:if test="%{vehicle2 == null || (hasFieldErrors() && action.contains('VehicleTwo'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="vehicle2.rcDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="vehicle2.rcDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=vehicle2rcdoc" target = "_blank"><s:property value="vehicle2.rcDocFileName"></s:property></a></div>					
						</s:else>
					</div>
					<div class="submitbtn">
						<s:if test="%{vehicle2 == null ||  (hasFieldErrors() && !update && action.contains('VehicleTwo'))}">
							<button type="submit" class="green medium" name="action:addVehicle"><span>Sumbit</span></button>
						</s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('VehicleTwo')}">
                    		<div id="v2_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v2_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v2_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="v2_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v2_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v2_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
                    	</s:else>
                    </div>
				</form>
			</div>
		</div>
	
		<div class="box medium">
			<div class="title">
				<h2>Vehicle 3</h2>
				<span class="hide"></span>
			</div>
			<div class="content forms">
			<s:if test="%{action.contains('VehicleThree')}">
				<div id="fieldError">
	    			<s:fielderror />
				</div>
			</s:if>
				<form id="v3_form" method="post" enctype="multipart/form-data">
					<div class="line">
						<label>First owner / Second Party / Third Party</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.owner" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle3.owner"  disabled="true"  value="%{vehicle3.owner}" /></s:else>
					</div>
					<div class="line">
						<label>Vehicle Make & Model</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.make" cssClass="medium"/></s:if>
						<s:else><s:textfield cssClass="medium" name ="vehicle3.make"  disabled="true"  value="%{vehicle3.make}" /></s:else>
					</div>
					<div class="line">
						<label>Registration Number</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.regNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle3.regNo"  disabled="true"  value="%{vehicle3.regNo}" /></s:else>
					</div>
                    <div class="line">
						<label>Engine/Chassi number</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.engNo" cssClass="small" /></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle3.engNo"  disabled="true"  value="%{vehicle3.engNo}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance Company</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:select headerKey=""  cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle3.insComp"/></s:if>
						<s:else><s:select disabled="true" headerKey=""  cssClass="medium" headerValue="Select Insurance Company" list="insCompanies" name="vehicle3.insComp" value="%{vehicle3.insComp}" /></s:else>
					</div>
					<div class="line">
						<label>Insurance No</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.insNo" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle3.insNo"  disabled="true"  value="%{vehicle3.insNo}" /></s:else>
					</div>
					<div class="line">
						<label>Validity</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.validity" cssClass="small"/></s:if>
						<s:else><s:textfield cssClass="small" name ="vehicle3.validity"  disabled="true"  value="%{vehicle3.validity}" /></s:else>
					</div>
                    <div class="line">
						<label>Renewal Date</label>
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && action.contains('VehicleThree'))}"><s:textfield name = "vehicle3.renwlDate" cssClass="datepicker"/></s:if>
						<s:else><s:textfield cssClass="datepicker" name ="vehicle3.renwlDate"  disabled="true"  value="%{vehicle3.renwlDate}" /></s:else>
					</div>
					<div class="line">
   						<s:if test="%{vehicle3 == null || (hasFieldErrors() && action.contains('VehicleThree'))}">
						<p>Upload your document copy</p>
						<label>File Upload</label>
						<s:file name="vehicle3.rcDoc" />
						</s:if>
						<s:else><label>Document Copy</label>
							<s:file name="vehicle3.rcDoc" disabled="true"/>
							<div style="float: right"><a href = "showDoc?docName=vehicle3rcdoc" target = "_blank"><s:property value="vehicle3.rcDocFileName"></s:property></a></div>					
						</s:else>
					</div>
					<div class="submitbtn">
						<s:if test="%{vehicle3 == null ||  (hasFieldErrors() && !update && action.contains('VehicleThree'))}">
							<button type="submit" class="green medium" name="action:addVehicle"><span>Sumbit</span></button>
						</s:if>
                    	<s:elseif test="%{hasFieldErrors() && update && action.contains('VehicleThree')}">
                    		<div id="v3_edit" style="display:none;"><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v3_cancel" style="float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v3_submit" style="float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
                    	</s:elseif>
                    	<s:else>
                    		<div id="v3_edit" ><button type="button" class="green medium"><span>Edit</span></button></div>
                    		<div id="v3_cancel" style="display:none;float:right;"><button type="button" class="green medium" ><span>Cancel</span></button></div>
                    		<div id="v3_submit" style="display:none;float:right;"><button type="submit" class="green medium" name="action:updateVehicle"><span>Update</span></button>&nbsp;</div>
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