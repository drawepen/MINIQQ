package MINIQQmain;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import MINIQQaddition.SnakeDemo;
import MINIQQmain.SignInInterface.myMouseEvent;
import MINIQQmain.SignInInterface.myMouseEvent.ztsj;
import MINIdialogue.dialogue;
import MINIdialogue.dialoguetool;
import MINIdialogue.friendlist;
import MINIdrawing.drawing;
import miniQQ.qqLogin;

//import minqq.desktop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
public class desktop extends JFrame implements desktoplink{

	dialoguetool tool;
	CardLayout card;
	JFrame game;
	public personal myself;
	private JPanel panel0,panel1,panel2,panel3,panel4,panel6,panel7,panel8,panel9,panel10;
	private drawing panel5;
	private dialogue jpdia;
	private friendlist fdlist;
	public JLabel label1,label2,label3,label4,label5,label6,gxlb1,gxlb2,gxlb3;
	public JButton button1,button2,button3,button4,button5,button6,leftbutton1,leftbutton2;
	public JTabbedPane tpane1;          //选项卡
	public JScrollPane spane1,spane2,spane3,spane4;//列表框
	private boolean delay=true;
	int fwidth = Toolkit.getDefaultToolkit().getScreenSize().width;//获取分辨率宽
    int fheight = Toolkit.getDefaultToolkit().getScreenSize().height;//获取分辨率高
	final int width=fwidth,height=fheight-60;
	Color myblue=new Color(0,163,243);
	public static void main(String[] args) throws IOException {
  //////////////////////////////////////////////////////////////////////////////////////////////////
//		EventQueue.invokeLater(new Runnable() {     有此语句add()总是在主线程的最后执行！！！!!!!!!!!
//			public void run() {
//				try {
//					desktop frame = new desktop();
//					//frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////

		desktop frame = new desktop(new dialoguetool());
		frame.setVisible(true);
	}
	public desktop(dialoguetool to) throws IOException {
		//基础设置
		super("MINIQQ");
		tool=to;
		String[] st=tool.lks.bfreader.readLine().split("\t");
		myself=new personal(st[0], st[1], st[2], st[3], Integer.parseInt(st[4]), Integer.parseInt(st[5]));
		tool.addmyself(myself);
		
		ImageIcon icon0=new ImageIcon("image/tp4.png");  
		setIconImage(icon0.getImage());    //更改左上角图标
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height+20);           //最顶框也占总大小，但setBounds不含最顶框坐标
		//setUndecorated(true);//去JF边框,无法变回在用false出错
		setExtendedState(JFrame.MAXIMIZED_BOTH); //初始最大化
		
		//创建对象
		ImageIcon icon1=new ImageIcon("image/tp2(220,216).gif");
		//icon1.setImage( icon1.getImage().getScaledInstance(220, 216, Image.SCALE_DEFAULT));//改变图片大小，清晰度会变差
		ImageIcon icon2=new ImageIcon("image/头像"+myself.head+".png");
		icon2.setImage( icon2.getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
		ImageIcon icon3=new ImageIcon("image/tp3.png");
		ImageIcon icon4=new ImageIcon("image/tp7.png");
		ImageIcon icon5=new ImageIcon("image/tp9.png");
		ImageIcon icon101=new ImageIcon("image/tp101(117,52).png");
		ImageIcon icon102=new ImageIcon("image/tp102(117,52).png");
		ImageIcon icon201=new ImageIcon("image/tp201(116,52).png");
		ImageIcon icon202=new ImageIcon("image/tp202(116,52).png");
		ImageIcon icon203=new ImageIcon("image/tp203(116,52).png");
		ImageIcon icon301=new ImageIcon("image/tp301(117,52).png");
		ImageIcon icon302=new ImageIcon("image/tp302(117,52).png");
		
		panel0=new JPanel();
		panel0.setLayout(null);
		panel0.setBackground(myblue);
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBackground(myblue);
		panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBackground(Color.cyan);
		panel3=new JPanel();
		panel3.setLayout(null);
		panel4=new JPanel();
		panel4.setLayout(null);
		panel5=new drawing(this,tool);
		
		tool.adddrawing(panel5);
		
		//panel5.setLayout(null);
		//panel5.setBackground(Color.red);
		panel6=new JPanel();
		panel6.setLayout(null);
		panel6.setBackground(Color.yellow);
		panel7=new JPanel();
		panel8=new JPanel();
		panel9=new JPanel();
		panel10=new JPanel();
		tpane1=new JTabbedPane();      //1上，2左，3下，4右，默认1
		label1=new JLabel(icon1);
		label2=new JLabel(icon2);
		label3=new JLabel(icon3);
		label4=new JLabel(icon4);
		label5=new JLabel(icon5);
		button1=new JButton(icon102);
		button2=new JButton(icon202);
		button3=new JButton(icon301);
		spane1=new JScrollPane(panel8);
		fdlist=new friendlist(tool);
		gxlb1=new JLabel(myself.nickname+" "+myself.vip);
		gxlb2=new JLabel("lv"+myself.lv+" MINIBI:"+myself.minibi);
		gxlb3=new JLabel("在线");
		gxlb1.setBounds(100,220,100,20);
		gxlb2.setBounds(160,180,80,20);
		gxlb3.setBounds(190,120,60,20);
		gxlb1.setOpaque(true);
		gxlb1.setBackground(Color.WHITE);
		gxlb2.setOpaque(true);
		gxlb2.setBackground(Color.WHITE);
		gxlb3.setOpaque(true);
		gxlb3.setBackground(Color.WHITE);
		
		leftbutton1=new JButton("MINI游戏 >");
		leftbutton2=new JButton("单机QQ >");
		
		//布局
		getContentPane().add(panel0);
		panel1.setBounds(0, 0, 250, height-100);        //设置框
		panel0.add(panel1);
		label2.setBounds(50, 50, 120, 120);
		panel1.add(label2);
		label2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panel1.remove(gxlb1);
				panel1.remove(gxlb2);
				panel1.remove(gxlb3);
				panel1.repaint();
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				panel1.add(gxlb3,0);
				panel1.add(gxlb2,0);
				panel1.add(gxlb1,0);
				panel1.repaint();
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		label1.setBounds(0, 0, 220, 216);
		panel1.add(label1);
		leftbutton1.setFont(new Font("华文行楷",Font.BOLD,20));
		leftbutton1.setFocusPainted(false); 
		leftbutton1.setBounds(0,300,180,40);
		panel1.add(leftbutton1);
		leftbutton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				snakedemo();
			}
		});
		leftbutton2.setFont(new Font("华文行楷",Font.BOLD,20));
		leftbutton2.setFocusPainted(false); 
		leftbutton2.setBounds(0,350,180,40);
		panel1.add(leftbutton2);
		leftbutton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					standaloneqq();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		panel2.setBounds(250, 0, width-250, 100);       //顶框
		panel0.add(panel2);
		panel2.setOpaque(false);
		label4.setBounds(250, 0, width-250, 100);
		panel0.add(label4);
		
		
		panel4.setBounds(width-350,100, 350, height-100);       //列表框
		panel0.add(panel4);
		panel7.setBounds(0,50,350,height-150);
		card =new CardLayout();
		panel7.setLayout(card);
		panel7.add(fdlist,"fdlist");
		panel7.add(spane1,"spane1");
		panel7.add(panel9,"panel9");
