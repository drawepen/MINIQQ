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
		setTitle(myname+" �� "+friendname+" ������ ......");
		setIconImage((new ImageIcon("image\\qqqie1.jpg")).getImage());   //����ͷ����
		
		jp = new JPanel();
		add(jp,"South");
		
		jta = new JTextArea();
		jta.setEnabled(false);                   //�����ı��򲻿ɱ༭
		add(jta,"Center");
		
		jtf = new JTextField(15);
		jp.add(jtf);
		
		jb = new JButton("����");
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
//				// �ͻ��������������շ�������Ϣ
//				BufferedReader br = new BufferedReader(new InputStreamReader(
//						s.getInputStream()));
//				PrintWriter pw = new PrintWriter(bw, true); // װ�����������ʱˢ��
//				pw.println(m.getCon());
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			
			
			jta.append(m.getCon());//setText()�����Ὣԭ�����������;append()�����Ὣ���õ��ַ�������ԭ��JTextArea��������֮��.
			jtf.setText("");
			
		}
	}

}
