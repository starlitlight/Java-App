package onlineshopping.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import onlineshopping.bean.Cart;
import onlineshopping.db.EntityMapping;

public class cartMapping implements EntityMapping{

	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		
		Cart cart = new Cart(
				rs.getInt("cartId"),
				rs.getInt("productId"),
				rs.getInt("amount"),
				rs.getInt("userId")
				);
		
		return cart;
	}

}
