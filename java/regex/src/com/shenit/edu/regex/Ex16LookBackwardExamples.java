package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 反向查找的示例
 * @author jiangnan
 *
 */
public class Ex16LookBackwardExamples {
	public static void main(String[] args) {
		//反向检索
		System.out.println("abcXdefXg中符合(?<=def)X的内容为 -> "+RegExUtils.findAll("abcXdefXg","(?<=def)",","));
		System.out.println("abcdegXaaa中符合(?<=def)X的内容为 -> "+RegExUtils.findAll("abcdegXaaa","(?<=def)",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//反向检索也可以取反,这里能找到2个X(aaX和abcX)
		System.out.println("aaXabcXdefg中符合(?<!def)X的内容为 -> "+RegExUtils.findAll("aaXabcXdefg","(?<!def)X",","));
		//这里能找不到任何X
		System.out.println("aaabcdefXg中符合(?<!def)X的内容为 -> "+RegExUtils.findAll("aaabcdefXg","(?<!def)X",","));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//反向查找由于性能原因，里面无法使用其他正则表达式.因此这段会抛出一个异常。
		System.out.println("aaabcdefXg中符合(?<\\w+)X的内容为 -> "+RegExUtils.findAll("aaabcdefXg","(?<\\w+)X",","));
	}
}
