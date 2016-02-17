package com.shenit.edu.regex;

import java.util.regex.Pattern;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 常用旗帜示例
 * @author 4536194@qq.com
 *
 */
public class Ex17FlagExamples {
	public static void main(String[] args) {
		System.out.println("\"abcABC\" 是否匹配 (?i)(?:abc)+ ? -> "+RegExUtils.matched("abcABC", "(?i)(?:abc)+"));
		System.out.println("\"abcABC\" 是否匹配 (?-i)(?:abc)+ ? -> "+RegExUtils.matched("abcABC", "(?-i)(?:abc)+"));
		System.out.println("\"abcABC\" 是否在Pattern.CASE_INSENSITIVE模式下匹配 (?:abc)+ ? -> "+RegExUtils.matched("abcABC", "(?:abc)+",Pattern.CASE_INSENSITIVE));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("\"abc\\nABC\" 哪些会匹配 (?-d).+ ? -> "+RegExUtils.findAll("abc\r\nABC", "(?-d).+"));
		System.out.println("\"abc\\nABC\" 哪些会匹配 (?d).+ ? -> "+RegExUtils.findAll("abc\r\nABC", "(?d).+"));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("\"test #comment\" 哪些会匹配 [(?-x)test #comment] ? -> "+RegExUtils.findAll("test #comment", "(?-x)test #comment",","));
		System.out.println("\"test #comment\" 哪些会匹配 [(?x)test #comment] ? -> "+RegExUtils.findAll("test #comment", "(?x)test #comment",","));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("\"1st line\\n2nd line\" 哪些会匹配 [(?-m)^.+line$] ? -> "+RegExUtils.findAll("1st line\n2nd line", "(?-m)^.+line$",","));
		System.out.println("\"1st line\\n2nd line\" 哪些会匹配 [(?m)^.+line$] ? -> "+RegExUtils.findAll("1st line\n2nd line", "(?m)^.+line$",","));
	}
}
