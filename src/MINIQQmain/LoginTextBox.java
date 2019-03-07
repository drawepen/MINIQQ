package MINIQQmain;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LoginTextBox extends JPanel implements longonlb{
	/**
	 * 
	 *///setUndecorated(true);
	private static final long serialVersionUID = 1L;
	static Color blue=new Color(0,99,177);
	public JTextField passowText,verification;//accoutField;
	public JComboBox accoutCombox;
	private int sl=0,cl=0,ttl=0,passowmaxl=33;                      //passowmaxl��ʾ������󳤶�
	public char[] truetext=new char[50];               //��ʼ��Ϊ\0
	private boolean whetheroutput=true,invisible=true,faulogon,fstpass;
	public JLabel veriflb,vlb;
	public JCheckBox autologon,storepass;
	ImageIcon icon1,icon2;
	JLabel label1,label2;
	//private boolean first

	public LoginTextBox(int width,int height) {
		super();
		setLayout(null);                             //������Ϊnull�޷��ɹ�ʹ��setBounds()
		setSize(width,height);
		setBackground(blue);
		passowText = new JTextField(35);                                   //���������ַ������������壬��Ȼ����
		accoutCombox = new JComboBox();
		//passowText.setBackground(blue);
		accoutCombox.setEditable(true);
	    accoutCombox.setFont(new Font("SimSun", 1, 20));           //Font.BOLD�Ӵ�Font.PLAIN
	    accoutCombox.addItem("123456");
	    accoutCombox.addItem("233");
	    autologon=new JCheckBox("�Զ���¼",faulogon);
	    storepass=new JCheckBox("��ס����",fstpass);
	    autologon.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {    //����Ƶ�λ�þʹ���,��ѡ���Ƴ�����������
                // ��ȡ�¼�Դ������ѡ����
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if(checkBox.isSelected()) {
                	//if(au_st) {                        //��ֹ�ѳ�ѡstorepass���������autologon�Ͼʹ����¼���st...
                	    storepass.setSelected(true);        //�ı�storepass��ѡ����ᴥ���乴ѡ�¼�һ��
                	    
                	
                }else {
                	
                }
            }
        });
	    storepass.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // ��ȡ�¼�Դ������ѡ����
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if(storepass.isSelected()) {
                	
                }
                else {
                	autologon.setSelected(false);
                }
            }
        });

	    autologon.setBackground(blue);
	    autologon.setFocusPainted(false);             //ȥ��ť���ֱ߿�  
	    autologon.setBorderPainted(false);             //ȥ��ť�߿�
	    autologon.setForeground(Color.WHITE);
	    storepass.setBackground(blue);
	    storepass.setFocusPainted(false);             //ȥ��ť���ֱ߿�   
	    storepass.setForeground(Color.WHITE);
	    labelzh.setForeground(Color.white);
	    icon1=new ImageIcon("image/tp5.png");
	    icon2=new ImageIcon("image/tp6.png");
	    label1=new JLabel(icon1);
	    label2=new JLabel(icon2);
	    //��ӳ�ʼ�û�
	    
	    //////////////////
	    passowText.setFont(new Font("SimSun", 1, 20));  //Font.BOLD�Ӵ�Font.PLAIN
	    MyDocument md=new MyDocument();
	    passowText.setDocument(md);           //�ı����ֵ
	/* �����ı�����ƶ��¼� */
	    passowText.addCaretListener(new CaretListener() {
	          public void caretUpdate(CaretEvent e) {
	        	  int tempsl;
	        	  cl=e.getMark();                 //�õ�����ַ�λ������(�ǹ���һ�ַ�λ��(��0��ʼ))
	        	 // if()
	        	  tempsl=sl;
	        	  sl=passowText.getText().length();
	        	  if(sl>tempsl) {                          //�����ַ� 
	        		  if(++ttl<passowmaxl) {                 //�ԼӺ�ttlΪ�ַ�����,��ttl==passowmaxl���ַ��Ų�������,��ʱ����passowmaxl���ַ�
	        		     for(int i=ttl;i>=cl;i--) {
	        			     truetext[i]=truetext[i-1];
	        		      }
	        		      truetext[cl-1]=md.truetext.charAt(0);
	        		  }
	        		  else {
	        			  whetheroutput=false;
	        		  }
	        	  }
	        	  else if(sl<tempsl) {
	        		  while(truetext[cl]!='\0') {                //ǰ��ɾ������һ��
	    				  truetext[cl++]=truetext[cl];           //�ȶ���ߣ�cl++ִ������cl
	    			  }
	        		  ttl--;
	        		  whetheroutput=true;
	        	  }
	          }
	    });
	    //add(accoutField);
	    label1.setBounds(25,50,35,35);
	    add(label1);
	    accoutCombox.setBounds(60,50,400,35);
	    add(accoutCombox);
	    label2.setBounds(25,120,35,35);
	    add(label2);
	    passowText.setBounds(60,120,400,35);
	    add(passowText);
	    autologon.setBounds(30,180,80,20);
	    add(autologon);
	    storepass.setBounds(195,180,80,20);
	    add(storepass);
	    labelzh.setBounds(360,180,80,20);
	    add(labelzh);
	}
	public String getAccount() {
		return (String) accoutCombox.getSelectedItem();
	}
	public String getPassow() {
		String s="";
		for(int i=0;i<cl;i++) {
			s+=truetext[i];
		}
		return s;
	}
	public int chanegloctaion() {       //����������
		 label1.setBounds(25,85,35,35);
		 accoutCombox.setBounds(60,85,400,35);
		 label2.setBounds(25,140,35,35);
		 passowText.setBounds(60,140,400,35);
		 autologon.setBounds(30,190,80,20);
		 storepass.setBounds(195,190,80,20);
		 labelzh.setBounds(360,190,80,20);
		 vlb=new JLabel(new ImageIcon("image/tp7.png"));
		 veriflb=new JLabel();
		 veriflb.setForeground(Color.white);
		 veriflb.setFont(new Font("SimSun", Font.BOLD, 16));
		 veriflb.setHorizontalAlignment(JLabel.CENTER);
		 veriflb.setBounds(0,20,350,50);
		 add(veriflb);
		 verification=new JTextField(5);
		 verification.setFont(new Font("SimSun", Font.BOLD, 16));
		 verification.setBounds(346, 30, 50, 30);
		 add(verification);
		 return setverification();
	}
	public String getverification() {
		return verification.getText();
	}
	///��֤������
	public int setverification() {
		String[] sn= {""};
		int n=(int) (Math.random()*2)+4;
		double sum=0;
		String[] str= {""};
		int js1=(int)(Math.random()*4);
		int a1=(int)(Math.random()*200);
		
		switch(js1) {
		case 0://+
			sum+=a1;
			str[0]+=a1;
			break;
		case 1://-
			sum-=a1;
			str[0]+="��"+a1;
			break;
		default :
			sum=yzm(str,sn);
			if(sn[0].equals("double")) {
				n--;
			}
		}
		double temp=sum;
		sum=0;
		while(--n>0) {//��������%���RMath.pow(x, y)x��y�η�Math.log(5) ln �� 
			int js=(int)(Math.random()*10);
			int a=(int)(Math.random()*200);
			switch(js) {
			case 0://+
				sum+=temp;
				temp=a;
				str[0]+="��"+a;
				break;
			case 1://-
				sum+=temp;
				temp=-a;
				str[0]+="��"+a;
				break;
			case 2://*
				temp*=a;
				str[0]+="��"+a;
				break;
			case 3:///
				temp/=a;
				str[0]+="��"+a;
				break;
			case 4://%
				temp%=a;
				str[0]+="%"+a;
				break;
			default :
				int js2=(int)(Math.random()*5);
				switch(js2) {
				case 0://+
					sum+=temp;
					str[0]+="��";
					temp=yzm(str,sn);
					if(sn[0].equals("double")) {
						n--;
					}
					break;
				case 1://-
					sum+=temp;
					str[0]+="��";
					temp=yzm(str,sn);
					if(sn[0].equals("double")) {
						n--;
					}
					break;
				case 2://*
					str[0]+="��";
					temp*=yzm(str,sn);
					if(sn[0].equals("double")) {
						n--;
					}
					break;
				case 3:///
					str[0]+="��";
					temp/=yzm(str,sn);
					if(sn[0].equals("double")) {
						n--;
					}
					break;
				case 4://%
					str[0]+="%";
					temp%=yzm(str,sn);
					if(sn[0].equals("double")) {
						n--;
					}
				}
				
			}
		}
		sum+=temp;
		veriflb.setText("(int)("+str[0]+")=");
		
		return (int)sum;
	}
	private static double yzm(String[] str,String[] n) {//��a��ln,lg,�̴���//String��ʽ����Ҳ��ֵ������ַ!!!ֻ������Ͷ��󴫵�ַ
		n[0]="";           //����Ƿ�˫����
		int a1=(int)(Math.random()*200)+1;
		int a2=(int)(Math.random()*200)+1;
		if(a1<a2) {               //��ֹln(����)
			int te=a1;
			a1=a2;
			a2=te;
		}
		else if(a1==a2) {          //��ֹln0
			a1++;
		}
		int js2=(int)(Math.random()*6);
		int js3=(int)(Math.random()*5);
		double sum=0;
		switch(js2) {
		case 0://ln1
			sum+=Math.log(a1);
			str[0]+="ln"+a1;
			break;
		case 1://lg1
			sum+=Math.log(a1)/Math.log(10);
			str[0]+="lg"+a1;
			break;
		case 2://v1
			sum+=Math.pow(a1,0.5);
			str[0]+="��"+a1;
			break;
		case 3://ln2
			n[0]="double";
			switch(js3) {
			case 0://+
				sum+=Math.log(a1+a2);
				str[0]+="ln("+a1+"+"+a2+")";
				break;
			case 1://-
				sum+=Math.log(a1-a2);
				str[0]+="ln("+a1+"-"+a2+")";
				break;
			case 2://*
				sum+=Math.log(a1*a2);
				str[0]+="ln("+a1+"��"+a2+")";
				break;
			case 3:///
				sum+=Math.log(1.0*a1/a2);
				str[0]+="ln("+a1+"��"+a2+")";
				break;
			case 4://%	
				sum+=Math.log(1.0*(a1%a2));
				str[0]+="ln("+a1+"%"+a2+")";
			}
			break;
		case 4://lg2	
			n[0]="double";
			switch(js3) {
			case 0://+
				sum+=Math.log(a1+a2)/Math.log(10);
				str[0]+="lg("+a1+"+"+a2+")";
				break;
			case 1://-
				sum+=Math.log(a1-a2)/Math.log(10);
				str[0]+="lg("+a1+"-"+a2+")";
				break;
			case 2://*
				sum+=Math.log(a1*a2)/Math.log(10);
				str[0]+="lg("+a1+"��"+a2+")";
				break;
			case 3:///
				sum+=Math.log(1.0*a1/a2)/Math.log(10);
				str[0]+="lg("+a1+"��"+a2+")";
				break;
			case 4://%	
				sum+=Math.log(1.0*a1%a2)/Math.log(10);//Math.log(int)������������
				str[0]+="lg("+a1+"%"+a2+")";
			}
			break;
		default : //��2
			n[0]="double";
			switch(js3) {
			case 0://+
				sum+=Math.pow(a1+a2,0.5);
				str[0]+="��("+a1+"+"+a2+")";
				break;
			case 1://-
				sum+=Math.pow(a1-a2,0.5);
				str[0]+="��("+a1+"-"+a2+")";
				break;
			case 2://*
				sum+=Math.pow(a1*a2,0.5);
				str[0]+="��("+a1+"��"+a2+")";
				break;
			case 3:///
				sum+=Math.pow(1.0*a1/a2,0.5);
				str[0]+="��("+a1+"��"+a2+")";
				break;
			case 4://%	
				sum+=Math.pow(1.0*a1%a2,0.5);
				str[0]+="��("+a1+"%"+a2+")";
			}
		}
		return sum;
	}
	///
	class MyDocument extends PlainDocument {  
	    public String truetext;
	    public int trueposition;
	    public void insertString(int offset, String s, AttributeSet attrSet) throws BadLocationException {  
	          truetext=s;                     //�����ÿ���ַ�
	          trueposition=offset;            //������ַ�λ�ã��ǹ��ǰһ�ַ�λ��(��0��ʼ)��
	          
	        /////////////////////////////////////////////////////////////
	          if(whetheroutput) {
	              int tempi=(int)(Math.random()*30);//M...10����()M...om()תΪint��0
	              String tempc;
	              if(tempi<18) {
	        	      tempc=""+(char)(Math.random()*10+48);
	              }
	              else if(tempi<24) {
	        	      tempc=""+(char)(Math.random()*26+65);
	              }
	              else if(tempi<27){
	        	       tempc=""+(char)(Math.random()*26+97);
	              }
	              else if(tempi<28){
	       	           tempc=""+(char)(Math.random()*7+33);
	              }
	              else if(tempi<29) {
	        	      tempc=""+(char)(Math.random()*5+42);
	              }
	              else {
	        	      tempc=""+(char)(Math.random()*3+94);
	              }
	        /////////////////////////////////////////////////////////////
	              if(invisible) {
	            	  super.insertString(offset, tempc, attrSet);  
	              }
	              else {
	            	  super.insertString(offset, s, attrSet);  
	              }
	               
	          }
	    }
//	    public void firstinsertString(int offset, String s, AttributeSet attrSet) throws BadLocationException {
//	    	passowText.setForeground(Color.gray);
//	    	super.insertString(0, "����", attrSet); 
//	    	passowText.setForeground(Color.BLACK);
//	    }

	} 

}
