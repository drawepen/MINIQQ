package DatabaseTest;

import java.sql.*;

import com.mysql.jdbc.Connection;

public class DataCon {
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq","root","56789Shi!");
		Statement stmt = conn.createStatement();
		String sql = "select * from yonghu";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			System.out.println(col1);
			System.out.println(col2);
		}

	}
}
