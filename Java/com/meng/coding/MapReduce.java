package com.meng.coding;

import java.util.Arrays;
import java.util.List;

public class MapReduce {

	public static void main(String[] args) {
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		double total = 0; 
		for (Integer cost : costBeforeTax) { 
			double price = cost + .12*cost; total = total + price; 
			} 
		System.out.println("Total : " + total); 
		
		
		double bill = costBeforeTax.stream().mapToDouble((cost) -> cost + .12*cost).sum(); 
		System.out.println("Total : " + bill);
	}
}
