package vendre.bean;

import java.sql.Date;

public class OrderItems {
//id , kart_id , product_id , status
	private String id;
	private String kartId;
	private String productId;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKartId() {
		return kartId;
	}
	public void setKartId(String kartId) {
		this.kartId = kartId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
}
