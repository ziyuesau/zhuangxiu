package com.hourse.common.utils;

import java.util.StringTokenizer;

import com.qiniu.util.StringUtils;

public class Converters {
	/**
	 * String str = "1,2,3,4,5,6" 
	 * @param str
	 * @return
	 */
	 public static Integer[] StringtoInt(String str) {  
		  if(str==null) return null;
		  String[] strs=str.split(",");
		  int length=strs.length;
		 Integer ret[] = new Integer[length];   
		  
		    for (int i = 0; i < length; i++) {
				ret[i]=Integer.parseInt(strs[i]);
			}
		   return ret;  
		  
		 }
	 
	 public static void main(String[] args) {
		String  str="2,2";
		Integer[] data=	Converters.StringtoInt(str);
		for (Integer integer : data) {
			System.out.println(integer);
		}
	}
}
