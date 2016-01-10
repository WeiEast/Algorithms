package leetCode.Medium.Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	
	Subscribe to see which companies asked this question
	
	原理太简单了 , 贪心算法
 *
 */
public class J122BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int dp = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				dp = (prices[i] - prices[i - 1]) + dp;
			}
		}
		return dp;

	}

	public static void main(String[] args) {
		J122BestTimetoBuyandSellStockII j = new J122BestTimetoBuyandSellStockII();
		System.out.println(j.maxProfit(new int[] { 2, 1, 1, 3, 4, 5, 6, 1, 3, 4 }));
	}
}
