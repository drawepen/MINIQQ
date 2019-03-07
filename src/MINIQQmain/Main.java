package MINIQQmain;

import java.util.concurrent.TimeUnit;

import MINIdialogue.dialoguetool;

public class Main {
	public Main(Main m) {//无法创建对象
		
	}
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		dialoguetool tool=new dialoguetool();
		SignInInterface signInInterface=new SignInInterface(tool);
		Thread t1=new Thread(signInInterface);
		t1.start();
		while(true) {
			try {                          //while(true){执行的步骤太少会卡住！！！！！}
				TimeUnit.MILLISECONDS.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}            
			if(signInInterface.getfinish()) {
				signInInterface=null;           //释放登陆框内存
				t1.interrupt();//中断线程
				break;
			}
		}
	}

}