<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=gbk"%>
<%@page import="onlineshopping.bean.Product"%>
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
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#home" data-toggle="tab">Home</a></li>
			<li class=""><a href="#user" data-toggle="tab">User</a></li>
			<li class=""><a href="#product" data-toggle="tab">Product</a></li>
			<li class=""><a href="#cart" data-toggle="tab">Cart</a></li>
			<li class=""><a href="#category" data-toggle="tab">Category</a></li>
			<li class=""><a
				href="<%=request.getContextPath()%>/bootstrap/index.jsp">Go
					HomePage</a></li>
		</ul>
	</div>

	<%
		Product product = (Product)request.getAttribute("product");
	%>
	
	<!-- Edit Product  form -->
	<div class="container">
		<form class="form-horizontal"
			action="<%=request.getContextPath()%>/UpdateProductServlet?productId=<%=product.getProductId()%>"
			name="saveUser" method="post">
			<fieldset>
				<legend>Edit Product Info</legend>
				<div class="form-group">
					<label for="productName" class="col-xs-2 control-label">Product Name</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="productName"
							value="<%=product.getProductName() %>">
					</div>
				</div>

				<div class="form-group">
					<label for="price" class="col-xs-2 control-label">Price</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="price"
							value="<%= product.getPrice() %>">
					</div>
				</div>

				<div class="form-group">
					<label for="context" class="col-xs-2 control-label">Context</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="context"
							value="<%=product.getContext() %>">
					</div>
				</div>

				<div class="form-group">
					<label for="image" class="col-xs-2 control-label">Image</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="image"
							value="<%=product.getImage() %>">
					</div>
				</div>
				
				<div class="form-group">
					<label for="quantity" class="col-xs-2 control-label">Quantity</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="quantity"
							value="<%=product.getQuantity() %>">
					</div>
				</div>

				<div class="form-group">
					<label for="categoryName" class="col-xs-2 control-label">Category Name</label>
					<div class="col-xs-10">
						<input type="text" class="form-control" name="categoryName"
							value="<%=product.getCategoryName() %>">
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
	
</body>

</html>
