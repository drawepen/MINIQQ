package MINIQQmain;

import java.util.concurrent.TimeUnit;

import MINIdialogue.dialoguetool;

public class Main {
	public Main(Main m) {//�޷���������
		
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		dialoguetool tool=new dialoguetool();
		SignInInterface signInInterface=new SignInInterface(tool);
		Thread t1=new Thread(signInInterface);
		t1.start();
		while(true) {
			try {                          //while(true){ִ�еĲ���̫�ٻῨס����������}
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
			if(signInInterface.getfinish()) {
				signInInterface=null;           //�ͷŵ�½���ڴ�
				t1.interrupt();//�ж��߳�
				break;
			}
		}
	}

}