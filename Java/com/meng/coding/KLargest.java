package com.meng.coding;

public class KLargest {

	public static void main(String[] args) {
		int[] A = {1, 5, 3, 2};
		System.out.println(getKLargest(A, 3));

	}
	
	public static int getKLargest(int[] A, int k) {
		int l = 0, r = A.length - 1;
		while (l <= r) {
			int ll = l + 1, rr = r;
			while (ll <= rr) {
				if (A[ll] >= A[l]) ll++;
				else if (A[rr] <= A[l]) rr--;
				else swap(A, ll++, rr--);
			}
			swap(A, l, rr);
			if (rr == k - 1) return A[rr];
			else if (ll > k - 1) {
				r = rr - 1;
			} else {
				l = rr + 1;
			}
		}
		return -1;
	}
	
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	} 

}
