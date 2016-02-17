package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 定位符示例
 * @author jiangnan
 *
 */
public class Ex10AnchorExamples {
	public static void main(String[] args) {
		System.out.println("aaabbbaaabbbaaabbbaaaccc found using [aaa.*aaa] -> "+RegExUtils.findAll("aaabbbaaabbbaaabbbaaaccc", "aaa.*aaa",","));
		System.out.println("aaabbbaaabbbaaabbbaaaccc found using [^aaa.*aaa$] -> "+RegExUtils.findAll("aaabbbaaabbbaaabbbaaaccc", "^aaa.*aaa$",","));
		System.out.println("aaabbbaaa\naaabbbaaa found using [^aaa.*aaa$] -> "+RegExUtils.findAll("aaabbbaaa\naaabbbaaa", "^aaa.*aaa$",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		System.out.println("http://www.imooc.com/http found using [^http.*] -> "+RegExUtils.findAll("http://www.imooc.com/http", "^http.*",","));
		System.out.println("ftp://www.imooc.com/http found using [^http.*] -> "+RegExUtils.findAll("ftp://www.imooc.com/http", "^http.*",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		System.out.println("cat matched .*t$ ? -> "+RegExUtils.matched("cat", ".*t$"));
		System.out.println("category matched .*t$ ? -> "+RegExUtils.matched("category", ".*t$"));
	}
}
