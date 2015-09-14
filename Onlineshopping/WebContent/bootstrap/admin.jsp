<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=gbk"%>
<%@page import="onlineshopping.bean.Category"%>
<%@page import="onlineshopping.bean.User"%>
<%@page import="onlineshopping.bean.Product"%>
<%@page import="onlineshopping.bean.Cart"%>
<%@page import="onlineshopping.dao.cartDAO"%>
<%@page import="onlineshopping.dao.productDAO"%>
<%@page import="onlineshopping.dao.userDAO"%>
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
	

	<!-- Administration -->
	<%
		userDAO userdao = new userDAO();
		productDAO productdao = new productDAO();
		cartDAO cartdao = new cartDAO();
		categoryDAO categorydao = new categoryDAO();
		List<Category> categorys = categorydao.findAll();
		List<Cart> carts = cartdao.findAll();
		List<Product> products = productdao.findAll();
		List<User> users = userdao.findAll();
	%>
	
	
	<div class="container">
		<ul class="nav nav-tabs">
  			<li class="active"><a href="#user" data-toggle="tab">Home</a></li>
  			<li class=""><a href="#user" data-toggle="tab">User</a></li>
  			<li class=""><a href="#product" data-toggle="tab">Product</a></li>
  			<li class=""><a href="#cart" data-toggle="tab">Cart</a></li>
  			<li class=""><a href="#category" data-toggle="tab">Category</a></li>
  			<li class=""><a href="<%=request.getContextPath()%>/bootstrap/index.jsp">Go HomePage</a></li>
		</ul>
		
		<!--  Table for user-->
		<div id="AdminInfo" class="tab-content">
		<div class="tab-pane fade active in" id="user">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>User ID</th>
						<th>Name</th>
						<th>Password</th>
						<th>Address</th>
						<th>CartId</th>
					</tr>
				</thead>
				<%
					for (User user : users) {
				%>
				<tbody>
					<tr>
						<td><%=user.getUserId()%></td>
						<td><%=user.getName()%></td>
						<td><%=user.getPassword()%></td>
						<td><%=user.getAddress()%></td>
						<td><%=user.getCartId()%></td>
						<td><a
									href="<%=request.getContextPath()%>/DeleteUserServlet?userId=<%=user.getUserId()%>">
								DELETE</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
	
		
		
		<!--  Table for product-->
		<div class="tab-pane fade" id="product">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Product ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Context</th>
						<th>Image</th>
						<th>Quantity</th>
						<th>categoryName</th>
					</tr>
				</thead>
				<%
					for (Product product : products) {
				%>
				<tbody>
					<tr>
						<td><%=product.getProductId()%></td>
						<td><%=product.getProductName()%></td>
						<td><%=product.getPrice()%></td>
						<td><%=product.getContext()%></td>
						<td><%=product.getImage()%></td>
						<td><%=product.getQuantity()%></td>
						<td><%=product.getCategoryName()%></td>
						<td><a href="<%=request.getContextPath()%>/FindProductByIdAdminServlet?productId=<%=product.getProductId()%>">
								EDIT</a></td>
						<td><a href="<%=request.getContextPath()%>/DeleteProductServlet?productId=<%=product.getProductId()%>">
								DELETE</a></td>
					</tr>
					
				
				</tbody>
				<%
					}
				%>
				<th><Button><a href="<%=request.getContextPath()%>/bootstrap/saveProduct.jsp">Add</a></button></th>
			</table>
		</div>
		
		<!--  Table for Cart-->
		<div class="tab-pane fade" id="cart">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Cart ID</th>
						<th>Product ID</th>
						<th>Amount</th>
						<th>User ID</th>
					</tr>
				</thead>
				<%
					for (Cart cart : carts) {
				%>
				<tbody>
					<tr>
						<td><%=cart.getCartId()%></td>
						<td><%=cart.getProductId()%></td>
						<td><%=cart.getAmount()%></td>
						<td><%=cart.getUserId()%></td>
						<td><a href="<%=request.getContextPath()%>/DeleteCartServlet?cartId=<%=cart.getCartId()%>">
								DELETE</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
		
		<!--  Table for Category-->
		<div class="tab-pane fade" id="category">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>Category ID</th>
						<th>PID</th>
						<th>CategoryName</th>
					</tr>
				</thead>
				<%
					for (Category category : categorys) {
				%>
				<tbody>
					<tr>
						<td><%=category.getCategoryId()%></td>
						<td><%=category.getpId()%></td>
						<td><%=category.getCategoryName()%></td>
						<td><a href="<%=request.getContextPath()%>/DeleteCategoryServlet?categoryId=<%=category.getCategoryId()%>">
								DELETE</a></td>
					</tr>
				</tbody>
				<%
					}
				%>
			</table>
		</div>
		</div>
	</div>
</body>

</html>
