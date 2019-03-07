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
 - 音乐播放器类
 - @author lt
 - time 2016-7-5"file:music/老男孩_筷子兄弟.mp3"
 */
public class text3{
    Player player;
    File music;
    //构造方法  参数是一个.mp3音频文件
    public text3(File file) {
        this.music = file;
    }
    //播放方法
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
           player.play();//一开始就不会向下执行
            
            
            
           
    }
    public static void main(String[] args) throws JavaLayerException, IOException {
    	new text3(new File("music/老男孩_筷子兄弟.mp3")).play();
    }
    
}
