package miniQQ;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class qqHomepage extends JFrame implements ActionListener{
	
private JLabel b1,name,gexing,gexingqianming,gexingqianming2,tianqi,bianji;
private JButton b2,b3,b4,b5,b6,huatu;
private JPanel p1,p2,p3,p4; 
//private JTabbedPane jtp;
private JScrollPane jsp1,jsp2,jsp3;
private JLabel []jbls;
//static Socket s;
String myname;
String username;
boolean b;
private JTextArea qianming;


	qqpersonalInformation xianshi = new qqpersonalInformation(myname);
	public qqHomepage(String myname,String username,boolean b) throws SQLException {
		this.username = username;
		this.myname = myname;
		//this.s = s;
		this.b = b;
		setUndecorated(true);
//		setTitle("MINIQQ");
//		setIconImage((new ImageIcon("image\\tianqi.jpg")).getImage());   //����ͷ����
		setBounds(1500,150,360,750);
		
		ImageIcon img = new ImageIcon("image/HomepageBackground7.gif");//���Ǳ���ͼƬ
		JLabel imgLabel = new JLabel(img);//������ͼ���ڱ�ǩ�
		img.setImage(img.getImage().getScaledInstance(360,750, Image.SCALE_DEFAULT));
		getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//ע�������ǹؼ�����������ǩ��ӵ�JFrame��LayeredPane����
		imgLabel.setBounds(0,0,360,750);//���ñ�����ǩ��λ��
		Container con=getContentPane();
		con.setLayout(null);//����Ϊ�ղ���
		((JPanel)con).setOpaque(false); //ע����������������Ϊ͸��������LayeredPane����еı���������ʾ������
		p1 = new JPanel();
		p1.setBounds(0,0,360,130);
		add(p1);
		p1.setOpaque(false);
		p1.setLayout(null);
		
		p2 = new JPanel(new GridLayout(15,1,4,4));
		//p2.setBounds(0,160,360,540);                //ûʲô�ã����������Сһ��
		p2.setBackground(new Color(194,194,200));
		p2.setOpaque(false);
		//p2.setLayout(null);                           //ע�⣬�������ӵ���������
		jsp1 = new JScrollPane(p2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp1.setBounds(0, 160, 360, 540);
		jsp1.setOpaque(false);
		add(jsp1);
		
		p3 = new JPanel();
		p3.setBackground(Color.blue);
		p3.setLayout(null);                         
		jsp2 = new JScrollPane(p3,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp2.setBounds(0, 160, 360, 540);
		jsp2.setVisible(false);
		add(jsp2);
		
		p4 = new JPanel();
		p4.setBackground(Color.orange);
		p4.setLayout(null);                           
		jsp3 = new JScrollPane(p4,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jsp3.setBounds(0, 160, 360, 540);
		jsp3.setVisible(false);
		add(jsp3);
		
		ImageIcon img2 = new ImageIcon("image\\touxiang2.png");
		JLabel lblImage = new JLabel(img2);
		img2.setImage(img2.getImage().getScaledInstance(100, 80, Image.SCALE_DEFAULT));
		lblImage.setBounds(5,5,130,130);
		
		
//		JButton b1 = new JButton();
//		b1.setFocusPainted(false);
//		b1.setBorderPainted(false);
//		b1.setBackground(Color.green);
//		b1.setBounds(0,0,130,130);
//		b1.setOpaque(false);
//		p1.add(b1);
//		b1.add(lblImage);
//		b1.addActionListener(this);
		
		//����ȫ���϶�
				Point origin = new Point();
				this.addMouseListener(new MouseAdapter() {
					// ���£�mousePressed ���ǵ����������걻����û��̧��
					public void mousePressed(MouseEvent e) {
						// ����갴�µ�ʱ���ô��ڵ�ǰ��λ��
						origin.x = e.getX();
						origin.y = e.getY();
					}
				});
				this.addMouseMotionListener(new MouseMotionAdapter() {
					// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
					public void mouseDragged(MouseEvent e) {
						// ������϶�ʱ��ȡ���ڵ�ǰλ��
						Point p = getLocation();
						// ���ô��ڵ�λ��
						// ���ڵ�ǰ��λ�� + ��굱ǰ�ڴ��ڵ�λ�� - ��갴�µ�ʱ���ڴ��ڵ�λ��
						setLocation(p.x + e.getX() - origin.x, p.y + e.getY()- origin.y);
						xianshi.setLocation(p.x-400,p.y+50);
					}
				});
		
		
		b1 = new JLabel();
		b1.setBackground(Color.green);
		b1.setBounds(0,0,130,130);
		p1.add(b1);
		b1.add(lblImage);
		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				xianshi.setVisible(true);
			}
		});
		b1.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				xianshi.setVisible(false);
		}
			
	});
		
		
