package com.meng.coding;

public class CoinInLine2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n < 3) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }
        int[] dp = new int[n];
        dp[n - 1] = values[n - 1];
        dp[n - 2] = values[n - 1] + values[n - 2];
        dp[0] = search(values, 0, dp);
        return dp[0] > sum / 2;
    }
    private int search(int[] values, int i, int[] dp) {
        if (i >= dp.length) return 0;
        if (dp[i] > 0) {
            return dp[i];
        }
        dp[i] = values[i] + Math.max(Math.min(search(values, i + 2, dp), search(values, i + 3, dp)), Math.min(search(values, i + 3, dp), search(values, i + 4, dp)) + values[i + 1]);
        return dp[i];
    }

}
