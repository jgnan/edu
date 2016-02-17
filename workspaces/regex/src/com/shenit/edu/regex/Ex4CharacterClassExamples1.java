package com.shenit.edu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 字符类示例1，演示基本用法
 * @author 4536194@qq.com
 *
 */
public class Ex4CharacterClassExamples1 {
	public static void main(String[] args) {
		//查找所有元音字母
		Pattern pattern = Pattern.compile("[aeiou]");
		Matcher matcher = pattern.matcher("Hello world");
		try{
			//查看命中了什么
			System.out.println("hits -> "+matcher.group());
		}catch(Exception ex){
			/* 因为没有在调用matcher.group()之前调用matcher.find()，所以matcher没有对表达式进行引用，
			 * 导致抛出IllegalStateException异常
			 */
			System.out.println("We got a problem here! "+ex.getMessage());
		}
		
		//由于上面的表达式有多次命中，所以我们进行while轮询
		System.out.print("We found -> ");
		while(matcher.find()){
			System.out.print(matcher.group());
		}
		System.out.println();
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//这次我们来尝试找所有数字
		System.out.println("We found -> " + RegExUtils.findAll("All over the world","[a-z]"));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//当选择字符集第一个字符是^，表示字符不能匹配整个选择字符集的任何一个字符，例如下例指任何非数字
		System.out.print("We found -> " + RegExUtils.findAll("1900年代的杰出球员ONeal","[^a-zA-Z0-9]"));
		
	}
}
