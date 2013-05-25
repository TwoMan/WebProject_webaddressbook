package joinbookmodule;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import connectmodule.Connect;
import javabean.UserSchoolViewBean;
import javabean.SelectInfoViewBean;

public class JoinBookDAO {
	//将用户新请求加入的通讯组信息插入到user_school_view表中
	public boolean insertUserSchoolView(UserSchoolViewBean userschoolviewbean){
		int state = 0;
		Connect connect = new Connect();
		PreparedStatement statement = null;
		statement = connect.getInsertPreparedStatement("insert into user_school_info_view(id,username,province,city,town,school,age,class_and_grade) value(?,?,?,?,?,?,?,?)");
		try {
			statement.setString(1, userschoolviewbean.getId());
			statement.setString(2, userschoolviewbean.getUserName());
			statement.setString(3, userschoolviewbean.getProvince());
			statement.setString(4, userschoolviewbean.getCity());
			statement.setString(5, userschoolviewbean.getTown());
			statement.setString(6, userschoolviewbean.getSchool());
			statement.setString(7, userschoolviewbean.getAge());
			statement.setString(8, userschoolviewbean.getClass_And_Grade());
			state = statement.executeUpdate();
			connect.closeDatabaseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JoinBookDAO----插入出错");
		}	
		if(state != 0)
			return true;
		else
			return false;
	}
	//如果需要调用此方法，说明用户创建了新的通讯组，并把相关信息保存在select_info_view中
	public boolean insertSelectInfoView(SelectInfoViewBean selectinfoview){
		int state = 0;
		Connect connect = new Connect();
		PreparedStatement statement = null;
		statement = connect.getInsertPreparedStatement("insert into select_info_view(province,city,town,school,age,class_and_grade,applyquestion,questionanswer) value(?,?,?,?,?,?,?,?)");
		try {
			statement.setString(1, selectinfoview.getProvince());
			statement.setString(2, selectinfoview.getCity());
			statement.setString(3, selectinfoview.getTown());
			statement.setString(4, selectinfoview.getSchool());
			statement.setString(5, selectinfoview.getAge());
			statement.setString(6, selectinfoview.getClass_And_Grade());
			statement.setString(7, selectinfoview.getQuestion());
			statement.setString(8, selectinfoview.getAnswear());
			state = statement.executeUpdate();
			connect.closeDatabaseConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("JoinBookDAO-selectinfoview---插入出错");
		}
		if(state != 0)
			return true;
		else
			return false;
	}
}
