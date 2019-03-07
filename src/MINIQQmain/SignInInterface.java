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
public class SignInInterface extends JFrame implements Runnable,longonlb{   //�̳�JWindow����ı����޷�����,��ť�����ޱ߿�
	
	int fwidth = Toolkit.getDefaultToolkit().getScreenSize().width;//��ȡ�ֱ��ʿ�
    int fheight = Toolkit.getDefaultToolkit().getScreenSize().height;//��ȡ�ֱ��ʸ�
    private final int Width=fwidth,Height=320,Lheight=(fheight-320)/2;
	static boolean unchange2=true,unchanged=true,unlongonsuccess=true,longonfinish=false;        //���δ��½�ɹ����رս���͹رճ���booleanĬ��Ϊfalse
    public ImageIcon headportrait;
    dialoguetool tool;
   // Cursor mycoursor;         //�Խ��������
	JPanel panel0;
	ImageIcon icon4;
	JLabel label2,vlb;
	JButton button2=new JButton("��ȫ��¼ ��");
	Color blue=new Color(0,99,177);
	JPanel panel1=new JPanel();
	LoginTextBox ltb;
	String verification="";
	public SignInInterface(dialoguetool to) {
		tool=to;
		setUndecorated(true);               //ȥ���߿�
		setSize(Width,Height);
        setLocation(0,Lheight);
        panel0=new JPanel();
        ImageIcon icon=new ImageIcon("image/tp1.gif");
		icon.setImage( icon.getImage().getScaledInstance(Width, Height, Image.SCALE_DEFAULT)); 
        JLabel label=new JLabel(icon); //����������JLabel
        panel0.add(label);
        add(panel0);
        setVisible(true);
        this.getRootPane().setDefaultButton(button2); // Ĭ�ϻس���ť  
	}
	@Override
	public void run() {
		//��ӵ�¼�ؼ�
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
//		GridLayout gl1=new GridLayout(1,3,0,0);//��������ָ�������������Լ����ˮƽ������һ���������񲼾֡�
		panel1.setSize(Width,Height);
		panel1.setBackground(blue);

/*	
//		button1.setForeground(Color.yellow);
//		button1.setFont(new Font("SimSun", 1, 18));
//		button1.setBackground(blue);
//		button1.setBorderPainted(false);             //ȥ��ť�߿�
//		button1.setFocusPainted(false);             //ȥ��ť���ֱ߿�      
                                             */
		labelzc.setBackground(blue);
		labelzc.setForeground(Color.white);
		labelzc.setFont(new Font("SimSun", 1, 18));
		
		button2.setForeground(Color.yellow);
		button2.setFont(new Font("SimSun", 1, 28));
		button2.setBackground(blue);
		button2.setFocusPainted(false);            //ȥ��ť���ֱ߿�
		button2.addActionListener(new ActionListener() {          //��Ӱ�ť�¼�����
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
		gbl_contentPane.columnWidths=a;         //��������������������������������أ�������Ԫ��ֵ��
		gbl_contentPane.rowHeights = new int[] {43,85,43,49,100};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};//��ֹ����ı��С
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_contentPane);

		JPanel jp0=new JPanel();
		jp0.setBackground(blue);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();            //miniqqͼ��
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
		label2.setBounds(105, 25, 200, 50);//��ִ�������ϲ�
		jp0.add(label2);
		vlb.setBounds(115, 30, 120, 30);//��ֹ���������󣬺�ִ�вű����ǣ���������
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
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();           //�û�ͷ��
		gbc_panel_3.gridwidth = 1;
		gbc_panel_3.gridheight = 3;
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 0;
		panel1.add(panel_3, gbc_panel_3);
		panel_3.add(new JLabel(headportrait));
		//panel_3.add(new JLabel(icon0));
		
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();             //��½�����
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
		GridBagConstraints gbc_panel6 = new GridBagConstraints();            //ע�ᰴť
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
//				new ImageIcon("image/tp8.png").getImage(),new Point(45,45),"stick"); //ͼƬ��С�̶�Լ35��Point(����С��35�����ɴ���50)
		setCursor(DEFAULT_CURSOR );
		
		
           /*	    �Ļ���¼����       */
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		remove(panel0);//�Ƴ�����
	    add(panel1);
	    setVisible(true);                                    //��it���治��
	    Thread thr1=new Thread(new myMouseEvent());
	    thr1.setDaemon(true);                            //����Ϊ��̨����
	    thr1.start();
//	    addKeyListener(new KeyAdapter() {             //JFrame���Ӽ��̼�����//ֻ�ܳ�ʼʱ�ż������㰴ť���ı��򡢸�ѡ��󶼲����ټ���������
	}
//	class ss extends Thread{                    //����Ƿ���ͷ�Signlnlnterface�����ڴ�
//		public void run() {
//			while(true) {
//	        	System.out.println(100);
//	        }
//		}
//	}
	///��½�¼�
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
				if(!unchanged) {          //��֤��֤��
					if(!verification.equals(ltb.getverification())) { //��֤�����
						
						verification=""+ltb.setverification();
						System.out.println(verification);
						JOptionPane.showMessageDialog(this,"��֤�����");
						return;
					}
				}
				longinsuccess();
			}
			else if(unchanged){       //�˺��������
				unchange2=false;
				///////////////
				vlb.setBounds(0, 0, 120, 30); //��������ӡ���������֤�롱�����������������ӹ�ֱ����ӵ�ltb�ϣ���10��20�޷���ʾ��������������
				ltb.add(vlb);
				verification=""+ltb.chanegloctaion();
				System.out.println(verification);
				JButton jb0=new JButton("�㲻��,��һ��");
				jb0.setBackground(blue);
				jb0.setBorderPainted(false);             //ȥ��ť�߿�
			    jb0.setFocusPainted(false); 
				jb0.setFont(new Font("����", 0, 10));
				jb0.setForeground(Color.white);
				jb0.addActionListener(new ActionListener() {          //��Ӱ�ť�¼�����
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
				
				JOptionPane.showMessageDialog(this,"�û������������");
			}
			else {
				verification=""+ltb.setverification();
				System.out.println(verification);
				
				JOptionPane.showMessageDialog(this,"�û������������");
			}
		}catch(IOException e) {
			JOptionPane.showMessageDialog(this,"��������ƨ��~");
		}
//		catch( java.lang.NullPointerException e) {
//			JOptionPane.showMessageDialog(this,"��������ƨ��~");
//		}
		
	}
	//��½�ɹ�
	private void longinsuccess() throws IOException {
		int h=Height-8;
		desktop desk=new desktop(tool);
		
		do {
			setBounds(0,Lheight+Height/2-h/2,Width,h);
			try {                                   
				Thread.sleep(4);               //�������ڲ�������ͣ���ã��������ִ�У�����
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			h-=8;
		}while(h>0);
		setVisible(false);
		
		desk.setVisible(true);
  //////////////////////////////////////////////////////////////////////
//		setBounds(0,Lheight+Height/2-h/2,Width,h);   //ֻ�е�һ�κ����һ��setBounds()���ã�setSizeͬ����setLocation()����
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
//	    remove(panelf1);//�Ƴ�����     //remove()/add()���ǳ������ִ�У���������
//	    setVisible(false);
  //////////////////////////////////////////////////////////////////////////////
		longonfinish=true;
		this.dispose(); //�رս���
	}
	public boolean getfinish() {
		return longonfinish;
	}
	class myMouseEvent extends MouseAdapter implements Runnable{      //����¼�
		private boolean zcdj1=true,zcdj2=true;                //ע����
		synchronized private void zc(JLabel lb,int i) {
			if(i==1) {
				zcdj1=false;
			}
			else {
				zcdj2=false;
			}
			lb.setForeground(Color.cyan);            //��һ��������ʱ����������ɫ������Ԥ��ʱ�䣬
			                                         //ִ�д˲���Ԥ�����¼���ͬʱ���У���ʹʱ����ͣ�ں��棬Ҳ�����ڱ�ɫִ��
			                                         //�������ڲ�������ͣ���ã��������ִ�У���
			//labelzc.setForeground(Color.YELLOW);           //����ƶ�ʱ��һ�¼���ı���ɫ����겻�ƶ�ʱ�˲��ı�������ɫ
		}
		public void run() {
				addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent event) {
						int x=event.getX();                       //�õ�x,yΪ�����������
						int y=event.getY();
						if(y>10&&y<160&&x>Width-170) {
							setVisible(false);
							
							if(unlongonsuccess) {
								System.exit(0);           //�����ʾ�쳣��ֹ
							}
						}
						else if(x>576&&x<645&&y<291&&y>275) {
							zc(labelzc,1);
							JOptionPane.showMessageDialog(SignInInterface.this,"����δ����!");
							new ztsj(labelzc,1).start();         //ʱ����ֱͣ�ӷ��ڴ˴����ã�synchronizedֻ���������߳�
						}
						else if(x>1056&&x<1103&&(unchange2&&y<193&&y>183||!unchange2&&y<203&&y>193)) {
							zc(labelzh,2);
							JOptionPane.showMessageDialog(SignInInterface.this,"����δ����!");
							new ztsj(labelzh,2).start(); 
						}
					}//1058,183,1103,192
				});
				addMouseMotionListener(new MouseAdapter() {
					public void mouseMoved(MouseEvent event) {
						int x=event.getX();                       //�õ�x,yΪ�����������
						int y=event.getY();
						//System.out.println(x+"   "+y);
						if(x>576&&x<645&&y<291&&y>275) {
							if(zcdj1) {
								labelzc.setForeground(Color.yellow);
								setCursor(HAND_CURSOR );          //�ı���Ϊ����
							}
						}
						else {
							labelzc.setForeground(Color.WHITE);              //button�����������밴ť���������ȡֹͣ��
							setCursor(DEFAULT_CURSOR );          //�ı���ΪĬ����
							if(x>1056&&x<1103&&(unchange2&&y<193&&y>183||!unchange2&&y<203&&y>193)) {
								if(zcdj2) {
									labelzh.setForeground(Color.yellow);
									setCursor(HAND_CURSOR );
								}
							}
							else {
								labelzh.setForeground(Color.WHITE);              //button�����������밴ť���������ȡֹͣ��
								setCursor(DEFAULT_CURSOR );
							}
						}
						
					}
				});
			
		}
		class ztsj extends Thread{
			public JLabel lb;
			int in;                    //�ı�ڼ���zcdj
			public ztsj(JLabel l,int i) {
				lb=l;
				in=i;
			}
			public void run() {
				try {                                   
					Thread.sleep(300);               //�������ڲ�������ͣ���ã��������ִ�У�����
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
	

}//�����ñ�����ɫ����setOpaque͸��
