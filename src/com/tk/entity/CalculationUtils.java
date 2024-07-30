package com.tk.entity;

public class CalculationUtils {
	
public static final String IDX_INSERT = "INSERT";
	
	public static final String IDX_UPDATE = "UPDATE";
	
	public static  final String IDX_SELL = "Sell";
	
	public static final String IDX_BUY = "Buy";
	
	public static final String IDX_CANCEL = "CANCEL";
	
	//factory can be extracted to diff class
	
	public static long getCalResult(String idx, String direction,long previous, long currentamount) {
		switch (idx) {
		case IDX_INSERT:
			if(IDX_SELL.equals(direction)) return getInsertAndSell(previous, currentamount);
			if(IDX_BUY.equals(direction)) return getInsertAndBuy(previous, currentamount);
		case IDX_UPDATE:
			return getUpdate(currentamount);
		case IDX_CANCEL:
			return Long.MIN_VALUE;
		default:
			return Long.MAX_VALUE;
		}
	}
	
	
	public static long getInsertAndBuy( long previous,long amount) {
		return previous+amount;
	
	}

public static long getInsertAndSell(long previous, long amount) {
return previous-amount;

}

public static long getUpdate(long amount) {
return amount;
}

public static long cancel() {
return 0;


}


	

}
