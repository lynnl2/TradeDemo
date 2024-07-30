package com.tk.inter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

import com.tk.entity.TradeExecution;

public class TradeEntryPoint {

	public static void main(String[] args) {

		ConcurrentHashMap<String, List<TradeExecution>> map = new ConcurrentHashMap<String, List<TradeExecution>>();
		List<TradeExecution> executions = initInx();
		if (executions != null && executions.size() > 0) {

			// better use thread pool
			CountDownLatch cntLatch = new CountDownLatch(executions.size());
			for (TradeExecution trade : executions) {
				Thread thread = new Thread(new GroupTool(cntLatch, map, trade));
				thread.start();
			}
			try {
				cntLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// better split the list and execution calculation per batch

			ConcurrentHashMap<String, Long> mapResult = new ConcurrentHashMap<String, Long>();
			CountDownLatch cntLatch2 = new CountDownLatch(map.size());

			for (String key : map.keySet()) {
				Thread thread = new Thread(new CalculationGroup(cntLatch2, mapResult, map.get(key)));
				thread.start();
			}

			try {
				cntLatch2.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String key : mapResult.keySet()) {
				System.out.println(key + ":" + mapResult.get(key));
			}
		}

	}

	public static List<TradeExecution> initInx() {
		List<String> executionStr = initInput();
		
		List<TradeExecution> executions = new ArrayList<>();
		executionStr.stream().forEach(tmp ->{
			TradeExecution  tradeExecution =  TradeDescConvert.getProduct(tmp);
			if(tradeExecution!= null) {
				executions.add(tradeExecution);
			}
		});

		return executions;

	}
	
	public static List<String> initInput() {
		List<String> executions = new ArrayList<>();
		executions.add("1, 1, 1,REL, 50, INSERT, Buy");
		executions.add("2, 2, 1,ITC, 40, INSERT, Sel");
		executions.add("3, 3, 1, INF, 70, INSERT, Buy");
		executions.add("4, 1, 2, REL, 60, UPDATE, Buy");
		executions.add("5, 2, 2, ITC, 30, CANCEL, Buy");
		executions.add("6, 4, 1, INF, 20, INSERT, Sell");

		return executions;

	}
	
	

}
