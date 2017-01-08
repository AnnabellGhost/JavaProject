package dao;

import common.DBUtil;
import java.sql.*;
import java.util.*;

import entity.user;

public class UserDao {
	public user selectUser(user user){
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
			("select * from usertable where username = ?");
			
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			user ru = new user();
			if(rs.next()){
				ru.setStaffid(rs.getString("staffid"));
				ru.setUsername(rs.getString("username"));
				ru.setPassword(rs.getString("password"));
				ru.setRole(rs.getString("role"));
				ru.setStatus(rs.getString("status"));
				ru.setWrongnum(rs.getInt("wrongnum"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	//管理员登陆
	public user selectUserofAdmin(user user){
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
			("select * from usertable where username = ? and role='admin'");
			
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			user ru = new user();
			if(rs.next()){
				ru.setStaffid(rs.getString("staffid"));
				ru.setUsername(rs.getString("username"));
				ru.setPassword(rs.getString("password"));
				ru.setRole(rs.getString("role"));
				ru.setStatus(rs.getString("status"));
				ru.setWrongnum(rs.getInt("wrongnum"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	//用户登录
	public user selectUserofMember(user user){
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
			("select * from usertable where username = ? and role='member'");
			
			ps.setString(1, user.getUsername());
			
			ResultSet rs = ps.executeQuery();
			
			user ru = new user();
			if(rs.next()){
				ru.setStaffid(rs.getString("staffid"));
				ru.setUsername(rs.getString("username"));
				ru.setPassword(rs.getString("password"));
				ru.setRole(rs.getString("role"));
				ru.setStatus(rs.getString("status"));
				ru.setWrongnum(rs.getInt("wrongnum"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	//改变用户状态以及错误次数
	public void updateUserStatus(user user){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("update usertable set status=?,wrongnum=? where staffid=?");
			ps.setString(1,user.getStatus());
			ps.setInt(2, user.getWrongnum());
			ps.setString(3, user.getStaffid());
			ps.executeUpdate();
			//提交，如果不提交，更新操作可能丢失
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//查询所有用户信息
	public ArrayList<user> selectAllUser(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from usertable");
			ResultSet rs=ps.executeQuery();
			ArrayList<user> alluser=new ArrayList<user>();			
			while(rs.next()){
				user ru=new user();
				ru.setStaffid(rs.getString("staffid"));
				ru.setUsername(rs.getString("username"));
				ru.setPassword(rs.getString("password"));
				ru.setRole(rs.getString("role"));
				ru.setStatus(rs.getString("status"));
				ru.setWrongnum(rs.getInt("wrongnum"));
				alluser.add(ru);				
			}			
			DBUtil.closeAll(conn, ps, rs);	
			return alluser;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	
	public int deletUserByStaffid(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("delete from usertable where staffid=?");
			ps.setString(1,staffid);
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}

	public int updateUserInfo(user user){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("update usertable set username=?,password=?,role=?,status=?,wrongnum=? where staffid=?");
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());
			ps.setString(4, user.getStatus());
			ps.setInt(5, user.getWrongnum());
			ps.setString(6,user.getStaffid());
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}
	
	public int insertUser(user user){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("insert into usertable" +
			"(staffid,username,password,role,status,wrongnum)" +
			 " values(?,?,?,?,?,?)");
			ps.setString(1,user.getStaffid());
			ps.setString(2,user.getUsername());
			ps.setString(3,user.getPassword());
			ps.setString(4,user.getRole());
			ps.setString(5,"1");
			ps.setInt(6,0);
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}
	
	//根据用户ID找到该用户的详细信息并返回
	public user selectUserByStaffid(String staffid){
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement
			("select * from usertable where staffid = ?");
			
			ps.setString(1, staffid);
			
			ResultSet rs = ps.executeQuery();
			
			user ru = new user();
			if(rs.next()){
				ru.setStaffid(rs.getString("staffid"));
				ru.setUsername(rs.getString("username"));
				ru.setPassword(rs.getString("password"));
				ru.setRole(rs.getString("role"));
				ru.setStatus(rs.getString("status"));
				ru.setWrongnum(rs.getInt("wrongnum"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
