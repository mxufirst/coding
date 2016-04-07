package com.meng.coding;

import java.util.Arrays;

public class TriangleCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int triangleCount(int S[]) {
        int n = S.length;
        Arrays.sort(S);
        int count = 0;
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (S[l] + S[r] > S[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }

}
