package model;


public class Claim {
	
	private int claimid;
    private String dateOfClaim;
    private String description;
    private String status;
    private String productSerialNo;
    private int userid;
    
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Claim() {
		super();
	}

	public Claim(int claimid, String dateOfClaim, String description, String status, String productSerialNo) {
		super();
		this.claimid = claimid;
		this.dateOfClaim = dateOfClaim;
		this.description = description;
		this.status = status;
		this.productSerialNo = productSerialNo;
	}

	public int getClaimid() {
		return claimid;
	}
	
	public void setClaimid(int claimid) {
		this.claimid = claimid;
	}
	
	public String getDateOfClaim() {
		return dateOfClaim;
	}
	
	public void setDateOfClaim(String dateOfClaim) {
		this.dateOfClaim = dateOfClaim;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getProductSerialNo() {
		return productSerialNo;
	}
	
	public void setProductSerialNo(String productSerialNo) {
		this.productSerialNo = productSerialNo;
	}

	@Override
	public String toString() {
		return "Claim [claimid=" + claimid + ", dateOfClaim=" + dateOfClaim + ", description=" + description
				+ ", status=" + status + ", productSerialNo=" + productSerialNo + "]";
	}
    
}
