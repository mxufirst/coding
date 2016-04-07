package com.meng.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

	public static void main(String[] args) {
		generateParenthesis(5).stream().forEach(System.out::println);

	}
	
	public static List<String> generateParenthesis(int n) {
        List<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>(Arrays.asList(""));
        dp[1] = new ArrayList<>(Arrays.asList("()"));
        for (int i = 2; i <= n; i++) {
        	dp[i] = new ArrayList<>();
        	for (int j = 0; j < i; j++) {
        		for (String l : dp[j]) {
        			for (String r : dp[i - 1 -j]){
        				dp[i].add("(" + l + ")" + r);
        			}
        		}
        	}
        }
        return dp[n];
    }

}
