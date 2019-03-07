package MINIdialogue;
import java.awt.Container;
 import java.awt.Font;
 import java.io.File;
 import java.util.EmptyStackException;
 import java.util.Iterator;
import java.util.Stack;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 import javax.swing.Icon;
 import javax.swing.ImageIcon;
 import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JSpinner;
 import javax.swing.JSplitPane;
 import javax.swing.JTabbedPane;
 
 public class ImplementsDemo {
     public static void main(String[] args) throws EmptyStackException{
         JFrame f=new JFrame("Welcome To Earth!");
         Container cont=f.getContentPane();
         String picPath="c:"+File.separator+"Users"+File.separator+"Sunboy"+File.separator+"desktop"+File.separator+"课表.png";
         Icon ico=new ImageIcon(picPath);
         JPanel pan=new JPanel();
         JLabel lab=new JLabel(ico);
         pan.add(lab);
         JTextArea jta = new JTextArea(30, 105);
         jta.setTabSize(4);
         jta.setFont(new Font("标楷体", Font.BOLD, 16));
         jta.setLineWrap(true);// 激活自动换行功能
         jta.setWrapStyleWord(true);// 激活断行不断字功能
         jta.setBackground(Color.WHITE);
         JScrollPane scr1=new JScrollPane(jta);//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
         cont.add(scr1);
         f.setSize(560,550);
         f.setLocation(300, 200);
         f.setVisible(true);
         f.addWindowListener(new WindowAdapter() {
        	    public void windowClosing(WindowEvent e) {
        	     System.exit(0);
        	    }
        	   });
         
     }
}


 //实现接口ActionListene
 class JTextAreaDemo3 implements ActionListener {
  JFrame jf;
  JPanel jpanel;
  JButton jb1, jb2, jb3;
  JTextArea jta = null;
  JScrollPane jscrollPane;
  public JTextAreaDemo3(JPanel contentPane) {
   jta = new JTextArea(10, 15);
   jta.setTabSize(4);
   jta.setFont(new Font("标楷体", Font.BOLD, 16));
   jta.setLineWrap(true);// 激活自动换行功能
   jta.setWrapStyleWord(true);// 激活断行不断字功能
   jta.setBackground(Color.pink);
   jscrollPane = new JScrollPane(jta);
   jpanel = new JPanel();
   jpanel.setLayout(new GridLayout(1, 3));
   jb1 = new JButton("复制");
   jb1.addActionListener(this);
   jb2 = new JButton("粘贴");
   jb2.addActionListener(this);
   jb3 = new JButton("剪切");
   jb3.addActionListener(this);
   jpanel.add(jb1);
   jpanel.add(jb2);
   jpanel.add(jb3);
   contentPane.add(jscrollPane, BorderLayout.CENTER);
   contentPane.add(jpanel, BorderLayout.SOUTH);
  
  }
  // 覆盖接口ActionListener的方法actionPerformed
  public void actionPerformed(ActionEvent e) {
   if (e.getSource() == jb1) {
    jta.copy();
   } else if (e.getSource() == jb2) {
    jta.paste();
   } else if (e.getSource() == jb3) {
    jta.cut();
   }
  }
 }