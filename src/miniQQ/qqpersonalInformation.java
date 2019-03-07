package miniQQ;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class qqpersonalInformation extends JFrame implements ActionListener{
	
	private JPanel p;
	private JLabel name,sex,constellation,birthday,hobby,phonenumber;
	String myname;
	
	public qqpersonalInformation(String myname) {
		
		this.myname = myname;
		
		setUndecorated(true);
		setBounds(1100,200,400,160);
		
		Color c1 = new Color(200,240,240);
		
		p = new JPanel();
		p.setBounds(0,0,400,160);
		p.setLayout(null);
		p.setBackground(c1);
		add(p);
		
		ImageIcon img2 = new ImageIcon("image/gexing.jpg");
		JLabel lblImage = new JLabel(img2);
		img2.setImage(img2.getImage().getScaledInstance(200, 160, Image.SCALE_DEFAULT));
		lblImage.setBounds(0,0,200,160);
		p.add(lblImage);
		
		name = new JLabel(myname);
		name.setFont(new Font("SimSun", 1,20));
		name.setForeground(Color.blue);
		name.setBounds(220, 10, 50, 20);
	    p.add(name);
		
	    
	    sex = new JLabel("性别：男   年龄：20");
		sex.setFont(new Font("SimSun", 50,15));
		sex.setForeground(Color.darkGray);
		sex.setBounds(210, 40, 200, 20);
	    p.add(sex);
	    
	    birthday = new JLabel("生日：1999.10.27");
	    birthday.setFont(new Font("SimSun", 50,15));
	    birthday.setForeground(Color.darkGray);
	    birthday.setBounds(210, 60, 200, 20);
	    p.add(birthday);
	    
	    constellation = new JLabel("星座：天蝎座  属兔");
	    constellation.setFont(new Font("SimSun", 50,15));
	    constellation.setForeground(Color.darkGray);
	    constellation.setBounds(210, 80, 200, 20);
	    p.add(constellation);
	    
	    hobby = new JLabel("爱好：听歌 下棋 打游戏");
	    hobby.setFont(new Font("SimSun", 50,15));
	    hobby.setForeground(Color.darkGray);
	    hobby.setBounds(210, 100, 200, 20);
	    p.add(hobby);
	    
	    phonenumber = new JLabel("手机号码：15665851926");
	    phonenumber.setFont(new Font("SimSun", 1,16));
	    phonenumber.setForeground(Color.magenta);
	    phonenumber.setBounds(210, 130, 200, 20);
	    p.add(phonenumber);
	    
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //setVisible(true);
	    
	}
	

//	public static void main(String[] args) {
//		qqpersonalInformation QQpersonalInformation = new qqpersonalInformation();
//		QQpersonalInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		QQpersonalInformation.setVisible(true);
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
