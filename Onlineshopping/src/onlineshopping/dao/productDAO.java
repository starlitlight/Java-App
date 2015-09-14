package onlineshopping.dao;

import java.sql.SQLException;
import java.util.List;

import onlineshopping.bean.Product;
import onlineshopping.bean.User;
import onlineshopping.db.JdbcTemplate;
import onlineshopping.mapping.productMapping;

public class productDAO {

	JdbcTemplate jdbctemplate = new JdbcTemplate();

	public List<Product> findAll() {
		String sql = " SELECT productId,productName,price,context,image,quantity,categoryName FROM product";
		List<Product> products = null;
		try {
			products = jdbctemplate.select(sql, new productMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION product");
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> findByCategoryName(String cname) {
		String sql = " SELECT productId,productName,price,context,image,quantity, categoryName FROM product WHERE categoryName="
				+ "'" + cname + "'";
		List<Product> products = null;
		try {
			products = jdbctemplate.select(sql, new productMapping());

		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
			e.getMessage();
		}
		return products;
	}

	public Product findById(int id) {
		String sql = "SELECT productId, productName,price,context,image, quantity, categoryName FROM product WHERE productId ="
				+ id;
		Product product = null;
		try {
			// List entitys = jdbctemplate.select(sql, new productMapping());
			// product = (Product) entitys.get(0);
			product = (Product) jdbctemplate.select(sql, new productMapping())
					.get(0);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}
		return product;
	}

	public boolean delete(int productId) {
		String sql = "DELETE FROM product WHERE productId = " + productId;

		try {
			return (jdbctemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION product delete");
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Product product) {

		System.out.println("eee");

		String sql = " UPDATE product SET productName=?, price=?, context=?, image=?, quantity=?, categoryName=? WHERE productId = ?";

		Object[] values = new Object[] { product.getProductName(),
				product.getPrice(), product.getContext(), product.getImage(),
				product.getQuantity(), product.getCategoryName(),
				product.getProductId() };

		int rows = 0;
		try {
			rows = jdbctemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION product update");
			e.printStackTrace();
		}
		return (rows == 1);

	}

	public boolean save(Product product) {
		String sql = "INSERT INTO product(productName, price, context, image, quantity, categoryName)"
				+ " VALUES(?,?,?,?,?,?)";
		Object[] values = new Object[] { product.getProductName(),
				product.getPrice(), product.getContext(), product.getImage(),
				product.getQuantity(), product.getCategoryName() };
		int rows = 0;
		try {
			rows = jdbctemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}
		return (rows == 1);
	}

}
