package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 非捕捉组示例
 * @author 4536194@qq.com
 *
 */
public class Ex14NonCapturingGroupExamples {
	public static void main(String[] args) {
		System.out.println("\"test1 test2 test3\"匹配(?:test)\\d的有 -> "+RegExUtils.findAll("test1 test2 test3","(?:test)\\d",","));
		System.out.println("\"test1 billy2 happy3\"匹配(?:test|billy|happy)\\d的有 -> "+RegExUtils.findAll("test1 billy2 happy3","(?:test|billy|happy)\\d",","));
	}
}
