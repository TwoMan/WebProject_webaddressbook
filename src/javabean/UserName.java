package javabean;

public class UserName {
	private String username ;
	private String memberid ;
	//username�ĳ�ʼ��
	public UserName(){
		this.memberid = null;
		this.username = null;
	}
	//��username��������Խ��и�ֵ
	public void set_memberid(String str){
		this.memberid = str;
	}	
	public void set_username(String str){
		this.username = str;
	}
	//����username���������ֵ
	public String get_memberid(){
		return this.memberid;
	}
	public String get_username(){
		return this.username;
	}

}
