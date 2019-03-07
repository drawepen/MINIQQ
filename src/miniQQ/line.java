package miniQQ;

import java.io.IOException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class line {

	String s1 = "‘⁄œﬂ";
	String s2 = "¿Îœﬂ";
	String username;
	boolean b;
	
	public line(String username,boolean b) {
		this.b = b;
		this.username = username;
		Connection ct = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq2","root","56789Shi!");
			ps = ct.prepareStatement("update yonghu set online=? where username=?");
			if(b == true) {
				ps.setString(1,s1);
				ps.setString(2, username);
				ps.executeUpdate();
			}
			else {
				ps.setString(1,s2);
				ps.setString(2, username);
				ps.executeUpdate();
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				ps.close();
				ct.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
//		public static void main(String args[]) {
//			new line("3247404849",true);
//
//	}
	
}
