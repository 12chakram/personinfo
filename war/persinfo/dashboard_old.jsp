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
		<h1><a href="#">Pte Cloud</a></h1>
		<ul>
			<li><a href="#"><span>Settings</span></a></li>
			<li class="usermessage"><a href="#"><span>1 new message</span></a></li>
			<li class="logout"><a href="logout"><span>Logout</span></a></li>
		</ul>
	</div>
	
	<div class="menu-search">
		<ul> 
			<li class="current"><a>Dashboard</a></li> 
			<li><a href="personalinfo">Personal Info</a></li> 
			<li><a href="vehicleinfo">Vehicle Info</a></li>
			<li><a href="memorabledays">Memorable Days</a></li>
			<li><a href="importantdocs">Important Docs</a></li>
			<li><a href="properties">Properties</a></li>
		</ul>
		<div class="search">
			<form action="" method="post">
				<input type="text" value="Seachterm" />
				<button type="submit"></button>
			</form> 
		</div>
	</div>
	
	<div class="breadcrumbs">
		<ul>
			<li class="home"><a href="#"></a></li>
			<li class="break">&#187;</li>
			<li><a href="#">Menu item</a></li>
			<li class="break">&#187;</li>
			<li><a href="#">Menu item</a></li>
		</ul>
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
					<a href="#" class="button blue">Edit Info</a>
				</div>
				<div class="message">
					<h3>This is a title</h3>
					Etiam et tristique nisi. Vestibulum non
					massa nec dui aliquet ultrices. Suspe
					id lacus augue, eu cursus.<br />
					<a href="#" class="button blue">Read more</a>
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
							<th>Status</th>
							<th>Date created</th>
							<th>Author</th>
							<th></th>
						</tr> 
					</thead> 
					<tbody>
					<s:iterator value="user.messages"> 
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#"><s:property value = "%{title}" /></a></td>
							<td><s:property value = "%{status}" /></td>
							<td><s:property value = "%{dateCreated}" /></td>
							<td><s:property value = "%{authorFname}" />, <s:property value = "%{authorLname}" /></td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
					</s:iterator>
					<!-- 	<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Vestibulum ante ipsum primis</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Quisque nulla libero</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Donec pretium scelerisque mi id</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Nam porttitor dictum arcu</a></td>
							<td>Draft</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
							</td>
						</tr>
						<tr> 
							<td><input type="checkbox" name="check" /></td>
							<td><a href="#">Duis suscipit mollis consectetur</a></td>
							<td>Published</td>
							<td>26th August 2011</td>
							<td>First, Lastname</td>
							<td>
								<a href="#"><img src="./gfx/icon-edit.png" alt="edit" /></a>
								<a href="#"><img src="./gfx/icon-delete.png" alt="delete" /></a>
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