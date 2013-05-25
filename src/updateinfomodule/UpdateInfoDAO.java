package updateinfomodule;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connectmodule.Connect;
import javabean.MemberInfomation;

public class UpdateInfoDAO {
	//�ù�����һ��memberinfomation��Ϣ��Ȼ����ݶ�������ݿ���и��´���
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
			//����ύ�ɹ���᷵��һ��������������count���棬������������ֵ���ж����ݣ�
			count = preparedstatement.executeUpdate();
			System.out.println("updateinfodao--count = "+ count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("updateinfodao----false");
		}
		//���i������0 ˵��sql���ɹ�ִ�У����Է���trueֵ
		if(count > 0)
			return true;
		//���i��Ȼ����0ֵ��˵��sql����ύ���ɹ������Է���ִ�����ݸ��²������ɹ����жϣ�
		else {
			return false;
		}
	}

}
