package onlineshopping.dao;

import java.sql.SQLException;
import java.util.List;

import onlineshopping.bean.User;
import onlineshopping.db.JdbcTemplate;
import onlineshopping.mapping.userMapping;

public class userDAO {

	private JdbcTemplate jdbctemplate = new JdbcTemplate();

	/**
	 * Excute add customer
	 * 
	 * @param customer
	 * @return boolean
	 */
	public boolean save(User user) {
		String sql = "INSERT INTO user(userId, name, password, email, address, cartId)"
				+ " VALUES(?,?,?,?,?,?)";
		Object[] values = new Object[] { user.getUserId(), user.getName(),
				user.getPassword(), user.getEmail(), user.getAddress(),
				user.getCartId() };
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

	/**
	 * Excute login
	 * 
	 * @param username
	 *            , password
	 * @return user
	 */
	public User Login(String username, String password) {
		User user = null;
		String sql = "SELECT userId, name, password, email, address, cartId FROM user where name = ?"
				+ "'" + username + "'" + ", password=?" + "'" + password + "'";
		try {
			List entitys = jdbctemplate.select(sql, new userMapping());
			user = (User) entitys.get(0);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}
		return user;
	}

	public List<User> findAll() {
		List<User> users = null;
		String sql = "SELECT userId, name, password, email, address, cartId FROM user";
		try {
			users = (List<User>) jdbctemplate.select(sql, new userMapping());
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION user");
			e.printStackTrace();
		}
		return users;
	}

	public boolean update(User user) {

		String sql = " UPDATE user SET name=?, password=?, email=?, address=? WHERE userId = ?";

		Object[] values = new Object[] {user.getName(), user.getPassword(),
				user.getEmail(), user.getAddress(), user.getUserId() };

		int rows = 0;
		try {
			rows = jdbctemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("NO CONNECTION");
			e.printStackTrace();
		}
		return (rows == 1);

	}
	
	public boolean delete(int userId){
		String sql = "DELETE FROM user WHERE userId = " + userId;
		
		try {
			return (jdbctemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			System.out.println("NO DRIVER");
		} catch (SQLException e) {
			System.out.println("NO CONNECTION user delete");
			e.printStackTrace();
		}
		return false;
	}
}
