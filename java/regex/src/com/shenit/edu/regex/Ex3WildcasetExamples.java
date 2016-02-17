package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 通配符示例.
 * @author 4536194@qq.com
 *
 */
public class Ex3WildcasetExamples {
	public static void main(String[] args) {
		String input = "all match\r\nall match";
		//正则里面.表示任意字符，这包括空格但不包括换行符换行符哦
		String result= RegExUtils.findAll(input,".");
		System.out.println("We found -> "+result);
		System.out.printf("Original length: %d, matched length: %d\n",input.length(),result.length());
		
	}
}
