package displayinfomodule;
import javabean.*;
import connectmodule.*;
import java.sql.*;
public class DisplayInfoDAO {
	public MemberInfomation getmemberinfo(String userid){
		String sql ;
		sql="select username,phonenumber,career,workt,currentaddress from user_info_view where id = "+"'"+userid+"'";
		MemberInfomation memberinfo = new MemberInfomation();
		Connect connect = new Connect();
		ResultSet resultset = null;
		resultset = connect.getResultSet(sql);
		try {
			if(resultset.next()){
				memberinfo.set_career(resultset.getString("career"));
				memberinfo.set_currentaddress(resultset.getString("currentaddress"));
				memberinfo.set_name(resultset.getString("username"));
				memberinfo.set_phonenumber(resultset.getString("phonenumber"));
				memberinfo.set_workt(resultset.getString("workt"));
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberinfo;
	}
}
