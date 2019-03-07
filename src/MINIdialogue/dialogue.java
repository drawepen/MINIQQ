package MINIdialogue;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import MINIdrawing.drawing;

public class dialogue extends JPanel{
	public boolean groupchat=false;
	BufferedWriter bw;
	BufferedReader br;
	PrintWriter pw;
	Friend friend;//=new Friend("233","������1",104,true);//
//	Friend friend=new Friend("666","������2",103,true);
	JScrollPane jspbot;
	JTextArea jta;
	JButton sendout,eliminate,button1,button2,button3,button4,button5,button6,button7,button11,button12;
	Button bwordcolor,bbackcolor;
	buttonact ba;
	private Box box = null; // ��������������� 
	dialoguetool tool;
	Color fontcolor=Color.black,backcolor=new Color(166,242,212);
	int fontsize=16;
	int boldqx=0;
	String fonttype="΢���ź�";
	JComboBox setsize, wordtype;
	JCheckBox jcbold,jcltalic;
	JLabel jbprompt,jbfd;
	private int function=0;
	JPanel jpbq;
	boolean blbq=false;
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		dialoguetool too=new dialoguetool();
		dialogue dlg=new dialogue(too);
		too.ltt.start();
		dlg.jbprompt.setForeground(Color.black);
		JFrame jf=new JFrame();
		jf.setContentPane(dlg);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(1000,100,560,700+40+40);
		jf.setVisible(true);
		jf.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e){
				   dlg.tool.lks.cutlink();
				   dlg.tool.filelks.cutlink();
			   }
			 });
	}
	public dialogue(dialoguetool t)  {
		tool=t;
		tool.adddialogue(this);
//////////////////////////////////////////
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
		setLayout(null);
		
		jpbq=new JPanel();
		jpbq.setBounds(0,470,500,80);
		for(int i=1;i<9;i++) {
			ImageIcon ic=new ImageIcon("image/����10"+i+".png");
			ic.setImage(ic.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
			JLabel jb=new JLabel(ic);
			jb.setBounds(10+(i-1)*60,10,60,60);
			jpbq.add(jb);
		}
		jpbq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(blbq) {
					int x=e.getX(),
							y=e.getY();
					if(y>10&&y<70) {
						for(int i=0;i<8;i++) {
							if(x>i*60&&x<(i+1)*60) {
								if(tool.sendbq(101+i)) {
									addbq(101+i,friend,tool.myself.head,"");
									
								}else {
									JTextArea jl=new JTextArea();
								    jl.setEditable(false);//ģ��JLabel ��ֹ�༭����
								    jl.setBounds(200,friend.height,100,20);
								    friend.height+=25;
								    jl.setText("����ʧ��");
								    friend.fdbox.add(jl);
							    }
								dialogue.this.remove(jpbq);
								blbq=false;
							    jspanechange(friend);
							}
						}
					}
				}
			}
		});
		
		ba=new buttonact();
        upper();
        centre();
        bottom();
        setup();
	}
	
	public void upper() {//����
		jbfd=new JLabel("null",JLabel.CENTER);
		jbfd.setFont(new Font("",Font.BOLD,30));
		jbfd.setBounds(0,0,500,50);
		add(jbfd);
	}
	public void centre() {//�м�
		friend=new Friend();
		add(friend.jspane);
		friend.jspane.doLayout();    // ��������и���䣬����������ʾ����
	}
	public void bottom() {//�׶�
		
		//���ܰ�ť
		button1=new JButton(new ImageIcon("image/����.png"));
		button2=new JButton(new ImageIcon("image/�ļ�.png"));
		button3=new JButton(new ImageIcon("image/ͼƬ.png"));
		button4=new JButton(new ImageIcon("image/��Ƶ.png"));
		button5=new JButton(new ImageIcon("image/����.png"));
		button6=new JButton(new ImageIcon("image/���.png"));
		button7=new JButton(new ImageIcon("image/���.png"));
		button1.setBounds(5,555,28,25);
		button2.setBounds(35,555,28,25);
		button3.setBounds(65,555,28,25);
		button4.setBounds(95,555,28,25);
		button5.setBounds(125,555,28,25);
		button6.setBounds(155,555,28,25);
		button7.setBounds(185,555,28,25);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		jbprompt=new JLabel();//�ļ���ʾ
		jbprompt.setBounds(220,550,300,30);
		jbprompt.setForeground(Color.yellow);
		jbprompt.setFont(new Font("",Font.BOLD,12));
		add(jbprompt);
		button1.addActionListener(ba);
		button2.addActionListener(ba);
		button3.addActionListener(ba);
		button4.addActionListener(ba);
		button5.addActionListener(ba);
		button6.addActionListener(ba);
		button7.addActionListener(ba);
		//�����
		jta = new JTextArea(2,36);
		jta.setTabSize(4);
		jta.setFont(new Font("΢���ź�", boldqx, fontsize));
        jta.setLineWrap(true);// �����Զ����й���
        jta.setWrapStyleWord(true);// ������в����ֹ���
		jspbot=new JScrollPane(jta);
		jspbot.setBounds(5,580,540,80);
		add(jspbot);
		//�ײ㰴ť
		add(Box.createHorizontalStrut(330));
		eliminate=new JButton("���");
		eliminate.setBounds(330,662,100,36);
		eliminate.setFont(new Font("����",Font.BOLD,20));
		eliminate.setBackground(Color.white);//Color(r,b,g)//ʹ��windows���������ð�ť������ɫ��Ч
		eliminate.setFocusPainted(false);
		add(eliminate);
		
		add(Box.createHorizontalStrut(10));
		sendout=new JButton("����");
		sendout.setBounds(440,662,100,36);
		sendout.setFont(new Font("����",Font.BOLD,20));
		sendout.setForeground(new Color(0,100,0));//����Color(r,b,g)//�ı�(r,g,b)
		sendout.setFocusPainted(false);             //ȥ��ť���ֱ߿�  //setBorderPainted(false); 
		add(sendout);
		sendout.addActionListener(ba);
		eliminate.addActionListener(ba);
		
	}
	public void setup() {//���ÿ�
		JPanel jp_1=new JPanel();
		
		jp_1.setBounds(0,700,550,40);
		add(jp_1);
		jp_1.setBackground(Color.BLACK);
		jp_1.setLayout(null);
		//�����С
		String[] s=new String[41];
		for(int i=0;i<41;i++) {
			s[i]=""+(i+8);
		}
		setsize=new JComboBox(s);
		setsize.setSelectedIndex(12);//������ѡ��,���㿪ʼ
		setsize.setMaximumRowCount(5);
		setsize.setBounds(0,0,100,20);
		jp_1.add(setsize);
		//��������
		String[] str2= {"΢���ź�","����","����","����","����","������","�����п�","��������","Freestyle Script","Blackadder ITC"};
		wordtype=new JComboBox(str2);
		wordtype.setMaximumRowCount(5);
		wordtype.setBounds(100,0,90,20);
		jp_1.add(wordtype);
		JLabel jb_1=new JLabel(" �����С     ��������");
		jb_1.setFont(new Font("����",Font.BOLD,14));
		jb_1.setForeground(Color.white);
		jb_1.setBounds(10,20,190,20);
		jp_1.add(jb_1);
		//�Ӵ���б
		jcbold=new JCheckBox("�Ӵ�");
		jcltalic=new JCheckBox("��б");
		jcbold.setBounds(200,0,50,20);
		jcbold.setForeground(Color.white);
		jcbold.setBackground(Color.BLACK);
		jcltalic.setBounds(200,20,50,20);
		jcltalic.setForeground(Color.white);
		jcltalic.setBackground(Color.BLACK);
		jp_1.add(jcbold);
		jp_1.add(jcltalic);
		//��ɫ
		
		bwordcolor=new Button();
		bbackcolor=new Button();
		bwordcolor.setBackground(fontcolor);
		bbackcolor.setBackground(backcolor);
		bwordcolor.setBounds(352,1,26,20);
		bbackcolor.setBounds(442,1,26,20);
		jp_1.add(bwordcolor);
		jp_1.add(bbackcolor);
		JLabel jlb1=new JLabel();
		JLabel jlb2=new JLabel();
		jlb1.setOpaque(true);//JlabelĬ��͸��
		jlb2.setOpaque(true);
		jlb1.setBackground(Color.white);
		jlb2.setBackground(Color.white);
		JLabel jlb3=new JLabel("������ɫ   ������ɫ");
		jlb3.setForeground(Color.white);
		jlb3.setFont(new Font("����",Font.BOLD,14));
		jlb1.setBounds(350,1,30,22);
		jlb2.setBounds(440,1,30,22);
		jlb3.setBounds(340,22,180,20);
		jp_1.add(jlb1);
		jp_1.add(jlb2);
		jp_1.add(jlb3);
		//�Ӽ�����
		setsize.addActionListener(ba);
		wordtype.addActionListener(ba);
		jcbold.addActionListener(ba);
		jcltalic.addActionListener(ba);
		bwordcolor.addActionListener(ba);
		bbackcolor.addActionListener(ba);
		
	}
	
	public void changefriend(Friend f) {
		friend.jspane.setVisible(false);
		remove(friend.jspane);
		friend=f;
		add(friend.jspane,0);
		jbfd.setText(friend.nickname);
		friend.jspane.setVisible(true);
		new Thread() {
			public void run() {
				try {                          //while(true){ִ�еĲ���̫�ٻῨס����������}
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				repaint();//
			}
		}.start();
	}

	public void addText(String str,Color bcolor,String ftype,int size,Friend friend,String head,String name) {//�ı������ѣ�ͷ���ǳ�
		JTextArea jl=new JTextArea();
		jl.setLineWrap(true);//�Զ�����
		jl.setEditable(false);//ģ��JLabel ��ֹ�༭����
		jta.setText("");
		//��ͷ��1
		JLabel jb1=new JLabel(new ImageIcon("image/ͷ��"+head+".png"));
		//���ı�1
		jl.setForeground(fontcolor);
		jl.setFont(new Font(ftype,boldqx,size));
		jl.setBackground(bcolor);
		jl.setText(str);
		int w=10,h=10;
		String[] str2=str.split("\n", -1);//�ָ��ַ��������ַ����Զ�ɾ��
		int l0=str2.length;
		for(int i=0;i<l0;i++) {//�ж������ı����С
			int l=str2[i].length();
			if(l*size/360>0) {
				w=370;
				h+=(int)((l*size/360+1)*size*1.5);
			}else {
				if(l*size+10>w) {
					w=l*size+10;
				}
				h+=(int)(size*1.5);
			}
		}
		
		if(!name.equals("")) {       //���16801920
			//���ǳ�
			JLabel jb2=new JLabel(name);
//			jb2.setHorizontalAlignment(JLabel.RIGHT);//ˮƽ�Ҷ���
			int l2=name.length();
			jb2.setBounds(60,friend.height,l2*12,12);
			friend.fdbox.add(jb2);
			
			jb1.setBounds(0,friend.height,60,60);
			friend.fdbox.add(jb1);
			jl.setBounds(60,friend.height+30,w,h);
		}else {
			//��ͷ��2
			jb1.setBounds(friend.width-60,friend.height,60,60);
			friend.fdbox.add(jb1);
			//���ı�2
			jl.setBounds(friend.width-60-w,friend.height+30,w,h);
		}
		
		friend.height+=30+h+5;
		friend.fdbox.add(jl);
		jspanechange(friend);
	}
	public  void addfile(ImageIcon icon,JProgressBar jpb,String filename,long filesize,Friend friend,String head,String name) {
		
		JLabel jb1=new JLabel(new ImageIcon("image/ͷ��"+head+".png"));
		if(name.equals("")) {
			//��ͷ��
			jb1.setBounds(friend.width-60,friend.height,60,60);
			friend.fdbox.add(jb1);
		}else {
			//���ǳ�
			JLabel jb2=new JLabel(name);
//			jb2.setHorizontalAlignment(JLabel.RIGHT);//ˮƽ�Ҷ���
			int l2=name.length();
			jb2.setBounds(60,friend.height,l2*12,12);
			friend.fdbox.add(jb2);
			jb1.setBounds(0,friend.height,60,60);
			friend.fdbox.add(jb1);
		}
		
		if(icon==null) {
			
			long s = filesize/1024/1024;
		      String ends = " M";
		      if (s < 1) {
		        s = (filesize / 1024);
		        ends = " K";
		      } else if (s > 1024) {
		        float s1 = filesize / 1024 / 1024;
		        s = (filesize / 1024 / 1024 / 1024);
		        ends = " G��";
		      }
			JPanel jp0=new JPanel();
			jp0.setLayout(null);
			JLabel jb2=new JLabel(new ImageIcon("image/�ļ�(80,69).png"));
			JLabel jb3=new JLabel(" "+filename);
			JLabel jb4=new JLabel("  "+s+ends+" ���ͳɹ������浽ɾ��");
			jb2.setBounds(5,5,80,69);
			jb3.setBounds(85,5,200,25);
			jb4.setBounds(85,30,200,20);
			jpb.setBounds(85,50,200,20);
			jp0.add(jb2);
			jp0.add(jb3);
			jp0.add(jb4);
			jp0.add(jpb);
			if(name.equals("")) {
				jp0.setBounds(friend.width-360,friend.height+30,300,80);
				friend.fdbox.add(jp0);
			}else {
				String[] strx=filename.split("&@&");
				jb3.setText(strx[1]);//�ļ�����
				JLabel jbx=new JLabel(filename);//�������ļ�·��
				jb4.setText("    "+s+ends+".");
				JButton button1=new JButton("����");
				JButton button2=new JButton("ȡ��");
				button1.setBounds(290,10,60,30);
				button2.setBounds(290,45,60,30);
				jp0.add(button1);
				jp0.add(button2);
				button1.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						    tool.lks.prwriter.println(">>>\t"+tool.lks.refile+"\t"+filename);
				        	tool.new getfile(filename,jpb,filesize).start();
					}
				});
				jp0.setBounds(60,friend.height+30,350,80);
				friend.fdbox.add(jp0);
			}
			friend.height+=30+80+10;
		}else {
			System.out.println(icon);
			icon.setImage(icon.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
			JLabel jb0=new JLabel(icon);
            if(name.equals("")) {
            	jb0.setBounds(friend.width-360,friend.height+30,300,300);
			}else {
				jb0.setBounds(60,friend.height+30,300,300);
			}
			
			friend.fdbox.add(jb0);
			friend.height+=30+300+10;
		}	
		jspanechange(friend);
	}
	class buttonact implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			try {                                    //��ť
				JButton jb=(JButton) e.getSource();
				
				if(jb==sendout) {
				    if(function==2) {//���ļ�
						JProgressBar  pgb = new JProgressBar();
					    pgb.setBackground(Color.WHITE);
					    pgb.setForeground(new Color(51, 51, 255));
					    pgb.setStringPainted(true);
					    String[] ts=jbprompt.getText().split("�� ");//���ӿո�E:Ҳ���
					    System.out.println(ts[1]);
					    File file=new File(ts[1]);
					    addfile(null,pgb,file.getName(),file.length(),friend,tool.myself.head,"");
						tool.new sendfile(ts[1],pgb).start();
						function=0;
						 jbprompt.setText("");
					}else if(function==3) {//��ͼƬ
						String[] ts=jbprompt.getText().split("�� ");
						ImageIcon icon=new ImageIcon(ts[1]);
						addfile(icon,null,"",0,friend,tool.myself.head,"");
						tool.new sendfile(ts[1],null).start();
						jbprompt.setText("");
						function=0;
					}else {
					    String str=jta.getText();
					    if(tool.sendString(str,backcolor.getRed(),backcolor.getGreen(),backcolor.getBlue(),fonttype,fontsize)) {
						    addText(str,backcolor,fonttype,fontsize,friend,tool.myself.head,"");
					    }else {
						    JTextArea jl=new JTextArea();
						    jl.setEditable(false);//ģ��JLabel ��ֹ�༭����
						    jl.setBounds(250,friend.height,100,20);
						    friend.height+=25;
						    jl.setText("����ʧ��");
						    friend.fdbox.add(jl);
					    }
					    jspanechange(friend);
					}
				}else if(jb==eliminate) {
					jbprompt.setText("");
					function=0;
					jta.setText("");
				}else if(jb==button1) {
					if(blbq) {
						remove(jpbq);
						repaint();
						blbq=false;
					}else {
						dialogue.this.add(jpbq,0);//intԽСԽ���ϲ㣬���ϲ�Ϊ0
						repaint();//���̶���ʱ���ı䣬����������ʾ��������
						blbq=true;
					}
					
				}else if(jb==button2) {
					if(groupchat) {
						JOptionPane.showMessageDialog(dialogue.this,"Ⱥ�����޴˹���");
						return;
					}
					JFileChooser jf = new JFileChooser();      
			        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        jf.showOpenDialog(dialogue.this);
			        if(jf.getSelectedFile()==null)  return;
			        jbprompt.setText("�ļ��� "+jf.getSelectedFile().getPath());//ע�������ģ��Ժ������Ӧ
					function=2;
				}else if(jb==button4) {
					if(groupchat) {
						JOptionPane.showMessageDialog(dialogue.this,"Ⱥ�����޴˹���");
						return;
					}
					JFileChooser jf = new JFileChooser();      
			        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        jf.showOpenDialog(dialogue.this);
			        if(jf.getSelectedFile()==null)  return;
			        jbprompt.setText("��Ƶ�ļ��� "+jf.getSelectedFile().getPath());//ע�������ģ��Ժ������Ӧ
					function=2;
				}else if(jb==button3) {
					if(groupchat) {
						JOptionPane.showMessageDialog(dialogue.this,"Ⱥ�����޴˹���");
						return;
					}
					JFileChooser jf = new JFileChooser();      
			        jf.setFileSelectionMode(JFileChooser.FILES_ONLY);
			        jf.showOpenDialog(dialogue.this);
			        if(jf.getSelectedFile()==null)  return;
			        jbprompt.setText("ͼƬ�� "+jf.getSelectedFile().getPath());
					function=3;
				}else if(jb==button5) {
					tool.ssrun.run();//����
				}else if(jb==button6) {//�����
					if(tool.sendbq(199)) {
						addbq(199,friend,tool.myself.head,"");
						
					}else {
						JTextArea jl=new JTextArea();
					    jl.setEditable(false);//ģ��JLabel ��ֹ�༭����
					    jl.setBounds(200,friend.height,100,20);
					    friend.height+=25;
					    jl.setText("����ʧ��");
					    friend.fdbox.add(jl);
				    }
					dialogue.this.remove(jpbq);
					blbq=false;
				    jspanechange(friend);
				}else if(jb==button7) {
					if(groupchat) {
						JOptionPane.showMessageDialog(dialogue.this,"Ⱥ�����޴˹���");
						return;
					}
					tool.choosesong();
				}
			}catch(Exception ex) {                           //ѡ���
				if(e.getSource()==setsize) {//�����С
					fontsize=Integer.parseInt(setsize.getSelectedItem().toString());
					jta.setFont(new Font(fonttype,boldqx,fontsize));
				}else if(e.getSource()==wordtype) {//��������
					fonttype=wordtype.getSelectedItem().toString();
					jta.setFont(new Font(fonttype,boldqx,fontsize));
				}else if(e.getSource()==jcbold) {//�Ӵ�
					if(jcbold.isSelected()) {//�жϸ�ѡ���Ƿ�ѡ��
						boldqx+=Font.BOLD;
					}else {
						boldqx-=Font.BOLD;
					}
					jta.setFont(new Font(fonttype,boldqx,fontsize));
				}else if(e.getSource()==jcltalic) {//��б
					if(jcltalic.isSelected()) {
						boldqx+=Font.ITALIC;
					}else {
						boldqx-=Font.ITALIC;
					}
					jta.setFont(new Font(fonttype,boldqx,fontsize));
				}else if(e.getSource()==bwordcolor) {
					fontcolor=JColorChooser.showDialog(dialogue.this, "��ɫ",fontcolor);
					bwordcolor.setBackground(fontcolor);
					jta.setForeground(fontcolor);
				}else if(e.getSource()==bbackcolor) {
					backcolor=JColorChooser.showDialog(dialogue.this, "��ɫ",backcolor);
					bbackcolor.setBackground(backcolor);
				}
			}
			
			
		}
		
	}
	public void jspanechange(Friend friend) {
		friend.fdbox.setPreferredSize(new Dimension(friend.width, friend.height));//������fdbox.setSize(550,1500);��Ч�����ô˷���
		
        //���ù�������ʾ�����
		new Thread() {            //��ȡ��������ȡ������һ�εģ�ֱ�������ܻ��һЩ����ȴ�һ��ʱ����ܻ�ȡ��ι���������
			public void run() {
				try {                          
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JScrollBar jscrollBar = friend.jspane.getVerticalScrollBar();
			    if (jscrollBar != null)
			        jscrollBar.setValue(jscrollBar.getMaximum());
			    repaint();
			}
		}.start();
		friend.jspane.setVisible(false);//JScrollPane�ı�һ��ʱ��������������ȹغ󿪲���ʾ������������������������������
	    friend.jspane.setVisible(true);
	}

	public void addbq(int bq,Friend friend,String head,String name) {
		JLabel jb1=new JLabel(new ImageIcon("image/ͷ��"+head+".png"));
		JLabel jl=new JLabel(new ImageIcon("image/����"+bq+".png"));
		if(!name.equals("")) {       //���
			//���ǳ�
			JLabel jb2=new JLabel(name);
//			jb2.setHorizontalAlignment(JLabel.RIGHT);//ˮƽ�Ҷ���
			int l2=name.length();
			jb2.setBounds(60,friend.height,l2*12,12);
			friend.fdbox.add(jb2);
			
			jb1.setBounds(0,friend.height,60,60);
			friend.fdbox.add(jb1);
			jl.setBounds(60,friend.height+30,130,130);
			friend.fdbox.add(jl);
		}else {
			jb1.setBounds(friend.width-60,friend.height,60,60);
			jl.setBounds(friend.width-190,friend.height+30,130,130);
			friend.fdbox.add(jl);
			friend.fdbox.add(jb1);	
		}
		friend.height+=30+130+5;
		jspanechange(friend);
	}
	
	

}
