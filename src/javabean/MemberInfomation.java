package javabean;

public class MemberInfomation {
	private String name ,phonenumber ,currentaddress ,career ,workt ;
	//memberinfomation��ʼ��
	public MemberInfomation(){
		this.name = null;
		this.career = null;
		this.currentaddress = null;
		this.phonenumber = null;
		this.workt = null;
	}
	//�����Խ��и�ֵ
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
	//����memberinfomation���������ֵ
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
