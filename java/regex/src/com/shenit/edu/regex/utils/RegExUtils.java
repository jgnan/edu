package com.shenit.edu.regex.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类.
 * 此工具类的目的是为了辅助教学，可供大家自由使用。
 * 但是在生产项目请慎用，因为没有进行过严谨的测试，出了问题的话这个锅我不背啊.
 * @author 4536194@qq.com
 *
 */
public final class RegExUtils {
	private static final String EMPTY = "";
	/**
	 * 根据表达式以及输入语句生成Matcher
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @param flags 正则表达式旗帜
	 * @return
	 */
	public static Matcher matcher(String input, String regex, int flags){
		if(regex == null || input == null) return null;
		return Pattern.compile(regex,flags).matcher(input);
	}
	
	/**
	 * 根据表达式以及输入语句生成Matcher
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @return
	 */
	public static Matcher matcher(String input, String regex){
		return matcher(input, regex, 0);
	}
	
	/**
	 * 判断指定的输入里面是否有满足正则表达式的片段内容
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @return
	 */
	public static boolean found (String input, String regex, int flags){
		Matcher matcher = matcher(input, regex);
		return matcher == null ? false : matcher.find();
	}
	
	/**
	 * 判断指定的输入里面是否有满足正则表达式的片段内容
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @return
	 */
	public static boolean found (String input, String regex){
		return found(input, regex, 0);
	}
	
	/**
	 * 判断指定的输入里面是否完全满足整个正则表达式的要求
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @return
	 */
	public static boolean matched (String input, String regex, int flags){
		Matcher matcher = matcher(input, regex, flags);
		return matcher == null ? false : matcher.matches();
	}
	
	/**
	 * 判断指定的输入里面是否完全满足整个正则表达式的要求
	 * @param input 输入文本
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @return
	 */
	public static boolean matched (String input, String regex){
		return matched(input, regex,0);
	}
	
	/**
	 * 获取所有命中表达式的字符串片段
	 * @param matcher Matcher实例
	 * @return 如果找到任何结果，并且拼装成一个字符串.
	 */
	public static String findAll(Matcher matcher){
		return findAll(matcher,null);
	}
	
	/**
	 * 获取所有命中表达式的字符串片段
	 * @param matcher Matcher实例
	 * @param seperator 分隔符，用于风格搜索结果
	 * @return 如果找到任何结果，以seperator为分割拼装成一个字符串.
	 */
	public static String findAll(Matcher matcher, String seperator){
		if(matcher == null) return null;	//nothing matched
		if(seperator == null) seperator = EMPTY;	//empty string
		StringBuilder builder = new StringBuilder();
		while(matcher.find()) builder.append(matcher.group()).append(seperator);	//拼装找到的字符串集合
		builder = removeTail(builder,seperator);
		return builder.toString();
	}
	
	/**
	 * 获取所有命中表达式的字符串片段
	 * @param input 输入字符串
	 * @param regex 正则表达式
	 * @return 如果找到任何结果，返回拼接好的字符串集合
	 */
	public static String findAll(String input, String regex) {
		return findAll(input,regex,0,null);
	}
	
	/**
	 * 获取所有命中表达式的字符串片段
	 * @param input 输入字符串
	 * @param regex 正则表达式
	 * @param seperator 分隔符，用于拼接字符集片段
	 * @return 如果找到任何结果，返回拼接好的字符串集合
	 */
	public static String findAll(String input, String regex,String seperator) {
		return findAll(input,regex, 0, seperator);
	}

	/**
	 * 获取所有命中表达式的字符串片段
	 * @param input 输入字符串
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @param seperator 分隔符，用于拼接字符集片段
	 * @return 如果找到任何结果，返回拼接好的字符串集合
	 */
	public static String findAll(String input, String regex,int flags, String seperator) {
		Matcher matcher = matcher(input, regex,flags);
		return matcher == null ? null : findAll(matcher, seperator);
	}

	/**
	 * 尝试把输入内容匹配正则表达式并且获取第index个组别内容
	 * @param input 输入内容
	 * @param regex 正则表达式
	 * @param index 索引
	 * @return
	 */
	public static String groups(String input, String regex, String seperator,int... indexex) {
		return groups(input, regex, 0,seperator,indexex);
	}
	
	/**
	 * 尝试把输入内容匹配正则表达式并且获取第index个组别内容
	 * @param input 输入内容
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @param index 索引
	 * @return
	 */
	public static String groups(String input, String regex, int flags,String seperator,int... indexes) {
		Matcher matcher = matcher(input,regex,flags);
		if(matcher == null) return null;
		if(seperator == null) seperator = EMPTY;
		StringBuilder builder = new StringBuilder();
		while(matcher.find()){
			for(int index : indexes){
				builder.append(matcher.group(index)).append(seperator);
			}
		}
		builder = removeTail(builder, seperator);
		return builder.toString();
	}
	
	/**
	 * 尝试把输入内容匹配正则表达式并且获取第index个组别内容
	 * @param input 输入内容
	 * @param regex 正则表达式
	 * @param index 索引
	 * @return
	 */
	public static String groups(String input, String regex, String seperator,String... groupNames) {
		return groups(input, regex, 0,seperator,groupNames);
	}
	
	/**
	 * 尝试把输入内容匹配正则表达式并且获取第index个组别内容
	 * @param input 输入内容
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @param index 索引
	 * @return
	 */
	public static String groups(String input, String regex, int flags,String seperator,String... groupNames) {
		if(groupNames.length == 0) return null;
		Matcher matcher = matcher(input,regex,flags);
		if(matcher == null) return null;
		if(seperator == null) seperator = EMPTY;
		StringBuilder builder = new StringBuilder();
		while(matcher.find()){
			for(String groupName: groupNames){
				builder.append(matcher.group(groupName)).append(seperator);
			}
		}
		builder = removeTail(builder, seperator);
		return builder.toString();
	}
	
	/**
	 * 获取第一个匹配内容的捕捉组数量
	 * @param input 输入字符串
	 * @param regex 正则表达式
	 * @return
	 */
	public static int groupCount(String input, String regex) {
		return groupCount(input,regex,0);
	}
	/**
	 * 获取第一个匹配内容的捕捉组数量
	 * @param input 输入字符串
	 * @param regex 正则表达式
	 * @param flags 正则旗帜
	 * @return
	 */
	public static int groupCount(String input, String regex,int flags) {
		Matcher matcher = matcher(input,regex,flags);
		if(matcher == null) return 0;
		return matcher.find() ? matcher.groupCount() : 0;
	}
	
	/*
	 * 删除StringBuilder的尾部
	 */
	private static StringBuilder removeTail(StringBuilder builder,String seperator){
		if(builder == null) return null;
		if(builder.length() > 0 && seperator.length() > 0) builder = builder.deleteCharAt(builder.length() - seperator.length());
		return builder;
	}
}
