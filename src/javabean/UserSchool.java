package javabean;

public class UserSchool {
	private String province ;
	private String city ;
	private String town ;
	private String school ;
	private String age ;
	private String class_and_grade ;
	//构造userschool及初始化
	public UserSchool(){
		this.age = null;
		this.city = null;
		this.class_and_grade = null;
		this.province = null;
		this.school = null;
		this.town = null;
	}
	//对对象属性进行赋值
	public void set_province(String str){
		this.province = str;
	}

	public void set_city(String str){
		this.city = str;
	}
	
	public void set_town(String str){
		this.town = str;
	}
	
	public void set_school(String str){
		this.school = str;
	}
	
	public void set_age(String str){
		this.age = str;
	}
	
	public void set_class_and_grade(String str){
		this.class_and_grade = str;
	}
	
	//返回对象的属性值
	public String get_province(){	
		return this.province;
	}
	
	public String get_city(){		
		return this.city;
	}
	
	public String get_town(){	
		return this.town;
	}
	
	public String get_school(){		
		return this.school;
	}
	
	public String get_age(){			
		return this.age;
	}
	
	public String get_class_and_grade(){		
		return this.class_and_grade;
	}
}
