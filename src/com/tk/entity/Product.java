package com.tk.entity;

public class Product {
	
//	private long id;
	
//	private long tradeId;
//	private long version;
	private String product;
	private long postion;
//	private Action string;
//	public long getTradeId() {
//		return tradeId;
//	}
//	public void setTradeId(long tradeId) {
//		this.tradeId = tradeId;
//	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	
	
	public long getPostion() {
		return postion;
	}
	public void setPostion(long postion) {
		this.postion = postion;
	}
	public Product(String product, long position) {
		this.product = product;
		this.postion =position;
		// TODO Auto-generated constructor stub
	}
	
//	private String direction;
	

}
