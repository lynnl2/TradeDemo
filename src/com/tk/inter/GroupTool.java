package com.tk.inter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.tk.entity.TradeExecution;

public class GroupTool implements Runnable {
	
	
	private CountDownLatch countDownLatch;
	private ConcurrentHashMap<String, List<TradeExecution>> map;
	private TradeExecution trade;
	
	public GroupTool(CountDownLatch countDownLatch, ConcurrentHashMap<String, 
			List<TradeExecution>> map,
			TradeExecution trade) {
		this.countDownLatch = countDownLatch;
		this.map = map;
		this.trade = trade;
	}

	@Override
	public void run() {
		String product = trade.getProduct();
		
		// sync
		if(map.containsKey(product)) {
			map.get(product).add(trade);
		}else {
			List<TradeExecution> list =  new ArrayList<TradeExecution>();
			list.add(trade);
			map.put(product, list);
		}
		countDownLatch.countDown();
		
	}

	public CountDownLatch getCountDownLatch() {
		return countDownLatch;
	}

	public void setCountDownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public ConcurrentHashMap<String, List<TradeExecution>> getMap() {
		return map;
	}

	public void setMap(ConcurrentHashMap<String, List<TradeExecution>> map) {
		this.map = map;
	}
	
	

}
