package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import entity.off;
import entity.salary;


public class SalaryDao {
	public String getlevel(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select slevel from stafftable where staffid=?");
			ps.setString(1, staffid);
			ResultSet rs=ps.executeQuery();
			String level=new String();
			while(rs.next()){
				level=rs.getString("slevel");
			}
			return level;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public int insertSalary(salary sal){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("insert into salary(salaryid,staffid,year,month,salary) values(?,?,?,?,?)");
			ps.setString(1,sal.getSalaryid());
			ps.setString(2,sal.getStaffid());
			ps.setInt(3,sal.getYear());
			ps.setInt(4,sal.getMonth());
			ps.setDouble(5,sal.getSalary());
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}
	
	public ArrayList<salary> selectAllSalary(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from salary");
			ResultSet rs=ps.executeQuery();
			ArrayList<salary> allsalary=new ArrayList<salary>();			
			while(rs.next()){
				salary p=new salary();
				p.setSalaryid(rs.getString("salaryid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setSalary(rs.getDouble("salary"));
				allsalary.add(p);				
			}			
			DBUtil.closeAll(conn, ps, rs);	
			return allsalary;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	
	public ArrayList<salary> selectAllSalaryByOption(salary sal){
		Connection conn=DBUtil.getConnection();
		try {
			String sql="select * from salary where 1=1";
			if(sal.getYear()!=0){
				sql = sql + " and year = ?";
			}
			if(sal.getMonth()!=0){
				sql = sql + " and month = ?";
			}
			if(!sal.getStaffid().equals("")){
				sql = sql + " and staffid = ?";
			}
			PreparedStatement ps=conn.prepareStatement(sql);
			if((sal.getYear()==0)&&(sal.getMonth()==0)&&(sal.getStaffid().equals(""))){
				
			}
			
			if((sal.getYear()!=0)&&(sal.getMonth()==0) && (sal.getStaffid().equals(""))){
				ps.setInt(1, sal.getYear());
			}
			
			if((sal.getYear()==0)&&(sal.getMonth()!=0) && (sal.getStaffid().equals(""))){
				ps.setInt(1, sal.getMonth());
			}
			
			if((sal.getYear()==0)&&(sal.getMonth()==0) && (!sal.getStaffid().equals(""))){
				ps.setString(1, sal.getStaffid());
			}
			
			if((sal.getYear()!=0)&&(sal.getMonth()!=0) && (sal.getStaffid().equals(""))){
				ps.setInt(1, sal.getYear());
				ps.setInt(2, sal.getMonth());
			}
			
			if((sal.getYear()!=0)&&(sal.getMonth()==0) && (!sal.getStaffid().equals(""))){
				ps.setInt(1, sal.getYear());
			    ps.setString(2, sal.getStaffid());
			}
			
			if((sal.getYear()==0)&&(sal.getMonth()!=0) && (!sal.getStaffid().equals(""))){
			
				ps.setInt(1, sal.getMonth());
				ps.setString(2, sal.getStaffid());
			}
			
			if((sal.getYear()!=0)&&(sal.getMonth()!=0) && (!sal.getStaffid().equals(""))){
				ps.setInt(1, sal.getYear());
				ps.setInt(2, sal.getMonth());
				ps.setString(3, sal.getStaffid());
				
			}
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<salary> allsalary=new ArrayList<salary>();			
			while(rs.next()){
				salary p=new salary();
				p.setSalaryid(rs.getString("salaryid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setSalary(rs.getDouble("salary"));
				allsalary.add(p);	
			}		
			DBUtil.closeAll(conn, ps, rs);	
			return allsalary;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
		
	}
	
	public int countSickOff(salary sal){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select count (*) from off where type='sick' and staffid=? and year=? and month=?");
			ps.setString(1,sal.getStaffid());
			ps.setInt(2,sal.getYear());
			ps.setInt(3,sal.getMonth());
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next()){
				i=rs.getInt("count(*)");
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int countAbsenceOff(salary sal){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("select count (*) from off where type='absence' and staffid=? and year=? and month=?");
			ps.setString(1,sal.getStaffid());
			ps.setInt(2,sal.getYear());
			ps.setInt(3,sal.getMonth());
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next()){
				i=rs.getInt("count(*)");
			}
			return i;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<salary> selectSalaryByStaffid(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from salary where staffid=?");
			ps.setString(1, staffid);
			ResultSet rs=ps.executeQuery();
			ArrayList<salary> allsalary=new ArrayList<salary>();			
			while(rs.next()){
				salary p=new salary();
				p.setSalaryid(rs.getString("salaryid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setSalary(rs.getDouble("salary"));
				allsalary.add(p);				
			}			
			DBUtil.closeAll(conn, ps, rs);	
			return allsalary;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return null;
	}
	
	
	
	
	
	
	
	
	
}
