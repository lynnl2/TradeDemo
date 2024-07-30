package com.tk.inter;

import com.tk.entity.TradeExecution;

public class TradeDescConvert {
	
	/**
	 * Sample String: 1l, 1l, 1l, "REL", 50, "INSERT", "Buy"
	 * @return
	 */
	public static TradeExecution getProduct(String tradeDesc) {
		if(tradeDesc == null)return null;
		String[] tmp= tradeDesc.split(",");
		TradeExecution tradeExecution = new TradeExecution();
		try {
			tradeExecution.setId(Long.parseLong(tmp[0].trim()));
			tradeExecution.setTradeId(Long.parseLong(tmp[1].trim()));
			tradeExecution.setVersion(Long.parseLong(tmp[2].trim()));
			tradeExecution.setProduct(tmp[3].trim());
			tradeExecution.setQuantity(Long.parseLong(tmp[4].trim()));
			tradeExecution.setAction(tmp[5].trim());
			tradeExecution.setDirection(tmp[6].trim());
		} catch (Exception e) {
			System.out.println("Discard Invalid Trade:" + tradeDesc);
			return null;
		}
		return tradeExecution;
		
	}

}
