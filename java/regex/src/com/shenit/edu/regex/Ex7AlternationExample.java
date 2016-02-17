package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 轮换匹配规则示例.
 * @author 4536194@qq.com
 *
 */
public class Ex7AlternationExample {
	public static void main(String[] args) {
		String rule = "ab|bc|cd";
		System.out.println("abcdefghi matched ab|bc|cd? -> "+RegExUtils.findAll("abcdefghi",rule,","));
		System.out.println("acdfhgeifcas matched ab|bc|cd? -> "+RegExUtils.findAll("acdfhgeifcas",rule,","));
	}
}
