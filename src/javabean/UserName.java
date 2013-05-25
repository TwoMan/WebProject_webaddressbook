package javabean;

public class UserName {
	private String username ;
	private String memberid ;
	//username的初始化
	public UserName(){
		this.memberid = null;
		this.username = null;
	}
	//对username对象的属性进行赋值
	public void set_memberid(String str){
		this.memberid = str;
	}	
	public void set_username(String str){
		this.username = str;
	}
	//返回username对象的属性值
	public String get_memberid(){
		return this.memberid;
	}
	public String get_username(){
		return this.username;
	}

}
