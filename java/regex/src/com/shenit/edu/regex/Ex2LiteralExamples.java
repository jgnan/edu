package com.shenit.edu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 基础匹配规则示例.
 * @author 4536194@qq.com
 *
 */
public class Ex2LiteralExamples {
	public static void main(String[] args) {
		//编译出一个表达式实例
		Pattern pattern = Pattern.compile("cat");
		//尝试查找给定字符串里面是否有命中规则的部分，并且抽取成Matcher实例
		Matcher matcher = pattern.matcher("dog cat panda");
		//如果一个字符串里面有多次命中表达式
		if(matcher.find()) {
			//打印出matcher实例当前指向的匹配部分内容
			System.out.println("We find a -> "+matcher.group());
		}else{
			//查看当前pattern的表达式
			System.out.println("We could not find a "+pattern.pattern());
		}
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		//再来一次，这次是能找到多个命中部分，我们都列印出来
		matcher = pattern.matcher("dog cat panda cat tiger tomcat category");
		//轮询所有命中部分
		int i=0;
		while(matcher.find()) {
			System.out.println("We find a -> "+matcher.group() + ", times -> "+(++i));
		}
	}
}
