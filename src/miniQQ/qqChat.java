package miniQQ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.io.*;

import javax.swing.*;

public class qqChat extends JFrame implements ActionListener{

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	String myname;
	String friendname;
	//Socket s;
	
	public qqChat(String myname,String friendname) {
		
		//this.s = s;
		this.myname = myname;
		this.friendname = friendname;
		
		setBounds(700, 400, 400, 300);
		setTitle(myname+" 与 "+friendname+" 聊天中 ......");
		setIconImage((new ImageIcon("image\\qqqie1.jpg")).getImage());   //设置头标题
		
		jp = new JPanel();
		add(jp,"South");
		
		jta = new JTextArea();
		jta.setEnabled(false);                   //设置文本框不可编辑
		add(jta,"Center");
		
		jtf = new JTextField(15);
		jp.add(jtf);
		
		jb = new JButton("发送");
		jb.addActionListener(this);
		jp.add(jb);
		
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb)
		{
			
			Message m = new Message();
			m.setSender(this.myname);
			m.setGetter(this.friendname);
			m.setCon(jtf.getText());
			m.setSendTime(new java.util.Date().toString());
			System.out.println(m.getSender());
			System.out.println(m.getGetter());
			System.out.println(m.getCon());
			
			
//			try {
//				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
//						s.getOutputStream()));
//				// 客户端输入流，接收服务器消息
//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						s.getInputStream()));
//				PrintWriter pw = new PrintWriter(bw, true); // 装饰输出流，及时刷新
//				pw.println(m.getCon());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			
			jta.append(m.getCon());//setText()方法会将原来的内容清除;append()方法会将设置的字符串接在原来JTextArea内容文字之后.
			jtf.setText("");
			
		}
	}

}
