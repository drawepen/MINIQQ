package miniQQ;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
 
/*
 * ��TCP�����ļ�����
 * ���ļ�Ϊ�������ļ�
 * �����ܵ��ͻ��˵�����֮�������䴫���ļ���
 * ���ͻ��˽������֮����ͻ��˴����ļ�
 * */
 
public class SendFileServer implements Runnable{
 
         //�����������˿�
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
                            //����������socket
                            ServerSocket ss = new ServerSocket(MONITORPORT);
                            while(true)
                            {
                                     //���յ�һ���ͻ�������֮�󣬴���һ���µ��߳̽��з���
                                     //������ͨ��socket�������߳�
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
                            //�ļ�·��
                            String filePath =filepath;
                            //�ļ���
                            String fileName = "ͼ��.jpg";
                            System.out.println("���ļ���:"+fileName+"�����ȥ");
                            //�Ƚ��ļ��������ȥ
                            os.write(fileName.getBytes());
                            System.out.println("��ʼ�����ļ�");
                            //���ļ������ȥ 
                            //��ȡ�ļ�
                            fins= new FileInputStream(filePath);
                            int data;
                            //ͨ��fins��ȡ�ļ�����ͨ��os���ļ�����
                            while(-1!=(data= fins.read()))
                            {
                                     os.write(data);
                            }
                            System.out.println("�ļ��������");
                            
                            
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
