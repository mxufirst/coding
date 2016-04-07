package com.meng.coding;

public class RegularExpressMatch {

	public static void main(String[] args) {
		System.out.println(isMatch("aaba", "ab*a*c*a"));
	}

	public static boolean isMatch(String s, String p) {
		int n = p.length();
		boolean[] match = new boolean[n + 1];
		match[0] = true;
		for (int j = 2; j <= n; j++) {
			match[j] = (p.charAt(j - 1) == '*') ? match[j - 2] : false;
		}
		for (int i = 1; i <= s.length(); i++) {
			boolean[] cur = new boolean[n + 1];
			for (int j = 1; j <= n; j++) {
				char ss = s.charAt(i - 1), pp = p.charAt(j - 1);
				if (ss == pp || pp == '.') {
					cur[j] = match[j - 1];
				}
				else if (pp == '*') {
				    cur[j] = cur[j - 2];
					if (ss == p.charAt(j - 2) ||  p.charAt(j - 2) == '.') {
						cur[j] = match[j] || cur[j];
					}
				} 
			}
			match = cur;
		}
		return match[n];
	}
	
	
	public boolean isM(String s, String p) {
		if (p.length() == 0) return p.length() == 0;
		if (s.length() == 0) {
			if (p.length() > 1) return isM(s, p.substring(2));
		}
		char s0 = s.charAt(0);
		char p0 = p.charAt(0);
		if (s0 == p0 || p0 == '.') return isM(s.substring(1), p.substring(1));
		if (p.length() > 1 && p.charAt(1) == '*') {
			if (isM(s, p.substring(2))) return true;
			if (s0 == p0 || p0 == '.') {
				return isM(s.substring(1), p);
			}
		}
		return false;
	}

}
