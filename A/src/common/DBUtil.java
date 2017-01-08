package common;
//���ݿ������������
import java.sql.*;
//����Ŀ�м��������������

public class DBUtil {
	
	public static Connection getConnection(){
		
		try {
		//ѡ����������
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��������Ĺ�����ͳһ��������
		Connection conn = null;
	    try {
			conn = DriverManager.getConnection
			("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "sms", "sms");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		//�������
//		Connection conn = DBUtil.getConnection();
//		
//		String sql = "select * from usertable";
//		PreparedStatement ps =  conn.prepareStatement(sql);
//		ResultSet rs = ps.executeQuery();
//		
//		while(rs.next()){
//			System.out.println(rs.getString("username")+" ");
//			System.out.println(rs.getString("role")+" ");
//			System.out.println(rs.getString("status")+" ");
//		}
//		
//		//�ر���Դ
//		DBUtil.closeAll(conn, ps, rs);
//	}

}
