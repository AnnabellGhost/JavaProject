package action;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import common.CreateId;
import common.DBUtil;



import dao.StaffDao;



import entity.dept;
import entity.staff;
import entity.staffinfo;



public class StaffAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private staff staff=new staff();
	private dept dept=new dept();
	private staffinfo staffinfo=new staffinfo();
	private ArrayList<staff> staffs=new ArrayList<staff>();
	private ArrayList<staffinfo> staffinfos=new ArrayList<staffinfo>();
	
	public dept getDept() {
		return dept;
	}

	public void setDept(dept dept) {
		this.dept = dept;
	}

	public staffinfo getStaffinfo() {
		return staffinfo;
	}

	public void setStaffinfo(staffinfo staffinfo) {
		this.staffinfo = staffinfo;
	}

	public ArrayList<staffinfo> getStaffinfos() {
		return staffinfos;
	}

	public void setStaffinfos(ArrayList<staffinfo> staffinfos) {
		this.staffinfos = staffinfos;
	}

	public Map<String, Object> getSession() {
		return session;
	}

    public void setSession(Map<String, Object> session) {
		this.session = session;
	}

    public staff getStaff() {
		return staff;
	}
    public void setStaff(staff staff) {
		this.staff = staff;
	}
    public ArrayList<staff> getStaffs() {
		return staffs;
	}
    public void setStaffs(ArrayList<staff> staffs) {
		this.staffs = staffs;
	}


     public String selectPartStaffinfo(){
		
		StaffDao dao = new StaffDao();
		ArrayList<staffinfo> staffinfos=dao.selectPartStaffinfo();
		this.setStaffinfos(staffinfos);
		return SUCCESS;
	}


    public String selectAllStaffinfo(){
		
		StaffDao dao = new StaffDao();
		ArrayList<staffinfo> staffinfos=dao.selectAllStaffinfo();
		this.setStaffinfos(staffinfos);
		return SUCCESS;
	}
    
    public String selectStaffinfo(){
		StaffDao dao = new StaffDao();
		staffinfo s=dao.selectStaffinfo(staffinfo.getStaffid());
		this.setStaffinfo(s);
		return SUCCESS;
	}
    
    public String updateStaffinfo(){
    	StaffDao dao = new StaffDao();
    	upload();
    	int i = dao.updateStaffinfo(staffinfo);
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "update staff error!");
		return "updatestaffinfoerror";
	}
    public String upload() {
		String realpath = ServletActionContext.getServletContext().getRealPath(
				"/files");
		File file = new File(realpath);
		if (!file.exists()) {
			file.mkdirs();
		}
		try {
			//把上传的文件名加上17位时间id后。服务器端保存的文件名
			staffinfo.setUploadImageFileName
				(CreateId.getId()+staffinfo.getUploadImageFileName());
			//把上传到服务器端的临时文件拷贝到服务器对应的目录下面
			FileUtils.copyFile
				(staffinfo.getUploadImage(), new File(file, staffinfo.getUploadImageFileName()));
			//设置数据库中保存的文件路径(服务器端路径)
			staffinfo.setImage(realpath+"\\"+staffinfo.getUploadImageFileName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
    
    
    
    
    
    
    
    //对staff的操作 这个是根据showallstuff.jsp页面里的staffid来在staff表里找到deptid和slevel
    public String selectStaff(){
		StaffDao dao = new StaffDao();
		staff s=dao.selectStaff(staff.getStaffid());
		this.setStaff(s);
		return SUCCESS;
	}
    
    public String updateStaff(){
    	StaffDao dao = new StaffDao();
    	//upload();
    	int i = dao.updateStaff(staff);
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "update staff error!");
		return "updatestafferror";
	}
    
    public String selectStaffInfoByDeptid(){
    	StaffDao dao = new StaffDao();
    	staffs=dao.selectStaffId(dept.getDeptid());
    	
    	for(staff e:staffs){
    		staffinfo=dao.selectStaffinfo(e.getStaffid());
    		staffinfos.add(staffinfo);
    	}
    	this.setStaffinfos(staffinfos);
    	return SUCCESS;
    }
    
    
    
    
}
