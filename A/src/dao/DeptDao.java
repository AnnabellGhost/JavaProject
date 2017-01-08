package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import entity.dept;
import entity.staff;




public class DeptDao {

	public ArrayList<dept> selectAllDept(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from dept");
			ResultSet rs=ps.executeQuery();
			ArrayList<dept> depts=new ArrayList<dept>();			
			while(rs.next()){
				dept ru=new dept();
				ru.setDeptid(rs.getString("deptid"));
				ru.setDeptname(rs.getString("deptname"));
				ru.setDetail(rs.getString("detail"));
				depts.add(ru);				
			}
			DBUtil.closeAll(conn, ps, rs);	
			return depts;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	public dept selectDept(String deptid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from dept where deptid=?");
			ps.setString(1,deptid);
			ResultSet rs = ps.executeQuery();
			dept ru=new dept();
			if(rs.next()){
				ru.setDeptid(rs.getString("deptid"));
				ru.setDeptname(rs.getString("deptname"));
				ru.setDetail(rs.getString("detail"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateDept(dept dept){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("update dept set deptname=?,detail=? where deptid=?");
		    ps.setString(1,dept.getDeptname());
			ps.setString(2,dept.getDetail());
			ps.setString(3,dept.getDeptid());
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		    return 0;
	}
	
	
	
	
	
	
	
	
}
