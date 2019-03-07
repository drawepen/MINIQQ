package MINIQQmain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.AttributedCharacterIterator;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

import MINIdialogue.dialoguetool;
public class SignInInterface extends JFrame implements Runnable,longonlb{   //继承JWindow添加文本框无法输入,按钮文字无边框
	
	int fwidth = Toolkit.getDefaultToolkit().getScreenSize().width;//获取分辨率宽
    int fheight = Toolkit.getDefaultToolkit().getScreenSize().height;//获取分辨率高
    private final int Width=fwidth,Height=320,Lheight=(fheight-320)/2;
	static boolean unchange2=true,unchanged=true,unlongonsuccess=true,longonfinish=false;        //如果未登陆成功，关闭界面就关闭程序boolean默认为false
    public ImageIcon headportrait;
    dialoguetool tool;
   // Cursor mycoursor;         //自建光标类型
	JPanel panel0;
	ImageIcon icon4;
	JLabel label2,vlb;
	JButton button2=new JButton("安全登录 ▼");
	Color blue=new Color(0,99,177);
	JPanel panel1=new JPanel();
	LoginTextBox ltb;
	String verification="";
	public SignInInterface(dialoguetool to) {
		tool=to;
		setUndecorated(true);               //去顶边框
		setSize(Width,Height);
        setLocation(0,Lheight);
        panel0=new JPanel();
        ImageIcon icon=new ImageIcon("image/tp1.gif");
		icon.setImage( icon.getImage().getScaledInstance(Width, Height, Image.SCALE_DEFAULT)); 
        JLabel label=new JLabel(icon); //往面板里加入JLabel
        panel0.add(label);
        add(panel0);
        setVisible(true);
        this.getRootPane().setDefaultButton(button2); // 默认回车按钮  
	}
	@Override
	public void run() {
		//添加登录控件
//		ImageIcon icon1=new ImageIcon(SignInInterface.class.getResource("tp2.png"));
		headportrait=new ImageIcon("image/tp8.png");
		headportrait.setImage( headportrait.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT));
		ImageIcon icon0=new ImageIcon("image/tp2.gif");
		icon0.setImage( icon0.getImage().getScaledInstance(180, 160, Image.SCALE_DEFAULT));
		ImageIcon icon1=new ImageIcon("image/tp2.png");
		icon1.setImage( icon1.getImage().getScaledInstance(200, 50, Image.SCALE_DEFAULT));
		ImageIcon icon2=new ImageIcon("image/tp4.png");
		icon2.setImage( icon2.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ImageIcon icon3=new ImageIcon("image/tp3.jpg");
		icon3.setImage( icon3.getImage().getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		icon4=new ImageIcon("image/tp7(120,21).png");
		//icon4.setImage( icon4.getImage().getScaledInstance(120, 25, Image.SCALE_DEFAULT));
//		GridLayout gl1=new GridLayout(1,3,0,0);//创建具有指定行数、列数以及组件水平、纵向一定间距的网格布局。
		panel1.setSize(Width,Height);
		panel1.setBackground(blue);

/*	
//		button1.setForeground(Color.yellow);
//		button1.setFont(new Font("SimSun", 1, 18));
//		button1.setBackground(blue);
//		button1.setBorderPainted(false);             //去按钮边框
//		button1.setFocusPainted(false);             //去按钮文字边框      
                                             */
		labelzc.setBackground(blue);
		labelzc.setForeground(Color.white);
		labelzc.setFont(new Font("SimSun", 1, 18));
		
		button2.setForeground(Color.yellow);
		button2.setFont(new Font("SimSun", 1, 28));
		button2.setBackground(blue);
		button2.setFocusPainted(false);            //去按钮文字边框
		button2.addActionListener(new ActionListener() {          //添加按钮事件监听
			@Override
			public void actionPerformed(ActionEvent e) {
				longonevent();
			}  
	      });  
		label2=new JLabel(icon1);
		vlb=new JLabel(icon4);
		JLabel label3=new JLabel(icon2);
		JLabel label4=new JLabel(icon3);
		
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		int[] a=new int[10];
		for(int i=0;i<10;i++) {
			a[i]=171;
		}
		gbl_contentPane.columnWidths=a;         //网格格子数（数组容量）及个格子像素（个数组元素值）
		gbl_contentPane.rowHeights = new int[] {43,85,43,49,100};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};//防止网格改变大小
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_contentPane);

		JPanel jp0=new JPanel();
		jp0.setBackground(blue);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();            //miniqq图标
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel1.add(jp0, gbc_panel_1);
		
