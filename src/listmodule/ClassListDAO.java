package listmodule;
import javabean.UserSchool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import connectmodule.Connect;
public class ClassListDAO {
	//
	public ArrayList<UserSchool> getUserSchoolList(String userid){
		ArrayList<UserSchool> arraylist = new ArrayList<UserSchool>();
		String sql = "select province,city,town,school,age,class_and_grade from user_school_info_view where id="+"'"+userid+"'";
		Connect connect = new Connect();
		ResultSet resultset = null;
		resultset = connect.getResultSet(sql);
		try {
			while(resultset.next()){
				UserSchool userschool = new UserSchool();
				userschool.set_age(resultset.getString("age"));
				userschool.set_city(resultset.getString("city"));
				userschool.set_class_and_grade(resultset.getString("class_and_grade"));
				userschool.set_province(resultset.getString("province"));
				userschool.set_school(resultset.getString("school"));
				userschool.set_town(resultset.getString("town"));
				arraylist.add(userschool);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("classlistdao----error");
		}
		return arraylist;
	}
}
