package com.meng.coding;

import java.util.Deque;
import java.util.LinkedList;

public class SlideWindowBuyAndSellStock {

	public static void main(String[] args) {
		int[] price = {1, 5, 0, 7, 5, 10, 9, 19, 0};
		System.out.println(slideWindowMaxProfit(price, 3));
	}
	
	public static int slideWindowMaxProfit(int[] price, int l) {
		int max = 0;
		if (price.length == 0 || l == 0) return max;
		Deque<Integer> deque = new LinkedList<>();
		deque.add(0);
		for (int i = 1; i < price.length; i++) {
			if (i - deque.peekFirst() == l) {
				deque.removeFirst();
			}
			while (!deque.isEmpty() && price[i] <= price[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.add(i);
			max = Math.max(max, price[i] - price[deque.peekFirst()]);
		}
		return max;
	}

}
