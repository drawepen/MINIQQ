package MINIQQaddition;


import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
/***
 - ���ֲ�������
 - @author lt
 - time 2016-7-5"file:music/���к�_�����ֵ�.mp3"
 */
public class musicplay{
	Player player=null;
    File music;
    //���췽��  ������һ��.mp3��Ƶ�ļ�
    public musicplay(File file,String str,String st) {
    	JFrame jf=new JFrame("����"+str+"�ĵ�衪��"+st);
    	JButton jb1=new JButton("����");
    	JButton jb2=new JButton("ֹͣ");
    	jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					play();
				} catch (JavaLayerException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
       jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(player!=null)
				    player.close();
			}
		});
        this.music = file;
        jf.getContentPane().setLayout(new FlowLayout() );
        jf.getContentPane().add(jb1);
        jf.getContentPane().add(jb2);
        jf.setBounds(300,10,400,80);
        jf.setVisible(true);
        jf.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e){
				   if(player!=null)
						player.close();
				   jf.setVisible(false);
				   jf.dispose(); //�رս���
			   }
			 });
    }
    //���ŷ���
    public void play() throws JavaLayerException, IOException {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
            player = new Player(buffer);
            
            new Thread(){ 
         	   @Override
         	   public void run() {
         		  try {
					player.play();
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//һ��ʼ�Ͳ�������ִ��
                   
         	   }
         }.start();    
    }
    
    public static void main(String[] args) throws JavaLayerException, IOException {
    	new musicplay(new File("music/���к�_�����ֵ�.mp3"),"aaa","bbb");
    }
    
}
