package listmodule;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connectmodule.Connect;
import javabean.UserName;
import javabean.UserSchool;

public class MemberListDAO {
	//
	public ArrayList<UserName> getMemberListArrayList(UserSchool schoolselect){
		ArrayList<UserName> arraylist = new ArrayList<UserName>();
		String sql = "select id, username from user_school_info_view where province = "+"'"+schoolselect.get_province()+"'"+"and city = "+"'"+schoolselect.get_city()+"'"+
					 "and town = "+"'"+schoolselect.get_town()+"'"+"and school = "+"'"+schoolselect.get_school()+"'"+"and age = "+"'"+schoolselect.get_age()+"'"+
					 "and class_and_grade = "+"'"+schoolselect.get_class_and_grade()+"'";
		System.out.println(sql);
		Connect connect = new Connect();
		ResultSet resultset = null;
		resultset = connect.getResultSet(sql);
		try {
			while(resultset.next()){
				UserName username = new UserName();
				username.set_memberid(resultset.getString("id"));
				username.set_username(resultset.getString("username"));
				arraylist.add(username);
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("memberlistdao----error");
		}
		connect.closeDatabaseConnection();
		return arraylist;
	}
}
