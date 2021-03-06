<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=gbk"%>
<%@page import="onlineshopping.bean.Product"%>
<%@page import="onlineshopping.bean.Category"%>
<%@page import="onlineshopping.bean.User"%>
<%@page import="onlineshopping.dao.categoryDAO"%>
<%@page import="onlineshopping.dao.productDAO"%>
<%@page import="onlineshopping.dao.productDAO"%>




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

	<!-- Left sliderbar  ================================================== -->
	<div class="container" style="margin-top: 30px;">
		<!-- Main -->
		<div class="row">
			<!-- Left sliderbar  ================================================== -->
			<div class="col-xs-3">
				<div id="sidebar">
					<h3>Categories</h3>
					<ul class="sidebar_menu">
						<%
							for (int i = 0; i < nonDuplicateNameMap.size(); i++) {
								String name = ((Category) nonDuplicateNameMap.get(i))
										.getCategoryName();
						%>
						<li><a
							href="FindProductByCategoryNameServlet?categoryName=<%=name%>">

								<%=name%>
						</a></li>
						<%
							}
						%>
					</ul>
					<h3>Search</h3>
					<p>Search the products.</p>
					<div id="products">
						<form action="#" method="get">
							<input type="text" value="products" name="email_newsletter"
								id="email_newsletter" title="email_newsletter"
								onfocus="clearText(this)" onblur="clearText(this)"
								class="txt_field"> <input type="submit" name="subscribe"
								value="products" alt="products" id="subscribebtn"
								title="products" class="subscribebtn">
						</form>
						<div class="cleaner"></div>
					</div>
				</div>
			</div>


			<!-- Right productList  ================================================== -->
			<%
				Product product = (Product) request.getAttribute("product");
			%>
			<div class="col-xs-8">
				<div id="content">
					<h2>Product Details</h2>
					<div class="row">
						<div class="col-xs-5">
							<a
								href="FindProductByIdServlet?productId=<%=product.getProductId()%>"><img
								src="<%=request.getContextPath()%>/bootstrap/img/<%=product.getImage()%>"
								alt="category 1" height="200" width="250"></a>
						</div>
						<div class="col-xs-7">
							<form class="form-horizontal"
								action="<%=request.getContextPath()%>/SaveCartServlet"
								name="saveCart" method="post">
								
								<div class="form-group">
									<label>Price:</label>
									<p><%=product.getPrice()%></p>
								</div>
								<div class="form-group">
									<label>Category:</label>
									<p><%=product.getCategoryName()%></p>
								</div>
								<div class="form-group">
									<label>Quantity:</label> <input type="text"
										class="form-control" name="amount" value="1">
								</div>
								<% 
									User user = (User)session.getAttribute("user");
									int userId = user.getUserId();
								%>
								<div class="form-group">
									<input type="text"
										class="hidden" name="userId" value="<%=userId %>">
								</div>
								<div class="form-group">
									<input type="text"
										class="hidden" name="productId" value="<%=product.getProductId() %>">
								</div>
								<div class="form-group">
									<button type="submit" class="btn btn-primary">
										Add to Cart <span class="glyphicon glyphicon-shopping-cart"></span>
									</button>
								</div>
								<div class="form-group">
									<label>Product Description</label>
									<p><%=product.getContext()%></p>
								</div>
							</form>

						</div>
					</div>
				</div>

				<h2>Other Products</h2>
					<%
						productDAO productdao = new productDAO();
						List<Product> productlists = productdao.findAll();
						for (Product productlist : productlists) {
					%>
					<div class="col-xs-3" style="padding-right: 0;">
						<a
							href="FindProductByIdServlet?productId=<%=productlist.getProductId()%>"><img
							src="<%=request.getContextPath()%>/bootstrap/img/<%=productlist.getImage()%>"
							alt="category 1" height="100" width="100"></a>
						<h5><%=productlist.getProductName()%></h5>
						<p class="product_price"><%=productlist.getPrice()%>
							Kr
						</p>
						<a
							href="FindCartByproductIdServlet?productId=<%=productlist.getProductId()%>">Add
							to Cart <span class="glyphicon glyphicon-shopping-cart"></span>
						</a>
					</div>
					<%
						}
					%>
					</div>

				</div>
		</div>
</body>

</html>