		jp0.setLayout(null);
		label3.setBounds(5, 5, 100, 100);
		jp0.add(label3);
		label2.setBounds(105, 25, 200, 50);//先执行在最上层
		jp0.add(label2);
		vlb.setBounds(115, 30, 120, 30);//防止非正常现象，后执行才被覆盖！！！！！
		jp0.add(vlb);
		
//		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
//		gbc_panel_2.gridwidth = 2;
//		gbc_panel_2.gridheight = 1;
//		gbc_panel_2.insets = new Insets(0, 0, 0, 0);
//		gbc_panel_2.fill = GridBagConstraints.BOTH;
//		gbc_panel_2.gridx = 1;
//		gbc_panel_2.gridy = 1;
//		panel1.add(label2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(blue);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();           //用户头像
		gbc_panel_3.gridwidth = 1;
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panel1.add(panel_3, gbc_panel_3);
		panel_3.add(new JLabel(headportrait));
		//panel_3.add(new JLabel(icon0));
		
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();             //登陆输入框
		gbc_panel_4.gridwidth = 3;
		gbc_panel_4.gridheight = 4;
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 0;
		ltb=new LoginTextBox(513,220);
		panel1.add(ltb, gbc_panel_4);
		
		GridBagConstraints gbc_panel7 = new GridBagConstraints();
		gbc_panel7.gridwidth = 3;
		gbc_panel7.gridheight = 1;
		gbc_panel7.insets = new Insets(0, 0, 0, 0);
		gbc_panel7.fill = GridBagConstraints.BOTH;
		gbc_panel7.gridx = 4;
		gbc_panel7.gridy = 4;
		panel1.add(button2,gbc_panel7);
        
		GridBagConstraints gbc_panel5 = new GridBagConstraints();
		gbc_panel5.gridwidth = 1;
		gbc_panel5.gridheight = 3;
		gbc_panel5.insets = new Insets(0, 0, 0, 0);
		gbc_panel5.fill = GridBagConstraints.BOTH;
		gbc_panel5.gridx = 9;
		gbc_panel5.gridy = 0;
		panel1.add(label4, gbc_panel5);
		
		JPanel jpanel_5=new JPanel();
		jpanel_5.setBackground(blue);
		jpanel_5.setLayout(null);
		GridBagConstraints gbc_panel6 = new GridBagConstraints();            //注册按钮
		gbc_panel6.gridwidth = 1;
		gbc_panel6.gridheight = 2;
		gbc_panel6.insets = new Insets(0, 0, 0, 0);
		gbc_panel6.fill = GridBagConstraints.BOTH;
		gbc_panel6.gridx = 3;
		gbc_panel6.gridy = 4;
		panel1.add(jpanel_5, gbc_panel6);
		labelzc.setBounds(50,40,120,50);
		jpanel_5.add(labelzc);
//		mycoursor = Toolkit.getDefaultToolkit().createCustomCursor(
//				new ImageIcon("image/tp8.png").getImage(),new Point(45,45),"stick"); //图片大小固定约35，Point(可以小于35，不可大于50)
		setCursor(DEFAULT_CURSOR );
		
		
           /*	    改换登录画布       */
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remove(panel0);//移除画布
	    add(panel1);
	    setVisible(true);                                    //无it画面不变
	    Thread thr1=new Thread(new myMouseEvent());
	    thr1.setDaemon(true);                            //设置为后台程序
	    thr1.start();
//	    addKeyListener(new KeyAdapter() {             //JFrame增加键盘监听器//只能初始时才监听，点按钮、文本框、复选框后都不能再监听！！！
	}
//	class ss extends Thread{                    //检测是否会释放Signlnlnterface对象内存
//		public void run() {
//			while(true) {
//	        	System.out.println(100);
//	        }
//		}
//	}
	///登陆事件
	private void longonevent(){
		String account=ltb.getAccount();
		String passow=""+ltb.getPassow();
		String str0="";
		try {
			tool.lks.prwriter.println(">>>\t"+Linksever.online+"\t"+account+"\t"+passow);
			str0=tool.lks.bfreader.readLine();
			System.out.println(passow+"<>"+str0);
			if(str0.equals("true")) {
				unlongonsuccess=false;
				if(!unchanged) {          //验证验证码
					if(!verification.equals(ltb.getverification())) { //验证码错误
						
						verification=""+ltb.setverification();
						System.out.println(verification);
						JOptionPane.showMessageDialog(this,"验证码错误");
						return;
					}
				}
				longinsuccess();
			}
			else if(unchanged){       //账号密码错误
				unchange2=false;
				///////////////
				vlb.setBounds(0, 0, 120, 30); //？？？添加“请输入验证码”，不在其他面板中添加过直接添加到ltb上，左10上20无法显示！！！！！！！
				ltb.add(vlb);
				verification=""+ltb.chanegloctaion();
				System.out.println(verification);
				JButton jb0=new JButton("算不清,换一个");
				jb0.setBackground(blue);
				jb0.setBorderPainted(false);             //去按钮边框
			    jb0.setFocusPainted(false); 
				jb0.setFont(new Font("宋体", 0, 10));
				jb0.setForeground(Color.white);
				jb0.addActionListener(new ActionListener() {          //添加按钮事件监听
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						verification=""+ltb.setverification();
						System.out.println(verification);
					}  
			      });  
				jb0.setBounds(396,30,100,30);
				ltb.add(jb0);
				/////////////////////////////////
				unchanged=false;
				
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
			else {
				verification=""+ltb.setverification();
				System.out.println(verification);
				
				JOptionPane.showMessageDialog(this,"用户名或密码错误");
			}
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this,"服务器嗝屁了~");
		}