//		JLabel label = new JLabel();
//		label.setBounds(100,200,100,100);
//		label.setText("<html>First row<br>Second row</html>");            //JLabel���ö����ı���ʾ
//		p1.add(label);
		
		
		b2 = new JButton("��");
		b2.setFocusPainted(false);                                        //ȥ�����ֱ߿�
		b2.setBorderPainted(false);                                       //ȥ����ť�߿�
		b2.setBounds(305,0,60,45);
		b2.setForeground(Color.gray);                                     //����������ɫ
		b2.setFont(new Font("SimSun", 1,18));                             //���������С   
		Color c1 = new Color(180,206,196);
		b2.setContentAreaFilled(false);
		p1.add(b2);
		b2.addActionListener(this);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				b2.setForeground(Color.black);
			}
		});
		b2.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				b2.setForeground(Color.white);
		}
			
	});
		
		b6 = new JButton("-");
		b6.setFocusPainted(false);                                        //ȥ�����ֱ߿�
		b6.setBorderPainted(false);                                       //ȥ����ť�߿�
		b6.setBounds(270,0,60,45);
		b6.setForeground(Color.gray);                                     //����������ɫ
		b6.setFont(new Font("SimSun", 1,30));                             //���������С   
		b6.setContentAreaFilled(false);
		p1.add(b6);
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
		
		huatu = new JButton(new ImageIcon("image/huatu.jpg"));
//		huatu.setFocusPainted(false);                                        //ȥ�����ֱ߿�
//		huatu.setBorderPainted(false);                                       //ȥ����ť�߿�
		huatu.setBounds(0,700,80,50);
		this.add(huatu);
		huatu.addActionListener(this);
		
		Color c2 = new Color(255,102,28);
		
		name = new JLabel(myname);
		name.setFont(new Font("SimSun", 1,24));
		name.setForeground(Color.red);
		name.setBounds(130, 25, 50, 20);
	    p1.add(name);
	    
	    gexing = new JLabel("����ǩ����");
	    gexing.setFont(new Font("SimSun", 1,16));
	    gexing.setForeground(Color.gray);
	    gexing.setBounds(130, 55, 100, 20);
	    p1.add(gexing);
	    
	    bianji = new JLabel("�༭");
	    bianji.setFont(new Font("SimSun", 1,13));
	    bianji.setForeground(Color.gray);
	    bianji.setBounds(220, 55, 30, 20);
	    p1.add(bianji);
	    
//When a cigarette falls in love with a match,it is destined to be hurt��
	    gexingqianming = new JLabel("�����̰��ϻ��");
	    gexingqianming.setFont(new Font("SimSun",16,12));
	    gexingqianming.setForeground(c2);
	    gexingqianming.setBounds(150, 90, 120, 15);
	    p1.add(gexingqianming);
	    
	    gexingqianming2 = new JLabel("��ע���ܵ��˺�");
	    gexingqianming2.setFont(new Font("SimSun",16,12));
	    gexingqianming2.setForeground(c2);
	    gexingqianming2.setBounds(150, 105, 120, 15);
	    p1.add(gexingqianming2);
	    
