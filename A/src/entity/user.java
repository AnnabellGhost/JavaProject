package entity;

public class user {

	private String staffid;
	private String username;
	private String password;
	private String status;
	private String role;
	private int wrongnum;
	public String getStaffid() {
		return staffid;
	}
	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getWrongnum() {
		return wrongnum;
	}
	public void setWrongnum(int wrongnum) {
		this.wrongnum = wrongnum;
	}
	
}
