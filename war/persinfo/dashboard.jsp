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
	
	<!--[if lte IE 8]>
		<script type="text/javascript" src="js/excanvas.min.js"></script>
	<![endif]-->

</head>

<body>

<div class="container">   
  
	<div class="logo-labels">
		<h1><a href="#">Pte Cloud</a></h1>
		<ul>
			<li><a href="editinfo"><span>Settings</span></a></li>
			<li class="logout"><a href="logout"><span>Logout</span></a></li>
		</ul>
	</div>
	
	<div class="menu-search">
		<ul> 
			<li class="current"><a>Dashboard</a></li> 
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
		<div class="box small">
			<div class="title">
				<h2>My Account</h2>
				<span class="hide"></span>
			</div>
			<div class="content">
				<div class="message">
					<h3>Mr. <s:property value = "%{user.fname}" /> <s:property value = "%{user.lname}" /></h3>
					Username:<s:property value = "%{user.uname}" /><br />
                    Address: <s:property value = "%{user.address}" />
					<div><a href="editinfo" class="button blue">Edit Info</a></div>
				</div>
				<div class="message">
				<s:if test="msgs == null">
					<h3>You don't have messages to display</h3>
				</s:if>
				<s:else><h3>New Message!</h3>
					<s:property value="msgs[0].subject" />
					<br />
					<s:a  action="showmessage" cssClass="button blue">Read more</s:a>
				</s:else>
				</div>
			</div>
		</div>
	
		<div class="box big">
			<div class="title">
				<h2>Messages</h2>
				<span class="hide"></span>
			</div>
			<div class="content">
				<table cellspacing="0" cellpadding="0" border="0" class="table-all"> 
					<thead> 
						<tr> 
							<th><input type="checkbox" name="check" class="checkall" /></th>
							<th>Title</th>
							<th>Date</th>
						</tr> 
					</thead> 
					<tbody> 
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<s:iterator value="msgs">
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#"><s:property value="subject" /></a></td>
							<td>
								<s:property value="msgDate" />
							</td>
						</tr>
						</s:iterator>
						<!-- <tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>
								12/12/2011
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>
								12/12/2011
							</td>
						</tr> -->
					</tbody> 
				</table>
				<div id="pager" class="pager">
				  <form action="">
						<button type="submit" class="red"><span>Delete</span></button>
						<div>
							<img src="./gfx/table-first.gif" class="first" alt="First" />
							<img src="./gfx/table-prev.gif" class="prev" alt="Previous" />
							<input type="text" class="pagedisplay"/>
							<img src="./gfx/table-next.gif" class="next" alt="Next" />
							<img src="./gfx/table-last.gif" class="last" alt="Last" />
						</div>
						<select class="pagesize">
							<option selected="selected" value="5">5</option>
							<option value="10">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
						</select>
					</form>
				</div>
			</div>
		</div>
	</div>
<div class="section">
		<div class="box small">
			<div class="title">
				<h2>Advertisments</h2>
				<span class="hide"></span>
			</div>
			<div class="content">
				<div class="ad1">
                	<img src="http://www.google.com/help/hc/images/adsense_185666_adformat-display_200x200_en.jpg" alt="" />
                </div>
				
			</div>
		</div>
	
		<div class="box big">
			<div class="title">
				<h2>Your PteCloud Information Overview</h2>
				<span class="hide"></span>
			</div>
			<div class="content">
				<s:if test="%{vehicles == null && insdocs == null && impdocs == null}">
				You don''t have anything to display here.
				</s:if>
				<s:if test="%{vehicles != null && !vehicles.isEmpty()}">
					<h3 class="subtitle">Vechicle Info</h3>
	                <ul>
	                	<s:iterator value="vehicles">
	                		<li><a href="vehicleinfo"><s:property value="make" /></a></li>
	                	</s:iterator>
	                    	<!-- <li><a href="#">Two Wheeler Hondo Dio - KA 05 MH 3252</a></li> -->
	               </ul>
               </s:if>
               <s:if test="%{insdocs != null && !insdocs.isEmpty()}">
					<h3 class="subtitle">Policies Documents</h3>
	                <ul>
	                	<s:iterator value="insdocs">
	                		<li><a href="insurancedocs">Policy <s:property value="polDocSeq" /> - <s:property value="polName" />, <s:property value="dateOfRnwl" /></a></li>
	                	</s:iterator>
	               </ul>
               </s:if>
              	<s:if test="%{impdocs != null && !impdocs.isEmpty()}">
					<h3 class="subtitle">Important Documents</h3>
	                <ul>
	                	<s:iterator value="impdocs">
	                		<li><a href="importantdocs"><s:property value="docType" /> - <s:property value="idNo" />, <s:property value="dateOfIssue" /></a></li>
	                	</s:iterator>
	               </ul>
               </s:if>              
				
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