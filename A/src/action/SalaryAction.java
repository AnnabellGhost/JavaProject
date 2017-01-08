package action;

import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import common.CreateId;
import dao.OffDao;
import dao.SalaryDao;
import entity.off;
import entity.salary;
import entity.staffinfo;

public class SalaryAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	private staffinfo staffinfo = new staffinfo();
	private salary sal=new salary();
	private ArrayList<salary> allsalary;
	
	public ArrayList<salary> getAllsalary() {
		return allsalary;
	}

	public void setAllsalary(ArrayList<salary> allsalary) {
		this.allsalary = allsalary;
	}

	public staffinfo getStaffinfo() {
		return staffinfo;
	}

	public void setStaffinfo(staffinfo staffinfo) {
		this.staffinfo = staffinfo;
	}

	public salary getSal() {
		return sal;
	}

	public void setSal(salary sal) {
		this.sal = sal;
	}

	

	
	public String preInsertSal(){
		sal.setSalaryid("w"+CreateId.getId());
		sal.setStaffid(staffinfo.getStaffid());
		
		return SUCCESS;
	}
	
	
	
	
	public String calculateSalary(){
		SalaryDao dao=new SalaryDao();
		String level=dao.getlevel(sal.getStaffid());
		if(level.equals("intern")){
			sal.setSalary(2000);
		}
		else if(level.equals("staff")){
			sal.setSalary(2800);
		}else{
			sal.setSalary(1000);
		}
		int l=dao.countAbsenceOff(sal);
		int i=dao.countSickOff(sal);
		sal.setSalary(sal.getSalary()-(i*20)-(l*30));
		this.setSal(sal);
		return SUCCESS;
	}
	
	public String insertSalary(){
		SalaryDao dao = new SalaryDao();
		int i = dao.insertSalary(sal);
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "add salary error!");
		return "insertsalaryerror";
	}
	public String getAllSalary(){
		SalaryDao dao = new SalaryDao();
		ArrayList<salary> alls=dao.selectAllSalary();
		this.setAllsalary(alls);
		return SUCCESS;
	}
	public String getAllSalaryByOption(){
		SalaryDao dao = new SalaryDao();
		ArrayList<salary> allsalary =dao.selectAllSalaryByOption(sal);
		this.setAllsalary(allsalary);
		return SUCCESS;
	}
	public String getSalaryByStaffid(){
		SalaryDao dao = new SalaryDao();
		ArrayList<salary> allsalary =dao.selectSalaryByStaffid(sal.getStaffid());
		this.setAllsalary(allsalary);
		return SUCCESS;
	}

}




