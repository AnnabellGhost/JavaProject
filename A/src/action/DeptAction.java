package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.DeptDao;
import dao.StaffDao;
import entity.dept;
import entity.staff;


public class DeptAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private ArrayList<dept> depts=new ArrayList<dept>();
	private dept dept=new dept();
	public dept getDept() {
		return dept;
	}

	public void setDept(dept dept) {
		this.dept = dept;
	}

	public ArrayList<dept> getDepts() {
		return depts;
	}

	public void setDepts(ArrayList<dept> depts) {
		this.depts = depts;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
    public String selectAllDept(){
		
		DeptDao dao = new DeptDao();
		ArrayList<dept> depts=dao.selectAllDept();
		this.setDepts(depts);
		return SUCCESS;
	}
	//对dept的选择和更改。先选了某个才能改嘛。
    public String selectDept(){
    	DeptDao dao = new DeptDao();
		dept s=dao.selectDept(dept.getDeptid());
		this.setDept(s);
		return SUCCESS;
	}
	
    public String updateDept(){
    	DeptDao dao = new DeptDao();
    	int i = dao.updateDept(dept);
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "Update dept error!");
		return "updatedepterror";
	}
    
	
	
	
	
	
}
