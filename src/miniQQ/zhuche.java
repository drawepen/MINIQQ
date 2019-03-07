package miniQQ;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class zhuche  extends JFrame implements ActionListener{

	/* 
	* 注册界面。 
	*/
	
	//定义组件 
	JFrame jf; 
	JPanel jp; 
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7,jl8; 
	JTextField jtf1,jtf2,jtf3,jtf5,jtf6,jtf7; 
	JButton jb1,jb2; 
	
	String vip = "VIP1";
	String level = "Lv1";
	String online = "离线";
	Long minibi = 100L;
	 
	public zhuche() 
	{ 
	//初始化组件 
	jf=new JFrame(); 
	jp=new JPanel(); 
	jl3=new JLabel("请输入昵称:"); 
	jtf3=new JTextField(10);
	jl1=new JLabel("请输入用户名:"); 
	jtf1=new JTextField(10); 
	jtf1.setToolTipText("用户名必须为3-6位字母_或者数字"); 
	jl2=new JLabel("请输入密码:");
	jtf2=new JTextField(10); 
	jtf2.setToolTipText("密码必须为6位字母_或者数字");
	
	jl4=new JLabel("请输入密保问题:");
	jl8=new JLabel("");
	
	jl5=new JLabel("你最喜欢的数字是:"); 
	jtf5=new JTextField(10); 
	
	jl6=new JLabel("你最喜欢的明星是:"); 
	jtf6=new JTextField(10); 
	
	jl7=new JLabel("你最喜欢做的事是:"); 
	jtf7=new JTextField(10); 
	
	  
	jb1=new JButton("返回"); 
	jb1.setToolTipText("点我返回登录界面哦"); 
	jb2=new JButton("注册"); 
	jb1.addActionListener(this); 
	jb2.addActionListener(this); 
	  
	jp.setLayout(new GridLayout(8,2)); 

	jp.add(jl3); 
	jp.add(jtf3); 
	  
	jp.add(jl1); 
	jp.add(jtf1); 
	  
	jp.add(jl2); 
	jp.add(jtf2); 
	
	jp.add(jl4);
	jp.add(jl8);
	
	jp.add(jl5); 
	jp.add(jtf5);
	
	jp.add(jl6); 
	jp.add(jtf6);
	
	jp.add(jl7); 
	jp.add(jtf7);
	  
	jp.add(jb1); 
	jp.add(jb2); 
	  
	this.add(jp); 
	this.setTitle("注册界面"); 
	this.setBounds(200, 100, 320, 400); 
	this.setVisible(true); 
	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	//this.setResizable(false); 
	  
	  
	  
	} 
	 
	 
	 
	 

	public void actionPerformed(ActionEvent e) { 
	 
	if(e.getActionCommand()=="返回") 
	{ 
	 this.dispose(); 
	//new qqLogin(); 
	// System.out.println("-------"); 
	   
	}else if(e.getActionCommand()=="注册") 
	{ 
	  //调用注册方法 
	     this.zhuce(); 
	   
	} 
	  
	} 
	public void zhuce() 
	{ 
	//调用注册方法/先检查要注册的用户名是否存在 
	  SQLserver ss=new SQLserver(); 
	  ss.ConnectSQL(); 
	  ss.ZhuceVerify(jtf1.getText()); 
	   
	// ss.UserRegis(jtf1.getText(),jtf2.getText(),jtf3.getText(), jtf4.getText()); 
	 this.jtf1.setText(""); 
	 this.jtf2.setText(""); 
	 this.jtf3.setText(""); 
	 this.jtf5.setText("");
	 this.jtf6.setText("");
	 this.jtf7.setText("");
	} 
	class SQLserver{ 
		  
		 Connection ct; 
		 PreparedStatement ps; 
		 ResultSet rs; 
		   
		 //将连接数据库的方法封装为一个方法 
		 public void ConnectSQL() 
		 { 
		  try { 
			  Class.forName("com.mysql.jdbc.Driver");
			  ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq2","root","56789Shi!");
		  } catch (Exception e) { 
		   // TODO Auto-generated catch block 
		   e.printStackTrace(); 
		  } 
		 } 
		   
		 //注册用户的方法 
		 public void UserRegis(String a,String b,String c,String d,String m,String f) 
		 { 
		  try { 
		   ps=ct.prepareStatement("insert into yonghu values(?,?,?,?,?,?,?,?,?,?)"); 
		   ps.setString(1,a); 
		   ps.setString(2,b);
		   ps.setString(3,c);
		   ps.setString(4,vip);
		   ps.setString(5,level);
		   ps.setLong(6,minibi);
		   ps.setString(7,online);
		   ps.setString(8,d);
		   ps.setString(9,m);
		   ps.setString(10,f);
		   //执行 
		   int i=ps.executeUpdate(); 
		   if(i==1) 
		   { 
		    JOptionPane.showMessageDialog(null, "注册成功","提示消息",JOptionPane.WARNING_MESSAGE); 
		    jf.dispose();  
		   }else
		   { 
		    JOptionPane.showMessageDialog(null, "注册失败","提示消息",JOptionPane.ERROR_MESSAGE); 
		   } 
		     
		     
		  } catch (SQLException e) { 
		   // TODO Auto-generated catch block 
		   e.printStackTrace(); 
		  } 
		 } 
		
		   
		 //注册验证方法，判断用户名是否已经存在 
		 public void ZhuceVerify(String b) 
		 { 
		  try { 
		   ps=ct.prepareStatement("select * from yonghu where username=?"); 
		//   System.out.println(ps); 
		   ps.setString(1, b); 
		     
		   rs=ps.executeQuery(); 
		   if(rs.next()) 
		   { 
		    JOptionPane.showMessageDialog(null, "该用户名已经存在", "提示信息", JOptionPane.WARNING_MESSAGE); 
		   }else
		   { 
//		    进行注册 
		    this.UserRegis(jtf3.getText(),jtf1.getText(),jtf2.getText(),jtf5.getText(),jtf6.getText(),jtf7.getText()); 
		   } 
		  } catch (SQLException e) { 
		   e.printStackTrace(); 
		  } 
		 }
	}
	
}
