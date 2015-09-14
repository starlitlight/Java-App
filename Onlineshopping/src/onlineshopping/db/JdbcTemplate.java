package onlineshopping.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class JdbcTemplate {
	
	/**
	 * Excute INSERT, UPDATE, DELETE query
	 * @param sql 
	 * @param values -> [1,values]
	 * @return row
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int update(String sql, Object... values) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			Connection con = DBManager.getConn();
			pstmt = con.prepareStatement(sql);
			//给占位符赋值
			for (int i = 0; i < values.length; i++) {
				pstmt.setObject(i + 1, values[i]);
			}
			System.out.println(pstmt);
			row = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		}
		return row;
	}
	/**
	 * Excuate SELECT query
	 * @param sql 
	 * @param mapping
	 * @param values
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List select(String sql, EntityMapping mapping, Object... values) throws ClassNotFoundException, SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Object> list = new Vector<Object>();
		try {
			Connection con = DBManager.getConn();
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				pstmt.setObject(i + 1, values[i]);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Object entity = mapping.mapping(rs); 
				list.add(entity);
			}
		} finally {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
		}
		return list;
	}
}
