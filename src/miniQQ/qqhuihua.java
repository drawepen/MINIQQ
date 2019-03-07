package miniQQ;

import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JWindow;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class qqhuihua extends JFrame implements MouseListener,ItemListener,ActionListener,MouseMotionListener,KeyListener{
	
	JPanel p1,p2;
	JButton colorboard;
	JButton hbcuxi;
	JButton pen;
	JButton ca;
	JButton line;
	JButton jvxing;
	JButton yuanjvxing;
	JButton tuoyuan;
	JTextField cuxikuang;
	JSlider js;
	JButton qingchu;
	JButton chexiao;
	JButton huifu;
	JButton sanjiaoxing;
	JButton lingxing;
	JButton wujiaoxing;
	JButton huakuang;
	JButton sijiaoxing;
	JButton shandian;
	JButton shu;
	JButton shang;
	JButton xia;
	JButton zuo;
	JButton you;
	
	Color color = Color.black;
	
	int tools = 0;
	//static boolean bool = false;
	
	// 画笔初始化
	Graphics g;
    Graphics2D g2;
    // 坐标的起点和终点的初始化
    int x1, y1, x2, y2;
    //Choice colorchoice;
    //Choice sizechoice;
    
	public qqhuihua() {
		
		this.setTitle("MINI QQ 画图室");
		this.setIconImage((new ImageIcon("image\\qqqie4.png")).getImage());   //设置头标题
		this.setBounds(500,270,916,650);
		
		
		p2 = new JPanel();
		p2.setBounds(0, 90, 916, 570);
		this.add(p2);
		p2.setLayout(null);
		
		p1 = new JPanel();
		p1.setBounds(0, 0, 916, 90);
		p1.setBackground(Color.orange);
		this.add(p1);
		p1.setLayout(null);
		
		
		colorboard = new JButton(new ImageIcon("image/bjyanse.PNG"));
		colorboard.setBounds(0,0,60,90);
		colorboard.setFocusPainted(false);                                        
		colorboard.addActionListener(this);
		p1.add(colorboard);
		
		hbcuxi = new JButton(new ImageIcon("image/cuxi.PNG"));
		hbcuxi.setBounds(60,0,60,60);
		hbcuxi.setFocusPainted(false);                                        
		hbcuxi.addActionListener(this);
		p1.add(hbcuxi);
		
		cuxikuang = new JTextField();
		cuxikuang.setText("1");
		cuxikuang.setBounds(60,60,60,30);
		p1.add(cuxikuang);
		
		pen = new JButton(new ImageIcon("image/huabi.jpg"));
		pen.setBounds(120,0,60,45);
		pen.setFocusPainted(false);                                        
		pen.addActionListener(this);
		p1.add(pen);

		ca = new JButton(new ImageIcon("image/xiangpi.jpg"));
		ca.setBounds(180,0,60,45);
		ca.setFocusPainted(false);                                        
		ca.addActionListener(this);
		p1.add(ca);
		
		line = new JButton(new ImageIcon("image/zhixian.jpg"));
		line.setBounds(240, 0, 60, 45);
		line.setFocusPainted(false);                                        
		line.addActionListener(this);
		p1.add(line);
		
		jvxing = new JButton(new ImageIcon("image/jvxing.jpg"));
		jvxing.setBounds(300, 0, 60, 45);
		jvxing.setFocusPainted(false);                                        
		jvxing.addActionListener(this);
		p1.add(jvxing);
		
		yuanjvxing = new JButton(new ImageIcon("image/yuanjvxing.jpg")); 
		yuanjvxing.setBounds(360, 0, 60, 45);
		yuanjvxing.setFocusPainted(false);                                        
		yuanjvxing.addActionListener(this);
		p1.add(yuanjvxing);
		
		tuoyuan = new JButton(new ImageIcon("image/tuoyuan.jpg"));
		tuoyuan.setBounds(420, 0, 60, 45);
		tuoyuan.setFocusPainted(false);                                        
		tuoyuan.addActionListener(this);
		p1.add(tuoyuan);
		
		qingchu = new JButton("清      除");
		qingchu.setBackground(Color.gray);
		qingchu.setForeground(Color.white);
		qingchu.setBounds(360,45,120,45);
		qingchu.setFocusPainted(false);                                        
		qingchu.addActionListener(this);
		p1.add(qingchu);
		
		chexiao = new JButton(new ImageIcon("image/chexiao.jpg"));
		chexiao.setBounds(480, 45, 60, 45);
		chexiao.setFocusPainted(false);                                        
		chexiao.addActionListener(this);
		p1.add(chexiao);
		
		huifu = new JButton(new ImageIcon("image/huifu.jpg"));
		huifu.setBounds(540, 45, 60, 45);
		huifu.setFocusPainted(false);                                        
		huifu.addActionListener(this);
		p1.add(huifu);
		
		sanjiaoxing = new JButton(new ImageIcon("image/sanjiaoxing.jpg"));
		sanjiaoxing.setBounds(480, 0, 60, 45);
		sanjiaoxing.setFocusPainted(false);                                        
		sanjiaoxing.addActionListener(this);
		p1.add(sanjiaoxing);
		
		lingxing = new JButton(new ImageIcon("image/lingxing3.jpg"));
		lingxing.setBounds(540, 0, 60, 45);
		lingxing.setFocusPainted(false);                                        
		lingxing.addActionListener(this);
		p1.add(lingxing);
		
		wujiaoxing = new JButton(new ImageIcon("image/wujiaoxing.png"));
		wujiaoxing.setBounds(600, 0, 60, 45);
		wujiaoxing.setFocusPainted(false);                                        
		wujiaoxing.addActionListener(this);
		p1.add(wujiaoxing);
		
		huakuang = new JButton(new ImageIcon("image/huakuang.jpg"));
		huakuang.setBounds(660, 0, 60, 45);
		huakuang.setFocusPainted(false);                                        
		huakuang.addActionListener(this);
		p1.add(huakuang);
		
		sijiaoxing = new JButton(new ImageIcon("image/sijiaoxing.jpg"));
		sijiaoxing.setBounds(720, 0, 60, 45);
		sijiaoxing.setFocusPainted(false);                                        
		sijiaoxing.addActionListener(this);
		p1.add(sijiaoxing);
		
		shandian = new JButton(new ImageIcon("image/shandian.jpg"));
		shandian.setBounds(780, 0, 60, 45);
		shandian.setFocusPainted(false);                                        
		shandian.addActionListener(this);
		p1.add(shandian);
		
		shu = new JButton(new ImageIcon("image/shu.jpg"));
		shu.setBounds(840, 0, 60, 90);
		shu.setFocusPainted(false);                                        
		shu.addActionListener(this);
		p1.add(shu);
		
		shang = new JButton(new ImageIcon("image/shang.jpg"));
		shang.setBounds(600, 45, 60, 45);
		shang.setFocusPainted(false);                                        
		shang.addActionListener(this);
		p1.add(shang);
		
		xia = new JButton(new ImageIcon("image/xia.jpg"));
		xia.setBounds(660, 45, 60, 45);
		xia.setFocusPainted(false);                                        
		xia.addActionListener(this);
		p1.add(xia);
		
		zuo = new JButton(new ImageIcon("image/zuo.jpg"));
		zuo.setBounds(720, 45, 60, 45);
		zuo.setFocusPainted(false);                                        
		zuo.addActionListener(this);
		p1.add(zuo);
		
		you = new JButton(new ImageIcon("image/you.jpg"));
		you.setBounds(780, 45, 60, 45);
		you.setFocusPainted(false);                                        
		you.addActionListener(this);
		p1.add(you);
		
		
		js = new JSlider(0,50,1);                         //滑动条
//		try {
//				float a = Float.parseFloat((cuxikuang.getText()));
//				
//				if(a>50) {
//					js.setValue(50);
//				}
//				else if(a<0) {
//					js.setValue(0);
//				}
//				else {
//					js.setValue((int) a);
//				}
//			}
//			catch(Exception e1){
//				cuxikuang.setText("6");
//				g2.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			}finally {
//				
//			}
		//js.setMajorTickSpacing(5);
		//js.setMinorTickSpacing(1);
		//js.setPaintTicks(true);
		//js.setSnapToTicks(true);
		//js.setPaintLabels(true);
		js.setBounds(120, 45, 240, 45);
		//js.setVisible(false);
		js.setBackground(Color.green);
		p1.add(js);
		js.addChangeListener(new ChangeListener() {      //监听刻度条
			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				int b = js.getValue();
				cuxikuang.setText(""+(int)b);
			}
		});

		
		
		
		
		setVisible(true);
        // 画笔获取要在可见之后,设置成全局属性
        g = p2.getGraphics();
        g2 = (Graphics2D)g;
        p1.addMouseMotionListener(this);
        p1.addMouseListener(this);
        p2.addMouseMotionListener(this);
        p2.addMouseListener(this);
        this.addKeyListener(this);

        
//    	Color.black, Color.white, Color.blue, Color.red,
// 	   Color.yellow, Color.orange, Color.cyan, Color.pink,
// 	   Color.green	
//        colorchoice = new Choice();   
//        colorchoice.add("black");
//        colorchoice.add("white");
//        colorchoice.add("blue");
//        colorchoice.add("red");
//        colorchoice.add("yellow");
//        colorchoice.add("orange");
//        colorchoice.add("cyan");
//        colorchoice.add("pink");
//        colorchoice.add("green");
//        colorchoice.setBounds(620, 20, 70, 30);
//        p1.add(colorchoice);
//        colorchoice.addItemListener(this);
		
//		sizechoice = new Choice();
//		sizechoice.add("1");
//		sizechoice.add("2");
//		sizechoice.add("4");
//		sizechoice.add("6");
//		sizechoice.add("8");
//		sizechoice.add("10");
//		sizechoice.setBounds(710, 20, 50, 30);
//        p1.add(sizechoice);
//        sizechoice.addItemListener(this);
        
	}
	public void mouseDragged(MouseEvent e) {
		if(tools==0) {
		x2=e.getX();
		y2=e.getY();
		g.drawLine(x1,y1,x2,y2);
	    x1=x2;
	    y1=y2;
		}
		
		if(tools==5) {
			x2=e.getX();
			y2=e.getY();
			g.drawLine(x1,y1,x2,y2);
		    x1=x2;
		    y1=y2;
        }
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
        y1 = e.getY();
        
        try {
			float a = Float.parseFloat((cuxikuang.getText()));
			
			if(a>50) {
				cuxikuang.setText("50");
				g2.setStroke(new BasicStroke(50,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
			}
			else if(a<0) {
				cuxikuang.setText("0");
				g2.setStroke(new BasicStroke(0,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
			}
			else {
				g2.setStroke(new BasicStroke(a,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
			}
		}
		catch(Exception e1){
			cuxikuang.setText("6");
			g2.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
		}finally {
			
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(tools==1) {
			x2 = e.getX();
	        y2 = e.getY(); 
	        g.drawLine(x1, y1, x2, y2);
        }
        
		if(tools==2) {
			x2 = e.getX();
	        y2 = e.getY();
	        if(e.getButton()==e.BUTTON3) 
	        	g.drawRect(x1, y1, Math.abs(x2-x1), Math.abs(x2-x1));
	        else
	        	g.drawRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
		}
		
		if(tools==3) {
			x2 = e.getX();
	        y2 = e.getY();
	        if(e.getButton()==e.BUTTON3)
	        	g.drawRoundRect(x1, y1, Math.abs(x2-x1), Math.abs(x2-x1),16,16);
	        else
	        	g.drawRoundRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1),16,16);
		}
		
		if(tools==4) {
			x2 = e.getX();
	        y2 = e.getY();
//	        if(bool == 1) {
//	        	Ellipse2D ellipse=new Ellipse2D.Double(x1, y1, Math.abs(x2-x1), Math.abs(x2-x1));
//		        g2.draw(ellipse);
//	        }
	        if(e.getButton()==e.BUTTON3) {
	        	Ellipse2D ellipse=new Ellipse2D.Double(x1, y1, Math.abs(x2-x1), Math.abs(x2-x1));
		        g2.draw(ellipse);
			}
	        else {
		        Ellipse2D ellipse=new Ellipse2D.Double(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
		        g2.draw(ellipse);
	        }
		}
		
		if(tools==6) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine((x1+x2)/2, y1, x1, y2);
        	g.drawLine(x1, y2, x2, y2);
        	g.drawLine(x2, y2, (x1+x2)/2, y1);
	    }
		
		if(tools==7) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine((x1+x2)/2, y1, x1, (y1+y2)/2);
        	g.drawLine(x1, (y1+y2)/2, (x1+x2)/2, y2);
        	g.drawLine((x1+x2)/2, y2, x2, (y1+y2)/2);
        	g.drawLine(x2, (y1+y2)/2, (x1+x2)/2, y1);
	    }
		
		if(tools==8) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine((x1+x2)/2, y1, x1+6*(x2-x1)/16, y1+3*(y2-y1)/8);
        	g.drawLine(x1+6*(x2-x1)/16, y1+3*(y2-y1)/8, x1, y1+3*(y2-y1)/8);
        	g.drawLine(x1, y1+3*(y2-y1)/8, x1+4*(x2-x1)/16, y1+5*(y2-y1)/8);
        	g.drawLine(x1+4*(x2-x1)/16, y1+5*(y2-y1)/8, x1+3*(x2-x1)/16, y2);
        	g.drawLine(x1+3*(x2-x1)/16, y2, (x1+x2)/2, y1+6*(y2-y1)/8);
        	g.drawLine((x1+x2)/2, y1+6*(y2-y1)/8, x1+13*(x2-x1)/16, y2);
        	g.drawLine(x1+13*(x2-x1)/16, y2, x1+12*(x2-x1)/16, y1+5*(y2-y1)/8);
        	g.drawLine(x1+12*(x2-x1)/16, y1+5*(y2-y1)/8, x2, y1+3*(y2-y1)/8);
        	g.drawLine(x2, y1+3*(y2-y1)/8, x1+10*(x2-x1)/16, y1+3*(y2-y1)/8);
        	g.drawLine(x1+10*(x2-x1)/16, y1+3*(y2-y1)/8, (x1+x2)/2, y1);
	    }
		
		if(tools==9) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine(x1, y1, x1, 4*(y2-y1)/5+y1);
        	g.drawLine(x1, 4*(y2-y1)/5+y1, (x2-x1)/5+x1, 4*(y2-y1)/5+y1);
        	g.drawLine((x2-x1)/5+x1, 4*(y2-y1)/5+y1, x1,y2);
        	g.drawLine(x1, y2, 2*(x2-x1)/5+x1, 4*(y2-y1)/5+y1);
        	g.drawLine(2*(x2-x1)/5+x1, 4*(y2-y1)/5+y1, x2, 4*(y2-y1)/5+y1);
        	g.drawLine(x2, 4*(y2-y1)/5+y1, x2, y1);
        	g.drawLine(x2, y1, x1, y1);
	    }
		
		if(tools==10) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine((x1+x2)/2, y1, x1+18*(x2-x1)/46, y1+5*(y2-y1)/14);
        	g.drawLine(x1+18*(x2-x1)/46, y1+5*(y2-y1)/14, x1, (y1+y2)/2);
        	g.drawLine(x1, (y1+y2)/2, x1+18*(x2-x1)/46, y1+9*(y2-y1)/14);
        	g.drawLine(x1+18*(x2-x1)/46, y1+9*(y2-y1)/14, (x1+x2)/2, y2);
        	g.drawLine((x1+x2)/2, y2, x1+28*(x2-x1)/46, y1+9*(y2-y1)/14);
        	g.drawLine(x1+28*(x2-x1)/46, y1+9*(y2-y1)/14, x2, (y1+y2)/2);
        	g.drawLine(x2, (y1+y2)/2, x1+28*(x2-x1)/46, y1+5*(y2-y1)/14);
        	g.drawLine(x1+28*(x2-x1)/46, y1+5*(y2-y1)/14, (x1+x2)/2, y1);
		}
		
		if(tools==11) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine(x2, y1, x1+(x2-x1)/7, y1+2*(y2-y1)/5);
        	g.drawLine(x1+(x2-x1)/7, y1+2*(y2-y1)/5, 3*(x2-x1)/7+x1, 3*(y2-y1)/5+y1);
        	g.drawLine(3*(x2-x1)/7+x1, 3*(y2-y1)/5+y1, x1,y2);
        	g.drawLine(x1, y2, 6*(x2-x1)/7+x1, 3*(y2-y1)/5+y1);
        	g.drawLine(6*(x2-x1)/7+x1, 3*(y2-y1)/5+y1, x1+4*(x2-x1)/7, 2*(y2-y1)/5+y1);
        	g.drawLine(x1+4*(x2-x1)/7, 2*(y2-y1)/5+y1, x2, y1);
		}
		
		if(tools==12) {
			x2 = e.getX();
	        y2 = e.getY();
	        g.drawLine(x1+(x2-x1)/4, y2, x1+(x2-x1)/4, (y1+y2)/2);
        	g.drawLine(x1+(x2-x1)/4, (y1+y2)/2, x1, (y1+y2)/2);
        	g.drawLine(x1, (y1+y2)/2, (x1+x2)/2,y1);
        	g.drawLine((x1+x2)/2,y1, x2, (y1+y2)/2);
        	g.drawLine(x2, (y1+y2)/2, x1+3*(x2-x1)/4, (y1+y2)/2);
        	g.drawLine(x1+3*(x2-x1)/4, (y1+y2)/2, x1+3*(x2-x1)/4, y2);
        	g.drawLine(x1+3*(x2-x1)/4, y2, x1+(x2-x1)/4, y2);
		}
		
		if(tools==13) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine(x1+(x2-x1)/4, y1, x1+(x2-x1)/4, (y1+y2)/2);
        	g.drawLine(x1+(x2-x1)/4, (y1+y2)/2, x1, (y1+y2)/2);
        	g.drawLine(x1, (y1+y2)/2, (x1+x2)/2,y2);
        	g.drawLine((x1+x2)/2,y2, x2, (y1+y2)/2);
        	g.drawLine(x2, (y1+y2)/2, x1+3*(x2-x1)/4, (y1+y2)/2);
        	g.drawLine(x1+3*(x2-x1)/4, (y1+y2)/2, x1+3*(x2-x1)/4, y1);
        	g.drawLine(x1+3*(x2-x1)/4, y1, x1+(x2-x1)/4, y1);
		}
		
		if(tools==14) {
			x2 = e.getX();
	        y2 = e.getY();
	        g.drawLine(x2, y1+(y2-y1)/4, x2, 3*(y2-y1)/4+y1);
        	g.drawLine(x2, 3*(y2-y1)/4+y1, (x1+x2)/2, 3*(y2-y1)/4+y1);
        	g.drawLine((x1+x2)/2, 3*(y2-y1)/4+y1, (x1+x2)/2,y2);
        	g.drawLine((x1+x2)/2,y2, x1, (y1+y2)/2);
        	g.drawLine(x1, (y1+y2)/2, (x1+x2)/2,y1);
        	g.drawLine((x1+x2)/2,y1, (x1+x2)/2, (y2-y1)/4+y1);
        	g.drawLine((x1+x2)/2, (y2-y1)/4+y1, x2, y1+(y2-y1)/4);
		}
		
		if(tools==15) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine(x1, y1+(y2-y1)/4, x1, 3*(y2-y1)/4+y1);
        	g.drawLine(x1, 3*(y2-y1)/4+y1, (x1+x2)/2, 3*(y2-y1)/4+y1);
        	g.drawLine((x1+x2)/2, 3*(y2-y1)/4+y1, (x1+x2)/2,y2);
        	g.drawLine((x1+x2)/2,y2, x2, (y1+y2)/2);
        	g.drawLine(x2, (y1+y2)/2, (x1+x2)/2,y1);
        	g.drawLine((x1+x2)/2,y1, (x1+x2)/2, (y2-y1)/4+y1);
        	g.drawLine((x1+x2)/2, (y2-y1)/4+y1, x1, y1+(y2-y1)/4);
		}
		
		if(tools==16) {
			x2 = e.getX();
	        y2 = e.getY();
        	g.drawLine((x1+x2)/2, y1, x1+4*(x2-x1)/18, (y2-y1)/4+y1);
        	g.drawLine(x1+4*(x2-x1)/18, (y2-y1)/4+y1, x1+7*(x2-x1)/18, (y2-y1)/4+y1);
        	g.drawLine(x1+7*(x2-x1)/18, (y2-y1)/4+y1, x1+2*(x2-x1)/18, 2*(y2-y1)/4+y1);
        	g.drawLine(x1+2*(x2-x1)/18, 2*(y2-y1)/4+y1, x1+7*(x2-x1)/18, 2*(y2-y1)/4+y1);
        	g.drawLine(x1+7*(x2-x1)/18, 2*(y2-y1)/4+y1, x1, 3*(y2-y1)/4+y1);
        	g.drawLine(x1, 3*(y2-y1)/4+y1, x1+8*(x2-x1)/18, 3*(y2-y1)/4+y1);
        	g.drawLine(x1+8*(x2-x1)/18, 3*(y2-y1)/4+y1, x1+6*(x2-x1)/18, y2);
        	g.drawLine(x1+6*(x2-x1)/18, y2, x1+12*(x2-x1)/18, y2);
        	g.drawLine((x1+x2)/2, y1, x1+14*(x2-x1)/18, (y2-y1)/4+y1);
        	g.drawLine(x1+14*(x2-x1)/18, (y2-y1)/4+y1, x1+11*(x2-x1)/18, (y2-y1)/4+y1);
        	g.drawLine(x1+11*(x2-x1)/18, (y2-y1)/4+y1, x1+16*(x2-x1)/18, 2*(y2-y1)/4+y1);
        	g.drawLine(x1+16*(x2-x1)/18, 2*(y2-y1)/4+y1, x1+11*(x2-x1)/18, 2*(y2-y1)/4+y1);
        	g.drawLine(x1+11*(x2-x1)/18, 2*(y2-y1)/4+y1, x2, 3*(y2-y1)/4+y1);
        	g.drawLine(x2, 3*(y2-y1)/4+y1, x1+10*(x2-x1)/18, 3*(y2-y1)/4+y1);
        	g.drawLine(x1+10*(x2-x1)/18, 3*(y2-y1)/4+y1, x1+12*(x2-x1)/18, y2);
        	
		}
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
//		int index = colorchoice.getSelectedIndex();
//	    this.i=index;
//	    g.setColor(colors[this.i]);
	      
		if(e.getSource()==pen) {
			tools = 0;
		}
		
		if(e.getSource()==line) {
			tools = 1;
		}
		
		if(e.getSource()==jvxing) {
			tools = 2;
		}
		
		if(e.getSource()==yuanjvxing) {
			tools = 3;
		}
		
		if(e.getSource()==tuoyuan) {
			tools = 4;
		}
		
		if(e.getSource()==ca) {
			tools = 5;
			g.setColor(p2.getBackground());
		}
		
		if(e.getSource()!=ca) {
			g.setColor(color);
		}
		
		if(e.getSource()==sanjiaoxing) {
			tools = 6;
		}
		
		if(e.getSource()==lingxing) {
			tools = 7;
		}
		
		if(e.getSource()==wujiaoxing) {
			tools = 8;
		}
		
		if(e.getSource()==huakuang) {
			tools = 9;
		}
		
		if(e.getSource()==sijiaoxing) {
			tools = 10;
		}
		
		if(e.getSource()==shandian) {
			tools = 11;
		}
		
		if(e.getSource()==shang) {
			tools = 12;
		}
		
		if(e.getSource()==xia) {
			tools = 13;
		}
		
		if(e.getSource()==zuo) {
			tools = 14;
		}
		
		if(e.getSource()==you) {
			tools = 15;
		}
		
		if(e.getSource()==shu) {
			tools = 16;
		}
		
		if(e.getSource()==colorboard){
		    color=JColorChooser.showDialog(p2,"",Color.lightGray);
		    g.setColor(color);
	    }
		
		if(e.getSource()==qingchu){
		    repaint();
	    }
		
		if(e.getSource()==chexiao) {
			tools = 101;
		}
		
		if(e.getSource()==huifu) {
			tools = 102;
		}
		
