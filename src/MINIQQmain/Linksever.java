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
	static final int PORT = 8080; // ���Ӷ˿�
	static final String HOST = "127.0.0.1";//"121.250.216.178"; // ���ӵ�ַ
	public static final String string="string",file="file",image="image",expression="bq",end=">>end3n2n",
			online="<dl2!@",refile="ref",success="success",getfriends="getf",getgroup="getg",drawingfd="draxy",
			csong="csong";
	public static final int fileaccept=12;
	public Socket socket;
	public InputStream input;
    public OutputStream output;
	public BufferedWriter bfwriter;//����Ϣ����ר��
	public BufferedReader bfreader;
	public PrintWriter prwriter;
	public Linksever() throws UnknownHostException, IOException {
		socket = new Socket(HOST, PORT);// �����ͻ����׽���//���Ӻ�������ر�Ҳ����������
		input = socket.getInputStream();
	    output = socket.getOutputStream();
		// �ͻ���������������������Ϣ
		bfwriter = new BufferedWriter(new OutputStreamWriter(output));
		// �ͻ��������������շ�������Ϣ
		bfreader = new BufferedReader(new InputStreamReader(input));
		prwriter = new PrintWriter(bfwriter, true); // װ�����������ʱˢ��
	}
	public void cutlink() {
		if (null != socket) {//���socket==null�Ͽ����ӻᱨ��
			   try {
					socket.close(); // �Ͽ�����
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}
