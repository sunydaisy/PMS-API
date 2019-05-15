package com.ocreatech.pms.utils;

import java.util.List;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

/**
 * 路基匹配工具
 * @author yanyaqin
 *
 */
public class PathMatchUtil {
	
	private PathMatchUtil() {
	    throw new IllegalStateException("Utility class");
	}

	public static boolean matchStart(List<String> patterns, String url) {
		PathMatcher matcher = new AntPathMatcher();
		for(String pattern : patterns) {
			if(matcher.matchStart(pattern, url)) {
				return true;
			}
		}
		return false;
	}

}
