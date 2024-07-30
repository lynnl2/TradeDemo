package com.tk.inter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.tk.entity.CalculationUtils;
import com.tk.entity.TradeExecution;

public class CalculationGroup implements Runnable {

	private CountDownLatch countDownLatch;
	private ConcurrentHashMap<String, Long> map;
	private List<TradeExecution> trades;

	public CalculationGroup(CountDownLatch countDownLatch, ConcurrentHashMap<String, Long> map,
			List<TradeExecution> trades) {
		this.countDownLatch = countDownLatch;
		this.map = map;
		this.trades = trades;
	}

	@Override
	public void run() {
		long amount = 0;
		String product = "";
		for (TradeExecution tradeExecution : trades) {
			amount = CalculationUtils.getCalResult(tradeExecution.getAction(), tradeExecution.getDirection(), amount,
					tradeExecution.getQuantity());
			product = tradeExecution.getProduct();
		}
		if(amount > 0) {
			map.put(product, amount);
		}
		
		countDownLatch.countDown();

	}

}
