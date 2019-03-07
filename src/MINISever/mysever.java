package MINISever;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.concurrent.TimeUnit;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import MINIQQmain.Linksever;
import MINIdialogue.Friend;

public class mysever {

		// TODO Auto-generated method stub
		static final int PORT = 8080;
		static final int MAX=100;
		static int jsp=-1;//����������һ
		Socket[] socket,filesocket,drawsocket;
		String[] IP,account;
		String savefilepath="E:\\MINIQQseverfile";
		PrintWriter[] outs;
		Connection sqlct = null;
		PreparedStatement sqlps = null;
		ResultSet sqlrs = null;
		boolean[] sdfile;
		ServerSocket ss;
		static int ljjs=0,ljzs=0;
		int[] jljgs;
		public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException  {
			
			mysever se=new mysever();
			InetAddress ia=InetAddress.getLocalHost(); //��ñ���IP��ַ���
			System.out.println("��������"+ia.getHostName());  //�õ�������//����������䣬������ַ������ӿڸı����
			System.out.println("������ַ:"+ia.getHostAddress()); //�õ�������ַ
			System.out.println("Started: " + se.ss);
			try {
				// Blocks until a connection occurs:
				while(true) {
					Socket sk= se.ss.accept();
					ljzs++;
					String ip = sk.getInetAddress().getHostAddress();//int port = socket.getLocalPort() ;
					int i=jsp;
					for(;i>=0;i--) {
						if(se.IP[i].equals(ip)) {  
							if(se.jljgs[i]==1) {
								se.filesocket[i]=sk;
								se.jljgs[i]++;
								System.out.println("fs:"+sk+" "+se.jljgs[i]);/////////////////
								break;
							}else if(se.jljgs[i]==2) {
								se.drawsocket[i]=sk;
								se.new handel(i).start();
								se.jljgs[i]++;
								System.out.println("ds:"+sk+" "+se.jljgs[i]);/////////////////
								break;
							}
							
						}
					}
					if(i<0) {
						int j=0;
						for(;j<=jsp;j++) {
							if(se.jljgs[j]<1) {
								se.socket[j]=sk;
								se.IP[j]=ip;
								se.jljgs[j]++;
								break;
							}
						}
						if(j==jsp+1) {
							jsp++;
							se.socket[jsp]=sk;
							se.IP[jsp]=ip;
							se.jljgs[jsp]++;
						}
					}
				}
				
		    } finally {
				se.ss.close();
				se.sqlrs.close();
				se.sqlps.close();
				se.sqlct.close();
			}

      }
		
		public mysever() throws IOException, ClassNotFoundException, SQLException {
			 new File("E:\\MINIQQseverfile").mkdirs();//����Ŀ¼���Ѵ��ڲ��Ḳ��
		        
			socket=new Socket[MAX];
			filesocket=new Socket[MAX];
			drawsocket=new Socket[MAX];
			IP=new String[MAX];
			account=new String[MAX];
			ss = new ServerSocket(PORT);
			sdfile=new boolean[MAX];
			jljgs=new int[MAX];
			outs=new PrintWriter[MAX];
			Class.forName("com.mysql.jdbc.Driver");
			sqlct = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/miniqq","root","56789Shi!");
			sqlct.prepareStatement("update yonghu set online= '����'").executeUpdate();
		}
		
