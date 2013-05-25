package updateinfomodule;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectmodule.Connect;
import javabean.MemberInfomation;

public class UpdateInfoDAO {
	//用过传来一个memberinfomation消息，然后根据对象对数据库进行更新处理
	public boolean updateInfo(MemberInfomation memberinfo, String id){
		Connect connect = new Connect();
		int count = 0;
		System.out.println("memberinfo:" + memberinfo.get_career()+memberinfo.get_currentaddress()+memberinfo.get_name()+memberinfo.get_phonenumber()+memberinfo.get_workt());
		PreparedStatement preparedstatement = connect.getUpdatePreparedStatement("update user_info_view set username = ?,phonenumber = ?,currentaddress = ?,career = ?,workt = ? where id = ? ");
		System.out.println("prepare is null?" + preparedstatement);
		try {
			preparedstatement.setString(1, memberinfo.get_name());
			preparedstatement.setString(2, memberinfo.get_phonenumber());
			preparedstatement.setString(3, memberinfo.get_currentaddress());
			preparedstatement.setString(4, memberinfo.get_career());
			preparedstatement.setString(5, memberinfo.get_workt());
			preparedstatement.setString(6, id);
			//如果提交成功则会返回一个整数，所以用count保存，用作方法返回值得判断依据；
			count = preparedstatement.executeUpdate();
			System.out.println("updateinfodao--count = "+ count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateinfodao----false");
		}
		//如果i不等于0 说明sql语句成功执行，所以返回true值
		if(count > 0)
			return true;
		//如果i依然保持0值，说明sql语句提交不成功，所以返回执行数据更新操作不成功的判断；
		else {
			return false;
		}
	}

}
