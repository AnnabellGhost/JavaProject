package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import entity.dept;
import entity.staff;
import entity.staffinfo;


public class StaffDao {

	
	
	public staffinfo selectStaffinfo(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from staffinfo where staffid=?");
			ps.setString(1,staffid);
			ResultSet rs = ps.executeQuery();
			
            staffinfo ru=new staffinfo();
			if(rs.next()){
				
				ru.setStaffid(rs.getString("staffid"));
				ru.setName(rs.getString("name"));
				ru.setBirthyear(rs.getInt("birthyear"));
				ru.setEdu(rs.getString("edu"));
				ru.setTel(rs.getString("tel"));
				ru.setIntro(rs.getString("intro"));
				ru.setImage(rs.getString("image"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	public int updateStaffinfo(staffinfo staffinfo){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("update staffinfo set name=?,birthyear=?,edu=?,tel=?,intro=?,image=? where staffid=?");
		
			ps.setString(1,staffinfo.getName());
			ps.setInt(2,staffinfo.getBirthyear());
			ps.setString(3,staffinfo.getEdu());
			ps.setString(4,staffinfo.getTel());
			ps.setString(5,staffinfo.getIntro());
			ps.setString(6,staffinfo.getImage());
			ps.setString(7,staffinfo.getStaffid());
			
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}
	
	public ArrayList<staffinfo> selectAllStaffinfo(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from staffinfo");
			ResultSet rs=ps.executeQuery();
			ArrayList<staffinfo> staffinfo=new ArrayList<staffinfo>();			
			while(rs.next()){
				
				staffinfo ru=new staffinfo();
				ru.setStaffid(rs.getString("staffid"));
				ru.setName(rs.getString("name"));
				ru.setBirthyear(rs.getInt("birthyear"));
				ru.setEdu(rs.getString("edu"));
				ru.setTel(rs.getString("tel"));
				ru.setIntro(rs.getString("intro"));
				ru.setImage(rs.getString("image"));
				staffinfo.add(ru);				
			}
			DBUtil.closeAll(conn, ps, rs);	
			return staffinfo;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	public ArrayList<staffinfo> selectPartStaffinfo(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select staffid,name from staffinfo");
			ResultSet rs=ps.executeQuery();
			ArrayList<staffinfo> staffinfo=new ArrayList<staffinfo>();			
			while(rs.next()){
				
				staffinfo ru=new staffinfo();
				ru.setStaffid(rs.getString("staffid"));
				ru.setName(rs.getString("name"));
				staffinfo.add(ru);				
			}
			DBUtil.closeAll(conn, ps, rs);	
			return staffinfo;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	
	
	
	
	//对stafftable表的操作
	public staff selectStaff(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from stafftable where staffid=?");
			ps.setString(1,staffid);
			
            ResultSet rs = ps.executeQuery();
			
            staff ru=new staff();
			if(rs.next()){
				
				ru.setStaffid(rs.getString("staffid"));
				dept d=new dept();
				d.setDeptid(rs.getString("deptid"));
				ru.setDept(d);
				ru.setSlevel(rs.getString("slevel"));
				DBUtil.closeAll(conn, ps, rs);
				return ru;
			}
			return null;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	public int updateStaff(staff staff){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("update stafftable set deptid=?,slevel=? where staffid=?");
		
			ps.setString(1,staff.getDept().getDeptid());
			ps.setString(2,staff.getSlevel());
			ps.setString(3,staff.getStaffid());
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		    return 0;
	}
	
	public ArrayList<staff> selectStaffId(String deptid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select * from stafftable where deptid=?");
			ps.setString(1,deptid);
			ResultSet rs = ps.executeQuery();
			ArrayList<staff> staffs=new ArrayList<staff>();
			while(rs.next()){
				staff ru=new staff();
				ru.setStaffid(rs.getString("staffid"));
				dept d=new dept();
				d.setDeptid(rs.getString("deptid"));
				ru.setDept(d);
				ru.setSlevel(rs.getString("slevel"));
				staffs.add(ru);
			}
			DBUtil.closeAll(conn, ps, rs);	
			return staffs;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
