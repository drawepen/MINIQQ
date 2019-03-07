package MINIdialogue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Friend {
	public int height=0;
	public final int width=530;
	public final static String wordgroup="wordgroup";
	public String head,lv;
	public String nickname,account=null;
	public boolean online;
	public JPanel fdbox;
	public JScrollPane jspane;
	public Friend(String a,String s,String h,String l,boolean o) {
		account=a;
		nickname=s;
		head=h;
		lv=l;
		online=o;
		fdbox=new JPanel();
		fdbox.setLayout(null);
		fdbox.setBackground(Color.white);
		fdbox.setPreferredSize(new Dimension(width, height));//？？？fdbox.setSize(550,1500);无效，需用此法！！！！！！！！！
		jspane=new JScrollPane(fdbox);//JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jspane.setBounds(0,50,550,500);
	}
	public Friend() {
		JLabel jb=new JLabel("null",JLabel.CENTER);
		jb.setFont(new Font("",Font.BOLD,60));
		jspane=new JScrollPane(jb);
		jspane.setBounds(0,50,550,500);
		jspane.setBackground(Color.WHITE);
	}
	public void setonline(boolean b) {
		online=b;
	}
}
