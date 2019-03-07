package MINIdrawing;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
//import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.ColorModel;
import java.io.IOException;
import java.util.EventObject;
import java.util.concurrent.TimeUnit;

import javax.security.auth.callback.ChoiceCallback;
import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import MINIQQmain.Linksever;
import MINIQQmain.desktop;
import MINIdialogue.dialoguetool;

public class drawing extends JPanel{
	Point start=new Point();
	public int fdx,fdy;
	private float fontsize=1;
	private int fontends=BasicStroke.CAP_ROUND,fontlink=BasicStroke.JOIN_ROUND;
	BasicStroke basicstroke;//虚线（实x虚y）(1,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{x,y},0);
    public Graphics2D g2D;//不允许静态
    Choice shapechoice;//JComboBox
    Choice wordtype;
    dialoguetool tool;
    boolean drawb=false,undottedline=true,pickupcolor=false,unsizeshow=true,unwordshow=true,eraser=false,word=false,blfill=false;
    Color mygray=new Color(51,51,51),recordcolor=Color.black,usecolor=Color.black,mycolorless=new Color(242,242,242);
    private int red=0,green=0,blue=0,textlong=1;
    String oldsize="5",typeface="";
    addML aml;
    JFrame jwsize;
    Point pcolorshow=new Point(360,3);
    JTextField textword;
    JCheckBox shapefill,jcbold,jcltalic;
    JFrame setcursor;
    Cursor cursor;
    public int jwx=305,jwy=800;
    int cursortype=Cursor.HAND_CURSOR;//十字CROSSHAIR_CURSOR;//十字箭头MOVE_CURSOR;//手指状HAND_CURSOR;//默认光标DEFAULT_CURSOR//
    public drawingset drawset;
    public JLabel labelxy;
    public JPanel jplbxy;
    public static void main(String[] args) {
		JFrame jf=new JFrame("MINIdrawing");
		
		drawing dr=new drawing(jf,new dialoguetool());
		jf.getContentPane().add(dr);
		jf.setLocation(1000,0);
		jf.setSize(560,700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		JFrame jf2=new JFrame("设置");
		dr.drawset.setBackground(Color.black);
		dr.drawset.setOpaque(true);
		jf2.setLocation(1000,700);
		jf2.setSize(560,50+30);
		jf2.add(dr.drawset);
		jf2.setVisible(true);
	}
  /////////////////////////////////////////////////////////////////////////////////////////////////////
//	public void paintComponent(Graphics g){          //在paint()中加super(g)后，此方法成为repaint()调用方法之一
//	    super.paintComponent(g);                 //有此步可删除重绘前内容
//	    System.out.println("pc");
//
////	    for(int i =0 ;i<pointList.size()-1;i=i+2){
////	        Point p1 = pointList.get(i);
////	        Point p2 = pointList.get(i+1);
////	    }
//	}
  //////////////////////////////////////////////////////////////////////////////////////////////////////
	//@Override
    public void paint(Graphics g){           //绘图只能在这个方法内,且不能在此方法内的监听器内//repaint()调用方法之一
    	super.paint(g);     //没有此方法，setBackground()无法使用!!!!!!!
    	   System.out.println("pcp");
    	   
    }
    public void repaint(){
    	
    }
    public drawing(JFrame jf,dialoguetool to) {
    	tool=to;
    	drawset=new drawingset();
    	setBackground(mycolorless);
    	aml=new addML();
    	addMouseListener(aml);
    	addMouseMotionListener(aml);
    	setcursor=jf;
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	Image image = new ImageIcon("image/tp101.png").getImage();
    	cursor = tk.createCustomCursor(image, new Point(10, 10), "norm"); 
    	labelxy=new JLabel();
    	labelxy.setFont(new Font("",1,8));
    	labelxy.setText("(—— ——)");
    	jplbxy=new JPanel();
    	jplbxy.setLayout(null);
    	jplbxy.setBackground(new Color(209,209,209));
    	//jplbxy.setOpaque(false);
    	labelxy.setBounds(0,0,100,10);
    	jplbxy.add(labelxy);//？？？不在其他内部面板上添加JLabel,显示它会影响画图！！！
    }
	public Color pickColor() throws AWTException {  //获取颜色
    	Robot robot=new Robot();//系统鼠标控制器
        Point mousepoint = MouseInfo.getPointerInfo().getLocation();//绝对坐标
		Color pixel = robot.getPixelColor(mousepoint.x, mousepoint.y);//(String)pixel<==>java.awt.Color[r=238,g=238,b=238]
//         robot.mouseMove(mousepoint.x+100, mousepoint.y);//移动鼠标
        /*
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();//获取屏幕的尺寸
    BufferedImage image = robot.createScreenCapture(new Rectangle(0, 0, screenSize.width,screenSize.height));//截取整个屏幕的图像 
         */
        return pixel;
    }
	public void jsdraw(int x,int y) {
		
		g2D.drawLine(fdx,fdy,x,y);
		fdx=x;
		fdy=y;
	}
 class   addML extends MouseAdapter {//implements MouseListener{
 
	//@Override
	public void mouseDragged(MouseEvent e) {//鼠标按下后移动触发
		// TODO Auto-generated method stub
		if(pickupcolor) {
			try {
				usecolor=pickColor();
				drawset.colorshow();
				drawset.colortchang();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			labelxy.setText("("+e.getX()+","+e.getY()+")");
		}else if(word){
			labelxy.setText("("+e.getX()+","+e.getY()+")");
		}else if(shapechoice.getSelectedIndex()==0||eraser) {
			int x=e.getX();
			int y=e.getY();
		    g2D.drawLine(start.x,start.y,x,y);
		    if(tool.friend.account!=null) {
		    	byte[] b=new byte[5];
		    	b[0]=1;
		    	b[1]=(byte)(x/100);b[2]=(byte)(x%100);
		    	b[3]=(byte)(y/100);b[4]=(byte)(y%100);
		    	try {
					tool.drawlks.output.write(b);
					tool.drawlks.output.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }
			start.setLocation(x, y);	
			labelxy.setText("("+e.getX()+","+e.getY()+")");
		}else {
			labelxy.setText("("+start.x+","+start.y+")——>("+e.getX()+","+e.getY()+")");
		}
		
	}
	//@Override
	public void mouseMoved(MouseEvent e) {//鼠标不按才能触发
		// TODO Auto-generated method stub
		//repaint();//必须用repaint()，直接用paint报错//？？？使用此方法，其他方法的面板都加到dr面板上了？？？//repaint()还会导致getGraphics()改变，无法用鼠标绘图
		labelxy.setText("("+e.getX()+","+e.getY()+")");
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX();
		int y=e.getY();
		if(pickupcolor) {//取色
			try {
				usecolor=pickColor();
				drawset.colorshow();
				drawset.colortchang();
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(word) {//绘字
			int bold,ltalic;
			if(jcbold.isSelected()) {
				bold=Font.BOLD ;
			}else {
				bold=0;
			}
			if(jcltalic.isSelected()) {
				ltalic= Font.ITALIC;
			}else {
				ltalic=0;
			}
			g2D.setFont(new Font(wordtype.getSelectedItem(),bold+ltalic,(int)fontsize));
			String str=textword.getText();
			g2D.drawString(str, x,y);//x-(int)(str.length()/2.0*fontsize), y+(int)fontsize/2);
		}
//		g2D.drawRect(100, 100, 100, 200);//以线条宽度中线设置坐标
		//g2D.fillRect(100, 100, 100, 200); 
	}
	private ColorModel getColorModel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		 Graphics g=getGraphics();//加此方法到监听器内部环境，可在监听器内执行绘图，
	     g2D=(Graphics2D)g;  //不是G...2D绘图报错！！！！！
	     
	     if(eraser) {
	    	 g2D.setColor(mycolorless);
	    	 basicstroke=new BasicStroke(fontsize,BasicStroke.CAP_ROUND,BasicStroke.JOIN_BEVEL);
	    	 setcursor.setCursor(cursor);
	     }else {
	    	 g2D.setColor(usecolor);
	       if(undottedline) {
				basicstroke=new BasicStroke(fontsize,fontends,fontlink,fontsize*10);
				
		   }else {
			    float tf=(float)Math.sqrt(fontsize);//开方返回double
				basicstroke=new BasicStroke(fontsize,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL,0,new float[]{tf*5,tf*2},0);
		   }
	       setcursor.setCursor(cursortype);
	     }
	     g2D.setStroke(basicstroke);//设置线条粗细，端点类型，相邻线条连接类型
	     g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);//让线条更平滑
	     //g2D.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_DEFAULT);//可能原始值

	}
	@Override
	public void mouseExited(MouseEvent e) {          //鼠标移出
		// TODO Auto-generated method stub
		if(e.getSource()==jwsize) {//1监控不灵敏
			jwsize.setVisible(false);
			unsizeshow=true;
		}else {
		    setcursor.setCursor(Cursor.DEFAULT_CURSOR);
		    labelxy.setText("(—— ——)");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		start.setLocation(e.getX(), e.getY());
		if(tool.friend.account!=null) {
	    	byte[] b=new byte[5];
	    	b[0]=0;//第一次传
	    	b[1]=(byte)(start.x/100);b[2]=(byte)(start.x%100);
	    	b[3]=(byte)(start.y/100);b[4]=(byte)(start.y%100);
	    	try {
				tool.drawlks.output.write(b);
				tool.drawlks.output.flush();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
//		if(!eraser&&!word&&!pickupcolor&&shapechoice.getSelectedIndex()>0&&!shapefill.isSelected()) {//绘图形
//			g2D.drawLine(start.x,start.y,start.x,start.y);
//		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int sc=shapechoice.getSelectedIndex();
		if(!eraser&&!word&&!pickupcolor&&sc>0) {
			int x=e.getX(),y=e.getY();
			int maxx=x, maxy=y,minx=start.x,miny=start.y,w,h;
			if(maxx<minx) {
				int temp=minx;
				minx=maxx;
				maxx=temp;
			}
			if(maxy<miny) {
				int temp=miny;
				miny=maxy;
				maxy=temp;
			}
			w=maxx-minx;
			h=maxy-miny;
			if(e.getButton() == e.BUTTON3) {//右键//e.BUTTON1左键
				if(w<h) {
					h=w;
				}else {
					w=h;
				}
			}
			if(shapefill.isSelected()) {
				sc+=10;
			}
			switch(sc) {
			case 1:
				g2D.drawLine(start.x,start.y,x,y);
				break;
			case 2:
				g2D.drawRect(minx, miny, w, h);
				break;
			case 3:
				g2D.drawRoundRect(minx, miny, w, h, w/3, h/3);
				break;
			case 4:
				g2D.drawOval(minx, miny, w, h);
				break;
			case 11:
				g2D.drawLine(start.x,start.y,x,y);
				break;
			case 12:
				g2D.fillRect(minx, miny, w, h);
				break;
			case 13:
				g2D.fillRoundRect(minx, miny, w, h, w/2, h/2);
				break;
			default:
				g2D.fillOval(minx, miny, w, h);
				
			}
		}
	}
 }
  public class drawingset extends JPanel implements ActionListener{//不是public类即使公共对象外部也不能用
	  JPanel jpword;
	 JButton[] dbutton=new JButton[4];
	 Button dbutton5,dbutton6,dbutton7;
	 ImageIcon[] icon=new ImageIcon[4];
	 ImageIcon[] images;
	 JLabel label1,label2,label3,label4;
	 JTextField textsize;
	 mycolortext textcolorr,textcolorg,textcolorb;
	 JComboBox linetype;
	 JSlider slider;
	 Font font=new Font("楷体", 1, 12);
	 Graphics2D g2;
//	 String[] buttonname={"画笔","橡皮擦","文字","取色器"};//？？加static报错！！
	 private void colorshow() {
		 g2=(Graphics2D)getGraphics();
		 g2.setColor(usecolor);
		 g2.fillRect(pcolorshow.x,pcolorshow.y, 20, 20);//直接放点pcolorshow报错
	 }

	 public void paint(Graphics g){//绘图      //只要此方法执行完，g就丢失!!!!!
		    super.paint(g);  
	    	g2=(Graphics2D) g;
		    g2.setStroke(new BasicStroke(0.1f));
		    g2.setColor(new Color(0,163,243));
	    	g2.drawLine(0, 0, 0, 40);
	    	g2.drawLine(0, 40, 550, 40);
	    	g2.drawLine(105, 0, 105, 40);
	    	g2.drawLine(238, 0, 238, 40);
	    	g2.drawLine(352, 0, 352, 40);
	    	g2.drawLine(550, 0, 550, 40);
	    	g2.setColor(Color.white);
			g2.setFont(new Font("微软雅黑",0,8));
			g2.drawString("线条类型", 175, 8);
			g2.setFont(font);
			g2.drawString("工具设置", 142, 38);
			g2.drawString("图形", 280, 38);
			g2.drawString("颜色", 360, 38);
			g2.drawString("红", 430, 32);
			g2.drawString("绿", 458, 32);
			g2.drawString("蓝", 486, 32);
			g2.fillRect(pcolorshow.x-2, pcolorshow.y-2, 24, 24);//颜色底块
			g2.setColor(usecolor);
			g2.fillRect(pcolorshow.x,pcolorshow.y, 20, 20);
	 }
	 public drawingset() {
////////////////////////////////////////
try    
{ // 使用Windows的界面风格  
UIManager.setLookAndFeel  
("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
}  
catch (Exception e)    
{  
e.printStackTrace();  
} 
//////////////////////////////////////////////////////////////
		 setOpaque(false);
		 setSize(560,40);
		 //添加工具按钮
		 for(int i=0;i<4;i++) {
			 icon[i]=new ImageIcon("image/tp1"+(i+1)+".png");
			 dbutton[i]=new JButton(icon[i]);
			 dbutton[i].setBounds(1+i*26,0,25,25);
			 add(dbutton[i]);
			 dbutton[i].addActionListener(this);
		 }
		 jpword=new JPanel();
		 jpword.setSize(180,20);
		 jpword.setLayout(null);
		 textword=new JTextField(3);
		 wordtype=new Choice();
		 wordtype.add("微软雅黑");
		 wordtype.add("宋体");
		 wordtype.add("楷体");
		 wordtype.add("黑体");//
		 wordtype.add("等线");
		 wordtype.add("Blackadder ITC");
		 jcbold=new JCheckBox("加粗",false);
		 jcltalic=new JCheckBox("倾斜",false);
		 Font tempf=new Font("微软雅黑",1,8);
		 jcbold.setFont(tempf);
		 jcltalic.setFont(tempf);
		 jcbold.setBounds(120, 0, 50, 10);
		 jcltalic.setBounds(120, 10, 50, 10);
		 textword.setBounds(0, 0, 50, 20);
		 
		 jpword.add(textword);
		 jpword.add(wordtype);
		 jpword.add(jcbold);
		 jpword.add(jcltalic);
		 
		 //wordtype.setMaximumRowCount(2);
		 setLayout(null);
		 //添加工具设置
		 dbutton5=new Button("粗细");    
		 dbutton5.setBounds(110,0,30,25);
		 add(dbutton5);
		 slider=new JSlider(0,100,1);
		 jwsize=new JFrame();
		 jwsize.setUndecorated(true);  
		 //jwsize.setBackground(Color.white);
		 jwsize.setVisible(false);
		 jwsize.add(slider);
		 jwsize.addMouseListener(aml);//drawing.this
		 slider.addChangeListener(new ChangeListener() {//监听刻度条
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				fontsize=slider.getValue();
				textsize.setText(""+(int)fontsize);
			}
		});
		 dbutton5.addActionListener(this);
		 textsize=new JTextField(2);
		 textsize.setText(""+fontsize);
		 textsize.setBounds(140,0,24,25);
	/*
  /////////////////////////////////////////////////////////////////////////////////////////////////////////
//		 textsize.setDocument(new PlainDocument() {???重写此方法会导致setText(String)<==>setText("")!!!!!
//			 public void insertString(int offset, String s, AttributeSet attrSet) throws BadLocationException {
//				//s输入的每个字符
//		        //offset输入的字符位置（记光标前一字符位置(从0开始)）
//				 //删除文本无反应
//				 //fontsize=Integer.parseInt(textsize.getText());
//				 String str=textsize.getText();
//				 char c=s.charAt(0);
//				 System.out.println(str);
//				 float f=-1.1f;//检测之前是否有小数点并防止.0现象
//				 if(!str.equals("")) {
//					 f=Float.parseFloat(str+1);
//				 }
//				 if((c<='9'&&c>='0'||f%1==0&&c=='.')&&Float.parseFloat(str+s)<100) {//顺序不能倒，不然可能报错
//					 super.insertString(offset, s, attrSet); //不调用父类原方法，无回显值
//					 fontsize=Float.parseFloat(textsize.getText());//Float.parseFloat("0.")不报错，Int...("0.")不可以
//				 }else {
//					 Toolkit.getDefaultToolkit().beep(); //系统提示音
//				 }
//			 }
//		 });
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
*/
//		 textsize.addFocusListener(new FocusListener() {//进入和离开监听器
		 textsize.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {//文本删除
				// TODO Auto-generated method stub
				String str=textsize.getText();
				if(!str.equals("")) {
					try {
						fontsize=Float.parseFloat(str);
						if(fontsize>100) {
							oldsize=""+str.charAt(0)+str.charAt(1);
							fontsize=Float.parseFloat(oldsize);
							new setText(textsize,oldsize).start();
							Toolkit.getDefaultToolkit().beep(); //系统提示音
						}else {
							oldsize=str;
						}
						
					}catch(Exception e) {//只剩.//.1==0.1
						oldsize=str;
						fontsize=0;
						Toolkit.getDefaultToolkit().beep(); //系统提示音
					}
				}else {
					oldsize=str;
					fontsize=0;
				}
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent arg0) {//文本增加或setText()
				// TODO Auto-generated method stub
				String str=textsize.getText();
				try {
					fontsize=Float.parseFloat(str);
					if(fontsize>100) {//防止大于100
						oldsize=""+str.charAt(0)+str.charAt(1);
						fontsize=Float.parseFloat(oldsize);
						new setText(textsize,oldsize).start();
						Toolkit.getDefaultToolkit().beep(); //系统提示音
					}else if(fontsize<0){//防止负数
						fontsize=-fontsize;
						new setText(textsize,oldsize).start();
						Toolkit.getDefaultToolkit().beep(); //系统提示音
					}else {
						oldsize=str;
					}
				}catch(Exception e) {
					new setText(textsize,oldsize).start();//???不开新线程直接用textsize.setText(oldsize);报错!!!
					Toolkit.getDefaultToolkit().beep(); //系统提示音
				}
			}
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("<<<3");
			}
		}); 
		 
		 add(textsize);
		 
		 String[] picStrings = { "21", "22", "23", "24",};//线条类型
		 images = new ImageIcon[picStrings.length];
		 for (int i = 0; i < picStrings.length; i++) {
		     images[i] = new ImageIcon("image/tp" + picStrings[i] + ".png");
		 }
		 linetype =new JComboBox(images);//只能放ImageIcon数组，不能放ImageIcon
		 //linetype.setFont(new Font("微软雅黑",0,9));//文字大小决定Choice的大小setBounds无
		 linetype.setMaximumRowCount(2);
		 linetype.setBounds(165,9,70,16);
		 add(linetype);
		 
		 label1=new JLabel("工具：画笔",JLabel.CENTER);
		 label1.setForeground(Color.white);
		 label1.setFont(font);
		 label1.setBounds(0,25,103,20);
		 add(label1);
		 linetype.addActionListener(this);
		 
		 //形状
//		 String[] shape= {"无","直线","矩形","圆角矩形","椭圆"};
//		 shapechoice=new JComboBox(shape);//？？？？？？用JComboBox点击时会使画图面板上大量区域变空白！！！！！！
		 shapechoice=new Choice();
		 shapechoice.addItem("无");
		 shapechoice.addItem("直线");
		 shapechoice.addItem("矩形");
		 shapechoice.addItem("圆角矩形");
		 shapechoice.addItem("椭圆");
		 //shapechoice.setMaximumRowCount(2);
		 shapechoice.setBackground(mycolorless);
//		 shapechoice.setFont(new Font("",1,9));
		 shapechoice.setBounds(240,0,65,25);
		 add(shapechoice);
		 shapefill=new JCheckBox("填充",blfill);
		 shapefill.setBounds(305,0,50,25);
		 shapefill.setForeground(Color.white);
		 shapefill.setFocusPainted(false); 
		 shapefill.setOpaque(false);
		 add(shapefill);
		 
		 //颜色
		 dbutton6=new Button("←");
		 dbutton6.setFont(new Font("",0,45));
		 dbutton6.setBounds(385,0,35,25);
		 add(dbutton6);
		 dbutton6.addActionListener(this);
		 dbutton7=new Button("调色板");
		 dbutton7.setBounds(504,0,39,25);
		 add(dbutton7);
		 dbutton7.addActionListener(this);
		 
		 textcolorr=new mycolortext(3,""+red);//三色文本框
		 textcolorg=new mycolortext(3,""+green);
		 textcolorb=new mycolortext(3,""+blue);
		 textcolorr.setBounds(420,0,28,18);
		 textcolorg.setBounds(448,0,28,18);
		 textcolorb.setBounds(476,0,28,18);
		 add(textcolorr);
		 add(textcolorg);
		 add(textcolorb);
	 }
	 private class mycolortext extends JTextField{
		 public int value;
		 public String old;
		 public mycolortext(int l,String old2) {
			 super(l);
			 this.old=old2;
			 setText(old2);
			 getDocument().addDocumentListener(new DocumentListener() {
				
				@Override
				public void removeUpdate(DocumentEvent arg0) {
					// TODO Auto-generated method stub
					String str=mycolortext.this.getText();
					if(!str.equals("")) {
							value=Integer.parseInt(str);
							
					}else {
						old=str;
						value=0;
					}
				}
				
				@Override
				public void insertUpdate(DocumentEvent arg0) {
					// TODO Auto-generated method stub
					String str=mycolortext.this.getText();
					try {
						value=Integer.parseInt(str);
						if(value>255) {
							old=""+str.charAt(0)+str.charAt(1);
							fontsize=Float.parseFloat(oldsize);
							new setText(mycolortext.this,old).start();
							Toolkit.getDefaultToolkit().beep(); //系统提示音
						}else if(value<0){//防止负数
							fontsize=-fontsize;
							new setText(mycolortext.this,old).start();
							Toolkit.getDefaultToolkit().beep(); //系统提示音
						}else {
							old=str;
						}
					  }catch(Exception e) {
							new setText(mycolortext.this,old).start();//???不开新线程直接用textsize.setText(oldsize);报错!!!
							Toolkit.getDefaultToolkit().beep(); //系统提示音
					
					}
				}
				
				@Override
				public void changedUpdate(DocumentEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
		 }
	 }
	 
	 private class setText extends Thread{//设置某文本框为指定内容
		 JTextField jtf;
		 String str;
		 public setText(JTextField j,String s) {
			 jtf=j;
			 str=s;
		 }
		 public void run() {           
			 jtf.setText(str);
		 }
		 
	 }
	 @Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		    if (e.getSource() == linetype) {
		    	int index =linetype.getSelectedIndex();
				System.out.println(index);
				switch (index) {
				case 0:
					fontends=BasicStroke.CAP_ROUND;
					fontlink=BasicStroke.JOIN_ROUND;
					undottedline=true;
					break;
				case 1:
					fontends=BasicStroke.CAP_SQUARE;
					fontlink=BasicStroke.JOIN_MITER;
					undottedline=true;
					break;
				case 2:
					fontends=BasicStroke.CAP_BUTT;
					fontlink=BasicStroke.JOIN_BEVEL;
					undottedline=true;
					break;
				default:
					undottedline=false;	
				}
				
		    }else if(e.getSource() == dbutton[0]){
		    	label1.setText("工具：画笔");
		    	eraser=false;
		    	pickupcolor=false;
		    	word=false;
		    	cursortype=Cursor.HAND_CURSOR;
		    }else if(e.getSource() == dbutton[1]) {
		    	label1.setText("工具：橡皮擦");
		    	pickupcolor=false;
		    	eraser=true;
		    	word=false;
		    }else if(e.getSource() == dbutton[2]) {
		    	label1.setText("工具：文字");
		    	pickupcolor=false;
		    	eraser=false;
		    	word=true;
		    	if(unwordshow) {
		    		jwsize.remove(slider);
		    		wordtype.setBounds(50, 0, 100, 20);//？？？Choice长度总比输入的短！！！//放在外部，每重新打开一次就变短一次！！！
			    	jwsize.add(jpword);
			    	jwsize.setBounds(jwx, jwy, 180, 20);
			    	jwsize.setVisible(true);
			    	unwordshow=false;
			    	unsizeshow=true;
		    	}else {
		    		jwsize.setVisible(false);
		    		unwordshow=true;
		    	}
		    	cursortype=Cursor.CROSSHAIR_CURSOR;
		    }else if(e.getSource() == dbutton[3]) {
		    	label1.setText("工具：取色器");
		    	pickupcolor=true;
		    	eraser=false;
		    	word=false;
		    	cursortype=Cursor.DEFAULT_CURSOR;
		    }else if(e.getSource()==dbutton5) {//线条粗细
		    	if(unsizeshow) {
		    		jwsize.remove(jpword);
			    	jwsize.add(slider);
		    		slider.setValue((int)fontsize);//设置默认值
		    		jwsize.setBounds(jwx+40, jwy, 80, 20);
		    		jwsize.setVisible(true);
		    		unsizeshow=false;
		    		unwordshow=true;
		    	}else {
		    		jwsize.setVisible(false);
		    		unsizeshow=true;
		    	}
		    	
		    	
		    }else if(e.getSource()==dbutton6) {
		    	usecolor=new Color(textcolorr.value,textcolorg.value,textcolorb.value);
		    	colorshow();
		    }else if(e.getSource()==dbutton7) {//调色板
		    	usecolor=JColorChooser.showDialog(drawing.this, "调色",usecolor);
		    	colortchang();
		        colorshow();
		    }
			
		}
	 public void colortchang() {
		 int r=usecolor.getRed(),g=usecolor.getGreen(),b=usecolor.getBlue();
	    	textcolorr.setText(""+r);
	    	textcolorb.setText(""+g);
	    	textcolorg.setText(""+b);
	    	textcolorr.value=r;
	    	textcolorg.value=g;
	    	textcolorb.value=b;
	 }
	 public void setup() {//JPanel不传地址
		 
		 
	 }
	
 }
}
