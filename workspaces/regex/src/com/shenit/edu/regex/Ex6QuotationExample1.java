package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 转义字符示例1
 * 
 * @author 4536194@qq.com
 *
 */
public class Ex6QuotationExample1 {
	public static void main(String[] args) {
		String input = "abcABC123 \t\n!@#";
		System.out.println("\\d found -> "+RegExUtils.findAll(input,"\\d",","));
		System.out.println("\\w found -> "+RegExUtils.findAll(input,"\\w",","));
		System.out.println("\\s found -> "+RegExUtils.findAll(input,"\\s",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		System.out.println("\\D found -> "+RegExUtils.findAll(input,"\\D",","));
		System.out.println("\\W found -> "+RegExUtils.findAll(input,"\\W",","));
		System.out.println("\\S found -> "+RegExUtils.findAll(input,"\\S",","));
	}
}