//	    qianming = new JTextArea();
//	    qianming.setEditable(false);
//	    qianming.setFont(new Font("SimSun",16,12));
//	    qianming.setText("");
//	    qianming.setBounds(150, 80, 120, 45);
//	    qianming.setOpaque(false);                    //�����ı���͸����
//	    p1.add(qianming);
	    
	    ImageIcon img3 = new ImageIcon("image/tianqi0.png");
		tianqi = new JLabel(img3);
		img3.setImage(img3.getImage().getScaledInstance(80, 70, Image.SCALE_DEFAULT));
		tianqi.setBounds(255,45,80,70);
		p1.add(tianqi);
		
		
		b3 = new JButton(new ImageIcon("image/huihua2.PNG"));
		b3.setBounds(0,130,120,30);
		b3.setFocusPainted(false);                                        
		//b3.setBorderPainted(false);
		b3.setBackground(Color.white);
		add(b3);
		b3.addActionListener(this);
		
		
		b4 = new JButton(new ImageIcon("image/lianxiren.PNG"));
		b4.setBounds(120,130,120,30);
		b4.setFocusPainted(false);                                        
		//b4.setBorderPainted(false);
		b4.setBackground(Color.white);
		add(b4);
		b4.addActionListener(this);
		
		b5 = new JButton(new ImageIcon("image/qunliao.PNG"));
		b5.setBounds(240,130,120,30);
		b5.setFocusPainted(false);                                        
		//b5.setBorderPainted(false);
		b5.setBackground(Color.white);
		add(b5);
		b5.addActionListener(this);
		
		Connection ct = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq2","root","56789Shi!");
			String sql = "select * from yonghu";
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
			jbls = new JLabel[15];
				for(int i = 0;rs.next();i++)
				{
					jbls[i] = new JLabel(rs.getString(7)+"      "+rs.getString(4)+"      "+rs.getString(5)+"           "+rs.getString(1),new ImageIcon("image/qietouxiang.jpg"),JLabel.LEFT);
					jbls[i].addMouseListener(new MouseAdapter() {
						public void mouseEntered(MouseEvent e) {
							JLabel j1 = (JLabel)e.getSource();
							j1.setForeground(Color.red);
						}
					});
					jbls[i].addMouseListener(new MouseAdapter() {
						public void mouseExited(MouseEvent e) {
							JLabel j1 = (JLabel)e.getSource();
							j1.setForeground(Color.black);
						}
					});
					jbls[i].addMouseListener(new MouseAdapter() {
						public void mouseClicked(MouseEvent e) {
							if(e.getClickCount()==2)
							{
								String friendname = ((JLabel)e.getSource()).getText().trim().substring(30,34)+"  ";
								qqChat qqchat = new qqChat(myname,friendname);
							}
						}
					});
					p2.add(jbls[i]);
				}
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			rs.close();
			ps.close();
			ct.close();
		}
		
//		new Thread() {
//			public void run() {
//				while(true) {
//					try {
//                        Thread.sleep(3000);
//                    } catch (InterruptedException ex) {
//                        ex.printStackTrace();
//                    }
//				}
//			}
//		}.start();
		
//public void setLocationRelativeTo(Component c)���ô��������ָ�������λ�á� 
//��������ǰδ��ʾ������ c Ϊ null����˴��ڽ�������Ļ�����롣
//�е����ʹ�� GraphicsEnvironment.getCenterPoint ȷ���� 
//���������ĵײ�����Ļ�⣬�򽫸ô��ڷ����� Component ��ӽ��������ĵ�һ�ࡣ
//��ˣ���� Component ����Ļ���Ҳ����� Window �����������󲿣���֮��Ȼ
		
		
//setHorizontalScrollBarPolicy(int policy) ȷ��ˮƽ��������ʱ��ʾ�ڹ��������ϡ�
//setVerticalScrollBarPolicy(int policy) //        ȷ����ֱ��������ʱ��ʾ�ڹ��������ϡ�
//��������ʱ��ʾ�ڹ��������ϡ��Ϸ�ֵ�ǣ� 
//ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED //��������
//ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER //����ʾ
//ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS //������ʾ
		
		
		
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
}
	

	
	
//	public static void main(String[] args) {
//		qqHomepage QQHomepage = new qqHomepage();
//		QQHomepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		QQHomepage.setVisible(true);
//
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==huatu) 
		  { 
				new qqhuihua();
		  }
		
		if(e.getActionCommand()=="��") 
		  { 
				b = false;
				new line(username,b);
				System.out.println(username);
				System.out.println(b);
				this.setVisible(false);
		  }
		
		if(e.getActionCommand()=="-") 
		  { 
				setExtendedState(JFrame.ICONIFIED);
		  }
		
		if(e.getSource()==b3) 
		  { 
				b3.setIcon(new ImageIcon("image/huihua2.PNG"));
				b4.setIcon(new ImageIcon("image/lianxiren.PNG"));
				b5.setIcon(new ImageIcon("image/qunliao.PNG"));
				jsp1.setVisible(true);
				jsp2.setVisible(false);
				jsp3.setVisible(false);
		  }
		
		if(e.getSource()==b4) 
		  { 
				b3.setIcon(new ImageIcon("image/huihua.PNG"));
				b4.setIcon(new ImageIcon("image/lianxiren2.PNG"));
				b5.setIcon(new ImageIcon("image/qunliao.PNG"));
				jsp1.setVisible(false);
				jsp2.setVisible(true);
				jsp3.setVisible(false);
		  }
		
		if(e.getSource()==b5) 
		  { 
				b3.setIcon(new ImageIcon("image/huihua.PNG"));
				b4.setIcon(new ImageIcon("image/lianxiren.PNG"));
				b5.setIcon(new ImageIcon("image/qunliao2.PNG"));
				jsp1.setVisible(false);
				jsp2.setVisible(false);
				jsp3.setVisible(true);
		  }
		
	}
	
//	public static void main(String args[]) throws UnknownHostException, IOException, SQLException{
//		new qqHomepage("С��","",s,true);
//	}

}
