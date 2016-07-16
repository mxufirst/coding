package com.meng.coding;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SeperateChar
{

	public static void main(String[] args)
	{
		SeperateChar sc = new SeperateChar();
		System.out.println("rearranged:"+sc.rearrangeString("aabbcc", 3));

	}
	
	public String rearrangeString(String str, int k) {
        int n = str.length();
        if (k == 0) {
        	return str;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
        	char ch = str.charAt(i);
        	if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
        	else map.put(ch, 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(Comparator.comparing(Map.Entry<Character, Integer>::getValue).thenComparing(Map.Entry<Character, Integer>::getKey).reversed());
        heap.addAll(map.entrySet());
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
        	if (queue.size() < k) {
        		Map.Entry<Character, Integer> entry = heap.poll();
        		if (entry.getValue() > 0) {
        			entry.setValue(entry.getValue() - 1);
        			sb.append(entry.getKey());
            		queue.offer(entry);
        		}
        	} else {
        		Map.Entry<Character, Integer> entry = queue.poll();
        		if (entry.getValue() > 0) {
        			heap.offer(entry);
        		}
        	}
        }
        System.out.println(sb.toString());
        return sb.length() == str.length() ? sb.toString() : "";
    }

}
