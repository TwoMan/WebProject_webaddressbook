package loginmodule;

import java.sql.ResultSet;
import java.sql.SQLException;
import connectmodule.Connect;

public class GetLoginQuestionDAO {
	private ResultSet resultset = null;
	//����û���¼������ɹ�����true�����򷵻�false
	public String getLoginQuestion(String id){
		String question = null;
		Connect connect = new Connect();
		String sql = "select question from user_login_view where id="+"'"+id+"'";
		this.resultset = connect.getResultSet(sql);
		try {
			if(resultset.next()){
				
				question = resultset.getString("question");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return question;
	}
}
