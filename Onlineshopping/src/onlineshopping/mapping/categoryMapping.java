package onlineshopping.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import onlineshopping.bean.Category;
import onlineshopping.db.EntityMapping;

public class categoryMapping implements EntityMapping {

	@Override
	public Object mapping(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Category category = new Category(
				rs.getInt("categoryId"),
				rs.getInt("pId"),
				rs.getString("categoryName")
				);
		
		return category;
		
	}
	
	
	
	

}
