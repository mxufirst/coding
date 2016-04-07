package com.meng.coding;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] A = {0,0,0};
		System.out.println(threeSumClosest(A, 1));

	}
	
	public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (min > Math.abs(sum - target)){
                	min = Math.abs(sum - target);
                	ans = sum;
                }
                if (sum < target) j++;
                else if (sum > target) k--;
                else return sum;
            }
        }
        return ans;
    }

}