//		tpane1.addTab("",icon3,panel7);     //选项卡
		//label1.setIcon(icon4);//改变JLabel中图片
		button1.setBounds(0,0, 117, 50);
		panel4.add(button1);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(panel7,"spane1");
				button1.setIcon(icon101);
				button2.setIcon(icon201);
				button3.setIcon(icon301);
			}
		});
		button2.setBounds(117,0, 116, 50);
		panel4.add(button2);
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(panel7,"fdlist");
				button1.setIcon(icon102);
				button2.setIcon(icon202);
				button3.setIcon(icon301);
			}
		});
		button3.setBounds(233,0, 117, 50);
		panel4.add(button3);
        button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(panel7,"panel9");
				button1.setIcon(icon102);
				button2.setIcon(icon203);
				button3.setIcon(icon302);
			}
		});
//		spane1.setBounds(0, 50, 350, height-150);
//		panel4.add(spane1);
        panel4.add(panel7);
		//setCursor(Cursor.WAIT_CURSOR);

		
		panel5.setBounds(278, 115, width-1200, height-235);     //画图框
		panel5.jplbxy.setBounds(300,height-115,100,10);
//		panel5.setOpaque(false);//？？？？放在最上层不透明有时无法画图！！！！！
//		JFrame tpjf=new JFrame();
//		tpjf.setUndecorated(true);  
//		tpjf.setBounds(278, 115, width-1200, height-235);
//		tpjf.add(panel5);
//		tpjf.setVisible(true);
		panel0.add(panel5);
		panel0.add(panel5.jplbxy);
		label5.setBounds(250, 100, width-1150, height-200);
		panel0.add(label5);
//		panel0.add(panel5);//放在Label下仍能绘图
		//
		
		jpdia=new dialogue(tool);
		tool.adddialogue(jpdia);
		jpdia.setBounds(width-900,100, 550, height-200+40);       //对话框
		jpdia.setBackground(myblue);
		panel0.add(jpdia);
		
//		try {                   
//			TimeUnit.MILLISECONDS.sleep(100);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent event) {
				int x=event.getX();                       //得到x,y为界面相对坐标
				int y=event.getY();
				System.out.println(x+"   "+y);
			}
			@Override
			public void mouseMoved(MouseEvent event) {
				// TODO Auto-generated method stub
				int x=event.getX();                       //得到x,y为界面相对坐标
				int y=event.getY();
				System.out.println(x+"   "+y);
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {    //鼠标拖拽
				// TODO Auto-generated method stub
				
			}
		});
		
		panel3.setBounds(0, height-100, width-350, 100);     //底框
		panel0.add(panel3);
		panel3.setOpaque(false);
		label3.setBounds(0, height-100, width-350, 100);
		panel0.add(label3);
		panel5.drawset.setBounds(250,0,560,41);
		panel3.add(panel5.drawset);

        tool.ltt.start();//循环接收信息
	}
	public void snakedemo() {
		SnakeDemo t = new SnakeDemo();
        t.Thread();
      
        game = new JFrame();
        Image img=Toolkit.getDefaultToolkit().getImage("title.png");//窗口图标
        game.setIconImage(img);
        game.setTitle("MINIQQ Snake");
        game.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e){
				   game.dispose(); //关闭界面
			   }
			 });
//        game.setSize(502, 507);
        game.setSize(602, 507);
        game.setResizable(false);                          //窗口大小不可改变
        game.setLocationRelativeTo(null);                  //居中显示
       
        game.add(t);
        game.setVisible(true);
	}
	public void standaloneqq() throws UnknownHostException, IOException {
		qqLogin QQLogin = new qqLogin();
		QQLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QQLogin.setVisible(true);
	}
}
