<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=gbk"%>
<%@page import="onlineshopping.bean.Category"%>
<%@page import="onlineshopping.bean.User"%>
<%@page import="onlineshopping.dao.categoryDAO"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>Shopping Online</title>

<!-- Bootstrap core JavaScript================================================== -->
<link href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css"
	rel="stylesheet">

<!-- Bootstrap core JavaScript================================================== -->
<script language="JavaScript" type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/jquery-2.1.1.js"></script>
<script language="JavaScript" type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.js"></script>
</head>

<body>
	<!-- Navigation ================================================== -->
	<div class="container">
		<div class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"
						href="<%=request.getContextPath()%>/bootstrap/index.jsp">My
						Shop</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
					<% 
						if(session.getAttribute("user")==null){
					%>
						<li class="hidden"><a
							href="<%=request.getContextPath()%>/bootstrap/userProfile.jsp">Profile</a></li>
						<li class="hidden"><a
							href="<%=request.getContextPath()%>/bootstrap/shoppingCart.jsp">Shopping
								Cart</a></li>
						<%
								}else{
								%>
						<li><a
							href="<%=request.getContextPath()%>/bootstrap/userProfile.jsp">Profile</a></li>
						<li><a
							href="<%=request.getContextPath()%>/bootstrap/shoppingCart.jsp">Shopping
								Cart</a></li>

						<%}%>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Products<b class="caret"></b></a>
							<ul class="dropdown-menu">
								<%
									categoryDAO categorydao = new categoryDAO();
									List<Category> categorys = categorydao.findAll();
									Map map = new HashMap();
									for (Category category : categorys) {
										String categoryName = category.getCategoryName();
										int cagetoryId = category.getCategoryId();
										if (map.get(categoryName) == null) {
											map.put(categoryName, category);
										} else {
											// exist a duplicate name category object
										}
									}
									ArrayList<Category> nonDuplicateNameMap = new ArrayList<Category>(
											map.values());
								%>
								<%
									for (int i = 0; i < nonDuplicateNameMap.size(); i++) {
										String name = ((Category) nonDuplicateNameMap.get(i))
												.getCategoryName();
								%>
								<li><a
									href="<%=request.getContextPath()%>/FindProductByCategoryNameServlet?categoryName=<%=name%>">
										<%=name%>
								</a></li>
								<%
									}
								%>
							</ul></li>

					</ul>
					<%
						if(session.getAttribute("user")==null){
					%>

					<ul class="nav navbar-nav navbar-right">
						<li><a href="" data-toggle="modal" data-target="#loginModal">Login</a></li>
					</ul>
					<%
						}else{
							User user = (User)session.getAttribute("user");
							String username = user.getName();
					%>
					<ul class="nav navbar-nav navbar-right">
						<li><a
							href="<%=request.getContextPath()%>/bootstrap/userProfile.jsp"><%=username %></a></li>
					</ul>
					<%} %>
					
				</div>

				<!-- LoginModal -->
				<div class="modal fade" id="loginModal" tabindex="0" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-sm">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Sign in</h4>
							</div>
							<div class="modal-body">
								<div style="height: 180px;">
									<form action="<%=request.getContextPath()%>/LoginServlet"
										method="post">
										<div class="col-xs-12" style="margin-bottom: 10px;">
											<span id="logininfobox" class="label label-danger"
												style="display: none;"></span>
										</div>
										<div class="col-xs-12" style="margin-bottom: 10px;">
											<input class="form-control" placeholder="Username"
												name="username"></input>
										</div>
										<div class="col-xs-12">
											<input class="form-control" placeholder="Password"
												name="password"></input>
										</div>
										<div class="col-xs-12">
											<div class="checkbox">
												<label> <input type="checkbox"> Remember me
												</label>
											</div>
										</div>
										<div class="col-xs-4">
											<button type="submit" class="btn btn-primary"
												onclick="login();">Sign in</button>
										</div>

										<div class="col-xs-offset-2 col-xs-6"
											style="line-height: 34px;">
											<a href="<%=request.getContextPath()%>/bootstrap/signup.jsp">Sign
												up here</a>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- End loginModal -->

				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</div>
		<!-- Static navbar -->
	</div>
	<!-- /container -->

	<!-- Sign up form -->
	<div class="container">
		<form class="form-horizontal" action="<%=request.getContextPath()%>/SaveProductServelt" name="saveProduct" method="post">
			<fieldset>
				<legend>Add Product</legend>
				<div class="form-group">
					<label for="username" class="col-xs-2 control-label">Product Name</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="productName"
							placeholder="productName">
					</div>
				</div>
				
				<div class="form-group">
					<label for="password" class="col-xs-2 control-label">Price</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="price"
							placeholder="xx.xx">
					</div>
				</div>
				
				<div class="form-group">
					<label for="email" class="col-xs-2 control-label">Context</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="context"
							placeholder="information for product">
					</div>
				</div>
				
				<div class="form-group">
					<label for="address" class="col-xs-2 control-label">Image</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="image"
							placeholder="CategoryName/name.jpg">
					</div>
				</div>
				
				<div class="form-group">
					<label for="address" class="col-xs-2 control-label">Quantity</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="quantity"
							placeholder="quantity">
					</div>
				</div>
				
				<div class="form-group">
					<label for="address" class="col-xs-2 control-label">CategoryName</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="categoryName"
							placeholder="Give a category name">
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-10 col-lg-offset-2">
						<button class="btn btn-default">Cancel</button>
						<button type="submit" value="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>

			</fieldset>
		</form>
		</div>

</body>

</html>
