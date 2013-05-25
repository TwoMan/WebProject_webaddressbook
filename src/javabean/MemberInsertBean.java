package javabean;

public class MemberInsertBean extends MemberInfomation {
	private String id;
	private String question;
	private String answear;
	//
	public void setID(String str){
		this.id = str;
	}
	public void setQuestion(String str){
		this.question = str;
	}
	public void setAnswear(String str){
		this.answear = str;
	}
	//
	public String getID(){
		return this.id;
	}
	public String getQuestion(){
		return this.question;
	}
	public String getAnswear(){
		return this.answear;
	}
	
}
