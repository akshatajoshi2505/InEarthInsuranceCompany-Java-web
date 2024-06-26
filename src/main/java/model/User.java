package model;

public class User {
	
	private int userid;
    private String username;
    private String password;
    private String name;
    private String address;
    private String email;
    private String cellphone;
    
	public User() {
		super();
	}

	public User(int userid, String username, String password, String name, String address, String email,
			String cellphone) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.cellphone = cellphone;
	}

	public User(String username, String password, String name, String address, String email, String cellphone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.address = address;
		this.email = email;
		this.cellphone = cellphone;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", address=" + address + ", email=" + email + ", cellphone=" + cellphone + "]";
	}
}
