package onlineshopping.dao;

import java.sql.SQLException;
import java.util.List;

import onlineshopping.bean.Category;
import onlineshopping.db.JdbcTemplate;
import onlineshopping.mapping.categoryMapping;

public class categoryDAO {

	JdbcTemplate jdbctemplate = new JdbcTemplate();

	public List<Category> findAll() {

		List<Category> categorys = null;
		String sql = "SELECT categoryId,pId,categoryName FROM category";
		try {
			categorys = jdbctemplate.select(sql, new categoryMapping());

		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}

		return categorys;
	}

	public Category FindpIdByCategoryName(String categoryName) {
		String sql = "SELECT pId FROM category WHERE categoryName = " + categoryName;
		Category pId = null;
		try {
			pId = (Category) jdbctemplate.select(sql,
					new categoryMapping()).get(1);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}

		return pId;
	}
	
	public boolean delete(int categoryId) {
		String sql = "DELETE FROM category WHERE categoryId = " + categoryId;

		try {
			return (jdbctemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION category delete");
			e.printStackTrace();
		}
		return false;
	}

}
