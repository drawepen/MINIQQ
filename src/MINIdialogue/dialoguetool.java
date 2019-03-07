package MINIdialogue;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.sound.midi.Track;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import javax.swing.JWindow;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import MINIQQaddition.musicplay;
import MINIQQmain.Linksever;
import MINIQQmain.personal;
import MINIdrawing.drawing;


public class dialoguetool {
	public boolean groupchat;
	private static final String AWTUtilities = null;
	Choice ccsong;
	JFrame jfcsong;
	JButton jbcsong;
	public static int x,y;
	boolean sdfile;
	public ScreenShotWindow ssrun;
	public personal myself;
	public Linksever lks,filelks,drawlks;
	private BufferedReader bfreader;
	public dialogue dia;
	public drawing draw;
	public Friend friend,fdgroup;
	public Friend[] friends;
	public Listenget ltt;
	public void adddialogue(dialogue di) {
		dia=di;
	}
	public void adddrawing(drawing dr) {
		draw=dr;
	}
	public void addfriends(Friend[] fs) {
		friends=fs;
	}
	public void addmyself(personal m) {
		myself=m;
	}
	public dialoguetool() {
		try {
			lks=new Linksever();
			filelks=new Linksever();
			drawlks=new Linksever();
		}catch(UnknownHostException e) {
			JOptionPane.showMessageDialog(null,"��������ƨ��~");
		}catch(IOException e) {
			JOptionPane.showMessageDialog(null,"��������ƨ��~");
			System.out.println(1233);
		}
	    ssrun=new ScreenShotWindow();     
//	    lks.prwriter.println(">>>\t"+lks.online+"\t"+"233");
	    ltt=new Listenget();
	    friend=new Friend();
	    //���
	    jbcsong=new JButton("ȷ��");
	    jfcsong=new JFrame("���");
		ccsong=new Choice();
		ccsong.add("���к�_�����ֵ�");
		ccsong.add("һЦ���-(���Ӿ硶΢΢һЦ����ǡ�Ƭͷ��)-������");
		jfcsong.getContentPane().setLayout(new FlowLayout() );
		jfcsong.getContentPane().add(ccsong);
		jfcsong.getContentPane().add(ccsong);
		jfcsong.getContentPane().add(jbcsong);
		jfcsong.setBounds(500,300,400,100);
		jbcsong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String str=ccsong.getSelectedItem();
				lks.prwriter.println(">>>\t"+Linksever.csong+"\t"+friend.account+"\t"+str);
				
			}
		});
		
	}
	public void changefriend(Friend f) {
		groupchat=false;
		dia.groupchat=false;
		lks.prwriter.println(">>>\t"+Linksever.drawingfd+"\t"+f.account);
		System.out.println("cfd:"+f.account);///////////////////////////////////////////////
		dia.changefriend(f);
		friend=f;
		
		/////////////////
	}
	public void changefdgroup(Friend fg) {
		fdgroup=fg;
		groupchat=true;
		dia.groupchat=true;
		dia.changefriend(fg);
		friend=fg;
	}
	public boolean sendString(String str,int r,int g,int b,String f,int size) {//�ַ�������ɫ���������ͣ���С
		// �ͻ���������������������Ϣ
		lks.prwriter.println(">>>\t"+lks.string+"\t"+friend.account+"\t"+r+"\t"+g+"\t"+b+"\t"+f+"\t"+size);//������������ַ�����friendaccount
		lks.prwriter.println(str);
		lks.prwriter.println(lks.end);
		for(int i=0;i<5;i++) {//�ж��Ƿ��ͳɹ�
			if(ltt.success_string) {
				ltt.success_string=false;
				return true;
			}
			try {                         
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
		}
		
		return false;
	}
	public boolean sendbq(int bq) {
		// �ͻ���������������������Ϣ
		lks.prwriter.println(">>>\t"+lks.expression+"\t"+friend.account);//������������ַ�����friendaccount
		lks.prwriter.println(bq);
//			if(lks.bfreader.readLine().equals(lks.expression)) {//���ն�ֻ����һ��
		for(int i=0;i<5;i++) {//�ж��Ƿ��ͳɹ�
			if(ltt.success_expression) {
				ltt.success_expression=false;
				return true;
			}
			try {                         
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     
		}
		
		return false;
	}
    public void choosesong() {
		jfcsong.setVisible(true);
	}
    public class sendfile extends Thread{
		private String filepath;
		private JProgressBar jprogressbar;
		public sendfile(String s,JProgressBar j) {
			filepath=s;
			jprogressbar=j;
		}
		public void run() {
			while(sdfile) {
				  try {          
					  TimeUnit.MILLISECONDS.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}            
			  }
			  sdfile=true;
			 try {
			      InputStream input = filelks.input;
			      OutputStream output = filelks.output;
			      File file = new File(filepath);
			     
			      int len=0;
			      if(jprogressbar!=null) {
			    	  lks.prwriter.println(">>>\t"+lks.file+"\t"+friend.account);
//			    
			    	 
			      }else {
			    	  lks.prwriter.println(">>>\t"+lks.image+"\t"+friend.account);
			      }
			      // ��һ�δ����ļ�����and�ļ��Ĵ�С
		    	  String str1 = file.getName() + "\t" + file.length();
			      output.write(str1.getBytes());
			      output.flush();
			      System.out.println("�ļ���"+str1);///////////////////////////////
//			       try {                          
//					TimeUnit.MILLISECONDS.sleep(200);
//				 } catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				  }
			        long size = 0;
			        if(jprogressbar!=null)
			        jprogressbar.setMaximum((int) (file.length() / 100));// ���ý��������ֵ
			        FileInputStream fins = new FileInputStream(file);
			        byte[] b1 = new byte[1024 * 1024];
			        while (fins.available() != 0) {
			          len = fins.read(b1);
			          output.write(b1, 0, len);
			          output.flush();
			          size += len;            //???len���2097152�������ͬ��len���65536???!!!
			          if(jprogressbar!=null)
			          jprogressbar.setValue((int) (size / 100));
			        }
//			        output.write(-1);//=255�޷��为��
//				    output.flush();
//			        if (fins.available() == 0) {
//			         JOptionPane.showMessageDialog(null, "�ϴ���ϣ�"); 
//			        }
			        
			        fins.close();
			    } catch (IOException e) {
			      JOptionPane.showMessageDialog(null, "IOException");
			    }
			 sdfile=false;
		}
		
	}
	public class getfile extends Thread{
		private String filename;
		long fs;
		private JProgressBar jprogressbar;
		public getfile(String f,JProgressBar j,long size) {
			filename=f;
			jprogressbar=j;
			fs=size;
		}
		public void run() {
			if(jprogressbar!=null) {
				filename=filename.split("&@&")[1];//�ļ�����
				JFileChooser jf = new JFileChooser();
				jf.setDialogTitle("����");
		        // �洢������·���ļ���
		        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		        jf.showOpenDialog(null);
		        try {
		        	if(jf.getSelectedFile()!=null) {
		        		int len=0;
		 				FileOutputStream fout = new FileOutputStream(new File(jf.getSelectedFile(), filename));
		 				jprogressbar.setMaximum((int) (fs / 100));// ���ý��������ֵ
		 				filelks.output.write(lks.fileaccept);//��ʾ����
		 				System.out.println("accept "+fs);
		 				byte[] b = new byte[1024 * 1024 ];
		 		        long size=0;//
		 		        while (size<fs&&(len=filelks.input.read(b))!=-1) {//�ֽ��׹رղŷ���-1������
		 		          fout.write(b, 0, len);
		 		          size+=len;
		 		          jprogressbar.setValue((int) (size / 100));
		 		        }
		 		        fout.close();
			        }else {
			        	filelks.output.write(lks.fileaccept+10);//��ʾ������
			        }
				   
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {//��ͼƬ
				System.out.println(filename);
				String[] ts=filename.split("file");//???????????????�ú�\\��ֱ�����������������
				filename=ts[1];                    //���ڲ�����⣬filename==\...
				int len=0;
				new File("E:\\MINIQQ\\imagesave").mkdirs();//����Ŀ¼���Ѵ��ڲ��Ḳ��
 				FileOutputStream fout = null;
				try {
					fout = new FileOutputStream(new File("E:\\MINIQQ\\imagesave"+filename));//filenameǰ��\
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 				byte[] b = new byte[1024 * 1024 ];
 		        long size=0;//
 		        try {
					while (size<fs&&(len=filelks.input.read(b))!=-1) {//�ֽ��׹رղŷ���-1������
					  fout.write(b, 0, len);
					  size+=len;
					}
					fout.close();
					ImageIcon icon=new ImageIcon("E:\\MINIQQ\\imagesave"+filename);
					dia.addfile(icon,null,"",0,friend,friend.head,friend.nickname);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
 		       
			}
			
		}
	}
	class lisdraw extends Thread{
		public void run() {
				try {
					InputStream din = drawlks.input;
					byte[] b=new byte[8];
					int le;
					while ((le=din.read(b))!=-1) {
						if(b[0]==0) {
							draw.fdx=b[1]*100+b[2];
							draw.fdy=b[3]*100+b[4];
							draw.g2D=(Graphics2D)(draw.getGraphics());
							draw.g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//��������ƽ��
						}else {
							draw.jsdraw(b[1]*100+b[2],b[3]*100+b[4]); 
						}
//						System.out.println(x1+" "+y1+" -> "+x2+" "+y2);///////////////////////
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public class Listenget extends Thread{
		public boolean success_string,success_expression;
		public void run() {
			new lisdraw().start();//��ͼ��Ϣ����
			while(true) {
				String str2=null;
				try {
					str2 = lks.bfreader.readLine();
					System.out.println(str2+"<<");
					String[] str0=null;
					try {
						str0 = str2.split("\t");
					}catch( java.lang.NullPointerException e) {
						continue;
					}
					if(str0[0].equals(">>>")) {
						Friend friend=dialoguetool.this.friend;
						if(str0.length>2) {
							for(int i=0;i<friends.length;i++) {
								if(friends[i].account.equals(str0[2])) {
									friend=friends[i];
									System.out.println("���ѣ�"+friend.nickname);//////////////
									break;
								}
							}
						}
						switch(str0[1]) {
						case Linksever.string:
							Color c=new Color(Integer.parseInt(str0[3]), Integer.parseInt(str0[4]), Integer.parseInt(str0[5]));
							String s11=getstring(lks.bfreader);
							dia.addText(s11, c,str0[6],Integer.parseInt(str0[7]), friend, friend.head, friend.nickname);
							friend.fdbox.repaint();
							break;
						case Linksever.expression:
							String s2=lks.bfreader.readLine();
							dia.addbq(Integer.parseInt(s2), friend, friend.head, friend.nickname);///friend temp
							break;
						case Linksever.file:
							System.out.println("<<<>>>");///////////////
							byte[] b = new byte[256];
						      int len = filelks.input.read(b);
						      String ss = new String(b, 0, len);
						      String[] str1 = ss.split("\t");// �ѽ��յ�����Ϣ���Ʊ�����
						      System.out.println("ss������>"+ss);
						      String filexname= str1[0];// �������ļ�·��
						      String filesize = str1[1];// �ļ��Ĵ�С
						      long size = Long.parseLong(filesize);
						      long s = size / 1024 / 1024;
						      String name = " M";
						      if (s < 1) {
						        s = (size / 1024);
						        name = " K";
						      } else if (s > 1024) {
						        float s1 = size / 1024 / 1024;
						        s = (size / 1024 / 1024 / 1024);
						        name = " G��";
						      }
							JProgressBar  pgb = new JProgressBar();
						    pgb.setBackground(Color.WHITE);
						    pgb.setForeground(new Color(51, 51, 255));
						    pgb.setStringPainted(true);
							dia.addfile(null, pgb, filexname, size, friend, friend.head, friend.nickname);
							 // ����ȷ�Ͽ��ʾ�Է���ip�˿��Լ��ļ������ƺʹ�С�Ƿ���Ҫ����
						      int sf = JOptionPane.showConfirmDialog(null,
						          "����: " + str0[2]+ "\n�ļ�����: " + filexname.split("&@&")[1] + "\n�ļ���С: " + s + name);
						      // ������ȷ��
						      if (sf == JOptionPane.OK_OPTION) {
						    	  dialoguetool.this.new getfile(filexname,pgb,size).start();
						      }else {
						    	  filelks.output.write(lks.fileaccept+10);//�跢���ֽڽ�������˵ȴ�
						      }
							break;
						case Linksever.image:
							byte[] b2 = new byte[256];
						    int len2 = filelks.input.read(b2);
						    String ss2 = new String(b2, 0, len2);
						    String[] str3 = ss2.split("\t");// �ѽ��յ�����Ϣ���Ʊ�����
						    System.out.println("<1>"+ss2);///////////////////////////////////
						    String filexname2= str3[0];// �������ļ�·��
						    long size2 = Integer.parseInt(str3[1]);// �ļ��Ĵ�С
						    dialoguetool.this.new getfile(filexname2,null,size2).start();
							break;
						case Linksever.success:
							if(str0[2].equals(lks.string)) {
								success_string=true;
							}else if(str0[2].equals(lks.expression)) {
								success_expression=true;
							}
							break;
						case Linksever.csong:
							new musicplay(new File("music/"+str0[3]+".mp3"),str0[2],str0[3]);
							
							break;
						}
					}else if(str0[0].equals("<<<")){//Ⱥ��
						Friend friend=dialoguetool.this.friend;
						if(str0.length>2) {
							for(int i=0;i<friends.length;i++) {
								if(friends[i].account.equals(str0[2])) {
									friend=friends[i];
									System.out.println("���ѣ�"+friend.nickname);//////////////
									break;
								}
							}
						}
						switch(str0[1]) {
						case Linksever.string:
							Color c=new Color(Integer.parseInt(str0[3]), Integer.parseInt(str0[4]), Integer.parseInt(str0[5]));
							String s11=getstring(lks.bfreader);
							dia.addText(s11, c,str0[6],Integer.parseInt(str0[7]), fdgroup, friend.head, friend.nickname);
							friend.fdbox.repaint();
							break;
						case Linksever.expression:
							String s2=lks.bfreader.readLine();
							dia.addbq(Integer.parseInt(s2), fdgroup, friend.head, friend.nickname);///friend temp
							break;
							
					   }
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
//					e1.printStackTrace();
					return;
				}
				
			}
		}
		public String getstring(BufferedReader in) throws IOException {
			String s=in.readLine(),str="",s2=in.readLine();//��һ��������Linksever.end
			while(!s2.equals(Linksever.end)) {
				str+=s+"\n";
				s=s2;
				s2=in.readLine();
			}
			return str+s;
		}
	}
	
	
	class ScreenShotWindow extends JWindow{//���� 
		 
	   private int orgx, orgy, endx, endy;
	      private BufferedImage image=null;
	      private BufferedImage tempImage=null;
	      private BufferedImage saveImage=null;

	      private ToolsWindow tools=null;

	      @Override
	      public void paint(Graphics g) {
	          RescaleOp ro = new RescaleOp(0.8f, 0, null);
	          tempImage = ro.filter(image, null);
	          g.drawImage(tempImage, 0, 0, this);
	      }
	      //����ͼ���ļ�
	   public void saveImage() throws IOException {
	    JFileChooser jfc=new JFileChooser();
	    jfc.setDialogTitle("����");

	    //�ļ����������û����˿�ѡ���ļ�
	    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG", "jpg");
	    jfc.setFileFilter(filter);

	    //��ʼ��һ��Ĭ���ļ������ļ������ɵ������ϣ�
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddHHmmss");
	       String fileName = sdf.format(new Date());
	       File filePath = FileSystemView.getFileSystemView().getHomeDirectory();
	       File defaultFile = new File(filePath + File.separator + fileName + ".jpg");
	       jfc.setSelectedFile(defaultFile);

	    int flag = jfc.showSaveDialog(this);
	    if(flag==JFileChooser.APPROVE_OPTION){
	     File file=jfc.getSelectedFile();
	     String path=file.getPath();
	     //����ļ���׺�������û����������׺�������벻��ȷ�ĺ�׺
	     if(!(path.endsWith(".jpg")||path.endsWith(".JPG"))){
	      path+=".jpg";
	     }
	     //д���ļ�
	     ImageIO.write(saveImage,"jpg",new File(path));
	    }
	   }
	   
	//   public ScreenShotWindow() {
//		   
	//   }
	//   

	public void run() {
		// TODO Auto-generated method stub
	    //��ȡ��Ļ�ߴ�
	    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setBounds(0, 0, d.width, d.height);

	    //��ȡ��Ļ
	    Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    image = robot.createScreenCapture(new Rectangle(0, 0, d.width,d.height));

	    this.addMouseListener(new MouseAdapter() {
	     @Override
	    public void mousePressed(MouseEvent e) {
	     //����ɿ�ʱ��¼���������꣬�����ز�������
	              orgx = e.getX();
	              orgy = e.getY();

	              if(tools!=null){
	               tools.setVisible(false);
	              }
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
	     //����ɿ�ʱ����ʾ��������
	     if(tools==null){
	      tools=new ToolsWindow(ScreenShotWindow.this,e.getX(),e.getY());
	     }else{
	      tools.setLocation(e.getX(),e.getY());
	     }
	     tools.setVisible(true);
	     tools.toFront();
	    }
	   });

	    this.addMouseMotionListener(new MouseMotionAdapter() {

	    @Override
	    public void mouseDragged(MouseEvent e) {
	     //����϶�ʱ����¼���겢�ػ洰��
	                 endx = e.getX();
	                 endy = e.getY();

	                 //��ʱͼ�����ڻ�����Ļ���������Ļ��˸
	                 Image tempImage2=createImage(ScreenShotWindow.this.getWidth(),ScreenShotWindow.this.getHeight());
	                 Graphics g =tempImage2.getGraphics();
	                 g.drawImage(tempImage, 0, 0, null);
	                 int x = Math.min(orgx, endx);
	                 int y = Math.min(orgy, endy);
	                 int width = Math.abs(endx - orgx)+1;
	                 int height = Math.abs(endy - orgy)+1;
	                 // ����1��ֹwidth��height0
	                 g.setColor(Color.BLUE);
	                 g.drawRect(x-1, y-1, width+1, height+1);
	                 //��1��1���˷�ֹͼƬ���ο򸲸ǵ�
	                 saveImage = image.getSubimage(x, y, width, height);
	                 g.drawImage(saveImage, x, y, null);

	                 ScreenShotWindow.this.getGraphics().drawImage(tempImage2,0,0,ScreenShotWindow.this);
	    }
	   });
	    setVisible(true);
	}
	/*
	 * ��������
	 */
	class ToolsWindow extends JWindow
	{
	 private ScreenShotWindow parent;

	 public ToolsWindow(ScreenShotWindow parent,int x,int y) {
	  this.parent=parent;
	  this.init();
	  this.setLocation(x, y);
	  this.pack();
	  this.setVisible(true);
	 }

	 private void init(){

	  this.setLayout(new BorderLayout());
	  JToolBar toolBar=new JToolBar("MINIQQ��ͼ");

	  //���水ť
	  JButton saveButton=new JButton("ȷ��");
	  saveButton.addActionListener(new ActionListener() { 
	   @Override
	   public void actionPerformed(ActionEvent e) {
	    try {
	     parent.saveImage();
	    } catch (IOException e1) {
	     e1.printStackTrace();
	    }
	    ssrun.setVisible(false);
	  	setVisible(false); 
	   }
	  });
	  toolBar.add(saveButton);

	  //�رհ�ť
	  JButton closeButton=new JButton("ȡ��");
	  closeButton.addActionListener(new ActionListener() {
	   @Override
	   public void actionPerformed(ActionEvent e) {
	  	 ssrun.setVisible(false);
	  	 setVisible(false);         
//	  	ssrun.setVisible(true);
//	 	 setVisible(true);
	   }
	  });
	  toolBar.add(closeButton);

	  this.add(toolBar,BorderLayout.NORTH);
	 }
	}
	}
}
