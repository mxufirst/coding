package com.meng.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class TemplateMatchReplace
{
	private static final Pattern NAMES_PATTERN = Pattern.compile("\\{([^/]+?)\\}");
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	Map<String, String> map = new HashMap<>();
	
	public String replace(String source) {
		if (source == null) {
			return null;
		}
		if (source.indexOf('{') == -1) {
			return source;
		}
		Matcher matcher = NAMES_PATTERN.matcher(source);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String match = matcher.group(1);
			String replacement = map.get(match);
			matcher.appendReplacement(sb, replacement);
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	

}
