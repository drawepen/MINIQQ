package DatabaseTest;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class test extends JFrame{
public static void main(String[] args) throws SQLException, ClassNotFoundException {
//	this.login();
	JFrame jf=new JFrame();
	Connection ct = null;
	Class.forName("com.mysql.jdbc.Driver");
	ct = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq","root","56789Shi!");
	
	 // PreparedStatement  多次重复执行效率高，防止危险字符注入要使用？赋值例:
	PreparedStatement ps = (PreparedStatement) ct.prepareStatement("insert into yonghu values(？，？)");
	ps.setLong(1, 324749);
	ps.setLong(2, 123456);
	Statement sm = null;
	ResultSet rs = null;
	try {
		
		sm = (Statement) ct.createStatement();
		String sn="1";
		int i = sm.executeUpdate("insert into yonghu values("+sn+","+"9999999999"+")");//添加
		int i1 = sm.executeUpdate("delete from yonghu where username=1111111111");//删除
		int i11 = sm.executeUpdate("update yonghu set password=8888888888 where username=1111111111");//修改          
		if(i11==1)
			System.out.println("hhhh");
		else
			System.out.println("eeee");
		rs = sm.executeQuery("select * from yonghu");//查询
		while(rs.next())                              //返回表
		{
			long ab1 = rs.getLong(1);
			long ab2 = rs.getLong(2);
			System.out.println(ab1+"\t"+ab2+"\t");
		}
		rs.next();
		long a = rs.getLong(1); //第一行第一列
		System.out.println(a);
		rs = sm.executeQuery("select username from yonghu");
		String u = new JTextField().getToolTipText().trim();
	}catch (Exception e1) {
		e1.printStackTrace();
	}finally {
		try {
			rs.close();
			sm.close();
			ct.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
	

}
