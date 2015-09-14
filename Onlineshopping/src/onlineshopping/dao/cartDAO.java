package onlineshopping.dao;

import java.sql.SQLException;
import java.util.List;

import onlineshopping.bean.Cart;
import onlineshopping.bean.Product;
import onlineshopping.bean.User;
import onlineshopping.db.JdbcTemplate;
import onlineshopping.mapping.cartMapping;
import onlineshopping.mapping.productMapping;


public class cartDAO {
	
	JdbcTemplate jdbctemplate = new JdbcTemplate();
	
	public List<Cart> findAll() {
		String sql = " SELECT cartId,productId,amount, userId FROM cart";
		List<Cart> carts = null;
		try {
			carts = jdbctemplate.select(sql, new cartMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION cart");
			e.printStackTrace();
		}
		return carts;

	}
	
	
	public List<Cart> findCartByUserId(int userId) {
		String sql = " SELECT cartId,productId,amount, userId FROM cart WHERE userId ="
				+ userId ;
		List<Cart> carts = null;
		try {
			carts = jdbctemplate.select(sql, new cartMapping());
			
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION 1");
			e.printStackTrace();
			e.getMessage();
		}
		return carts;
	}

	public List<Product> findCartByproductId(int productId) {
		String sql = " SELECT cartId, productId, amount, userId FROM cart WHERE productId ="
				+ productId ;
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
	
	public boolean save(Cart cart) {
		String sql = "INSERT INTO cart(productId, amount, userId)"
				+ " VALUES(?,?,?)";
		Object[] values = new Object[] { cart.getProductId(), cart.getAmount(),
				cart.getUserId()};
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
	
	public boolean delete(int cartId){
		String sql = "DELETE FROM cart WHERE cartId = " + cartId;
		
		try {
			return (jdbctemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION 1");
			e.printStackTrace();
		}
		return false;
	}
	
	

}
