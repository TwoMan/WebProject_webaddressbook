package loginmodule;
import java.sql.*;
import javabean.*;
import connectmodule.*;
public class LoginCheckDAO {
	private ResultSet resultset = null;
	//检查用户登录，如果成功返回true，否则返回false
	public Boolean checkLogin(CheckUserBean checkuserbean){
		String userid = null, answear = null;
		Connect connect = new Connect();
		String sql = "select id,answer from user_login_view where id="+"'"+checkuserbean.get_id()+"'";
		this.resultset = connect.getResultSet(sql);
		try {
			if(resultset.next()){
				userid = resultset.getString("id");
				answear = resultset.getString("answer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(checkuserbean.get_id().equals(userid)&&checkuserbean.get_questswear().equals(answear)){
			return true;
		}
		else{
			System.out.println("logincheckdao----回答问题答案不匹配");
			return false;
		}
	}

}
