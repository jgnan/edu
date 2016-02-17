package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 简单邮件格式校验
 * @author 4536194@qq.com
 *
 */
public class Ex19EmailValidation {
	public static void main(String[] args) {
		String rule = "\\w[\\w_\\-.]*@[\\w\\-]+(?:\\.[a-zA-Z]{2,3})+";
		System.out.println("4536194@qq.com 合法 ? "+RegExUtils.matched("4536194@qq.com",rule));
		System.out.println("test.123@naver.co.kr 合法 ? "+RegExUtils.matched("test.123@naver.co.kr",rule));
		System.out.println("hello_regex@yy.cn 合法 ? "+RegExUtils.matched("hello_regex@yy.cn",rule));
		System.out.println("4536194@oh-my-god.com 合法 ? "+RegExUtils.matched("4536194@oh-my-god.com",rule));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("hello world 合法 ? "+RegExUtils.matched("hello world",rule));
		System.out.println("@江老师 合法 ? "+RegExUtils.matched("@江老师",rule));
	}
}
