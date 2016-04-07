package com.meng.coding;

import java.util.HashMap;
import java.util.Map;

public class IntToRoman {

	public static void main(String[] args) {
		int n = 3974;
		String s = intToRoman(n);
		System.out.println(n + " " + s + " " + romanToInt(s));

	}

	public static String intToRoman(int n) {
		String M[] = { "", "M", "MM", "MMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[n / 1000] + C[(n % 1000) / 100] + X[(n % 100) / 10] + I[n % 10];
	}

	public static int romanToInt(String s) {
		int ans = 0;
		int i = 0;
		while (i < s.length()) {
			int d = c2n(s.charAt(i));
			int d2 = i < s.length() - 1 ? c2n(s.charAt(i + 1)) : 0;
			if (d < d2) {
				ans += d2 - d;
				i += 2;
			} else {
				ans += d;
				i++;
			}
		}
		return ans;
	}

	private static int c2n(char ch) {
		switch (ch) {
			case 'M': return 1000;
			case 'C': return 100;
			case 'X': return 10;
			case 'I': return 1;
			case 'D': return 500;
			case 'L': return 50;
			case 'V': return 5;
		}
		return 0;
	}

}
