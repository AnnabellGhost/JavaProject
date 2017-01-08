package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBUtil;
import entity.off;
import entity.salary;

public class OffDao {

	public int insertOff(off off){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement
			("insert into off(offid,staffid,year,month,day,type,note) values(?,?,?,?,?,?,?)");
			ps.setString(1,off.getOffid());
			ps.setString(2,off.getStaffid());
			ps.setInt(3,off.getYear());
			ps.setInt(4,off.getMonth());
			ps.setInt(5,off.getDay());
			ps.setString(6,off.getType());
			ps.setString(7,off.getNote());
			int i = ps.executeUpdate();
			conn.commit();
			DBUtil.closeAll(conn, ps, null);
			
			return i;
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			return 0;
	}
	
	public ArrayList<off> selectAllOff(){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from off");
			ResultSet rs=ps.executeQuery();
			ArrayList<off> alloff=new ArrayList<off>();			
			while(rs.next()){
				off p=new off();
				p.setOffid(rs.getString("offid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setDay(rs.getInt("day"));
				p.setType(rs.getString("type"));
				p.setNote(rs.getString("note"));
				alloff.add(p);				
			}		
			DBUtil.closeAll(conn, ps, rs);	
			return alloff;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return null;
	}
	
	
	public ArrayList<off> selectAllOffByOption(off off){
		Connection conn=DBUtil.getConnection();
		try {
			String sql="select * from off where 1=1";
			if(off.getYear()!=0){
				sql = sql + " and year = ?";
			}
			if(off.getMonth()!=0){
				sql = sql + " and month = ?";
			}
			if(off.getDay()!=0){
				sql = sql + " and day = ?";
			}
			PreparedStatement ps=conn.prepareStatement(sql);
			if((off.getYear()==0)&&(off.getMonth()==0)&&(off.getDay()==0)){
				
			}
			
			if((off.getYear()!=0)&&(off.getMonth()==0) && (off.getDay()==0)){
				ps.setInt(1, off.getYear());
			}
			
			if((off.getYear()==0)&&(off.getMonth()!=0) && (off.getDay()==0)){
				ps.setInt(1, off.getMonth());
			}
			
			if((off.getYear()==0)&&(off.getMonth()==0) && (off.getDay()!=0)){
				ps.setInt(1, off.getDay());
			}
			
			if((off.getYear()!=0)&&(off.getMonth()!=0) && (off.getDay()==0)){
				ps.setInt(1, off.getYear());
				ps.setInt(2, off.getMonth());
			}
			
			if((off.getYear()!=0)&&(off.getMonth()==0) && (off.getDay()!=0)){
				ps.setInt(1, off.getYear());
			    ps.setInt(2, off.getDay());
			}
			
			if((off.getYear()==0)&&(off.getMonth()!=0) && (off.getDay()!=0)){
			
				ps.setInt(1, off.getMonth());
				ps.setInt(2, off.getDay());
			}
			
			if((off.getYear()!=0)&&(off.getMonth()!=0) && (off.getDay()!=0)){
				ps.setInt(1, off.getYear());
				ps.setInt(2, off.getMonth());
				ps.setInt(3, off.getDay());
				
			}
			System.out.println(sql);
			ResultSet rs=ps.executeQuery();
			ArrayList<off> alloff=new ArrayList<off>();			
			while(rs.next()){
				off p=new off();
				p.setOffid(rs.getString("offid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setDay(rs.getInt("day"));
				p.setType(rs.getString("type"));
				p.setNote(rs.getString("note"));
				alloff.add(p);				
			}		
			DBUtil.closeAll(conn, ps, rs);	
			return alloff;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return null;
	}
	
	public ArrayList<off> selectOffByStaffid(String staffid){
		Connection conn=DBUtil.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from off where staffid=?");
			ps.setString(1,staffid);
			ResultSet rs=ps.executeQuery();
			ArrayList<off> alloff=new ArrayList<off>();			
			while(rs.next()){
				off p=new off();
				p.setOffid(rs.getString("offid"));
				p.setStaffid(rs.getString("staffid"));
				p.setYear(rs.getInt("year"));
				p.setMonth(rs.getInt("month"));
				p.setDay(rs.getInt("day"));
				p.setType(rs.getString("type"));
				p.setNote(rs.getString("note"));
				alloff.add(p);				
			}		
			DBUtil.closeAll(conn, ps, rs);	
			return alloff;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
