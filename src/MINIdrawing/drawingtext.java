package MINIdrawing;

//public class drawingtext {
//
//}

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

//the point 
//impress the info of one point,the x and y

class OnePoint implements Serializable {
    int x;
    int y;
    int tool;
    Color c;
    int border;
 
 public OnePoint(int x,int y,int tool,Color cc,int border){
  this.x=x;
  this.y=y;
  this.tool=tool;
  this.c=cc;
  this.border=border;
 }
}

class DrawingBoard extends Frame implements MouseListener,ItemListener,ActionListener,MouseMotionListener{
 
 Button pen;
 Button line ;
 Button ellipse ;
 Button rect ;
 Button clear ;
 Button colorboard ; 
 Button storebutton;
 Button openbutton;
 
 Choice sizechoice ;
 Choice colorchoice ;
 
 Label pensize;
 Label pencolor;
 Panel panel ;
 
 FileDialog  storefile;
 FileDialog  openfile;
 
 FileInputStream filein;
 FileOutputStream fileout;
 ObjectInputStream objectin;
 ObjectOutputStream objectout;
 
 int flagtool=0;
 Color flagcolor;
 int border;
 BasicStroke size;
 
 OnePoint p1,p2;
 Vector<OnePoint> points=new Vector<OnePoint>();
 
 public DrawingBoard(){
  pen=new Button("����");
  line=new Button("ֱ��");
  ellipse=new Button("Բ");
  rect=new Button("����");
  clear=new Button("���");
  colorboard=new Button("��ɫ��");
  storebutton=new Button("�洢�ļ�");
  openbutton=new Button("���ļ�");
  
  pensize=new Label("���ʴ�С");
  pencolor=new Label("������ɫ");
  
  storefile=new FileDialog(this,"�洢�ļ�",FileDialog.SAVE);
  storefile.setVisible(false);
  
  openfile=new FileDialog(this,"���ļ�",FileDialog.LOAD);
  openfile.setVisible(false);
  openfile.addWindowListener(new WindowAdapter(){
   public void windowClosing(WindowEvent e){
    openfile.setVisible(false);
   }
  });
  
  sizechoice=new Choice();
  sizechoice.add("1");
  sizechoice.add("2");
  sizechoice.add("4");
  sizechoice.add("6");
  sizechoice.add("8");
  sizechoice.addItemListener(this);
  
  colorchoice=new Choice();
  colorchoice.add("black");
  colorchoice.add("red");
  colorchoice.add("blue");
  colorchoice.add("green");
  colorchoice.addItemListener(this);
  
  pen.addActionListener(this);
  line.addActionListener(this);
  ellipse.addActionListener(this);
  rect.addActionListener(this);
  clear.addActionListener(this);
  colorboard.addActionListener(this);
  storebutton.addActionListener(this);
  openbutton.addActionListener(this);
  
  panel=new Panel(); 
  
  panel.add(storebutton);
  panel.add(openbutton);
  
  panel.add(pen);
  panel.add(line);
  panel.add(ellipse);
  panel.add(rect);
  panel.add(clear);
  
  panel.add(sizechoice);
  panel.add(pensize);
  
  panel.add(colorchoice);
  panel.add(pencolor);
  panel.add(colorboard);
  
  add(panel,BorderLayout.NORTH);
  setBounds(100,100,700,600);
  setVisible(true);
  
  addWindowListener(new WindowAdapter(){
   public void windowClosing(WindowEvent e){
    System.exit(0);
   }
  });
  
  /**
   * �������¼��ļ����������������ƶ��͵�������޷�ʶ��
   * */
  addMouseListener(this);
  addMouseMotionListener(this);
 }
 
 public void paint(Graphics g){
  
  Graphics2D g2d=(Graphics2D)g;
  if(flagtool==2){                    //qing chu
   g.clearRect(0,0,getSize().width,getSize().height);
  }

  for(int i=0;i<points.size()-1;i++){
   p1=(OnePoint)points.elementAt(i);
   p2=(OnePoint)points.elementAt(i+1);
   
   g2d.setColor(p1.c); //////////////��Ҫʹ��Graphics2D��Graphics���м̳������ķ��� setColor�������õ�ǰ����ɫ
   size=new BasicStroke(p1.border,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
   g2d.setStroke(size);
   
   if(p1.tool==p2.tool){
   switch(p1.tool){
   case 0:  
    Line2D.Double line1=new Line2D.Double(p1.x,p1.y,p2.x,p2.y);
    g2d.draw(line1);
    break;
   case 1:
    Line2D.Double line2=new Line2D.Double(p1.x,p1.y,p2.x,p2.y);
    g2d.draw(line2);
    break;
   case 3:
    Ellipse2D.Double ellipse=new Ellipse2D.Double(p1.x,p1.y,Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y));
    g2d.draw(ellipse);
    break;
   case 4:
    Rectangle2D.Double rect=new Rectangle2D.Double(p1.x,p1.y,Math.abs(p2.x-p1.x),Math.abs(p2.y-p1.y));
    g2d.draw(rect);
    break;
   default:
   }
    }
  } 
 }
 
