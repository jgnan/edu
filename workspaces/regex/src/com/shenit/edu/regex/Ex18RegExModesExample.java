package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 正则表达式三种重复匹配模式示例
 * @author 4536194@qq.com
 *
 */
public class Ex18RegExModesExample {
	public static void main(String[] args) {
		System.out.println("\"I got an A in the class A.\" 匹配 .*A 的结果是 -> "+RegExUtils.findAll("I got an A in the class A.", "^.*A",","));
		System.out.println("\"I got an A in the class A.\\nBut Li Ming got B.\" 匹配 (?m)^.*B 的结果是 -> "+RegExUtils.findAll("I got an A in the class A.\nBut Li Ming got B.", "(?m)^.*B",","));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("\"I got an A in the class A.\" 匹配 ^.*?A 的结果是 -> "+RegExUtils.findAll("I got an A in the class A.", ".*?A",","));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("\"I got an A in the class A.\" 匹配 ^.*+A 的结果是 -> "+RegExUtils.findAll("I got an A in the class A.", ".*+A",","));
		
	}
}
