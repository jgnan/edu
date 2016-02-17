package com.shenit.edu.regex;


/**
 * 把命令行的数据表结构输出替换为java 的pojo类属性练习
 * @author 4536194@qq.com
 *
 */
public class Ex21TableDumpToPojo {
	public static void main(String[] args) {
		String input = 
			"| id         | int(11)      | NO   | PRI | NULL    | auto_increment |\n"+
			"| code       | char(31)     | YES  | MUL | NULL    |                |\n"+
			"| mobile     | char(31)     | YES  | MUL | NULL    |                |\n"+
			"| client_ip  | char(31)     | YES  |     | NULL    |                |\n"+
			"| price      | decimal(7,2) | YES  |     | NULL    |                |\n"+
			"| store_name | varchar(255) | YES  | MUL | NULL    |                |\n"+
			"| account    | varchar(255) | YES  |     | NULL    |                |\n"+
			"| req_at     | datetime     | YES  |     | NULL    |                |\n"+
			"| redeem_at  | datetime     | YES  | MUL | NULL    |                |\n"+
			"| error      | varchar(255) | YES  |     | NULL    |                |\n"+
			"| status     | char(31)     | YES  | MUL | NULL    |                |\n"+
			"| created_at | datetime     | YES  |     | NULL    |                |\n"+
			"| updated_at | datetime     | YES  |     | NULL    |                |";
		System.out.println(input.replaceAll("(?m)^\\W*([\\w_]+)\\W*(\\w+)\\b.*$", "public $2 $1;"));
	}
}