//		catch( java.lang.NullPointerException e) {
//			JOptionPane.showMessageDialog(this,"服务器嗝屁了~");
//		}
		
	}
	//登陆成功
	private void longinsuccess() throws IOException {
		int h=Height-8;
		desktop desk=new desktop(tool);
		
		do {
			setBounds(0,Lheight+Height/2-h/2,Width,h);
			try {                                   
				Thread.sleep(4);               //监视器内部设置暂停无用，后面继续执行！！！
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			h-=8;
		}while(h>0);
		setVisible(false);
		
		desk.setVisible(true);
  //////////////////////////////////////////////////////////////////////
//		setBounds(0,Lheight+Height/2-h/2,Width,h);   //只有第一次和最后一次setBounds()有用，setSize同样，setLocation()不是
//			try {                                   
//				Thread.sleep(1000);             
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//			h+=100;
//		setBounds(0,Lheight+Height/2-h/2,Width,h);
//			try {                                   
//				Thread.sleep(1000);             
//			}catch(InterruptedException e) {
//				e.printStackTrace();
//			}
//			h+=100;
//		setBounds(0,Lheight+Height/2-h/2,Width,h);
//	    remove(panelf1);//移除画布     //remove()/add()总是程序最后执行！！！！！
//	    setVisible(false);
  //////////////////////////////////////////////////////////////////////////////
		longonfinish=true;
		this.dispose(); //关闭界面
	}
	public boolean getfinish() {
		return longonfinish;
	}
	class myMouseEvent extends MouseAdapter implements Runnable{      //鼠标事件
		private boolean zcdj1=true,zcdj2=true;                //注册点击
		synchronized private void zc(JLabel lb,int i) {
			if(i==1) {
				zcdj1=false;
			}
			else {
				zcdj2=false;
			}
			lb.setForeground(Color.cyan);            //这一步总是延时！！！！颜色设置有预备时间，
			                                         //执行此步后预备与下几步同时进行，即使时间暂停在后面，也会先于变色执行
			                                         //监视器内部设置暂停无用，后面继续执行！！
			//labelzc.setForeground(Color.YELLOW);           //鼠标移动时另一事件会改变颜色，鼠标不移动时此步改变文字颜色
		}
		public void run() {
				addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent event) {
						int x=event.getX();                       //得到x,y为界面相对坐标
						int y=event.getY();
						if(y>10&&y<160&&x>Width-170) {
							setVisible(false);
							
							if(unlongonsuccess) {
								System.exit(0);           //非零表示异常终止
							}
						}
						else if(x>576&&x<645&&y<291&&y>275) {
							zc(labelzc,1);
							JOptionPane.showMessageDialog(SignInInterface.this,"功能未开发!");
							new ztsj(labelzc,1).start();         //时间暂停直接放在此处无用，synchronized只阻塞其他线程
						}
						else if(x>1056&&x<1103&&(unchange2&&y<193&&y>183||!unchange2&&y<203&&y>193)) {
							zc(labelzh,2);
							JOptionPane.showMessageDialog(SignInInterface.this,"功能未开发!");
							new ztsj(labelzh,2).start(); 
						}
					}//1058,183,1103,192
				});
				addMouseMotionListener(new MouseAdapter() {
					public void mouseMoved(MouseEvent event) {
						int x=event.getX();                       //得到x,y为界面相对坐标
						int y=event.getY();
						//System.out.println(x+"   "+y);
						if(x>576&&x<645&&y<291&&y>275) {
							if(zcdj1) {
								labelzc.setForeground(Color.yellow);
								setCursor(HAND_CURSOR );          //改变光标为手型
							}
						}
						else {
							labelzc.setForeground(Color.WHITE);              //button鼠标监视器进入按钮区域坐标读取停止！
							setCursor(DEFAULT_CURSOR );          //改变光标为默认型
							if(x>1056&&x<1103&&(unchange2&&y<193&&y>183||!unchange2&&y<203&&y>193)) {
								if(zcdj2) {
									labelzh.setForeground(Color.yellow);
									setCursor(HAND_CURSOR );
								}
							}
							else {
								labelzh.setForeground(Color.WHITE);              //button鼠标监视器进入按钮区域坐标读取停止！
								setCursor(DEFAULT_CURSOR );
							}
						}
						
					}
				});
			
		}
		class ztsj extends Thread{
			public JLabel lb;
			int in;                    //改变第几个zcdj
			public ztsj(JLabel l,int i) {
				lb=l;
				in=i;
			}
			public void run() {
				try {                                   
					Thread.sleep(300);               //监视器内部设置暂停无用，后面继续执行！！！
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				lb.setForeground(Color.yellow);
				if(in==1) {
					zcdj1=true;
				}
				else {
					zcdj2=true;
				}
//				System.out.println(zcdj1);
			}
		}
		
	}
	

}//先设置背景颜色，在setOpaque透明
