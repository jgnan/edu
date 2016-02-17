package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 捕捉组示例
 * @author jiangnan
 *
 */
public class Ex13BackReference {
	public static void main(String[] args) {
		System.out.println("<a href=\"http://www.imooc.com\">imooc</a>匹配<([a-zA-Z]\\w*)\\b[^>]*>[^<]+</\\1> ? -> "+
				RegExUtils.matched("<a href=\"http://www.imooc.com\">imooc</a>","<([a-zA-Z]\\w*)\\b[^>]*>[^<]+</\\1>"));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		System.out.println("<h11>江老师教编程</h1>匹配<([a-zA-Z]\\w*)[^>]*>[^<]+</\\1> ? -> "+
				RegExUtils.matched("<h11>江老师教编程</h1>","<([a-zA-Z]\\w*)[^>]*>[^<]+</\\1>"));
		System.out.println("<h11>江老师教编程</h1>匹配<([a-zA-Z]\\w*)\\b[^>]*>[^<]+</\\1> ? -> "+
				RegExUtils.matched("<h11>江老师教编程</h1>","<([a-zA-Z]\\w*)\\b[^>]*>[^<]+</\\1>"));
	}
}
