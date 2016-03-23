package com.meng.coding;


/**
 * 
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2].

**/

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
