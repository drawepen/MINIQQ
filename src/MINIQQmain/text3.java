package MINIQQmain;


import java.awt.EventQueue;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
/***
 - ���ֲ�������
 - @author lt
 - time 2016-7-5"file:music/���к�_�����ֵ�.mp3"
 */
public class text3{
    Player player;
    File music;
    //���췽��  ������һ��.mp3��Ƶ�ļ�
    public text3(File file) {
        this.music = file;
    }
    //���ŷ���
    public void play() throws JavaLayerException, IOException {
            BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
            player = new Player(buffer);
            
            EventQueue.invokeLater(new Runnable() { 
         	   @Override
         	   public void run() {
         		   try {                   
        				TimeUnit.MILLISECONDS.sleep(10000);
        			} catch (InterruptedException e) {
        				// TODO Auto-generated catch block
        				e.printStackTrace();
        			} 
                    System.out.println("sj");
                     player.close();
         	   }
         }); 
           player.play();//һ��ʼ�Ͳ�������ִ��
            
            
            
           
    }
    public static void main(String[] args) throws JavaLayerException, IOException {
    	new text3(new File("music/���к�_�����ֵ�.mp3")).play();
    }
    
}
