package miniQQ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class mimazhaohui extends JFrame implements ActionListener{
	JFrame jf; 
	JPanel jp; 
	JLabel jl1,jl4,jl5,jl6,jl7,jl8; 
	JTextField jtf1,jtf5,jtf6,jtf7; 
	JButton jb1,jb2; 
	
	public mimazhaohui() {
		
		jf=new JFrame(); 
		jp=new JPanel(); 
		
		jl1=new JLabel("�������û���:"); 
		jtf1=new JTextField(10); 
		
		jl4=new JLabel("�������ܱ�����:");
		jl8=new JLabel("");
		
		jl5=new JLabel("����ϲ����������:"); 
		jtf5=new JTextField(10); 
		
		jl6=new JLabel("����ϲ����������:"); 
		jtf6=new JTextField(10); 
		
		jl7=new JLabel("����ϲ����������:"); 
		jtf7=new JTextField(10); 
		
		  
		jb1=new JButton("����"); 
		jb1.setToolTipText("���ҷ��ص�¼����Ŷ"); 
		jb2=new JButton("ȷ��"); 
		jb1.addActionListener(this); 
		jb2.addActionListener(this); 
		  
		jp.setLayout(new GridLayout(6,2)); 
		  
		jp.add(jl1); 
		jp.add(jtf1); 
		
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
		this.setTitle("�����һؽ���"); 
		this.setBounds(200, 100, 320, 300); 
		this.setVisible(true); 
	}
	
	public void check(String a,String b,String c,String d) {
		
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq2","root","56789Shi!");
			String sql = "select * from yonghu where username = ? and mibao1 = ? and mibao2 = ? and mibao3 = ?";
			ps = ct.prepareStatement(sql);
			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			rs = ps.executeQuery();
			if(rs.next())
			{
				JOptionPane.showMessageDialog(this,"���������:"+rs.getString(3));
			}
			else
				JOptionPane.showMessageDialog(this,"�ܱ��������");
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
	


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==jb2) {
			this.check(jtf1.getText(), jtf5.getText(), jtf6.getText(), jtf7.getText());
		}
		
		if(e.getSource()==jb1) {
			this.dispose();
		}
	}
	
//	public static void main(String args[]) {
//		new mimazhaohui();
//	}

}
