package com.meng.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum > 0) k--;
				else if (sum < 0) j++;
				else {
					List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
					ans.add(list);
					do {j++;} while (j < k && nums[j] == nums[j - 1]);
					do {k--;} while (j < k && nums[k] == nums[k + 1]);
				}
			}
			do {i++;} while (j < k && nums[i] == nums[i - 1]);
		}
		return ans;
	}

}
