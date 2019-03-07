package miniQQ;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
/*
 * 用TCP进行文件传输
 * 此文件为服务器文件
 * 当接受到客户端的请求之后，先向其传输文件名
 * 当客户端接受完毕之后，向客户端传输文件
 * */
 
public class SendFileServer implements Runnable{
 
         //服务器监听端口
         private static final int MONITORPORT  = 12345;
         private static String filepath;
         private static String filename;
          private Socket s ;
        
         public SendFileServer(Socket s) {
                   super();
                   this.s= s;
         }
 
         public static void server(String filepath,String filename)
         {
                   try{
                            //创建服务器socket
                            ServerSocket ss = new ServerSocket(MONITORPORT);
                            while(true)
                            {
                                     //接收到一个客户端连接之后，创建一个新的线程进行服务
                                     //并将联通的socket传给该线程
                                     Socket s = ss.accept();
                                     new Thread(new SendFileServer(s)).start();
                            }
                   }catch (IOException e) {
                            //TODO Auto-generated catch block
                            e.printStackTrace();
                   }
         }
         
         /**
          * @param args
          */
       /*  public static void main(String[] args) {
                   //TODO Auto-generated method stub
                   SendFileServer.server();
         }*/
 
 
 
         @Override
         public void run() {
                   //TODO Auto-generated method stub
                   byte[]buf = new byte[100];
                   OutputStream os=null;
                   FileInputStream fins=null;
                   try{
                            os= s.getOutputStream();
                            //文件路径
                            String filePath =filepath;
                            //文件名
                            String fileName = "图形.jpg";
                            System.out.println("将文件名:"+fileName+"传输过去");
                            //先将文件名传输过去
                            os.write(fileName.getBytes());
                            System.out.println("开始传输文件");
                            //将文件传输过去 
                            //获取文件
                            fins= new FileInputStream(filePath);
                            int data;
                            //通过fins读取文件，并通过os将文件传输
                            while(-1!=(data= fins.read()))
                            {
                                     os.write(data);
                            }
                            System.out.println("文件传输结束");
                            
                            
                   }catch (IOException e) {
                            //TODO Auto-generated catch block
                            e.printStackTrace();
                   }finally
                   {
                            try{
                                     if(fins!=null)fins.close();
                                     if(os!=null)        os.close();
                                     this.s.close();
                            }catch (IOException e) {
                                     e.printStackTrace();
                            }
                            
                   }
                   
         }
 
}