 public void mouseClicked(MouseEvent e) {}

 public void mouseEntered(MouseEvent e) {}

 public void mouseExited(MouseEvent e) {}

 public void mousePressed(MouseEvent e) { //������ʱ�򣬽���ǰ�ĵ���Ϣ��¼
  
  OnePoint pp1=new OnePoint(e.getX(),e.getY(),flagtool,flagcolor,border);
  points.addElement(pp1);
  //repaint();
 }

 public void mouseReleased(MouseEvent e) {//����ɿ�ʱ������ǻ��ʣ���ǰ�ضϣ�������״̬����һö����Ϣ
  if(flagtool==0){
   points.addElement(new OnePoint(-1,-1,22,flagcolor,border));
  }
  else{
   OnePoint pp2=new OnePoint(e.getX(),e.getY(),flagtool,flagcolor,border);
   points.addElement(pp2);
   points.add(new OnePoint(-1,-1,22,flagcolor,border));
  }
  repaint();
 }

 public void itemStateChanged(ItemEvent e) {
  if(e.getSource()==colorchoice){
   String selected=colorchoice.getSelectedItem();
   if(selected=="black"){
    flagcolor=new Color(0,0,0);
   }
   else if(selected=="red"){
    flagcolor=new Color(255,0,0);
   }
   else if(selected=="blue"){
    flagcolor=new Color(0,0,255);
   }
   else if(selected=="green"){
    flagcolor=new Color(0,255,0);
   }
  }
  else if(e.getSource()==sizechoice){
   String selected=sizechoice.getSelectedItem();
   if (selected=="1"){
    border=1;
   }
   else if(selected=="2"){
    border=2*2;
   }
   else if(selected=="4"){
    border=4*2;
   }
   else if(selected=="6"){
    border=6*2;
   }
   else if(selected=="8"){
    border=8*2;
   }
  }
  
 }
 public void update(Graphics g) {   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
  paint(g);
 }
 public void actionPerformed(ActionEvent e) {
  // TODO Auto-generated method stub
  if(e.getSource()==pen){
   flagtool=0;
  }
  else if(e.getSource()==line){
   flagtool=1;
  }
  else if(e.getSource()==clear){
   flagtool=2;
   points.removeAllElements();
   repaint();      //����Ҫ�У���������޷�ɾ����
  }
  else if(e.getSource()==ellipse){
   flagtool=3;
  }
  else if(e.getSource()==rect){
   flagtool=4;
  }
  else if(e.getSource()==colorboard){
   /*
    * ʹ�� javax.swing.�����е� JColorChooser ��ľ�̬����showDialog��Component component��String title��Color color ����
    * �÷����Ĳ�����component�ǵ�ǰ��ʾ�Ի���ĸ���ܣ�color�����õ�ɫ���ʼ�ı�ѡ��ɫ
    * 
    * �÷������ر�ѡ����ɫ������ΪColor
    * */
   Color color=JColorChooser.showDialog(this, "��ɫ��",flagcolor);
   flagcolor=color;
  }
  else if(e.getSource()==openbutton){
   openfile.setVisible(true);
   if(openfile.getFile()!=null){   
    int temp=flagtool;
    flagtool=2;
    repaint();
    try{
     points.removeAllElements();
     File file=new File(openfile.getDirectory(),openfile.getFile());
     filein=new FileInputStream(file);
     objectin=new ObjectInputStream(filein);
     points=(Vector)objectin.readObject();
     objectin.close();
     filein.close();
     flagtool=temp;
     repaint();
    }
    catch(Exception ee){
     System.out.println(ee.toString());
    }
   }
  }
  else if(e.getSource()==storebutton){
   storefile.setVisible(true);
   if(storefile.getFile()!=null){    
    try {
     File file=new File(storefile.getDirectory(),storefile.getFile());
     fileout=new FileOutputStream(file);
     objectout=new ObjectOutputStream(fileout);
     objectout.writeObject(points);
     objectout.close();
     fileout.close();
     repaint();
    }
    catch (FileNotFoundException e1) {
     System.out.println(e1.toString());
     e1.printStackTrace();
    } catch (IOException ee) {
     System.out.println(ee.toString());
     ee.printStackTrace();
    }
   }
  }
 }

 public void mouseDragged(MouseEvent e) {//����϶�ʱ��//���ҽ��� flagtool����0�����߱�ʾΪ��Ƥ��ʱ��
//           �Ž��϶��������漰���ĵ�ȫ����¼���������ҵ���repain()�������ػ���ǰ
  // TODO Auto-generated method stub
  if(flagtool==0){
   OnePoint pp3=new OnePoint(e.getX(),e.getY(),flagtool,flagcolor,border);
   points.addElement(pp3);
   repaint();
  }
 }

 public void mouseMoved(MouseEvent e) {
  // TODO Auto-generated method stub  
 }

}

public class drawingtext{
 public static void main(String[] args){
  DrawingBoard oneBorder=new DrawingBoard();
 }
}