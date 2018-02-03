package com.demo.order.model;

public class Order {

	private int orderId;
	private String desc;
	private String orderName;
	private int custom_Id;
	
	public Order() {
		super();
	}

	public Order(int orderId, String desc, String orderName, int custom_Id) {
		super();
		this.orderId = orderId;
		this.desc = desc;
		this.orderName = orderName;
		this.custom_Id = custom_Id;
	}

	public int getCustom_Id() {
		return custom_Id;
	}

	public void setCustom_Id(int custom_Id) {
		this.custom_Id = custom_Id;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", desc=" + desc + ", orderName=" + orderName + ", custom_Id=" + custom_Id
				+ "]";
	}
	
}
