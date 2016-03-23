package com.meng.coding;

public class CountBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            dp[i] = dp[i / 2] + (i & 1);
        }
        return dp;
    }

}
