package com.shenit.edu.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式的HelloWorld
 * @author 4536194@qq.com
 *
 */
public class Ex1RegExHelloWorld {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("Hello World");
		Matcher matcher = pattern.matcher("I want to say \"Hello World\"");
		if(matcher.find()){
			System.out.println(matcher.group());
		}
	}

}
