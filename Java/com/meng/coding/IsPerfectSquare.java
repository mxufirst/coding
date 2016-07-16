package com.meng.coding;

public class IsPerfectSquare
{

	public static void main(String[] args)
	{
		System.out.println(isPerfectSquare(808201));
	}
	
	public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int r = num/2;
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (num/mid == mid) {
                return num % mid == 0;
            } else if (mid < num/mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }

}
