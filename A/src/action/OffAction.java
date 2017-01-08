package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import common.CreateId;
import dao.OffDao;
import entity.off;
import entity.staffinfo;

public class OffAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;
	private off off=new off();
	private staffinfo staffinfo = new staffinfo();
	private ArrayList<off> alloff;
	public ArrayList<off> getAlloff() {
		return alloff;
	}
	public void setAlloff(ArrayList<off> alloff) {
		this.alloff = alloff;
	}
	public off getOff() {
		return off;
	}
    public void setOff(off off) {
		this.off = off;
	}
    public Map<String, Object> getSession() {
		return session;
	}
    public void setSession(Map<String, Object> session) {
		this.session = session;
	}
    public staffinfo getStaffinfo() {
		return staffinfo;
	}

	public void setStaffinfo(staffinfo staffinfo) {
		this.staffinfo = staffinfo;
	}
	
	
	
	public String preInsertOff(){
		off.setOffid("o"+CreateId.getId());
		off.setStaffid(staffinfo.getStaffid());
		
		return SUCCESS;
	}
	
	public String insertOff(){
		OffDao dao = new OffDao();
		int i = dao.insertOff(off);
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "add Off record error!");
		return "insertofferror";
	}
	
	public String getAllOff(){
		OffDao dao = new OffDao();
		ArrayList<off> alloff=dao.selectAllOff();
		this.setAlloff(alloff);
		return SUCCESS;
	}

	public String getAllOffByOption(){
		OffDao dao = new OffDao();
		ArrayList<off> alloff = dao.selectAllOffByOption(off);
		this.setAlloff(alloff);
		return SUCCESS;
	}
	
	public String getOffByStaffid(){
		OffDao dao = new OffDao();
		ArrayList<off> alloff =dao.selectOffByStaffid(off.getStaffid());
        this.setAlloff(alloff);
		return SUCCESS;
	}
}
