package com.meng.coding;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class SDTree {
	
	private static class Node {
		char ch;
		Node left;
		Node right;
		Node(char ch) {
			this.ch = ch;
		}
	}	

	public static void main(String[] args) {
		Node root = new Node('5');
		root.left = new Node('3');
		root.left.left = new Node('5');
		SDTree sd = new SDTree();
		String str = sd.serialize(root);
		System.out.println(str);
		Node root2 = sd.deserialze(str);
		System.out.println(root2.ch);
		System.out.println(root2.left.ch);
		System.out.println(root2.left.left.ch);

	}
	
	public String serialize(Node root) {
		List<Character> list = new ArrayList<>();
		helper(root, list);
		return list.toString();
	}
	
	private void helper(Node root, List<Character> list) {
		if (root == null) {
			list.add('#');
			return;
		}
		list.add(root.ch);
		helper(root.left, list);
		helper(root.right, list);
		
	}

	public Node deserialze(String s) {
		s = s.substring(1, s.length() - 1);
		LinkedList<Character> list = new LinkedList<>();
		for (String ss : s.split(",")) {
			list.add(ss.trim().charAt(0));			
		}
		return helper(list);
		
	}

	private Node helper(LinkedList<Character> list) {
		char ch = list.removeFirst();
		if (ch == '#') {
			return null;
		}
		Node node = new Node(ch);
		node.left = helper(list);
		node.right = helper(list);
		return node;
	}

}