//		if(e.getSource()==hbcuxi) {
//			if(bool == false) {
//				bool = true;
//				js.setVisible(true);
//			}
//			else if(bool == true) {
//				bool = false;
//				js.setVisible(false);
//			}
//		}
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
//		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
//			bool = 1;
//			System.out.println("你好");
//		}
		
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
//		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
//			bool = 0;
//		}
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void itemStateChanged(ItemEvent e) {
//		  if(e.getSource()==colorchoice){
//		   String selected=colorchoice.getSelectedItem();
//		   if(selected=="black"){
//			   g.setColor(Color.black);
//		   }
//		   else if(selected=="white"){
//			   g.setColor(Color.white);
//		   }
//		   else if(selected=="blue"){
//			   g.setColor(Color.blue);
//		   }
//		   else if(selected=="red"){
//			   g.setColor(Color.red);
//		   }
//		   else if(selected=="yellow"){
//			   g.setColor(Color.yellow);
//		   }
//		   else if(selected=="orange"){
//			   g.setColor(Color.orange);
//		   }
//		   else if(selected=="cyan"){
//			   g.setColor(Color.cyan);
//		   }
//		   else if(selected=="pink"){
//			   g.setColor(Color.pink);
//		   }
//		   else if(selected=="green"){
//			   g.setColor(Color.green);
//		   }
//		  }
//		  
//		  else if(e.getSource()==sizechoice){
//			   String selected=sizechoice.getSelectedItem();
//			   if (selected=="1"){
//				   g2.setStroke(new BasicStroke(1,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			   else if(selected=="2"){
//				   g2.setStroke(new BasicStroke(2,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			   else if(selected=="4"){
//				   g2.setStroke(new BasicStroke(4,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			   else if(selected=="6"){
//				   g2.setStroke(new BasicStroke(6,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			   else if(selected=="8"){
//				   g2.setStroke(new BasicStroke(8,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			   else if(selected=="10"){
//				   g2.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER,10));
//			   }
//			  }
		  
	}
	
	
	
	public static void main(String[] args) {
		qqhuihua huayihua = new qqhuihua();
		huayihua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		huayihua.setVisible(true);

	}

}



//class MyPanel extends JPanel{
//	
//	public void paint(Graphics g) {
//		super.paint(g);
//		Graphics2D g2 = (Graphics2D)g;
//		
//	}
//	
//	
//}


