package com.meng.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieSearcher {
	
	class TrieNode {
		TrieNode[] next = new TrieNode[27];
		int index = -1;
	}

	public static void main(String[] args) {
		TrieSearcher searcher = new TrieSearcher();
		for (String rs : searcher.search("")){
			System.out.println(rs);
		}

	}
	
	private TrieNode root;
	private List<String> dict = new ArrayList<>(Arrays.asList("do it y","dog gooming", "dog walking", "house cleaner"));
	
	
	public TrieSearcher() {
		root = new TrieNode();
		for (int i = 0; i < dict.size(); i++) {
			add(i, 0, root);
		}
	}
	
	private void add(int idx, int pos, TrieNode root) {
		if (pos == dict.get(idx).length()) {
			root.index = idx;
			return;
		}
		int i = getIdx(dict.get(idx).charAt(pos));
		if (root.next[i] == null) {
			root.next[i] = new TrieNode();
		} 
		add(idx, pos + 1, root.next[i]);
	}
	
	public List<String> search(String s) {
		List<String> ret = new ArrayList<>();
		search(s, 0, root, ret);
		return ret;
	}

	private void search(String s, int pos, TrieNode root, List<String> ret) {
		
		if (pos >= s.length()) {
			if (pos >= s.length() && root.index >= 0) {
				ret.add(dict.get(root.index));
			}
			for (int i = 0; i < 27; i++) {
				if (root.next[i] != null) {
					search(s, pos, root.next[i], ret);
				}
				
			}
			
		} else {
			int i = getIdx(s.charAt(pos));
			if (i < s.length() && root.next[i] == null) {
				ret = new ArrayList<String>();
				return;
			}
			search(s, pos + 1, root.next[i], ret);
		}
	}
	
	private int getIdx(char ch) {
		return ch == ' ' ?  26 : ch - 'a';
	}
	
	
	

}
