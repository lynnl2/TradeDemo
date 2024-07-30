package com.tk.entity;

import java.math.BigDecimal;

public class TradeExecution {

	private long id;

	private long tradeId;
	private long version;
	private String product;
	private long quantity;
	private String action;

	private String direction;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public TradeExecution(long id,

			long tradeId, long version, String product, long quantity, String action, String direction) {

		this.action = action;
		this.tradeId = tradeId;
		this.version = version;
		this.quantity = quantity;
		this.direction = direction;
		this.product = product;

	}
	
	public TradeExecution() {

	}

}
