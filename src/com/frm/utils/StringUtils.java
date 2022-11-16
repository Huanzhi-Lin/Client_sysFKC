package com.frm.utils;

public class StringUtils {
	
	/**
	 * surround with 'str'
	 * @param str
	 * @return
	 */
	public static String roundWithQuotes(String str) {
		return new String("'" + str + "'");
	}

	public static String generateTokenByV(int v) {
		String str = "";
		while(v-- >=0) {
			str += ".";
		}
		return str;
	}

	/**
	 * @param src 字符串
	 * @param objs 参考书列表
	 * @return
	 * @description 这个默认替换src中的 "@"
	 */
	public static String replaceToken(String src, Object ...objs) {
		StringBuffer sb = new StringBuffer(src);
		if(objs != null) {			
			for(int i=0; i<objs.length; i++) {
				Object o = objs[i];
				int idx = findPitIdx(sb.toString());
				sb.replace(idx, idx+1, o.toString());
			}
		}
		return sb.toString();
	}
	public static String token = "@";
	private static int findPitIdx(String str) {
		return str.indexOf(token);
	}

}
