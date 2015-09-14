package onlineshopping.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import onlineshopping.bean.User;
import onlineshopping.db.EntityMapping;


public class userMapping implements EntityMapping{

	public User mapping(ResultSet rs) throws SQLException {

		User customer = new User(
			
			rs.getInt("userId"),
			rs.getString("name"),
			rs.getString("password"),
			rs.getString("email"),
			rs.getString("address"),
			rs.getInt("cartId")
		);
		
		return customer;
	}
	
	

}
