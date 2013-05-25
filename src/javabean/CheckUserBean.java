package javabean;

public class CheckUserBean {
	private String id, questanswear;
	//
	public CheckUserBean(){
		this.id = null;
		this.questanswear = null;
	}
	//
	public void set_id(String str){
		this.id = str;
	}
	public void set_questswear(String str){
		this.questanswear = str;
	}
	//
	public String get_id(){
		return this.id;
	}
	public String get_questswear(){
		return this.questanswear;
	}
}
