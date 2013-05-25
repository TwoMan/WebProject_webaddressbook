package javabean;
import java.util.*;
import connectmodule.*;
import java.sql.*;
public class SchoolSelectArray {
	private Connect connect = null;
	private ArrayList<String> SchoolArray_province = new ArrayList<String>();
	private ArrayList<String> SchoolArray_age = new ArrayList<String>();
	private ArrayList<String> SchoolArray_city = new ArrayList<String>();
	private ArrayList<String> SchoolArray_town = new ArrayList<String>();
	private ArrayList<String> SchoolArray_school = new ArrayList<String>();
	private ArrayList<String> SchoolArray_classandgrade = new ArrayList<String>();
	//
	public SchoolSelectArray(){
		connect = new Connect();
		System.out.println("schoolselectarray----init");
	}
	//
	private void set_SchoolArray_province(){		
		ResultSet resultset = connect.getResultSet("select province from province_view");
		//System.out.println("schoolselectarray--province--init");
		try {
			System.out.println("resultset is empty?"+resultset.wasNull());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("schoolselectarray--resultset--error");
		}
		try {
			while(resultset.next()){
				String province = null;
				province = resultset.getString("province");
				SchoolArray_province.add(province);
				//System.out.println(resultset.getString("province"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---province--error");
		}
	}
	private void set_SchoolArray_age(){		
		ResultSet resultset = connect.getResultSet("select age from age_view");
		try {
			while(resultset.next()){
				SchoolArray_age.add(""+resultset.getString("age"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---age--error");
		}
	}
	private void set_SchoolArray_town(){		
		ResultSet resultset = connect.getResultSet("select town from town_view");
		try {
			while(resultset.next()){
				SchoolArray_town.add(""+resultset.getString("town"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---town--error");
		}
	}
	private void set_SchoolArray_city(){		
		ResultSet resultset = connect.getResultSet("select city from city_view");
		try {
			while(resultset.next()){
				SchoolArray_city.add(""+resultset.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---city--error");
		}
	}
	private void set_SchoolArray_school(){		
		ResultSet resultset = connect.getResultSet("select school from school_view");
		try {
			while(resultset.next()){
				SchoolArray_school.add(""+resultset.getString("school"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---school--error");
		}
	}
	private void set_SchoolArray_classandgrade(){		
		ResultSet resultset = connect.getResultSet("select class_and_grade from class_and_grade_view");
		try {
			while(resultset.next()){
				SchoolArray_classandgrade.add(resultset.getString("class_and_grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("schoolselectarray---classandgrade--error");
		}
	}
	//
	public ArrayList<String> getSchoolArray_province(){
		set_SchoolArray_province();
		return this.SchoolArray_province;
	}
	public ArrayList<String> getSchoolArray_city(){
		set_SchoolArray_city();
		return this.SchoolArray_city;
	}
	public ArrayList<String> getSchoolArray_town(){
		set_SchoolArray_town();
		return this.SchoolArray_town;
	}
	public ArrayList<String> getSchoolArray_school(){
		set_SchoolArray_school();
		return this.SchoolArray_school;
	}
	public ArrayList<String> getSchoolArray_age(){
		set_SchoolArray_age();
		return this.SchoolArray_age;
	}
	public ArrayList<String> getSchoolArray_classandgrade(){
		set_SchoolArray_classandgrade();
		return this.SchoolArray_classandgrade;
	}
}
