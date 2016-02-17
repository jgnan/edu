package com.shenit.edu.regex;


/**
 * 使用捕捉组替换示例
 * @author jiangnan
 *
 */
public class Ex12ReplacingExample {
	public static void main(String[] args) {
		System.out.println("使用(na)匹配banana并且替换成$1n? -> "+"banana".replaceAll("(na)","$1n"));
		//naming group
		System.out.println("使用(?<na>na)匹配banana并且替换成$1n? -> "+"banana".replaceAll("(?<na>na)","${na}n"));
	}
}
