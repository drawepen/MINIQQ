package miniQQ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;


public class qqLogin extends JFrame implements ActionListener{
	
private JButton b1,regAccount,findpwd,LoginBtn,b6;
private JPanel p1;
private JLabel userLabel,pwdlabel;
private JComboBox textField;
private JCheckBox remberpwd,zidonglogin;
private JPasswordField jPasswordField;
//JSplitPane                  //分割面板
//JList                       //在一列中展示一组项目
//Socket s;

Boolean b = false;
private String myname = null;
private String username = null; 
	
public qqLogin() throws UnknownHostException, IOException {
//	s = new Socket("127.0.0.1",8080);
	//setTitle("MINIQQ");
	//dispose();                                           //关闭窗体，并释放一部分窗体所占用的资源
	setUndecorated(true);                                  //去除窗体边框
	setSize(550,425);
	setLocation(675, 350);
//setResizable(false);      //窗口不可缩放
//	setLayout(null);
//	Container con = getContentPane();
//	JPanel p1 = new JPanel();
//	p1.setSize(550,220);
//	p1.setLocation(0,0);
////	BorderLayout b=new BorderLayout();
////	p1.setLayout(b);
////	p1.setPreferredSize(new Dimension(0,150));             //使用布局管理器时设置面板大小
////	p1.setBackground(Color.BLUE);
////	add(p1,BorderLayout.NORTH);
//	//Color p1Bd = new Color(0,150,255);
//	//p1.setBackground(p1Bd);
////	add(p1);
//	
//	JLabel lblImage = new JLabel(new ImageIcon(lianXi.class.getResource("qq.jpg")));    //创建一个带图片的 JLabel
//	lblImage.setBounds(0,0,550,220);    //设置 图片的横坐标、纵坐标、宽、高
//	p1.add(lblImage);
//	JButton b1 = new JButton("x");
//	b1.setBounds(0,0,10,10);
//	p1.add(b1);
//	con.add(p1);
	
	
	
//	ImageIcon img = new ImageIcon(qqLogin.class.getResource("qq.jpg"));//这是背景图片     //不太方便，淘汰
	ImageIcon img = new ImageIcon("image/qq.jpg");
	JLabel imgLabel = new JLabel(img);//将背景图放在标签里。
	getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//注意这里是关键，将背景标签添加到JFrame的LayeredPane面板里。
	imgLabel.setBounds(0,0,550,220);//设置背景标签的位置
	Container con=getContentPane();
	con.setLayout(null);//定义为空布局
	((JPanel)con).setOpaque(false); //注意这里，将内容面板设为透明。这样LayeredPane面板中的背景才能显示出来。
	
	
	
	b1 = new JButton("×");
	b1.setFocusPainted(false);                                        //去除文字边框
	b1.setBorderPainted(false);                                       //去除按钮边框
	b1.setBounds(490,0,60,45);
	b1.setForeground(Color.white);                                    //设置字体颜色
	b1.setFont(new Font("SimSun", 1,25));                             //设置字体（类型，粗细，大小）   
	Color c1 = new Color(3,143,204);
	b1.setBackground(c1);  
	b1.setContentAreaFilled(false);                                   //按钮设置为透明，这样就不会挡着后面的背景 
	((JPanel)con).add(b1);
	b1.addActionListener(this);
	b1.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			b1.setForeground(Color.black);
		}
	});
	b1.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			b1.setForeground(Color.white);
	}
		
});
	
	b6 = new JButton("-");
	b6.setFocusPainted(false);                                        
	b6.setBorderPainted(false);                                       
	b6.setBounds(440,0,60,45);
	b6.setForeground(Color.white);                                    
	b6.setFont(new Font("SimSun", 1,30));                             
	b6.setBackground(c1);
	b6.setContentAreaFilled(false);
	((JPanel)con).add(b6);
	b6.addActionListener(this);
	b6.addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
			b6.setForeground(Color.black);
		}
	});
	b6.addMouseListener(new MouseAdapter() {
		public void mouseExited(MouseEvent e) {
			b6.setForeground(Color.white);
	}
		
});
	
	p1 = new JPanel();
	p1.setBounds(0,220,550,205);
	add(p1);
	p1.setLayout(null);
	ImageIcon img2 = new ImageIcon("image/touxiang2.png");
	JLabel lblImage = new JLabel(img2);
	img2.setImage(img2.getImage().getScaledInstance(160, 120, Image.SCALE_DEFAULT));
	lblImage.setBounds(30,20,150,150);
	p1.add(lblImage);
	//((JPanel)con).add(lblImage);
	
	userLabel = new JLabel();
    userLabel.setText("用户名：");
    userLabel.setFont(new Font("SimSun", 1,16));                    
    userLabel.setForeground(Color.blue);                            
    userLabel.setBounds(200, 40, 120, 30);
    p1.add(userLabel);

    textField=new JComboBox();
    textField.setEditable(true);
    textField.addItem("3247404849");
    textField.setFont(new Font("SimSun", 1,18));
    //JTextField textField = new JTextField();
    textField.setBounds(270, 35, 180, 36);
    textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));         //不知道为什么没有用
    //textField.setBorder(BorderFactory.createLoweredBevelBorder());             //下凹
    p1.add(textField);
    
