package miniQQ;

public class Message implements java.io.Serializable{
	
	private String mesType,sender,getter,con,sendTime;
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public String getGetter() {
		return getter;
	}
	
	public void setGetter(String getter) {
		this.getter = getter;
	}
	
	public String getCon() {
		return con;
	}
	
	public void setCon(String con) {
		this.con = con;
	}

	public String getMesType() {
		return mesType;
	}

	public void setMesType(String mesType) {
		this.mesType = mesType;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

}