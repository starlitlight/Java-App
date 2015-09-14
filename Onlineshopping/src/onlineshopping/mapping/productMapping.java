package onlineshopping.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import onlineshopping.bean.Product;
import onlineshopping.db.EntityMapping;


public class productMapping implements EntityMapping {

	@Override
	public Product mapping(ResultSet rs) throws SQLException {

		Product product = new Product(
				
		rs.getInt("productId"), 
		rs.getString("productName"),
		rs.getFloat("price"),
		rs.getString("context"),
		rs.getString("image"),
		rs.getInt("quantity"),
		rs.getString("categoryName"));
		
		return product;

	}
}
