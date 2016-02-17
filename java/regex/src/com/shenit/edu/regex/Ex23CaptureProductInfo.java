package com.shenit.edu.regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 抽取淘宝的商品信息练习
 * @author 4536194@qq.com
 *
 */
public class Ex23CaptureProductInfo {
	/*
	 * 用于封装商品数据信息
	 */
	private static class Product{
		String title;
		String thumbnail;
		java.math.BigDecimal parPrice;
		@Override
		public String toString() {
			return String.format("商品名称: %s\n缩略图地址: %s\n市场价: %s", title,thumbnail, parPrice);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		URL url = null;
		InputStream is = null;
		Pattern imagePattern = Pattern.compile("<img id=\"J_ImgBooth\".*src=\"([^\"]+)\"[^>]*>");
		Pattern titlePattern = Pattern.compile("\"title\":\"([^\"]+)\"");
		Pattern parPricePattern = Pattern.compile("\"reservePrice\":\"(\\d+\\.\\d{2})");
		try{
			url = new URL("https://detail.tmall.com/item.htm?id=18483792196&ali_refid=a3_430583_1006:1103392616:N:%E7%8B%97%E7%B2%AE:1ec237e7530eb345834c09c5fcdfe1c5&ali_trackid=1_1ec237e7530eb345834c09c5fcdfe1c5&spm=a230r.1.14.1.IVTBid");
			is = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is,"gbk"));
			String line;
			Product product = new Product();
			//开始解释每行HTML代码
			Matcher m;
			while((line = reader.readLine()) != null){
				//抽取缩略图地址
				m = imagePattern.matcher(line);
				if(m.find()) product.thumbnail = m.group(1);
				
				//抽取商品标题
				m = titlePattern.matcher(line);
				if(m.find()) product.title = m.group(1);
				
				//抽取商品市场价
				m = parPricePattern.matcher(line);
				if(m.find()) product.parPrice = new java.math.BigDecimal(m.group(1));
			}
			
			System.out.println("抽取的商品信息: \n"+product);
		}finally{
			if(is != null) is.close();
		}
	}
}