package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;

/**
 * 简单电话号码格式校验
 * @author 4536194@qq.com
 *
 */
public class Ex20MobileValidation {
	public static void main(String[] args) {
		String rule = "1[3458]\\d-?\\d{4}-?\\d{4}";
		System.out.println("189-5252-8842 合法 ? "+RegExUtils.matched("189-5252-8842",rule));
		System.out.println("18662314182 合法 ? "+RegExUtils.matched("18662314182",rule));
		
		System.out.println("\n--------我是华丽的分割线----------\n");
		
		System.out.println("12345667889 合法 ? "+RegExUtils.matched("12345667889",rule));
		System.out.println("41851928341 合法 ? "+RegExUtils.matched("41851928341",rule));
		System.out.println("testme 合法 ? "+RegExUtils.matched("testme",rule));
		System.out.println("1334566788944114 合法 ? "+RegExUtils.matched("1334566788944114",rule));
	}
}
