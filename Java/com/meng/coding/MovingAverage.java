package com.meng.coding;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> queue = new LinkedList<>();
    private int size;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
    	queue.add(val);
        sum += val;
        if(queue.size() > size) {
        	sum -= queue.remove();
        }
        return sum/queue.size();
    }
}

