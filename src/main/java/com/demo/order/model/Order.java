package com.demo.order.model;

//@Entity
//@Table(name = "order")
public class Order {
//	 @Id
//	 @GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private String desc;
	private int Custom_Id;
	
	
	public Order() {
		super();
	}

	public Order(int orderId, String desc, int custom_Id) {
		super();
		this.orderId = orderId;
		this.desc = desc;
		Custom_Id = custom_Id;
	}


	public int getCustom_Id() {
		return Custom_Id;
	}

	public void setCustom_Id(int custom_Id) {
		Custom_Id = custom_Id;
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

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", desc=" + desc + ", Custom_Id=" + Custom_Id + "]";
	}
	
}
