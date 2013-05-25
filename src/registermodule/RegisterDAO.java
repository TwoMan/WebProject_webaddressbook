package registermodule;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectmodule.*;
import javabean.MemberInsertBean;
public class RegisterDAO {
	public boolean insertMember(MemberInsertBean memberinsert){
		int state = 0;
		Connect connect = new Connect();
		PreparedStatement preparedstatement = null;
		preparedstatement = connect.getInsertPreparedStatement("insert into user_info(id,username,phonenumber,currentaddress,career,workt,question,answer) values(?,?,?,?,?,?,?,?)");
		try {
			preparedstatement.setString(1, memberinsert.getID());
			preparedstatement.setString(2, memberinsert.get_name());
			preparedstatement.setString(3, memberinsert.get_phonenumber());
			preparedstatement.setString(4, memberinsert.get_currentaddress());
			preparedstatement.setString(5, memberinsert.get_career());
			preparedstatement.setString(6, memberinsert.get_workt());
			preparedstatement.setString(7, memberinsert.getQuestion());
			preparedstatement.setString(8, memberinsert.getAnswear());
			state = preparedstatement.executeUpdate();
			System.out.println(state);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("registerdao-----≤Â»Î ß∞‹");
		}
		if(state != 0)
			return true;
		else 
			return false;
	}
}
