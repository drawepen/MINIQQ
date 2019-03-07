package MINIQQmain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Linksever {
	static final int PORT = 8080; // 连接端口
	static final String HOST = "127.0.0.1";//"121.250.216.178"; // 连接地址
	public static final String string="string",file="file",image="image",expression="bq",end=">>end3n2n",
			online="<dl2!@",refile="ref",success="success",getfriends="getf",getgroup="getg",drawingfd="draxy",
			csong="csong";
	public static final int fileaccept=12;
	public Socket socket;
	public InputStream input;
    public OutputStream output;
	public BufferedWriter bfwriter;//传消息类型专用
	public BufferedReader bfreader;
	public PrintWriter prwriter;
	public Linksever() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);// 创建客户端套接字//连接后服务器关闭也不报错！！！
		input = socket.getInputStream();
	    output = socket.getOutputStream();
		// 客户端输出流，向服务器发消息
		bfwriter = new BufferedWriter(new OutputStreamWriter(output));
		// 客户端输入流，接收服务器消息
		bfreader = new BufferedReader(new InputStreamReader(input));
		prwriter = new PrintWriter(bfwriter, true); // 装饰输出流，及时刷新
	}
	public void cutlink() {
		if (null != socket) {//如果socket==null断开连接会报错
			   try {
					socket.close(); // 断开连接
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
