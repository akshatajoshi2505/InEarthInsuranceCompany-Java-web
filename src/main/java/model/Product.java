package model;


public class Product {
	
	private int productid;
    private String serialNo;
    private String productName;
    private String purchaseDate;
    private int userId;
    
    public Product() {
		super();
	}
    
	public Product(String serialNo, String productName, String purchaseDate, int userId) {
		super();
		this.serialNo = serialNo;
		this.productName = productName;
		this.purchaseDate = purchaseDate;
		this.userId = userId;
	}

	public int getProductid() {
		return productid;
	}
	
	public void setProductid(int productid) {
		this.productid = productid;
	}
	
	public String getSerialNo() {
		return serialNo;
	}
	
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", serialNo=" + serialNo + ", productName=" + productName
				+ ", purchaseDate=" + purchaseDate + ", userId=" + userId + "]";
	}    
}
