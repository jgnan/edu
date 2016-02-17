package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 字符类练习2，演示交集、并集和差集.
 * @author 4536194@qq.com
 *
 */
public class Ex5CharacterClassExamples2 {
	public static void main(String[] args) {
		String input = "tiny cats sleep in the bed in the crazy world";
		//并集，查找字母a,b,c,d,e,w,x,y.z
		//由于上面的表达式有多次命中，所以我们进行while轮询
		System.out.println("We found -> " + RegExUtils.findAll(input,"[a-e[w-z]]", ","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//交集,只查找c,d,e
		System.out.println("We found -> " + RegExUtils.findAll(input,"[a-e&&[c-z]]", ","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//差集,查找除c,d,e以外的所有小写字符
		System.out.println("We found -> " + RegExUtils.findAll(input,"[a-z&&[^c-e]]", ","));
		
	}
}