//	JTextArea jt = new JTextArea(3, 20);                   //多行文本框
//  jt.setLineWrap(true);                                  //如果内容过长，自动换行
//  "<html>" + a + "<br/>" + b + " <html/>";               //JLabel换行
//  setIconTextGap(15);                                    //设置JLable的图片与文字之间的距离

    pwdlabel = new JLabel("密  码:");
    pwdlabel.setFont(new Font("SimSun", 1,16));
    pwdlabel.setForeground(Color.blue);
    pwdlabel.setBounds(200, 90, 120, 30);
    p1.add(pwdlabel);

    jPasswordField = new JPasswordField();
    jPasswordField.setBounds(270, 85, 180, 36);
    jPasswordField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));    //不知道为什么没有用
    //jPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());        //下凹
    p1.add(jPasswordField);
    
    Color c2 = new Color(1,175,235);
    
    regAccount = new JButton("注册账号");
    //regAccount.setText("注册账号");
    regAccount.setFont(new Font("SimSun", 1,15));
    regAccount.setForeground(c2);
    regAccount.setBounds(450, 40, 100, 30);
    regAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    //regAccount.setBackground(c2);
    regAccount.setFocusPainted(false);
    regAccount.setBorderPainted(false);
    //regAccount.setOpaque(false);          //使按钮透明化（必须先设置按钮背景颜色？？？）  //此透明化方法不适合按钮
    regAccount.setContentAreaFilled(false);
    p1.add(regAccount);
    regAccount.addActionListener(this);
    
    findpwd = new JButton();
    findpwd.setText("找回密码");
    findpwd.setFont(new Font("SimSun", 1,15));
    findpwd.setForeground(c2);
    findpwd.setBounds(450, 90, 100, 30);
    findpwd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    findpwd.setFocusPainted(false);
    findpwd.setBorderPainted(false);
    findpwd.setContentAreaFilled(false);
    p1.add(findpwd);
    findpwd.addActionListener(this);
    
    
    
    Color c3 = new Color(117,128,108);
    remberpwd = new JCheckBox("记住密码");
    remberpwd.setFocusPainted(false);
    remberpwd.setBorderPainted(false);
    remberpwd.setFont(new Font("SimSun", 1,15));
    remberpwd.setForeground(c3);
    remberpwd.setBounds(200,130,100,27);
    p1.add(remberpwd);
    
    zidonglogin = new JCheckBox("自动登录");
    zidonglogin.setFocusPainted(false);
    zidonglogin.setBorderPainted(false);
    zidonglogin.setFont(new Font("SimSun", 1,15));
    zidonglogin.setForeground(c3);
    zidonglogin.setBounds(360,130,100,27);
    p1.add(zidonglogin);
    

    
    LoginBtn = new JButton("登  录");
    LoginBtn.setFocusPainted(false);
    LoginBtn.setFont(new Font("SimSun", 1,18));
    LoginBtn.setBorderPainted(false);
    LoginBtn.setBackground(c2);
    LoginBtn.setForeground(Color.white);
    LoginBtn.setBounds(200,160,250,32);
    //LoginBtn.setOpaque(false);
    p1.add(LoginBtn);
    LoginBtn.addActionListener(this);

    
    this.getRootPane().setDefaultButton(LoginBtn); // 默认回车按钮  
	 
	 

//下面全是拖动
Point origin = new Point();
this.addMouseListener(new MouseAdapter() {
	// 按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
	public void mousePressed(MouseEvent e) {
		// 当鼠标按下的时候获得窗口当前的位置
		origin.x = e.getX();
		origin.y = e.getY();
	}
});
this.addMouseMotionListener(new MouseMotionAdapter() {
	// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
	public void mouseDragged(MouseEvent e) {
		// 当鼠标拖动时获取窗口当前位置
		Point p = getLocation();
		// 设置窗口的位置
		// 窗口当前的位置 + 鼠标当前在窗口的位置 - 鼠标按下的时候在窗口的位置
		setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
	}
});

