package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 重复匹配规则示例1,演示{m,n}的使用方式
 * @author 4536194@qq.com
 *
 */
public class Ex8RepeatExample1 {
	public static void main(String[] args) {
		String rule = "[0-9]{3,9}";
		System.out.println("22 matched [0-9]{3,9}? -> "+RegExUtils.matched("22",rule));
		System.out.println("333 matched [0-9]{3,9}? -> "+RegExUtils.matched("333",rule));
		System.out.println("999999999 matched [0-9]{3,9}? -> "+RegExUtils.matched("999999999",rule));
		System.out.println("1234567890 matched [0-9]{3,9}? -> "+RegExUtils.matched("1234567890",rule));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		rule = "a{3}";
		System.out.println("aa matched a{3}? -> "+RegExUtils.matched("aa",rule));
		System.out.println("aaa matched a{3}? -> "+RegExUtils.matched("aaa",rule));
		System.out.println("aaaa matched a{3}? -> "+RegExUtils.matched("aaaa",rule));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		rule = "love{3,}";
		System.out.println("love matched love{3,}? -> "+RegExUtils.matched("love",rule));
		System.out.println("loveee matched love{3,}? -> "+RegExUtils.matched("loveee",rule));
		System.out.println("loveeeeeee matched love{3,}? -> "+RegExUtils.matched("loveeeeeee",rule));
	}
}
