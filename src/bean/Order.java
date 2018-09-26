package bean;

import java.sql.Timestamp;

public class Order {
	private int carId;
	private int userId;
	private String orderId;
	private int ordertype;
	private Timestamp orderData;
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(int ordertype) {
		this.ordertype = ordertype;
	}
	public Timestamp getOrderData() {
		return orderData;
	}
	public void setOrderData(Timestamp orderData) {
		this.orderData = orderData;
	}
	
}
