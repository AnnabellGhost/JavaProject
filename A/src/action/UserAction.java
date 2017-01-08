package action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import common.CreateId;

import dao.UserDao;
import entity.user;

public class UserAction extends ActionSupport implements SessionAware{
	private user user=new user();
	private Map<String, Object> session;
	private ArrayList<user> users;
	
	public Map<String, Object> getSession() {
		return session;
	}
	
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}

	public user getUser() {
		return user;
	}

	public void setUser(user user) {
		this.user = user;
	}

	public ArrayList<user> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<user> users) {
		this.users = users;
	}
	//普通用户登录
	public String userLogin(){
		UserDao dao = new UserDao();
		user ru = dao.selectUserofMember(user);
		
		if(ru == null){ 
			this.addFieldError("invalid", "用户不存在在当前身份下");
			return "error";	
		}
		if (ru.getStatus().equals("0")) {
			this.addFieldError("invalid", "账户已经锁定，请联系管理员开锁");
			return "error";
		}
		if(!user.getPassword().equals(ru.getPassword())){
			int i=ru.getWrongnum();
			if(i==2){
				user uu=new user();
				uu.setStaffid(ru.getStaffid());
				uu.setStatus("0");
				uu.setWrongnum(3);
				dao.updateUserStatus(uu);
				this.addFieldError("invalid", "密码输入三次错误 已锁定账户");
			}else{
				user uu=new user();
				uu.setStaffid(ru.getStaffid());
				uu.setStatus("1");
				uu.setWrongnum(ru.getWrongnum()+1);
				dao.updateUserStatus(uu);	
			    this.addFieldError("invalid", "密码错误");		
			}
			
			return "error";	
		}
		session.put("userinfo", ru);
		return "success";
	}
	//管理员登录
	public String execute(){
		UserDao dao = new UserDao();
		user ru = dao.selectUserofAdmin(user);
		
		if(ru == null){ 
			this.addFieldError("invalid", "用户不存在在当前身份下");
			return "error";	
		}
		if (ru.getStatus().equals("0")) {
			this.addFieldError("invalid", "账户已经锁定，请联系管理员开锁");
			return "error";
		}
		if(!user.getPassword().equals(ru.getPassword())){
			int i=ru.getWrongnum();
			if(i==2){
				user uu=new user();
				uu.setStaffid(ru.getStaffid());
				uu.setStatus("0");
				uu.setWrongnum(3);
				dao.updateUserStatus(uu);
				this.addFieldError("invalid", "密码输入三次错误 已锁定账户");
			}else{
				user uu=new user();
				uu.setStaffid(ru.getStaffid());
				uu.setStatus("1");
				uu.setWrongnum(ru.getWrongnum()+1);
				dao.updateUserStatus(uu);	
			    this.addFieldError("invalid", "密码错误");		
			}
			return "error";	
		}
		session.put("userinfo", ru);
		return "success";
	}
	
	//查询所有用户的
	public String selectAllUser(){
		UserDao dao = new UserDao();
		ArrayList<user> alluser= dao.selectAllUser();
		this.setUsers(alluser);
		return SUCCESS;
	}
	
	public String userUnlock(){
		UserDao dao = new UserDao();
		user.setStatus("1");
		user.setWrongnum(0);
		dao.updateUserStatus(user);
		
		return SUCCESS;
	}
	
	public String preInsertUser(){
		user.setStaffid("s"+CreateId.getId());
		
		return SUCCESS;
	}
	
	public String checkUsername(){
		UserDao dao = new UserDao();
		user ru = dao.selectUser(user);
		
		if(ru == null){
			this.addFieldError("msg", "name ok");
			return SUCCESS;
		}
		
		user.setUsername("");
		this.addFieldError("msg", "name existed!");
		return "checkerror";
	}
	
	public String insertUser(){
		
		user.setWrongnum(0);
		UserDao dao = new UserDao();
		int i = dao.insertUser(user);
		
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "add user error!");
		return "insertusererror";
		
	}
	
	public String deleteUser(){
		UserDao dao = new UserDao();
		
		int i = dao.deletUserByStaffid(user.getStaffid());
		
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "delete user error!");
		return "deleteusererror";
	}
	
	public String selectUserByStaffid(){
		UserDao dao = new UserDao();
		user ru = dao.selectUserByStaffid(user.getStaffid());
		this.setUser(ru);
		
		return SUCCESS;
	}
	
	public String updateUser(){
		UserDao dao = new UserDao();
		
		int i = dao.updateUserInfo(user);
		
		if(i > 0){
			return SUCCESS;
		}
		this.addFieldError("msg", "update user error!");
		return "updateusererror";
	}

	public String logoff(){
		session.remove("userinfo");
		return SUCCESS;
	}
}
