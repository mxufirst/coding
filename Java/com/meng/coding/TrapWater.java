package com.meng.coding;

public class TrapWater {

	public static void main(String[] args) {
		int[] A = {3,1,5,1,7,0,4};
		System.out.println(trapWater(A));

	}
	
	public static int trapWater(int[] A) {
		int w = 0;
		int l = 0, r = A.length - 1;
		int lh = A[l], rh = A[r];
		while (l < r) {
			if (lh <= rh) {
				w += lh;
				l++;
				lh = Math.max(lh, A[l]);
				
			} else {
				w += rh;
				r--;
				rh = Math.max(rh, A[r]);
			}
		}
		return w;
	}

}
