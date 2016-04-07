package com.meng.coding;

import java.util.ArrayList;

public class IntervalMiniNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Interval {
		int start;
		int end;
	}
	
	class SegmentTreeNode {
        int start;
        int end;
        int min;
        SegmentTreeNode left;
        SegmentTreeNode right;
        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = Integer.MAX_VALUE;
        }
    }
	
	SegmentTreeNode root;
	
	public IntervalMiniNumber(int[] A) {
		root = build(A, 0, A.length - 1);
	}
	
    
    public ArrayList<Integer> intervalMinNumber(ArrayList<Interval> queries) {
        ArrayList<Integer> list = new ArrayList<>();
        for (Interval interval : queries) {
            list.add(query(root, interval.start, interval.end));
        }
        return list;
    }
    
    private SegmentTreeNode build(int[] A, int start, int end) {
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        if (start == end) {
            node.min = A[start];
        } else {
            int mid = (start + end) / 2;
            node.left = build(A, start, mid);
            node.right = build(A, mid + 1, end);
            node.min = Math.min(node.left.min, node.right.min);
        }
        return node;
    }
    
    public void update(int i, int val) {
    	update(root, i, val);
    }
    
    private void update(SegmentTreeNode node, int i, int val) {
    	if (node.start == node.end) {
    		node.min = val;
    	} else {
    		int mid = (node.start + node.end) / 2;
    		if (i <= mid) {
    			update(node.left, i, val);
    		} else update(node.right, i, val);
    		node.min = Math.min(node.left.min, node.right.min);
    	}
    }
    
    private int query(SegmentTreeNode root, int start, int end){
        if (start == root.start && end == root.end) {
            return root.min;
        }
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return query(root.left, start, end);
        } else if (start > mid) {
            return query(root.right, start, end);
        } else {
        	return Math.min(query(root.left, start, mid), query(root.right, mid + 1, end));
        }
    }
}
