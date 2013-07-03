package connectmodule;
import java.sql.*;
public class Connect {
	private String user = "root";
	//Ҫ�����Լ������ݿ�����
	private String password = "5613996";
	private String url = "jdbc:mysql://localhost:3306/addressbook?useUnicode=true&characterEncoding=gbk";
	private Connection connection = null;
	//���connection����
	public Connection tryConnectDatabase(){		
		//Ѱ�����ݿ���������
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��----�Ҳ����������ݿ������");
		}
		//����һ��connection���Ӷ���
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��----����connection���Ӳ��ɹ�");
		}		
		return connection;
	}
	//�ر����ݿ�����
	public void closeDatabaseConnection(){
		if(this.connection == null){
			System.out.println("Connect��----connection��û������");
		}
		else{
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connect��----connection,���ݿ�رղ��ɹ�");
			}
		}
	}
	//��ȡ��sql��ص�resultset����
	public ResultSet getResultSet(String sql){
		ResultSet resultset = null;
		Statement statement = null;
		try {
			statement = tryConnectDatabase().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��----��ȡstatement���ɹ�");
		}
		try {
			resultset = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��----��ȡresultset���ɹ�");
		}		
		return resultset;
	}
	//��ȡ��sql��ص�insertPreparedstatement����
	public PreparedStatement getInsertPreparedStatement(String sql){
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = tryConnectDatabase().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��---��ȡinsertpreparedstatement���ɹ�");
		}
		return preparedstatement;
	}
	//��ȡ��sql��ص�updatepreparedstatement����
	public PreparedStatement getUpdatePreparedStatement(String sql){
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = tryConnectDatabase().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect��---��ȡupdatepreparedstatement���ɹ�");
		}
		return preparedstatement;
	}
}
