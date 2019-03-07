package MINIdialogue;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import MINIQQmain.Linksever;

public class friendlist extends JPanel{

	JButton button1,button2,button3;
	ImageIcon icon11,icon12,icon21,icon22;
	JPanel jpfd,jpfs,jpwg;
	JPanel[] jpfds,jpfgs;
	JScrollPane jsfd,jsfs;
	mouseact mact;
	Friend fdgroup;
	int fsum;
	boolean bfdzs;
	static int fdheight=0,fdh2=85;
	public dialoguetool tool;
	public Friend[] friend;
	int[] bclk;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
////////////////////////////////////////
try    
{ // ʹ��Windows�Ľ�����  
UIManager.setLookAndFeel  
("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
}  
catch (Exception e)    
{  
e.printStackTrace();  
} 
//////////////////////////////////////////////////////////////
dialoguetool t=new dialoguetool();

		JFrame jf=new JFrame("�����б�");
		friendlist fds=new friendlist(t);
		jf.getContentPane().add(fds);
		jf.setBounds(1000,50,350,800+40);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);

	}
	public friendlist(dialoguetool t) throws IOException {
		tool=t;
//		tool.lks.prwriter.println(">>>\t"+Linksever.online+"\t"+"233"+"\t"+"233");
//		tool.lks.bfreader.readLine();
//		tool.lks.bfreader.readLine();
		//////
		CardLayout card=new CardLayout();
		setLayout(null);
		JPanel jpdc=new JPanel();
		jpdc.setLayout(card);
		jpdc.setBounds(0,40,350,800);
		icon11=new ImageIcon("image/����1.png");
		icon12=new ImageIcon("image/����2.png");
		icon21=new ImageIcon("image/Ⱥ��1.png");
		icon22=new ImageIcon("image/Ⱥ��2.png");
		icon11.setImage( icon11.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
		icon12.setImage( icon12.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
		icon21.setImage( icon21.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
		icon22.setImage( icon22.getImage().getScaledInstance(60, 40, Image.SCALE_DEFAULT));
		button1=new JButton("����",icon11);
		button2=new JButton("Ⱥ",icon21);
		button1.setFont(new Font("�����п�",Font.BOLD,20));
		button2.setFont(new Font("�����п�",Font.BOLD,20));
		button1.setBounds(5,0,165,40);
		button2.setBounds(170,0,165,40);
		button1.setFocusPainted(false); 
		button2.setFocusPainted(false); 
		jpfd=new JPanel();
		jpfs=new JPanel();
		jpfd.setLayout(null);
		jpfs.setLayout(null);
		jsfd=new JScrollPane(jpfd);
		jsfs=new JScrollPane(jpfs);
//		jsfd.setBounds(0,40,350,800);
//		jsfs.setBounds(0,40,350,800);
//		add(jsfd);
//		add(jsfs);//���������������ʼ��ӣ�֮���޷���ӣ�������������������
		
		add(button1);
		add(button2);
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				card.show(jpdc,"jsfd");
				repaint();
			}
		});
        button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				card.show(jpdc,"jsfs");
				repaint();
			}
		});
        mact=new mouseact();
      //�����б�
        tool.lks.prwriter.println(">>>\t"+Linksever.getfriends);
        String st=tool.lks.bfreader.readLine();
        System.out.println("<<<<<<<>>>>>>>>"+st);
        String[] str1=st.split("\t");//tool�������̻߳�δ����
        fsum=Integer.parseInt(str1[0]);
        friend=new Friend[fsum];
        bclk=new int[fsum];
        jpfds=new JPanel[fsum];
        for(int i=0;i<fsum;i++) {
        	jpfds[i]=new JPanel();
        	jpfds[i].setLayout(null);
        	boolean b=false;
        	if(str1[i*5+5].equals("����"))
        		b=true;
        	friend[i]=new Friend(str1[i*5+1],str1[i*5+3],str1[i*5+2],str1[i*5+4],b);
        	JLabel jb1=new JLabel(new ImageIcon("image/ͷ��"+str1[i*5+2]+".png"));
        	JLabel jb2=new JLabel(str1[i*5+3]+" lv"+str1[i*5+4]+" "+str1[i*5+5]);
            jb1.setBounds(5,10,60,60);
            jb2.setBounds(80,20,200,40);
            jpfds[i].setBackground(Color.WHITE);
            jpfds[i].add(jb1);
            jpfds[i].add(jb2);
            jpfds[i].setBounds(0,fdheight,350,80);
            jpfd.add(jpfds[i]);
            //
            fdheight+=80;
			jpfd.setPreferredSize(new Dimension(350,fdheight));//������fdbox.setSize(550,1500);��Ч�����ô˷���
			jpfds[i].addMouseListener(mact);
        }
        
        tool.addfriends(friend);
        
        new Thread() {            //��ȡ��������ȡ������һ�εģ�ֱ�������ܻ��һЩ����ȴ�һ��ʱ����ܻ�ȡ��ι���������
			public void run() {
				try {                          
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
			}
		}.start();
        //Ⱥ�б�
        tool.lks.prwriter.println(">>>\t"+Linksever.getgroup);
        String tempstr=tool.lks.bfreader.readLine();//tool�������̻߳�δ����////
        System.out.println(tempstr);////////////////////////////////
        fdgroup=new Friend(Friend.wordgroup,"����Ⱥ",null,"MAX",true);//Ⱥ�Ŀ�
        tool.fdgroup=fdgroup;
        String[] str2=tempstr.split("\t");
        int fsum2=Integer.parseInt(str2[0]);
        jpfgs=new JPanel[fsum2];
        for(int i=0;i<fsum2;i++) {
        	jpfgs[i]=new JPanel();
        	jpfgs[i].setLayout(null);
        	jpfgs[i].setBounds(0,85*(i+1),350,80);
        	boolean b=false;
        	if(str2[i*4+4].equals("����"))
        		b=true;
        	JLabel jb1=new JLabel(new ImageIcon("image/ͷ��"+str2[i*4+1]+".png"));
        	JLabel jb2=new JLabel(str2[i*4+2]+" lv"+str2[i*4+3]+" "+str2[i*4+4]);
            jb1.setBounds(5,10,60,60);
            jb2.setBounds(80,20,200,40);
            jpfgs[i].setBackground(Color.WHITE);
            jpfgs[i].add(jb1);
            jpfgs[i].add(jb2);
        }
        jpwg=new JPanel();
        jpwg.setBounds(0,0,350,80);
        jpwg.setBackground(Color.WHITE);
        jpwg.setLayout(null);
        jpwg.addMouseListener(mact);
        JLabel jb11=new JLabel(new ImageIcon("image/����Ⱥ.gif"));
        JLabel jb12=new JLabel("����Ⱥ");
        JLabel jb13=new JLabel("lvMAX");
        jb13.setFont(new Font("",Font.ITALIC+Font.BOLD,14));
        jb13.setForeground(Color.red);
        button3=new JButton("��Ա  ��");
        button3.setFont(new Font("",Font.BOLD,15));
        button3.setFocusPainted(false);   
        button3.setBounds(250,30,90,30);
        jb11.setBounds(5,10,60,60);
        jb12.setBounds(80,20,60,40);
        jb13.setBounds(140,20,60,40);
        jpwg.add(jb11);
        jpwg.add(jb12);
        jpwg.add(jb13);
        jpwg.add(button3);
        jpfs.add(jpwg);
        System.out.println(fsum2);
        button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(bfdzs) {
					button3.setText("��Ա  ��");
					addfgs(0,jpfgs.length,false);
					bfdzs=false;
				}else {
					button3.setText("��Ա  ��");
					addfgs(0,jpfgs.length,true);
					bfdzs=true;
				}
			}
		});
        
       
		
		add(jpdc);
		jpdc.add(jsfd,"jsfd");
		jpdc.add(jsfs,"jsfs");
