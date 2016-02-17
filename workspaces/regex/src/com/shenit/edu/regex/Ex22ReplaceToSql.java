package com.shenit.edu.regex;


/**
 * 把CSV格式内容替换为INSERT语句
 * @author 4536194@qq.com
 *
 */
public class Ex22ReplaceToSql {
	public static void main(String[] args) {
		String input = 
				"1,user1,1999-01-02,18421314515,test address1\n" + 
				"2,user2,1999-01-03,18421314525,\"test ,address2\"\n" + 
				"3,user3,1999-01-04,18421314535,test address3\n" + 
				"4,user4,1999-01-05,18421314545,test address4\n" + 
				"5,user5,1999-01-06,18421314555,test address5\n" + 
				"6,user6,1999-01-07,18421314565,test address6\n";
		System.out.println(input.replaceAll("(?m)^\"?(\\d+)\"?,\"?(\\w+)\"?,\"?([^,]+)\"?,\"?(\\w+)\"?,\"?(.*)\\b\"?$", "insert into users(id,name,birth,mobile,address) values($1,’$2’,’$3’,’$4’,’$5’);"));
	}
}