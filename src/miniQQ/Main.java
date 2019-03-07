package miniQQ;

import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;

public class Main {

	public static void main(String args[]) throws UnknownHostException, IOException{
		qqLogin QQLogin = new qqLogin();
		QQLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		QQLogin.setVisible(true);
	}

}
