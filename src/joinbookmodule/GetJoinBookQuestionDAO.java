package joinbookmodule;

import java.sql.ResultSet;
import java.sql.SQLException;

import connectmodule.Connect;

class GetJoinBookQuestionDAO {
	//
	public String getJoinBookQuestion(String province_select,String city_select,String town_select,String school_select,String age_select,String classandgrade_select){
		String applyquestion = null;
		String sql="select applyquestion from select_info_view where province="+"'"+province_select+"'"+" and city="+"'"+city_select+"'"+" and town="+"'"+town_select+"'"+" and school="+"'"+school_select+"'"+" and age="+"'"+age_select+"'"+" and class_and_grade="+"'"+classandgrade_select+"'";
		Connect connect = new Connect();
		ResultSet resultset = null;
		resultset = connect.getResultSet(sql);
		try {
			while(resultset.next()){
				applyquestion = resultset.getString("applyquestion");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("GetJoinBookQuestionDAO----error");
		}
		return applyquestion;
	}
}
