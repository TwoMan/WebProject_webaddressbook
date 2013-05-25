package javabean;

public class MemberInfomation {
	private String name ,phonenumber ,currentaddress ,career ,workt ;
	//memberinfomation初始化
	public MemberInfomation(){
		this.name = null;
		this.career = null;
		this.currentaddress = null;
		this.phonenumber = null;
		this.workt = null;
	}
	//对属性进行赋值
	public void set_name(String str){
		this.name = str;
	}
	public void set_phonenumber(String str){
		phonenumber = str;
	}
	public void set_currentaddress(String str){
		currentaddress = str;
	}
	public void set_career(String str){
		career = str;
	}
	public void set_workt(String str){
		workt = str;
	}
	//返回memberinfomation对象的属性值
	public String get_name(){		
		return this.name; 
	}
	public String get_phonenumber(){		
		return this.phonenumber; 
	}
	public String get_currentaddress(){		
		return this.currentaddress; 
	}
	public String get_career(){		
		return this.career; 
	}
	public String get_workt(){		
		return this.workt; 
	}
}