//下面是限制窗口移出屏幕
// this.addComponentListener(new ComponentAdapter() {
//            int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
//            int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height); 
//             
//            //@Override
//           public void componentMoved(ComponentEvent e) {
//                Point p =getLocation();
//                int frameWidth = getWidth();
//                int frameHeight = getHeight();
//                 
//                if (p.x <= 0) {
//                    setLocation(0 - frameWidth + 5, p.y);
//                }
//                 
//                if (p.y <= 0) {
//                    setLocation(p.x, 0 - frameHeight + 5);
//                }
//                 
//                if ((p.x + frameWidth) >= screenWidth) {
//                    setLocation(screenWidth - 5, p.y);
//                }
//                if ((p.y + frameHeight) >= screenHeight) {
//                    setLocation(p.x, screenHeight - 5);
//                }
//            }
//             
//        });
// 
//    addMouseListener(new MouseAdapter() {
//            int screenWidth=((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().width);
//            int screenHeight = ((int)java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);
//             
//            @Override
//            public void mouseExited(MouseEvent e) {
//                Point p = getLocation();
//                int frameWidth = getWidth();
//                int frameHeight =getHeight();
//                 
//                if (p.x <= 1) {
//                    setLocation(0 - frameWidth + 6, p.y);
//                }
//                 
//                if (p.y <= 1) {
//                   setLocation(p.x, 0 - frameHeight + 6);
//                }
//                 
//                if ((p.x + frameWidth) >= screenWidth) {
//                    setLocation(screenWidth - 6, p.y);
//                }
//                if ((p.y + frameHeight) >= screenHeight) {
//                    setLocation(p.x, screenHeight - 6);
//                }
//            }
// 
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                Point p = getLocation();
//                int frameWidth = getWidth();
//                int frameHeight = getHeight();
//                 
//                if (p.x <= 0) {
//                    setLocation(1, p.y);
//                }
//                 
//                if (p.y <= 0) {
//                    setLocation(p.x, 1);
//                }
//                 
//                if ((p.x + frameWidth) >= screenWidth) {
//                    setLocation(screenWidth - frameWidth - 1, p.y);
//                }
//                if ((p.y + frameHeight) >= screenHeight) {
//                    setLocation(p.x, screenHeight - frameHeight - 1);
//                }
//            }
//        });
		//this.pack();                            //调整此窗口的大小，以适合其子组件的首选大小和布局
}


@SuppressWarnings({ "deprecation", "resource" })
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==b1) 
	  { 
			this.setVisible(false);
	  }
	
	if(e.getActionCommand()=="-") 
	  { 
		setExtendedState(JFrame.ICONIFIED);
	  }
	
	if(e.getActionCommand()=="登  录") 
	  { 
	    	//this.login();
			//PreparedStatement   多次重复执行效率高，防止危险字符注入
			//要使用？赋值       
//			例:
//			PreparedStatement ps = ct.prepareStatement("insert into yonghu values(？，？)");
//			ps.setLong(1, 3247404849);
//			ps.setLong(2, 123456);
		//int i = sm.executeUpdate("insert into yonghu values(1111111111,9999999999)");//添加
		//int i = sm.executeUpdate("delete from yonghu where username=1111111111");//删除
//		int i = sm.executeUpdate("update yonghu set password=8888888888 where username=1111111111");//修改          
//		if(i==1)
//			System.out.println("hhhh");
//		else
//			System.out.println("eeee");
//		rs = sm.executeQuery("select * from yonghu");//查询
//		while(rs.next())                              //返回表
//		{
//			long ab1 = rs.getLong(1);
//			long ab2 = rs.getLong(2);
//			System.out.println(ab1+"\t"+ab2+"\t");
//		}
//		rs.next();
//		long a = rs.getLong(1); //第一行第一列
		//System.out.println(a);
			Connection ct = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				User u = new User();
				Class.forName("com.mysql.jdbc.Driver");
				ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq2","root","56789Shi!");
				String sql = "select * from yonghu where username = ? and password = ?";
				ps = ct.prepareStatement(sql);
				ps.setString(1, (String) textField.getSelectedItem());
				ps.setString(2, jPasswordField.getText());
				rs = ps.executeQuery();
				if(rs.next())
				{
					u.setUsername(rs.getString(1));
					u.setPassword(rs.getString(2));
					System.out.println(u.getUsername());
					myname = rs.getString(1);
					username = rs.getString(2);
					b = true;
					new line(username,b);
					this.login();
				}
				else
					JOptionPane.showMessageDialog(this,"用户名密码错误");
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
	
	if(e.getSource()==regAccount) 
	  { 
		this.Regis();
	  }
	
	if(e.getSource()==findpwd) 
	  { 
			this.zhaohui();
	  }
	
}


//登录方法 
public void login() throws SQLException {
	this.dispose();
	new qqHomepage(myname,username,b);
}

//注册方法 
public void Regis() { 

 new zhuche();

}

//密码找回
public void zhaohui() { 

	 new mimazhaohui();

	}

} 