//        
	}
	
	public void addtool(dialoguetool t) {
		tool=t;
	}
	class mouseact extends MouseAdapter{
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<friend.length;i++) {
				if(e.getSource()==jpfds[i]) {
					jpfds[i].setBackground(Color.white);
					break;
				}
			}
			if(e.getSource()==jpwg) {
				 jpwg.setBackground(Color.white);
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			for(int i=0;i<friend.length;i++) {
				if(e.getSource()==jpfds[i]) {
					jpfds[i].setBackground(Color.gray);
					break;
				}
			}
			if(e.getSource()==jpwg) {
				 jpwg.setBackground(Color.gray);
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			for(int i=0;i<friend.length;i++) {
				if(e.getSource()==jpfds[i]) {
					if(bclk[i]<1) {
						bclk[i]++;
						return;
					}
					System.out.println(12345);////////////////////
					tool.changefriend(friend[i]);
					bclk[i]=0;
					break;
				}
			}
			if(e.getSource()==jpwg) {
				 tool.changefdgroup(fdgroup);
			}
			
		}
	}
	public void addfgs(int a,int sum,boolean b) {
		if(a==sum) {
			return;
		}
		fdh2+=85;
		jpfs.setPreferredSize(new Dimension(350,fdh2));//������fdbox.setSize(550,1500);��Ч�����ô˷���
        //���ù�������ʾ�����
		new Thread() {            //��ȡ��������ȡ������һ�εģ�ֱ�������ܻ��һЩ����ȴ�һ��ʱ����ܻ�ȡ��ι���������
			public void run() {
				try {                          
					TimeUnit.MILLISECONDS.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				repaint();
				addfgs(a+1,sum,b);
			}
		}.start();
		if(b) {
			jpfs.add(jpfgs[a]);
		}else {
			jpfs.remove(jpfgs[sum-a-1]);
		}
		
	}

}
