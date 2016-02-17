package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 正向查找的示例
 * @author jiangnan
 *
 */
public class Ex15LookAheadExamples {
	public static void main(String[] args) {
		//正向检索
		System.out.println("abcXdefg中符合X(?=def)的内容为 -> "+RegExUtils.findAll("abcXdefg","X(?=def)",","));
		//这个应该找不到，结果为空
		System.out.println("abcXdegaaa中符合X(?=def)的内容为 -> "+RegExUtils.findAll("abcXdegaaa","X(?=def)",","));

		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//正向检索和一般的非捕捉组的最大区别是可以取反，因此下例是找不到X的
		System.out.println("abcXdefg中符合X(?!def)的内容为 -> "+RegExUtils.findAll("abcXdefg","X(?!def)",","));
		//这里会先找到X，然后看后三个字符是否符合def,由于不符合所以能找到X
		System.out.println("abcXdegaaa中符合X(?!def)的内容为 -> "+RegExUtils.findAll("abcXdegaaa","X(?!def)",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//另外正向查找里面可以使用其他表达式
		System.out.println("abcX@aaaab中符合X(?!\\w+)的内容为 -> "+RegExUtils.findAll("abcX@aaaab","X(?!\\w+)",","));
	}
}
