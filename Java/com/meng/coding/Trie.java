package com.meng.coding;

public class Trie {
	class TrieNode {
		TrieNode[] children;
		boolean isWord;
		TrieNode() {
			children = new TrieNode[26];
		}
	}
	
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	public void add(String word) {
		if (word == null) return;
		add(word, 0, root);
	}
	
	private void add(String word, int i, TrieNode node) {
		if (i == word.length()) {
			node.isWord = true;
			return;
		}
		char ch = word.charAt(i);
		if (node.children[ch - 'a'] == null) {
			node.children[ch - 'a'] = new TrieNode();
		}
		add(word, i + 1, node.children[ch - 'a']);
	}

	public boolean search(String word) {
		if (word == null) return true;
		return search(word, 0, root);
	}

	private boolean search(String word, int i, TrieNode node) {
		if (i == word.length()) return node.isWord;
		char ch = word.charAt(i);
		if (node.children[ch - 'a'] != null) {
			return search(word, i + 1, node.children[ch - 'a']);
		}
		return false;
	}
}
