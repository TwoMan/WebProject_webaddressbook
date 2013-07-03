package connectmodule;
import java.sql.*;
public class Connect {
	private String user = "root";
	//要改用自己的数据库密码
	private String password = "5613996";
	private String url = "jdbc:mysql://localhost:3306/addressbook?useUnicode=true&characterEncoding=gbk";
	private Connection connection = null;
	//获得connection连接
	public Connection tryConnectDatabase(){		
		//寻找数据库连接驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类----找不到连接数据库的驱动");
		}
		//建立一个connection连接对象
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类----建立connection连接不成功");
		}		
		return connection;
	}
	//关闭数据库连接
	public void closeDatabaseConnection(){
		if(this.connection == null){
			System.out.println("Connect类----connection本没被建立");
		}
		else{
			try {
				this.connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Connect类----connection,数据库关闭不成功");
			}
		}
	}
	//获取与sql相关的resultset对象
	public ResultSet getResultSet(String sql){
		ResultSet resultset = null;
		Statement statement = null;
		try {
			statement = tryConnectDatabase().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类----获取statement不成功");
		}
		try {
			resultset = statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类----获取resultset不成功");
		}		
		return resultset;
	}
	//获取与sql相关的insertPreparedstatement对象
	public PreparedStatement getInsertPreparedStatement(String sql){
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = tryConnectDatabase().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类---获取insertpreparedstatement不成功");
		}
		return preparedstatement;
	}
	//获取与sql相关的updatepreparedstatement对象
	public PreparedStatement getUpdatePreparedStatement(String sql){
		PreparedStatement preparedstatement = null;
		try {
			preparedstatement = tryConnectDatabase().prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connect类---获取updatepreparedstatement不成功");
		}
		return preparedstatement;
	}
}
