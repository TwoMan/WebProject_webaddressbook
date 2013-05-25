package javabean;

public class SelectInfoViewBean {
	private String province;
	private String city;
	private String town;
	private String school;
	private String age;
	private String class_and_grade;
	private String question;
	private String answear;
	//
	public void setProvince(String str){
		this.province = str;
	}
	public void setCity(String str){
		this.city = str;
	}
	public void setTown(String str){
		this.town = str;
	}
	public void setSchool(String str){
		this.school =  str;
	}
	public void setAge(String str){
		this.age = str;
	}
	public void setClass_And_Grade(String str){
		this.class_and_grade = str;
	}
	public void setQuestion(String str){
		this.question = str;
	}
	public void setAnswear(String str){
		this.answear = str;
	}
	//
	
	public String getProvince(){
		return this.province;
	}
	public String getCity(){
		return this.city;
	}
	public String getTown(){
		return this.town;
	}
	public String getSchool(){
		return this.school;
	}
	public String getAge(){
		return this.age;
	}
	public String getClass_And_Grade(){
		return this.class_and_grade;
	}
	public String getQuestion(){
		return this.question;
	}
	public String getAnswear(){
		return this.answear;
	}
}
