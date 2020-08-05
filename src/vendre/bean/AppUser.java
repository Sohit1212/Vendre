package vendre.bean;

public class AppUser {
// id, email , pass, user_name, phone_no , address , s_que, s_ans, role,status	
	private String id;
	private String email;
	private String pass;
	private String userName;
	private String phoneNo;
	private String address;
	private String sque;
	private String sans;
	private String role;
	private String status;
	
	public boolean isAdmin(){
		return role!=null && "Admin".equalsIgnoreCase(role);
	}
	public boolean isSeller(){
		return role!=null && "Seller".equalsIgnoreCase(role);
	}
	public boolean isBuyer(){
		return role!=null && "Buyer".equalsIgnoreCase(role);
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSque() {
		return sque;
	}
	public void setSque(String sque) {
		this.sque = sque;
	}
	public String getSans() {
		return sans;
	}
	public void setSans(String sans) {
		this.sans = sans;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
