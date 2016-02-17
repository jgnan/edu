package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 重复匹配规则示例2,演示*, +, ?的用法和区别
 * @author 4536194@qq.com
 *
 */
public class Ex9RepeatExample2 {
	public static void main(String[] args) {
		String rule = "h[0-9]+";
		System.out.println("h matched [0-9]+ ? -> "+RegExUtils.matched("h",rule));
		System.out.println("h2 matched [0-9]+ ? -> "+RegExUtils.matched("h2",rule));
		System.out.println("h333 matched [0-9]+ ? -> "+RegExUtils.matched("h333",rule));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		rule = "h[0-9]*";
		System.out.println("h matched [0-9]*  ? -> "+RegExUtils.matched("h",rule));
		System.out.println("h2 matched [0-9]*  ? -> "+RegExUtils.matched("h2",rule));
		System.out.println("h333 matched [0-9]*  ? -> "+RegExUtils.matched("h333",rule));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		rule = "h[0-9]?";
		System.out.println("h matched [0-9]?  ? -> "+RegExUtils.matched("h",rule));
		System.out.println("h2 matched [0-9]?  ? -> "+RegExUtils.matched("h2",rule));
		System.out.println("h333 matched [0-9]?  ? -> "+RegExUtils.matched("h333",rule));
	}
}