  class handel extends Thread{
	Socket socket,filesocket,drawsocket;
	int number=0;
	private OutputStream dout;
	public handel(int num){
		socket=mysever.this.socket[num];
		filesocket=mysever.this.filesocket[num];
		number=num;
		drawsocket=mysever.this.drawsocket[num];
		new draws().start();
	}
	class draws extends Thread{
		public void run() {
			InputStream din;
			try {
				din = drawsocket.getInputStream();
				dout=null;//////////////////
				byte[] b=new byte[16];
				int le;
				while ((le=din.read(b))!=-1) {
					if(dout!=null) {
						dout.write(b,0,le);
						dout.flush();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void run() {
		System.out.println("����������"+ljzs+"<"+(++ljjs)+">"+"�����ӣ�"+socket+"\n��������������������������������"+filesocket
				+"\n��������������������������������"+drawsocket);
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			PrintWriter out=new PrintWriter(bw,true);
			outs[number] = out;
			String info = null;
			String str2="";
			while ((str2=in.readLine())!=null) {//�ж�����in.readLine()���ᱨ����һֱ����null
				String[] str0=null;
				try {
					str0 = str2.split("\t");
				}catch( java.lang.NullPointerException e) {
					System.out.println("δ֪��Ϣ");
					continue;
				}
				
				if(str0[0].equals(">>>")) {
					
					switch(str0[1]) {
					
					case Linksever.string:                //�Ի���Ϣ
						String strt=getstring(in);
						int i=jsp;
						for(;i>=0;i--) {
							if(account[i].equals(str0[2])) {
								str0[2]=account[number];
								for(int j=1;j<str0.length;j++) {
									str0[0]+="\t"+str0[j];
								}
								out.println(">>>\t"+Linksever.success+"\t"+Linksever.string);
								outs[i].println(str0[0]);
								outs[i].println(strt);//strtĩβ��\nӦ��print,������������println�ͻ���۵���һ�η�������
								break;
							}
						}
						if(i<0) {
							if(str0[2].equals(Friend.wordgroup)) {
								str0[0]="<<<";
								str0[2]=account[number];
								for(int j=1;j<str0.length;j++) {
									str0[0]+="\t"+str0[j];
								}
								out.println(">>>\t"+Linksever.success+"\t"+Linksever.string);
								for(int i4=0;i4<=jsp;i4++) {
									if(i4!=number) {
										outs[i4].println(str0[0]);
										outs[i4].println(strt);
									}
								}
							}else {
								out.println("false");
							}
						}
						break;
					case Linksever.expression:
						String s1=in.readLine();
						int i2=jsp;
						for(;i2>=0;i2--) {
							if(account[i2].equals(str0[2])) {
								str0[2]=account[number];
								for(int j=1;j<str0.length;j++) {
									str0[0]+="\t"+str0[j];
								}
								out.println(">>>\t"+Linksever.success+"\t"+Linksever.expression);
								outs[i2].println(str0[0]);
								outs[i2].println(s1);//����������println�ͻ���۵���һ�η�������
								break;
							}
						}
						if(i2<0) {
							if(str0[2].equals(Friend.wordgroup)) {
								str0[0]="<<<";
								str0[2]=account[number];
								for(int j=1;j<str0.length;j++) {
									str0[0]+="\t"+str0[j];
								}
								out.println(">>>\t"+Linksever.success+"\t"+Linksever.expression);
								for(int i4=0;i4<=jsp;i4++) {
									if(i4!=number) {
										outs[i4].println(str0[0]);
										outs[i4].println(s1);
									}
								}
							}else {
								out.println("false");
							}
						}
						break;
					case Linksever.file:
						System.out.println("׼������");/////////////////////////////
						mysever.this.new getfile(number,str0[2],false).start();
						break;
					case Linksever.image:
						mysever.this.new getfile(number,str0[2],true).start();
						break;
					case Linksever.online:
						System.out.println("senfonline1");
						try {
							sqlrs=sqlct.prepareStatement("select * from yonghu where username = '"+str0[2]+
									"' and password = '"+str0[3]+"' and online ='����'").executeQuery();
						}catch( java.lang.ArrayIndexOutOfBoundsException e) {
							out.println("false");
							e.printStackTrace();
							break;
						}
						System.out.println("senfonline2");
						if(sqlrs.next()) {
							out.println("true");
							sqlct.prepareStatement("update yonghu set online= '����' where username = '"+str0[2]+"'").executeUpdate();
							account[number]=str0[2];
							System.out.println(account[number]+"��½"+mysever.this.socket[number]);////////////////////
							out.println(sqlrs.getString("username")+"\t"+sqlrs.getString("nicheng")+"\t"+sqlrs.getString("head")+"\t"+sqlrs.getString("vip")+"\t"+sqlrs.getString("dengji")+"\t"+sqlrs.getString("minibi"));
						}else {
							out.println("false");
							System.out.println("senfonline3");
						}
						break;
					case Linksever.refile:
						
						mysever.this.new sendfile(number,str0[2],null,true,false,null).start();//�ؽ����ļ�,">>>(+)L...le(+)filepath"
						break;
					case Linksever.getfriends:
						out.println(getfriends(number));
						break;
					case Linksever.getgroup:
						sqlrs=sqlct.prepareStatement("select * from yonghu ").executeQuery();
						String str1="";
						int sum1=0;
						while(sqlrs.next()) {
							sum1++;
							str1+="\t"+sqlrs.getString("head")+"\t"+sqlrs.getString("nicheng")+"\t"+sqlrs.getString("dengji")+"\t"+sqlrs.getString("online");
						}
						out.println(sum1+str1);
						break;
					case Linksever.drawingfd:
						System.out.println("׼��drawfd");//////////////////////////////////
						int i3=jsp;
						for(;i3>=0;i3--) {
							System.out.println(jsp+"��ѯ�� "+account[i3]+"==="+str0[2]);//////////////////////////////
							if(account[i3].equals(str0[2])) {
								dout=mysever.this.drawsocket[i3].getOutputStream();
								System.out.println(account[number]+"��ds:"+mysever.this.drawsocket[i3]);////////////
								break;
							}
						}
						if(i3<0) {
							dout=null;
						}
						break;
					case Linksever.csong:
						for(int i5=jsp;i5>=0;i5--) {
							System.out.println(jsp+"��ѯ�� "+account[i5]+"==="+str0[2]);//////////////////////////////
							if(account[i5].equals(str0[2])) {
								outs[i5].println(str0[0]+"\t"+str0[1]+"\t"+account[number]+"\t"+str0[3]);
								break;
							}
						}
						break;
				}
			}
			}
			// Always close the two sockets...
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("����������"+ljzs+"<"+(--ljjs)+">"+account[number]+"��closing...");
			try {
				socket.close();
				sqlct.prepareStatement("update yonghu set online= '����' where username = '"+account[number]+"'").executeUpdate();
				jljgs[number]=0;//���������Ҫ���
				account[number]="";//������Ϊnull,equals()��������
				IP[number]="";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
	 
	}
  public String getstring(BufferedReader in) throws IOException {
		String s=null,str="";
		do {
			s=in.readLine();
			str+=s+"\n";
		}while(!s.equals(Linksever.end));
		return str;
	}
  class getfile extends Thread{
	  InputStream input;
//      OutputStream output;
	  int source;
      String fileusename,friend;
      public boolean end=false,image=false;
	  public getfile(int s,String str,boolean im) throws IOException {
		  source=s;
		  friend=str;
		  input = filesocket[s].getInputStream();
//	      output = socket.getOutputStream();
		  image=im;
	  }
	  public void run() {
		  
		  //�ļ���
		    byte[] b = new byte[256];
		    int len = 0;
			try {
				len = input.read(b);
				String ss = new String(b, 0, len);
			    String[] str1 = ss.split("\t");// �ѽ��յ�����Ϣ���Ʊ�����
			    String filename = str1[0];// ��ʼλ�ļ�����
			    System.out.println("<1>"+ss);////////////////////////////
			    //�ļ�����
//			    output.flush();
			    fileusename=savefilepath+"\\"+System.currentTimeMillis()+"&@&"+filename;//�ļ�·��//��ǰ����ʱ���
			    FileOutputStream fout = new FileOutputStream(new File(fileusename));
			    System.out.println("�����ļ�"+fileusename);////////////////////////////
		        b = new byte[1024 * 1024*2];
		        long size=0;
		        long fs=Long.parseLong(str1[1]);
		        while (size<fs&&(len=input.read(b))!=-1) {//�ֽ��׹رղŷ���-1������
		          fout.write(b, 0, len);
		          size+=len;
		        }
		        System.out.println("<4>"+len);////////////////////////////
		        fout.close();
		        int i1=jsp;
		        for(;i1>=0;i1--) {
					if(account[i1].equals(friend)) {
						System.out.println("<-3");///////////////
							mysever.this.new sendfile(i1,fileusename,str1[1],false,image,account[source]).start();//·������С��ͼƬor�ļ�
					        break;
					}
				}
		        if(i1<0) {
		        	sqlrs=sqlct.prepareStatement("select * from a"+friend+" where account = '"+account[source]+"'").executeQuery();
		        	if(sqlrs.next()) {
		        		int fsum=sqlrs.getInt("filesum");
		        		if(fsum<10) {
		        			sqlct.prepareStatement("update a"+friend+" set filesum = "+(++fsum)+" where account = '"+account[source]+"'").executeUpdate();
		        		}else {
		        			fsum=1;
		        		}
		        		sqlct.prepareStatement("update a"+friend+" set file"+fsum+" = '"+fileusename+"#&#"+str1[1]+"' where account = '"+account[source]+"'").executeUpdate();
		        	}
		        }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       System.out.println("getfile  end");
	  }
  }
  class sendfile extends Thread{
	  int num;
	  String path,size,source;
	  boolean resend,image;
	  public sendfile (int i,String p,String si,boolean r,boolean im,String s) {//Ҫ�����ļ���С����д����ļ���С����0���޷��õ���ʵ��С
		  path=p;
		  num=i;
		  resend=r;
		  size=si;
		  image=im;
		  source=s;
	  }
	  public void run() {
		  System.out.println("[1]");/////////////////////
		  while(sdfile[num]) {
			  try {          
				  TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}            
		  }
		  System.out.println("[2]");///////////////
		  sdfile[num]=true;
		  try {
		      InputStream input = filesocket[num].getInputStream();
		      OutputStream output = filesocket[num].getOutputStream();
		      System.out.println(path);
		      File file = new File(path);
		      System.out.println("<-1");///////////////
		      int len=0;
		      if(!resend) {
		    	  if(image) {
		    		  outs[num].println(">>>\t"+Linksever.image+"\t"+source);
		    	  }else {
		    		  outs[num].println(">>>\t"+Linksever.file+"\t"+source);
		    	  }
		    	  
		    	  // ��һ�δ����ļ�����and�ļ��Ĵ�С
		    	  String str1 = path+ "\t" + size;//�����ļ�·�����Ա��ؽ���
			      output.write(str1.getBytes());
			      output.flush();
		      }
		      if(image||input.read()==Linksever.fileaccept) {
		     		FileInputStream fins = new FileInputStream(file);
			        byte[] b1 = new byte[1024 * 1024];
			        while (fins.available() != 0) {
			          len = fins.read(b1);
			          output.write(b1, 0, len);
			          output.flush();   //???len���2097152�������ͬ��len���65536???!!! 
			        }
			        fins.close();
		       }
		    } catch (IOException e) {
			}
		       System.out.println("sendfile  end");  //////////////////////
		  sdfile[num]=false;
	  }
  }
 
  public String getfriends(int num) throws SQLException {
	  String str="";
	  int sum=0;
	  sqlrs=sqlct.prepareStatement("select * from yonghu where username = '"+account[num]+"'").executeQuery();
	    if(sqlrs.next()) {
	    	sum=sqlrs.getInt("friendsum");
	    }
	    str+=sum;
	    sqlrs=sqlct.prepareStatement("select * from a"+account[num]).executeQuery();
	    String[] s=new String[sum];
	    int i=0;
	    while(sqlrs.next()) {
	    	s[i++]=sqlrs.getString("account");
	    }
	    for(int j=0;j<sum;j++) {
	    	sqlrs=sqlct.prepareStatement("select * from yonghu where username = '"+s[j]+"'").executeQuery();
	    	if(sqlrs.next()) {//û��.next()�޷��õ�����
	    		str+="\t"+s[j]+"\t"+sqlrs.getString("head")+"\t"+sqlrs.getString("nicheng")+"\t"+sqlrs.getString("dengji")+"\t"+sqlrs.getString("online");
	    	}
	    }
	   new lxsendfile(num).start(); 
	  return str;
  }
  class lxsendfile extends Thread{//��½���������ļ�
	  int num;
	  public lxsendfile(int n) {
		  num=n;
	  }
	  public void run() {
		  try {
				TimeUnit.MILLISECONDS.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  try {
			sqlrs=sqlct.prepareStatement("select * from a"+account[num]).executeQuery();
			 while(sqlrs.next()) {
				  int sum=sqlrs.getInt("filesum");
				  String fda=sqlrs.getString("account");
				  for(int i=1;i<=sum;i++) {
					  String s=sqlrs.getString("file"+i);
					  String[] s2=s.split("#&#");
					  mysever.this.new sendfile(num,s2[0],s2[1], false,false,fda).start();//·������С��ͼƬor�ļ�
				  }
				  sqlct.prepareStatement("update a"+account[num]+" set filesum = "+0+" where account = '"+fda+"'").executeUpdate();
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	  }
  }
}