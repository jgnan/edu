package com.shenit.edu.regex;

import com.shenit.edu.regex.utils.RegExUtils;


/**
 * 捕捉组示例
 * @author jiangnan
 *
 */
public class Ex11CapturingGroup {
	public static void main(String[] args) {
		System.out.println("aaABCcc in (ABC)? -> "+RegExUtils.groups("aaABCcc","(ABC)",",",1));
		System.out.println("http://www.imooc.com/https in (?<protocal>https?) ? -> "+RegExUtils.groups("http://www.imooc.com/https","(?<protocal>https?)",",","protocal"));
		System.out.println("https://www.imooc.com/http in (?<protocal>^https?)? -> "+RegExUtils.groups("https://www.imooc.com/http","(?<protocal>https?)",",","protocal"));
		
		System.out.println("\n------- 华丽的分割线 ------\n");
		
		//nested capturing group
		System.out.println("DABCE匹配D((A)(B(C)))E的捕捉组? -> "+RegExUtils.groups("DABCE","D((A)(B(C)))E",",",1,2,3,4,0));
	}
}
