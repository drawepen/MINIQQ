package DatabaseTest;

import java.sql.*;

public class gfhfh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq","root","56789Shi!");
			String sql = "select * from yonghu where username = ? and password = ?";
			ps = ct.prepareStatement(sql);
			ps.setString(1,"233");
			ps.setString(2,"233");//(nicheng,username,password,vip,dengji,minibi,online)
			rs = ps.executeQuery();
			if(rs.next())
			{
//			    ps=ct.prepareStatement("delete from yonghu where username = '50'");
//			    for(int i=1;i<7;i++) {
//			    	ps.setString(1, "40");
//			    }
//			    int i=ps.executeUpdate();
//				System.out.println(i);DROP TABLE//CREATE TABLE//(account varchar(45) not null, passow varchar(45) not null, name varchar(20) not null, primary key (account));
//				String[] s=new String[10];
//				String[] ac= {"666","233","111","123","456"};
//				 for(int j=1;j<11;j++) {
//					 s[j-1]="file"+j+" varchar(100) null";
//				 }
//				 ct.prepareStatement("DROP TABLE  a"+ac[0]).executeUpdate();
//				for(int i=1;i<6;i++) {
//					
//					ct.prepareStatement("update yonghu set friendsum = 4 where nicheng ='"+"机器人"+i+"';").executeUpdate();
//					 ps=ct.prepareStatement("CREATE TABLE  a"+ac[i-1]+" (account varchar(45) not null,filesum int not null,"+s[0]
//							 +","+s[1]+","+s[2]+","+s[3]+","+s[4]+","+s[5]+","+s[6]+","+s[7]+","+s[8]+","+s[9]+",primary key(account));");
//					 ps.executeUpdate();
//					 for(int j=0;j<i-1;j++) {
//						 ct.prepareStatement("insert into a"+ac[i-1]+"(account ,filesum) values('"+ac[j]+"', 0 )").executeUpdate();
//					 }
//					 for(int j=i;j<5;j++) {
//						 ct.prepareStatement("insert into a"+ac[i-1]+"(account ,filesum) values('"+ac[j]+"', 0)").executeUpdate();
//					 }
//				}
//				ct.prepareStatement("DROP TABLE friends  ").executeUpdate();
//				Statement sta= ct.createStatement();//实例化执行对象
//				sta.executeUpdate("update yonghu set username = 'www' where vip = "+"'9'");
			}else {
				System.out.println("1");
			}
			String str="";
			rs=ct.prepareStatement("select * from yonghu where username = '"+"233"+
					"' and password = '"+"233"+"' and online ='离线'").executeQuery();
			    while(rs.next()) {
			    	System.out.println(rs.getInt("account"));
			    }
			
			
		}catch (Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				rs.close();
				ps.close();
				ct.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	
  }

}
