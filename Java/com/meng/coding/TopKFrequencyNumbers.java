package com.meng.coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKFrequencyNumbers
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public List<Integer> topKFrequent(int[] nums, int k) {
		
		
		Map<Integer, Integer> map =  new HashMap<>();
		
		Arrays.stream(nums).forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
		
		return map.entrySet().stream()
		                .sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue()))
		                .limit(k)
		                .map(e -> e.getKey())
		                .collect(Collectors.toList());
        
        
    }

}
