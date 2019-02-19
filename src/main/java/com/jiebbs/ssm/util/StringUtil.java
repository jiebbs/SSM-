package com.jiebbs.ssm.util;

/**
 * 字符工具类
 * @author weijie
 * @version
 */
public class StringUtil {

	/**
	 * 检查字符是否为 null 或者为 空。
	 * @param str
	 * @return
	 */
	public static boolean checkStr(String str) {
		if(str==null||str.trim().equals("")) {
			return false;
		}else {
			return true;
		}
	}
}
